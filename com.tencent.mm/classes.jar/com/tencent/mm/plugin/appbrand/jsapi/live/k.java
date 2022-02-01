package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.live2.jsplugin.V2TXJSAdapterError;

public final class k
{
  public int errorCode = 0;
  public String errorInfo = "Success";
  
  public k() {}
  
  public k(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorInfo = paramString;
  }
  
  public k(V2TXJSAdapterError paramV2TXJSAdapterError)
  {
    this.errorCode = paramV2TXJSAdapterError.errorCode;
    this.errorInfo = paramV2TXJSAdapterError.errorInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.k
 * JD-Core Version:    0.7.0.1
 */