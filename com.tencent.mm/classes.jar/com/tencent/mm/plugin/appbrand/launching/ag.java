package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.event.IListener;

abstract class ag
  implements aa, z
{
  boolean mUW = true;
  QualitySession mVi;
  private final IListener<lf> mVj = new IListener() {};
  private volatile z.b mVk;
  private volatile z.a mVl;
  final ad mVm;
  
  ag(ad paramad)
  {
    this.mVm = paramad;
  }
  
  public final void a(z.a parama)
  {
    this.mVl = parama;
  }
  
  public final void a(z.b paramb)
  {
    this.mVk = paramb;
  }
  
  public void a(QualitySession paramQualitySession)
  {
    this.mVi = paramQualitySession;
  }
  
  final void bNE()
  {
    if (this.mVk != null) {
      z.b localb = this.mVk;
    }
    this.mVj.dead();
  }
  
  public final boolean bNh()
  {
    return this.mUW;
  }
  
  public abstract String brS();
  
  final void c(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    z.a locala = this.mVl;
    if (locala != null) {
      locala.a(paramWxaPkgLoadProgress);
    }
  }
  
  final void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.mVk != null) {
      this.mVk.c(paramWxaPkgWrappingInfo);
    }
    this.mVj.dead();
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    if (this.mVi != null) {
      this.mVj.alive();
    }
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47241);
        ag.this.prepare();
        AppMethodBeat.o(47241);
      }
    }, "AppBrandLaunchPrepareJob#" + brS());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag
 * JD-Core Version:    0.7.0.1
 */