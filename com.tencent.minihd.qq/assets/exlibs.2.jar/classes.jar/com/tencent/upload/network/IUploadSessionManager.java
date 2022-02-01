package com.tencent.upload.network;

import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.uinterface.IUploadAction;

public abstract interface IUploadSessionManager
{
  public abstract boolean cancelAll(int paramInt);
  
  public abstract boolean cancelAsync(int paramInt1, int paramInt2);
  
  public abstract void close();
  
  public abstract int getServerCategory();
  
  public abstract boolean isPerpared();
  
  public abstract boolean perpareAsync();
  
  public abstract boolean switchRouteStrategy(IUploadRouteStrategy paramIUploadRouteStrategy);
  
  public abstract boolean uploadAsync(IUploadAction paramIUploadAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.IUploadSessionManager
 * JD-Core Version:    0.7.0.1
 */