package com.tencent.map.tools.net.exception;

public class NetCustomException
  extends Exception
{
  private static final long serialVersionUID = -5614711401833110994L;
  private Exception exception;
  private int netCode;
  
  public NetCustomException() {}
  
  public NetCustomException(String paramString, Exception paramException, int paramInt)
  {
    super(paramString);
    this.exception = paramException;
    this.netCode = paramInt;
  }
  
  public Exception getException()
  {
    return this.exception;
  }
  
  public int getNetCode()
  {
    return this.netCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetCustomException
 * JD-Core Version:    0.7.0.1
 */