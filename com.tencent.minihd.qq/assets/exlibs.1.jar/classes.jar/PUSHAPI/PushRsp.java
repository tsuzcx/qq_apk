package PUSHAPI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushRsp
  extends JceStruct
{
  static byte[] cache_UID;
  public String Mark = "";
  public byte[] UID = null;
  public byte is_bgd = 0;
  public long ptime = 0L;
  public String sUID = "";
  
  public PushRsp() {}
  
  public PushRsp(byte[] paramArrayOfByte, long paramLong, String paramString1, byte paramByte, String paramString2)
  {
    this.UID = paramArrayOfByte;
    this.ptime = paramLong;
    this.Mark = paramString1;
    this.is_bgd = paramByte;
    this.sUID = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_UID == null)
    {
      cache_UID = (byte[])new byte[1];
      ((byte[])cache_UID)[0] = 0;
    }
    this.UID = ((byte[])paramJceInputStream.read(cache_UID, 0, false));
    this.ptime = paramJceInputStream.read(this.ptime, 1, false);
    this.Mark = paramJceInputStream.readString(3, false);
    this.is_bgd = paramJceInputStream.read(this.is_bgd, 4, false);
    this.sUID = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.UID != null) {
      paramJceOutputStream.write(this.UID, 0);
    }
    paramJceOutputStream.write(this.ptime, 1);
    if (this.Mark != null) {
      paramJceOutputStream.write(this.Mark, 3);
    }
    paramJceOutputStream.write(this.is_bgd, 4);
    if (this.sUID != null) {
      paramJceOutputStream.write(this.sUID, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     PUSHAPI.PushRsp
 * JD-Core Version:    0.7.0.1
 */