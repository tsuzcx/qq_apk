package com.tencent.mm.plugin.appbrand.ad;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.x;

public final class h
  implements j
{
  public q kGW;
  public com.tencent.mm.plugin.appbrand.service.c kGX;
  public int kGY = 9;
  public MTimerHandler kGZ;
  private HandlerThread kHa;
  public i kHb;
  public long kHc;
  volatile boolean kHd = false;
  private volatile boolean kHe = false;
  volatile boolean kHf = false;
  
  public h(q paramq)
  {
    this.kGW = paramq;
  }
  
  private void btf()
  {
    AppMethodBeat.i(226273);
    if (btQ() != null)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "destroyServiceAdComponentView");
      btQ().btf();
    }
    AppMethodBeat.o(226273);
  }
  
  public final void UC(String paramString)
  {
    AppMethodBeat.i(226269);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).d(btQ());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).d(btQ());
      paramString = this.kGW;
      Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, reset orientation", new Object[] { paramString.mAppId });
      if ((paramString.brh() != null) && (paramString.brh().getPageView() != null))
      {
        localObject = (com.tencent.mm.plugin.appbrand.page.a.d)paramString.brh().getPageView().S(com.tencent.mm.plugin.appbrand.page.a.d.class);
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).MZ();
          Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, request orientation:%s", new Object[] { paramString.mAppId, str });
          if (!Util.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).a(null);
          }
        }
      }
      btW();
      com.tencent.mm.plugin.appbrand.report.quality.b.K(this.kGW);
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onSplashAdViewContainerHide");
      this.kHe = true;
      btf();
      btV();
    }
    AppMethodBeat.o(226269);
  }
  
  public final void UD(String paramString)
  {
    AppMethodBeat.i(226276);
    if (this.kGZ != null)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "stopCheckShowAdTimeoutTick, appId:%s, reason:%s, realTime:%s", new Object[] { this.kGW.mAppId, paramString, Long.valueOf(Util.nowMilliSecond() - this.kHc) });
      this.kHd = true;
      this.kGZ.stopTimer();
      this.kGZ = null;
    }
    btX();
    AppMethodBeat.o(226276);
  }
  
  final com.tencent.mm.plugin.appbrand.ui.ac btP()
  {
    AppMethodBeat.i(226265);
    if ((this.kGW.brK() instanceof com.tencent.mm.plugin.appbrand.ui.ac))
    {
      com.tencent.mm.plugin.appbrand.ui.ac localac = (com.tencent.mm.plugin.appbrand.ui.ac)this.kGW.brK();
      AppMethodBeat.o(226265);
      return localac;
    }
    AppMethodBeat.o(226265);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c btQ()
  {
    AppMethodBeat.i(226266);
    com.tencent.mm.plugin.appbrand.service.c localc;
    if (this.kGX != null)
    {
      localc = this.kGX;
      AppMethodBeat.o(226266);
      return localc;
    }
    if (this.kGW != null)
    {
      localc = this.kGW.bsE();
      AppMethodBeat.o(226266);
      return localc;
    }
    AppMethodBeat.o(226266);
    return null;
  }
  
  public final void btR()
  {
    AppMethodBeat.i(226267);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.kHe), Boolean.valueOf(this.kHf) });
    com.tencent.mm.plugin.appbrand.ui.ac localac = btP();
    if ((localac != null) && (localac.getInternalLoadingSplash() != null)) {
      localac.getInternalLoadingSplash().z(new a() {});
    }
    AppMethodBeat.o(226267);
  }
  
  public final void btS()
  {
    AppMethodBeat.i(226268);
    com.tencent.mm.plugin.appbrand.ad.a.b localb = new com.tencent.mm.plugin.appbrand.ad.a.b();
    localb.source = "launch";
    localb.type = "close";
    localb.d(btQ());
    m(true, "launch");
    AppMethodBeat.o(226268);
  }
  
  public final void btT()
  {
    AppMethodBeat.i(226270);
    this.kHc = Util.nowMilliSecond();
    this.kHa = new HandlerThread("checkShowAdThread");
    this.kHa.start();
    this.kGZ = new MTimerHandler(this.kHa.getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(226262);
        if (h.this.kHd)
        {
          Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer, timer already stopped");
          AppMethodBeat.o(226262);
          return false;
        }
        Log.e("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer timeOut, realTime:%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - h.this.kHc) });
        h.this.btW();
        h.this.btU();
        h.this.btX();
        AppMethodBeat.o(226262);
        return false;
      }
    }, false);
    int i = q.bsK();
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer start, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    this.kHd = false;
    this.kGZ.startTimer(i);
    AppMethodBeat.o(226270);
  }
  
  public final void btU()
  {
    AppMethodBeat.i(226272);
    com.tencent.mm.plugin.appbrand.ui.ac localac = btP();
    if (localac != null) {
      localac.bWI();
    }
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideSplashAdImmediately");
    this.kHe = true;
    btf();
    btV();
    AppMethodBeat.o(226272);
  }
  
  final void btV()
  {
    AppMethodBeat.i(226274);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.kHe), Boolean.valueOf(this.kHf) });
    if ((this.kHe) && (this.kHf))
    {
      com.tencent.mm.plugin.appbrand.ui.ac localac = btP();
      if (localac != null)
      {
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, remove AdLoadingSplash");
        localac.bWJ();
      }
    }
    AppMethodBeat.o(226274);
  }
  
  public final void btW()
  {
    AppMethodBeat.i(226275);
    if (this.kHb != null) {
      this.kGW.S(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226264);
          if (h.this.kHb != null) {
            h.this.kHb.KY();
          }
          AppMethodBeat.o(226264);
        }
      });
    }
    AppMethodBeat.o(226275);
  }
  
  final void btX()
  {
    AppMethodBeat.i(226277);
    if (this.kHa != null)
    {
      this.kHa.quitSafely();
      this.kHa = null;
    }
    AppMethodBeat.o(226277);
  }
  
  public final void m(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(226271);
    this.kGW.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226263);
        com.tencent.mm.plugin.appbrand.ui.ac localac = h.this.btP();
        if (localac != null) {
          localac.k(paramBoolean, paramString);
        }
        AppMethodBeat.o(226263);
      }
    }, 0L);
    AppMethodBeat.o(226271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.h
 * JD-Core Version:    0.7.0.1
 */