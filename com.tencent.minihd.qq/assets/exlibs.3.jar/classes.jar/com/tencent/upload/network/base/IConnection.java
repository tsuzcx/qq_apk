package com.tencent.upload.network.base;

public abstract interface IConnection
{
  public abstract boolean connectAsync(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3);
  
  public abstract int getProtocolCategory();
  
  public abstract boolean isConnected();
  
  public abstract boolean isRunning();
  
  public abstract boolean sendAsync(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setCallback(IConnectionCallback paramIConnectionCallback);
  
  public abstract boolean start();
  
  public abstract boolean stop();
  
  public abstract void wakeUp();
  
  public static final class ProtocolCategory
  {
    public static final int HTTP = 2;
    public static final int TCP = 1;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown ProtocolCategory";
      case 1: 
        return "tcp";
      }
      return "http";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.base.IConnection
 * JD-Core Version:    0.7.0.1
 */