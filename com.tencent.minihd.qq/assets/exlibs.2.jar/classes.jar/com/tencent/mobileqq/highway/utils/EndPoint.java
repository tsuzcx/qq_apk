package com.tencent.mobileqq.highway.utils;

public class EndPoint
  implements Cloneable
{
  public static final int COMMON_IP = 0;
  public static final int PROXY_IP = 1;
  public int connIndex;
  public int connResult = -1;
  public long cost = -1L;
  public String host;
  public int ipIndex = 0;
  public int port;
  public int protoType = 1;
  public long timestampe;
  public int type;
  
  public EndPoint(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }
  
  public EndPoint(String paramString, int paramInt1, int paramInt2)
  {
    this.host = paramString;
    this.port = paramInt1;
    this.type = paramInt2;
  }
  
  public EndPoint(String paramString, int paramInt, long paramLong)
  {
    this(paramString, paramInt, 0);
    this.timestampe = paramLong;
  }
  
  public EndPoint clone()
    throws CloneNotSupportedException
  {
    return (EndPoint)super.clone();
  }
  
  public boolean isPorxyIp()
  {
    return this.type == 1;
  }
  
  public String toString()
  {
    return this.host + ":" + this.port + ",type:" + this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.EndPoint
 * JD-Core Version:    0.7.0.1
 */