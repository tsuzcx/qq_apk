package com.tencent.securemodule.service;

public abstract interface ApkDownLoadListener
{
  public abstract void onDownLoadError();
  
  public abstract void onDownloadStart();
  
  public abstract void onDownloadSuccess();
  
  public abstract void onRefreshProgress(int paramInt, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.securemodule.service.ApkDownLoadListener
 * JD-Core Version:    0.7.0.1
 */