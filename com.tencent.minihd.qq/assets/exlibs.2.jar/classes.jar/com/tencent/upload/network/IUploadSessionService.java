package com.tencent.upload.network;

import com.tencent.upload.uinterface.IUploadAction;

public abstract interface IUploadSessionService
{
  public abstract boolean cancel(int paramInt1, int paramInt2);
  
  public abstract void cancelAll(int paramInt);
  
  public abstract void close();
  
  public abstract boolean perpare(int paramInt);
  
  public abstract boolean switchServer(int paramInt1, int paramInt2);
  
  public abstract boolean upload(IUploadAction paramIUploadAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.IUploadSessionService
 * JD-Core Version:    0.7.0.1
 */