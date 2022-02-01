package com.tencent.upload.network;

import com.tencent.upload.network.route.UploadRoute;

public abstract interface ISessionServiceCallback
{
  public abstract void onFailToOpen(int paramInt, UploadRoute paramUploadRoute, String paramString);
  
  public abstract void onOpen(int paramInt, UploadRoute paramUploadRoute, String paramString);
  
  public abstract void onSessionServiceStateChange(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.ISessionServiceCallback
 * JD-Core Version:    0.7.0.1
 */