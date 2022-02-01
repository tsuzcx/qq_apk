package com.tencent.mars.cdn;

public abstract interface CronetLogic$CronetTaskCallback
{
  public abstract int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt, String paramString);
  
  public abstract void onCronetTaskCompleted(String paramString1, CronetLogic.CronetTaskResult paramCronetTaskResult, String paramString2);
  
  public abstract void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
 * JD-Core Version:    0.7.0.1
 */