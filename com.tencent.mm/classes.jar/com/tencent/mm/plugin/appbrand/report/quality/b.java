package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.luggage.game.c.h.1;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.mc;
import com.tencent.mm.g.b.a.mc.a;
import com.tencent.mm.g.b.a.md;
import com.tencent.mm.g.b.a.md.a;
import com.tencent.mm.g.b.a.mg;
import com.tencent.mm.g.b.a.mh;
import com.tencent.mm.g.b.a.mh.a;
import com.tencent.mm.g.b.a.mq;
import com.tencent.mm.g.b.a.mq.a;
import com.tencent.mm.g.b.a.mx;
import com.tencent.mm.g.b.a.mx.a;
import com.tencent.mm.g.b.a.mx.b;
import com.tencent.mm.g.b.a.mx.c;
import com.tencent.mm.g.b.a.mx.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class b
{
  private static final c nKo;
  private static final HashMap<String, QualitySessionRuntime> nKp;
  private static final a nKq;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      nKo = new c();
      nKp = new HashMap();
      nKq = new a();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void H(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(48189);
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramq.mAppId, Integer.valueOf(paramq.hashCode()) });
    Object localObject2 = paramq.bsC().ldW;
    ??? = localObject2;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.b.zF(paramq.bsC().uin), paramq.bsC(), paramq.ON().cyA);
      paramq.bsC().ldW = ((QualitySession)???);
    }
    localObject2 = g.g((QualitySession)???);
    ((QualitySessionRuntime)localObject2).kGW = paramq;
    ((QualitySessionRuntime)localObject2).cuy = paramq.NA();
    ((QualitySessionRuntime)localObject2).nLo = System.currentTimeMillis();
    a.aeT(((QualitySessionRuntime)localObject2).kEY);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48185);
        QualitySessionRuntime localQualitySessionRuntime = this.nKr;
        h.a locala = (h.a)com.tencent.luggage.sdk.g.c.a("MemoryInspector.getMemoryMB", new h.1(com.tencent.luggage.game.c.h.cvz));
        if (locala == null) {}
        for (int i = 0;; i = locala.cvD)
        {
          localQualitySessionRuntime.nLu = i;
          AppMethodBeat.o(48185);
          return;
        }
      }
    });
    long l;
    if (1 == paramq.bsC().ldX) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).nLC = l;
      synchronized (nKp)
      {
        if (($assertionsDisabled) || (nKp.get(paramq.mAppId) == null)) {
          break;
        }
        paramq = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramq;
      }
      if (paramq.bsC().ldU) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    nKp.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    com.tencent.mm.plugin.appbrand.h.a(paramq.mAppId, new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(48184);
        Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.kzl.mAppId, Integer.valueOf(this.kzl.hashCode()) });
        b.L(this.kzl);
        AppMethodBeat.o(48184);
      }
    });
    AppMethodBeat.o(48189);
  }
  
  public static void I(com.tencent.mm.plugin.appbrand.q paramq)
  {
    long l2 = 1L;
    AppMethodBeat.i(227386);
    QualitySessionRuntime localQualitySessionRuntime = aC(paramq.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramq.mAppId });
      AppMethodBeat.o(227386);
      return;
    }
    md localmd = new md();
    localmd.eWb = localmd.x("InstanceId", localQualitySessionRuntime.kEY, true);
    localmd.eJx = localmd.x("AppId", localQualitySessionRuntime.appId, true);
    localmd.eXc = localQualitySessionRuntime.nLk;
    localmd.fbl = md.a.mr(localQualitySessionRuntime.nJE);
    localmd.eYW = localQualitySessionRuntime.apptype;
    localmd.vM(paramq.bsC().startTime);
    localmd.vN(Util.nowMilliSecond());
    localmd.vL(localmd.fae - localmd.fad);
    localmd.fbm = localmd.x("path", com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramq.brs())), true);
    long l1;
    if (localQualitySessionRuntime.nLG)
    {
      l1 = 1L;
      localmd.eZN = l1;
      if ((localQualitySessionRuntime.nLt == null) || (!localQualitySessionRuntime.nLt.bNr())) {
        break label299;
      }
      l1 = l2;
      label226:
      localmd.fbn = l1;
      localmd.eZK = localQualitySessionRuntime.bVg();
      localmd.fbo = localQualitySessionRuntime.nLC;
      l1 = Util.nowMilliSecond();
      if ((localQualitySessionRuntime.nLs <= 0L) || (l1 <= localQualitySessionRuntime.nLs)) {
        break label304;
      }
    }
    label299:
    label304:
    for (localmd.fbp = l1;; localmd.fbp = 0L)
    {
      localmd.bfK();
      AppMethodBeat.o(227386);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label226;
    }
  }
  
  public static void J(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = aC(paramq.mAppId, false);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    mc localmc = localQualitySessionRuntime.nLE;
    long l;
    if (localmc != null)
    {
      localmc.zp(localQualitySessionRuntime.kEY);
      localmc.zq(localQualitySessionRuntime.appId);
      localmc.eXc = localQualitySessionRuntime.nLk;
      localmc.fba = mc.a.mq(localQualitySessionRuntime.nJE);
      localmc.eYW = localQualitySessionRuntime.apptype;
      localmc.erW = localQualitySessionRuntime.scene;
      localmc.zr(paramq.bsC().username);
      if (!localQualitySessionRuntime.nLG) {
        break label277;
      }
      l = 1L;
      localmc.eZN = l;
      localmc.eZK = localQualitySessionRuntime.bVg();
      localmc.zs(com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext()));
      if (!paramq.bsC().cyy) {
        break label282;
      }
      l = 1L;
      label160:
      localmc.fbb = l;
      if (!localQualitySessionRuntime.nLF) {
        break label287;
      }
      l = 1L;
      label175:
      localmc.fbc = l;
      localmc.vJ(paramq.bsC().startTime);
      localmc.aiX();
      localmc.vH(localmc.fae - localmc.fad);
      if (!localQualitySessionRuntime.nLH) {
        break label292;
      }
      l = 1L;
      label226:
      localmc.fbg = l;
      if (localQualitySessionRuntime.nLt == null) {
        break label297;
      }
    }
    label277:
    label282:
    label287:
    label292:
    label297:
    for (localmc.fbd = 1L;; localmc.fbd = 0L)
    {
      localmc.fbe = paramq.bsJ();
      localmc.fbf = com.tencent.mm.plugin.appbrand.q.bsK();
      localmc.bfK();
      AppMethodBeat.o(48195);
      return;
      l = 0L;
      break;
      l = 0L;
      break label160;
      l = 0L;
      break label175;
      l = 0L;
      break label226;
    }
  }
  
  public static void K(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = aC(paramq.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.c localc = p.Um(paramq.mAppId).kCO;
    mq localmq = new mq();
    localmq.eWb = localmq.x("InstanceId", localQualitySessionRuntime.kEY, true);
    localmq.eJx = localmq.x("AppId", localQualitySessionRuntime.appId, true);
    localmq.eXc = localQualitySessionRuntime.nLk;
    localmq.fdo = mq.a.mB(localQualitySessionRuntime.nJE);
    localmq.eYW = localQualitySessionRuntime.apptype;
    localmq.erW = localQualitySessionRuntime.scene;
    localmq.wA(localc.kGs);
    localmq.wB(localc.kGv);
    localmq.wz(localc.kGv - localc.kGs);
    localmq.fbe = paramq.bsJ();
    localmq.fdp = localc.kGs;
    localmq.fdq = localc.kGv;
    localmq.fdr = (localc.kGv - localc.kGs);
    localmq.fds = localc.kGx;
    localmq.fdt = localc.kGy;
    localmq.fdu = (localc.kGy - localc.kGx);
    localmq.fdv = localc.kGz;
    localmq.fdw = localc.kGA;
    localmq.fdx = (localc.kGA - localc.kGz);
    localmq.fbf = com.tencent.mm.plugin.appbrand.q.bsK();
    localmq.fdC = (localc.kGu - localc.kGt);
    localmq.fdy = localc.kGt;
    localmq.fdz = (localc.kGt - localc.kGs);
    localmq.fdA = localc.kGu;
    localmq.fdB = (localc.kGv - localc.kGu);
    localmq.fdD = paramq.bsM();
    localmq.fdE = localc.kGB;
    localmq.fdF = localc.kGw;
    localmq.fdG = localc.kGD;
    localmq.fdH = localc.kGE;
    localmq.fdI = localc.kGF;
    localmq.fdJ = localc.kGG;
    localmq.fdK = (localc.kGG - localc.kGD);
    localmq.fdL = (localc.kGF - localc.kGE);
    localmq.fdN = com.tencent.mm.plugin.appbrand.q.bsK();
    localmq.fdM = com.tencent.mm.plugin.appbrand.q.bsL();
    localmq.fdO = 1L;
    if (paramq.bqZ() != null) {}
    for (long l = paramq.bqZ().bvd();; l = 0L)
    {
      localmq.fdP = l;
      localmq.bfK();
      AppMethodBeat.o(160613);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(227387);
    String str = paramd.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = aC(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(227387);
      return;
    }
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.kGW.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.kGW.hashCode())
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        paramd = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(227387);
        throw paramd;
      }
      AppMethodBeat.o(227387);
      return;
    }
    mg localmg = new mg();
    localmg.eJx = localmg.x("AppId", localQualitySessionRuntime.appId, true);
    localmg.eWb = localmg.x("InstanceId", localQualitySessionRuntime.kEY, true);
    localmg.fbC = localQualitySessionRuntime.nJE;
    localmg.eYW = localQualitySessionRuntime.apptype;
    localmg.eXc = localQualitySessionRuntime.nLk;
    localmg.erW = localQualitySessionRuntime.scene;
    localmg.vR(paramLong);
    localmg.ajd();
    localmg.vQ(localmg.fae - localmg.fad);
    localmg.fbD = paramInt1;
    localmg.fbE = localmg.x("filePath", paramString1, true);
    e locale = e.d(paramd.getJsRuntime());
    label390:
    boolean bool;
    switch (5.nKu[locale.ordinal()])
    {
    default: 
      paramInt1 = 0;
      localmg.fbF = paramInt1;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < v.mNV.length))
      {
        paramLong = v.mNV[paramc.codeCacheStatus];
        localmg.fbG = paramLong;
        if (!(paramd instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label950;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramd).cBj.Mj();
        label416:
        if (!bool) {
          break label981;
        }
        paramLong = 1L;
        label424:
        localmg.fbH = paramLong;
        if (paramc == null) {
          break label987;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localmg.fbI = paramLong;
        if (!org.apache.commons.b.a.contains(e.nGR, locale)) {
          break label993;
        }
        localmg.zv(V8.getV8Version());
        label470:
        localmg.fbJ = localmg.x("pluginAppid", paramString2, true);
        localmg.fbK = localmg.x("pluginVersion", String.valueOf(paramInt2), true);
        localmg.bfK();
        if ((paramd instanceof com.tencent.mm.plugin.appbrand.s))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.q.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localmg.fad;
          paramString2.endTime = localmg.fae;
          paramString2.r("fileName", localmg.fbE);
          paramString2.r("size", Long.valueOf(localmg.fbD));
          paramString2.d((com.tencent.mm.plugin.appbrand.s)paramd);
        }
        if ((!localQualitySessionRuntime.nLv.nKv) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.nLv.nKv = true;
          localQualitySessionRuntime.nLq = System.currentTimeMillis();
          paramd = localQualitySessionRuntime.kGW;
          paramString1 = new mh();
          paramString2 = aC(str, true);
          if (paramString2 != null)
          {
            paramString1.eJx = paramString1.x("AppId", paramString2.appId, true);
            paramString1.eWb = paramString1.x("InstanceId", paramString2.kEY, true);
            paramString1.fbL = mh.a.mt(paramString2.nJE);
            paramString1.eYW = paramString2.apptype;
            paramString1.eXc = paramString2.nLk;
            paramString1.erW = paramString2.scene;
            paramString1.vT(paramString2.nLn);
            paramString1.aje();
            paramString1.vS(paramString1.fae - paramString2.nLn);
            paramString1.fbm = paramString1.x("path", com.tencent.mm.compatible.util.q.encode(paramd.brs()), true);
            if (!paramd.kDl) {
              break label1028;
            }
            paramLong = 1L;
            label783:
            paramString1.eZN = paramLong;
            if (paramString2.nLt == null) {
              break label1040;
            }
            if (!paramString2.nLt.bNr()) {
              break label1034;
            }
            paramLong = 1L;
            paramString1.fbn = paramLong;
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
        paramString1.eZK = paramString2.bVg();
        paramString1.exq = paramString1.x("networkType", t.el(MMApplicationContext.getContext()), true);
        paramString1.fbo = paramString2.nLC;
        paramString1.fbM = paramString2.bVj();
        paramString1.bfK();
        if (DebuggerShell.bAx()) {
          com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localmg.fad, localmg.fae);
        }
        AppMethodBeat.o(227387);
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
        if ((paramd instanceof ag))
        {
          bool = ((ag)paramd).bsE().cBj.Mj();
          break label416;
        }
        bool = false;
        break label416;
        paramLong = 0L;
        break label424;
        paramLong = 0L;
        break label443;
        if (!(paramd.getJsRuntime() instanceof bb)) {
          break label470;
        }
        localmg.zv(c.bVa());
        break label470;
        paramLong = 0L;
        break label783;
        paramLong = 0L;
      }
    }
    label1028:
    label1034:
    label1040:
    paramd = new IllegalStateException("StartupBundle not registered.");
    AppMethodBeat.o(227387);
    throw paramd;
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = aC(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.nLp = System.currentTimeMillis();
    localQualitySessionRuntime1.nLt = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime1.nLn = paramq.bsC().startTime;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramq.d(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      Log.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    mx localmx;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48186);
          if (this.nKr.kGW.isDestroyed())
          {
            AppMethodBeat.o(48186);
            return;
          }
          f localf;
          if (!this.nKr.cuy)
          {
            localf = this.nKr.nLw;
            QualitySessionRuntime localQualitySessionRuntime = this.nKr;
            AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
            Log.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
            int i = localQualitySessionRuntime.kGW.bsC().uin;
            double d1 = localAppBrandSysConfigWC.czd.ldg;
            double d2 = new Random(i ^ System.nanoTime()).nextDouble();
            boolean bool2 = DebuggerShell.bAx();
            if ((d2 <= d1) || (bool2)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              Log.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f] monkeyMode[%b]", new Object[] { Boolean.valueOf(bool1), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(bool2) });
              if (!bool1) {
                break;
              }
              try
              {
                localf.a(localQualitySessionRuntime, localAppBrandSysConfigWC.czd.ldh, f.a.nKF, false);
                return;
              }
              finally
              {
                AppMethodBeat.o(48186);
              }
            }
          }
          AppMethodBeat.o(48186);
        }
      });
      AppMethodBeat.o(48192);
      return;
      localmx = new mx();
      localQualitySessionRuntime2 = aC(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localmx.eJx = localmx.x("AppId", localQualitySessionRuntime2.appId, true);
    localmx.eWb = localmx.x("InstanceId", localQualitySessionRuntime2.kEY, true);
    localmx.ffg = mx.a.mJ(localQualitySessionRuntime2.nJE);
    localmx.eYW = localQualitySessionRuntime2.apptype;
    localmx.erW = localQualitySessionRuntime2.scene;
    localmx.eXc = localQualitySessionRuntime2.nLk;
    localmx.xm(paramq.bsC().startTime);
    localmx.ajm();
    localmx.xl(localmx.fae - paramq.bsC().startTime);
    localmx.ffo = (paramAppStartupPerformanceReportBundle.mSA - paramAppStartupPerformanceReportBundle.mSz);
    localmx.ffp = (paramAppStartupPerformanceReportBundle.mSC - paramAppStartupPerformanceReportBundle.mSB);
    localmx.ffq = localQualitySessionRuntime2.nLl;
    localmx.ffr = paramAppStartupPerformanceReportBundle.mSF;
    Object localObject = paramq.bsB();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramq.bsC();
    label307:
    label325:
    long l1;
    if (paramAppStartupPerformanceReportBundle.mSG)
    {
      paramString = mx.c.ffB;
      localmx.ffi = paramString;
      if (!localAppBrandInitConfigWC.cyy) {
        break label572;
      }
      paramString = mx.b.ffy;
      localmx.ffj = paramString;
      if (!paramq.kDl) {
        break label579;
      }
      l1 = 1L;
      label341:
      localmx.ffk = l1;
      long l2 = 0L;
      if (com.tencent.mm.vfs.s.YS(((AppBrandSysConfigWC)localObject).leE.pkgPath)) {
        break label585;
      }
      paramString = ((AppBrandSysConfigWC)localObject).leE.kNZ.iterator();
      do
      {
        l1 = l2;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (ModulePkgInfo)paramString.next();
      } while (!com.tencent.mm.vfs.s.YS(((ModulePkgInfo)localObject).pkgPath));
      l1 = com.tencent.mm.vfs.s.boW(((ModulePkgInfo)localObject).pkgPath);
      label422:
      if (!paramq.kDl) {
        break label601;
      }
      label429:
      localmx.ffh = l1;
      localmx.eJb = g.getNetworkType();
      localmx.fbo = localQualitySessionRuntime2.nLC;
      localmx.eZK = localQualitySessionRuntime2.bVg();
      localmx.xn(localQualitySessionRuntime2.nLt.mSy - localQualitySessionRuntime2.nLt.mSe);
      if (!paramAppStartupPerformanceReportBundle.mSH) {
        break label607;
      }
    }
    label572:
    label579:
    label585:
    label601:
    label607:
    for (paramString = mx.d.ffE;; paramString = mx.d.ffF)
    {
      localmx.ffs = paramString;
      localmx.fft = (paramAppStartupPerformanceReportBundle.mSE - paramAppStartupPerformanceReportBundle.mSD);
      localmx.fbM = localQualitySessionRuntime2.bVj();
      localmx.bfK();
      if (!DebuggerShell.bAx()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localmx.eJx, "ResourcePrepare", localmx.fad, localmx.fae);
      break;
      paramString = mx.c.ffC;
      break label307;
      paramString = mx.b.ffz;
      break label325;
      l1 = 0L;
      break label341;
      l1 = com.tencent.mm.vfs.s.boW(((AppBrandSysConfigWC)localObject).leE.pkgPath);
      break label422;
      l1 = 0L;
      break label429;
    }
  }
  
  /* Error */
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.q paramq)
  {
    // Byte code:
    //   0: ldc_w 1156
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 225	com/tencent/mm/plugin/appbrand/report/quality/b:aC	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +26 -> 41
    //   18: ldc 70
    //   20: ldc_w 1158
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1156
    //   37: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 70
    //   43: ldc_w 1160
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 4
    //   59: aconst_null
    //   60: putfield 354	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLE	Lcom/tencent/mm/g/b/a/mc;
    //   63: new 1162	com/tencent/mm/g/b/a/mi
    //   66: dup
    //   67: invokespecial 1163	com/tencent/mm/g/b/a/mi:<init>	()V
    //   70: astore 5
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 225	com/tencent/mm/plugin/appbrand/report/quality/b:aC	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +478 -> 559
    //   84: aload 5
    //   86: aload 5
    //   88: ldc 243
    //   90: aload 6
    //   92: getfield 209	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1164	com/tencent/mm/g/b/a/mi:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1165	com/tencent/mm/g/b/a/mi:eJx	Ljava/lang/String;
    //   102: aload 5
    //   104: aload 5
    //   106: ldc 234
    //   108: aload 6
    //   110: getfield 169	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:kEY	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1164	com/tencent/mm/g/b/a/mi:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1166	com/tencent/mm/g/b/a/mi:eWb	Ljava/lang/String;
    //   120: aload 5
    //   122: aload 6
    //   124: getfield 255	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nJE	I
    //   127: invokestatic 1172	com/tencent/mm/g/b/a/mi$a:mu	(I)Lcom/tencent/mm/g/b/a/mi$a;
    //   130: putfield 1176	com/tencent/mm/g/b/a/mi:fbR	Lcom/tencent/mm/g/b/a/mi$a;
    //   133: aload 5
    //   135: aload 6
    //   137: getfield 268	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1177	com/tencent/mm/g/b/a/mi:eYW	J
    //   144: aload 5
    //   146: aload 6
    //   148: getfield 249	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLk	I
    //   151: i2l
    //   152: putfield 1178	com/tencent/mm/g/b/a/mi:eXc	J
    //   155: aload 5
    //   157: aload 6
    //   159: getfield 378	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1179	com/tencent/mm/g/b/a/mi:erW	J
    //   166: aload 5
    //   168: aload_1
    //   169: invokevirtual 99	com/tencent/mm/plugin/appbrand/q:bsC	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   172: getfield 274	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   175: invokevirtual 1183	com/tencent/mm/g/b/a/mi:vV	(J)Lcom/tencent/mm/g/b/a/mi;
    //   178: pop
    //   179: aload 5
    //   181: invokevirtual 1187	com/tencent/mm/g/b/a/mi:ajf	()Lcom/tencent/mm/g/b/a/mi;
    //   184: pop
    //   185: aload 5
    //   187: aload 5
    //   189: getfield 1188	com/tencent/mm/g/b/a/mi:fae	J
    //   192: aload 5
    //   194: getfield 1189	com/tencent/mm/g/b/a/mi:fad	J
    //   197: lsub
    //   198: invokevirtual 1192	com/tencent/mm/g/b/a/mi:vU	(J)Lcom/tencent/mm/g/b/a/mi;
    //   201: pop
    //   202: aload 5
    //   204: aload 5
    //   206: ldc_w 297
    //   209: aload_1
    //   210: invokevirtual 1196	com/tencent/mm/plugin/appbrand/q:bsD	()Lcom/tencent/mm/plugin/appbrand/page/x;
    //   213: invokevirtual 1201	com/tencent/mm/plugin/appbrand/page/x:getCurrentUrl	()Ljava/lang/String;
    //   216: invokestatic 305	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 310	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: iconst_1
    //   223: invokevirtual 1164	com/tencent/mm/g/b/a/mi:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   226: putfield 1202	com/tencent/mm/g/b/a/mi:fbm	Ljava/lang/String;
    //   229: aload 6
    //   231: getfield 316	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLG	Z
    //   234: ifeq +957 -> 1191
    //   237: lconst_1
    //   238: lstore_2
    //   239: aload 5
    //   241: lload_2
    //   242: putfield 1203	com/tencent/mm/g/b/a/mi:eZN	J
    //   245: aload 6
    //   247: getfield 323	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLt	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   250: ifnull +951 -> 1201
    //   253: aload 6
    //   255: getfield 323	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLt	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   258: invokevirtual 328	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:bNr	()Z
    //   261: ifeq +935 -> 1196
    //   264: lconst_1
    //   265: lstore_2
    //   266: aload 5
    //   268: lload_2
    //   269: putfield 1204	com/tencent/mm/g/b/a/mi:fbn	J
    //   272: aload 5
    //   274: aload 6
    //   276: invokevirtual 334	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVg	()J
    //   279: putfield 1205	com/tencent/mm/g/b/a/mi:eZK	J
    //   282: aload 5
    //   284: ldc_w 1207
    //   287: invokestatic 1213	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   290: checkcast 1207	com/tencent/mm/plugin/expt/b/b
    //   293: getstatic 1219	com/tencent/mm/plugin/expt/b/b$a:rUB	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   296: iconst_0
    //   297: invokeinterface 1222 3 0
    //   302: i2l
    //   303: putfield 1225	com/tencent/mm/g/b/a/mi:fbU	J
    //   306: aload 5
    //   308: lconst_0
    //   309: putfield 1228	com/tencent/mm/g/b/a/mi:fbv	J
    //   312: aload 5
    //   314: aload 5
    //   316: ldc_w 894
    //   319: invokestatic 395	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   322: invokestatic 899	com/tencent/mm/plugin/appbrand/report/t:el	(Landroid/content/Context;)Ljava/lang/String;
    //   325: iconst_1
    //   326: invokevirtual 1164	com/tencent/mm/g/b/a/mi:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   329: putfield 1229	com/tencent/mm/g/b/a/mi:exq	Ljava/lang/String;
    //   332: aload_1
    //   333: invokevirtual 1032	com/tencent/mm/plugin/appbrand/q:bsB	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   336: getfield 1062	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:leE	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   339: getfield 1233	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:kOb	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   342: astore 7
    //   344: aload 7
    //   346: ifnull +880 -> 1226
    //   349: aload 7
    //   351: ldc_w 1235
    //   354: invokevirtual 1241	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Vz	(Ljava/lang/String;)Ljava/util/List;
    //   357: astore 7
    //   359: aload 7
    //   361: ifnull +19 -> 380
    //   364: aload 7
    //   366: invokeinterface 1245 1 0
    //   371: ifle +9 -> 380
    //   374: aload 5
    //   376: lconst_1
    //   377: putfield 1248	com/tencent/mm/g/b/a/mi:fbw	J
    //   380: aload 5
    //   382: aload 6
    //   384: getfield 196	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLC	J
    //   387: putfield 1249	com/tencent/mm/g/b/a/mi:fbo	J
    //   390: aload 6
    //   392: invokevirtual 1252	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVh	()Z
    //   395: ifeq +840 -> 1235
    //   398: lconst_1
    //   399: lstore_2
    //   400: aload 5
    //   402: lload_2
    //   403: putfield 1255	com/tencent/mm/g/b/a/mi:fbx	J
    //   406: aload 5
    //   408: aload_1
    //   409: invokevirtual 441	com/tencent/mm/plugin/appbrand/q:bsJ	()I
    //   412: i2l
    //   413: putfield 1256	com/tencent/mm/g/b/a/mi:fbe	J
    //   416: aload_1
    //   417: invokevirtual 99	com/tencent/mm/plugin/appbrand/q:bsC	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   420: getfield 1259	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:ldY	Z
    //   423: ifeq +817 -> 1240
    //   426: lconst_1
    //   427: lstore_2
    //   428: aload 5
    //   430: lload_2
    //   431: putfield 1262	com/tencent/mm/g/b/a/mi:fbT	J
    //   434: aload_1
    //   435: invokevirtual 626	com/tencent/mm/plugin/appbrand/q:bqZ	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +803 -> 1245
    //   445: aload 5
    //   447: aload 5
    //   449: ldc_w 1264
    //   452: aload 7
    //   454: invokeinterface 1267 1 0
    //   459: iconst_1
    //   460: invokevirtual 1164	com/tencent/mm/g/b/a/mi:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   463: putfield 1270	com/tencent/mm/g/b/a/mi:fbS	Ljava/lang/String;
    //   466: aload 5
    //   468: aload 6
    //   470: getfield 343	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLs	J
    //   473: putfield 1271	com/tencent/mm/g/b/a/mi:fbp	J
    //   476: aload 5
    //   478: aload 6
    //   480: invokevirtual 906	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVj	()J
    //   483: putfield 1272	com/tencent/mm/g/b/a/mi:fbM	J
    //   486: aload 5
    //   488: invokevirtual 1273	com/tencent/mm/g/b/a/mi:bfK	()Z
    //   491: pop
    //   492: invokestatic 915	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bAx	()Z
    //   495: ifeq +64 -> 559
    //   498: aload 6
    //   500: getfield 316	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLG	Z
    //   503: ifeq +764 -> 1267
    //   506: lconst_1
    //   507: lstore_2
    //   508: ldc_w 1275
    //   511: iconst_2
    //   512: anewarray 4	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: ldc_w 1277
    //   520: aastore
    //   521: dup
    //   522: iconst_1
    //   523: lload_2
    //   524: invokestatic 826	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   527: aastore
    //   528: invokestatic 1281	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   531: astore 6
    //   533: aload 5
    //   535: getfield 1165	com/tencent/mm/g/b/a/mi:eJx	Ljava/lang/String;
    //   538: ldc_w 1283
    //   541: ldc_w 1285
    //   544: aload 5
    //   546: getfield 1189	com/tencent/mm/g/b/a/mi:fad	J
    //   549: aload 5
    //   551: getfield 1188	com/tencent/mm/g/b/a/mi:fae	J
    //   554: aload 6
    //   556: invokestatic 1288	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   559: new 1290	com/tencent/mm/g/b/a/na
    //   562: dup
    //   563: invokespecial 1291	com/tencent/mm/g/b/a/na:<init>	()V
    //   566: astore 5
    //   568: aload_0
    //   569: iconst_1
    //   570: invokestatic 225	com/tencent/mm/plugin/appbrand/report/quality/b:aC	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   573: astore 6
    //   575: aload 6
    //   577: ifnull +256 -> 833
    //   580: aload 6
    //   582: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   585: putfield 1294	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLr	J
    //   588: aload 5
    //   590: aload 5
    //   592: ldc 243
    //   594: aload 6
    //   596: getfield 209	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   599: iconst_1
    //   600: invokevirtual 1295	com/tencent/mm/g/b/a/na:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   603: putfield 1296	com/tencent/mm/g/b/a/na:eJx	Ljava/lang/String;
    //   606: aload 5
    //   608: aload 5
    //   610: ldc 234
    //   612: aload 6
    //   614: getfield 169	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:kEY	Ljava/lang/String;
    //   617: iconst_1
    //   618: invokevirtual 1295	com/tencent/mm/g/b/a/na:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   621: putfield 1297	com/tencent/mm/g/b/a/na:eWb	Ljava/lang/String;
    //   624: aload 5
    //   626: aload 6
    //   628: getfield 255	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nJE	I
    //   631: invokestatic 1303	com/tencent/mm/g/b/a/na$a:mM	(I)Lcom/tencent/mm/g/b/a/na$a;
    //   634: putfield 1307	com/tencent/mm/g/b/a/na:ffP	Lcom/tencent/mm/g/b/a/na$a;
    //   637: aload 5
    //   639: aload 6
    //   641: getfield 268	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   644: i2l
    //   645: putfield 1308	com/tencent/mm/g/b/a/na:eYW	J
    //   648: aload 5
    //   650: aload 6
    //   652: getfield 249	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLk	I
    //   655: i2l
    //   656: putfield 1309	com/tencent/mm/g/b/a/na:eXc	J
    //   659: aload 5
    //   661: aload 6
    //   663: getfield 378	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   666: i2l
    //   667: putfield 1310	com/tencent/mm/g/b/a/na:erW	J
    //   670: aload 5
    //   672: aload 6
    //   674: getfield 953	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLp	J
    //   677: invokevirtual 1314	com/tencent/mm/g/b/a/na:xx	(J)Lcom/tencent/mm/g/b/a/na;
    //   680: pop
    //   681: aload 5
    //   683: invokevirtual 1318	com/tencent/mm/g/b/a/na:ajo	()Lcom/tencent/mm/g/b/a/na;
    //   686: pop
    //   687: aload 5
    //   689: aload 5
    //   691: getfield 1319	com/tencent/mm/g/b/a/na:fae	J
    //   694: aload 6
    //   696: getfield 953	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLp	J
    //   699: lsub
    //   700: invokevirtual 1322	com/tencent/mm/g/b/a/na:xw	(J)Lcom/tencent/mm/g/b/a/na;
    //   703: pop
    //   704: aload 5
    //   706: aload 6
    //   708: invokevirtual 334	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVg	()J
    //   711: putfield 1323	com/tencent/mm/g/b/a/na:eZK	J
    //   714: aload 5
    //   716: aload 5
    //   718: ldc_w 297
    //   721: aload_1
    //   722: invokevirtual 1196	com/tencent/mm/plugin/appbrand/q:bsD	()Lcom/tencent/mm/plugin/appbrand/page/x;
    //   725: invokevirtual 1201	com/tencent/mm/plugin/appbrand/page/x:getCurrentUrl	()Ljava/lang/String;
    //   728: invokestatic 310	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   731: iconst_1
    //   732: invokevirtual 1295	com/tencent/mm/g/b/a/na:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   735: putfield 1324	com/tencent/mm/g/b/a/na:fbm	Ljava/lang/String;
    //   738: aload 5
    //   740: lconst_0
    //   741: putfield 1325	com/tencent/mm/g/b/a/na:fbv	J
    //   744: aload 5
    //   746: aload 5
    //   748: ldc_w 894
    //   751: invokestatic 395	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   754: invokestatic 899	com/tencent/mm/plugin/appbrand/report/t:el	(Landroid/content/Context;)Ljava/lang/String;
    //   757: iconst_1
    //   758: invokevirtual 1295	com/tencent/mm/g/b/a/na:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   761: putfield 1326	com/tencent/mm/g/b/a/na:exq	Ljava/lang/String;
    //   764: aload 5
    //   766: aload 6
    //   768: getfield 196	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLC	J
    //   771: putfield 1327	com/tencent/mm/g/b/a/na:fbo	J
    //   774: aload 6
    //   776: invokevirtual 1252	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVh	()Z
    //   779: ifeq +493 -> 1272
    //   782: lconst_1
    //   783: lstore_2
    //   784: aload 5
    //   786: lload_2
    //   787: putfield 1328	com/tencent/mm/g/b/a/na:fbx	J
    //   790: aload 5
    //   792: aload 6
    //   794: invokevirtual 906	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVj	()J
    //   797: putfield 1329	com/tencent/mm/g/b/a/na:fbM	J
    //   800: aload 5
    //   802: invokevirtual 1330	com/tencent/mm/g/b/a/na:bfK	()Z
    //   805: pop
    //   806: invokestatic 915	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bAx	()Z
    //   809: ifeq +24 -> 833
    //   812: aload 5
    //   814: getfield 1296	com/tencent/mm/g/b/a/na:eJx	Ljava/lang/String;
    //   817: ldc_w 1332
    //   820: aload 5
    //   822: getfield 1333	com/tencent/mm/g/b/a/na:fad	J
    //   825: aload 5
    //   827: getfield 1319	com/tencent/mm/g/b/a/na:fae	J
    //   830: invokestatic 923	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   833: new 1335	com/tencent/mm/g/b/a/me
    //   836: dup
    //   837: invokespecial 1336	com/tencent/mm/g/b/a/me:<init>	()V
    //   840: astore 5
    //   842: aload_0
    //   843: iconst_1
    //   844: invokestatic 225	com/tencent/mm/plugin/appbrand/report/quality/b:aC	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   847: astore 6
    //   849: aload 6
    //   851: ifnull +259 -> 1110
    //   854: aload 5
    //   856: aload 5
    //   858: ldc 243
    //   860: aload 6
    //   862: getfield 209	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   865: iconst_1
    //   866: invokevirtual 1337	com/tencent/mm/g/b/a/me:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   869: putfield 1338	com/tencent/mm/g/b/a/me:eJx	Ljava/lang/String;
    //   872: aload 5
    //   874: aload 5
    //   876: ldc 234
    //   878: aload 6
    //   880: getfield 169	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:kEY	Ljava/lang/String;
    //   883: iconst_1
    //   884: invokevirtual 1337	com/tencent/mm/g/b/a/me:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   887: putfield 1339	com/tencent/mm/g/b/a/me:eWb	Ljava/lang/String;
    //   890: aload 5
    //   892: aload 6
    //   894: getfield 255	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nJE	I
    //   897: invokestatic 1345	com/tencent/mm/g/b/a/me$a:ms	(I)Lcom/tencent/mm/g/b/a/me$a;
    //   900: putfield 1349	com/tencent/mm/g/b/a/me:fbu	Lcom/tencent/mm/g/b/a/me$a;
    //   903: aload 5
    //   905: aload 6
    //   907: getfield 268	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   910: i2l
    //   911: putfield 1350	com/tencent/mm/g/b/a/me:eYW	J
    //   914: aload 5
    //   916: aload 6
    //   918: getfield 249	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLk	I
    //   921: i2l
    //   922: putfield 1351	com/tencent/mm/g/b/a/me:eXc	J
    //   925: aload 5
    //   927: aload 6
    //   929: getfield 378	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   932: i2l
    //   933: putfield 1352	com/tencent/mm/g/b/a/me:erW	J
    //   936: aload 5
    //   938: aload 6
    //   940: getfield 851	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLq	J
    //   943: invokevirtual 1356	com/tencent/mm/g/b/a/me:vP	(J)Lcom/tencent/mm/g/b/a/me;
    //   946: pop
    //   947: aload 5
    //   949: invokevirtual 1360	com/tencent/mm/g/b/a/me:ajc	()Lcom/tencent/mm/g/b/a/me;
    //   952: pop
    //   953: aload 5
    //   955: aload 5
    //   957: getfield 1361	com/tencent/mm/g/b/a/me:fae	J
    //   960: aload 6
    //   962: getfield 851	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLq	J
    //   965: lsub
    //   966: invokevirtual 1364	com/tencent/mm/g/b/a/me:vO	(J)Lcom/tencent/mm/g/b/a/me;
    //   969: pop
    //   970: aload 5
    //   972: aload 6
    //   974: invokevirtual 334	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVg	()J
    //   977: putfield 1365	com/tencent/mm/g/b/a/me:eZK	J
    //   980: aload 5
    //   982: aload 5
    //   984: ldc_w 297
    //   987: aload_1
    //   988: invokevirtual 1196	com/tencent/mm/plugin/appbrand/q:bsD	()Lcom/tencent/mm/plugin/appbrand/page/x;
    //   991: invokevirtual 1201	com/tencent/mm/plugin/appbrand/page/x:getCurrentUrl	()Ljava/lang/String;
    //   994: invokestatic 310	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   997: iconst_1
    //   998: invokevirtual 1337	com/tencent/mm/g/b/a/me:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1001: putfield 1366	com/tencent/mm/g/b/a/me:fbm	Ljava/lang/String;
    //   1004: aload 5
    //   1006: lconst_0
    //   1007: putfield 1367	com/tencent/mm/g/b/a/me:fbv	J
    //   1010: aload 5
    //   1012: aload 5
    //   1014: ldc_w 894
    //   1017: invokestatic 395	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1020: invokestatic 899	com/tencent/mm/plugin/appbrand/report/t:el	(Landroid/content/Context;)Ljava/lang/String;
    //   1023: iconst_1
    //   1024: invokevirtual 1337	com/tencent/mm/g/b/a/me:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1027: putfield 1368	com/tencent/mm/g/b/a/me:exq	Ljava/lang/String;
    //   1030: aload_1
    //   1031: invokevirtual 1032	com/tencent/mm/plugin/appbrand/q:bsB	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1034: getfield 1062	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:leE	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1037: getfield 1233	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:kOb	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1040: astore 7
    //   1042: aload 7
    //   1044: ifnull +233 -> 1277
    //   1047: aload 7
    //   1049: ldc_w 1235
    //   1052: invokevirtual 1241	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Vz	(Ljava/lang/String;)Ljava/util/List;
    //   1055: astore 7
    //   1057: aload 7
    //   1059: ifnull +19 -> 1078
    //   1062: aload 7
    //   1064: invokeinterface 1245 1 0
    //   1069: ifle +9 -> 1078
    //   1072: aload 5
    //   1074: lconst_1
    //   1075: putfield 1369	com/tencent/mm/g/b/a/me:fbw	J
    //   1078: aload 5
    //   1080: aload 6
    //   1082: getfield 196	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLC	J
    //   1085: putfield 1370	com/tencent/mm/g/b/a/me:fbo	J
    //   1088: aload 6
    //   1090: invokevirtual 1252	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bVh	()Z
    //   1093: ifeq +193 -> 1286
    //   1096: lconst_1
    //   1097: lstore_2
    //   1098: aload 5
    //   1100: lload_2
    //   1101: putfield 1371	com/tencent/mm/g/b/a/me:fbx	J
    //   1104: aload 5
    //   1106: invokevirtual 1372	com/tencent/mm/g/b/a/me:bfK	()Z
    //   1109: pop
    //   1110: invokestatic 283	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   1113: lstore_2
    //   1114: invokestatic 915	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bAx	()Z
    //   1117: ifeq +16 -> 1133
    //   1120: aload_0
    //   1121: ldc_w 1374
    //   1124: aload 4
    //   1126: getfield 851	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLq	J
    //   1129: lload_2
    //   1130: invokestatic 923	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1133: aload 4
    //   1135: getfield 268	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   1138: sipush 1004
    //   1141: if_icmpne +17 -> 1158
    //   1144: aload_1
    //   1145: sipush 205
    //   1148: lload_2
    //   1149: aload 4
    //   1151: getfield 851	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:nLq	J
    //   1154: lsub
    //   1155: invokestatic 1379	com/tencent/mm/plugin/appbrand/performance/AppBrandPerformanceManager:a	(Lcom/tencent/luggage/sdk/d/d;IJ)V
    //   1158: ldc_w 1156
    //   1161: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1164: return
    //   1165: astore 7
    //   1167: ldc 70
    //   1169: ldc_w 1381
    //   1172: iconst_2
    //   1173: anewarray 4	java/lang/Object
    //   1176: dup
    //   1177: iconst_0
    //   1178: aload_0
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_1
    //   1182: aload 7
    //   1184: aastore
    //   1185: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: goto -959 -> 229
    //   1191: lconst_0
    //   1192: lstore_2
    //   1193: goto -954 -> 239
    //   1196: lconst_0
    //   1197: lstore_2
    //   1198: goto -932 -> 266
    //   1201: getstatic 671	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1204: ifeq -932 -> 272
    //   1207: new 673	java/lang/IllegalStateException
    //   1210: dup
    //   1211: ldc_w 948
    //   1214: invokespecial 677	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1217: astore_0
    //   1218: ldc_w 1156
    //   1221: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1224: aload_0
    //   1225: athrow
    //   1226: aload 5
    //   1228: lconst_0
    //   1229: putfield 1248	com/tencent/mm/g/b/a/mi:fbw	J
    //   1232: goto -852 -> 380
    //   1235: lconst_0
    //   1236: lstore_2
    //   1237: goto -837 -> 400
    //   1240: lconst_0
    //   1241: lstore_2
    //   1242: goto -814 -> 428
    //   1245: ldc 70
    //   1247: ldc_w 1383
    //   1250: iconst_1
    //   1251: anewarray 4	java/lang/Object
    //   1254: dup
    //   1255: iconst_0
    //   1256: aload_1
    //   1257: getfield 78	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1260: aastore
    //   1261: invokestatic 1386	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1264: goto -798 -> 466
    //   1267: lconst_0
    //   1268: lstore_2
    //   1269: goto -761 -> 508
    //   1272: lconst_0
    //   1273: lstore_2
    //   1274: goto -490 -> 784
    //   1277: aload 5
    //   1279: lconst_0
    //   1280: putfield 1369	com/tencent/mm/g/b/a/me:fbw	J
    //   1283: goto -205 -> 1078
    //   1286: lconst_0
    //   1287: lstore_2
    //   1288: goto -190 -> 1098
    //   1291: astore 7
    //   1293: goto -289 -> 1004
    //   1296: astore 7
    //   1298: goto -560 -> 738
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1301	0	paramString	String
    //   0	1301	1	paramq	com.tencent.mm.plugin.appbrand.q
    //   238	1050	2	l	long
    //   11	1139	4	localQualitySessionRuntime	QualitySessionRuntime
    //   70	1208	5	localObject1	Object
    //   77	1012	6	localObject2	Object
    //   342	721	7	localObject3	Object
    //   1165	18	7	localException1	Exception
    //   1291	1	7	localException2	Exception
    //   1296	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   202	229	1165	java/lang/Exception
    //   980	1004	1291	java/lang/Exception
    //   714	738	1296	java/lang/Exception
  }
  
  public static void a(String paramString, final com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(48193);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48187);
        QualitySessionRuntime localQualitySessionRuntime = b.aeU(this.kFU);
        if ((localQualitySessionRuntime != null) && (paramb != null))
        {
          Object localObject;
          if ((paramb.nGd != null) && (paramb.nGd.Nza != 0))
          {
            Log.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.nGd.Nza), Integer.valueOf(paramb.nGd.Nzb) });
            localObject = null;
            switch (paramb.nGd.Nza)
            {
            default: 
              Log.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
            }
          }
          for (;;)
          {
            if (localObject != null) {
              localQualitySessionRuntime.nLw.a(localQualitySessionRuntime, paramb.nGd.Nzb, (f.a)localObject, true);
            }
            if ((paramb.nGf == null) || (!paramb.nGf.NyX)) {
              break label324;
            }
            localObject = com.tencent.luggage.game.e.a.Nn();
            boolean bool = paramb.nGf.NyX;
            int i = paramb.nGf.NyY;
            double d = paramb.nGf.NyZ;
            try
            {
              Log.i("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Double.valueOf(d) });
              ((com.tencent.luggage.game.e.a)localObject).cxB = bool;
              ((com.tencent.luggage.game.e.a)localObject).cxC = i;
              ((com.tencent.luggage.game.e.a)localObject).cxD = d;
              AppMethodBeat.o(48187);
              return;
              localObject = f.a.nKE;
              continue;
              localObject = f.a.nKF;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.MBNiReporter", localException, "setConfig Exception", new Object[0]);
              }
            }
          }
        }
        Log.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        label324:
        AppMethodBeat.o(48187);
      }
    });
    AppMethodBeat.o(48193);
  }
  
  private static QualitySessionRuntime aC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (nKp)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)nKp.get(paramString);
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
  
  public static QualitySessionRuntime aeU(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = aC(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static c bUZ()
  {
    return nKo;
  }
  
  public static final class a
  {
    boolean nKv = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */