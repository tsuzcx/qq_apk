package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;
import java.util.Locale;

final class WxaCommLibRuntimeReader$d
  extends WxaCommLibRuntimeReader.a
{
  private final WxaPkgWrappingInfo fDa;
  private final ai fDd;
  
  private WxaCommLibRuntimeReader$d(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    super((byte)0);
    this.fDa = paramWxaPkgWrappingInfo;
    this.fDd = new ai(paramWxaPkgWrappingInfo.fCl);
  }
  
  public final WxaPkgWrappingInfo abB()
  {
    return this.fDa;
  }
  
  public final void init()
  {
    this.fDd.abX();
  }
  
  public final InputStream openRead(String paramString)
  {
    this.fDd.abX();
    return this.fDd.rb(paramString);
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "PkgReader[%d] [%s]", new Object[] { Integer.valueOf(this.fDa.fEN), abC() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.d
 * JD-Core Version:    0.7.0.1
 */