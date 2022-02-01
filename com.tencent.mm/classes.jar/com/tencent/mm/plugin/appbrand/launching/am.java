package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.b.c;

public abstract class am
  implements aa
{
  QualitySession lNV;
  private final c<kp> lNW = new c() {};
  public volatile aa.e lNX;
  private volatile aa.b lNY;
  final ad lNZ;
  
  am(ad paramad)
  {
    this.lNZ = paramad;
  }
  
  public final void a(aa.b paramb)
  {
    this.lNY = paramb;
  }
  
  public final void a(aa.e parame)
  {
    this.lNX = parame;
  }
  
  public void a(QualitySession paramQualitySession)
  {
    this.lNV = paramQualitySession;
  }
  
  public abstract String aWU();
  
  final void bsc()
  {
    if (this.lNX != null) {
      this.lNX.brT();
    }
    this.lNW.dead();
  }
  
  final void bsd()
  {
    if (this.lNX != null) {
      this.lNX.brU();
    }
  }
  
  final void bse()
  {
    if (this.lNX != null) {
      this.lNX.brV();
    }
  }
  
  final void c(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    aa.b localb = this.lNY;
    if (localb != null) {
      localb.a(paramWxaPkgLoadProgress);
    }
  }
  
  final void f(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.lNX != null) {
      this.lNX.c(paramWxaPkgWrappingInfo);
    }
    this.lNW.dead();
  }
  
  final void g(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.lNX != null) {
      this.lNX.d(paramWxaPkgWrappingInfo);
    }
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    if (this.lNV != null) {
      this.lNW.alive();
    }
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47241);
        am.this.prepare();
        AppMethodBeat.o(47241);
      }
    }, "AppBrandLaunchPrepareJob#" + aWU());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */