package flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    private char charname; // 문자의 이름 '0', '1', '2' ...
    private String fontdata; //

    // 생성자
    public BigChar(char charname){
        this.charname = charname;
        try{
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e){
            this.fontdata = charname + "?";
        }
    }
    // 큰 문자를 표시한다
    public void print(){
        System.out.print(fontdata);
    }
}
