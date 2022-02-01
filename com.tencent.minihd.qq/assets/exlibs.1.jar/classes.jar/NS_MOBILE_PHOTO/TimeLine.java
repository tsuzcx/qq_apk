package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeLine
  extends JceStruct
  implements Cloneable
{
  public long begin_time = 0L;
  public long end_time = 0L;
  public int show_day = 0;
  public int show_month = 0;
  public int show_time = 0;
  public int show_week = 0;
  public int show_year = 0;
  public int total = 0;
  
  public TimeLine() {}
  
  public TimeLine(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.begin_time = paramLong1;
    this.end_time = paramLong2;
    this.total = paramInt1;
    this.show_time = paramInt2;
    this.show_year = paramInt3;
    this.show_month = paramInt4;
    this.show_week = paramInt5;
    this.show_day = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.begin_time = paramJceInputStream.read(this.begin_time, 0, true);
    this.end_time = paramJceInputStream.read(this.end_time, 1, true);
    this.total = paramJceInputStream.read(this.total, 2, true);
    this.show_time = paramJceInputStream.read(this.show_time, 3, true);
    this.show_year = paramJceInputStream.read(this.show_year, 4, true);
    this.show_month = paramJceInputStream.read(this.show_month, 5, true);
    this.show_week = paramJceInputStream.read(this.show_week, 6, false);
    this.show_day = paramJceInputStream.read(this.show_day, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.begin_time, 0);
    paramJceOutputStream.write(this.end_time, 1);
    paramJceOutputStream.write(this.total, 2);
    paramJceOutputStream.write(this.show_time, 3);
    paramJceOutputStream.write(this.show_year, 4);
    paramJceOutputStream.write(this.show_month, 5);
    paramJceOutputStream.write(this.show_week, 6);
    paramJceOutputStream.write(this.show_day, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.TimeLine
 * JD-Core Version:    0.7.0.1
 */