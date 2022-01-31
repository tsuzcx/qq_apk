package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;

final class WxaCommLibRuntimeReader$b
  extends WxaCommLibRuntimeReader.a
{
  static final b fDb = new b();
  final WxaPkgWrappingInfo fDa = new WxaPkgWrappingInfo();
  
  WxaCommLibRuntimeReader$b()
  {
    super((byte)0);
    this.fDa.fEP = true;
    this.fDa.fEM = 0;
    this.fDa.fEN = ah.VERSION;
    this.fDa.bIW = "";
  }
  
  public final WxaPkgWrappingInfo abB()
  {
    return this.fDa;
  }
  
  public final void init() {}
  
  public final InputStream openRead(String paramString)
  {
    return ah.openRead(paramString);
  }
  
  public final String toString()
  {
    return "AssetReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.b
 * JD-Core Version:    0.7.0.1
 */