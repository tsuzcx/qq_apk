package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IpInfo
  extends JceStruct
{
  public int ip = 0;
  public short port = 0;
  
  public IpInfo() {}
  
  public IpInfo(int paramInt, short paramShort)
  {
    this.ip = paramInt;
    this.port = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ip = paramJceInputStream.read(this.ip, 0, false);
    this.port = paramJceInputStream.read(this.port, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ip, 0);
    paramJceOutputStream.write(this.port, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     FileUpload.IpInfo
 * JD-Core Version:    0.7.0.1
 */