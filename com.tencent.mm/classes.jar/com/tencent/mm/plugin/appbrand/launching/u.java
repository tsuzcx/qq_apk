package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ba.a;

abstract class u
  implements ba.a
{
  final int hcr;
  
  u(int paramInt)
  {
    this.hcr = paramInt;
  }
  
  abstract String aGZ();
  
  protected void b(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  abstract void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.u
 * JD-Core Version:    0.7.0.1
 */