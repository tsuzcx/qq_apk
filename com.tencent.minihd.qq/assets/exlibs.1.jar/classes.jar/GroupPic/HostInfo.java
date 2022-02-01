package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HostInfo
  extends JceStruct
{
  public short shPort = 0;
  public int uIP = 0;
  
  public HostInfo() {}
  
  public HostInfo(int paramInt, short paramShort)
  {
    this.uIP = paramInt;
    this.shPort = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uIP = paramJceInputStream.read(this.uIP, 0, true);
    this.shPort = paramJceInputStream.read(this.shPort, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uIP, 0);
    paramJceOutputStream.write(this.shPort, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GroupPic.HostInfo
 * JD-Core Version:    0.7.0.1
 */