package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class birth_info
  extends JceStruct
{
  public int birthDay = 0;
  public int birthDayLunar = 0;
  public int birthMon = 0;
  public int birthMonLunar = 0;
  
  public birth_info() {}
  
  public birth_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.birthMon = paramInt1;
    this.birthDay = paramInt2;
    this.birthMonLunar = paramInt3;
    this.birthDayLunar = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.birthMon = paramJceInputStream.read(this.birthMon, 0, false);
    this.birthDay = paramJceInputStream.read(this.birthDay, 1, false);
    this.birthMonLunar = paramJceInputStream.read(this.birthMonLunar, 3, false);
    this.birthDayLunar = paramJceInputStream.read(this.birthDayLunar, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.birthMon, 0);
    paramJceOutputStream.write(this.birthDay, 1);
    paramJceOutputStream.write(this.birthMonLunar, 3);
    paramJceOutputStream.write(this.birthDayLunar, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.birth_info
 * JD-Core Version:    0.7.0.1
 */