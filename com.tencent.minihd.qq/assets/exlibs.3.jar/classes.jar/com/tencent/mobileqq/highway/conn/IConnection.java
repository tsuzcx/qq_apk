package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

public abstract interface IConnection
{
  public abstract void connect();
  
  public abstract void disConnect();
  
  public abstract int getConnId();
  
  public abstract int getConnType();
  
  public abstract EndPoint getEndPoint();
  
  public abstract int getProtoType();
  
  public abstract boolean isWritable();
  
  public abstract void setConnectListener(IConnectionListener paramIConnectionListener);
  
  public abstract void setUrgentFlag(boolean paramBoolean);
  
  public abstract void wakeupChannel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.IConnection
 * JD-Core Version:    0.7.0.1
 */