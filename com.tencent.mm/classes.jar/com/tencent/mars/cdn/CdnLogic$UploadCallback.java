package com.tencent.mars.cdn;

public abstract interface CdnLogic$UploadCallback
{
  public abstract void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult);
  
  public abstract void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.UploadCallback
 * JD-Core Version:    0.7.0.1
 */