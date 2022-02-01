package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UinPairReadInfo
  extends JceStruct
{
  static byte[] cache_vCrmSig;
  public long lLastReadTime = 0L;
  public long lPeerUin = 0L;
  public long lSecChatSessionId = 0L;
  public byte[] vCrmSig = null;
  
  public UinPairReadInfo() {}
  
  public UinPairReadInfo(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    this.lPeerUin = paramLong1;
    this.lLastReadTime = paramLong2;
    this.lSecChatSessionId = paramLong3;
    this.vCrmSig = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 0, false);
    this.lLastReadTime = paramJceInputStream.read(this.lLastReadTime, 1, false);
    this.lSecChatSessionId = paramJceInputStream.read(this.lSecChatSessionId, 2, false);
    if (cache_vCrmSig == null)
    {
      cache_vCrmSig = (byte[])new byte[1];
      ((byte[])cache_vCrmSig)[0] = 0;
    }
    this.vCrmSig = ((byte[])paramJceInputStream.read(cache_vCrmSig, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPeerUin, 0);
    paramJceOutputStream.write(this.lLastReadTime, 1);
    paramJceOutputStream.write(this.lSecChatSessionId, 2);
    if (this.vCrmSig != null) {
      paramJceOutputStream.write(this.vCrmSig, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.UinPairReadInfo
 * JD-Core Version:    0.7.0.1
 */