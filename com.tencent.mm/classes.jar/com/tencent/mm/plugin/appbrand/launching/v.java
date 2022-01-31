package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.sdk.g.d;

public abstract class v
  implements o
{
  public volatile o.c ilE;
  private volatile o.b ilF;
  final y ilG;
  
  v(y paramy)
  {
    this.ilG = paramy;
  }
  
  public final void a(o.b paramb)
  {
    this.ilF = paramb;
  }
  
  public final void a(o.c paramc)
  {
    this.ilE = paramc;
  }
  
  final void aHa()
  {
    if (this.ilE != null) {
      this.ilE.aGU();
    }
  }
  
  final void aHb()
  {
    if (this.ilE != null) {
      this.ilE.aGW();
    }
  }
  
  public abstract String aHc();
  
  final void c(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    o.b localb = this.ilF;
    if (localb != null) {
      localb.a(paramWxaPkgLoadProgress);
    }
  }
  
  final void d(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.ilE != null) {
      this.ilE.a(paramWxaPkgWrappingInfo);
    }
  }
  
  final void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.ilE != null) {
      this.ilE.b(paramWxaPkgWrappingInfo);
    }
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    d.post(new v.1(this), "AppBrandLaunchPrepareJob#" + aHc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.v
 * JD-Core Version:    0.7.0.1
 */