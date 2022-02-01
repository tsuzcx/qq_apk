package com.tencent.mm.plugin.appbrand.ad;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
  implements j
{
  public p jFm;
  public com.tencent.mm.plugin.appbrand.service.c jFn;
  public int jFo = 9;
  public aw jFp;
  private HandlerThread jFq;
  public i jFr;
  public long jFs;
  volatile boolean jFt = false;
  private volatile boolean jFu = false;
  volatile boolean jFv = false;
  
  public h(p paramp)
  {
    this.jFm = paramp;
  }
  
  private void aXZ()
  {
    AppMethodBeat.i(222071);
    if (aYE() != null)
    {
      ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "destroyServiceAdComponentView");
      aYE().aXZ();
    }
    AppMethodBeat.o(222071);
  }
  
  public final void Lt(String paramString)
  {
    AppMethodBeat.i(222067);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c(aYE());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c(aYE());
      paramString = this.jFm;
      ae.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, reset orientation", new Object[] { paramString.mAppId });
      if ((paramString.aWm() != null) && (paramString.aWm().getPageView() != null))
      {
        localObject = (com.tencent.mm.plugin.appbrand.page.a.d)paramString.aWm().getPageView().Q(com.tencent.mm.plugin.appbrand.page.a.d.class);
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).DC();
          ae.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, request orientation:%s", new Object[] { paramString.mAppId, str });
          if (!bu.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).a(null);
          }
        }
      }
      aYK();
      com.tencent.mm.plugin.appbrand.report.quality.a.F(this.jFm);
      ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onSplashAdViewContainerHide");
      this.jFu = true;
      aXZ();
      aYJ();
    }
    AppMethodBeat.o(222067);
  }
  
  public final void Lu(String paramString)
  {
    AppMethodBeat.i(222074);
    if (this.jFp != null)
    {
      ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "stopCheckShowAdTimeoutTick, appId:%s, reason:%s, realTime:%s", new Object[] { this.jFm.mAppId, paramString, Long.valueOf(bu.fpO() - this.jFs) });
      this.jFt = true;
      this.jFp.stopTimer();
      this.jFp = null;
    }
    aYL();
    AppMethodBeat.o(222074);
  }
  
  final x aYD()
  {
    AppMethodBeat.i(222063);
    if ((this.jFm.aWN() instanceof x))
    {
      x localx = (x)this.jFm.aWN();
      AppMethodBeat.o(222063);
      return localx;
    }
    AppMethodBeat.o(222063);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aYE()
  {
    AppMethodBeat.i(222064);
    com.tencent.mm.plugin.appbrand.service.c localc;
    if (this.jFn != null)
    {
      localc = this.jFn;
      AppMethodBeat.o(222064);
      return localc;
    }
    if (this.jFm != null)
    {
      localc = this.jFm.aXz();
      AppMethodBeat.o(222064);
      return localc;
    }
    AppMethodBeat.o(222064);
    return null;
  }
  
  public final void aYF()
  {
    AppMethodBeat.i(222065);
    ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.jFu), Boolean.valueOf(this.jFv) });
    x localx = aYD();
    if ((localx != null) && (localx.getInternalLoadingSplash() != null)) {
      localx.getInternalLoadingSplash().v(new d.g.a.a() {});
    }
    AppMethodBeat.o(222065);
  }
  
  public final void aYG()
  {
    AppMethodBeat.i(222066);
    b localb = new b();
    localb.source = "launch";
    localb.type = "close";
    localb.c(aYE());
    l(true, "launch");
    AppMethodBeat.o(222066);
  }
  
  public final void aYH()
  {
    AppMethodBeat.i(222068);
    this.jFs = bu.fpO();
    this.jFq = new HandlerThread("checkShowAdThread");
    this.jFq.start();
    this.jFp = new aw(this.jFq.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(222060);
        if (h.this.jFt)
        {
          ae.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer, timer already stopped");
          AppMethodBeat.o(222060);
          return false;
        }
        ae.e("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer timeOut, realTime:%s", new Object[] { Long.valueOf(bu.fpO() - h.this.jFs) });
        h.this.aYK();
        h.this.aYI();
        h.this.aYL();
        AppMethodBeat.o(222060);
        return false;
      }
    }, false);
    int i = p.aXF();
    ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer start, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    this.jFt = false;
    aw localaw = this.jFp;
    long l = i;
    localaw.ay(l, l);
    AppMethodBeat.o(222068);
  }
  
  public final void aYI()
  {
    AppMethodBeat.i(222070);
    x localx = aYD();
    if (localx != null) {
      localx.aYI();
    }
    ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideSplashAdImmediately");
    this.jFu = true;
    aXZ();
    aYJ();
    AppMethodBeat.o(222070);
  }
  
  final void aYJ()
  {
    AppMethodBeat.i(222072);
    ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.jFu), Boolean.valueOf(this.jFv) });
    if ((this.jFu) && (this.jFv))
    {
      x localx = aYD();
      if (localx != null)
      {
        ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, remove AdLoadingSplash");
        localx.bzO();
      }
    }
    AppMethodBeat.o(222072);
  }
  
  public final void aYK()
  {
    AppMethodBeat.i(222073);
    if (this.jFr != null) {
      this.jFm.N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222062);
          if (h.this.jFr != null) {
            h.this.jFr.BJ();
          }
          AppMethodBeat.o(222062);
        }
      });
    }
    AppMethodBeat.o(222073);
  }
  
  final void aYL()
  {
    AppMethodBeat.i(222075);
    if (this.jFq != null)
    {
      this.jFq.quitSafely();
      this.jFq = null;
    }
    AppMethodBeat.o(222075);
  }
  
  public final void l(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(222069);
    this.jFm.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222061);
        x localx = h.this.aYD();
        if (localx != null) {
          localx.l(paramBoolean, paramString);
        }
        AppMethodBeat.o(222061);
      }
    }, 0L);
    AppMethodBeat.o(222069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.h
 * JD-Core Version:    0.7.0.1
 */