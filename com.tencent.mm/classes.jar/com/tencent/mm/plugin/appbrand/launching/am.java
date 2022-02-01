package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.b.c;

public abstract class am
  implements aa
{
  QualitySession kKR;
  private final c<jy> kKS = new c() {};
  public volatile aa.e kKT;
  private volatile aa.b kKU;
  final ab kKV;
  
  am(ab paramab)
  {
    this.kKV = paramab;
  }
  
  public final void a(aa.b paramb)
  {
    this.kKU = paramb;
  }
  
  public final void a(aa.e parame)
  {
    this.kKT = parame;
  }
  
  public void a(QualitySession paramQualitySession)
  {
    this.kKR = paramQualitySession;
  }
  
  public abstract String aMu();
  
  final void bgK()
  {
    if (this.kKT != null) {
      this.kKT.bgC();
    }
    this.kKS.dead();
  }
  
  final void bgL()
  {
    if (this.kKT != null) {
      this.kKT.bgD();
    }
  }
  
  final void bgM()
  {
    if (this.kKT != null) {
      this.kKT.bgE();
    }
  }
  
  final void d(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    aa.b localb = this.kKU;
    if (localb != null) {
      localb.b(paramWxaPkgLoadProgress);
    }
  }
  
  final void f(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.kKT != null) {
      this.kKT.c(paramWxaPkgWrappingInfo);
    }
    this.kKS.dead();
  }
  
  final void g(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.kKT != null) {
      this.kKT.d(paramWxaPkgWrappingInfo);
    }
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    if (this.kKR != null) {
      this.kKS.alive();
    }
    h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47241);
        am.this.prepare();
        AppMethodBeat.o(47241);
      }
    }, "AppBrandLaunchPrepareJob#" + aMu());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */