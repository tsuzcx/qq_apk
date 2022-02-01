package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SyncReqCookie
  extends JceStruct
{
  static byte[] cache_vCookie;
  static ArrayList cache_vServiceId;
  public byte[] vCookie = null;
  public ArrayList vServiceId = null;
  
  public SyncReqCookie() {}
  
  public SyncReqCookie(ArrayList paramArrayList, byte[] paramArrayOfByte)
  {
    this.vServiceId = paramArrayList;
    this.vCookie = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vServiceId == null)
    {
      cache_vServiceId = new ArrayList();
      cache_vServiceId.add(Long.valueOf(0L));
    }
    this.vServiceId = ((ArrayList)paramJceInputStream.read(cache_vServiceId, 0, true));
    if (cache_vCookie == null)
    {
      cache_vCookie = (byte[])new byte[1];
      ((byte[])cache_vCookie)[0] = 0;
    }
    this.vCookie = ((byte[])paramJceInputStream.read(cache_vCookie, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vServiceId, 0);
    if (this.vCookie != null) {
      paramJceOutputStream.write(this.vCookie, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.SyncReqCookie
 * JD-Core Version:    0.7.0.1
 */