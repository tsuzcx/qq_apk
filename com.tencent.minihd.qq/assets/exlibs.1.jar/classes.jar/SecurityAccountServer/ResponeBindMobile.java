package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponeBindMobile
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public String alreadyBindedUin = "";
  public byte[] sessionSid = null;
  
  public ResponeBindMobile() {}
  
  public ResponeBindMobile(byte[] paramArrayOfByte, String paramString)
  {
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindedUin = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 0, true));
    this.alreadyBindedUin = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sessionSid, 0);
    if (this.alreadyBindedUin != null) {
      paramJceOutputStream.write(this.alreadyBindedUin, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponeBindMobile
 * JD-Core Version:    0.7.0.1
 */