package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.e.i;
import com.tencent.luggage.game.c.h.1;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.ih.a;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.g.b.a.ii.a;
import com.tencent.mm.g.b.a.ik;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.g.b.a.il.a;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.g.b.a.iu.a;
import com.tencent.mm.g.b.a.jb;
import com.tencent.mm.g.b.a.jb.a;
import com.tencent.mm.g.b.a.jb.b;
import com.tencent.mm.g.b.a.jb.c;
import com.tencent.mm.g.b.a.jb.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class a
{
  private static final b mzi;
  private static final HashMap<String, QualitySessionRuntime> mzj;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      mzi = new b();
      mzj = new HashMap();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void C(p paramp)
  {
    AppMethodBeat.i(48189);
    ae.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramp.mAppId, Integer.valueOf(paramp.hashCode()) });
    Object localObject2 = paramp.aXx().kaS;
    ??? = localObject2;
    if (localObject2 == null)
    {
      ae.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.b.vQ(paramp.aXx().uin), paramp.aXx(), paramp.Fg().cmE);
      paramp.aXx().kaS = ((QualitySession)???);
    }
    localObject2 = f.h((QualitySession)???);
    ((QualitySessionRuntime)localObject2).jFm = paramp;
    ((QualitySessionRuntime)localObject2).ciE = paramp.Ee();
    ((QualitySessionRuntime)localObject2).mAj = System.currentTimeMillis();
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48185);
        QualitySessionRuntime localQualitySessionRuntime = this.mzk;
        h.a locala = (h.a)com.tencent.luggage.sdk.g.c.a("MemoryInspector.getMemoryMB", new h.1(com.tencent.luggage.game.c.h.cjD));
        if (locala == null) {}
        for (int i = 0;; i = locala.cjG)
        {
          localQualitySessionRuntime.mAp = i;
          AppMethodBeat.o(48185);
          return;
        }
      }
    });
    long l;
    if (1 == paramp.aXx().kaT) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).mAx = l;
      synchronized (mzj)
      {
        if (($assertionsDisabled) || (mzj.get(paramp.mAppId) == null)) {
          break;
        }
        paramp = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramp;
      }
      if (paramp.aXx().kaQ) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    mzj.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    com.tencent.mm.plugin.appbrand.h.a(paramp.mAppId, new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(48184);
        ae.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.jyD.mAppId, Integer.valueOf(this.jyD.hashCode()) });
        a.G(this.jyD);
        AppMethodBeat.o(48184);
      }
    });
    AppMethodBeat.o(48189);
  }
  
  public static void D(p paramp)
  {
    long l2 = 1L;
    AppMethodBeat.i(222935);
    QualitySessionRuntime localQualitySessionRuntime = aA(paramp.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      ae.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramp.mAppId });
      AppMethodBeat.o(222935);
      return;
    }
    ii localii = new ii();
    localii.esa = localii.t("InstanceId", localQualitySessionRuntime.lIU, true);
    localii.euy = localii.t("AppId", localQualitySessionRuntime.appId, true);
    localii.etb = localQualitySessionRuntime.mAf;
    localii.ewQ = ii.a.jp(localQualitySessionRuntime.myD);
    localii.euA = localQualitySessionRuntime.apptype;
    localii.oc(paramp.aXx().startTime);
    localii.od(bu.fpO());
    localii.ob(localii.evJ - localii.evI);
    localii.ewR = localii.t("path", com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramp.aWx())), true);
    long l1;
    if (localQualitySessionRuntime.mAB)
    {
      l1 = 1L;
      localii.evs = l1;
      if ((localQualitySessionRuntime.mAo == null) || (!localQualitySessionRuntime.mAo.brH())) {
        break label299;
      }
      l1 = l2;
      label226:
      localii.ewS = l1;
      localii.evp = localQualitySessionRuntime.byN();
      localii.ewT = localQualitySessionRuntime.mAx;
      l1 = bu.fpO();
      if ((localQualitySessionRuntime.mAn <= 0L) || (l1 <= localQualitySessionRuntime.mAn)) {
        break label304;
      }
    }
    label299:
    label304:
    for (localii.ewU = l1;; localii.ewU = 0L)
    {
      localii.aLH();
      AppMethodBeat.o(222935);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label226;
    }
  }
  
  public static void E(p paramp)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = aA(paramp.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    ih localih = localQualitySessionRuntime.mAz;
    long l;
    if (localih != null)
    {
      localih.rm(localQualitySessionRuntime.lIU);
      localih.rn(localQualitySessionRuntime.appId);
      localih.etb = localQualitySessionRuntime.mAf;
      localih.ewF = ih.a.jo(localQualitySessionRuntime.myD);
      localih.euA = localQualitySessionRuntime.apptype;
      localih.dWt = localQualitySessionRuntime.scene;
      localih.ro(paramp.aXx().username);
      if (!localQualitySessionRuntime.mAB) {
        break label277;
      }
      l = 1L;
      localih.evs = l;
      localih.evp = localQualitySessionRuntime.byN();
      localih.rp(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext()));
      if (!paramp.aXx().cmD) {
        break label282;
      }
      l = 1L;
      label160:
      localih.ewG = l;
      if (!localQualitySessionRuntime.mAA) {
        break label287;
      }
      l = 1L;
      label175:
      localih.ewH = l;
      localih.nZ(paramp.aXx().startTime);
      localih.Vg();
      localih.nX(localih.evJ - localih.evI);
      if (!localQualitySessionRuntime.mAC) {
        break label292;
      }
      l = 1L;
      label226:
      localih.ewL = l;
      if (localQualitySessionRuntime.mAo == null) {
        break label297;
      }
    }
    label277:
    label282:
    label287:
    label292:
    label297:
    for (localih.ewI = 1L;; localih.ewI = 0L)
    {
      localih.ewJ = paramp.aXE();
      localih.ewK = p.aXF();
      localih.aLH();
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
  
  public static void F(p paramp)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = aA(paramp.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.c localc = com.tencent.mm.plugin.appbrand.o.Ld(paramp.mAppId).jBS;
    iu localiu = new iu();
    localiu.esa = localiu.t("InstanceId", localQualitySessionRuntime.lIU, true);
    localiu.euy = localiu.t("AppId", localQualitySessionRuntime.appId, true);
    localiu.etb = localQualitySessionRuntime.mAf;
    localiu.eyR = iu.a.jz(localQualitySessionRuntime.myD);
    localiu.euA = localQualitySessionRuntime.apptype;
    localiu.dWt = localQualitySessionRuntime.scene;
    localiu.oP(localc.jEI);
    localiu.oQ(localc.jEL);
    localiu.oO(localc.jEL - localc.jEI);
    localiu.ewJ = paramp.aXE();
    localiu.eyS = localc.jEI;
    localiu.eyT = localc.jEL;
    localiu.eyU = (localc.jEL - localc.jEI);
    localiu.eyV = localc.jEN;
    localiu.eyW = localc.jEO;
    localiu.eyX = (localc.jEO - localc.jEN);
    localiu.eyY = localc.jEP;
    localiu.eyZ = localc.jEQ;
    localiu.eza = (localc.jEQ - localc.jEP);
    localiu.ewK = p.aXF();
    localiu.ezf = (localc.jEK - localc.jEJ);
    localiu.ezb = localc.jEJ;
    localiu.ezc = (localc.jEJ - localc.jEI);
    localiu.ezd = localc.jEK;
    localiu.eze = (localc.jEL - localc.jEK);
    localiu.ezg = paramp.aXH();
    localiu.ezh = localc.jER;
    localiu.ezi = localc.jEM;
    localiu.ezj = localc.jET;
    localiu.ezk = localc.jEU;
    localiu.ezl = localc.jEV;
    localiu.ezm = localc.jEW;
    localiu.ezn = (localc.jEW - localc.jET);
    localiu.ezo = (localc.jEV - localc.jEU);
    localiu.ezq = p.aXF();
    localiu.ezp = p.aXG();
    localiu.ezr = 1L;
    if (paramp.aWe() != null) {}
    for (long l = paramp.aWe().aZM();; l = 0L)
    {
      localiu.ezs = l;
      localiu.aLH();
      AppMethodBeat.o(160613);
      return;
    }
  }
  
  public static QualitySessionRuntime Ve(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = aA(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(222936);
    String str = paramd.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = aA(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(222936);
      return;
    }
    ae.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.jFm.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.jFm.hashCode())
    {
      ae.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((j.IS_FLAVOR_RED) || (j.DEBUG))
      {
        paramd = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(222936);
        throw paramd;
      }
      AppMethodBeat.o(222936);
      return;
    }
    ik localik = new ik();
    localik.euy = localik.t("AppId", localQualitySessionRuntime.appId, true);
    localik.esa = localik.t("InstanceId", localQualitySessionRuntime.lIU, true);
    localik.exh = localQualitySessionRuntime.myD;
    localik.euA = localQualitySessionRuntime.apptype;
    localik.etb = localQualitySessionRuntime.mAf;
    localik.dWt = localQualitySessionRuntime.scene;
    localik.oh(paramLong);
    localik.Vm();
    localik.og(localik.evJ - localik.evI);
    localik.exi = paramInt1;
    localik.exj = localik.t("filePath", paramString1, true);
    com.tencent.mm.plugin.appbrand.report.d locald = com.tencent.mm.plugin.appbrand.report.d.d(paramd.aYB());
    label390:
    boolean bool;
    switch (5.mzn[locald.ordinal()])
    {
    default: 
      paramInt1 = 0;
      localik.exk = paramInt1;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < v.lGl.length))
      {
        paramLong = v.lGl[paramc.codeCacheStatus];
        localik.exl = paramLong;
        if (!(paramd instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label950;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramd).coW.CN();
        label416:
        if (!bool) {
          break label981;
        }
        paramLong = 1L;
        label424:
        localik.exm = paramLong;
        if (paramc == null) {
          break label987;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localik.exn = paramLong;
        if (!org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.report.d.mvT, locald)) {
          break label993;
        }
        localik.rq(V8.getV8Version());
        label470:
        localik.exo = localik.t("pluginAppid", paramString2, true);
        localik.exp = localik.t("pluginVersion", String.valueOf(paramInt2), true);
        localik.aLH();
        if ((paramd instanceof r))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.o.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localik.evI;
          paramString2.endTime = localik.evJ;
          paramString2.r("fileName", localik.exj);
          paramString2.r("size", Long.valueOf(localik.exi));
          paramString2.c((r)paramd);
        }
        if ((!localQualitySessionRuntime.mAq.mzo) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.mAq.mzo = true;
          localQualitySessionRuntime.mAl = System.currentTimeMillis();
          paramd = localQualitySessionRuntime.jFm;
          paramString1 = new il();
          paramString2 = aA(str, true);
          if (paramString2 != null)
          {
            paramString1.euy = paramString1.t("AppId", paramString2.appId, true);
            paramString1.esa = paramString1.t("InstanceId", paramString2.lIU, true);
            paramString1.exq = il.a.jr(paramString2.myD);
            paramString1.euA = paramString2.apptype;
            paramString1.etb = paramString2.mAf;
            paramString1.dWt = paramString2.scene;
            paramString1.oj(paramString2.mAi);
            paramString1.Vn();
            paramString1.oi(paramString1.evJ - paramString2.mAi);
            paramString1.ewR = paramString1.t("path", com.tencent.mm.compatible.util.q.encode(paramd.aWx()), true);
            if (!paramd.jCo) {
              break label1028;
            }
            paramLong = 1L;
            label783:
            paramString1.evs = paramLong;
            if (paramString2.mAo == null) {
              break label1040;
            }
            if (!paramString2.mAo.brH()) {
              break label1034;
            }
            paramLong = 1L;
            paramString1.ewS = paramLong;
          }
        }
      }
      break;
    }
    label950:
    label981:
    label987:
    label993:
    while (!j.DEBUG) {
      for (;;)
      {
        paramString1.evp = paramString2.byN();
        paramString1.evc = paramString1.t("networkType", com.tencent.mm.plugin.appbrand.report.q.dO(ak.getContext()), true);
        paramString1.ewT = paramString2.mAx;
        paramString1.exr = paramString2.byQ();
        paramString1.aLH();
        if (DebuggerShell.bfe()) {
          com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localik.evI, localik.evJ);
        }
        AppMethodBeat.o(222936);
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
        if ((paramd instanceof ad))
        {
          bool = ((ad)paramd).aXz().coW.CN();
          break label416;
        }
        bool = false;
        break label416;
        paramLong = 0L;
        break label424;
        paramLong = 0L;
        break label443;
        if (!(paramd.aYB() instanceof ax)) {
          break label470;
        }
        localik.rq(b.byH());
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
    AppMethodBeat.o(222936);
    throw paramd;
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, p paramp)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = aA(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.mAk = System.currentTimeMillis();
    localQualitySessionRuntime1.mAo = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime1.mAi = paramp.aXx().startTime;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramp.c(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      ae.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    jb localjb;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48186);
          if (this.mzk.jFm.isDestroyed())
          {
            AppMethodBeat.o(48186);
            return;
          }
          e locale;
          if (!this.mzk.ciE)
          {
            locale = this.mzk.mAr;
            QualitySessionRuntime localQualitySessionRuntime = this.mzk;
            AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
            ae.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
            int i = localQualitySessionRuntime.jFm.aXx().uin;
            double d1 = localAppBrandSysConfigWC.cnh.kad;
            double d2 = new Random(i ^ System.nanoTime()).nextDouble();
            boolean bool2 = DebuggerShell.bfe();
            if ((d2 <= d1) || (bool2)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              ae.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f] monkeyMode[%b]", new Object[] { Boolean.valueOf(bool1), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(bool2) });
              if (!bool1) {
                break;
              }
              try
              {
                locale.a(localQualitySessionRuntime, localAppBrandSysConfigWC.cnh.kae, e.a.mzy, false);
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
      localjb = new jb();
      localQualitySessionRuntime2 = aA(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localjb.euy = localjb.t("AppId", localQualitySessionRuntime2.appId, true);
    localjb.esa = localjb.t("InstanceId", localQualitySessionRuntime2.lIU, true);
    localjb.eAJ = jb.a.jH(localQualitySessionRuntime2.myD);
    localjb.euA = localQualitySessionRuntime2.apptype;
    localjb.dWt = localQualitySessionRuntime2.scene;
    localjb.etb = localQualitySessionRuntime2.mAf;
    localjb.pB(paramp.aXx().startTime);
    localjb.Vw();
    localjb.pA(localjb.evJ - paramp.aXx().startTime);
    localjb.eAR = (paramAppStartupPerformanceReportBundle.lKI - paramAppStartupPerformanceReportBundle.lKH);
    localjb.eAS = (paramAppStartupPerformanceReportBundle.lKK - paramAppStartupPerformanceReportBundle.lKJ);
    localjb.eAT = localQualitySessionRuntime2.mAg;
    localjb.eAU = paramAppStartupPerformanceReportBundle.lKN;
    Object localObject = paramp.aXw();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramp.aXx();
    label307:
    label325:
    long l1;
    if (paramAppStartupPerformanceReportBundle.lKO)
    {
      paramString = jb.c.eBe;
      localjb.eAL = paramString;
      if (!localAppBrandInitConfigWC.cmD) {
        break label572;
      }
      paramString = jb.b.eBb;
      localjb.eAM = paramString;
      if (!paramp.jCo) {
        break label579;
      }
      l1 = 1L;
      label341:
      localjb.eAN = l1;
      long l2 = 0L;
      if (com.tencent.mm.vfs.o.fB(((AppBrandSysConfigWC)localObject).kbw.pkgPath)) {
        break label585;
      }
      paramString = ((AppBrandSysConfigWC)localObject).kbw.jLY.iterator();
      do
      {
        l1 = l2;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (ModulePkgInfo)paramString.next();
      } while (!com.tencent.mm.vfs.o.fB(((ModulePkgInfo)localObject).pkgPath));
      l1 = com.tencent.mm.vfs.o.aZR(((ModulePkgInfo)localObject).pkgPath);
      label422:
      if (!paramp.jCo) {
        break label601;
      }
      label429:
      localjb.eAK = l1;
      localjb.ehL = f.getNetworkType();
      localjb.ewT = localQualitySessionRuntime2.mAx;
      localjb.evp = localQualitySessionRuntime2.byN();
      localjb.pC(localQualitySessionRuntime2.mAo.lKG - localQualitySessionRuntime2.mAo.lKp);
      if (!paramAppStartupPerformanceReportBundle.lKP) {
        break label607;
      }
    }
    label572:
    label579:
    label585:
    label601:
    label607:
    for (paramString = jb.d.eBh;; paramString = jb.d.eBi)
    {
      localjb.eAV = paramString;
      localjb.eAW = (paramAppStartupPerformanceReportBundle.lKM - paramAppStartupPerformanceReportBundle.lKL);
      localjb.exr = localQualitySessionRuntime2.byQ();
      localjb.aLH();
      if (!DebuggerShell.bfe()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localjb.euy, "ResourcePrepare", localjb.evI, localjb.evJ);
      break;
      paramString = jb.c.eBf;
      break label307;
      paramString = jb.b.eBc;
      break label325;
      l1 = 0L;
      break label341;
      l1 = com.tencent.mm.vfs.o.aZR(((AppBrandSysConfigWC)localObject).kbw.pkgPath);
      break label422;
      l1 = 0L;
      break label429;
    }
  }
  
  /* Error */
  public static void a(String paramString, p paramp)
  {
    // Byte code:
    //   0: ldc_w 1152
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +26 -> 41
    //   18: ldc 63
    //   20: ldc_w 1154
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 216	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1152
    //   37: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 63
    //   43: ldc_w 1156
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 86	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 4
    //   59: aconst_null
    //   60: putfield 345	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAz	Lcom/tencent/mm/g/b/a/ih;
    //   63: new 1158	com/tencent/mm/g/b/a/im
    //   66: dup
    //   67: invokespecial 1159	com/tencent/mm/g/b/a/im:<init>	()V
    //   70: astore 4
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +448 -> 529
    //   84: aload 4
    //   86: aload 4
    //   88: ldc 233
    //   90: aload 5
    //   92: getfield 195	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1160	com/tencent/mm/g/b/a/im:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1161	com/tencent/mm/g/b/a/im:euy	Ljava/lang/String;
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 221
    //   108: aload 5
    //   110: getfield 224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lIU	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1160	com/tencent/mm/g/b/a/im:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1162	com/tencent/mm/g/b/a/im:esa	Ljava/lang/String;
    //   120: aload 4
    //   122: aload 5
    //   124: getfield 245	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:myD	I
    //   127: invokestatic 1168	com/tencent/mm/g/b/a/im$a:js	(I)Lcom/tencent/mm/g/b/a/im$a;
    //   130: putfield 1172	com/tencent/mm/g/b/a/im:exw	Lcom/tencent/mm/g/b/a/im$a;
    //   133: aload 4
    //   135: aload 5
    //   137: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1173	com/tencent/mm/g/b/a/im:euA	J
    //   144: aload 4
    //   146: aload 5
    //   148: getfield 239	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAf	I
    //   151: i2l
    //   152: putfield 1174	com/tencent/mm/g/b/a/im:etb	J
    //   155: aload 4
    //   157: aload 5
    //   159: getfield 369	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1175	com/tencent/mm/g/b/a/im:dWt	J
    //   166: aload 4
    //   168: aload_1
    //   169: invokevirtual 92	com/tencent/mm/plugin/appbrand/p:aXx	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   172: getfield 264	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   175: invokevirtual 1179	com/tencent/mm/g/b/a/im:ol	(J)Lcom/tencent/mm/g/b/a/im;
    //   178: pop
    //   179: aload 4
    //   181: invokevirtual 1183	com/tencent/mm/g/b/a/im:Vo	()Lcom/tencent/mm/g/b/a/im;
    //   184: pop
    //   185: aload 4
    //   187: aload 4
    //   189: getfield 1184	com/tencent/mm/g/b/a/im:evJ	J
    //   192: aload 4
    //   194: getfield 1185	com/tencent/mm/g/b/a/im:evI	J
    //   197: lsub
    //   198: invokevirtual 1188	com/tencent/mm/g/b/a/im:ok	(J)Lcom/tencent/mm/g/b/a/im;
    //   201: pop
    //   202: aload 4
    //   204: aload 4
    //   206: ldc_w 287
    //   209: aload_1
    //   210: invokevirtual 1192	com/tencent/mm/plugin/appbrand/p:aXy	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   213: invokevirtual 1197	com/tencent/mm/plugin/appbrand/page/u:getCurrentUrl	()Ljava/lang/String;
    //   216: invokestatic 295	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 300	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: iconst_1
    //   223: invokevirtual 1160	com/tencent/mm/g/b/a/im:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   226: putfield 1198	com/tencent/mm/g/b/a/im:ewR	Ljava/lang/String;
    //   229: aload 5
    //   231: getfield 306	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAB	Z
    //   234: ifeq +895 -> 1129
    //   237: lconst_1
    //   238: lstore_2
    //   239: aload 4
    //   241: lload_2
    //   242: putfield 1199	com/tencent/mm/g/b/a/im:evs	J
    //   245: aload 5
    //   247: getfield 313	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAo	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   250: ifnull +889 -> 1139
    //   253: aload 5
    //   255: getfield 313	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAo	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   258: invokevirtual 318	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:brH	()Z
    //   261: ifeq +873 -> 1134
    //   264: lconst_1
    //   265: lstore_2
    //   266: aload 4
    //   268: lload_2
    //   269: putfield 1200	com/tencent/mm/g/b/a/im:ewS	J
    //   272: aload 4
    //   274: aload 5
    //   276: invokevirtual 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byN	()J
    //   279: putfield 1201	com/tencent/mm/g/b/a/im:evp	J
    //   282: aload 4
    //   284: lconst_0
    //   285: putfield 1204	com/tencent/mm/g/b/a/im:exa	J
    //   288: aload 4
    //   290: aload 4
    //   292: ldc_w 890
    //   295: invokestatic 386	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   298: invokestatic 895	com/tencent/mm/plugin/appbrand/report/q:dO	(Landroid/content/Context;)Ljava/lang/String;
    //   301: iconst_1
    //   302: invokevirtual 1160	com/tencent/mm/g/b/a/im:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   305: putfield 1205	com/tencent/mm/g/b/a/im:evc	Ljava/lang/String;
    //   308: aload_1
    //   309: invokevirtual 1028	com/tencent/mm/plugin/appbrand/p:aXw	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   312: getfield 1209	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:cnk	Ljava/util/List;
    //   315: astore 6
    //   317: aload_1
    //   318: invokevirtual 1028	com/tencent/mm/plugin/appbrand/p:aXw	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   321: getfield 1058	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:kbw	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   324: getfield 1213	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:jMa	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   327: astore 7
    //   329: aload 6
    //   331: ifnull +833 -> 1164
    //   334: aload 6
    //   336: invokeinterface 1217 1 0
    //   341: ifle +823 -> 1164
    //   344: aload 4
    //   346: lconst_1
    //   347: putfield 1220	com/tencent/mm/g/b/a/im:exb	J
    //   350: aload 4
    //   352: aload 5
    //   354: getfield 182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAx	J
    //   357: putfield 1221	com/tencent/mm/g/b/a/im:ewT	J
    //   360: aload 5
    //   362: invokevirtual 1224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byO	()Z
    //   365: ifeq +847 -> 1212
    //   368: lconst_1
    //   369: lstore_2
    //   370: aload 4
    //   372: lload_2
    //   373: putfield 1227	com/tencent/mm/g/b/a/im:exc	J
    //   376: aload 4
    //   378: aload_1
    //   379: invokevirtual 432	com/tencent/mm/plugin/appbrand/p:aXE	()I
    //   382: i2l
    //   383: putfield 1228	com/tencent/mm/g/b/a/im:ewJ	J
    //   386: aload_1
    //   387: invokevirtual 92	com/tencent/mm/plugin/appbrand/p:aXx	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   390: getfield 1231	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:kaU	Z
    //   393: ifeq +824 -> 1217
    //   396: lconst_1
    //   397: lstore_2
    //   398: aload 4
    //   400: lload_2
    //   401: putfield 1234	com/tencent/mm/g/b/a/im:exy	J
    //   404: aload_1
    //   405: invokevirtual 617	com/tencent/mm/plugin/appbrand/p:aWe	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   408: astore 6
    //   410: aload 6
    //   412: ifnull +810 -> 1222
    //   415: aload 4
    //   417: aload 4
    //   419: ldc_w 1236
    //   422: aload 6
    //   424: invokeinterface 1239 1 0
    //   429: iconst_1
    //   430: invokevirtual 1160	com/tencent/mm/g/b/a/im:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   433: putfield 1242	com/tencent/mm/g/b/a/im:exx	Ljava/lang/String;
    //   436: aload 4
    //   438: aload 5
    //   440: getfield 333	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAn	J
    //   443: putfield 1243	com/tencent/mm/g/b/a/im:ewU	J
    //   446: aload 4
    //   448: aload 5
    //   450: invokevirtual 902	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byQ	()J
    //   453: putfield 1244	com/tencent/mm/g/b/a/im:exr	J
    //   456: aload 4
    //   458: invokevirtual 1245	com/tencent/mm/g/b/a/im:aLH	()Z
    //   461: pop
    //   462: invokestatic 911	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bfe	()Z
    //   465: ifeq +64 -> 529
    //   468: aload 5
    //   470: getfield 306	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAB	Z
    //   473: ifeq +771 -> 1244
    //   476: lconst_1
    //   477: lstore_2
    //   478: ldc_w 1247
    //   481: iconst_2
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: ldc_w 1249
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: lload_2
    //   494: invokestatic 821	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   497: aastore
    //   498: invokestatic 1253	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   501: astore 5
    //   503: aload 4
    //   505: getfield 1161	com/tencent/mm/g/b/a/im:euy	Ljava/lang/String;
    //   508: ldc_w 1255
    //   511: ldc_w 1257
    //   514: aload 4
    //   516: getfield 1185	com/tencent/mm/g/b/a/im:evI	J
    //   519: aload 4
    //   521: getfield 1184	com/tencent/mm/g/b/a/im:evJ	J
    //   524: aload 5
    //   526: invokestatic 1260	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   529: new 1262	com/tencent/mm/g/b/a/je
    //   532: dup
    //   533: invokespecial 1263	com/tencent/mm/g/b/a/je:<init>	()V
    //   536: astore 4
    //   538: aload_0
    //   539: iconst_1
    //   540: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   543: astore 5
    //   545: aload 5
    //   547: ifnull +256 -> 803
    //   550: aload 5
    //   552: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   555: putfield 1266	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAm	J
    //   558: aload 4
    //   560: aload 4
    //   562: ldc 233
    //   564: aload 5
    //   566: getfield 195	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   569: iconst_1
    //   570: invokevirtual 1267	com/tencent/mm/g/b/a/je:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   573: putfield 1268	com/tencent/mm/g/b/a/je:euy	Ljava/lang/String;
    //   576: aload 4
    //   578: aload 4
    //   580: ldc 221
    //   582: aload 5
    //   584: getfield 224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lIU	Ljava/lang/String;
    //   587: iconst_1
    //   588: invokevirtual 1267	com/tencent/mm/g/b/a/je:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   591: putfield 1269	com/tencent/mm/g/b/a/je:esa	Ljava/lang/String;
    //   594: aload 4
    //   596: aload 5
    //   598: getfield 245	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:myD	I
    //   601: invokestatic 1275	com/tencent/mm/g/b/a/je$a:jK	(I)Lcom/tencent/mm/g/b/a/je$a;
    //   604: putfield 1279	com/tencent/mm/g/b/a/je:eBs	Lcom/tencent/mm/g/b/a/je$a;
    //   607: aload 4
    //   609: aload 5
    //   611: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   614: i2l
    //   615: putfield 1280	com/tencent/mm/g/b/a/je:euA	J
    //   618: aload 4
    //   620: aload 5
    //   622: getfield 239	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAf	I
    //   625: i2l
    //   626: putfield 1281	com/tencent/mm/g/b/a/je:etb	J
    //   629: aload 4
    //   631: aload 5
    //   633: getfield 369	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   636: i2l
    //   637: putfield 1282	com/tencent/mm/g/b/a/je:dWt	J
    //   640: aload 4
    //   642: aload 5
    //   644: getfield 949	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAk	J
    //   647: invokevirtual 1286	com/tencent/mm/g/b/a/je:pM	(J)Lcom/tencent/mm/g/b/a/je;
    //   650: pop
    //   651: aload 4
    //   653: invokevirtual 1290	com/tencent/mm/g/b/a/je:Vy	()Lcom/tencent/mm/g/b/a/je;
    //   656: pop
    //   657: aload 4
    //   659: aload 4
    //   661: getfield 1291	com/tencent/mm/g/b/a/je:evJ	J
    //   664: aload 5
    //   666: getfield 949	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAk	J
    //   669: lsub
    //   670: invokevirtual 1294	com/tencent/mm/g/b/a/je:pL	(J)Lcom/tencent/mm/g/b/a/je;
    //   673: pop
    //   674: aload 4
    //   676: aload 5
    //   678: invokevirtual 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byN	()J
    //   681: putfield 1295	com/tencent/mm/g/b/a/je:evp	J
    //   684: aload 4
    //   686: aload 4
    //   688: ldc_w 287
    //   691: aload_1
    //   692: invokevirtual 1192	com/tencent/mm/plugin/appbrand/p:aXy	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   695: invokevirtual 1197	com/tencent/mm/plugin/appbrand/page/u:getCurrentUrl	()Ljava/lang/String;
    //   698: invokestatic 300	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   701: iconst_1
    //   702: invokevirtual 1267	com/tencent/mm/g/b/a/je:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   705: putfield 1296	com/tencent/mm/g/b/a/je:ewR	Ljava/lang/String;
    //   708: aload 4
    //   710: lconst_0
    //   711: putfield 1297	com/tencent/mm/g/b/a/je:exa	J
    //   714: aload 4
    //   716: aload 4
    //   718: ldc_w 890
    //   721: invokestatic 386	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   724: invokestatic 895	com/tencent/mm/plugin/appbrand/report/q:dO	(Landroid/content/Context;)Ljava/lang/String;
    //   727: iconst_1
    //   728: invokevirtual 1267	com/tencent/mm/g/b/a/je:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   731: putfield 1298	com/tencent/mm/g/b/a/je:evc	Ljava/lang/String;
    //   734: aload 4
    //   736: aload 5
    //   738: getfield 182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAx	J
    //   741: putfield 1299	com/tencent/mm/g/b/a/je:ewT	J
    //   744: aload 5
    //   746: invokevirtual 1224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byO	()Z
    //   749: ifeq +500 -> 1249
    //   752: lconst_1
    //   753: lstore_2
    //   754: aload 4
    //   756: lload_2
    //   757: putfield 1300	com/tencent/mm/g/b/a/je:exc	J
    //   760: aload 4
    //   762: aload 5
    //   764: invokevirtual 902	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byQ	()J
    //   767: putfield 1301	com/tencent/mm/g/b/a/je:exr	J
    //   770: aload 4
    //   772: invokevirtual 1302	com/tencent/mm/g/b/a/je:aLH	()Z
    //   775: pop
    //   776: invokestatic 911	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bfe	()Z
    //   779: ifeq +24 -> 803
    //   782: aload 4
    //   784: getfield 1268	com/tencent/mm/g/b/a/je:euy	Ljava/lang/String;
    //   787: ldc_w 1304
    //   790: aload 4
    //   792: getfield 1305	com/tencent/mm/g/b/a/je:evI	J
    //   795: aload 4
    //   797: getfield 1291	com/tencent/mm/g/b/a/je:evJ	J
    //   800: invokestatic 919	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   803: new 1307	com/tencent/mm/g/b/a/ij
    //   806: dup
    //   807: invokespecial 1308	com/tencent/mm/g/b/a/ij:<init>	()V
    //   810: astore 4
    //   812: aload_0
    //   813: iconst_1
    //   814: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   817: astore 5
    //   819: aload 5
    //   821: ifnull +275 -> 1096
    //   824: aload 4
    //   826: aload 4
    //   828: ldc 233
    //   830: aload 5
    //   832: getfield 195	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   835: iconst_1
    //   836: invokevirtual 1309	com/tencent/mm/g/b/a/ij:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   839: putfield 1310	com/tencent/mm/g/b/a/ij:euy	Ljava/lang/String;
    //   842: aload 4
    //   844: aload 4
    //   846: ldc 221
    //   848: aload 5
    //   850: getfield 224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lIU	Ljava/lang/String;
    //   853: iconst_1
    //   854: invokevirtual 1309	com/tencent/mm/g/b/a/ij:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   857: putfield 1311	com/tencent/mm/g/b/a/ij:esa	Ljava/lang/String;
    //   860: aload 4
    //   862: aload 5
    //   864: getfield 245	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:myD	I
    //   867: invokestatic 1317	com/tencent/mm/g/b/a/ij$a:jq	(I)Lcom/tencent/mm/g/b/a/ij$a;
    //   870: putfield 1321	com/tencent/mm/g/b/a/ij:ewZ	Lcom/tencent/mm/g/b/a/ij$a;
    //   873: aload 4
    //   875: aload 5
    //   877: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   880: i2l
    //   881: putfield 1322	com/tencent/mm/g/b/a/ij:euA	J
    //   884: aload 4
    //   886: aload 5
    //   888: getfield 239	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAf	I
    //   891: i2l
    //   892: putfield 1323	com/tencent/mm/g/b/a/ij:etb	J
    //   895: aload 4
    //   897: aload 5
    //   899: getfield 369	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   902: i2l
    //   903: putfield 1324	com/tencent/mm/g/b/a/ij:dWt	J
    //   906: aload 4
    //   908: aload 5
    //   910: getfield 847	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAl	J
    //   913: invokevirtual 1328	com/tencent/mm/g/b/a/ij:of	(J)Lcom/tencent/mm/g/b/a/ij;
    //   916: pop
    //   917: aload 4
    //   919: invokevirtual 1332	com/tencent/mm/g/b/a/ij:Vl	()Lcom/tencent/mm/g/b/a/ij;
    //   922: pop
    //   923: aload 4
    //   925: aload 4
    //   927: getfield 1333	com/tencent/mm/g/b/a/ij:evJ	J
    //   930: aload 5
    //   932: getfield 847	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAl	J
    //   935: lsub
    //   936: invokevirtual 1336	com/tencent/mm/g/b/a/ij:oe	(J)Lcom/tencent/mm/g/b/a/ij;
    //   939: pop
    //   940: aload 4
    //   942: aload 5
    //   944: invokevirtual 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byN	()J
    //   947: putfield 1337	com/tencent/mm/g/b/a/ij:evp	J
    //   950: aload 4
    //   952: aload 4
    //   954: ldc_w 287
    //   957: aload_1
    //   958: invokevirtual 1192	com/tencent/mm/plugin/appbrand/p:aXy	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   961: invokevirtual 1197	com/tencent/mm/plugin/appbrand/page/u:getCurrentUrl	()Ljava/lang/String;
    //   964: invokestatic 300	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   967: iconst_1
    //   968: invokevirtual 1309	com/tencent/mm/g/b/a/ij:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   971: putfield 1338	com/tencent/mm/g/b/a/ij:ewR	Ljava/lang/String;
    //   974: aload 4
    //   976: lconst_0
    //   977: putfield 1339	com/tencent/mm/g/b/a/ij:exa	J
    //   980: aload 4
    //   982: aload 4
    //   984: ldc_w 890
    //   987: invokestatic 386	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   990: invokestatic 895	com/tencent/mm/plugin/appbrand/report/q:dO	(Landroid/content/Context;)Ljava/lang/String;
    //   993: iconst_1
    //   994: invokevirtual 1309	com/tencent/mm/g/b/a/ij:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   997: putfield 1340	com/tencent/mm/g/b/a/ij:evc	Ljava/lang/String;
    //   1000: aload_1
    //   1001: invokevirtual 1028	com/tencent/mm/plugin/appbrand/p:aXw	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1004: getfield 1209	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:cnk	Ljava/util/List;
    //   1007: astore 6
    //   1009: aload_1
    //   1010: invokevirtual 1028	com/tencent/mm/plugin/appbrand/p:aXw	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1013: getfield 1058	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:kbw	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1016: getfield 1213	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:jMa	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1019: astore_1
    //   1020: aload 6
    //   1022: ifnull +232 -> 1254
    //   1025: aload 6
    //   1027: invokeinterface 1217 1 0
    //   1032: ifle +222 -> 1254
    //   1035: aload 4
    //   1037: lconst_1
    //   1038: putfield 1341	com/tencent/mm/g/b/a/ij:exb	J
    //   1041: aload 4
    //   1043: aload 5
    //   1045: getfield 182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mAx	J
    //   1048: putfield 1342	com/tencent/mm/g/b/a/ij:ewT	J
    //   1051: aload 5
    //   1053: invokevirtual 1224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:byO	()Z
    //   1056: ifeq +241 -> 1297
    //   1059: lconst_1
    //   1060: lstore_2
    //   1061: aload 4
    //   1063: lload_2
    //   1064: putfield 1343	com/tencent/mm/g/b/a/ij:exc	J
    //   1067: aload 4
    //   1069: invokevirtual 1344	com/tencent/mm/g/b/a/ij:aLH	()Z
    //   1072: pop
    //   1073: invokestatic 911	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bfe	()Z
    //   1076: ifeq +20 -> 1096
    //   1079: aload_0
    //   1080: ldc_w 1346
    //   1083: aload 4
    //   1085: getfield 1347	com/tencent/mm/g/b/a/ij:evI	J
    //   1088: aload 4
    //   1090: getfield 1333	com/tencent/mm/g/b/a/ij:evJ	J
    //   1093: invokestatic 919	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1096: ldc_w 1152
    //   1099: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1102: return
    //   1103: astore 6
    //   1105: ldc 63
    //   1107: ldc_w 1349
    //   1110: iconst_2
    //   1111: anewarray 4	java/lang/Object
    //   1114: dup
    //   1115: iconst_0
    //   1116: aload_0
    //   1117: aastore
    //   1118: dup
    //   1119: iconst_1
    //   1120: aload 6
    //   1122: aastore
    //   1123: invokestatic 216	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1126: goto -897 -> 229
    //   1129: lconst_0
    //   1130: lstore_2
    //   1131: goto -892 -> 239
    //   1134: lconst_0
    //   1135: lstore_2
    //   1136: goto -870 -> 266
    //   1139: getstatic 665	com/tencent/mm/sdk/platformtools/j:DEBUG	Z
    //   1142: ifeq -870 -> 272
    //   1145: new 667	java/lang/IllegalStateException
    //   1148: dup
    //   1149: ldc_w 944
    //   1152: invokespecial 672	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1155: astore_0
    //   1156: ldc_w 1152
    //   1159: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1162: aload_0
    //   1163: athrow
    //   1164: aload 7
    //   1166: ifnull +37 -> 1203
    //   1169: aload 7
    //   1171: ldc_w 1351
    //   1174: invokevirtual 1357	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Mq	(Ljava/lang/String;)Ljava/util/List;
    //   1177: astore 6
    //   1179: aload 6
    //   1181: ifnull -831 -> 350
    //   1184: aload 6
    //   1186: invokeinterface 1217 1 0
    //   1191: ifle -841 -> 350
    //   1194: aload 4
    //   1196: lconst_1
    //   1197: putfield 1220	com/tencent/mm/g/b/a/im:exb	J
    //   1200: goto -850 -> 350
    //   1203: aload 4
    //   1205: lconst_0
    //   1206: putfield 1220	com/tencent/mm/g/b/a/im:exb	J
    //   1209: goto -859 -> 350
    //   1212: lconst_0
    //   1213: lstore_2
    //   1214: goto -844 -> 370
    //   1217: lconst_0
    //   1218: lstore_2
    //   1219: goto -821 -> 398
    //   1222: ldc 63
    //   1224: ldc_w 1359
    //   1227: iconst_1
    //   1228: anewarray 4	java/lang/Object
    //   1231: dup
    //   1232: iconst_0
    //   1233: aload_1
    //   1234: getfield 71	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1237: aastore
    //   1238: invokestatic 1362	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1241: goto -805 -> 436
    //   1244: lconst_0
    //   1245: lstore_2
    //   1246: goto -768 -> 478
    //   1249: lconst_0
    //   1250: lstore_2
    //   1251: goto -497 -> 754
    //   1254: aload_1
    //   1255: ifnull +33 -> 1288
    //   1258: aload_1
    //   1259: ldc_w 1351
    //   1262: invokevirtual 1357	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Mq	(Ljava/lang/String;)Ljava/util/List;
    //   1265: astore_1
    //   1266: aload_1
    //   1267: ifnull -226 -> 1041
    //   1270: aload_1
    //   1271: invokeinterface 1217 1 0
    //   1276: ifle -235 -> 1041
    //   1279: aload 4
    //   1281: lconst_1
    //   1282: putfield 1341	com/tencent/mm/g/b/a/ij:exb	J
    //   1285: goto -244 -> 1041
    //   1288: aload 4
    //   1290: lconst_0
    //   1291: putfield 1341	com/tencent/mm/g/b/a/ij:exb	J
    //   1294: goto -253 -> 1041
    //   1297: lconst_0
    //   1298: lstore_2
    //   1299: goto -238 -> 1061
    //   1302: astore 6
    //   1304: goto -330 -> 974
    //   1307: astore 6
    //   1309: goto -601 -> 708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1312	0	paramString	String
    //   0	1312	1	paramp	p
    //   238	1061	2	l	long
    //   11	1278	4	localObject1	Object
    //   77	975	5	localObject2	Object
    //   315	711	6	localObject3	Object
    //   1103	18	6	localException1	Exception
    //   1177	8	6	localList	java.util.List
    //   1302	1	6	localException2	Exception
    //   1307	1	6	localException3	Exception
    //   327	843	7	localWxaRuntimeModulePluginListMap	com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap
    // Exception table:
    //   from	to	target	type
    //   202	229	1103	java/lang/Exception
    //   950	974	1302	java/lang/Exception
    //   684	708	1307	java/lang/Exception
  }
  
  public static void a(String paramString, final com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(48193);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48187);
        QualitySessionRuntime localQualitySessionRuntime = a.Ve(this.jEl);
        if ((localQualitySessionRuntime != null) && (paramb != null))
        {
          Object localObject;
          if ((paramb.mvp != null) && (paramb.mvp.IlX != 0))
          {
            ae.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.mvp.IlX), Integer.valueOf(paramb.mvp.IlY) });
            localObject = null;
            switch (paramb.mvp.IlX)
            {
            default: 
              ae.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
            }
          }
          for (;;)
          {
            if (localObject != null) {
              localQualitySessionRuntime.mAr.a(localQualitySessionRuntime, paramb.mvp.IlY, (e.a)localObject, true);
            }
            if ((paramb.mvr == null) || (!paramb.mvr.IlU)) {
              break label324;
            }
            localObject = com.tencent.luggage.game.e.a.DR();
            boolean bool = paramb.mvr.IlU;
            int i = paramb.mvr.IlV;
            double d = paramb.mvr.IlW;
            try
            {
              ae.i("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Double.valueOf(d) });
              ((com.tencent.luggage.game.e.a)localObject).clG = bool;
              ((com.tencent.luggage.game.e.a)localObject).clH = i;
              ((com.tencent.luggage.game.e.a)localObject).clI = d;
              AppMethodBeat.o(48187);
              return;
              localObject = e.a.mzx;
              continue;
              localObject = e.a.mzy;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.MBNiReporter", localException, "setConfig Exception", new Object[0]);
              }
            }
          }
        }
        ae.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        label324:
        AppMethodBeat.o(48187);
      }
    });
    AppMethodBeat.o(48193);
  }
  
  private static QualitySessionRuntime aA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (mzj)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)mzj.get(paramString);
      if (localQualitySessionRuntime != null) {
        break label108;
      }
      paramString = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[] { paramString });
      if ((paramBoolean) && ((j.DEBUG) || (j.IS_FLAVOR_RED)))
      {
        paramString = new IllegalStateException(paramString);
        AppMethodBeat.o(48191);
        throw paramString;
      }
    }
    ae.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), paramString, new Object[0]);
    label108:
    AppMethodBeat.o(48191);
    return localQualitySessionRuntime;
  }
  
  public static b byG()
  {
    return mzi;
  }
  
  public static final class a
  {
    boolean mzo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */