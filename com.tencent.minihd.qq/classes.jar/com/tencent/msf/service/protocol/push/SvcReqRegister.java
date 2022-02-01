package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqRegister
  extends JceStruct
{
  static byte[] cache_vecDevParam;
  static byte[] cache_vecGuid;
  public byte bIsOnline = 0;
  public byte bIsShowOnline = 0;
  public byte bKikPC = 0;
  public byte bKikWeak = 0;
  public byte bOnlinePush = 0;
  public byte bOpenPush = 1;
  public byte bRegType = 0;
  public byte bSlientPush = 0;
  public byte cConnType = 0;
  public byte cNetType = 0;
  public long iLargeSeq = 0L;
  public int iLocaleID = 2052;
  public long iOSVersion = 0L;
  public int iStatus = 11;
  public long lBid = 0L;
  public long lUin = 0L;
  public String sBuildVer = "";
  public String sOther = "";
  public String strDevName = "";
  public String strDevType = "";
  public String strOSVer = "";
  public long timeStamp = 0L;
  public byte[] vecDevParam = null;
  public byte[] vecGuid = null;
  
  public SvcReqRegister() {}
  
  public SvcReqRegister(long paramLong1, long paramLong2, byte paramByte1, String paramString1, int paramInt1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, long paramLong3, long paramLong4, byte paramByte7, String paramString2, byte paramByte8, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, byte paramByte9, String paramString3, String paramString4, String paramString5, byte paramByte10, long paramLong5)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.cConnType = paramByte1;
    this.sOther = paramString1;
    this.iStatus = paramInt1;
    this.bOnlinePush = paramByte2;
    this.bIsOnline = paramByte3;
    this.bIsShowOnline = paramByte4;
    this.bKikPC = paramByte5;
    this.bKikWeak = paramByte6;
    this.timeStamp = paramLong3;
    this.iOSVersion = paramLong4;
    this.cNetType = paramByte7;
    this.sBuildVer = paramString2;
    this.bRegType = paramByte8;
    this.vecDevParam = paramArrayOfByte1;
    this.vecGuid = paramArrayOfByte2;
    this.iLocaleID = paramInt2;
    this.bSlientPush = paramByte9;
    this.strDevName = paramString3;
    this.strDevType = paramString4;
    this.strOSVer = paramString5;
    this.bOpenPush = paramByte10;
    this.iLargeSeq = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.cConnType = paramJceInputStream.read(this.cConnType, 2, true);
    this.sOther = paramJceInputStream.readString(3, true);
    this.iStatus = paramJceInputStream.read(this.iStatus, 4, false);
    this.bOnlinePush = paramJceInputStream.read(this.bOnlinePush, 5, false);
    this.bIsOnline = paramJceInputStream.read(this.bIsOnline, 6, false);
    this.bIsShowOnline = paramJceInputStream.read(this.bIsShowOnline, 7, false);
    this.bKikPC = paramJceInputStream.read(this.bKikPC, 8, false);
    this.bKikWeak = paramJceInputStream.read(this.bKikWeak, 9, false);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 10, false);
    this.iOSVersion = paramJceInputStream.read(this.iOSVersion, 11, false);
    this.cNetType = paramJceInputStream.read(this.cNetType, 12, false);
    this.sBuildVer = paramJceInputStream.readString(13, false);
    this.bRegType = paramJceInputStream.read(this.bRegType, 14, false);
    if (cache_vecDevParam == null)
    {
      cache_vecDevParam = (byte[])new byte[1];
      ((byte[])cache_vecDevParam)[0] = 0;
    }
    this.vecDevParam = ((byte[])paramJceInputStream.read(cache_vecDevParam, 15, false));
    if (cache_vecGuid == null)
    {
      cache_vecGuid = (byte[])new byte[1];
      ((byte[])cache_vecGuid)[0] = 0;
    }
    this.vecGuid = ((byte[])paramJceInputStream.read(cache_vecGuid, 16, false));
    this.iLocaleID = paramJceInputStream.read(this.iLocaleID, 17, false);
    this.bSlientPush = paramJceInputStream.read(this.bSlientPush, 18, false);
    this.strDevName = paramJceInputStream.readString(19, false);
    this.strDevType = paramJceInputStream.readString(20, false);
    this.strOSVer = paramJceInputStream.readString(21, false);
    this.bOpenPush = paramJceInputStream.read(this.bOpenPush, 22, false);
    this.iLargeSeq = paramJceInputStream.read(this.iLargeSeq, 23, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cConnType, 2);
    paramJceOutputStream.write(this.sOther, 3);
    paramJceOutputStream.write(this.iStatus, 4);
    paramJceOutputStream.write(this.bOnlinePush, 5);
    paramJceOutputStream.write(this.bIsOnline, 6);
    paramJceOutputStream.write(this.bIsShowOnline, 7);
    paramJceOutputStream.write(this.bKikPC, 8);
    paramJceOutputStream.write(this.bKikWeak, 9);
    paramJceOutputStream.write(this.timeStamp, 10);
    paramJceOutputStream.write(this.iOSVersion, 11);
    paramJceOutputStream.write(this.cNetType, 12);
    if (this.sBuildVer != null) {
      paramJceOutputStream.write(this.sBuildVer, 13);
    }
    paramJceOutputStream.write(this.bRegType, 14);
    if (this.vecDevParam != null) {
      paramJceOutputStream.write(this.vecDevParam, 15);
    }
    if (this.vecGuid != null) {
      paramJceOutputStream.write(this.vecGuid, 16);
    }
    paramJceOutputStream.write(this.iLocaleID, 17);
    paramJceOutputStream.write(this.bSlientPush, 18);
    if (this.strDevName != null) {
      paramJceOutputStream.write(this.strDevName, 19);
    }
    if (this.strDevType != null) {
      paramJceOutputStream.write(this.strDevType, 20);
    }
    if (this.strOSVer != null) {
      paramJceOutputStream.write(this.strOSVer, 21);
    }
    paramJceOutputStream.write(this.bOpenPush, 22);
    paramJceOutputStream.write(this.iLargeSeq, 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcReqRegister
 * JD-Core Version:    0.7.0.1
 */