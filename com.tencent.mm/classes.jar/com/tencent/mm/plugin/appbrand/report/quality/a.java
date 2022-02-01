package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.luggage.game.c.h.1;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.g.b.a.hb.a;
import com.tencent.mm.g.b.a.hc;
import com.tencent.mm.g.b.a.hc.a;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.g.b.a.hf.a;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.g.b.a.ho.a;
import com.tencent.mm.g.b.a.hv;
import com.tencent.mm.g.b.a.hv.a;
import com.tencent.mm.g.b.a.hv.b;
import com.tencent.mm.g.b.a.hv.c;
import com.tencent.mm.g.b.a.hv.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class a
{
  private static final b lUu;
  private static final HashMap<String, QualitySessionRuntime> lUv;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      lUu = new b();
      lUv = new HashMap();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void K(o paramo)
  {
    AppMethodBeat.i(48189);
    ac.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramo.mAppId, Integer.valueOf(paramo.hashCode()) });
    Object localObject2 = paramo.aTS().jDH;
    ??? = localObject2;
    if (localObject2 == null)
    {
      ac.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.a.vf(paramo.aTS().uin), paramo.aTS(), paramo.DC().ccl);
      paramo.aTS().jDH = ((QualitySession)???);
    }
    localObject2 = f.h((QualitySession)???);
    ((QualitySessionRuntime)localObject2).jPl = paramo;
    ((QualitySessionRuntime)localObject2).bYk = paramo.CC();
    ((QualitySessionRuntime)localObject2).lVw = System.currentTimeMillis();
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48185);
        QualitySessionRuntime localQualitySessionRuntime = this.lUw;
        h.a locala = (h.a)com.tencent.luggage.sdk.g.c.a("MemoryInspector.getMemoryMB", new h.1(com.tencent.luggage.game.c.h.bZj));
        if (locala == null) {}
        for (int i = 0;; i = locala.bZm)
        {
          localQualitySessionRuntime.lVC = i;
          AppMethodBeat.o(48185);
          return;
        }
      }
    });
    long l;
    if (1 == paramo.aTS().jDI) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).lVK = l;
      synchronized (lUv)
      {
        if (($assertionsDisabled) || (lUv.get(paramo.mAppId) == null)) {
          break;
        }
        paramo = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramo;
      }
      if (paramo.aTS().jDF) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    lUv.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    com.tencent.mm.plugin.appbrand.g.a(paramo.mAppId, new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(48184);
        ac.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.jcz.mAppId, Integer.valueOf(this.jcz.hashCode()) });
        a.O(this.jcz);
        AppMethodBeat.o(48184);
      }
    });
    AppMethodBeat.o(48189);
  }
  
  public static void L(o paramo)
  {
    long l2 = 1L;
    AppMethodBeat.i(186920);
    QualitySessionRuntime localQualitySessionRuntime = ay(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      ac.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramo.mAppId });
      AppMethodBeat.o(186920);
      return;
    }
    hc localhc = new hc();
    localhc.dZT = localhc.t("InstanceId", localQualitySessionRuntime.lht, true);
    localhc.ecm = localhc.t("AppId", localQualitySessionRuntime.appId, true);
    localhc.eaM = localQualitySessionRuntime.lVs;
    localhc.eew = hc.a.iR(localQualitySessionRuntime.lTR);
    localhc.eco = localQualitySessionRuntime.apptype;
    localhc.lS(paramo.aTS().startTime);
    localhc.lT(bs.eWj());
    localhc.lR(localhc.edx - localhc.edw);
    localhc.eex = localhc.t("path", com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramo.aSI())), true);
    if (localQualitySessionRuntime.lVO)
    {
      l1 = 1L;
      localhc.edg = l1;
      if ((localQualitySessionRuntime.lVB == null) || (!localQualitySessionRuntime.lVB.bnl())) {
        break label283;
      }
    }
    label283:
    for (long l1 = l2;; l1 = 0L)
    {
      localhc.eey = l1;
      localhc.edd = localQualitySessionRuntime.btP();
      localhc.eez = localQualitySessionRuntime.lVK;
      l1 = bs.eWj();
      if (localQualitySessionRuntime.lVA > 0L) {
        break label288;
      }
      localhc.eeA = 0L;
      AppMethodBeat.o(186920);
      return;
      l1 = 0L;
      break;
    }
    label288:
    if (l1 > localQualitySessionRuntime.lVA)
    {
      localhc.eeA = l1;
      AppMethodBeat.o(186920);
      return;
    }
    localhc.eeA = 0L;
    AppMethodBeat.o(186920);
  }
  
  public static void M(o paramo)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = ay(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    hb localhb = localQualitySessionRuntime.lVM;
    long l;
    if (localhb != null)
    {
      localhb.on(localQualitySessionRuntime.lht);
      localhb.oo(localQualitySessionRuntime.appId);
      localhb.eaM = localQualitySessionRuntime.lVs;
      localhb.eek = hb.a.iQ(localQualitySessionRuntime.lTR);
      localhb.eco = localQualitySessionRuntime.apptype;
      localhb.dHY = localQualitySessionRuntime.scene;
      localhb.op(paramo.aTS().username);
      if (!localQualitySessionRuntime.lVO) {
        break label278;
      }
      l = 1L;
      localhb.edg = l;
      localhb.edd = localQualitySessionRuntime.btP();
      localhb.oq(com.tencent.mm.plugin.appbrand.report.g.getNetworkType(ai.getContext()));
      if (!paramo.aTS().cck) {
        break label283;
      }
      l = 1L;
      label160:
      localhb.eem = l;
      if (!localQualitySessionRuntime.lVN) {
        break label288;
      }
      l = 1L;
      label175:
      localhb.een = l;
      localhb.lP(paramo.aTS().startTime);
      localhb.SM();
      localhb.lN(localhb.edx - localhb.edw);
      if (!localQualitySessionRuntime.lVP) {
        break label293;
      }
      l = 1L;
      label226:
      localhb.eer = l;
      if (localQualitySessionRuntime.lVB == null) {
        break label298;
      }
    }
    label278:
    label283:
    label288:
    label293:
    label298:
    for (localhb.eeo = 1L;; localhb.eeo = 0L)
    {
      localhb.eep = paramo.jgq;
      localhb.eeq = paramo.aTf();
      localhb.aHZ();
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
  
  public static void N(o paramo)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = ay(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.b localb = n.Hr(paramo.mAppId).jfM;
    ho localho = new ho();
    localho.dZT = localho.t("InstanceId", localQualitySessionRuntime.lht, true);
    localho.ecm = localho.t("AppId", localQualitySessionRuntime.appId, true);
    localho.eaM = localQualitySessionRuntime.lVs;
    localho.egt = ho.a.ja(localQualitySessionRuntime.lTR);
    localho.eco = localQualitySessionRuntime.apptype;
    localho.dHY = localQualitySessionRuntime.scene;
    localho.mE(localb.jiv);
    localho.mF(localb.jiy);
    localho.mD(localb.jiy - localb.jiv);
    localho.eep = paramo.jgq;
    localho.egu = localb.jiv;
    localho.egv = localb.jiy;
    localho.egw = (localb.jiy - localb.jiv);
    localho.egx = localb.jiz;
    localho.egy = localb.jiA;
    localho.egz = (localb.jiA - localb.jiz);
    localho.egA = localb.jiB;
    localho.egB = localb.jiC;
    localho.egC = (localb.jiC - localb.jiB);
    localho.eeq = paramo.aTf();
    localho.egH = (localb.jix - localb.jiw);
    localho.egD = localb.jiw;
    localho.egE = (localb.jiw - localb.jiv);
    localho.egF = localb.jix;
    localho.egG = (localb.jiy - localb.jix);
    localho.egI = paramo.aUe();
    localho.egJ = localb.jiD;
    localho.aHZ();
    AppMethodBeat.o(160613);
  }
  
  public static QualitySessionRuntime QN(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = ay(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static void a(d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(186921);
    String str = paramd.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = ay(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(186921);
      return;
    }
    ac.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.jPl.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.jPl.hashCode())
    {
      ac.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        paramd = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(186921);
        throw paramd;
      }
      AppMethodBeat.o(186921);
      return;
    }
    he localhe = new he();
    localhe.ecm = localhe.t("AppId", localQualitySessionRuntime.appId, true);
    localhe.dZT = localhe.t("InstanceId", localQualitySessionRuntime.lht, true);
    localhe.eeN = localQualitySessionRuntime.lTR;
    localhe.eco = localQualitySessionRuntime.apptype;
    localhe.eaM = localQualitySessionRuntime.lVs;
    localhe.dHY = localQualitySessionRuntime.scene;
    localhe.lX(paramLong);
    localhe.SS();
    localhe.lW(localhe.edx - localhe.edw);
    localhe.eeO = paramInt1;
    localhe.eeP = localhe.t("filePath", paramString1, true);
    com.tencent.mm.plugin.appbrand.report.c localc = com.tencent.mm.plugin.appbrand.report.c.d(paramd.aUV());
    switch (5.lUz[localc.ordinal()])
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      localhe.eeQ = paramInt1;
      label390:
      boolean bool;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < com.tencent.mm.plugin.appbrand.jsruntime.v.leN.length))
      {
        paramLong = com.tencent.mm.plugin.appbrand.jsruntime.v.leN[paramc.codeCacheStatus];
        localhe.eeR = paramLong;
        if (!(paramd instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label956;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramd).ceD.Bl();
        label416:
        if (!bool) {
          break label987;
        }
        paramLong = 1L;
        label424:
        localhe.eeS = paramLong;
        if (paramc == null) {
          break label993;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localhe.eeT = paramLong;
        if (!org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.report.c.lRf, localc)) {
          break label999;
        }
        localhe.or(V8.getV8Version());
        label470:
        localhe.eeV = localhe.t("pluginAppid", paramString2, true);
        localhe.eeW = localhe.t("pluginVersion", String.valueOf(paramInt2), true);
        localhe.aHZ();
        if ((paramd instanceof q))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.l.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localhe.edw;
          paramString2.endTime = localhe.edx;
          paramString2.s("fileName", localhe.eeP);
          paramString2.s("size", Long.valueOf(localhe.eeO));
          paramString2.c((q)paramd);
        }
        if ((!localQualitySessionRuntime.lVD.lUA) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.lVD.lUA = true;
          localQualitySessionRuntime.lVy = System.currentTimeMillis();
          paramd = localQualitySessionRuntime.jPl;
          paramString1 = new hf();
          paramString2 = ay(str, true);
          if (paramString2 != null)
          {
            paramString1.ecm = paramString1.t("AppId", paramString2.appId, true);
            paramString1.dZT = paramString1.t("InstanceId", paramString2.lht, true);
            paramString1.eeX = hf.a.iT(paramString2.lTR);
            paramString1.eco = paramString2.apptype;
            paramString1.eaM = paramString2.lVs;
            paramString1.dHY = paramString2.scene;
            paramString1.lZ(paramString2.lVv);
            paramString1.ST();
            paramString1.lY(paramString1.edx - paramString2.lVv);
          }
        }
      }
      try
      {
        paramString1.eex = paramString1.t("path", com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramd.aTT().getCurrentUrl())), true);
        if (paramd.jgh)
        {
          paramLong = 1L;
          paramString1.edg = paramLong;
          if (paramString2.lVB == null) {
            break label1073;
          }
          if (!paramString2.lVB.bnl()) {
            break label1067;
          }
          paramLong = 1L;
          paramString1.eey = paramLong;
          paramString1.edd = paramString2.btP();
          paramString1.ecQ = paramString1.t("networkType", com.tencent.mm.plugin.appbrand.report.p.dL(ai.getContext()), true);
          paramString1.eez = paramString2.lVK;
          paramString1.eeY = paramString2.btT();
          paramString1.aHZ();
          if (DebuggerShell.baW()) {
            com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localhe.edw, localhe.edx);
          }
          AppMethodBeat.o(186921);
          return;
          paramInt1 = 102;
          continue;
          paramInt1 = 103;
          continue;
          paramInt1 = 104;
          continue;
          paramInt1 = 6;
          continue;
          paramInt1 = 5;
          continue;
          paramInt1 = 4;
          continue;
          paramInt1 = 3;
          continue;
          paramInt1 = 2;
          continue;
          paramInt1 = 1;
          continue;
          paramLong = 4L;
          break label390;
          label956:
          if ((paramd instanceof ae))
          {
            bool = ((ae)paramd).aTU().ceD.Bl();
            break label416;
          }
          bool = false;
          break label416;
          label987:
          paramLong = 0L;
          break label424;
          label993:
          paramLong = 0L;
          break label443;
          label999:
          if (!(paramd.aUV() instanceof ay)) {
            break label470;
          }
          localhe.or(b.btJ());
        }
      }
      catch (NullPointerException paramc)
      {
        label1067:
        label1073:
        do
        {
          for (;;)
          {
            ac.e("MicroMsg.AppBrandQualitySystem", "launchToJsInject appId %s getCurrentUrl npe = %s", new Object[] { str, paramc });
            continue;
            paramLong = 0L;
            continue;
            paramLong = 0L;
          }
        } while (!com.tencent.mm.sdk.platformtools.h.DEBUG);
        paramd = new IllegalStateException("StartupBundle not registered.");
        AppMethodBeat.o(186921);
        throw paramd;
      }
    }
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, o paramo)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = ay(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.lVx = System.currentTimeMillis();
    localQualitySessionRuntime1.lVB = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime1.lVv = paramo.aTS().startTime;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramo.c(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      ac.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    hv localhv;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48186);
          if (this.lUw.jPl.isDestroyed())
          {
            AppMethodBeat.o(48186);
            return;
          }
          e locale;
          if (!this.lUw.bYk)
          {
            locale = this.lUw.lVE;
            QualitySessionRuntime localQualitySessionRuntime = this.lUw;
            AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
            ac.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
            int i = localQualitySessionRuntime.jPl.aTS().uin;
            double d1 = localAppBrandSysConfigWC.ccO.jCS;
            double d2 = new Random(i ^ System.nanoTime()).nextDouble();
            if (d2 <= d1) {}
            for (boolean bool = true;; bool = false)
            {
              ac.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", new Object[] { Boolean.valueOf(bool), Double.valueOf(d2), Double.valueOf(d1) });
              if (!bool) {
                break;
              }
              try
              {
                locale.a(localQualitySessionRuntime, localAppBrandSysConfigWC.ccO.jCT, e.a.lUL, false);
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
      localhv = new hv();
      localQualitySessionRuntime2 = ay(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localhv.ecm = localhv.t("AppId", localQualitySessionRuntime2.appId, true);
    localhv.dZT = localhv.t("InstanceId", localQualitySessionRuntime2.lht, true);
    localhv.eia = hv.a.ji(localQualitySessionRuntime2.lTR);
    localhv.eco = localQualitySessionRuntime2.apptype;
    localhv.dHY = localQualitySessionRuntime2.scene;
    localhv.eaM = localQualitySessionRuntime2.lVs;
    localhv.nq(paramo.aTS().startTime);
    localhv.Tb();
    localhv.np(localhv.edx - paramo.aTS().startTime);
    localhv.eii = (paramAppStartupPerformanceReportBundle.ljc - paramAppStartupPerformanceReportBundle.ljb);
    localhv.eij = (paramAppStartupPerformanceReportBundle.lje - paramAppStartupPerformanceReportBundle.ljd);
    localhv.eik = localQualitySessionRuntime2.lVt;
    localhv.eil = localQualitySessionRuntime2.lVu;
    Object localObject = paramo.aTR();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramo.aTS();
    label308:
    label326:
    long l1;
    if (paramAppStartupPerformanceReportBundle.ljh)
    {
      paramString = hv.c.eiv;
      localhv.eic = paramString;
      if (!localAppBrandInitConfigWC.cck) {
        break label573;
      }
      paramString = hv.b.eis;
      localhv.eid = paramString;
      if (!paramo.jgh) {
        break label580;
      }
      l1 = 1L;
      label342:
      localhv.eie = l1;
      long l2 = 0L;
      if (com.tencent.mm.vfs.i.eA(((AppBrandSysConfigWC)localObject).jEg.pkgPath)) {
        break label586;
      }
      paramString = ((AppBrandSysConfigWC)localObject).jEg.jpd.iterator();
      do
      {
        l1 = l2;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (ModulePkgInfo)paramString.next();
      } while (!com.tencent.mm.vfs.i.eA(((ModulePkgInfo)localObject).pkgPath));
      l1 = com.tencent.mm.vfs.i.aSp(((ModulePkgInfo)localObject).pkgPath);
      label423:
      if (!paramo.jgh) {
        break label602;
      }
      label430:
      localhv.eib = l1;
      localhv.dQE = f.getNetworkType();
      localhv.eez = localQualitySessionRuntime2.lVK;
      localhv.edd = localQualitySessionRuntime2.btP();
      localhv.nr(localQualitySessionRuntime2.lVB.lja - localQualitySessionRuntime2.lVB.liL);
      if (!paramAppStartupPerformanceReportBundle.lji) {
        break label608;
      }
    }
    label573:
    label580:
    label586:
    label602:
    label608:
    for (paramString = hv.d.eiy;; paramString = hv.d.eiz)
    {
      localhv.eim = paramString;
      localhv.ein = (paramAppStartupPerformanceReportBundle.ljg - paramAppStartupPerformanceReportBundle.ljf);
      localhv.eeY = localQualitySessionRuntime2.btT();
      localhv.aHZ();
      if (!DebuggerShell.baW()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localhv.ecm, "ResourcePrepare", localhv.edw, localhv.edx);
      break;
      paramString = hv.c.eiw;
      break label308;
      paramString = hv.b.eit;
      break label326;
      l1 = 0L;
      break label342;
      l1 = com.tencent.mm.vfs.i.aSp(((AppBrandSysConfigWC)localObject).jEg.pkgPath);
      break label423;
      l1 = 0L;
      break label430;
    }
  }
  
  /* Error */
  public static void a(String paramString, o paramo)
  {
    // Byte code:
    //   0: ldc_w 1104
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:ay	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +26 -> 41
    //   18: ldc 63
    //   20: ldc_w 1106
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 216	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1104
    //   37: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 63
    //   43: ldc_w 1108
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 86	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 4
    //   59: aconst_null
    //   60: putfield 342	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVM	Lcom/tencent/mm/g/b/a/hb;
    //   63: new 1110	com/tencent/mm/g/b/a/hg
    //   66: dup
    //   67: invokespecial 1111	com/tencent/mm/g/b/a/hg:<init>	()V
    //   70: astore 4
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:ay	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +448 -> 529
    //   84: aload 4
    //   86: aload 4
    //   88: ldc 233
    //   90: aload 5
    //   92: getfield 195	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1112	com/tencent/mm/g/b/a/hg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1113	com/tencent/mm/g/b/a/hg:ecm	Ljava/lang/String;
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 221
    //   108: aload 5
    //   110: getfield 224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lht	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1112	com/tencent/mm/g/b/a/hg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1114	com/tencent/mm/g/b/a/hg:dZT	Ljava/lang/String;
    //   120: aload 4
    //   122: aload 5
    //   124: getfield 245	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lTR	I
    //   127: invokestatic 1120	com/tencent/mm/g/b/a/hg$a:iU	(I)Lcom/tencent/mm/g/b/a/hg$a;
    //   130: putfield 1124	com/tencent/mm/g/b/a/hg:efd	Lcom/tencent/mm/g/b/a/hg$a;
    //   133: aload 4
    //   135: aload 5
    //   137: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1125	com/tencent/mm/g/b/a/hg:eco	J
    //   144: aload 4
    //   146: aload 5
    //   148: getfield 239	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVs	I
    //   151: i2l
    //   152: putfield 1126	com/tencent/mm/g/b/a/hg:eaM	J
    //   155: aload 4
    //   157: aload 5
    //   159: getfield 366	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1127	com/tencent/mm/g/b/a/hg:dHY	J
    //   166: aload 4
    //   168: aload_1
    //   169: invokevirtual 92	com/tencent/mm/plugin/appbrand/o:aTS	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   172: getfield 264	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   175: invokevirtual 1131	com/tencent/mm/g/b/a/hg:mb	(J)Lcom/tencent/mm/g/b/a/hg;
    //   178: pop
    //   179: aload 4
    //   181: invokevirtual 1135	com/tencent/mm/g/b/a/hg:SU	()Lcom/tencent/mm/g/b/a/hg;
    //   184: pop
    //   185: aload 4
    //   187: aload 4
    //   189: getfield 1136	com/tencent/mm/g/b/a/hg:edx	J
    //   192: aload 4
    //   194: getfield 1137	com/tencent/mm/g/b/a/hg:edw	J
    //   197: lsub
    //   198: invokevirtual 1140	com/tencent/mm/g/b/a/hg:ma	(J)Lcom/tencent/mm/g/b/a/hg;
    //   201: pop
    //   202: aload 4
    //   204: aload 4
    //   206: ldc_w 287
    //   209: aload_1
    //   210: invokevirtual 826	com/tencent/mm/plugin/appbrand/o:aTT	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   213: invokevirtual 831	com/tencent/mm/plugin/appbrand/page/v:getCurrentUrl	()Ljava/lang/String;
    //   216: invokestatic 295	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 300	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: iconst_1
    //   223: invokevirtual 1112	com/tencent/mm/g/b/a/hg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   226: putfield 1141	com/tencent/mm/g/b/a/hg:eex	Ljava/lang/String;
    //   229: aload 5
    //   231: getfield 306	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVO	Z
    //   234: ifeq +895 -> 1129
    //   237: lconst_1
    //   238: lstore_2
    //   239: aload 4
    //   241: lload_2
    //   242: putfield 1142	com/tencent/mm/g/b/a/hg:edg	J
    //   245: aload 5
    //   247: getfield 313	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVB	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   250: ifnull +889 -> 1139
    //   253: aload 5
    //   255: getfield 313	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVB	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   258: invokevirtual 318	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:bnl	()Z
    //   261: ifeq +873 -> 1134
    //   264: lconst_1
    //   265: lstore_2
    //   266: aload 4
    //   268: lload_2
    //   269: putfield 1143	com/tencent/mm/g/b/a/hg:eey	J
    //   272: aload 4
    //   274: aload 5
    //   276: invokevirtual 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btP	()J
    //   279: putfield 1144	com/tencent/mm/g/b/a/hg:edd	J
    //   282: aload 4
    //   284: lconst_0
    //   285: putfield 1147	com/tencent/mm/g/b/a/hg:eeG	J
    //   288: aload 4
    //   290: aload 4
    //   292: ldc_w 840
    //   295: invokestatic 383	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   298: invokestatic 845	com/tencent/mm/plugin/appbrand/report/p:dL	(Landroid/content/Context;)Ljava/lang/String;
    //   301: iconst_1
    //   302: invokevirtual 1112	com/tencent/mm/g/b/a/hg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   305: putfield 1148	com/tencent/mm/g/b/a/hg:ecQ	Ljava/lang/String;
    //   308: aload_1
    //   309: invokevirtual 980	com/tencent/mm/plugin/appbrand/o:aTR	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   312: getfield 1152	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:ccS	Ljava/util/List;
    //   315: astore 6
    //   317: aload_1
    //   318: invokevirtual 980	com/tencent/mm/plugin/appbrand/o:aTR	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   321: getfield 1010	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:jEg	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   324: getfield 1156	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:jpf	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   327: astore 7
    //   329: aload 6
    //   331: ifnull +833 -> 1164
    //   334: aload 6
    //   336: invokeinterface 1160 1 0
    //   341: ifle +823 -> 1164
    //   344: aload 4
    //   346: lconst_1
    //   347: putfield 1163	com/tencent/mm/g/b/a/hg:eeH	J
    //   350: aload 4
    //   352: aload 5
    //   354: getfield 182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVK	J
    //   357: putfield 1164	com/tencent/mm/g/b/a/hg:eez	J
    //   360: aload 5
    //   362: invokevirtual 1167	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btR	()Z
    //   365: ifeq +847 -> 1212
    //   368: lconst_1
    //   369: lstore_2
    //   370: aload 4
    //   372: lload_2
    //   373: putfield 1170	com/tencent/mm/g/b/a/hg:eeI	J
    //   376: aload 4
    //   378: aload_1
    //   379: getfield 429	com/tencent/mm/plugin/appbrand/o:jgq	I
    //   382: i2l
    //   383: putfield 1171	com/tencent/mm/g/b/a/hg:eep	J
    //   386: aload_1
    //   387: invokevirtual 92	com/tencent/mm/plugin/appbrand/o:aTS	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   390: getfield 1174	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:jDJ	Z
    //   393: ifeq +824 -> 1217
    //   396: lconst_1
    //   397: lstore_2
    //   398: aload 4
    //   400: lload_2
    //   401: putfield 1177	com/tencent/mm/g/b/a/hg:eff	J
    //   404: aload_1
    //   405: invokevirtual 1181	com/tencent/mm/plugin/appbrand/o:aSt	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   408: astore 6
    //   410: aload 6
    //   412: ifnull +810 -> 1222
    //   415: aload 4
    //   417: aload 4
    //   419: ldc_w 1183
    //   422: aload 6
    //   424: invokeinterface 1188 1 0
    //   429: iconst_1
    //   430: invokevirtual 1112	com/tencent/mm/g/b/a/hg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   433: putfield 1191	com/tencent/mm/g/b/a/hg:efe	Ljava/lang/String;
    //   436: aload 4
    //   438: aload 5
    //   440: getfield 333	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVA	J
    //   443: putfield 1192	com/tencent/mm/g/b/a/hg:eeA	J
    //   446: aload 4
    //   448: aload 5
    //   450: invokevirtual 852	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btT	()J
    //   453: putfield 1193	com/tencent/mm/g/b/a/hg:eeY	J
    //   456: aload 4
    //   458: invokevirtual 1194	com/tencent/mm/g/b/a/hg:aHZ	()Z
    //   461: pop
    //   462: invokestatic 861	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:baW	()Z
    //   465: ifeq +64 -> 529
    //   468: aload 5
    //   470: getfield 306	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVO	Z
    //   473: ifeq +771 -> 1244
    //   476: lconst_1
    //   477: lstore_2
    //   478: ldc_w 1196
    //   481: iconst_2
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: ldc_w 1198
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: lload_2
    //   494: invokestatic 762	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   497: aastore
    //   498: invokestatic 1202	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   501: astore 5
    //   503: aload 4
    //   505: getfield 1113	com/tencent/mm/g/b/a/hg:ecm	Ljava/lang/String;
    //   508: ldc_w 1204
    //   511: ldc_w 1206
    //   514: aload 4
    //   516: getfield 1137	com/tencent/mm/g/b/a/hg:edw	J
    //   519: aload 4
    //   521: getfield 1136	com/tencent/mm/g/b/a/hg:edx	J
    //   524: aload 5
    //   526: invokestatic 1209	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   529: new 1211	com/tencent/mm/g/b/a/hy
    //   532: dup
    //   533: invokespecial 1212	com/tencent/mm/g/b/a/hy:<init>	()V
    //   536: astore 4
    //   538: aload_0
    //   539: iconst_1
    //   540: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:ay	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   543: astore 5
    //   545: aload 5
    //   547: ifnull +256 -> 803
    //   550: aload 5
    //   552: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   555: putfield 1215	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVz	J
    //   558: aload 4
    //   560: aload 4
    //   562: ldc 233
    //   564: aload 5
    //   566: getfield 195	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   569: iconst_1
    //   570: invokevirtual 1216	com/tencent/mm/g/b/a/hy:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   573: putfield 1217	com/tencent/mm/g/b/a/hy:ecm	Ljava/lang/String;
    //   576: aload 4
    //   578: aload 4
    //   580: ldc 221
    //   582: aload 5
    //   584: getfield 224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lht	Ljava/lang/String;
    //   587: iconst_1
    //   588: invokevirtual 1216	com/tencent/mm/g/b/a/hy:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   591: putfield 1218	com/tencent/mm/g/b/a/hy:dZT	Ljava/lang/String;
    //   594: aload 4
    //   596: aload 5
    //   598: getfield 245	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lTR	I
    //   601: invokestatic 1224	com/tencent/mm/g/b/a/hy$a:jl	(I)Lcom/tencent/mm/g/b/a/hy$a;
    //   604: putfield 1228	com/tencent/mm/g/b/a/hy:eiJ	Lcom/tencent/mm/g/b/a/hy$a;
    //   607: aload 4
    //   609: aload 5
    //   611: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   614: i2l
    //   615: putfield 1229	com/tencent/mm/g/b/a/hy:eco	J
    //   618: aload 4
    //   620: aload 5
    //   622: getfield 239	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVs	I
    //   625: i2l
    //   626: putfield 1230	com/tencent/mm/g/b/a/hy:eaM	J
    //   629: aload 4
    //   631: aload 5
    //   633: getfield 366	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   636: i2l
    //   637: putfield 1231	com/tencent/mm/g/b/a/hy:dHY	J
    //   640: aload 4
    //   642: aload 5
    //   644: getfield 901	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVx	J
    //   647: invokevirtual 1235	com/tencent/mm/g/b/a/hy:nB	(J)Lcom/tencent/mm/g/b/a/hy;
    //   650: pop
    //   651: aload 4
    //   653: invokevirtual 1239	com/tencent/mm/g/b/a/hy:Td	()Lcom/tencent/mm/g/b/a/hy;
    //   656: pop
    //   657: aload 4
    //   659: aload 4
    //   661: getfield 1240	com/tencent/mm/g/b/a/hy:edx	J
    //   664: aload 5
    //   666: getfield 901	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVx	J
    //   669: lsub
    //   670: invokevirtual 1243	com/tencent/mm/g/b/a/hy:nA	(J)Lcom/tencent/mm/g/b/a/hy;
    //   673: pop
    //   674: aload 4
    //   676: aload 5
    //   678: invokevirtual 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btP	()J
    //   681: putfield 1244	com/tencent/mm/g/b/a/hy:edd	J
    //   684: aload 4
    //   686: aload 4
    //   688: ldc_w 287
    //   691: aload_1
    //   692: invokevirtual 826	com/tencent/mm/plugin/appbrand/o:aTT	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   695: invokevirtual 831	com/tencent/mm/plugin/appbrand/page/v:getCurrentUrl	()Ljava/lang/String;
    //   698: invokestatic 300	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   701: iconst_1
    //   702: invokevirtual 1216	com/tencent/mm/g/b/a/hy:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   705: putfield 1245	com/tencent/mm/g/b/a/hy:eex	Ljava/lang/String;
    //   708: aload 4
    //   710: lconst_0
    //   711: putfield 1246	com/tencent/mm/g/b/a/hy:eeG	J
    //   714: aload 4
    //   716: aload 4
    //   718: ldc_w 840
    //   721: invokestatic 383	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   724: invokestatic 845	com/tencent/mm/plugin/appbrand/report/p:dL	(Landroid/content/Context;)Ljava/lang/String;
    //   727: iconst_1
    //   728: invokevirtual 1216	com/tencent/mm/g/b/a/hy:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   731: putfield 1247	com/tencent/mm/g/b/a/hy:ecQ	Ljava/lang/String;
    //   734: aload 4
    //   736: aload 5
    //   738: getfield 182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVK	J
    //   741: putfield 1248	com/tencent/mm/g/b/a/hy:eez	J
    //   744: aload 5
    //   746: invokevirtual 1167	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btR	()Z
    //   749: ifeq +500 -> 1249
    //   752: lconst_1
    //   753: lstore_2
    //   754: aload 4
    //   756: lload_2
    //   757: putfield 1249	com/tencent/mm/g/b/a/hy:eeI	J
    //   760: aload 4
    //   762: aload 5
    //   764: invokevirtual 852	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btT	()J
    //   767: putfield 1250	com/tencent/mm/g/b/a/hy:eeY	J
    //   770: aload 4
    //   772: invokevirtual 1251	com/tencent/mm/g/b/a/hy:aHZ	()Z
    //   775: pop
    //   776: invokestatic 861	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:baW	()Z
    //   779: ifeq +24 -> 803
    //   782: aload 4
    //   784: getfield 1217	com/tencent/mm/g/b/a/hy:ecm	Ljava/lang/String;
    //   787: ldc_w 1253
    //   790: aload 4
    //   792: getfield 1254	com/tencent/mm/g/b/a/hy:edw	J
    //   795: aload 4
    //   797: getfield 1240	com/tencent/mm/g/b/a/hy:edx	J
    //   800: invokestatic 869	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   803: new 1256	com/tencent/mm/g/b/a/hd
    //   806: dup
    //   807: invokespecial 1257	com/tencent/mm/g/b/a/hd:<init>	()V
    //   810: astore 4
    //   812: aload_0
    //   813: iconst_1
    //   814: invokestatic 212	com/tencent/mm/plugin/appbrand/report/quality/a:ay	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   817: astore 5
    //   819: aload 5
    //   821: ifnull +275 -> 1096
    //   824: aload 4
    //   826: aload 4
    //   828: ldc 233
    //   830: aload 5
    //   832: getfield 195	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   835: iconst_1
    //   836: invokevirtual 1258	com/tencent/mm/g/b/a/hd:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   839: putfield 1259	com/tencent/mm/g/b/a/hd:ecm	Ljava/lang/String;
    //   842: aload 4
    //   844: aload 4
    //   846: ldc 221
    //   848: aload 5
    //   850: getfield 224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lht	Ljava/lang/String;
    //   853: iconst_1
    //   854: invokevirtual 1258	com/tencent/mm/g/b/a/hd:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   857: putfield 1260	com/tencent/mm/g/b/a/hd:dZT	Ljava/lang/String;
    //   860: aload 4
    //   862: aload 5
    //   864: getfield 245	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lTR	I
    //   867: invokestatic 1266	com/tencent/mm/g/b/a/hd$a:iS	(I)Lcom/tencent/mm/g/b/a/hd$a;
    //   870: putfield 1270	com/tencent/mm/g/b/a/hd:eeF	Lcom/tencent/mm/g/b/a/hd$a;
    //   873: aload 4
    //   875: aload 5
    //   877: getfield 258	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   880: i2l
    //   881: putfield 1271	com/tencent/mm/g/b/a/hd:eco	J
    //   884: aload 4
    //   886: aload 5
    //   888: getfield 239	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVs	I
    //   891: i2l
    //   892: putfield 1272	com/tencent/mm/g/b/a/hd:eaM	J
    //   895: aload 4
    //   897: aload 5
    //   899: getfield 366	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   902: i2l
    //   903: putfield 1273	com/tencent/mm/g/b/a/hd:dHY	J
    //   906: aload 4
    //   908: aload 5
    //   910: getfield 788	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVy	J
    //   913: invokevirtual 1277	com/tencent/mm/g/b/a/hd:lV	(J)Lcom/tencent/mm/g/b/a/hd;
    //   916: pop
    //   917: aload 4
    //   919: invokevirtual 1281	com/tencent/mm/g/b/a/hd:SR	()Lcom/tencent/mm/g/b/a/hd;
    //   922: pop
    //   923: aload 4
    //   925: aload 4
    //   927: getfield 1282	com/tencent/mm/g/b/a/hd:edx	J
    //   930: aload 5
    //   932: getfield 788	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVy	J
    //   935: lsub
    //   936: invokevirtual 1285	com/tencent/mm/g/b/a/hd:lU	(J)Lcom/tencent/mm/g/b/a/hd;
    //   939: pop
    //   940: aload 4
    //   942: aload 5
    //   944: invokevirtual 324	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btP	()J
    //   947: putfield 1286	com/tencent/mm/g/b/a/hd:edd	J
    //   950: aload 4
    //   952: aload 4
    //   954: ldc_w 287
    //   957: aload_1
    //   958: invokevirtual 826	com/tencent/mm/plugin/appbrand/o:aTT	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   961: invokevirtual 831	com/tencent/mm/plugin/appbrand/page/v:getCurrentUrl	()Ljava/lang/String;
    //   964: invokestatic 300	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   967: iconst_1
    //   968: invokevirtual 1258	com/tencent/mm/g/b/a/hd:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   971: putfield 1287	com/tencent/mm/g/b/a/hd:eex	Ljava/lang/String;
    //   974: aload 4
    //   976: lconst_0
    //   977: putfield 1288	com/tencent/mm/g/b/a/hd:eeG	J
    //   980: aload 4
    //   982: aload 4
    //   984: ldc_w 840
    //   987: invokestatic 383	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   990: invokestatic 845	com/tencent/mm/plugin/appbrand/report/p:dL	(Landroid/content/Context;)Ljava/lang/String;
    //   993: iconst_1
    //   994: invokevirtual 1258	com/tencent/mm/g/b/a/hd:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   997: putfield 1289	com/tencent/mm/g/b/a/hd:ecQ	Ljava/lang/String;
    //   1000: aload_1
    //   1001: invokevirtual 980	com/tencent/mm/plugin/appbrand/o:aTR	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1004: getfield 1152	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:ccS	Ljava/util/List;
    //   1007: astore 6
    //   1009: aload_1
    //   1010: invokevirtual 980	com/tencent/mm/plugin/appbrand/o:aTR	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1013: getfield 1010	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:jEg	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1016: getfield 1156	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:jpf	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1019: astore_1
    //   1020: aload 6
    //   1022: ifnull +232 -> 1254
    //   1025: aload 6
    //   1027: invokeinterface 1160 1 0
    //   1032: ifle +222 -> 1254
    //   1035: aload 4
    //   1037: lconst_1
    //   1038: putfield 1290	com/tencent/mm/g/b/a/hd:eeH	J
    //   1041: aload 4
    //   1043: aload 5
    //   1045: getfield 182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lVK	J
    //   1048: putfield 1291	com/tencent/mm/g/b/a/hd:eez	J
    //   1051: aload 5
    //   1053: invokevirtual 1167	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:btR	()Z
    //   1056: ifeq +241 -> 1297
    //   1059: lconst_1
    //   1060: lstore_2
    //   1061: aload 4
    //   1063: lload_2
    //   1064: putfield 1292	com/tencent/mm/g/b/a/hd:eeI	J
    //   1067: aload 4
    //   1069: invokevirtual 1293	com/tencent/mm/g/b/a/hd:aHZ	()Z
    //   1072: pop
    //   1073: invokestatic 861	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:baW	()Z
    //   1076: ifeq +20 -> 1096
    //   1079: aload_0
    //   1080: ldc_w 1295
    //   1083: aload 4
    //   1085: getfield 1296	com/tencent/mm/g/b/a/hd:edw	J
    //   1088: aload 4
    //   1090: getfield 1282	com/tencent/mm/g/b/a/hd:edx	J
    //   1093: invokestatic 869	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1096: ldc_w 1104
    //   1099: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1102: return
    //   1103: astore 6
    //   1105: ldc 63
    //   1107: ldc_w 1298
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
    //   1123: invokestatic 216	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1126: goto -897 -> 229
    //   1129: lconst_0
    //   1130: lstore_2
    //   1131: goto -892 -> 239
    //   1134: lconst_0
    //   1135: lstore_2
    //   1136: goto -870 -> 266
    //   1139: getstatic 606	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   1142: ifeq -870 -> 272
    //   1145: new 608	java/lang/IllegalStateException
    //   1148: dup
    //   1149: ldc_w 896
    //   1152: invokespecial 613	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1155: astore_0
    //   1156: ldc_w 1104
    //   1159: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1162: aload_0
    //   1163: athrow
    //   1164: aload 7
    //   1166: ifnull +37 -> 1203
    //   1169: aload 7
    //   1171: ldc_w 1300
    //   1174: invokevirtual 1306	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Iw	(Ljava/lang/String;)Ljava/util/List;
    //   1177: astore 6
    //   1179: aload 6
    //   1181: ifnull -831 -> 350
    //   1184: aload 6
    //   1186: invokeinterface 1160 1 0
    //   1191: ifle -841 -> 350
    //   1194: aload 4
    //   1196: lconst_1
    //   1197: putfield 1163	com/tencent/mm/g/b/a/hg:eeH	J
    //   1200: goto -850 -> 350
    //   1203: aload 4
    //   1205: lconst_0
    //   1206: putfield 1163	com/tencent/mm/g/b/a/hg:eeH	J
    //   1209: goto -859 -> 350
    //   1212: lconst_0
    //   1213: lstore_2
    //   1214: goto -844 -> 370
    //   1217: lconst_0
    //   1218: lstore_2
    //   1219: goto -821 -> 398
    //   1222: ldc 63
    //   1224: ldc_w 1308
    //   1227: iconst_1
    //   1228: anewarray 4	java/lang/Object
    //   1231: dup
    //   1232: iconst_0
    //   1233: aload_1
    //   1234: getfield 71	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1237: aastore
    //   1238: invokestatic 1311	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1259: ldc_w 1300
    //   1262: invokevirtual 1306	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Iw	(Ljava/lang/String;)Ljava/util/List;
    //   1265: astore_1
    //   1266: aload_1
    //   1267: ifnull -226 -> 1041
    //   1270: aload_1
    //   1271: invokeinterface 1160 1 0
    //   1276: ifle -235 -> 1041
    //   1279: aload 4
    //   1281: lconst_1
    //   1282: putfield 1290	com/tencent/mm/g/b/a/hd:eeH	J
    //   1285: goto -244 -> 1041
    //   1288: aload 4
    //   1290: lconst_0
    //   1291: putfield 1290	com/tencent/mm/g/b/a/hd:eeH	J
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
    //   0	1312	1	paramo	o
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
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48187);
        QualitySessionRuntime localQualitySessionRuntime = a.QN(this.jib);
        if ((localQualitySessionRuntime != null) && (paramb != null))
        {
          Object localObject;
          if ((paramb.lQB != null) && (paramb.lQB.GgD != 0))
          {
            ac.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.lQB.GgD), Integer.valueOf(paramb.lQB.GgE) });
            localObject = null;
            switch (paramb.lQB.GgD)
            {
            default: 
              ac.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
            }
          }
          for (;;)
          {
            if (localObject != null) {
              localQualitySessionRuntime.lVE.a(localQualitySessionRuntime, paramb.lQB.GgE, (e.a)localObject, true);
            }
            if ((paramb.lQD == null) || (!paramb.lQD.GgA)) {
              break label324;
            }
            localObject = com.tencent.luggage.game.e.a.Cp();
            boolean bool = paramb.lQD.GgA;
            int i = paramb.lQD.GgB;
            double d = paramb.lQD.GgC;
            try
            {
              ac.i("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Double.valueOf(d) });
              ((com.tencent.luggage.game.e.a)localObject).cbn = bool;
              ((com.tencent.luggage.game.e.a)localObject).cbo = i;
              ((com.tencent.luggage.game.e.a)localObject).cbp = d;
              AppMethodBeat.o(48187);
              return;
              localObject = e.a.lUK;
              continue;
              localObject = e.a.lUL;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.MBNiReporter", localException, "setConfig Exception", new Object[0]);
              }
            }
          }
        }
        ac.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        label324:
        AppMethodBeat.o(48187);
      }
    });
    AppMethodBeat.o(48193);
  }
  
  private static QualitySessionRuntime ay(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (lUv)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)lUv.get(paramString);
      if (localQualitySessionRuntime != null) {
        break label108;
      }
      paramString = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[] { paramString });
      if ((paramBoolean) && ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)))
      {
        paramString = new IllegalStateException(paramString);
        AppMethodBeat.o(48191);
        throw paramString;
      }
    }
    ac.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), paramString, new Object[0]);
    label108:
    AppMethodBeat.o(48191);
    return localQualitySessionRuntime;
  }
  
  public static b btI()
  {
    return lUu;
  }
  
  public static final class a
  {
    boolean lUA = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */