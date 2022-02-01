package com.tencent.upload.network.base;

public abstract interface IConnectionCallback
{
  public abstract void onConnect(IConnectionCallback paramIConnectionCallback, boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onDisconnect(IConnectionCallback paramIConnectionCallback);
  
  public abstract void onError(IConnectionCallback paramIConnectionCallback, int paramInt);
  
  public abstract void onRecv(IConnectionCallback paramIConnectionCallback, byte[] paramArrayOfByte);
  
  public abstract void onSendBegin(IConnectionCallback paramIConnectionCallback, int paramInt);
  
  public abstract void onSendEnd(IConnectionCallback paramIConnectionCallback, int paramInt);
  
  public abstract void onSendTimeOut(IConnectionCallback paramIConnectionCallback, int paramInt1, int paramInt2);
  
  public abstract void onStart(IConnectionCallback paramIConnectionCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.base.IConnectionCallback
 * JD-Core Version:    0.7.0.1
 */