package com.tencent.kinda.gen;

public abstract interface KThirdPayService
{
  public abstract boolean isYunShanFuAppInstalled();
  
  public abstract void startYunShanFuPayImpl(String paramString, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KThirdPayService
 * JD-Core Version:    0.7.0.1
 */