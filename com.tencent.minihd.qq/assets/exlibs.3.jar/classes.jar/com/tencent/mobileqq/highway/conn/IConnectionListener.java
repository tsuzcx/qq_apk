package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

public abstract interface IConnectionListener
{
  public abstract void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo);
  
  public abstract void onConnectionIdle(int paramInt, boolean paramBoolean);
  
  public abstract void onDisConnect(int paramInt, IConnection paramIConnection);
  
  public abstract void onRecvInvalidData(EndPoint paramEndPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.IConnectionListener
 * JD-Core Version:    0.7.0.1
 */