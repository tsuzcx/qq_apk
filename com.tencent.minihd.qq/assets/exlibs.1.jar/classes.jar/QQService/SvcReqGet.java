package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqGet
  extends JceStruct
{
  static byte[] cache_vecGuid;
  public byte bIsShowOnline = 0;
  public byte bOnlinePush = 0;
  public byte cConnType = 0;
  public int iClientId = 0;
  public int iClientIp = 0;
  public int iClientPort = 0;
  public int iSSOIp = 0;
  public int iSSOPort = 0;
  public int iStatus = 11;
  public long lBid = 0L;
  public long lUin = 0L;
  public String sOther = "";
  public byte[] vecGuid = null;
  
  public SvcReqGet() {}
  
  public SvcReqGet(long paramLong1, long paramLong2, String paramString, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.sOther = paramString;
    this.iStatus = paramInt1;
    this.bOnlinePush = paramByte1;
    this.cConnType = paramByte2;
    this.bIsShowOnline = paramByte3;
    this.iSSOIp = paramInt2;
    this.iSSOPort = paramInt3;
    this.iClientIp = paramInt4;
    this.iClientPort = paramInt5;
    this.iClientId = paramInt6;
    this.vecGuid = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.sOther = paramJceInputStream.readString(2, true);
    this.iStatus = paramJceInputStream.read(this.iStatus, 3, false);
    this.bOnlinePush = paramJceInputStream.read(this.bOnlinePush, 4, false);
    this.cConnType = paramJceInputStream.read(this.cConnType, 5, false);
    this.bIsShowOnline = paramJceInputStream.read(this.bIsShowOnline, 6, false);
    this.iSSOIp = paramJceInputStream.read(this.iSSOIp, 7, false);
    this.iSSOPort = paramJceInputStream.read(this.iSSOPort, 8, false);
    this.iClientIp = paramJceInputStream.read(this.iClientIp, 9, false);
    this.iClientPort = paramJceInputStream.read(this.iClientPort, 10, false);
    this.iClientId = paramJceInputStream.read(this.iClientId, 11, false);
    if (cache_vecGuid == null)
    {
      cache_vecGuid = (byte[])new byte[1];
      ((byte[])cache_vecGuid)[0] = 0;
    }
    this.vecGuid = ((byte[])paramJceInputStream.read(cache_vecGuid, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.sOther, 2);
    paramJceOutputStream.write(this.iStatus, 3);
    paramJceOutputStream.write(this.bOnlinePush, 4);
    paramJceOutputStream.write(this.cConnType, 5);
    paramJceOutputStream.write(this.bIsShowOnline, 6);
    paramJceOutputStream.write(this.iSSOIp, 7);
    paramJceOutputStream.write(this.iSSOPort, 8);
    paramJceOutputStream.write(this.iClientIp, 9);
    paramJceOutputStream.write(this.iClientPort, 10);
    paramJceOutputStream.write(this.iClientId, 11);
    if (this.vecGuid != null) {
      paramJceOutputStream.write(this.vecGuid, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.SvcReqGet
 * JD-Core Version:    0.7.0.1
 */