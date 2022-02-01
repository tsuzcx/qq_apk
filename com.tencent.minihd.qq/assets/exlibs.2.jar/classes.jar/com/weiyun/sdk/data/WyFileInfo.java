package com.weiyun.sdk.data;

public class WyFileInfo
{
  public final String cookieName;
  public final String cookieValue;
  public final String encodeUrl;
  public final String fileId;
  public final String fileName;
  public final long fileSize;
  public final String hostName;
  public final int id;
  public final String md5;
  public final long mtime;
  public final int serverPort;
  public final int source;
  
  public WyFileInfo(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, String paramString3)
  {
    this.id = paramInt1;
    this.fileId = paramString1;
    this.fileName = paramString2;
    this.mtime = paramLong1;
    this.fileSize = paramLong2;
    this.source = paramInt2;
    this.encodeUrl = null;
    this.cookieName = null;
    this.cookieValue = null;
    this.hostName = null;
    this.serverPort = 0;
    this.md5 = paramString3;
  }
  
  public WyFileInfo(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.id = paramInt1;
    this.fileId = paramString1;
    this.fileName = paramString2;
    this.mtime = paramLong1;
    this.fileSize = paramLong2;
    this.source = paramInt2;
    this.encodeUrl = paramString4;
    this.cookieName = paramString5;
    this.cookieValue = paramString6;
    this.hostName = paramString7;
    this.serverPort = paramInt3;
    this.md5 = paramString3;
  }
  
  public WyFileInfo(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, String paramString3)
  {
    this.fileId = paramString1;
    this.fileName = paramString2;
    this.mtime = paramLong1;
    this.fileSize = paramLong2;
    this.source = paramInt;
    this.id = 0;
    this.encodeUrl = null;
    this.cookieName = null;
    this.cookieValue = null;
    this.hostName = null;
    this.serverPort = 0;
    this.md5 = paramString3;
  }
  
  public WyFileInfo(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2)
  {
    this.id = 0;
    this.fileId = paramString1;
    this.fileName = paramString2;
    this.mtime = paramLong1;
    this.fileSize = paramLong2;
    this.source = paramInt1;
    this.encodeUrl = paramString4;
    this.cookieName = paramString5;
    this.cookieValue = paramString6;
    this.hostName = paramString7;
    this.serverPort = paramInt2;
    this.md5 = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.data.WyFileInfo
 * JD-Core Version:    0.7.0.1
 */