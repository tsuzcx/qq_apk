package com.pay.http;

public abstract interface IAPHttpAns
{
  public abstract void onError(APBaseHttpReq paramAPBaseHttpReq, int paramInt, String paramString);
  
  public abstract void onFinish(APBaseHttpReq paramAPBaseHttpReq);
  
  public abstract void onReceive(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq);
  
  public abstract void onStart(APBaseHttpReq paramAPBaseHttpReq);
  
  public abstract void onStop(APBaseHttpReq paramAPBaseHttpReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.pay.http.IAPHttpAns
 * JD-Core Version:    0.7.0.1
 */