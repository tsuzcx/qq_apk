package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.b.c;

public abstract class am
  implements aa
{
  QualitySession lmn;
  private final c<kg> lmo = new c() {};
  public volatile aa.e lmp;
  private volatile aa.b lmq;
  final ab lmr;
  
  am(ab paramab)
  {
    this.lmr = paramab;
  }
  
  public final void a(aa.b paramb)
  {
    this.lmq = paramb;
  }
  
  public final void a(aa.e parame)
  {
    this.lmp = parame;
  }
  
  public void a(QualitySession paramQualitySession)
  {
    this.lmn = paramQualitySession;
  }
  
  public abstract String aTk();
  
  final void bnE()
  {
    if (this.lmp != null) {
      this.lmp.bnw();
    }
    this.lmo.dead();
  }
  
  final void bnF()
  {
    if (this.lmp != null) {
      this.lmp.bnx();
    }
  }
  
  final void bnG()
  {
    if (this.lmp != null) {
      this.lmp.bny();
    }
  }
  
  final void c(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    aa.b localb = this.lmq;
    if (localb != null) {
      localb.a(paramWxaPkgLoadProgress);
    }
  }
  
  final void f(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.lmp != null) {
      this.lmp.c(paramWxaPkgWrappingInfo);
    }
    this.lmo.dead();
  }
  
  final void g(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.lmp != null) {
      this.lmp.d(paramWxaPkgWrappingInfo);
    }
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    if (this.lmn != null) {
      this.lmo.alive();
    }
    h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47241);
        am.this.prepare();
        AppMethodBeat.o(47241);
      }
    }, "AppBrandLaunchPrepareJob#" + aTk());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */