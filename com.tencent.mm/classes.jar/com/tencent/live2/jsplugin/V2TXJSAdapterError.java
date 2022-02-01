package com.tencent.live2.jsplugin;

public class V2TXJSAdapterError
{
  public int errorCode = 0;
  public String errorInfo = "Success";
  
  public V2TXJSAdapterError() {}
  
  public V2TXJSAdapterError(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorInfo = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.V2TXJSAdapterError
 * JD-Core Version:    0.7.0.1
 */