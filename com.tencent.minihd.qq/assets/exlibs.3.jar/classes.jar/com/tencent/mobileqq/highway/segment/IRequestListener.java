package com.tencent.mobileqq.highway.segment;

public abstract interface IRequestListener
{
  public abstract void handleConnClosed();
  
  public abstract void handleError(int paramInt);
  
  public abstract void handleResponse(HwResponse paramHwResponse);
  
  public abstract void handleSendBegin(int paramInt);
  
  public abstract void handleSendEnd(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void handleSendTimeOut();
  
  public abstract void handleWriteTimeout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.IRequestListener
 * JD-Core Version:    0.7.0.1
 */