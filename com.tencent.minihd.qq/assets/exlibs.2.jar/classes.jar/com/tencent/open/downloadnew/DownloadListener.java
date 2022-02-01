package com.tencent.open.downloadnew;

import java.util.List;

public abstract interface DownloadListener
{
  public abstract void a(DownloadInfo paramDownloadInfo);
  
  public abstract void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List paramList);
  
  public abstract void b(DownloadInfo paramDownloadInfo);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void c(DownloadInfo paramDownloadInfo);
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract void d(DownloadInfo paramDownloadInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadListener
 * JD-Core Version:    0.7.0.1
 */