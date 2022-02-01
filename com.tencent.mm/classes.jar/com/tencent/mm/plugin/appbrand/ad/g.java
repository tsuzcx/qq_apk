package com.tencent.mm.plugin.appbrand.ad;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.a.b;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.z;

public final class g
  implements i
{
  public o jCo;
  public com.tencent.mm.plugin.appbrand.service.c jCp;
  public int jCq = 9;
  public av jCr;
  public HandlerThread jCs;
  public h jCt;
  public long jCu;
  public volatile boolean jCv = false;
  private volatile boolean jCw = false;
  volatile boolean jCx = false;
  
  public g(o paramo)
  {
    this.jCo = paramo;
  }
  
  private void aXE()
  {
    AppMethodBeat.i(187958);
    if (aYk() != null)
    {
      ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "destroyServiceAdComponentView");
      aYk().aXE();
    }
    AppMethodBeat.o(187958);
  }
  
  public final void KT(String paramString)
  {
    AppMethodBeat.i(187955);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c(aYk());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c(aYk());
      paramString = this.jCo;
      ad.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, reset orientation", new Object[] { paramString.mAppId });
      if ((paramString.aVN() != null) && (paramString.aVN().getPageView() != null))
      {
        localObject = (com.tencent.mm.plugin.appbrand.page.b.d)paramString.aVN().getPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.appbrand.page.b.d)localObject).Dz();
          ad.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, request orientation:%s", new Object[] { paramString.mAppId, str });
          if (!bt.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.page.b.d)localObject).a(null);
          }
        }
      }
      aYp();
      com.tencent.mm.plugin.appbrand.report.quality.a.E(this.jCo);
      ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onSplashAdViewContainerHide");
      this.jCw = true;
      aXE();
      aYo();
    }
    AppMethodBeat.o(187955);
  }
  
  public final void KU(String paramString)
  {
    AppMethodBeat.i(187961);
    if (this.jCr != null)
    {
      ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "stopCheckShowAdTimeoutTick, appId:%s, reason:%s, realTime:%s", new Object[] { this.jCo.mAppId, paramString, Long.valueOf(bt.flT() - this.jCu) });
      this.jCv = true;
      this.jCr.stopTimer();
      this.jCr = null;
    }
    aYq();
    AppMethodBeat.o(187961);
  }
  
  final w aYj()
  {
    AppMethodBeat.i(187951);
    if ((this.jCo.aWm() instanceof w))
    {
      w localw = (w)this.jCo.aWm();
      AppMethodBeat.o(187951);
      return localw;
    }
    AppMethodBeat.o(187951);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aYk()
  {
    AppMethodBeat.i(187952);
    com.tencent.mm.plugin.appbrand.service.c localc;
    if (this.jCp != null)
    {
      localc = this.jCp;
      AppMethodBeat.o(187952);
      return localc;
    }
    if (this.jCo != null)
    {
      localc = this.jCo.aXe();
      AppMethodBeat.o(187952);
      return localc;
    }
    AppMethodBeat.o(187952);
    return null;
  }
  
  public final void aYl()
  {
    AppMethodBeat.i(187953);
    ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.jCw), Boolean.valueOf(this.jCx) });
    w localw = aYj();
    if ((localw != null) && (localw.getInternalLoadingSplash() != null)) {
      localw.getInternalLoadingSplash().u(new d.g.a.a() {});
    }
    AppMethodBeat.o(187953);
  }
  
  public final void aYm()
  {
    AppMethodBeat.i(187954);
    b localb = new b();
    localb.source = "launch";
    localb.type = "close";
    localb.c(aYk());
    l(true, "launch");
    AppMethodBeat.o(187954);
  }
  
  public final void aYn()
  {
    AppMethodBeat.i(187957);
    w localw = aYj();
    if (localw != null) {
      localw.aYn();
    }
    ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideSplashAdImmediately");
    this.jCw = true;
    aXE();
    aYo();
    AppMethodBeat.o(187957);
  }
  
  final void aYo()
  {
    AppMethodBeat.i(187959);
    ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.jCw), Boolean.valueOf(this.jCx) });
    if ((this.jCw) && (this.jCx))
    {
      w localw = aYj();
      if (localw != null)
      {
        ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, remove AdLoadingSplash");
        localw.byT();
      }
    }
    AppMethodBeat.o(187959);
  }
  
  public final void aYp()
  {
    AppMethodBeat.i(187960);
    if (this.jCt != null) {
      this.jCo.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187950);
          if (g.this.jCt != null) {
            g.this.jCt.BI();
          }
          AppMethodBeat.o(187950);
        }
      });
    }
    AppMethodBeat.o(187960);
  }
  
  final void aYq()
  {
    AppMethodBeat.i(187962);
    if (this.jCs != null)
    {
      this.jCs.quitSafely();
      this.jCs = null;
    }
    AppMethodBeat.o(187962);
  }
  
  public final void l(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(187956);
    this.jCo.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187949);
        w localw = g.this.aYj();
        if (localw != null) {
          localw.l(paramBoolean, paramString);
        }
        AppMethodBeat.o(187949);
      }
    }, 0L);
    AppMethodBeat.o(187956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.g
 * JD-Core Version:    0.7.0.1
 */