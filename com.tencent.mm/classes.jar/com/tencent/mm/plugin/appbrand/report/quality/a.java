package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.b.a.fj.a;
import com.tencent.mm.g.b.a.fk;
import com.tencent.mm.g.b.a.fk.a;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.g.b.a.fn.a;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.g.b.a.fw.a;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.g.b.a.gd.a;
import com.tencent.mm.g.b.a.gd.b;
import com.tencent.mm.g.b.a.gd.c;
import com.tencent.mm.g.b.a.gd.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class a
{
  private static final b lsA;
  private static final HashMap<String, QualitySessionRuntime> lsB;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      lsA = new b();
      lsB = new HashMap();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void K(o paramo)
  {
    AppMethodBeat.i(48189);
    ad.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramo.mAppId, Integer.valueOf(paramo.hashCode()) });
    Object localObject2 = paramo.aNc().jdu;
    ??? = localObject2;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.a.un(paramo.aNc().uin), paramo.aNc(), paramo.DZ().cfo);
      paramo.aNc().jdu = ((QualitySession)???);
    }
    localObject2 = f.h((QualitySession)???);
    ((QualitySessionRuntime)localObject2).joZ = paramo;
    ((QualitySessionRuntime)localObject2).cbn = paramo.CZ();
    ((QualitySessionRuntime)localObject2).ltC = System.currentTimeMillis();
    com.tencent.e.h.Iye.aP(new a.2((QualitySessionRuntime)localObject2));
    long l;
    if (1 == paramo.aNc().jdv) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).ltQ = l;
      synchronized (lsB)
      {
        if (($assertionsDisabled) || (lsB.get(paramo.mAppId) == null)) {
          break;
        }
        paramo = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramo;
      }
      if (paramo.aNc().jds) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    lsB.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    g.a(paramo.mAppId, new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(48184);
        ad.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.iCz.mAppId, Integer.valueOf(this.iCz.hashCode()) });
        a.O(this.iCz);
        AppMethodBeat.o(48184);
      }
    });
    AppMethodBeat.o(48189);
  }
  
  public static void L(o paramo)
  {
    long l2 = 1L;
    AppMethodBeat.i(196078);
    QualitySessionRuntime localQualitySessionRuntime = ax(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      ad.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramo.mAppId });
      AppMethodBeat.o(196078);
      return;
    }
    fk localfk = new fk();
    localfk.dYa = localfk.t("InstanceId", localQualitySessionRuntime.kGa, true);
    localfk.eag = localfk.t("AppId", localQualitySessionRuntime.appId, true);
    localfk.dYT = localQualitySessionRuntime.lty;
    localfk.ecq = fk.a.iT(localQualitySessionRuntime.lrW);
    localfk.eai = localQualitySessionRuntime.apptype;
    localfk.iq(paramo.aNc().startTime);
    localfk.ir(bt.eGO());
    localfk.ip(localfk.ebr - localfk.ebq);
    localfk.ecr = localfk.t("path", p.encode(bt.nullAsNil(paramo.aLS())), true);
    if (localQualitySessionRuntime.ltU)
    {
      l1 = 1L;
      localfk.eba = l1;
      if ((localQualitySessionRuntime.ltH == null) || (!localQualitySessionRuntime.ltH.bgr())) {
        break label283;
      }
    }
    label283:
    for (long l1 = l2;; l1 = 0L)
    {
      localfk.ecs = l1;
      localfk.eaX = localQualitySessionRuntime.bmT();
      localfk.ect = localQualitySessionRuntime.ltQ;
      l1 = bt.eGO();
      if (localQualitySessionRuntime.ltG > 0L) {
        break label288;
      }
      localfk.ecu = 0L;
      AppMethodBeat.o(196078);
      return;
      l1 = 0L;
      break;
    }
    label288:
    if (l1 > localQualitySessionRuntime.ltG)
    {
      localfk.ecu = l1;
      AppMethodBeat.o(196078);
      return;
    }
    localfk.ecu = 0L;
    AppMethodBeat.o(196078);
  }
  
  public static void M(o paramo)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = ax(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    fj localfj = localQualitySessionRuntime.ltS;
    long l;
    if (localfj != null)
    {
      localfj.li(localQualitySessionRuntime.kGa);
      localfj.lj(localQualitySessionRuntime.appId);
      localfj.dYT = localQualitySessionRuntime.lty;
      localfj.ece = fj.a.iS(localQualitySessionRuntime.lrW);
      localfj.eai = localQualitySessionRuntime.apptype;
      localfj.dKe = localQualitySessionRuntime.scene;
      localfj.lk(paramo.aNc().username);
      if (!localQualitySessionRuntime.ltU) {
        break label278;
      }
      l = 1L;
      localfj.eba = l;
      localfj.eaX = localQualitySessionRuntime.bmT();
      localfj.ll(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext()));
      if (!paramo.aNc().cfn) {
        break label283;
      }
      l = 1L;
      label160:
      localfj.ecg = l;
      if (!localQualitySessionRuntime.ltT) {
        break label288;
      }
      l = 1L;
      label175:
      localfj.ech = l;
      localfj.in(paramo.aNc().startTime);
      localfj.RT();
      localfj.il(localfj.ebr - localfj.ebq);
      if (!localQualitySessionRuntime.ltV) {
        break label293;
      }
      l = 1L;
      label226:
      localfj.ecl = l;
      if (localQualitySessionRuntime.ltH == null) {
        break label298;
      }
    }
    label278:
    label283:
    label288:
    label293:
    label298:
    for (localfj.eci = 1L;; localfj.eci = 0L)
    {
      localfj.ecj = paramo.iGo;
      localfj.eck = paramo.aMp();
      localfj.aBj();
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
  
  public static QualitySessionRuntime ME(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = ax(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static void N(o paramo)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = ax(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.b localb = n.Do(paramo.mAppId).iFK;
    fw localfw = new fw();
    localfw.dYa = localfw.t("InstanceId", localQualitySessionRuntime.kGa, true);
    localfw.eag = localfw.t("AppId", localQualitySessionRuntime.appId, true);
    localfw.dYT = localQualitySessionRuntime.lty;
    localfw.eem = fw.a.jc(localQualitySessionRuntime.lrW);
    localfw.eai = localQualitySessionRuntime.apptype;
    localfw.dKe = localQualitySessionRuntime.scene;
    localfw.jc(localb.iIr);
    localfw.jd(localb.iIu);
    localfw.jb(localb.iIu - localb.iIr);
    localfw.ecj = paramo.iGo;
    localfw.een = localb.iIr;
    localfw.eeo = localb.iIu;
    localfw.eep = (localb.iIu - localb.iIr);
    localfw.eeq = localb.iIv;
    localfw.eer = localb.iIw;
    localfw.ees = (localb.iIw - localb.iIv);
    localfw.eet = localb.iIx;
    localfw.eeu = localb.iIy;
    localfw.eev = (localb.iIy - localb.iIx);
    localfw.eck = paramo.aMp();
    localfw.eeA = (localb.iIt - localb.iIs);
    localfw.eew = localb.iIs;
    localfw.eex = (localb.iIs - localb.iIr);
    localfw.eey = localb.iIt;
    localfw.eez = (localb.iIu - localb.iIt);
    localfw.eeB = paramo.aNo();
    localfw.eeC = localb.iIz;
    localfw.aBj();
    AppMethodBeat.o(160613);
  }
  
  public static void a(d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(196079);
    String str = paramd.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = ax(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(196079);
      return;
    }
    ad.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.joZ.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.joZ.hashCode())
    {
      ad.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        paramd = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(196079);
        throw paramd;
      }
      AppMethodBeat.o(196079);
      return;
    }
    fm localfm = new fm();
    localfm.eag = localfm.t("AppId", localQualitySessionRuntime.appId, true);
    localfm.dYa = localfm.t("InstanceId", localQualitySessionRuntime.kGa, true);
    localfm.ecH = localQualitySessionRuntime.lrW;
    localfm.eai = localQualitySessionRuntime.apptype;
    localfm.dYT = localQualitySessionRuntime.lty;
    localfm.dKe = localQualitySessionRuntime.scene;
    localfm.iv(paramLong);
    localfm.RZ();
    localfm.iu(localfm.ebr - localfm.ebq);
    localfm.ecI = paramInt1;
    localfm.ecJ = localfm.t("filePath", paramString1, true);
    com.tencent.mm.plugin.appbrand.report.c localc = com.tencent.mm.plugin.appbrand.report.c.d(paramd.aOf());
    switch (a.5.lsF[localc.ordinal()])
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      localfm.ecK = paramInt1;
      label390:
      boolean bool;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < v.kDv.length))
      {
        paramLong = v.kDv[paramc.codeCacheStatus];
        localfm.ecL = paramLong;
        if (!(paramd instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label956;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramd).chI.BH();
        label416:
        if (!bool) {
          break label987;
        }
        paramLong = 1L;
        label424:
        localfm.ecM = paramLong;
        if (paramc == null) {
          break label993;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localfm.ecN = paramLong;
        if (!org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.report.c.lpf, localc)) {
          break label999;
        }
        localfm.lm(V8.getV8Version());
        label470:
        localfm.ecP = localfm.t("pluginAppid", paramString2, true);
        localfm.ecQ = localfm.t("pluginVersion", String.valueOf(paramInt2), true);
        localfm.aBj();
        if ((paramd instanceof com.tencent.mm.plugin.appbrand.q))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.m.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localfm.ebq;
          paramString2.endTime = localfm.ebr;
          paramString2.t("fileName", localfm.ecJ);
          paramString2.t("size", Long.valueOf(localfm.ecI));
          paramString2.c((com.tencent.mm.plugin.appbrand.q)paramd);
        }
        if ((!localQualitySessionRuntime.ltJ.lsG) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.ltJ.lsG = true;
          localQualitySessionRuntime.ltE = System.currentTimeMillis();
          paramd = localQualitySessionRuntime.joZ;
          paramString1 = new fn();
          paramString2 = ax(str, true);
          if (paramString2 != null)
          {
            paramString1.eag = paramString1.t("AppId", paramString2.appId, true);
            paramString1.dYa = paramString1.t("InstanceId", paramString2.kGa, true);
            paramString1.ecR = fn.a.iV(paramString2.lrW);
            paramString1.eai = paramString2.apptype;
            paramString1.dYT = paramString2.lty;
            paramString1.dKe = paramString2.scene;
            paramString1.ix(paramString2.ltB);
            paramString1.Sa();
            paramString1.iw(paramString1.ebr - paramString2.ltB);
          }
        }
      }
      try
      {
        paramString1.ecr = paramString1.t("path", p.encode(bt.nullAsNil(paramd.aNd().getCurrentUrl())), true);
        if (paramd.iGf)
        {
          paramLong = 1L;
          paramString1.eba = paramLong;
          if (paramString2.ltH == null) {
            break label1073;
          }
          if (!paramString2.ltH.bgr()) {
            break label1067;
          }
          paramLong = 1L;
          paramString1.ecs = paramLong;
          paramString1.eaX = paramString2.bmT();
          paramString1.eaK = paramString1.t("networkType", com.tencent.mm.plugin.appbrand.report.q.dC(aj.getContext()), true);
          paramString1.ect = paramString2.ltQ;
          paramString1.ecS = paramString2.bmX();
          paramString1.aBj();
          if (DebuggerShell.aTY()) {
            com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localfm.ebq, localfm.ebr);
          }
          AppMethodBeat.o(196079);
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
            bool = ((ae)paramd).aNe().chI.BH();
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
          if (!(paramd.aOf() instanceof bd)) {
            break label470;
          }
          localfm.lm(b.bmN());
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
            ad.e("MicroMsg.AppBrandQualitySystem", "launchToJsInject appId %s getCurrentUrl npe = %s", new Object[] { str, paramc });
            continue;
            paramLong = 0L;
            continue;
            paramLong = 0L;
          }
        } while (!com.tencent.mm.sdk.platformtools.h.DEBUG);
        paramd = new IllegalStateException("StartupBundle not registered.");
        AppMethodBeat.o(196079);
        throw paramd;
      }
    }
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, o paramo)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = ax(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.ltD = System.currentTimeMillis();
    localQualitySessionRuntime1.ltH = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime1.ltB = paramo.aNc().startTime;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramo.c(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      ad.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    gd localgd;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48186);
          if (this.lsC.joZ.isDestroyed())
          {
            AppMethodBeat.o(48186);
            return;
          }
          e locale;
          if (!this.lsC.cbn)
          {
            locale = this.lsC.ltK;
            QualitySessionRuntime localQualitySessionRuntime = this.lsC;
            AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
            ad.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
            int i = localQualitySessionRuntime.joZ.aNc().uin;
            double d1 = localAppBrandSysConfigWC.cfR.jcF;
            double d2 = new Random(i ^ System.nanoTime()).nextDouble();
            if (d2 <= d1) {}
            for (boolean bool = true;; bool = false)
            {
              ad.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", new Object[] { Boolean.valueOf(bool), Double.valueOf(d2), Double.valueOf(d1) });
              if (!bool) {
                break;
              }
              try
              {
                locale.a(localQualitySessionRuntime, localAppBrandSysConfigWC.cfR.jcG, e.a.lsR, false);
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
      localgd = new gd();
      localQualitySessionRuntime2 = ax(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localgd.eag = localgd.t("AppId", localQualitySessionRuntime2.appId, true);
    localgd.dYa = localgd.t("InstanceId", localQualitySessionRuntime2.kGa, true);
    localgd.efT = gd.a.jk(localQualitySessionRuntime2.lrW);
    localgd.eai = localQualitySessionRuntime2.apptype;
    localgd.dKe = localQualitySessionRuntime2.scene;
    localgd.dYT = localQualitySessionRuntime2.lty;
    localgd.jO(paramo.aNc().startTime);
    localgd.Si();
    localgd.jN(localgd.ebr - paramo.aNc().startTime);
    localgd.egb = (paramAppStartupPerformanceReportBundle.kHI - paramAppStartupPerformanceReportBundle.kHH);
    localgd.egc = (paramAppStartupPerformanceReportBundle.kHK - paramAppStartupPerformanceReportBundle.kHJ);
    localgd.egd = localQualitySessionRuntime2.ltz;
    localgd.ege = localQualitySessionRuntime2.ltA;
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramo.aNb();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramo.aNc();
    label308:
    label326:
    long l;
    if (paramAppStartupPerformanceReportBundle.kHN)
    {
      paramString = gd.c.egp;
      localgd.efV = paramString;
      if (!localAppBrandInitConfigWC.cfn) {
        break label509;
      }
      paramString = gd.b.egm;
      localgd.efW = paramString;
      if (!paramo.iGf) {
        break label516;
      }
      l = 1L;
      label342:
      localgd.efX = l;
      if (!paramo.iGf) {
        break label522;
      }
      l = localAppBrandSysConfigWC.jdS.getPkgSize();
      label366:
      localgd.efU = l;
      localgd.dON = f.getNetworkType();
      localgd.ect = localQualitySessionRuntime2.ltQ;
      localgd.eaX = localQualitySessionRuntime2.bmT();
      localgd.jP(localQualitySessionRuntime2.ltH.kHG - localQualitySessionRuntime2.ltH.kHr);
      if (!paramAppStartupPerformanceReportBundle.kHO) {
        break label528;
      }
    }
    label516:
    label522:
    label528:
    for (paramString = gd.d.egs;; paramString = gd.d.egt)
    {
      localgd.egf = paramString;
      localgd.egg = (paramAppStartupPerformanceReportBundle.kHM - paramAppStartupPerformanceReportBundle.kHL);
      localgd.ecS = localQualitySessionRuntime2.bmX();
      localgd.aBj();
      if (!DebuggerShell.aTY()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localgd.eag, "ResourcePrepare", localgd.ebq, localgd.ebr);
      break;
      paramString = gd.c.egq;
      break label308;
      label509:
      paramString = gd.b.egn;
      break label326;
      l = 0L;
      break label342;
      l = 0L;
      break label366;
    }
  }
  
  /* Error */
  public static void a(String paramString, o paramo)
  {
    // Byte code:
    //   0: ldc_w 1071
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 210	com/tencent/mm/plugin/appbrand/report/quality/a:ax	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +26 -> 41
    //   18: ldc 59
    //   20: ldc_w 1073
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 214	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1071
    //   37: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 59
    //   43: ldc_w 1075
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 4
    //   59: aconst_null
    //   60: putfield 340	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltS	Lcom/tencent/mm/g/b/a/fj;
    //   63: new 1077	com/tencent/mm/g/b/a/fo
    //   66: dup
    //   67: invokespecial 1078	com/tencent/mm/g/b/a/fo:<init>	()V
    //   70: astore 4
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 210	com/tencent/mm/plugin/appbrand/report/quality/a:ax	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +448 -> 529
    //   84: aload 4
    //   86: aload 4
    //   88: ldc 231
    //   90: aload 5
    //   92: getfield 193	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1079	com/tencent/mm/g/b/a/fo:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1080	com/tencent/mm/g/b/a/fo:eag	Ljava/lang/String;
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 219
    //   108: aload 5
    //   110: getfield 222	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:kGa	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1079	com/tencent/mm/g/b/a/fo:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1081	com/tencent/mm/g/b/a/fo:dYa	Ljava/lang/String;
    //   120: aload 4
    //   122: aload 5
    //   124: getfield 243	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lrW	I
    //   127: invokestatic 1087	com/tencent/mm/g/b/a/fo$a:iW	(I)Lcom/tencent/mm/g/b/a/fo$a;
    //   130: putfield 1091	com/tencent/mm/g/b/a/fo:ecX	Lcom/tencent/mm/g/b/a/fo$a;
    //   133: aload 4
    //   135: aload 5
    //   137: getfield 256	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1092	com/tencent/mm/g/b/a/fo:eai	J
    //   144: aload 4
    //   146: aload 5
    //   148: getfield 237	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lty	I
    //   151: i2l
    //   152: putfield 1093	com/tencent/mm/g/b/a/fo:dYT	J
    //   155: aload 4
    //   157: aload 5
    //   159: getfield 364	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1094	com/tencent/mm/g/b/a/fo:dKe	J
    //   166: aload 4
    //   168: aload_1
    //   169: invokevirtual 88	com/tencent/mm/plugin/appbrand/o:aNc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   172: getfield 262	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   175: invokevirtual 1098	com/tencent/mm/g/b/a/fo:iz	(J)Lcom/tencent/mm/g/b/a/fo;
    //   178: pop
    //   179: aload 4
    //   181: invokevirtual 1102	com/tencent/mm/g/b/a/fo:Sb	()Lcom/tencent/mm/g/b/a/fo;
    //   184: pop
    //   185: aload 4
    //   187: aload 4
    //   189: getfield 1103	com/tencent/mm/g/b/a/fo:ebr	J
    //   192: aload 4
    //   194: getfield 1104	com/tencent/mm/g/b/a/fo:ebq	J
    //   197: lsub
    //   198: invokevirtual 1107	com/tencent/mm/g/b/a/fo:iy	(J)Lcom/tencent/mm/g/b/a/fo;
    //   201: pop
    //   202: aload 4
    //   204: aload 4
    //   206: ldc_w 285
    //   209: aload_1
    //   210: invokevirtual 824	com/tencent/mm/plugin/appbrand/o:aNd	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   213: invokevirtual 829	com/tencent/mm/plugin/appbrand/page/u:getCurrentUrl	()Ljava/lang/String;
    //   216: invokestatic 293	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 298	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: iconst_1
    //   223: invokevirtual 1079	com/tencent/mm/g/b/a/fo:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   226: putfield 1108	com/tencent/mm/g/b/a/fo:ecr	Ljava/lang/String;
    //   229: aload 5
    //   231: getfield 304	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltU	Z
    //   234: ifeq +895 -> 1129
    //   237: lconst_1
    //   238: lstore_2
    //   239: aload 4
    //   241: lload_2
    //   242: putfield 1109	com/tencent/mm/g/b/a/fo:eba	J
    //   245: aload 5
    //   247: getfield 311	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltH	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   250: ifnull +889 -> 1139
    //   253: aload 5
    //   255: getfield 311	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltH	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   258: invokevirtual 316	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:bgr	()Z
    //   261: ifeq +873 -> 1134
    //   264: lconst_1
    //   265: lstore_2
    //   266: aload 4
    //   268: lload_2
    //   269: putfield 1110	com/tencent/mm/g/b/a/fo:ecs	J
    //   272: aload 4
    //   274: aload 5
    //   276: invokevirtual 322	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmT	()J
    //   279: putfield 1111	com/tencent/mm/g/b/a/fo:eaX	J
    //   282: aload 4
    //   284: lconst_0
    //   285: putfield 1114	com/tencent/mm/g/b/a/fo:ecA	J
    //   288: aload 4
    //   290: aload 4
    //   292: ldc_w 838
    //   295: invokestatic 381	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   298: invokestatic 843	com/tencent/mm/plugin/appbrand/report/q:dC	(Landroid/content/Context;)Ljava/lang/String;
    //   301: iconst_1
    //   302: invokevirtual 1079	com/tencent/mm/g/b/a/fo:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   305: putfield 1115	com/tencent/mm/g/b/a/fo:eaK	Ljava/lang/String;
    //   308: aload_1
    //   309: invokevirtual 978	com/tencent/mm/plugin/appbrand/o:aNb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   312: getfield 1119	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:cfV	Ljava/util/List;
    //   315: astore 6
    //   317: aload_1
    //   318: invokevirtual 978	com/tencent/mm/plugin/appbrand/o:aNb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   321: getfield 1008	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:jdS	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   324: getfield 1123	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:iOV	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   327: astore 7
    //   329: aload 6
    //   331: ifnull +833 -> 1164
    //   334: aload 6
    //   336: invokeinterface 1127 1 0
    //   341: ifle +823 -> 1164
    //   344: aload 4
    //   346: lconst_1
    //   347: putfield 1130	com/tencent/mm/g/b/a/fo:ecB	J
    //   350: aload 4
    //   352: aload 5
    //   354: getfield 180	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltQ	J
    //   357: putfield 1131	com/tencent/mm/g/b/a/fo:ect	J
    //   360: aload 5
    //   362: invokevirtual 1134	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmV	()Z
    //   365: ifeq +847 -> 1212
    //   368: lconst_1
    //   369: lstore_2
    //   370: aload 4
    //   372: lload_2
    //   373: putfield 1137	com/tencent/mm/g/b/a/fo:ecC	J
    //   376: aload 4
    //   378: aload_1
    //   379: getfield 427	com/tencent/mm/plugin/appbrand/o:iGo	I
    //   382: i2l
    //   383: putfield 1138	com/tencent/mm/g/b/a/fo:ecj	J
    //   386: aload_1
    //   387: invokevirtual 88	com/tencent/mm/plugin/appbrand/o:aNc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   390: getfield 1141	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:jdw	Z
    //   393: ifeq +824 -> 1217
    //   396: lconst_1
    //   397: lstore_2
    //   398: aload 4
    //   400: lload_2
    //   401: putfield 1144	com/tencent/mm/g/b/a/fo:ecZ	J
    //   404: aload_1
    //   405: invokevirtual 1148	com/tencent/mm/plugin/appbrand/o:aLC	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   408: astore 6
    //   410: aload 6
    //   412: ifnull +810 -> 1222
    //   415: aload 4
    //   417: aload 4
    //   419: ldc_w 1150
    //   422: aload 6
    //   424: invokeinterface 1155 1 0
    //   429: iconst_1
    //   430: invokevirtual 1079	com/tencent/mm/g/b/a/fo:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   433: putfield 1158	com/tencent/mm/g/b/a/fo:ecY	Ljava/lang/String;
    //   436: aload 4
    //   438: aload 5
    //   440: getfield 331	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltG	J
    //   443: putfield 1159	com/tencent/mm/g/b/a/fo:ecu	J
    //   446: aload 4
    //   448: aload 5
    //   450: invokevirtual 850	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmX	()J
    //   453: putfield 1160	com/tencent/mm/g/b/a/fo:ecS	J
    //   456: aload 4
    //   458: invokevirtual 1161	com/tencent/mm/g/b/a/fo:aBj	()Z
    //   461: pop
    //   462: invokestatic 859	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:aTY	()Z
    //   465: ifeq +64 -> 529
    //   468: aload 5
    //   470: getfield 304	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltU	Z
    //   473: ifeq +771 -> 1244
    //   476: lconst_1
    //   477: lstore_2
    //   478: ldc_w 1163
    //   481: iconst_2
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: ldc_w 1165
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: lload_2
    //   494: invokestatic 760	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   497: aastore
    //   498: invokestatic 1169	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   501: astore 5
    //   503: aload 4
    //   505: getfield 1080	com/tencent/mm/g/b/a/fo:eag	Ljava/lang/String;
    //   508: ldc_w 1171
    //   511: ldc_w 1173
    //   514: aload 4
    //   516: getfield 1104	com/tencent/mm/g/b/a/fo:ebq	J
    //   519: aload 4
    //   521: getfield 1103	com/tencent/mm/g/b/a/fo:ebr	J
    //   524: aload 5
    //   526: invokestatic 1176	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   529: new 1178	com/tencent/mm/g/b/a/gg
    //   532: dup
    //   533: invokespecial 1179	com/tencent/mm/g/b/a/gg:<init>	()V
    //   536: astore 4
    //   538: aload_0
    //   539: iconst_1
    //   540: invokestatic 210	com/tencent/mm/plugin/appbrand/report/quality/a:ax	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   543: astore 5
    //   545: aload 5
    //   547: ifnull +256 -> 803
    //   550: aload 5
    //   552: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   555: putfield 1182	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltF	J
    //   558: aload 4
    //   560: aload 4
    //   562: ldc 231
    //   564: aload 5
    //   566: getfield 193	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   569: iconst_1
    //   570: invokevirtual 1183	com/tencent/mm/g/b/a/gg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   573: putfield 1184	com/tencent/mm/g/b/a/gg:eag	Ljava/lang/String;
    //   576: aload 4
    //   578: aload 4
    //   580: ldc 219
    //   582: aload 5
    //   584: getfield 222	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:kGa	Ljava/lang/String;
    //   587: iconst_1
    //   588: invokevirtual 1183	com/tencent/mm/g/b/a/gg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   591: putfield 1185	com/tencent/mm/g/b/a/gg:dYa	Ljava/lang/String;
    //   594: aload 4
    //   596: aload 5
    //   598: getfield 243	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lrW	I
    //   601: invokestatic 1191	com/tencent/mm/g/b/a/gg$a:jn	(I)Lcom/tencent/mm/g/b/a/gg$a;
    //   604: putfield 1195	com/tencent/mm/g/b/a/gg:egD	Lcom/tencent/mm/g/b/a/gg$a;
    //   607: aload 4
    //   609: aload 5
    //   611: getfield 256	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   614: i2l
    //   615: putfield 1196	com/tencent/mm/g/b/a/gg:eai	J
    //   618: aload 4
    //   620: aload 5
    //   622: getfield 237	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lty	I
    //   625: i2l
    //   626: putfield 1197	com/tencent/mm/g/b/a/gg:dYT	J
    //   629: aload 4
    //   631: aload 5
    //   633: getfield 364	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   636: i2l
    //   637: putfield 1198	com/tencent/mm/g/b/a/gg:dKe	J
    //   640: aload 4
    //   642: aload 5
    //   644: getfield 899	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltD	J
    //   647: invokevirtual 1202	com/tencent/mm/g/b/a/gg:jZ	(J)Lcom/tencent/mm/g/b/a/gg;
    //   650: pop
    //   651: aload 4
    //   653: invokevirtual 1206	com/tencent/mm/g/b/a/gg:Sk	()Lcom/tencent/mm/g/b/a/gg;
    //   656: pop
    //   657: aload 4
    //   659: aload 4
    //   661: getfield 1207	com/tencent/mm/g/b/a/gg:ebr	J
    //   664: aload 5
    //   666: getfield 899	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltD	J
    //   669: lsub
    //   670: invokevirtual 1210	com/tencent/mm/g/b/a/gg:jY	(J)Lcom/tencent/mm/g/b/a/gg;
    //   673: pop
    //   674: aload 4
    //   676: aload 5
    //   678: invokevirtual 322	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmT	()J
    //   681: putfield 1211	com/tencent/mm/g/b/a/gg:eaX	J
    //   684: aload 4
    //   686: aload 4
    //   688: ldc_w 285
    //   691: aload_1
    //   692: invokevirtual 824	com/tencent/mm/plugin/appbrand/o:aNd	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   695: invokevirtual 829	com/tencent/mm/plugin/appbrand/page/u:getCurrentUrl	()Ljava/lang/String;
    //   698: invokestatic 298	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   701: iconst_1
    //   702: invokevirtual 1183	com/tencent/mm/g/b/a/gg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   705: putfield 1212	com/tencent/mm/g/b/a/gg:ecr	Ljava/lang/String;
    //   708: aload 4
    //   710: lconst_0
    //   711: putfield 1213	com/tencent/mm/g/b/a/gg:ecA	J
    //   714: aload 4
    //   716: aload 4
    //   718: ldc_w 838
    //   721: invokestatic 381	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   724: invokestatic 843	com/tencent/mm/plugin/appbrand/report/q:dC	(Landroid/content/Context;)Ljava/lang/String;
    //   727: iconst_1
    //   728: invokevirtual 1183	com/tencent/mm/g/b/a/gg:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   731: putfield 1214	com/tencent/mm/g/b/a/gg:eaK	Ljava/lang/String;
    //   734: aload 4
    //   736: aload 5
    //   738: getfield 180	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltQ	J
    //   741: putfield 1215	com/tencent/mm/g/b/a/gg:ect	J
    //   744: aload 5
    //   746: invokevirtual 1134	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmV	()Z
    //   749: ifeq +500 -> 1249
    //   752: lconst_1
    //   753: lstore_2
    //   754: aload 4
    //   756: lload_2
    //   757: putfield 1216	com/tencent/mm/g/b/a/gg:ecC	J
    //   760: aload 4
    //   762: aload 5
    //   764: invokevirtual 850	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmX	()J
    //   767: putfield 1217	com/tencent/mm/g/b/a/gg:ecS	J
    //   770: aload 4
    //   772: invokevirtual 1218	com/tencent/mm/g/b/a/gg:aBj	()Z
    //   775: pop
    //   776: invokestatic 859	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:aTY	()Z
    //   779: ifeq +24 -> 803
    //   782: aload 4
    //   784: getfield 1184	com/tencent/mm/g/b/a/gg:eag	Ljava/lang/String;
    //   787: ldc_w 1220
    //   790: aload 4
    //   792: getfield 1221	com/tencent/mm/g/b/a/gg:ebq	J
    //   795: aload 4
    //   797: getfield 1207	com/tencent/mm/g/b/a/gg:ebr	J
    //   800: invokestatic 867	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   803: new 1223	com/tencent/mm/g/b/a/fl
    //   806: dup
    //   807: invokespecial 1224	com/tencent/mm/g/b/a/fl:<init>	()V
    //   810: astore 4
    //   812: aload_0
    //   813: iconst_1
    //   814: invokestatic 210	com/tencent/mm/plugin/appbrand/report/quality/a:ax	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   817: astore 5
    //   819: aload 5
    //   821: ifnull +275 -> 1096
    //   824: aload 4
    //   826: aload 4
    //   828: ldc 231
    //   830: aload 5
    //   832: getfield 193	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   835: iconst_1
    //   836: invokevirtual 1225	com/tencent/mm/g/b/a/fl:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   839: putfield 1226	com/tencent/mm/g/b/a/fl:eag	Ljava/lang/String;
    //   842: aload 4
    //   844: aload 4
    //   846: ldc 219
    //   848: aload 5
    //   850: getfield 222	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:kGa	Ljava/lang/String;
    //   853: iconst_1
    //   854: invokevirtual 1225	com/tencent/mm/g/b/a/fl:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   857: putfield 1227	com/tencent/mm/g/b/a/fl:dYa	Ljava/lang/String;
    //   860: aload 4
    //   862: aload 5
    //   864: getfield 243	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lrW	I
    //   867: invokestatic 1233	com/tencent/mm/g/b/a/fl$a:iU	(I)Lcom/tencent/mm/g/b/a/fl$a;
    //   870: putfield 1237	com/tencent/mm/g/b/a/fl:ecz	Lcom/tencent/mm/g/b/a/fl$a;
    //   873: aload 4
    //   875: aload 5
    //   877: getfield 256	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   880: i2l
    //   881: putfield 1238	com/tencent/mm/g/b/a/fl:eai	J
    //   884: aload 4
    //   886: aload 5
    //   888: getfield 237	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lty	I
    //   891: i2l
    //   892: putfield 1239	com/tencent/mm/g/b/a/fl:dYT	J
    //   895: aload 4
    //   897: aload 5
    //   899: getfield 364	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   902: i2l
    //   903: putfield 1240	com/tencent/mm/g/b/a/fl:dKe	J
    //   906: aload 4
    //   908: aload 5
    //   910: getfield 786	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltE	J
    //   913: invokevirtual 1244	com/tencent/mm/g/b/a/fl:it	(J)Lcom/tencent/mm/g/b/a/fl;
    //   916: pop
    //   917: aload 4
    //   919: invokevirtual 1248	com/tencent/mm/g/b/a/fl:RY	()Lcom/tencent/mm/g/b/a/fl;
    //   922: pop
    //   923: aload 4
    //   925: aload 4
    //   927: getfield 1249	com/tencent/mm/g/b/a/fl:ebr	J
    //   930: aload 5
    //   932: getfield 786	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltE	J
    //   935: lsub
    //   936: invokevirtual 1252	com/tencent/mm/g/b/a/fl:is	(J)Lcom/tencent/mm/g/b/a/fl;
    //   939: pop
    //   940: aload 4
    //   942: aload 5
    //   944: invokevirtual 322	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmT	()J
    //   947: putfield 1253	com/tencent/mm/g/b/a/fl:eaX	J
    //   950: aload 4
    //   952: aload 4
    //   954: ldc_w 285
    //   957: aload_1
    //   958: invokevirtual 824	com/tencent/mm/plugin/appbrand/o:aNd	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   961: invokevirtual 829	com/tencent/mm/plugin/appbrand/page/u:getCurrentUrl	()Ljava/lang/String;
    //   964: invokestatic 298	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   967: iconst_1
    //   968: invokevirtual 1225	com/tencent/mm/g/b/a/fl:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   971: putfield 1254	com/tencent/mm/g/b/a/fl:ecr	Ljava/lang/String;
    //   974: aload 4
    //   976: lconst_0
    //   977: putfield 1255	com/tencent/mm/g/b/a/fl:ecA	J
    //   980: aload 4
    //   982: aload 4
    //   984: ldc_w 838
    //   987: invokestatic 381	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   990: invokestatic 843	com/tencent/mm/plugin/appbrand/report/q:dC	(Landroid/content/Context;)Ljava/lang/String;
    //   993: iconst_1
    //   994: invokevirtual 1225	com/tencent/mm/g/b/a/fl:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   997: putfield 1256	com/tencent/mm/g/b/a/fl:eaK	Ljava/lang/String;
    //   1000: aload_1
    //   1001: invokevirtual 978	com/tencent/mm/plugin/appbrand/o:aNb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1004: getfield 1119	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:cfV	Ljava/util/List;
    //   1007: astore 6
    //   1009: aload_1
    //   1010: invokevirtual 978	com/tencent/mm/plugin/appbrand/o:aNb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1013: getfield 1008	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:jdS	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1016: getfield 1123	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:iOV	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1019: astore_1
    //   1020: aload 6
    //   1022: ifnull +232 -> 1254
    //   1025: aload 6
    //   1027: invokeinterface 1127 1 0
    //   1032: ifle +222 -> 1254
    //   1035: aload 4
    //   1037: lconst_1
    //   1038: putfield 1257	com/tencent/mm/g/b/a/fl:ecB	J
    //   1041: aload 4
    //   1043: aload 5
    //   1045: getfield 180	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ltQ	J
    //   1048: putfield 1258	com/tencent/mm/g/b/a/fl:ect	J
    //   1051: aload 5
    //   1053: invokevirtual 1134	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bmV	()Z
    //   1056: ifeq +241 -> 1297
    //   1059: lconst_1
    //   1060: lstore_2
    //   1061: aload 4
    //   1063: lload_2
    //   1064: putfield 1259	com/tencent/mm/g/b/a/fl:ecC	J
    //   1067: aload 4
    //   1069: invokevirtual 1260	com/tencent/mm/g/b/a/fl:aBj	()Z
    //   1072: pop
    //   1073: invokestatic 859	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:aTY	()Z
    //   1076: ifeq +20 -> 1096
    //   1079: aload_0
    //   1080: ldc_w 1262
    //   1083: aload 4
    //   1085: getfield 1263	com/tencent/mm/g/b/a/fl:ebq	J
    //   1088: aload 4
    //   1090: getfield 1249	com/tencent/mm/g/b/a/fl:ebr	J
    //   1093: invokestatic 867	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1096: ldc_w 1071
    //   1099: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1102: return
    //   1103: astore 6
    //   1105: ldc 59
    //   1107: ldc_w 1265
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
    //   1123: invokestatic 214	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1126: goto -897 -> 229
    //   1129: lconst_0
    //   1130: lstore_2
    //   1131: goto -892 -> 239
    //   1134: lconst_0
    //   1135: lstore_2
    //   1136: goto -870 -> 266
    //   1139: getstatic 603	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   1142: ifeq -870 -> 272
    //   1145: new 605	java/lang/IllegalStateException
    //   1148: dup
    //   1149: ldc_w 894
    //   1152: invokespecial 610	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1155: astore_0
    //   1156: ldc_w 1071
    //   1159: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1162: aload_0
    //   1163: athrow
    //   1164: aload 7
    //   1166: ifnull +37 -> 1203
    //   1169: aload 7
    //   1171: ldc_w 1267
    //   1174: invokevirtual 1273	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Et	(Ljava/lang/String;)Ljava/util/List;
    //   1177: astore 6
    //   1179: aload 6
    //   1181: ifnull -831 -> 350
    //   1184: aload 6
    //   1186: invokeinterface 1127 1 0
    //   1191: ifle -841 -> 350
    //   1194: aload 4
    //   1196: lconst_1
    //   1197: putfield 1130	com/tencent/mm/g/b/a/fo:ecB	J
    //   1200: goto -850 -> 350
    //   1203: aload 4
    //   1205: lconst_0
    //   1206: putfield 1130	com/tencent/mm/g/b/a/fo:ecB	J
    //   1209: goto -859 -> 350
    //   1212: lconst_0
    //   1213: lstore_2
    //   1214: goto -844 -> 370
    //   1217: lconst_0
    //   1218: lstore_2
    //   1219: goto -821 -> 398
    //   1222: ldc 59
    //   1224: ldc_w 1275
    //   1227: iconst_1
    //   1228: anewarray 4	java/lang/Object
    //   1231: dup
    //   1232: iconst_0
    //   1233: aload_1
    //   1234: getfield 67	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1237: aastore
    //   1238: invokestatic 1278	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1259: ldc_w 1267
    //   1262: invokevirtual 1273	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:Et	(Ljava/lang/String;)Ljava/util/List;
    //   1265: astore_1
    //   1266: aload_1
    //   1267: ifnull -226 -> 1041
    //   1270: aload_1
    //   1271: invokeinterface 1127 1 0
    //   1276: ifle -235 -> 1041
    //   1279: aload 4
    //   1281: lconst_1
    //   1282: putfield 1257	com/tencent/mm/g/b/a/fl:ecB	J
    //   1285: goto -244 -> 1041
    //   1288: aload 4
    //   1290: lconst_0
    //   1291: putfield 1257	com/tencent/mm/g/b/a/fl:ecB	J
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
        QualitySessionRuntime localQualitySessionRuntime = a.ME(this.iHZ);
        if ((localQualitySessionRuntime != null) && (paramb != null))
        {
          Object localObject;
          if ((paramb.loB != null) && (paramb.loB.EJr != 0))
          {
            ad.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.loB.EJr), Integer.valueOf(paramb.loB.EJs) });
            localObject = null;
            switch (paramb.loB.EJr)
            {
            default: 
              ad.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
            }
          }
          for (;;)
          {
            if (localObject != null) {
              localQualitySessionRuntime.ltK.a(localQualitySessionRuntime, paramb.loB.EJs, (e.a)localObject, true);
            }
            if ((paramb.loD == null) || (!paramb.loD.EJo)) {
              break label324;
            }
            localObject = com.tencent.luggage.game.e.a.CL();
            boolean bool = paramb.loD.EJo;
            int i = paramb.loD.EJp;
            double d = paramb.loD.EJq;
            try
            {
              ad.i("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Double.valueOf(d) });
              ((com.tencent.luggage.game.e.a)localObject).ceq = bool;
              ((com.tencent.luggage.game.e.a)localObject).cer = i;
              ((com.tencent.luggage.game.e.a)localObject).ces = d;
              AppMethodBeat.o(48187);
              return;
              localObject = e.a.lsQ;
              continue;
              localObject = e.a.lsR;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.MBNiReporter", localException, "setConfig Exception", new Object[0]);
              }
            }
          }
        }
        ad.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        label324:
        AppMethodBeat.o(48187);
      }
    });
    AppMethodBeat.o(48193);
  }
  
  private static QualitySessionRuntime ax(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (lsB)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)lsB.get(paramString);
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
    ad.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), paramString, new Object[0]);
    label108:
    AppMethodBeat.o(48191);
    return localQualitySessionRuntime;
  }
  
  public static b bmM()
  {
    return lsA;
  }
  
  public static final class a
  {
    boolean lsG = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */