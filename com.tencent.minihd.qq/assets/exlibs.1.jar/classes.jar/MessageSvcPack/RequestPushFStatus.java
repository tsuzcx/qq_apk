package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestPushFStatus
  extends JceStruct
{
  public byte cStatus = 0;
  public long lUin = 0L;
  public int uClientType = 99;
  
  public RequestPushFStatus() {}
  
  public RequestPushFStatus(long paramLong, byte paramByte, int paramInt)
  {
    this.lUin = paramLong;
    this.cStatus = paramByte;
    this.uClientType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.uClientType = paramJceInputStream.read(this.uClientType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.uClientType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.RequestPushFStatus
 * JD-Core Version:    0.7.0.1
 */