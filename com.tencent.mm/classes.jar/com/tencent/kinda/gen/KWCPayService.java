package com.tencent.kinda.gen;

public abstract interface KWCPayService
{
  public abstract void getBannerInfoImpl(int paramInt, VoidITransmitKvDataNoticeItemCallback paramVoidITransmitKvDataNoticeItemCallback);
  
  public abstract boolean isNeedWalletLock();
  
  public abstract boolean isSetWalletLock();
  
  public abstract void startUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KWCPayService
 * JD-Core Version:    0.7.0.1
 */