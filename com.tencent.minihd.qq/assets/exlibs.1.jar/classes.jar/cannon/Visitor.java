package cannon;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Visitor
  extends JceStruct
{
  public String lastmood = "";
  public String name = "";
  public String portrait = "";
  public int sqqlevel = 0;
  public long uin = 0L;
  public int viplevle = 0;
  public int visittime = 0;
  public int weight = 0;
  
  public Visitor() {}
  
  public Visitor(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    this.uin = paramLong;
    this.name = paramString1;
    this.visittime = paramInt1;
    this.portrait = paramString2;
    this.lastmood = paramString3;
    this.viplevle = paramInt2;
    this.sqqlevel = paramInt3;
    this.weight = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.visittime = paramJceInputStream.read(this.visittime, 3, false);
    this.portrait = paramJceInputStream.readString(4, false);
    this.lastmood = paramJceInputStream.readString(5, false);
    this.viplevle = paramJceInputStream.read(this.viplevle, 6, false);
    this.sqqlevel = paramJceInputStream.read(this.sqqlevel, 7, false);
    this.weight = paramJceInputStream.read(this.weight, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.visittime, 3);
    if (this.portrait != null) {
      paramJceOutputStream.write(this.portrait, 4);
    }
    if (this.lastmood != null) {
      paramJceOutputStream.write(this.lastmood, 5);
    }
    paramJceOutputStream.write(this.viplevle, 6);
    paramJceOutputStream.write(this.sqqlevel, 7);
    paramJceOutputStream.write(this.weight, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cannon.Visitor
 * JD-Core Version:    0.7.0.1
 */