package com.tencent.mars.cdn;

public abstract interface CdnLogic$DownloadCallback
{
  public abstract void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
  
  public abstract void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.DownloadCallback
 * JD-Core Version:    0.7.0.1
 */