package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.sdk.f.e;

public abstract class o
  implements j
{
  public volatile j.c gKD;
  private volatile j.b gKE;
  final s gKF;
  
  o(s params)
  {
    this.gKF = params;
  }
  
  public final void a(j.b paramb)
  {
    this.gKE = paramb;
  }
  
  public final void a(j.c paramc)
  {
    this.gKD = paramc;
  }
  
  public abstract String alK();
  
  final void c(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    j.b localb = this.gKE;
    if (localb != null) {
      localb.a(paramWxaPkgLoadProgress);
    }
  }
  
  final void d(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    j.c localc = this.gKD;
    if (localc != null) {
      localc.b(paramWxaPkgWrappingInfo);
    }
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    e.post(new o.1(this), "AppBrandLaunchPrepareJob#" + alK());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */