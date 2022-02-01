package com.tencent.mm.plugin.appbrand.ad;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.a.f;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;

public final class h
  implements j
{
  public t nAH;
  public com.tencent.mm.plugin.appbrand.service.c nAI;
  public int nAJ = 9;
  public MTimerHandler nAK;
  private HandlerThread nAL;
  public i nAM;
  public long nAN;
  volatile boolean nAO = false;
  private volatile boolean nAP = false;
  volatile boolean nAQ = false;
  public com.tencent.mm.plugin.appbrand.b nwF;
  
  public h(t paramt, com.tencent.mm.plugin.appbrand.b paramb)
  {
    this.nAH = paramt;
    this.nwF = paramb;
  }
  
  public static r a(kotlin.o<Long, Long> paramo, r paramr, int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(282964);
    paramr.gfp = ((Long)paramo.Mx).longValue();
    paramr.gfq = ((Long)paramo.My).longValue();
    paramr.gfs = paramInt;
    paramr.gft = paramLong;
    paramo = paramString;
    if (paramString == null) {
      paramo = "";
    }
    paramr.iM(paramo);
    AppMethodBeat.o(282964);
    return paramr;
  }
  
  private void bEU()
  {
    AppMethodBeat.i(282958);
    if (bEP() != null)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "destroyServiceAdComponentView");
      bEP().bEU();
    }
    AppMethodBeat.o(282958);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.m.o paramo, com.tencent.mm.plugin.appbrand.service.c paramc, t paramt)
  {
    AppMethodBeat.i(282951);
    this.nAI.nxs = paramt;
    paramc.qOE = true;
    paramt = new f();
    paramt.source = "launch";
    paramt.a(paramc, null, paramo);
    this.nAJ = 8;
    AppMethodBeat.o(282951);
  }
  
  public final void acm(String paramString)
  {
    AppMethodBeat.i(282954);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).a(bEP());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).a(bEP());
      paramString = this.nAH;
      Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, reset orientation", new Object[] { paramString.mAppId });
      if ((paramString.bBX() != null) && (paramString.bBX().getPageView() != null))
      {
        localObject = (com.tencent.mm.plugin.appbrand.page.a.d)paramString.bBX().getPageView().R(com.tencent.mm.plugin.appbrand.page.a.d.class);
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).PR();
          Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, request orientation:%s", new Object[] { paramString.mAppId, str });
          if (!Util.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).a(null);
          }
        }
      }
      bEW();
      com.tencent.mm.plugin.appbrand.report.quality.b.L(this.nAH);
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onSplashAdViewContainerHide");
      this.nAP = true;
      bEU();
      bEV();
    }
    AppMethodBeat.o(282954);
  }
  
  public final void acn(String paramString)
  {
    AppMethodBeat.i(282962);
    if (this.nAK != null)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "stopCheckShowAdTimeoutTick, appId:%s, reason:%s, realTime:%s", new Object[] { this.nAH.mAppId, paramString, Long.valueOf(Util.nowMilliSecond() - this.nAN) });
      this.nAO = true;
      this.nAK.stopTimer();
      this.nAK = null;
    }
    bEX();
    AppMethodBeat.o(282962);
  }
  
  final ab bEO()
  {
    AppMethodBeat.i(282949);
    if ((this.nAH.bCz() instanceof ab))
    {
      ab localab = (ab)this.nAH.bCz();
      AppMethodBeat.o(282949);
      return localab;
    }
    AppMethodBeat.o(282949);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c bEP()
  {
    AppMethodBeat.i(282950);
    com.tencent.mm.plugin.appbrand.service.c localc;
    if (this.nAI != null)
    {
      localc = this.nAI;
      AppMethodBeat.o(282950);
      return localc;
    }
    if (this.nAH != null)
    {
      localc = this.nAH.bDA();
      AppMethodBeat.o(282950);
      return localc;
    }
    AppMethodBeat.o(282950);
    return null;
  }
  
  public final void bEQ()
  {
    AppMethodBeat.i(282952);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.nAP), Boolean.valueOf(this.nAQ) });
    ab localab = bEO();
    if ((localab != null) && (localab.getInternalLoadingSplash() != null)) {
      localab.getInternalLoadingSplash().x(new a() {});
    }
    AppMethodBeat.o(282952);
  }
  
  public final void bER()
  {
    AppMethodBeat.i(282953);
    com.tencent.mm.plugin.appbrand.ad.a.b localb = new com.tencent.mm.plugin.appbrand.ad.a.b();
    localb.source = "launch";
    localb.type = "close";
    localb.a(bEP());
    q(true, "launch");
    AppMethodBeat.o(282953);
  }
  
  public final void bES()
  {
    AppMethodBeat.i(282955);
    this.nAN = Util.nowMilliSecond();
    this.nAL = new HandlerThread("checkShowAdThread");
    this.nAL.start();
    this.nAK = new MTimerHandler(this.nAL.getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(277265);
        if (h.this.nAO)
        {
          Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer, timer already stopped");
          AppMethodBeat.o(277265);
          return false;
        }
        Log.e("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer timeOut, realTime:%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - h.this.nAN) });
        h.this.bEW();
        h.this.bET();
        h.this.bEX();
        AppMethodBeat.o(277265);
        return false;
      }
    }, false);
    int i = t.bDH();
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer start, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    this.nAO = false;
    this.nAK.startTimer(i);
    AppMethodBeat.o(282955);
  }
  
  public final void bET()
  {
    AppMethodBeat.i(282957);
    ab localab = bEO();
    if (localab != null) {
      localab.cjm();
    }
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideSplashAdImmediately");
    this.nAP = true;
    bEU();
    bEV();
    AppMethodBeat.o(282957);
  }
  
  final void bEV()
  {
    AppMethodBeat.i(282959);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, isSplashAdFinished:%s, isLoadingSplashFinished:%s", new Object[] { Boolean.valueOf(this.nAP), Boolean.valueOf(this.nAQ) });
    if ((this.nAP) && (this.nAQ))
    {
      ab localab = bEO();
      if (localab != null)
      {
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, remove AdLoadingSplash");
        localab.cjn();
      }
    }
    AppMethodBeat.o(282959);
  }
  
  public final void bEW()
  {
    AppMethodBeat.i(282960);
    if (this.nAM != null) {
      this.nAH.T(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(253391);
          if (h.this.nAM != null) {
            h.this.nAM.NO();
          }
          AppMethodBeat.o(253391);
        }
      });
    }
    AppMethodBeat.o(282960);
  }
  
  final void bEX()
  {
    AppMethodBeat.i(282963);
    if (this.nAL != null)
    {
      this.nAL.quitSafely();
      this.nAL = null;
    }
    AppMethodBeat.o(282963);
  }
  
  public final void q(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(282956);
    this.nAH.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(280011);
        ab localab = h.this.bEO();
        if (localab != null) {
          localab.o(paramBoolean, paramString);
        }
        AppMethodBeat.o(280011);
      }
    }, 0L);
    AppMethodBeat.o(282956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.h
 * JD-Core Version:    0.7.0.1
 */