package com.tencent.mm.plugin.appbrand.ad;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.t;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.a.f;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.ui.ai;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.r;

public final class h
  implements j
{
  private final int qAa;
  private final int qAb;
  private final int qAc;
  public com.tencent.mm.plugin.appbrand.b qvK;
  public w qxC;
  public final boolean qzL;
  public com.tencent.mm.plugin.appbrand.service.c qzM;
  public int qzN;
  public MTimerHandler qzO;
  private HandlerThread qzP;
  public i qzQ;
  public long qzR;
  volatile boolean qzS;
  private volatile boolean qzT;
  public volatile boolean qzU;
  public volatile boolean qzV;
  private final int qzW;
  private final int qzX;
  private final int qzY;
  private final int qzZ;
  
  public h(w paramw, com.tencent.mm.plugin.appbrand.b paramb)
  {
    AppMethodBeat.i(321263);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQp, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.qzL = bool;
      this.qzN = 9;
      this.qzS = false;
      this.qzT = false;
      this.qzU = false;
      this.qzV = false;
      this.qzW = 2;
      this.qzX = -2;
      this.qzY = -3;
      this.qzZ = -4;
      this.qAa = 100;
      this.qAb = 1;
      this.qAc = 0;
      this.qxC = paramw;
      this.qvK = paramb;
      AppMethodBeat.o(321263);
      return;
    }
  }
  
  public static t a(r<Long, Long> paramr, t paramt, int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(321274);
    paramt.ilO = ((Long)paramr.bsC).longValue();
    paramt.ilP = ((Long)paramr.bsD).longValue();
    paramt.ilR = paramInt;
    paramt.ilS = paramLong;
    paramr = paramString;
    if (paramString == null) {
      paramr = "";
    }
    paramt.kl(paramr);
    AppMethodBeat.o(321274);
    return paramt;
  }
  
  private void ceh()
  {
    AppMethodBeat.i(321265);
    if (ceb() != null)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "destroyServiceAdComponentView");
      ceb().ceh();
    }
    AppMethodBeat.o(321265);
  }
  
  private void cei()
  {
    AppMethodBeat.i(321268);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, isSplashAdFinished:%s, canLoadingSplashFinish:%s", new Object[] { Boolean.valueOf(this.qzT), Boolean.valueOf(this.qzU) });
    if ((this.qzT) && (this.qzU))
    {
      ai localai = cea();
      if (localai != null)
      {
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, remove AdLoadingSplash");
        if (y(this.qxC)) {
          cel();
        }
        localai.cKn();
      }
    }
    AppMethodBeat.o(321268);
  }
  
  public static boolean y(w paramw)
  {
    AppMethodBeat.i(321279);
    if (u.Uy(paramw.mAppId).quV.qzs == 1)
    {
      AppMethodBeat.o(321279);
      return true;
    }
    AppMethodBeat.o(321279);
    return false;
  }
  
  public final void D(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(321325);
    this.qxC.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(321288);
        ai localai = h.this.cea();
        if (localai != null) {
          localai.B(paramBoolean, paramString);
        }
        AppMethodBeat.o(321288);
      }
    }, 0L);
    AppMethodBeat.o(321325);
  }
  
  public final void UM(String paramString)
  {
    AppMethodBeat.i(321320);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).a(ceb());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).a(ceb());
      paramString = this.qxC;
      Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, reset orientation", new Object[] { paramString.mAppId });
      if ((paramString.getPageContainer() != null) && (paramString.getPageContainer().getPageView() != null))
      {
        localObject = (com.tencent.mm.plugin.appbrand.page.a.d)paramString.getPageContainer().getPageView().aa(com.tencent.mm.plugin.appbrand.page.a.d.class);
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).aqa();
          Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, request orientation:%s", new Object[] { paramString.mAppId, str });
          if (!Util.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.page.a.d)localObject).a(null);
          }
        }
      }
      cec();
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onSplashAdViewContainerHide");
      this.qzT = true;
      cej();
      ceh();
      cei();
    }
    AppMethodBeat.o(321320);
  }
  
  public final void UN(String paramString)
  {
    AppMethodBeat.i(321334);
    if (this.qzO != null)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "stopCheckShowAdTimeoutTick, appId:%s, reason:%s, realTime:%s", new Object[] { this.qxC.mAppId, paramString, Long.valueOf(Util.nowMilliSecond() - this.qzR) });
      this.qzS = true;
      this.qzO.stopTimer();
      this.qzO = null;
    }
    cek();
    AppMethodBeat.o(321334);
  }
  
  public final void a(o paramo, com.tencent.mm.plugin.appbrand.service.c paramc, w paramw)
  {
    AppMethodBeat.i(321297);
    this.qzM.qwG = paramw;
    paramc.tTr = true;
    paramw = new f();
    paramw.source = "launch";
    paramw.a(paramc, null, paramo);
    this.qzN = 8;
    AppMethodBeat.o(321297);
  }
  
  final ai cea()
  {
    AppMethodBeat.i(321285);
    if ((this.qxC.cbM() instanceof ai))
    {
      ai localai = (ai)this.qxC.cbM();
      AppMethodBeat.o(321285);
      return localai;
    }
    AppMethodBeat.o(321285);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c ceb()
  {
    AppMethodBeat.i(321292);
    com.tencent.mm.plugin.appbrand.service.c localc;
    if (this.qzM != null)
    {
      localc = this.qzM;
      AppMethodBeat.o(321292);
      return localc;
    }
    if (this.qxC != null)
    {
      localc = this.qxC.ccO();
      AppMethodBeat.o(321292);
      return localc;
    }
    AppMethodBeat.o(321292);
    return null;
  }
  
  public final void cec()
  {
    AppMethodBeat.i(321306);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "reportSplashAd");
    t localt = u.Uy(this.qxC.mAppId).quW;
    long l1;
    long l2;
    if (localt != null)
    {
      if (!this.qzL) {
        break label207;
      }
      l1 = 1L;
      localt.ima = l1;
      if ((y(this.qxC)) && (this.qzM != null) && (this.qzM.cdn() != null) && (this.qzM.cdn().cds() != null))
      {
        l1 = this.qzM.cdn().cds().uSp;
        l2 = this.qzM.cdn().cds().uSo;
        if (l1 != 0L) {
          break label212;
        }
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "WorkerCreateEarlyTime: -2");
        u.Uy(this.qxC.mAppId).quW.imb = -2L;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.V(this.qxC);
      if ((y(this.qxC)) && (localt != null))
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.j(1754L, 200L, localt.ilY);
        com.tencent.mm.plugin.appbrand.report.quality.b.j(1755L, 500L, localt.ilZ);
      }
      AppMethodBeat.o(321306);
      return;
      label207:
      l1 = 0L;
      break;
      label212:
      if (l2 == 0L)
      {
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "WorkerCreateEarlyTime: -3");
        u.Uy(this.qxC.mAppId).quW.imb = -3L;
      }
      else if (l1 < l2)
      {
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "WorkerCreateEarlyTime: -4");
        u.Uy(this.qxC.mAppId).quW.imb = -4L;
      }
      else
      {
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "WorkerCreateEarlyTime: " + (l1 - l2));
        u.Uy(this.qxC.mAppId).quW.imb = (l1 - l2);
      }
    }
  }
  
  public final void ced()
  {
    AppMethodBeat.i(321308);
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, isSplashAdFinished:%s, canLoadingSplashFinish:%s", new Object[] { Boolean.valueOf(this.qzT), Boolean.valueOf(this.qzU) });
    this.qzU = true;
    if ((!y(this.qxC)) || (this.qzN == 1)) {
      cel();
    }
    cei();
    AppMethodBeat.o(321308);
  }
  
  public final void cee()
  {
    AppMethodBeat.i(321313);
    com.tencent.mm.plugin.appbrand.ad.a.b localb = new com.tencent.mm.plugin.appbrand.ad.a.b();
    localb.source = "launch";
    localb.type = "close";
    localb.a(ceb());
    D(true, "launch");
    AppMethodBeat.o(321313);
  }
  
  public final void cef()
  {
    AppMethodBeat.i(321322);
    this.qzR = Util.nowMilliSecond();
    this.qzP = new HandlerThread("checkShowAdThread");
    this.qzP.start();
    this.qzO = new MTimerHandler(this.qzP.getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(321290);
        if (h.this.qzS)
        {
          Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer, timer already stopped");
          AppMethodBeat.o(321290);
          return false;
        }
        Log.e("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer timeOut, realTime:%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - h.this.qzR) });
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(321260);
            h.this.ceg();
            AppMethodBeat.o(321260);
          }
        });
        h.this.cej();
        h.this.cek();
        AppMethodBeat.o(321290);
        return false;
      }
    }, false);
    int i;
    if (u.Uy(this.qxC.mAppId).quV.qzs != 2)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "NOT PRELOAD SHOW");
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQq, w.ccU());
      if (i <= 0) {}
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer start, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
      this.qzS = false;
      this.qzO.startTimer(i);
      AppMethodBeat.o(321322);
      return;
      i = w.ccU();
      continue;
      Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "PRELOAD SHOW");
      i = w.ccU();
    }
  }
  
  public final void ceg()
  {
    AppMethodBeat.i(321328);
    ai localai = cea();
    if (localai != null) {
      localai.cKm();
    }
    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideSplashAdImmediately");
    this.qzT = true;
    ceh();
    cei();
    AppMethodBeat.o(321328);
  }
  
  public final void cej()
  {
    AppMethodBeat.i(321331);
    if ((this.qzQ != null) && (this.qzV) && (this.qzT)) {
      this.qxC.Z(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(321276);
          if (h.this.qzQ != null) {
            h.this.qzQ.ready();
          }
          AppMethodBeat.o(321276);
        }
      });
    }
    AppMethodBeat.o(321331);
  }
  
  final void cek()
  {
    AppMethodBeat.i(321339);
    if (this.qzP != null)
    {
      this.qzP.quitSafely();
      this.qzP = null;
    }
    AppMethodBeat.o(321339);
  }
  
  public final void cel()
  {
    AppMethodBeat.i(321342);
    ai localai = cea();
    if (localai != null) {
      localai.getInternalLoadingSplash().as(new a() {});
    }
    AppMethodBeat.o(321342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.h
 * JD-Core Version:    0.7.0.1
 */