package com.tencent.upload.uinterface;

public abstract interface IUploadReport
{
  public abstract void batchComplete();
  
  public abstract void onUploadReport(Report paramReport);
  
  public abstract void openSessionReport(int paramInt1, String paramString1, String paramString2, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadReport
 * JD-Core Version:    0.7.0.1
 */