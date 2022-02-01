package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.b.c;

public abstract class am
  implements aa
{
  QualitySession lJv;
  private final c<ko> lJw = new c() {};
  public volatile aa.e lJx;
  private volatile aa.b lJy;
  final ac lJz;
  
  am(ac paramac)
  {
    this.lJz = paramac;
  }
  
  public final void a(aa.b paramb)
  {
    this.lJy = paramb;
  }
  
  public final void a(aa.e parame)
  {
    this.lJx = parame;
  }
  
  public void a(QualitySession paramQualitySession)
  {
    this.lJv = paramQualitySession;
  }
  
  public abstract String aWs();
  
  final void brr()
  {
    if (this.lJx != null) {
      this.lJx.bri();
    }
    this.lJw.dead();
  }
  
  final void brs()
  {
    if (this.lJx != null) {
      this.lJx.brj();
    }
  }
  
  final void brt()
  {
    if (this.lJx != null) {
      this.lJx.brk();
    }
  }
  
  final void c(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    aa.b localb = this.lJy;
    if (localb != null) {
      localb.a(paramWxaPkgLoadProgress);
    }
  }
  
  final void f(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.lJx != null) {
      this.lJx.c(paramWxaPkgWrappingInfo);
    }
    this.lJw.dead();
  }
  
  final void g(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (this.lJx != null) {
      this.lJx.d(paramWxaPkgWrappingInfo);
    }
  }
  
  public abstract void prepare();
  
  public final void prepareAsync()
  {
    if (this.lJv != null) {
      this.lJw.alive();
    }
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47241);
        am.this.prepare();
        AppMethodBeat.o(47241);
      }
    }, "AppBrandLaunchPrepareJob#" + aWs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */