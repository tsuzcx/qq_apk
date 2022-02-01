package com.tencent.upload.network.base;

public class HttpConnection
  extends Connection
{
  public HttpConnection(IConnectionCallback paramIConnectionCallback)
  {
    super(paramIConnectionCallback);
  }
  
  public int getProtocolCategory()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.base.HttpConnection
 * JD-Core Version:    0.7.0.1
 */