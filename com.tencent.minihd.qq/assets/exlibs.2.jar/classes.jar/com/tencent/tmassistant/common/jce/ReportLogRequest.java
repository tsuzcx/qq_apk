package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportLogRequest
  extends JceStruct
{
  static byte[] a;
  public String hostAppPackageName = "";
  public int hostAppVersion = 0;
  public String hostUserId = "";
  public byte[] logData = null;
  public int logType = 0;
  
  public ReportLogRequest() {}
  
  public ReportLogRequest(int paramInt1, byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt2)
  {
    this.logType = paramInt1;
    this.logData = paramArrayOfByte;
    this.hostUserId = paramString1;
    this.hostAppPackageName = paramString2;
    this.hostAppVersion = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.logType = paramJceInputStream.read(this.logType, 0, false);
    if (a == null)
    {
      a = (byte[])new byte[1];
      ((byte[])a)[0] = 0;
    }
    this.logData = ((byte[])paramJceInputStream.read(a, 1, false));
    this.hostUserId = paramJceInputStream.readString(2, false);
    this.hostAppPackageName = paramJceInputStream.readString(3, false);
    this.hostAppVersion = paramJceInputStream.read(this.hostAppVersion, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logType, 0);
    if (this.logData != null) {
      paramJceOutputStream.write(this.logData, 1);
    }
    if (this.hostUserId != null) {
      paramJceOutputStream.write(this.hostUserId, 2);
    }
    if (this.hostAppPackageName != null) {
      paramJceOutputStream.write(this.hostAppPackageName, 3);
    }
    paramJceOutputStream.write(this.hostAppVersion, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.ReportLogRequest
 * JD-Core Version:    0.7.0.1
 */