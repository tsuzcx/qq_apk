package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_gps
  extends JceStruct
{
  public int altitude = 0;
  public int latitude = 0;
  public int longitude = 0;
  
  public s_gps() {}
  
  public s_gps(int paramInt1, int paramInt2, int paramInt3)
  {
    this.latitude = paramInt1;
    this.longitude = paramInt2;
    this.altitude = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.latitude = paramJceInputStream.read(this.latitude, 0, false);
    this.longitude = paramJceInputStream.read(this.longitude, 1, false);
    this.altitude = paramJceInputStream.read(this.altitude, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.latitude, 0);
    paramJceOutputStream.write(this.longitude, 1);
    paramJceOutputStream.write(this.altitude, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_gps
 * JD-Core Version:    0.7.0.1
 */