package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.autogen.mmdata.rpt.st;
import com.tencent.mm.autogen.mmdata.rpt.st.a;
import com.tencent.mm.autogen.mmdata.rpt.su;
import com.tencent.mm.autogen.mmdata.rpt.su.a;
import com.tencent.mm.autogen.mmdata.rpt.sx;
import com.tencent.mm.autogen.mmdata.rpt.sy;
import com.tencent.mm.autogen.mmdata.rpt.sy.a;
import com.tencent.mm.autogen.mmdata.rpt.t;
import com.tencent.mm.autogen.mmdata.rpt.ti;
import com.tencent.mm.autogen.mmdata.rpt.ti.a;
import com.tencent.mm.autogen.mmdata.rpt.tp;
import com.tencent.mm.autogen.mmdata.rpt.tp.a;
import com.tencent.mm.autogen.mmdata.rpt.tp.b;
import com.tencent.mm.autogen.mmdata.rpt.tp.c;
import com.tencent.mm.autogen.mmdata.rpt.tp.d;
import com.tencent.mm.autogen.mmdata.rpt.tp.e;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class b
{
  private static final c tRk;
  private static final HashMap<String, QualitySessionRuntime> tRl;
  private static final a tRm;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      tRk = new c();
      tRl = new HashMap();
      tRm = new a();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void S(com.tencent.mm.plugin.appbrand.w paramw)
  {
    AppMethodBeat.i(48189);
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramw.mAppId, Integer.valueOf(paramw.hashCode()) });
    Object localObject2 = paramw.getInitConfig().qYm;
    ??? = localObject2;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.f.DI(paramw.getInitConfig().uin), paramw.getInitConfig(), paramw.asA().epn);
      paramw.getInitConfig().qYm = ((QualitySession)???);
    }
    localObject2 = f.g((QualitySession)???);
    ((QualitySessionRuntime)localObject2).qxC = paramw;
    ((QualitySessionRuntime)localObject2).ekt = paramw.aqJ();
    ((QualitySessionRuntime)localObject2).tSl = System.currentTimeMillis();
    ((QualitySessionRuntime)localObject2).tSk = paramw.getInitConfig().startTime;
    a.afY(((QualitySessionRuntime)localObject2).eup);
    com.tencent.threadpool.h.ahAA.bm(new b.2((QualitySessionRuntime)localObject2));
    long l;
    if (1 == paramw.getInitConfig().qYn) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).tSz = l;
      synchronized (tRl)
      {
        if (($assertionsDisabled) || (tRl.get(paramw.mAppId) == null)) {
          break;
        }
        paramw = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramw;
      }
      if (paramw.getInitConfig().qYk) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    tRl.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    k.a(paramw.mAppId, new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(48184);
        Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { b.this.mAppId, Integer.valueOf(b.this.hashCode()) });
        b.W(b.this);
        AppMethodBeat.o(48184);
      }
    });
    AppMethodBeat.o(48189);
  }
  
  public static void T(com.tencent.mm.plugin.appbrand.w paramw)
  {
    long l2 = 1L;
    AppMethodBeat.i(321520);
    QualitySessionRuntime localQualitySessionRuntime = aQ(paramw.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramw.mAppId });
      AppMethodBeat.o(321520);
      return;
    }
    su localsu = new su();
    localsu.ilM = localsu.F("InstanceId", localQualitySessionRuntime.eup, true);
    localsu.imT = localsu.F("AppId", localQualitySessionRuntime.appId, true);
    localsu.ind = localQualitySessionRuntime.tSh;
    localsu.jzQ = su.a.oP(localQualitySessionRuntime.tQx);
    localsu.jax = localQualitySessionRuntime.apptype;
    localsu.fO(paramw.getInitConfig().startTime);
    localsu.fP(Util.nowMilliSecond());
    localsu.fN(localsu.jyJ - localsu.jyI);
    localsu.jzR = localsu.F("path", r.cg(Util.nullAsNil(paramw.cby())), true);
    long l1;
    if (localQualitySessionRuntime.tSD)
    {
      l1 = 1L;
      localsu.jys = l1;
      if ((localQualitySessionRuntime.tSq == null) || (!localQualitySessionRuntime.tSq.czT())) {
        break label299;
      }
      l1 = l2;
      label226:
      localsu.jzS = l1;
      localsu.jyp = localQualitySessionRuntime.cJi();
      localsu.jzT = localQualitySessionRuntime.tSz;
      l1 = Util.nowMilliSecond();
      if ((localQualitySessionRuntime.tSp <= 0L) || (l1 <= localQualitySessionRuntime.tSp)) {
        break label304;
      }
    }
    label299:
    label304:
    for (localsu.jzU = l1;; localsu.jzU = 0L)
    {
      localsu.bMH();
      AppMethodBeat.o(321520);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label226;
    }
  }
  
  public static void U(com.tencent.mm.plugin.appbrand.w paramw)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = aQ(paramw.mAppId, false);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    st localst = localQualitySessionRuntime.tSB;
    long l;
    if (localst != null)
    {
      localst.zm(localQualitySessionRuntime.eup);
      localst.zn(localQualitySessionRuntime.appId);
      localst.ind = localQualitySessionRuntime.tSh;
      localst.jzE = st.a.oO(localQualitySessionRuntime.tQx);
      localst.jax = localQualitySessionRuntime.apptype;
      localst.iqr = localQualitySessionRuntime.scene;
      localst.zo(paramw.getInitConfig().username);
      if (!localQualitySessionRuntime.tSD) {
        break label322;
      }
      l = 1L;
      localst.jys = l;
      localst.jyp = localQualitySessionRuntime.cJi();
      localst.zp(j.getNetworkType(MMApplicationContext.getContext()));
      if (!paramw.getInitConfig().epl) {
        break label327;
      }
      l = 1L;
      label160:
      localst.jzF = l;
      if (!localQualitySessionRuntime.tSC) {
        break label332;
      }
      l = 1L;
      label175:
      localst.jzG = l;
      localst.fM(localQualitySessionRuntime.tSk);
      localst.aJa();
      localst.fL(localst.jyJ - localst.jyI);
      if (!localQualitySessionRuntime.tSE) {
        break label337;
      }
      l = 1L;
      label223:
      localst.jzK = l;
      if (!localQualitySessionRuntime.tSF) {
        break label342;
      }
      l = 1L;
      label238:
      localst.jzL = l;
      if (localQualitySessionRuntime.tSq == null) {
        break label347;
      }
    }
    label322:
    label327:
    label332:
    label337:
    label342:
    label347:
    for (localst.jzH = 1L;; localst.jzH = 0L)
    {
      localst.jzI = paramw.ccT();
      localst.jzJ = com.tencent.mm.plugin.appbrand.w.ccU();
      localst.bMH();
      if (Log.getLogLevel() >= 2) {
        Log.i("MicroMsg.AppBrandQualitySystem", "onRuntimeDestroy report 18033 " + localst.aIF());
      }
      AppMethodBeat.o(48195);
      return;
      l = 0L;
      break;
      l = 0L;
      break label160;
      l = 0L;
      break label175;
      l = 0L;
      break label223;
      l = 0L;
      break label238;
    }
  }
  
  public static void V(com.tencent.mm.plugin.appbrand.w paramw)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = aQ(paramw.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.c localc = u.Ux(paramw.mAppId).quV;
    Object localObject = new ti();
    ((ti)localObject).ilM = ((ti)localObject).F("InstanceId", localQualitySessionRuntime.eup, true);
    ((ti)localObject).imT = ((ti)localObject).F("AppId", localQualitySessionRuntime.appId, true);
    ((ti)localObject).ind = localQualitySessionRuntime.tSh;
    ((ti)localObject).jCd = ti.a.oY(localQualitySessionRuntime.tQx);
    ((ti)localObject).jax = localQualitySessionRuntime.apptype;
    ((ti)localObject).iqr = localQualitySessionRuntime.scene;
    ((ti)localObject).gj(localc.qzd);
    ((ti)localObject).gk(localc.qzg);
    ((ti)localObject).gi(localc.qzg - localc.qzd);
    ((ti)localObject).jzI = paramw.ccT();
    ((ti)localObject).jCe = localc.qzd;
    ((ti)localObject).jCf = localc.qzg;
    ((ti)localObject).jCg = (localc.qzg - localc.qzd);
    ((ti)localObject).jCh = localc.qzi;
    ((ti)localObject).jCi = localc.qzj;
    ((ti)localObject).jCj = (localc.qzj - localc.qzi);
    ((ti)localObject).jCk = localc.qzk;
    ((ti)localObject).jCl = localc.qzl;
    ((ti)localObject).jCm = (localc.qzl - localc.qzk);
    ((ti)localObject).jzJ = com.tencent.mm.plugin.appbrand.w.ccU();
    ((ti)localObject).jCr = (localc.qzf - localc.qze);
    ((ti)localObject).jCn = localc.qze;
    ((ti)localObject).jCo = (localc.qze - localc.qzd);
    ((ti)localObject).jCp = localc.qzf;
    ((ti)localObject).jCq = (localc.qzg - localc.qzf);
    ((ti)localObject).jCs = paramw.ccW();
    ((ti)localObject).jCt = localc.qzm;
    ((ti)localObject).jCu = localc.qzh;
    ((ti)localObject).jCv = localc.qzo;
    ((ti)localObject).jCw = localc.qzp;
    ((ti)localObject).jCx = localc.qzq;
    ((ti)localObject).jCy = localc.qzr;
    ((ti)localObject).jCz = (localc.qzr - localc.qzo);
    ((ti)localObject).jCA = (localc.qzq - localc.qzp);
    ((ti)localObject).jCC = com.tencent.mm.plugin.appbrand.w.ccU();
    ((ti)localObject).jCB = com.tencent.mm.plugin.appbrand.w.ccV();
    ((ti)localObject).jCD = 1L;
    if (paramw.cbl() != null) {}
    for (long l = paramw.cbl().cfG();; l = 0L)
    {
      ((ti)localObject).jCE = l;
      ((ti)localObject).iEy = ((ti)localObject).F("networkType", j.getNetworkType(MMApplicationContext.getContext()), true);
      ((ti)localObject).jCF = localc.qzs;
      ((ti)localObject).jCH = localc.qzc;
      ((ti)localObject).bMH();
      Log.d("MicroMsg.AppBrandQualitySystem", "WeAppQualitySplashAdStruct:" + ((ti)localObject).aIF());
      localObject = u.Uy(paramw.mAppId).quW;
      if (localObject != null)
      {
        ((t)localObject).ilM = ((t)localObject).F("InstanceId", localQualitySessionRuntime.eup, true);
        ((t)localObject).ilT = (localc.qzg - localc.qzd);
        ((t)localObject).ilV = paramw.ccT();
        paramw = paramw.qvK;
        ((t)localObject).ilQ = localc.qzs;
        ((t)localObject).imc = localc.qzt;
        if (paramw != null)
        {
          ((t)localObject).ilW = paramw.qqW;
          ((t)localObject).ilX = paramw.qqX;
        }
        ((t)localObject).bMH();
      }
      AppMethodBeat.o(160613);
      return;
    }
  }
  
  public static void a(g paramg, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(321562);
    String str = paramg.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = aQ(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(321562);
      return;
    }
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.qxC.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.qxC.hashCode())
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        paramg = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(321562);
        throw paramg;
      }
      AppMethodBeat.o(321562);
      return;
    }
    sx localsx = new sx();
    localsx.imT = localsx.F("AppId", localQualitySessionRuntime.appId, true);
    localsx.ilM = localsx.F("InstanceId", localQualitySessionRuntime.eup, true);
    localsx.ine = localQualitySessionRuntime.tQx;
    localsx.jax = localQualitySessionRuntime.apptype;
    localsx.ind = localQualitySessionRuntime.tSh;
    localsx.iqr = localQualitySessionRuntime.scene;
    localsx.fT(paramLong);
    localsx.aJc();
    localsx.fS(localsx.jyJ - localsx.jyI);
    localsx.jAh = paramInt1;
    localsx.jAi = localsx.F("filePath", paramString1, true);
    e locale = e.f(paramg.getJsRuntime());
    label390:
    boolean bool;
    switch (5.tRq[locale.ordinal()])
    {
    default: 
      paramInt1 = 0;
      localsx.jAj = paramInt1;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < v.sTm.length))
      {
        paramLong = v.sTm[paramc.codeCacheStatus];
        localsx.jAk = paramLong;
        if (!(paramg instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label950;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramg).esM.apj();
        label416:
        if (!bool) {
          break label981;
        }
        paramLong = 1L;
        label424:
        localsx.jAl = paramLong;
        if (paramc == null) {
          break label987;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localsx.jAm = paramLong;
        if (!org.apache.commons.c.a.contains(e.tNF, locale)) {
          break label993;
        }
        localsx.zq(V8.getV8Version());
        label470:
        localsx.jAn = localsx.F("pluginAppid", paramString2, true);
        localsx.jAo = localsx.F("pluginVersion", String.valueOf(paramInt2), true);
        localsx.bMH();
        if ((paramg instanceof com.tencent.mm.plugin.appbrand.y))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.u.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localsx.jyI;
          paramString2.endTime = localsx.jyJ;
          paramString2.y("fileName", localsx.jAi);
          paramString2.y("size", Long.valueOf(localsx.jAh));
          paramString2.q((com.tencent.mm.plugin.appbrand.y)paramg);
        }
        if ((!localQualitySessionRuntime.tSs.tRr) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.tSs.tRr = true;
          localQualitySessionRuntime.tSn = System.currentTimeMillis();
          paramg = localQualitySessionRuntime.qxC;
          paramString1 = new sy();
          paramString2 = aQ(str, true);
          if (paramString2 != null)
          {
            paramString1.imT = paramString1.F("AppId", paramString2.appId, true);
            paramString1.ilM = paramString1.F("InstanceId", paramString2.eup, true);
            paramString1.jAp = sy.a.oR(paramString2.tQx);
            paramString1.jax = paramString2.apptype;
            paramString1.ind = paramString2.tSh;
            paramString1.iqr = paramString2.scene;
            paramString1.fV(paramString2.tSk);
            paramString1.aJd();
            paramString1.fU(paramString1.jyJ - paramString2.tSk);
            paramString1.jzR = paramString1.F("path", r.cg(paramg.cby()), true);
            if (!paramg.qvA) {
              break label1028;
            }
            paramLong = 1L;
            label783:
            paramString1.jys = paramLong;
            if (paramString2.tSq == null) {
              break label1040;
            }
            if (!paramString2.tSq.czT()) {
              break label1034;
            }
            paramLong = 1L;
            paramString1.jzS = paramLong;
          }
        }
      }
      break;
    }
    label950:
    label981:
    label987:
    label993:
    while (!BuildInfo.DEBUG) {
      for (;;)
      {
        paramString1.jyp = paramString2.cJi();
        paramString1.iEy = paramString1.F("networkType", com.tencent.mm.plugin.appbrand.report.w.fg(MMApplicationContext.getContext()), true);
        paramString1.jzT = paramString2.tSz;
        paramString1.jAq = paramString2.cJl();
        paramString1.bMH();
        if (DebuggerShell.cls()) {
          com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localsx.jyI, localsx.jyJ);
        }
        AppMethodBeat.o(321562);
        return;
        paramInt1 = 102;
        break;
        paramInt1 = 103;
        break;
        paramInt1 = 104;
        break;
        paramInt1 = 6;
        break;
        paramInt1 = 5;
        break;
        paramInt1 = 4;
        break;
        paramInt1 = 3;
        break;
        paramInt1 = 2;
        break;
        paramInt1 = 1;
        break;
        paramLong = 4L;
        break label390;
        if ((paramg instanceof ah))
        {
          bool = ((ah)paramg).ccO().esM.apj();
          break label416;
        }
        bool = false;
        break label416;
        paramLong = 0L;
        break label424;
        paramLong = 0L;
        break label443;
        if (!(paramg.getJsRuntime() instanceof bd)) {
          break label470;
        }
        localsx.zq(c.cJc());
        break label470;
        paramLong = 0L;
        break label783;
        paramLong = 0L;
      }
    }
    label1028:
    label1034:
    label1040:
    paramg = new IllegalStateException("StartupBundle not registered.");
    AppMethodBeat.o(321562);
    throw paramg;
  }
  
  public static void a(String paramString, AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, com.tencent.mm.plugin.appbrand.w paramw)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = aQ(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.tSm = System.currentTimeMillis();
    localQualitySessionRuntime1.tSq = paramAppStartupPerformanceReportBundle;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramw.d(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      Log.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    tp localtp;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      o.runOnUiThread(new b.3(localQualitySessionRuntime1, paramAppBrandSysConfigWC));
      AppMethodBeat.o(48192);
      return;
      localtp = new tp();
      localQualitySessionRuntime2 = aQ(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localtp.imT = localtp.F("AppId", localQualitySessionRuntime2.appId, true);
    localtp.ilM = localtp.F("InstanceId", localQualitySessionRuntime2.eup, true);
    localtp.jDZ = tp.a.pg(localQualitySessionRuntime2.tQx);
    localtp.jax = localQualitySessionRuntime2.apptype;
    localtp.iqr = localQualitySessionRuntime2.scene;
    localtp.ind = localQualitySessionRuntime2.tSh;
    localtp.gA(localQualitySessionRuntime2.tSk);
    localtp.aJi();
    localtp.gz(localtp.jyJ - localtp.jyI);
    localtp.jEh = (paramAppStartupPerformanceReportBundle.sYy - paramAppStartupPerformanceReportBundle.sYx);
    localtp.jEi = (paramAppStartupPerformanceReportBundle.sYA - paramAppStartupPerformanceReportBundle.sYz);
    localtp.jEj = localQualitySessionRuntime2.tSi;
    localtp.jEk = paramAppStartupPerformanceReportBundle.sYF;
    Object localObject = paramw.ccM();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramw.getInitConfig();
    label291:
    label309:
    long l1;
    if (paramAppStartupPerformanceReportBundle.sYG)
    {
      paramString = tp.c.jEw;
      localtp.jEb = paramString;
      if (!localAppBrandInitConfigWC.epl) {
        break label607;
      }
      paramString = tp.b.jEt;
      localtp.jEc = paramString;
      if (!paramw.qvA) {
        break label614;
      }
      l1 = 1L;
      label325:
      localtp.jEd = l1;
      long l2 = 0L;
      if (com.tencent.mm.vfs.y.ZC(((AppBrandSysConfigWC)localObject).qYY.pkgPath)) {
        break label620;
      }
      paramString = ((AppBrandSysConfigWC)localObject).qYY.qHR.iterator();
      do
      {
        l1 = l2;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (ModulePkgInfo)paramString.next();
      } while (!com.tencent.mm.vfs.y.ZC(((ModulePkgInfo)localObject).pkgPath));
      l1 = com.tencent.mm.vfs.y.bEl(((ModulePkgInfo)localObject).pkgPath);
      label406:
      if (!paramw.qvA) {
        break label636;
      }
      label413:
      localtp.jEa = l1;
      localtp.iVU = f.getNetworkType();
      localtp.jzT = localQualitySessionRuntime2.tSz;
      localtp.jyp = localQualitySessionRuntime2.cJi();
      localtp.gB(localQualitySessionRuntime2.tSq.sYw - localQualitySessionRuntime2.tSq.sXY);
      if (!paramAppStartupPerformanceReportBundle.sYH) {
        break label642;
      }
      paramString = tp.e.jEC;
      label483:
      localtp.jEl = paramString;
      localtp.jEm = (paramAppStartupPerformanceReportBundle.sYC - paramAppStartupPerformanceReportBundle.sYB);
      if (!paramAppStartupPerformanceReportBundle.sYI) {
        break label649;
      }
    }
    label642:
    label649:
    for (paramString = tp.d.jEz;; paramString = tp.d.jEA)
    {
      localtp.jEn = paramString;
      localtp.jEo = (paramAppStartupPerformanceReportBundle.sYE - paramAppStartupPerformanceReportBundle.sYD);
      localtp.jAq = localQualitySessionRuntime2.cJl();
      localtp.jCW = localtp.F("NetworkTypeStr", j.getNetworkType(MMApplicationContext.getContext()), true);
      localtp.bMH();
      if (!DebuggerShell.cls()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localtp.imT, "ResourcePrepare", localtp.jyI, localtp.jyJ);
      break;
      paramString = tp.c.jEx;
      break label291;
      label607:
      paramString = tp.b.jEu;
      break label309;
      label614:
      l1 = 0L;
      break label325;
      label620:
      l1 = com.tencent.mm.vfs.y.bEl(((AppBrandSysConfigWC)localObject).qYY.pkgPath);
      break label406;
      label636:
      l1 = 0L;
      break label413;
      paramString = tp.e.jED;
      break label483;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(48193);
    o.runOnUiThread(new b.4(paramString, paramb));
    AppMethodBeat.o(48193);
  }
  
  /* Error */
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.w paramw)
  {
    // Byte code:
    //   0: ldc_w 1277
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 228	com/tencent/mm/plugin/appbrand/report/quality/b:aQ	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +26 -> 41
    //   18: ldc 64
    //   20: ldc_w 1279
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1277
    //   37: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 64
    //   43: ldc_w 1281
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 5
    //   59: aconst_null
    //   60: putfield 356	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSB	Lcom/tencent/mm/autogen/mmdata/rpt/st;
    //   63: new 1283	com/tencent/mm/autogen/mmdata/rpt/sz
    //   66: dup
    //   67: invokespecial 1284	com/tencent/mm/autogen/mmdata/rpt/sz:<init>	()V
    //   70: astore 4
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 228	com/tencent/mm/plugin/appbrand/report/quality/b:aQ	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +564 -> 645
    //   84: aload 4
    //   86: aload 4
    //   88: ldc 246
    //   90: aload 6
    //   92: getfield 211	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1285	com/tencent/mm/autogen/mmdata/rpt/sz:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1286	com/tencent/mm/autogen/mmdata/rpt/sz:imT	Ljava/lang/String;
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 237
    //   108: aload 6
    //   110: getfield 169	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:eup	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1285	com/tencent/mm/autogen/mmdata/rpt/sz:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1287	com/tencent/mm/autogen/mmdata/rpt/sz:ilM	Ljava/lang/String;
    //   120: aload 4
    //   122: aload 6
    //   124: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tQx	I
    //   127: invokestatic 1293	com/tencent/mm/autogen/mmdata/rpt/sz$a:oS	(I)Lcom/tencent/mm/autogen/mmdata/rpt/sz$a;
    //   130: putfield 1297	com/tencent/mm/autogen/mmdata/rpt/sz:jAv	Lcom/tencent/mm/autogen/mmdata/rpt/sz$a;
    //   133: aload 4
    //   135: aload 6
    //   137: getfield 271	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1298	com/tencent/mm/autogen/mmdata/rpt/sz:jax	J
    //   144: aload 4
    //   146: aload 6
    //   148: getfield 252	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSh	I
    //   151: i2l
    //   152: putfield 1299	com/tencent/mm/autogen/mmdata/rpt/sz:ind	J
    //   155: aload 4
    //   157: aload 6
    //   159: getfield 380	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1300	com/tencent/mm/autogen/mmdata/rpt/sz:iqr	J
    //   166: aload 4
    //   168: aload 6
    //   170: getfield 166	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSk	J
    //   173: invokevirtual 1304	com/tencent/mm/autogen/mmdata/rpt/sz:fX	(J)Lcom/tencent/mm/autogen/mmdata/rpt/sz;
    //   176: pop
    //   177: aload 4
    //   179: invokevirtual 1308	com/tencent/mm/autogen/mmdata/rpt/sz:aJe	()Lcom/tencent/mm/autogen/mmdata/rpt/sz;
    //   182: pop
    //   183: aload 4
    //   185: aload 4
    //   187: getfield 1309	com/tencent/mm/autogen/mmdata/rpt/sz:jyJ	J
    //   190: aload 4
    //   192: getfield 1310	com/tencent/mm/autogen/mmdata/rpt/sz:jyI	J
    //   195: lsub
    //   196: invokevirtual 1313	com/tencent/mm/autogen/mmdata/rpt/sz:fW	(J)Lcom/tencent/mm/autogen/mmdata/rpt/sz;
    //   199: pop
    //   200: aload 4
    //   202: aload 4
    //   204: ldc_w 298
    //   207: aload_1
    //   208: invokevirtual 1317	com/tencent/mm/plugin/appbrand/w:ccN	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   211: invokevirtual 1322	com/tencent/mm/plugin/appbrand/page/y:getCurrentUrl	()Ljava/lang/String;
    //   214: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokestatic 311	com/tencent/mm/compatible/util/r:cg	(Ljava/lang/String;)Ljava/lang/String;
    //   220: iconst_1
    //   221: invokevirtual 1285	com/tencent/mm/autogen/mmdata/rpt/sz:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   224: putfield 1323	com/tencent/mm/autogen/mmdata/rpt/sz:jzR	Ljava/lang/String;
    //   227: aload 6
    //   229: getfield 317	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSD	Z
    //   232: ifeq +1074 -> 1306
    //   235: lconst_1
    //   236: lstore_2
    //   237: aload 4
    //   239: lload_2
    //   240: putfield 1324	com/tencent/mm/autogen/mmdata/rpt/sz:jys	J
    //   243: aload 6
    //   245: getfield 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSq	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   248: ifnull +1068 -> 1316
    //   251: aload 6
    //   253: getfield 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSq	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   256: invokevirtual 329	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:czT	()Z
    //   259: ifeq +1052 -> 1311
    //   262: lconst_1
    //   263: lstore_2
    //   264: aload 4
    //   266: lload_2
    //   267: putfield 1325	com/tencent/mm/autogen/mmdata/rpt/sz:jzS	J
    //   270: aload 4
    //   272: aload 6
    //   274: invokevirtual 335	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJi	()J
    //   277: putfield 1326	com/tencent/mm/autogen/mmdata/rpt/sz:jyp	J
    //   280: aload 4
    //   282: ldc_w 1328
    //   285: invokestatic 1334	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   288: checkcast 1328	com/tencent/mm/plugin/expt/b/c
    //   291: getstatic 1340	com/tencent/mm/plugin/expt/b/c$a:yPd	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   294: iconst_0
    //   295: invokeinterface 1343 3 0
    //   300: i2l
    //   301: putfield 1346	com/tencent/mm/autogen/mmdata/rpt/sz:jAy	J
    //   304: aload 4
    //   306: lconst_0
    //   307: putfield 1349	com/tencent/mm/autogen/mmdata/rpt/sz:jAa	J
    //   310: aload 4
    //   312: aload 4
    //   314: ldc_w 665
    //   317: invokestatic 397	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   320: invokestatic 991	com/tencent/mm/plugin/appbrand/report/w:fg	(Landroid/content/Context;)Ljava/lang/String;
    //   323: iconst_1
    //   324: invokevirtual 1285	com/tencent/mm/autogen/mmdata/rpt/sz:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   327: putfield 1350	com/tencent/mm/autogen/mmdata/rpt/sz:iEy	Ljava/lang/String;
    //   330: aload_1
    //   331: invokevirtual 1119	com/tencent/mm/plugin/appbrand/w:ccM	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   334: getfield 1149	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:qYY	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   337: getfield 1354	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHT	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   340: astore 7
    //   342: aload 7
    //   344: ifnull +997 -> 1341
    //   347: aload 7
    //   349: ldc_w 1356
    //   352: invokevirtual 1362	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:VE	(Ljava/lang/String;)Ljava/util/List;
    //   355: astore 7
    //   357: aload 7
    //   359: ifnull +19 -> 378
    //   362: aload 7
    //   364: invokeinterface 1366 1 0
    //   369: ifle +9 -> 378
    //   372: aload 4
    //   374: lconst_1
    //   375: putfield 1369	com/tencent/mm/autogen/mmdata/rpt/sz:jAb	J
    //   378: aload 4
    //   380: aload 6
    //   382: getfield 198	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSz	J
    //   385: putfield 1370	com/tencent/mm/autogen/mmdata/rpt/sz:jzT	J
    //   388: aload 6
    //   390: invokevirtual 1373	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJj	()Z
    //   393: ifeq +957 -> 1350
    //   396: lconst_1
    //   397: lstore_2
    //   398: aload 4
    //   400: lload_2
    //   401: putfield 1376	com/tencent/mm/autogen/mmdata/rpt/sz:jAc	J
    //   404: aload 4
    //   406: aload_1
    //   407: invokevirtual 449	com/tencent/mm/plugin/appbrand/w:ccT	()I
    //   410: i2l
    //   411: putfield 1377	com/tencent/mm/autogen/mmdata/rpt/sz:jzI	J
    //   414: aload_1
    //   415: invokevirtual 93	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   418: getfield 1380	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYo	Z
    //   421: ifeq +934 -> 1355
    //   424: lconst_1
    //   425: lstore_2
    //   426: aload 4
    //   428: lload_2
    //   429: putfield 1383	com/tencent/mm/autogen/mmdata/rpt/sz:jAx	J
    //   432: aload_1
    //   433: invokevirtual 655	com/tencent/mm/plugin/appbrand/w:cbl	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   436: astore 7
    //   438: aload 7
    //   440: ifnull +920 -> 1360
    //   443: aload 4
    //   445: aload 4
    //   447: ldc_w 1385
    //   450: aload 7
    //   452: invokeinterface 1388 1 0
    //   457: iconst_1
    //   458: invokevirtual 1285	com/tencent/mm/autogen/mmdata/rpt/sz:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   461: putfield 1391	com/tencent/mm/autogen/mmdata/rpt/sz:jAw	Ljava/lang/String;
    //   464: aload 4
    //   466: aload 6
    //   468: getfield 344	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSp	J
    //   471: putfield 1392	com/tencent/mm/autogen/mmdata/rpt/sz:jzU	J
    //   474: aload 4
    //   476: aload 6
    //   478: invokevirtual 996	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJl	()J
    //   481: putfield 1393	com/tencent/mm/autogen/mmdata/rpt/sz:jAq	J
    //   484: invokestatic 462	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   487: iconst_1
    //   488: if_icmpgt +23 -> 511
    //   491: ldc 64
    //   493: ldc_w 1395
    //   496: iconst_1
    //   497: anewarray 4	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: aload 4
    //   504: invokevirtual 1398	com/tencent/mm/autogen/mmdata/rpt/sz:aIE	()Ljava/lang/String;
    //   507: aastore
    //   508: invokestatic 1400	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   511: aload_1
    //   512: invokevirtual 1404	com/tencent/mm/plugin/appbrand/w:ccK	()Lcom/tencent/mm/plugin/appbrand/page/ah;
    //   515: astore 7
    //   517: aload 7
    //   519: ifnull +53 -> 572
    //   522: getstatic 1409	com/tencent/mm/plugin/appbrand/report/quality/c$2:tRu	[I
    //   525: aload 7
    //   527: invokestatic 1415	com/tencent/mm/plugin/appbrand/report/q:p	(Lcom/tencent/mm/plugin/appbrand/page/ah;)Lcom/tencent/mm/plugin/appbrand/report/q;
    //   530: invokevirtual 1416	com/tencent/mm/plugin/appbrand/report/q:ordinal	()I
    //   533: iaload
    //   534: tableswitch	default:+30 -> 564, 1:+848->1382, 2:+859->1393, 3:+870->1404, 4:+881->1415
    //   565: iconst_1
    //   566: ldc2_w 1417
    //   569: putfield 1421	com/tencent/mm/autogen/mmdata/rpt/sz:jAz	J
    //   572: aload 4
    //   574: invokevirtual 1422	com/tencent/mm/autogen/mmdata/rpt/sz:bMH	()Z
    //   577: pop
    //   578: invokestatic 1005	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:cls	()Z
    //   581: ifeq +64 -> 645
    //   584: aload 6
    //   586: getfield 317	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSD	Z
    //   589: ifeq +837 -> 1426
    //   592: lconst_1
    //   593: lstore_2
    //   594: ldc_w 1424
    //   597: iconst_2
    //   598: anewarray 4	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: ldc_w 1426
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: lload_2
    //   610: invokestatic 922	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   613: aastore
    //   614: invokestatic 1430	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   617: astore 6
    //   619: aload 4
    //   621: getfield 1286	com/tencent/mm/autogen/mmdata/rpt/sz:imT	Ljava/lang/String;
    //   624: ldc_w 1432
    //   627: ldc_w 1434
    //   630: aload 4
    //   632: getfield 1310	com/tencent/mm/autogen/mmdata/rpt/sz:jyI	J
    //   635: aload 4
    //   637: getfield 1309	com/tencent/mm/autogen/mmdata/rpt/sz:jyJ	J
    //   640: aload 6
    //   642: invokestatic 1437	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   645: new 1439	com/tencent/mm/autogen/mmdata/rpt/ts
    //   648: dup
    //   649: invokespecial 1440	com/tencent/mm/autogen/mmdata/rpt/ts:<init>	()V
    //   652: astore 6
    //   654: aload_0
    //   655: iconst_1
    //   656: invokestatic 228	com/tencent/mm/plugin/appbrand/report/quality/b:aQ	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   659: astore 7
    //   661: aload 7
    //   663: ifnull +285 -> 948
    //   666: aload 7
    //   668: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   671: putfield 1443	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSo	J
    //   674: aload 6
    //   676: aload 6
    //   678: ldc 246
    //   680: aload 7
    //   682: getfield 211	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   685: iconst_1
    //   686: invokevirtual 1444	com/tencent/mm/autogen/mmdata/rpt/ts:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   689: putfield 1445	com/tencent/mm/autogen/mmdata/rpt/ts:imT	Ljava/lang/String;
    //   692: aload 6
    //   694: aload 6
    //   696: ldc 237
    //   698: aload 7
    //   700: getfield 169	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:eup	Ljava/lang/String;
    //   703: iconst_1
    //   704: invokevirtual 1444	com/tencent/mm/autogen/mmdata/rpt/ts:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   707: putfield 1446	com/tencent/mm/autogen/mmdata/rpt/ts:ilM	Ljava/lang/String;
    //   710: aload 6
    //   712: aload 7
    //   714: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tQx	I
    //   717: invokestatic 1452	com/tencent/mm/autogen/mmdata/rpt/ts$a:pi	(I)Lcom/tencent/mm/autogen/mmdata/rpt/ts$a;
    //   720: putfield 1456	com/tencent/mm/autogen/mmdata/rpt/ts:jEN	Lcom/tencent/mm/autogen/mmdata/rpt/ts$a;
    //   723: aload 6
    //   725: aload 7
    //   727: getfield 271	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   730: i2l
    //   731: putfield 1457	com/tencent/mm/autogen/mmdata/rpt/ts:jax	J
    //   734: aload 6
    //   736: aload 7
    //   738: getfield 252	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSh	I
    //   741: i2l
    //   742: putfield 1458	com/tencent/mm/autogen/mmdata/rpt/ts:ind	J
    //   745: aload 6
    //   747: aload 7
    //   749: getfield 380	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   752: i2l
    //   753: putfield 1459	com/tencent/mm/autogen/mmdata/rpt/ts:iqr	J
    //   756: aload_1
    //   757: invokevirtual 123	com/tencent/luggage/sdk/e/d:asA	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
    //   760: getfield 129	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:epn	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
    //   763: ifnonnull +668 -> 1431
    //   766: aconst_null
    //   767: astore 4
    //   769: aload 6
    //   771: aload 6
    //   773: ldc_w 1461
    //   776: aload 4
    //   778: iconst_1
    //   779: invokevirtual 1444	com/tencent/mm/autogen/mmdata/rpt/ts:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   782: putfield 1464	com/tencent/mm/autogen/mmdata/rpt/ts:iXJ	Ljava/lang/String;
    //   785: aload 6
    //   787: aload 7
    //   789: getfield 1037	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSm	J
    //   792: invokevirtual 1468	com/tencent/mm/autogen/mmdata/rpt/ts:gI	(J)Lcom/tencent/mm/autogen/mmdata/rpt/ts;
    //   795: pop
    //   796: aload 6
    //   798: invokevirtual 1472	com/tencent/mm/autogen/mmdata/rpt/ts:aJk	()Lcom/tencent/mm/autogen/mmdata/rpt/ts;
    //   801: pop
    //   802: aload 6
    //   804: aload 6
    //   806: getfield 1473	com/tencent/mm/autogen/mmdata/rpt/ts:jyJ	J
    //   809: aload 7
    //   811: getfield 1037	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSm	J
    //   814: lsub
    //   815: invokevirtual 1476	com/tencent/mm/autogen/mmdata/rpt/ts:gH	(J)Lcom/tencent/mm/autogen/mmdata/rpt/ts;
    //   818: pop
    //   819: aload 6
    //   821: aload 7
    //   823: invokevirtual 335	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJi	()J
    //   826: putfield 1477	com/tencent/mm/autogen/mmdata/rpt/ts:jyp	J
    //   829: aload 6
    //   831: aload 6
    //   833: ldc_w 298
    //   836: aload_1
    //   837: invokevirtual 1317	com/tencent/mm/plugin/appbrand/w:ccN	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   840: invokevirtual 1322	com/tencent/mm/plugin/appbrand/page/y:getCurrentUrl	()Ljava/lang/String;
    //   843: invokestatic 311	com/tencent/mm/compatible/util/r:cg	(Ljava/lang/String;)Ljava/lang/String;
    //   846: iconst_1
    //   847: invokevirtual 1444	com/tencent/mm/autogen/mmdata/rpt/ts:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   850: putfield 1478	com/tencent/mm/autogen/mmdata/rpt/ts:jzR	Ljava/lang/String;
    //   853: aload 6
    //   855: lconst_0
    //   856: putfield 1479	com/tencent/mm/autogen/mmdata/rpt/ts:jAa	J
    //   859: aload 6
    //   861: aload 6
    //   863: ldc_w 665
    //   866: invokestatic 397	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   869: invokestatic 991	com/tencent/mm/plugin/appbrand/report/w:fg	(Landroid/content/Context;)Ljava/lang/String;
    //   872: iconst_1
    //   873: invokevirtual 1444	com/tencent/mm/autogen/mmdata/rpt/ts:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   876: putfield 1480	com/tencent/mm/autogen/mmdata/rpt/ts:iEy	Ljava/lang/String;
    //   879: aload 6
    //   881: aload 7
    //   883: getfield 198	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSz	J
    //   886: putfield 1481	com/tencent/mm/autogen/mmdata/rpt/ts:jzT	J
    //   889: aload 7
    //   891: invokevirtual 1373	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJj	()Z
    //   894: ifeq +552 -> 1446
    //   897: lconst_1
    //   898: lstore_2
    //   899: aload 6
    //   901: lload_2
    //   902: putfield 1482	com/tencent/mm/autogen/mmdata/rpt/ts:jAc	J
    //   905: aload 6
    //   907: aload 7
    //   909: invokevirtual 996	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJl	()J
    //   912: putfield 1483	com/tencent/mm/autogen/mmdata/rpt/ts:jAq	J
    //   915: aload 6
    //   917: invokevirtual 1484	com/tencent/mm/autogen/mmdata/rpt/ts:bMH	()Z
    //   920: pop
    //   921: invokestatic 1005	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:cls	()Z
    //   924: ifeq +24 -> 948
    //   927: aload 6
    //   929: getfield 1445	com/tencent/mm/autogen/mmdata/rpt/ts:imT	Ljava/lang/String;
    //   932: ldc_w 1486
    //   935: aload 6
    //   937: getfield 1487	com/tencent/mm/autogen/mmdata/rpt/ts:jyI	J
    //   940: aload 6
    //   942: getfield 1473	com/tencent/mm/autogen/mmdata/rpt/ts:jyJ	J
    //   945: invokestatic 1013	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   948: new 1489	com/tencent/mm/autogen/mmdata/rpt/sv
    //   951: dup
    //   952: invokespecial 1490	com/tencent/mm/autogen/mmdata/rpt/sv:<init>	()V
    //   955: astore 4
    //   957: aload_0
    //   958: iconst_1
    //   959: invokestatic 228	com/tencent/mm/plugin/appbrand/report/quality/b:aQ	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   962: astore 6
    //   964: aload 6
    //   966: ifnull +259 -> 1225
    //   969: aload 4
    //   971: aload 4
    //   973: ldc 246
    //   975: aload 6
    //   977: getfield 211	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   980: iconst_1
    //   981: invokevirtual 1491	com/tencent/mm/autogen/mmdata/rpt/sv:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   984: putfield 1492	com/tencent/mm/autogen/mmdata/rpt/sv:imT	Ljava/lang/String;
    //   987: aload 4
    //   989: aload 4
    //   991: ldc 237
    //   993: aload 6
    //   995: getfield 169	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:eup	Ljava/lang/String;
    //   998: iconst_1
    //   999: invokevirtual 1491	com/tencent/mm/autogen/mmdata/rpt/sv:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1002: putfield 1493	com/tencent/mm/autogen/mmdata/rpt/sv:ilM	Ljava/lang/String;
    //   1005: aload 4
    //   1007: aload 6
    //   1009: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tQx	I
    //   1012: invokestatic 1499	com/tencent/mm/autogen/mmdata/rpt/sv$a:oQ	(I)Lcom/tencent/mm/autogen/mmdata/rpt/sv$a;
    //   1015: putfield 1503	com/tencent/mm/autogen/mmdata/rpt/sv:jzZ	Lcom/tencent/mm/autogen/mmdata/rpt/sv$a;
    //   1018: aload 4
    //   1020: aload 6
    //   1022: getfield 271	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   1025: i2l
    //   1026: putfield 1504	com/tencent/mm/autogen/mmdata/rpt/sv:jax	J
    //   1029: aload 4
    //   1031: aload 6
    //   1033: getfield 252	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSh	I
    //   1036: i2l
    //   1037: putfield 1505	com/tencent/mm/autogen/mmdata/rpt/sv:ind	J
    //   1040: aload 4
    //   1042: aload 6
    //   1044: getfield 380	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   1047: i2l
    //   1048: putfield 1506	com/tencent/mm/autogen/mmdata/rpt/sv:iqr	J
    //   1051: aload 4
    //   1053: aload 6
    //   1055: getfield 948	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSn	J
    //   1058: invokevirtual 1510	com/tencent/mm/autogen/mmdata/rpt/sv:fR	(J)Lcom/tencent/mm/autogen/mmdata/rpt/sv;
    //   1061: pop
    //   1062: aload 4
    //   1064: invokevirtual 1514	com/tencent/mm/autogen/mmdata/rpt/sv:aJb	()Lcom/tencent/mm/autogen/mmdata/rpt/sv;
    //   1067: pop
    //   1068: aload 4
    //   1070: aload 4
    //   1072: getfield 1515	com/tencent/mm/autogen/mmdata/rpt/sv:jyJ	J
    //   1075: aload 6
    //   1077: getfield 948	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSn	J
    //   1080: lsub
    //   1081: invokevirtual 1518	com/tencent/mm/autogen/mmdata/rpt/sv:fQ	(J)Lcom/tencent/mm/autogen/mmdata/rpt/sv;
    //   1084: pop
    //   1085: aload 4
    //   1087: aload 6
    //   1089: invokevirtual 335	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJi	()J
    //   1092: putfield 1519	com/tencent/mm/autogen/mmdata/rpt/sv:jyp	J
    //   1095: aload 4
    //   1097: aload 4
    //   1099: ldc_w 298
    //   1102: aload_1
    //   1103: invokevirtual 1317	com/tencent/mm/plugin/appbrand/w:ccN	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   1106: invokevirtual 1322	com/tencent/mm/plugin/appbrand/page/y:getCurrentUrl	()Ljava/lang/String;
    //   1109: invokestatic 311	com/tencent/mm/compatible/util/r:cg	(Ljava/lang/String;)Ljava/lang/String;
    //   1112: iconst_1
    //   1113: invokevirtual 1491	com/tencent/mm/autogen/mmdata/rpt/sv:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1116: putfield 1520	com/tencent/mm/autogen/mmdata/rpt/sv:jzR	Ljava/lang/String;
    //   1119: aload 4
    //   1121: lconst_0
    //   1122: putfield 1521	com/tencent/mm/autogen/mmdata/rpt/sv:jAa	J
    //   1125: aload 4
    //   1127: aload 4
    //   1129: ldc_w 665
    //   1132: invokestatic 397	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1135: invokestatic 991	com/tencent/mm/plugin/appbrand/report/w:fg	(Landroid/content/Context;)Ljava/lang/String;
    //   1138: iconst_1
    //   1139: invokevirtual 1491	com/tencent/mm/autogen/mmdata/rpt/sv:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1142: putfield 1522	com/tencent/mm/autogen/mmdata/rpt/sv:iEy	Ljava/lang/String;
    //   1145: aload_1
    //   1146: invokevirtual 1119	com/tencent/mm/plugin/appbrand/w:ccM	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1149: getfield 1149	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:qYY	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1152: getfield 1354	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHT	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1155: astore 7
    //   1157: aload 7
    //   1159: ifnull +292 -> 1451
    //   1162: aload 7
    //   1164: ldc_w 1356
    //   1167: invokevirtual 1362	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:VE	(Ljava/lang/String;)Ljava/util/List;
    //   1170: astore 7
    //   1172: aload 7
    //   1174: ifnull +19 -> 1193
    //   1177: aload 7
    //   1179: invokeinterface 1366 1 0
    //   1184: ifle +9 -> 1193
    //   1187: aload 4
    //   1189: lconst_1
    //   1190: putfield 1523	com/tencent/mm/autogen/mmdata/rpt/sv:jAb	J
    //   1193: aload 4
    //   1195: aload 6
    //   1197: getfield 198	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSz	J
    //   1200: putfield 1524	com/tencent/mm/autogen/mmdata/rpt/sv:jzT	J
    //   1203: aload 6
    //   1205: invokevirtual 1373	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cJj	()Z
    //   1208: ifeq +252 -> 1460
    //   1211: lconst_1
    //   1212: lstore_2
    //   1213: aload 4
    //   1215: lload_2
    //   1216: putfield 1525	com/tencent/mm/autogen/mmdata/rpt/sv:jAc	J
    //   1219: aload 4
    //   1221: invokevirtual 1526	com/tencent/mm/autogen/mmdata/rpt/sv:bMH	()Z
    //   1224: pop
    //   1225: invokestatic 284	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   1228: lstore_2
    //   1229: invokestatic 1005	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:cls	()Z
    //   1232: ifeq +16 -> 1248
    //   1235: aload_0
    //   1236: ldc_w 1528
    //   1239: aload 5
    //   1241: getfield 948	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSn	J
    //   1244: lload_2
    //   1245: invokestatic 1013	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1248: aload 5
    //   1250: getfield 271	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   1253: sipush 1004
    //   1256: if_icmpne +17 -> 1273
    //   1259: aload_1
    //   1260: sipush 205
    //   1263: lload_2
    //   1264: aload 5
    //   1266: getfield 948	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:tSn	J
    //   1269: lsub
    //   1270: invokestatic 1533	com/tencent/mm/plugin/appbrand/performance/AppBrandPerformanceManager:a	(Lcom/tencent/luggage/sdk/e/d;IJ)V
    //   1273: ldc_w 1277
    //   1276: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1279: return
    //   1280: astore 7
    //   1282: ldc 64
    //   1284: ldc_w 1535
    //   1287: iconst_2
    //   1288: anewarray 4	java/lang/Object
    //   1291: dup
    //   1292: iconst_0
    //   1293: aload_0
    //   1294: aastore
    //   1295: dup
    //   1296: iconst_1
    //   1297: aload 7
    //   1299: aastore
    //   1300: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1303: goto -1076 -> 227
    //   1306: lconst_0
    //   1307: lstore_2
    //   1308: goto -1071 -> 237
    //   1311: lconst_0
    //   1312: lstore_2
    //   1313: goto -1049 -> 264
    //   1316: getstatic 768	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1319: ifeq -1049 -> 270
    //   1322: new 770	java/lang/IllegalStateException
    //   1325: dup
    //   1326: ldc_w 1032
    //   1329: invokespecial 773	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1332: astore_0
    //   1333: ldc_w 1277
    //   1336: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1339: aload_0
    //   1340: athrow
    //   1341: aload 4
    //   1343: lconst_0
    //   1344: putfield 1369	com/tencent/mm/autogen/mmdata/rpt/sz:jAb	J
    //   1347: goto -969 -> 378
    //   1350: lconst_0
    //   1351: lstore_2
    //   1352: goto -954 -> 398
    //   1355: lconst_0
    //   1356: lstore_2
    //   1357: goto -931 -> 426
    //   1360: ldc 64
    //   1362: ldc_w 1537
    //   1365: iconst_1
    //   1366: anewarray 4	java/lang/Object
    //   1369: dup
    //   1370: iconst_0
    //   1371: aload_1
    //   1372: getfield 72	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1375: aastore
    //   1376: invokestatic 1540	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1379: goto -915 -> 464
    //   1382: aload 4
    //   1384: ldc2_w 194
    //   1387: putfield 1421	com/tencent/mm/autogen/mmdata/rpt/sz:jAz	J
    //   1390: goto -818 -> 572
    //   1393: aload 4
    //   1395: ldc2_w 1014
    //   1398: putfield 1421	com/tencent/mm/autogen/mmdata/rpt/sz:jAz	J
    //   1401: goto -829 -> 572
    //   1404: aload 4
    //   1406: ldc2_w 1541
    //   1409: putfield 1421	com/tencent/mm/autogen/mmdata/rpt/sz:jAz	J
    //   1412: goto -840 -> 572
    //   1415: aload 4
    //   1417: ldc2_w 1543
    //   1420: putfield 1421	com/tencent/mm/autogen/mmdata/rpt/sz:jAz	J
    //   1423: goto -851 -> 572
    //   1426: lconst_0
    //   1427: lstore_2
    //   1428: goto -834 -> 594
    //   1431: aload_1
    //   1432: invokevirtual 123	com/tencent/luggage/sdk/e/d:asA	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
    //   1435: getfield 129	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:epn	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
    //   1438: getfield 1549	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:hzx	Ljava/lang/String;
    //   1441: astore 4
    //   1443: goto -674 -> 769
    //   1446: lconst_0
    //   1447: lstore_2
    //   1448: goto -549 -> 899
    //   1451: aload 4
    //   1453: lconst_0
    //   1454: putfield 1523	com/tencent/mm/autogen/mmdata/rpt/sv:jAb	J
    //   1457: goto -264 -> 1193
    //   1460: lconst_0
    //   1461: lstore_2
    //   1462: goto -249 -> 1213
    //   1465: astore 7
    //   1467: goto -348 -> 1119
    //   1470: astore 4
    //   1472: goto -619 -> 853
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1475	0	paramString	String
    //   0	1475	1	paramw	com.tencent.mm.plugin.appbrand.w
    //   236	1226	2	l	long
    //   70	1382	4	localObject1	Object
    //   1470	1	4	localException1	java.lang.Exception
    //   11	1254	5	localQualitySessionRuntime	QualitySessionRuntime
    //   77	1127	6	localObject2	Object
    //   340	838	7	localObject3	Object
    //   1280	18	7	localException2	java.lang.Exception
    //   1465	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   200	227	1280	java/lang/Exception
    //   1095	1119	1465	java/lang/Exception
    //   829	853	1470	java/lang/Exception
  }
  
  private static QualitySessionRuntime aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (tRl)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)tRl.get(paramString);
      if (localQualitySessionRuntime != null) {
        break label108;
      }
      paramString = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[] { paramString });
      if ((paramBoolean) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)))
      {
        paramString = new IllegalStateException(paramString);
        AppMethodBeat.o(48191);
        throw paramString;
      }
    }
    Log.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), paramString, new Object[0]);
    label108:
    AppMethodBeat.o(48191);
    return localQualitySessionRuntime;
  }
  
  public static QualitySessionRuntime afZ(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = aQ(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static c cJb()
  {
    return tRk;
  }
  
  public static void j(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(321542);
    if (paramLong3 < paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 1L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 2L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 2L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 3L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 3L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 4L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 4L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 5L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 5L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 6L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 6L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 7L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 7L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 8L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 8L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 9L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 9L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    if (paramLong3 < 10L * paramLong2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 10L, 1L);
      AppMethodBeat.o(321542);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, 11L, 1L);
    AppMethodBeat.o(321542);
  }
  
  public static final class a
  {
    boolean tRr = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */