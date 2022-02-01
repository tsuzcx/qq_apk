package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.mmv8.V8;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.b.a.pa;
import com.tencent.mm.f.b.a.pa.a;
import com.tencent.mm.f.b.a.pb;
import com.tencent.mm.f.b.a.pb.a;
import com.tencent.mm.f.b.a.pe;
import com.tencent.mm.f.b.a.pf;
import com.tencent.mm.f.b.a.pf.a;
import com.tencent.mm.f.b.a.pp;
import com.tencent.mm.f.b.a.pp.a;
import com.tencent.mm.f.b.a.pw;
import com.tencent.mm.f.b.a.pw.a;
import com.tencent.mm.f.b.a.pw.b;
import com.tencent.mm.f.b.a.pw.c;
import com.tencent.mm.f.b.a.pw.d;
import com.tencent.mm.f.b.a.pw.e;
import com.tencent.mm.f.b.a.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.fon;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  private static final c qMA;
  private static final HashMap<String, QualitySessionRuntime> qMB;
  private static final a qMC;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      qMA = new c();
      qMB = new HashMap();
      qMC = new a();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void I(t paramt)
  {
    AppMethodBeat.i(48189);
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramt.mAppId, Integer.valueOf(paramt.hashCode()) });
    Object localObject2 = paramt.bDy().nYk;
    ??? = localObject2;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.d.Do(paramt.bDy().uin), paramt.bDy(), paramt.Sk().cxf);
      paramt.bDy().nYk = ((QualitySession)???);
    }
    localObject2 = g.f((QualitySession)???);
    ((QualitySessionRuntime)localObject2).nAH = paramt;
    ((QualitySessionRuntime)localObject2).csz = paramt.Qv();
    ((QualitySessionRuntime)localObject2).qNB = System.currentTimeMillis();
    a.amN(((QualitySessionRuntime)localObject2).cBH);
    h.ZvG.be(new b.2((QualitySessionRuntime)localObject2));
    long l;
    if (1 == paramt.bDy().nYl) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).qNP = l;
      synchronized (qMB)
      {
        if (($assertionsDisabled) || (qMB.get(paramt.mAppId) == null)) {
          break;
        }
        paramt = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramt;
      }
      if (paramt.bDy().nYi) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    qMB.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    k.a(paramt.mAppId, new b.1(paramt));
    AppMethodBeat.o(48189);
  }
  
  public static void J(t paramt)
  {
    long l2 = 1L;
    AppMethodBeat.i(277436);
    QualitySessionRuntime localQualitySessionRuntime = aE(paramt.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramt.mAppId });
      AppMethodBeat.o(277436);
      return;
    }
    pb localpb = new pb();
    localpb.gfn = localpb.z("InstanceId", localQualitySessionRuntime.cBH, true);
    localpb.gmF = localpb.z("AppId", localQualitySessionRuntime.appId, true);
    localpb.gYL = localQualitySessionRuntime.qNx;
    localpb.hed = pb.a.oC(localQualitySessionRuntime.qLQ);
    localpb.gYN = localQualitySessionRuntime.apptype;
    localpb.BH(paramt.bDy().startTime);
    localpb.BI(Util.nowMilliSecond());
    localpb.BG(localpb.hcV - localpb.hcU);
    localpb.hee = localpb.z("path", q.aT(Util.nullAsNil(paramt.bCi())), true);
    long l1;
    if (localQualitySessionRuntime.qNT)
    {
      l1 = 1L;
      localpb.hcE = l1;
      if ((localQualitySessionRuntime.qNG == null) || (!localQualitySessionRuntime.qNG.bZI())) {
        break label299;
      }
      l1 = l2;
      label226:
      localpb.hef = l1;
      localpb.hcB = localQualitySessionRuntime.cir();
      localpb.heg = localQualitySessionRuntime.qNP;
      l1 = Util.nowMilliSecond();
      if ((localQualitySessionRuntime.qNF <= 0L) || (l1 <= localQualitySessionRuntime.qNF)) {
        break label304;
      }
    }
    label299:
    label304:
    for (localpb.heh = l1;; localpb.heh = 0L)
    {
      localpb.bpa();
      AppMethodBeat.o(277436);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label226;
    }
  }
  
  public static void K(t paramt)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = aE(paramt.mAppId, false);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    pa localpa = localQualitySessionRuntime.qNR;
    long l;
    if (localpa != null)
    {
      localpa.FV(localQualitySessionRuntime.cBH);
      localpa.FW(localQualitySessionRuntime.appId);
      localpa.gYL = localQualitySessionRuntime.qNx;
      localpa.hdR = pa.a.oB(localQualitySessionRuntime.qLQ);
      localpa.gYN = localQualitySessionRuntime.apptype;
      localpa.gnP = localQualitySessionRuntime.scene;
      localpa.FX(paramt.bDy().username);
      if (!localQualitySessionRuntime.qNT) {
        break label292;
      }
      l = 1L;
      localpa.hcE = l;
      localpa.hcB = localQualitySessionRuntime.cir();
      localpa.FY(j.getNetworkType(MMApplicationContext.getContext()));
      if (!paramt.bDy().cxd) {
        break label297;
      }
      l = 1L;
      label160:
      localpa.hdS = l;
      if (!localQualitySessionRuntime.qNS) {
        break label302;
      }
      l = 1L;
      label175:
      localpa.hdT = l;
      localpa.BE(paramt.bDy().startTime);
      localpa.aoF();
      localpa.BC(localpa.hcV - localpa.hcU);
      if (!localQualitySessionRuntime.qNU) {
        break label307;
      }
      l = 1L;
      label226:
      localpa.hdX = l;
      if (!localQualitySessionRuntime.qNV) {
        break label312;
      }
      l = 1L;
      label241:
      localpa.hdY = l;
      if (localQualitySessionRuntime.qNG == null) {
        break label317;
      }
    }
    label292:
    label297:
    label302:
    label307:
    label312:
    label317:
    for (localpa.hdU = 1L;; localpa.hdU = 0L)
    {
      localpa.hdV = paramt.bDG();
      localpa.hdW = t.bDH();
      localpa.bpa();
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
      l = 0L;
      break label241;
    }
  }
  
  public static void L(t paramt)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = aE(paramt.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.c localc = s.abV(paramt.mAppId).nvY;
    Object localObject = new pp();
    ((pp)localObject).gfn = ((pp)localObject).z("InstanceId", localQualitySessionRuntime.cBH, true);
    ((pp)localObject).gmF = ((pp)localObject).z("AppId", localQualitySessionRuntime.appId, true);
    ((pp)localObject).gYL = localQualitySessionRuntime.qNx;
    ((pp)localObject).hgo = pp.a.oM(localQualitySessionRuntime.qLQ);
    ((pp)localObject).gYN = localQualitySessionRuntime.apptype;
    ((pp)localObject).gnP = localQualitySessionRuntime.scene;
    ((pp)localObject).CA(localc.nzZ);
    ((pp)localObject).CB(localc.nAc);
    ((pp)localObject).Cz(localc.nAc - localc.nzZ);
    ((pp)localObject).hdV = paramt.bDG();
    ((pp)localObject).hgp = localc.nzZ;
    ((pp)localObject).hgq = localc.nAc;
    ((pp)localObject).hgr = (localc.nAc - localc.nzZ);
    ((pp)localObject).hgs = localc.nAe;
    ((pp)localObject).hgt = localc.nAf;
    ((pp)localObject).hgu = (localc.nAf - localc.nAe);
    ((pp)localObject).hgv = localc.nAg;
    ((pp)localObject).hgw = localc.nAh;
    ((pp)localObject).hgx = (localc.nAh - localc.nAg);
    ((pp)localObject).hdW = t.bDH();
    ((pp)localObject).hgC = (localc.nAb - localc.nAa);
    ((pp)localObject).hgy = localc.nAa;
    ((pp)localObject).hgz = (localc.nAa - localc.nzZ);
    ((pp)localObject).hgA = localc.nAb;
    ((pp)localObject).hgB = (localc.nAc - localc.nAb);
    ((pp)localObject).hgD = paramt.bDJ();
    ((pp)localObject).hgE = localc.nAi;
    ((pp)localObject).hgF = localc.nAd;
    ((pp)localObject).hgG = localc.nAk;
    ((pp)localObject).hgH = localc.nAl;
    ((pp)localObject).hgI = localc.nAm;
    ((pp)localObject).hgJ = localc.nAn;
    ((pp)localObject).hgK = (localc.nAn - localc.nAk);
    ((pp)localObject).hgL = (localc.nAm - localc.nAl);
    ((pp)localObject).hgN = t.bDH();
    ((pp)localObject).hgM = t.bDI();
    ((pp)localObject).hgO = 1L;
    if (paramt.bBP() != null) {}
    for (long l = paramt.bBP().bGi();; l = 0L)
    {
      ((pp)localObject).hgP = l;
      ((pp)localObject).gtA = ((pp)localObject).z("networkType", j.getNetworkType(MMApplicationContext.getContext()), true);
      ((pp)localObject).bpa();
      localObject = s.abW(paramt.mAppId).nvZ;
      if (localObject != null)
      {
        ((r)localObject).gfn = ((r)localObject).z("InstanceId", localQualitySessionRuntime.cBH, true);
        ((r)localObject).gfu = (localc.nAc - localc.nzZ);
        ((r)localObject).gfw = paramt.bDG();
        paramt = paramt.nwF;
        if (paramt != null)
        {
          ((r)localObject).gfx = paramt.nsr;
          ((r)localObject).gfy = paramt.nss;
        }
        ((r)localObject).bpa();
      }
      AppMethodBeat.o(160613);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.g paramg, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(277439);
    String str = paramg.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = aE(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(277439);
      return;
    }
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.nAH.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.nAH.hashCode())
    {
      Log.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        paramg = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(277439);
        throw paramg;
      }
      AppMethodBeat.o(277439);
      return;
    }
    pe localpe = new pe();
    localpe.gmF = localpe.z("AppId", localQualitySessionRuntime.appId, true);
    localpe.gfn = localpe.z("InstanceId", localQualitySessionRuntime.cBH, true);
    localpe.gYM = localQualitySessionRuntime.qLQ;
    localpe.gYN = localQualitySessionRuntime.apptype;
    localpe.gYL = localQualitySessionRuntime.qNx;
    localpe.gnP = localQualitySessionRuntime.scene;
    localpe.BM(paramLong);
    localpe.aoL();
    localpe.BL(localpe.hcV - localpe.hcU);
    localpe.heu = paramInt1;
    localpe.hev = localpe.z("filePath", paramString1, true);
    e locale = e.f(paramg.getJsRuntime());
    label390:
    boolean bool;
    switch (5.qMG[locale.ordinal()])
    {
    default: 
      paramInt1 = 0;
      localpe.hew = paramInt1;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < com.tencent.mm.plugin.appbrand.m.v.pON.length))
      {
        paramLong = com.tencent.mm.plugin.appbrand.m.v.pON[paramc.codeCacheStatus];
        localpe.hex = paramLong;
        if (!(paramg instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label950;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramg).cAr.Pb();
        label416:
        if (!bool) {
          break label981;
        }
        paramLong = 1L;
        label424:
        localpe.hey = paramLong;
        if (paramc == null) {
          break label987;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localpe.hez = paramLong;
        if (!org.apache.commons.b.a.contains(e.qJc, locale)) {
          break label993;
        }
        localpe.Gb(V8.getV8Version());
        label470:
        localpe.heA = localpe.z("pluginAppid", paramString2, true);
        localpe.heB = localpe.z("pluginVersion", String.valueOf(paramInt2), true);
        localpe.bpa();
        if ((paramg instanceof com.tencent.mm.plugin.appbrand.v))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.r.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localpe.hcU;
          paramString2.endTime = localpe.hcV;
          paramString2.q("fileName", localpe.hev);
          paramString2.q("size", Long.valueOf(localpe.heu));
          paramString2.q((com.tencent.mm.plugin.appbrand.v)paramg);
        }
        if ((!localQualitySessionRuntime.qNI.qMH) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.qNI.qMH = true;
          localQualitySessionRuntime.qND = System.currentTimeMillis();
          paramg = localQualitySessionRuntime.nAH;
          paramString1 = new pf();
          paramString2 = aE(str, true);
          if (paramString2 != null)
          {
            paramString1.gmF = paramString1.z("AppId", paramString2.appId, true);
            paramString1.gfn = paramString1.z("InstanceId", paramString2.cBH, true);
            paramString1.heC = pf.a.oE(paramString2.qLQ);
            paramString1.gYN = paramString2.apptype;
            paramString1.gYL = paramString2.qNx;
            paramString1.gnP = paramString2.scene;
            paramString1.BO(paramString2.qNA);
            paramString1.aoM();
            paramString1.BN(paramString1.hcV - paramString2.qNA);
            paramString1.hee = paramString1.z("path", q.aT(paramg.bCi()), true);
            if (!paramg.nwv) {
              break label1028;
            }
            paramLong = 1L;
            label783:
            paramString1.hcE = paramLong;
            if (paramString2.qNG == null) {
              break label1040;
            }
            if (!paramString2.qNG.bZI()) {
              break label1034;
            }
            paramLong = 1L;
            paramString1.hef = paramLong;
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
        paramString1.hcB = paramString2.cir();
        paramString1.gtA = paramString1.z("networkType", com.tencent.mm.plugin.appbrand.report.u.ek(MMApplicationContext.getContext()), true);
        paramString1.heg = paramString2.qNP;
        paramString1.heD = paramString2.ciu();
        paramString1.bpa();
        if (DebuggerShell.bLS()) {
          com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localpe.hcU, localpe.hcV);
        }
        AppMethodBeat.o(277439);
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
          bool = ((ah)paramg).bDA().cAr.Pb();
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
        localpe.Gb(c.cil());
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
    AppMethodBeat.o(277439);
    throw paramg;
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, t paramt)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = aE(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.qNC = System.currentTimeMillis();
    localQualitySessionRuntime1.qNG = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime1.qNA = paramt.bDy().startTime;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramt.d(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      Log.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    pw localpw;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48186);
          if (this.qMD.nAH.ntU.get())
          {
            AppMethodBeat.o(48186);
            return;
          }
          f localf;
          if (!this.qMD.csz)
          {
            localf = this.qMD.qNJ;
            QualitySessionRuntime localQualitySessionRuntime = this.qMD;
            AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
            Log.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
            int i = localQualitySessionRuntime.nAH.bDy().uin;
            double d1 = localAppBrandSysConfigWC.cxL.nXp;
            double d2 = new Random(i ^ System.nanoTime()).nextDouble();
            boolean bool2 = DebuggerShell.bLS();
            if ((d2 <= d1) || (bool2)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              Log.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f] monkeyMode[%b]", new Object[] { Boolean.valueOf(bool1), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(bool2) });
              if (!bool1) {
                break;
              }
              try
              {
                localf.a(localQualitySessionRuntime, localAppBrandSysConfigWC.cxL.nXq, f.a.qMR, false);
                return;
              }
              finally
              {
                AppMethodBeat.o(48186);
              }
            }
          }
        }
      });
      AppMethodBeat.o(48192);
      return;
      localpw = new pw();
      localQualitySessionRuntime2 = aE(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localpw.gmF = localpw.z("AppId", localQualitySessionRuntime2.appId, true);
    localpw.gfn = localpw.z("InstanceId", localQualitySessionRuntime2.cBH, true);
    localpw.hig = pw.a.oU(localQualitySessionRuntime2.qLQ);
    localpw.gYN = localQualitySessionRuntime2.apptype;
    localpw.gnP = localQualitySessionRuntime2.scene;
    localpw.gYL = localQualitySessionRuntime2.qNx;
    localpw.Dm(paramt.bDy().startTime);
    localpw.aoT();
    localpw.Dl(localpw.hcV - paramt.bDy().startTime);
    localpw.hio = (paramAppStartupPerformanceReportBundle.pTu - paramAppStartupPerformanceReportBundle.pTt);
    localpw.hip = (paramAppStartupPerformanceReportBundle.pTw - paramAppStartupPerformanceReportBundle.pTv);
    localpw.hiq = localQualitySessionRuntime2.qNy;
    localpw.hir = paramAppStartupPerformanceReportBundle.pTB;
    Object localObject = paramt.bDx();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramt.bDy();
    label307:
    label325:
    long l1;
    if (paramAppStartupPerformanceReportBundle.pTC)
    {
      paramString = pw.c.hiD;
      localpw.hii = paramString;
      if (!localAppBrandInitConfigWC.cxd) {
        break label603;
      }
      paramString = pw.b.hiA;
      localpw.hij = paramString;
      if (!paramt.nwv) {
        break label610;
      }
      l1 = 1L;
      label341:
      localpw.hik = l1;
      long l2 = 0L;
      if (com.tencent.mm.vfs.u.agG(((AppBrandSysConfigWC)localObject).nYR.pkgPath)) {
        break label616;
      }
      paramString = ((AppBrandSysConfigWC)localObject).nYR.nIb.iterator();
      do
      {
        l1 = l2;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (ModulePkgInfo)paramString.next();
      } while (!com.tencent.mm.vfs.u.agG(((ModulePkgInfo)localObject).pkgPath));
      l1 = com.tencent.mm.vfs.u.bBQ(((ModulePkgInfo)localObject).pkgPath);
      label422:
      if (!paramt.nwv) {
        break label632;
      }
      label429:
      localpw.hih = l1;
      localpw.gHC = g.getNetworkType();
      localpw.heg = localQualitySessionRuntime2.qNP;
      localpw.hcB = localQualitySessionRuntime2.cir();
      localpw.Dn(localQualitySessionRuntime2.qNG.pTs - localQualitySessionRuntime2.qNG.pSY);
      if (!paramAppStartupPerformanceReportBundle.pTD) {
        break label638;
      }
      paramString = pw.e.hiJ;
      label499:
      localpw.his = paramString;
      localpw.hit = (paramAppStartupPerformanceReportBundle.pTy - paramAppStartupPerformanceReportBundle.pTx);
      if (!paramAppStartupPerformanceReportBundle.pTE) {
        break label645;
      }
    }
    label645:
    for (paramString = pw.d.hiG;; paramString = pw.d.hiH)
    {
      localpw.hiu = paramString;
      localpw.hiv = (paramAppStartupPerformanceReportBundle.pTA - paramAppStartupPerformanceReportBundle.pTz);
      localpw.heD = localQualitySessionRuntime2.ciu();
      localpw.bpa();
      if (!DebuggerShell.bLS()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localpw.gmF, "ResourcePrepare", localpw.hcU, localpw.hcV);
      break;
      paramString = pw.c.hiE;
      break label307;
      label603:
      paramString = pw.b.hiB;
      break label325;
      label610:
      l1 = 0L;
      break label341;
      label616:
      l1 = com.tencent.mm.vfs.u.bBQ(((AppBrandSysConfigWC)localObject).nYR.pkgPath);
      break label422;
      label632:
      l1 = 0L;
      break label429;
      label638:
      paramString = pw.e.hiK;
      break label499;
    }
  }
  
  public static void a(String paramString, final com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(48193);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48187);
        QualitySessionRuntime localQualitySessionRuntime = b.amO(this.nzB);
        if ((localQualitySessionRuntime != null) && (paramb != null))
        {
          if ((paramb.qIp != null) && (paramb.qIp.UME != 0))
          {
            Log.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.qIp.UME), Integer.valueOf(paramb.qIp.UMF) });
            f.a locala = null;
            switch (paramb.qIp.UME)
            {
            default: 
              Log.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
            }
            for (;;)
            {
              if (locala != null) {
                localQualitySessionRuntime.qNJ.a(localQualitySessionRuntime, paramb.qIp.UMF, locala, true);
              }
              AppMethodBeat.o(48187);
              return;
              locala = f.a.qMQ;
              continue;
              locala = f.a.qMR;
            }
          }
        }
        else {
          Log.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        }
        AppMethodBeat.o(48187);
      }
    });
    AppMethodBeat.o(48193);
  }
  
  /* Error */
  public static void a(String paramString, t paramt)
  {
    // Byte code:
    //   0: ldc_w 1227
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 224	com/tencent/mm/plugin/appbrand/report/quality/b:aE	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +26 -> 41
    //   18: ldc 66
    //   20: ldc_w 1229
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 228	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1227
    //   37: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 66
    //   43: ldc_w 1231
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 4
    //   59: aconst_null
    //   60: putfield 354	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNR	Lcom/tencent/mm/f/b/a/pa;
    //   63: new 1233	com/tencent/mm/f/b/a/pg
    //   66: dup
    //   67: invokespecial 1234	com/tencent/mm/f/b/a/pg:<init>	()V
    //   70: astore 5
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 224	com/tencent/mm/plugin/appbrand/report/quality/b:aE	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +478 -> 559
    //   84: aload 5
    //   86: aload 5
    //   88: ldc 242
    //   90: aload 6
    //   92: getfield 206	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1235	com/tencent/mm/f/b/a/pg:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1236	com/tencent/mm/f/b/a/pg:gmF	Ljava/lang/String;
    //   102: aload 5
    //   104: aload 5
    //   106: ldc 233
    //   108: aload 6
    //   110: getfield 164	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cBH	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1235	com/tencent/mm/f/b/a/pg:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1237	com/tencent/mm/f/b/a/pg:gfn	Ljava/lang/String;
    //   120: aload 5
    //   122: aload 6
    //   124: getfield 254	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qLQ	I
    //   127: invokestatic 1243	com/tencent/mm/f/b/a/pg$a:oF	(I)Lcom/tencent/mm/f/b/a/pg$a;
    //   130: putfield 1247	com/tencent/mm/f/b/a/pg:heI	Lcom/tencent/mm/f/b/a/pg$a;
    //   133: aload 5
    //   135: aload 6
    //   137: getfield 267	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1248	com/tencent/mm/f/b/a/pg:gYN	J
    //   144: aload 5
    //   146: aload 6
    //   148: getfield 248	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNx	I
    //   151: i2l
    //   152: putfield 1249	com/tencent/mm/f/b/a/pg:gYL	J
    //   155: aload 5
    //   157: aload 6
    //   159: getfield 378	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1250	com/tencent/mm/f/b/a/pg:gnP	J
    //   166: aload 5
    //   168: aload_1
    //   169: invokevirtual 95	com/tencent/mm/plugin/appbrand/t:bDy	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   172: getfield 273	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   175: invokevirtual 1254	com/tencent/mm/f/b/a/pg:BQ	(J)Lcom/tencent/mm/f/b/a/pg;
    //   178: pop
    //   179: aload 5
    //   181: invokevirtual 1258	com/tencent/mm/f/b/a/pg:aoN	()Lcom/tencent/mm/f/b/a/pg;
    //   184: pop
    //   185: aload 5
    //   187: aload 5
    //   189: getfield 1259	com/tencent/mm/f/b/a/pg:hcV	J
    //   192: aload 5
    //   194: getfield 1260	com/tencent/mm/f/b/a/pg:hcU	J
    //   197: lsub
    //   198: invokevirtual 1263	com/tencent/mm/f/b/a/pg:BP	(J)Lcom/tencent/mm/f/b/a/pg;
    //   201: pop
    //   202: aload 5
    //   204: aload 5
    //   206: ldc_w 296
    //   209: aload_1
    //   210: invokevirtual 1267	com/tencent/mm/plugin/appbrand/t:bDz	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   213: invokevirtual 1272	com/tencent/mm/plugin/appbrand/page/y:getCurrentUrl	()Ljava/lang/String;
    //   216: invokestatic 304	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 309	com/tencent/mm/compatible/util/q:aT	(Ljava/lang/String;)Ljava/lang/String;
    //   222: iconst_1
    //   223: invokevirtual 1235	com/tencent/mm/f/b/a/pg:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   226: putfield 1273	com/tencent/mm/f/b/a/pg:hee	Ljava/lang/String;
    //   229: aload 6
    //   231: getfield 315	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNT	Z
    //   234: ifeq +957 -> 1191
    //   237: lconst_1
    //   238: lstore_2
    //   239: aload 5
    //   241: lload_2
    //   242: putfield 1274	com/tencent/mm/f/b/a/pg:hcE	J
    //   245: aload 6
    //   247: getfield 322	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNG	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   250: ifnull +951 -> 1201
    //   253: aload 6
    //   255: getfield 322	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNG	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   258: invokevirtual 327	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:bZI	()Z
    //   261: ifeq +935 -> 1196
    //   264: lconst_1
    //   265: lstore_2
    //   266: aload 5
    //   268: lload_2
    //   269: putfield 1275	com/tencent/mm/f/b/a/pg:hef	J
    //   272: aload 5
    //   274: aload 6
    //   276: invokevirtual 333	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cir	()J
    //   279: putfield 1276	com/tencent/mm/f/b/a/pg:hcB	J
    //   282: aload 5
    //   284: ldc_w 1278
    //   287: invokestatic 1284	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   290: checkcast 1278	com/tencent/mm/plugin/expt/b/b
    //   293: getstatic 1290	com/tencent/mm/plugin/expt/b/b$a:vBl	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   296: iconst_0
    //   297: invokeinterface 1293 3 0
    //   302: i2l
    //   303: putfield 1296	com/tencent/mm/f/b/a/pg:heL	J
    //   306: aload 5
    //   308: lconst_0
    //   309: putfield 1299	com/tencent/mm/f/b/a/pg:hen	J
    //   312: aload 5
    //   314: aload 5
    //   316: ldc_w 642
    //   319: invokestatic 395	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   322: invokestatic 943	com/tencent/mm/plugin/appbrand/report/u:ek	(Landroid/content/Context;)Ljava/lang/String;
    //   325: iconst_1
    //   326: invokevirtual 1235	com/tencent/mm/f/b/a/pg:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   329: putfield 1300	com/tencent/mm/f/b/a/pg:gtA	Ljava/lang/String;
    //   332: aload_1
    //   333: invokevirtual 1075	com/tencent/mm/plugin/appbrand/t:bDx	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   336: getfield 1105	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:nYR	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   339: getfield 1304	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:nId	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   342: astore 7
    //   344: aload 7
    //   346: ifnull +880 -> 1226
    //   349: aload 7
    //   351: ldc_w 1306
    //   354: invokevirtual 1312	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:adi	(Ljava/lang/String;)Ljava/util/List;
    //   357: astore 7
    //   359: aload 7
    //   361: ifnull +19 -> 380
    //   364: aload 7
    //   366: invokeinterface 1316 1 0
    //   371: ifle +9 -> 380
    //   374: aload 5
    //   376: lconst_1
    //   377: putfield 1319	com/tencent/mm/f/b/a/pg:heo	J
    //   380: aload 5
    //   382: aload 6
    //   384: getfield 193	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNP	J
    //   387: putfield 1320	com/tencent/mm/f/b/a/pg:heg	J
    //   390: aload 6
    //   392: invokevirtual 1323	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cis	()Z
    //   395: ifeq +840 -> 1235
    //   398: lconst_1
    //   399: lstore_2
    //   400: aload 5
    //   402: lload_2
    //   403: putfield 1326	com/tencent/mm/f/b/a/pg:hep	J
    //   406: aload 5
    //   408: aload_1
    //   409: invokevirtual 447	com/tencent/mm/plugin/appbrand/t:bDG	()I
    //   412: i2l
    //   413: putfield 1327	com/tencent/mm/f/b/a/pg:hdV	J
    //   416: aload_1
    //   417: invokevirtual 95	com/tencent/mm/plugin/appbrand/t:bDy	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   420: getfield 1330	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYm	Z
    //   423: ifeq +817 -> 1240
    //   426: lconst_1
    //   427: lstore_2
    //   428: aload 5
    //   430: lload_2
    //   431: putfield 1333	com/tencent/mm/f/b/a/pg:heK	J
    //   434: aload_1
    //   435: invokevirtual 632	com/tencent/mm/plugin/appbrand/t:bBP	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +803 -> 1245
    //   445: aload 5
    //   447: aload 5
    //   449: ldc_w 1335
    //   452: aload 7
    //   454: invokeinterface 1338 1 0
    //   459: iconst_1
    //   460: invokevirtual 1235	com/tencent/mm/f/b/a/pg:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   463: putfield 1341	com/tencent/mm/f/b/a/pg:heJ	Ljava/lang/String;
    //   466: aload 5
    //   468: aload 6
    //   470: getfield 342	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNF	J
    //   473: putfield 1342	com/tencent/mm/f/b/a/pg:heh	J
    //   476: aload 5
    //   478: aload 6
    //   480: invokevirtual 948	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ciu	()J
    //   483: putfield 1343	com/tencent/mm/f/b/a/pg:heD	J
    //   486: aload 5
    //   488: invokevirtual 1344	com/tencent/mm/f/b/a/pg:bpa	()Z
    //   491: pop
    //   492: invokestatic 957	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bLS	()Z
    //   495: ifeq +64 -> 559
    //   498: aload 6
    //   500: getfield 315	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNT	Z
    //   503: ifeq +764 -> 1267
    //   506: lconst_1
    //   507: lstore_2
    //   508: ldc_w 1346
    //   511: iconst_2
    //   512: anewarray 4	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: ldc_w 1348
    //   520: aastore
    //   521: dup
    //   522: iconst_1
    //   523: lload_2
    //   524: invokestatic 872	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   527: aastore
    //   528: invokestatic 1352	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   531: astore 6
    //   533: aload 5
    //   535: getfield 1236	com/tencent/mm/f/b/a/pg:gmF	Ljava/lang/String;
    //   538: ldc_w 1354
    //   541: ldc_w 1356
    //   544: aload 5
    //   546: getfield 1260	com/tencent/mm/f/b/a/pg:hcU	J
    //   549: aload 5
    //   551: getfield 1259	com/tencent/mm/f/b/a/pg:hcV	J
    //   554: aload 6
    //   556: invokestatic 1359	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   559: new 1361	com/tencent/mm/f/b/a/pz
    //   562: dup
    //   563: invokespecial 1362	com/tencent/mm/f/b/a/pz:<init>	()V
    //   566: astore 5
    //   568: aload_0
    //   569: iconst_1
    //   570: invokestatic 224	com/tencent/mm/plugin/appbrand/report/quality/b:aE	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   573: astore 6
    //   575: aload 6
    //   577: ifnull +256 -> 833
    //   580: aload 6
    //   582: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   585: putfield 1365	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNE	J
    //   588: aload 5
    //   590: aload 5
    //   592: ldc 242
    //   594: aload 6
    //   596: getfield 206	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   599: iconst_1
    //   600: invokevirtual 1366	com/tencent/mm/f/b/a/pz:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   603: putfield 1367	com/tencent/mm/f/b/a/pz:gmF	Ljava/lang/String;
    //   606: aload 5
    //   608: aload 5
    //   610: ldc 233
    //   612: aload 6
    //   614: getfield 164	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cBH	Ljava/lang/String;
    //   617: iconst_1
    //   618: invokevirtual 1366	com/tencent/mm/f/b/a/pz:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   621: putfield 1368	com/tencent/mm/f/b/a/pz:gfn	Ljava/lang/String;
    //   624: aload 5
    //   626: aload 6
    //   628: getfield 254	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qLQ	I
    //   631: invokestatic 1374	com/tencent/mm/f/b/a/pz$a:oX	(I)Lcom/tencent/mm/f/b/a/pz$a;
    //   634: putfield 1378	com/tencent/mm/f/b/a/pz:hiU	Lcom/tencent/mm/f/b/a/pz$a;
    //   637: aload 5
    //   639: aload 6
    //   641: getfield 267	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   644: i2l
    //   645: putfield 1379	com/tencent/mm/f/b/a/pz:gYN	J
    //   648: aload 5
    //   650: aload 6
    //   652: getfield 248	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNx	I
    //   655: i2l
    //   656: putfield 1380	com/tencent/mm/f/b/a/pz:gYL	J
    //   659: aload 5
    //   661: aload 6
    //   663: getfield 378	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   666: i2l
    //   667: putfield 1381	com/tencent/mm/f/b/a/pz:gnP	J
    //   670: aload 5
    //   672: aload 6
    //   674: getfield 995	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNC	J
    //   677: invokevirtual 1385	com/tencent/mm/f/b/a/pz:Dx	(J)Lcom/tencent/mm/f/b/a/pz;
    //   680: pop
    //   681: aload 5
    //   683: invokevirtual 1389	com/tencent/mm/f/b/a/pz:aoV	()Lcom/tencent/mm/f/b/a/pz;
    //   686: pop
    //   687: aload 5
    //   689: aload 5
    //   691: getfield 1390	com/tencent/mm/f/b/a/pz:hcV	J
    //   694: aload 6
    //   696: getfield 995	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNC	J
    //   699: lsub
    //   700: invokevirtual 1393	com/tencent/mm/f/b/a/pz:Dw	(J)Lcom/tencent/mm/f/b/a/pz;
    //   703: pop
    //   704: aload 5
    //   706: aload 6
    //   708: invokevirtual 333	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cir	()J
    //   711: putfield 1394	com/tencent/mm/f/b/a/pz:hcB	J
    //   714: aload 5
    //   716: aload 5
    //   718: ldc_w 296
    //   721: aload_1
    //   722: invokevirtual 1267	com/tencent/mm/plugin/appbrand/t:bDz	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   725: invokevirtual 1272	com/tencent/mm/plugin/appbrand/page/y:getCurrentUrl	()Ljava/lang/String;
    //   728: invokestatic 309	com/tencent/mm/compatible/util/q:aT	(Ljava/lang/String;)Ljava/lang/String;
    //   731: iconst_1
    //   732: invokevirtual 1366	com/tencent/mm/f/b/a/pz:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   735: putfield 1395	com/tencent/mm/f/b/a/pz:hee	Ljava/lang/String;
    //   738: aload 5
    //   740: lconst_0
    //   741: putfield 1396	com/tencent/mm/f/b/a/pz:hen	J
    //   744: aload 5
    //   746: aload 5
    //   748: ldc_w 642
    //   751: invokestatic 395	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   754: invokestatic 943	com/tencent/mm/plugin/appbrand/report/u:ek	(Landroid/content/Context;)Ljava/lang/String;
    //   757: iconst_1
    //   758: invokevirtual 1366	com/tencent/mm/f/b/a/pz:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   761: putfield 1397	com/tencent/mm/f/b/a/pz:gtA	Ljava/lang/String;
    //   764: aload 5
    //   766: aload 6
    //   768: getfield 193	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNP	J
    //   771: putfield 1398	com/tencent/mm/f/b/a/pz:heg	J
    //   774: aload 6
    //   776: invokevirtual 1323	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cis	()Z
    //   779: ifeq +493 -> 1272
    //   782: lconst_1
    //   783: lstore_2
    //   784: aload 5
    //   786: lload_2
    //   787: putfield 1399	com/tencent/mm/f/b/a/pz:hep	J
    //   790: aload 5
    //   792: aload 6
    //   794: invokevirtual 948	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ciu	()J
    //   797: putfield 1400	com/tencent/mm/f/b/a/pz:heD	J
    //   800: aload 5
    //   802: invokevirtual 1401	com/tencent/mm/f/b/a/pz:bpa	()Z
    //   805: pop
    //   806: invokestatic 957	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bLS	()Z
    //   809: ifeq +24 -> 833
    //   812: aload 5
    //   814: getfield 1367	com/tencent/mm/f/b/a/pz:gmF	Ljava/lang/String;
    //   817: ldc_w 1403
    //   820: aload 5
    //   822: getfield 1404	com/tencent/mm/f/b/a/pz:hcU	J
    //   825: aload 5
    //   827: getfield 1390	com/tencent/mm/f/b/a/pz:hcV	J
    //   830: invokestatic 965	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   833: new 1406	com/tencent/mm/f/b/a/pc
    //   836: dup
    //   837: invokespecial 1407	com/tencent/mm/f/b/a/pc:<init>	()V
    //   840: astore 5
    //   842: aload_0
    //   843: iconst_1
    //   844: invokestatic 224	com/tencent/mm/plugin/appbrand/report/quality/b:aE	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   847: astore 6
    //   849: aload 6
    //   851: ifnull +259 -> 1110
    //   854: aload 5
    //   856: aload 5
    //   858: ldc 242
    //   860: aload 6
    //   862: getfield 206	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   865: iconst_1
    //   866: invokevirtual 1408	com/tencent/mm/f/b/a/pc:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   869: putfield 1409	com/tencent/mm/f/b/a/pc:gmF	Ljava/lang/String;
    //   872: aload 5
    //   874: aload 5
    //   876: ldc 233
    //   878: aload 6
    //   880: getfield 164	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cBH	Ljava/lang/String;
    //   883: iconst_1
    //   884: invokevirtual 1408	com/tencent/mm/f/b/a/pc:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   887: putfield 1410	com/tencent/mm/f/b/a/pc:gfn	Ljava/lang/String;
    //   890: aload 5
    //   892: aload 6
    //   894: getfield 254	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qLQ	I
    //   897: invokestatic 1416	com/tencent/mm/f/b/a/pc$a:oD	(I)Lcom/tencent/mm/f/b/a/pc$a;
    //   900: putfield 1420	com/tencent/mm/f/b/a/pc:hem	Lcom/tencent/mm/f/b/a/pc$a;
    //   903: aload 5
    //   905: aload 6
    //   907: getfield 267	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   910: i2l
    //   911: putfield 1421	com/tencent/mm/f/b/a/pc:gYN	J
    //   914: aload 5
    //   916: aload 6
    //   918: getfield 248	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNx	I
    //   921: i2l
    //   922: putfield 1422	com/tencent/mm/f/b/a/pc:gYL	J
    //   925: aload 5
    //   927: aload 6
    //   929: getfield 378	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   932: i2l
    //   933: putfield 1423	com/tencent/mm/f/b/a/pc:gnP	J
    //   936: aload 5
    //   938: aload 6
    //   940: getfield 897	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qND	J
    //   943: invokevirtual 1427	com/tencent/mm/f/b/a/pc:BK	(J)Lcom/tencent/mm/f/b/a/pc;
    //   946: pop
    //   947: aload 5
    //   949: invokevirtual 1431	com/tencent/mm/f/b/a/pc:aoK	()Lcom/tencent/mm/f/b/a/pc;
    //   952: pop
    //   953: aload 5
    //   955: aload 5
    //   957: getfield 1432	com/tencent/mm/f/b/a/pc:hcV	J
    //   960: aload 6
    //   962: getfield 897	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qND	J
    //   965: lsub
    //   966: invokevirtual 1435	com/tencent/mm/f/b/a/pc:BJ	(J)Lcom/tencent/mm/f/b/a/pc;
    //   969: pop
    //   970: aload 5
    //   972: aload 6
    //   974: invokevirtual 333	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cir	()J
    //   977: putfield 1436	com/tencent/mm/f/b/a/pc:hcB	J
    //   980: aload 5
    //   982: aload 5
    //   984: ldc_w 296
    //   987: aload_1
    //   988: invokevirtual 1267	com/tencent/mm/plugin/appbrand/t:bDz	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   991: invokevirtual 1272	com/tencent/mm/plugin/appbrand/page/y:getCurrentUrl	()Ljava/lang/String;
    //   994: invokestatic 309	com/tencent/mm/compatible/util/q:aT	(Ljava/lang/String;)Ljava/lang/String;
    //   997: iconst_1
    //   998: invokevirtual 1408	com/tencent/mm/f/b/a/pc:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1001: putfield 1437	com/tencent/mm/f/b/a/pc:hee	Ljava/lang/String;
    //   1004: aload 5
    //   1006: lconst_0
    //   1007: putfield 1438	com/tencent/mm/f/b/a/pc:hen	J
    //   1010: aload 5
    //   1012: aload 5
    //   1014: ldc_w 642
    //   1017: invokestatic 395	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1020: invokestatic 943	com/tencent/mm/plugin/appbrand/report/u:ek	(Landroid/content/Context;)Ljava/lang/String;
    //   1023: iconst_1
    //   1024: invokevirtual 1408	com/tencent/mm/f/b/a/pc:z	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   1027: putfield 1439	com/tencent/mm/f/b/a/pc:gtA	Ljava/lang/String;
    //   1030: aload_1
    //   1031: invokevirtual 1075	com/tencent/mm/plugin/appbrand/t:bDx	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1034: getfield 1105	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:nYR	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1037: getfield 1304	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:nId	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1040: astore 7
    //   1042: aload 7
    //   1044: ifnull +233 -> 1277
    //   1047: aload 7
    //   1049: ldc_w 1306
    //   1052: invokevirtual 1312	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:adi	(Ljava/lang/String;)Ljava/util/List;
    //   1055: astore 7
    //   1057: aload 7
    //   1059: ifnull +19 -> 1078
    //   1062: aload 7
    //   1064: invokeinterface 1316 1 0
    //   1069: ifle +9 -> 1078
    //   1072: aload 5
    //   1074: lconst_1
    //   1075: putfield 1440	com/tencent/mm/f/b/a/pc:heo	J
    //   1078: aload 5
    //   1080: aload 6
    //   1082: getfield 193	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qNP	J
    //   1085: putfield 1441	com/tencent/mm/f/b/a/pc:heg	J
    //   1088: aload 6
    //   1090: invokevirtual 1323	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:cis	()Z
    //   1093: ifeq +193 -> 1286
    //   1096: lconst_1
    //   1097: lstore_2
    //   1098: aload 5
    //   1100: lload_2
    //   1101: putfield 1442	com/tencent/mm/f/b/a/pc:hep	J
    //   1104: aload 5
    //   1106: invokevirtual 1443	com/tencent/mm/f/b/a/pc:bpa	()Z
    //   1109: pop
    //   1110: invokestatic 282	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   1113: lstore_2
    //   1114: invokestatic 957	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bLS	()Z
    //   1117: ifeq +16 -> 1133
    //   1120: aload_0
    //   1121: ldc_w 1445
    //   1124: aload 4
    //   1126: getfield 897	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qND	J
    //   1129: lload_2
    //   1130: invokestatic 965	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1133: aload 4
    //   1135: getfield 267	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   1138: sipush 1004
    //   1141: if_icmpne +17 -> 1158
    //   1144: aload_1
    //   1145: sipush 205
    //   1148: lload_2
    //   1149: aload 4
    //   1151: getfield 897	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:qND	J
    //   1154: lsub
    //   1155: invokestatic 1450	com/tencent/mm/plugin/appbrand/performance/AppBrandPerformanceManager:a	(Lcom/tencent/luggage/sdk/e/d;IJ)V
    //   1158: ldc_w 1227
    //   1161: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1164: return
    //   1165: astore 7
    //   1167: ldc 66
    //   1169: ldc_w 1452
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
    //   1185: invokestatic 228	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: goto -959 -> 229
    //   1191: lconst_0
    //   1192: lstore_2
    //   1193: goto -954 -> 239
    //   1196: lconst_0
    //   1197: lstore_2
    //   1198: goto -932 -> 266
    //   1201: getstatic 718	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   1204: ifeq -932 -> 272
    //   1207: new 720	java/lang/IllegalStateException
    //   1210: dup
    //   1211: ldc_w 990
    //   1214: invokespecial 724	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1217: astore_0
    //   1218: ldc_w 1227
    //   1221: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1224: aload_0
    //   1225: athrow
    //   1226: aload 5
    //   1228: lconst_0
    //   1229: putfield 1319	com/tencent/mm/f/b/a/pg:heo	J
    //   1232: goto -852 -> 380
    //   1235: lconst_0
    //   1236: lstore_2
    //   1237: goto -837 -> 400
    //   1240: lconst_0
    //   1241: lstore_2
    //   1242: goto -814 -> 428
    //   1245: ldc 66
    //   1247: ldc_w 1454
    //   1250: iconst_1
    //   1251: anewarray 4	java/lang/Object
    //   1254: dup
    //   1255: iconst_0
    //   1256: aload_1
    //   1257: getfield 74	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1260: aastore
    //   1261: invokestatic 1457	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1264: goto -798 -> 466
    //   1267: lconst_0
    //   1268: lstore_2
    //   1269: goto -761 -> 508
    //   1272: lconst_0
    //   1273: lstore_2
    //   1274: goto -490 -> 784
    //   1277: aload 5
    //   1279: lconst_0
    //   1280: putfield 1440	com/tencent/mm/f/b/a/pc:heo	J
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
    //   0	1301	1	paramt	t
    //   238	1050	2	l	long
    //   11	1139	4	localQualitySessionRuntime	QualitySessionRuntime
    //   70	1208	5	localObject1	Object
    //   77	1012	6	localObject2	Object
    //   342	721	7	localObject3	Object
    //   1165	18	7	localException1	java.lang.Exception
    //   1291	1	7	localException2	java.lang.Exception
    //   1296	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   202	229	1165	java/lang/Exception
    //   980	1004	1291	java/lang/Exception
    //   714	738	1296	java/lang/Exception
  }
  
  private static QualitySessionRuntime aE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (qMB)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)qMB.get(paramString);
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
  
  public static QualitySessionRuntime amO(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = aE(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static c cik()
  {
    return qMA;
  }
  
  public static final class a
  {
    boolean qMH = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */