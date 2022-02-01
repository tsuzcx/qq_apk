package com.tencent.kinda.gen;

public abstract class KCgi
{
  public abstract int getCgiId();
  
  public abstract String getCgiUrl();
  
  public abstract int getChannelType();
  
  public abstract boolean getNeedNotify();
  
  public abstract byte[] getRequestData();
  
  public abstract int getRetryCount();
  
  public abstract String getRouteInfo();
  
  public abstract int getTimeout();
  
  public abstract void onResp(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KCgi
 * JD-Core Version:    0.7.0.1
 */