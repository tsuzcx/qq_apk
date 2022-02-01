package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.g.b.a.if.a;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.g.b.a.ig.a;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ij.a;
import com.tencent.mm.g.b.a.is;
import com.tencent.mm.g.b.a.is.a;
import com.tencent.mm.g.b.a.iz;
import com.tencent.mm.g.b.a.iz.a;
import com.tencent.mm.g.b.a.iz.b;
import com.tencent.mm.g.b.a.iz.c;
import com.tencent.mm.g.b.a.iz.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class a
{
  private static final b mul;
  private static final HashMap<String, QualitySessionRuntime> mum;
  
  static
  {
    AppMethodBeat.i(48198);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      mul = new b();
      mum = new HashMap();
      AppMethodBeat.o(48198);
      return;
    }
  }
  
  public static void B(o paramo)
  {
    AppMethodBeat.i(48189);
    ad.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramo.mAppId, Integer.valueOf(paramo.hashCode()) });
    Object localObject2 = paramo.aXc().jXD;
    ??? = localObject2;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(com.tencent.mm.plugin.appbrand.utils.a.vL(paramo.aXc().uin), paramo.aXc(), paramo.Fb().cmC);
      paramo.aXc().jXD = ((QualitySession)???);
    }
    localObject2 = f.h((QualitySession)???);
    ((QualitySessionRuntime)localObject2).jCo = paramo;
    ((QualitySessionRuntime)localObject2).ciC = paramo.Eb();
    ((QualitySessionRuntime)localObject2).mvm = System.currentTimeMillis();
    com.tencent.e.h.LTJ.aR(new a.2((QualitySessionRuntime)localObject2));
    long l;
    if (1 == paramo.aXc().jXE) {
      l = 2L;
    }
    for (;;)
    {
      ((QualitySessionRuntime)localObject2).mvA = l;
      synchronized (mum)
      {
        if (($assertionsDisabled) || (mum.get(paramo.mAppId) == null)) {
          break;
        }
        paramo = new AssertionError();
        AppMethodBeat.o(48189);
        throw paramo;
      }
      if (paramo.aXc().jXB) {
        l = 0L;
      } else {
        l = 1L;
      }
    }
    mum.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    g.a(paramo.mAppId, new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(48184);
        ad.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.jvI.mAppId, Integer.valueOf(this.jvI.hashCode()) });
        a.F(this.jvI);
        AppMethodBeat.o(48184);
      }
    });
    AppMethodBeat.o(48189);
  }
  
  public static void C(o paramo)
  {
    long l2 = 1L;
    AppMethodBeat.i(188718);
    QualitySessionRuntime localQualitySessionRuntime = aA(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      ad.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", new Object[] { paramo.mAppId });
      AppMethodBeat.o(188718);
      return;
    }
    ig localig = new ig();
    localig.eqt = localig.t("InstanceId", localQualitySessionRuntime.lEv, true);
    localig.esR = localig.t("AppId", localQualitySessionRuntime.appId, true);
    localig.eru = localQualitySessionRuntime.mvi;
    localig.evj = ig.a.jn(localQualitySessionRuntime.mtG);
    localig.esT = localQualitySessionRuntime.apptype;
    localig.nQ(paramo.aXc().startTime);
    localig.nR(bt.flT());
    localig.nP(localig.euc - localig.eub);
    localig.evk = localig.t("path", com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramo.aVW())), true);
    long l1;
    if (localQualitySessionRuntime.mvE)
    {
      l1 = 1L;
      localig.etL = l1;
      if ((localQualitySessionRuntime.mvr == null) || (!localQualitySessionRuntime.mvr.bqX())) {
        break label299;
      }
      l1 = l2;
      label226:
      localig.evl = l1;
      localig.etI = localQualitySessionRuntime.bxU();
      localig.evm = localQualitySessionRuntime.mvA;
      l1 = bt.flT();
      if ((localQualitySessionRuntime.mvq <= 0L) || (l1 <= localQualitySessionRuntime.mvq)) {
        break label304;
      }
    }
    label299:
    label304:
    for (localig.evn = l1;; localig.evn = 0L)
    {
      localig.aLk();
      AppMethodBeat.o(188718);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label226;
    }
  }
  
  public static void D(o paramo)
  {
    AppMethodBeat.i(48195);
    QualitySessionRuntime localQualitySessionRuntime = aA(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48195);
      return;
    }
    if localif = localQualitySessionRuntime.mvC;
    long l;
    if (localif != null)
    {
      localif.qR(localQualitySessionRuntime.lEv);
      localif.qS(localQualitySessionRuntime.appId);
      localif.eru = localQualitySessionRuntime.mvi;
      localif.euY = if.a.jm(localQualitySessionRuntime.mtG);
      localif.esT = localQualitySessionRuntime.apptype;
      localif.dVd = localQualitySessionRuntime.scene;
      localif.qT(paramo.aXc().username);
      if (!localQualitySessionRuntime.mvE) {
        break label277;
      }
      l = 1L;
      localif.etL = l;
      localif.etI = localQualitySessionRuntime.bxU();
      localif.qU(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext()));
      if (!paramo.aXc().cmB) {
        break label282;
      }
      l = 1L;
      label160:
      localif.euZ = l;
      if (!localQualitySessionRuntime.mvD) {
        break label287;
      }
      l = 1L;
      label175:
      localif.eva = l;
      localif.nN(paramo.aXc().startTime);
      localif.Va();
      localif.nL(localif.euc - localif.eub);
      if (!localQualitySessionRuntime.mvF) {
        break label292;
      }
      l = 1L;
      label226:
      localif.eve = l;
      if (localQualitySessionRuntime.mvr == null) {
        break label297;
      }
    }
    label277:
    label282:
    label287:
    label292:
    label297:
    for (localif.evb = 1L;; localif.evb = 0L)
    {
      localif.evc = paramo.aXj();
      localif.evd = o.aXk();
      localif.aLk();
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
  
  public static void E(o paramo)
  {
    AppMethodBeat.i(160613);
    QualitySessionRuntime localQualitySessionRuntime = aA(paramo.mAppId, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(160613);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.b localb = n.KE(paramo.mAppId).jyS;
    is localis = new is();
    localis.eqt = localis.t("InstanceId", localQualitySessionRuntime.lEv, true);
    localis.esR = localis.t("AppId", localQualitySessionRuntime.appId, true);
    localis.eru = localQualitySessionRuntime.mvi;
    localis.exh = is.a.jx(localQualitySessionRuntime.mtG);
    localis.esT = localQualitySessionRuntime.apptype;
    localis.dVd = localQualitySessionRuntime.scene;
    localis.oC(localb.jBL);
    localis.oD(localb.jBO);
    localis.oB(localb.jBO - localb.jBL);
    localis.evc = paramo.aXj();
    localis.exi = localb.jBL;
    localis.exj = localb.jBO;
    localis.exk = (localb.jBO - localb.jBL);
    localis.exl = localb.jBQ;
    localis.exm = localb.jBR;
    localis.exn = (localb.jBR - localb.jBQ);
    localis.exo = localb.jBS;
    localis.exp = localb.jBT;
    localis.exq = (localb.jBT - localb.jBS);
    localis.evd = o.aXk();
    localis.exv = (localb.jBN - localb.jBM);
    localis.exr = localb.jBM;
    localis.exs = (localb.jBM - localb.jBL);
    localis.ext = localb.jBN;
    localis.exu = (localb.jBO - localb.jBN);
    localis.exw = paramo.aXm();
    localis.exx = localb.jBU;
    localis.exy = localb.jBP;
    localis.exz = localb.jBW;
    localis.exA = localb.jBX;
    localis.exB = localb.jBY;
    localis.exC = localb.jBZ;
    localis.exD = (localb.jBZ - localb.jBW);
    localis.exE = (localb.jBY - localb.jBX);
    localis.exG = o.aXk();
    localis.exF = o.aXl();
    localis.exH = 1L;
    if (paramo.aVF() != null) {}
    for (long l = paramo.aVF().aZp();; l = 0L)
    {
      localis.exI = l;
      localis.aLk();
      AppMethodBeat.o(160613);
      return;
    }
  }
  
  public static QualitySessionRuntime Ut(String paramString)
  {
    AppMethodBeat.i(48190);
    paramString = aA(paramString, true);
    AppMethodBeat.o(48190);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, m.c paramc)
  {
    AppMethodBeat.i(188719);
    String str = paramd.getAppId();
    QualitySessionRuntime localQualitySessionRuntime = aA(str, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(188719);
      return;
    }
    ad.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { str, Integer.valueOf(localQualitySessionRuntime.jCo.hashCode()), Integer.valueOf(paramInt3), paramString1 });
    if (paramInt3 != localQualitySessionRuntime.jCo.hashCode())
    {
      ad.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
      {
        paramd = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(188719);
        throw paramd;
      }
      AppMethodBeat.o(188719);
      return;
    }
    ii localii = new ii();
    localii.esR = localii.t("AppId", localQualitySessionRuntime.appId, true);
    localii.eqt = localii.t("InstanceId", localQualitySessionRuntime.lEv, true);
    localii.evA = localQualitySessionRuntime.mtG;
    localii.esT = localQualitySessionRuntime.apptype;
    localii.eru = localQualitySessionRuntime.mvi;
    localii.dVd = localQualitySessionRuntime.scene;
    localii.nV(paramLong);
    localii.Vg();
    localii.nU(localii.euc - localii.eub);
    localii.evB = paramInt1;
    localii.evC = localii.t("filePath", paramString1, true);
    com.tencent.mm.plugin.appbrand.report.d locald = com.tencent.mm.plugin.appbrand.report.d.d(paramd.aYh());
    label390:
    boolean bool;
    switch (a.5.muq[locald.ordinal()])
    {
    default: 
      paramInt1 = 0;
      localii.evD = paramInt1;
      if ((paramc != null) && (paramc.codeCacheStatus >= 0) && (paramc.codeCacheStatus < v.lBM.length))
      {
        paramLong = v.lBM[paramc.codeCacheStatus];
        localii.evE = paramLong;
        if (!(paramd instanceof com.tencent.mm.plugin.appbrand.service.c)) {
          break label950;
        }
        bool = ((com.tencent.mm.plugin.appbrand.service.c)paramd).coU.CK();
        label416:
        if (!bool) {
          break label981;
        }
        paramLong = 1L;
        label424:
        localii.evF = paramLong;
        if (paramc == null) {
          break label987;
        }
        paramLong = paramc.flatJSCompileCost;
        label443:
        localii.evG = paramLong;
        if (!org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.report.d.mqV, locald)) {
          break label993;
        }
        localii.qV(V8.getV8Version());
        label470:
        localii.evH = localii.t("pluginAppid", paramString2, true);
        localii.evI = localii.t("pluginVersion", String.valueOf(paramInt2), true);
        localii.aLk();
        if ((paramd instanceof com.tencent.mm.plugin.appbrand.q))
        {
          paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.o.a();
          paramString2.setName("evaluateJavaScript");
          paramString2.startTime = localii.eub;
          paramString2.endTime = localii.euc;
          paramString2.r("fileName", localii.evC);
          paramString2.r("size", Long.valueOf(localii.evB));
          paramString2.c((com.tencent.mm.plugin.appbrand.q)paramd);
        }
        if ((!localQualitySessionRuntime.mvt.mur) && ((paramString1.endsWith("app-service.js")) || ("game.js".equals(paramString1))))
        {
          localQualitySessionRuntime.mvt.mur = true;
          localQualitySessionRuntime.mvo = System.currentTimeMillis();
          paramd = localQualitySessionRuntime.jCo;
          paramString1 = new ij();
          paramString2 = aA(str, true);
          if (paramString2 != null)
          {
            paramString1.esR = paramString1.t("AppId", paramString2.appId, true);
            paramString1.eqt = paramString1.t("InstanceId", paramString2.lEv, true);
            paramString1.evJ = ij.a.jp(paramString2.mtG);
            paramString1.esT = paramString2.apptype;
            paramString1.eru = paramString2.mvi;
            paramString1.dVd = paramString2.scene;
            paramString1.nX(paramString2.mvl);
            paramString1.Vh();
            paramString1.nW(paramString1.euc - paramString2.mvl);
            paramString1.evk = paramString1.t("path", com.tencent.mm.compatible.util.q.encode(paramd.aVW()), true);
            if (!paramd.jzn) {
              break label1028;
            }
            paramLong = 1L;
            label783:
            paramString1.etL = paramLong;
            if (paramString2.mvr == null) {
              break label1040;
            }
            if (!paramString2.mvr.bqX()) {
              break label1034;
            }
            paramLong = 1L;
            paramString1.evl = paramLong;
          }
        }
      }
      break;
    }
    label950:
    label981:
    label987:
    label993:
    while (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
      for (;;)
      {
        paramString1.etI = paramString2.bxU();
        paramString1.etv = paramString1.t("networkType", com.tencent.mm.plugin.appbrand.report.q.dK(aj.getContext()), true);
        paramString1.evm = paramString2.mvA;
        paramString1.evK = paramString2.bxX();
        paramString1.aLk();
        if (DebuggerShell.bew()) {
          com.tencent.mm.plugin.appbrand.performance.c.b(str, "JsInject", localii.eub, localii.euc);
        }
        AppMethodBeat.o(188719);
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
        if ((paramd instanceof ae))
        {
          bool = ((ae)paramd).aXe().coU.CK();
          break label416;
        }
        bool = false;
        break label416;
        paramLong = 0L;
        break label424;
        paramLong = 0L;
        break label443;
        if (!(paramd.aYh() instanceof ay)) {
          break label470;
        }
        localii.qV(b.bxO());
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
    AppMethodBeat.o(188719);
    throw paramd;
  }
  
  public static void a(String paramString, AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, o paramo)
  {
    AppMethodBeat.i(48192);
    QualitySessionRuntime localQualitySessionRuntime1 = aA(paramString, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(48192);
      return;
    }
    localQualitySessionRuntime1.mvn = System.currentTimeMillis();
    localQualitySessionRuntime1.mvr = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime1.mvl = paramo.aXc().startTime;
    paramAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramo.c(AppStartupPerformanceReportBundle.class, false);
    if (paramAppStartupPerformanceReportBundle == null) {
      ad.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    iz localiz;
    QualitySessionRuntime localQualitySessionRuntime2;
    do
    {
      m.runOnUiThread(new a.3(localQualitySessionRuntime1, paramAppBrandSysConfigWC));
      AppMethodBeat.o(48192);
      return;
      localiz = new iz();
      localQualitySessionRuntime2 = aA(paramString, true);
    } while (localQualitySessionRuntime2 == null);
    localiz.esR = localiz.t("AppId", localQualitySessionRuntime2.appId, true);
    localiz.eqt = localiz.t("InstanceId", localQualitySessionRuntime2.lEv, true);
    localiz.eza = iz.a.jF(localQualitySessionRuntime2.mtG);
    localiz.esT = localQualitySessionRuntime2.apptype;
    localiz.dVd = localQualitySessionRuntime2.scene;
    localiz.eru = localQualitySessionRuntime2.mvi;
    localiz.po(paramo.aXc().startTime);
    localiz.Vo();
    localiz.pn(localiz.euc - paramo.aXc().startTime);
    localiz.ezi = (paramAppStartupPerformanceReportBundle.lGi - paramAppStartupPerformanceReportBundle.lGh);
    localiz.ezj = (paramAppStartupPerformanceReportBundle.lGk - paramAppStartupPerformanceReportBundle.lGj);
    localiz.ezk = localQualitySessionRuntime2.mvj;
    localiz.ezl = paramAppStartupPerformanceReportBundle.lGn;
    Object localObject = paramo.aXb();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramo.aXc();
    label307:
    label325:
    long l1;
    if (paramAppStartupPerformanceReportBundle.lGo)
    {
      paramString = iz.c.ezv;
      localiz.ezc = paramString;
      if (!localAppBrandInitConfigWC.cmB) {
        break label572;
      }
      paramString = iz.b.ezs;
      localiz.ezd = paramString;
      if (!paramo.jzn) {
        break label579;
      }
      l1 = 1L;
      label341:
      localiz.eze = l1;
      long l2 = 0L;
      if (com.tencent.mm.vfs.i.fv(((AppBrandSysConfigWC)localObject).jYh.pkgPath)) {
        break label585;
      }
      paramString = ((AppBrandSysConfigWC)localObject).jYh.jIX.iterator();
      do
      {
        l1 = l2;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (ModulePkgInfo)paramString.next();
      } while (!com.tencent.mm.vfs.i.fv(((ModulePkgInfo)localObject).pkgPath));
      l1 = com.tencent.mm.vfs.i.aYo(((ModulePkgInfo)localObject).pkgPath);
      label422:
      if (!paramo.jzn) {
        break label601;
      }
      label429:
      localiz.ezb = l1;
      localiz.ega = f.getNetworkType();
      localiz.evm = localQualitySessionRuntime2.mvA;
      localiz.etI = localQualitySessionRuntime2.bxU();
      localiz.pp(localQualitySessionRuntime2.mvr.lGg - localQualitySessionRuntime2.mvr.lFQ);
      if (!paramAppStartupPerformanceReportBundle.lGp) {
        break label607;
      }
    }
    label572:
    label579:
    label585:
    label601:
    label607:
    for (paramString = iz.d.ezy;; paramString = iz.d.ezz)
    {
      localiz.ezm = paramString;
      localiz.ezn = (paramAppStartupPerformanceReportBundle.lGm - paramAppStartupPerformanceReportBundle.lGl);
      localiz.evK = localQualitySessionRuntime2.bxX();
      localiz.aLk();
      if (!DebuggerShell.bew()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.performance.c.b(localiz.esR, "ResourcePrepare", localiz.eub, localiz.euc);
      break;
      paramString = iz.c.ezw;
      break label307;
      paramString = iz.b.ezt;
      break label325;
      l1 = 0L;
      break label341;
      l1 = com.tencent.mm.vfs.i.aYo(((AppBrandSysConfigWC)localObject).jYh.pkgPath);
      break label422;
      l1 = 0L;
      break label429;
    }
  }
  
  /* Error */
  public static void a(String paramString, o paramo)
  {
    // Byte code:
    //   0: ldc_w 1152
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 208	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +26 -> 41
    //   18: ldc 57
    //   20: ldc_w 1154
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc_w 1152
    //   37: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: ldc 57
    //   43: ldc_w 1156
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 80	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 4
    //   59: aconst_null
    //   60: putfield 341	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvC	Lcom/tencent/mm/g/b/a/if;
    //   63: new 1158	com/tencent/mm/g/b/a/ik
    //   66: dup
    //   67: invokespecial 1159	com/tencent/mm/g/b/a/ik:<init>	()V
    //   70: astore 4
    //   72: aload_0
    //   73: iconst_1
    //   74: invokestatic 208	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +448 -> 529
    //   84: aload 4
    //   86: aload 4
    //   88: ldc 229
    //   90: aload 5
    //   92: getfield 191	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   95: iconst_1
    //   96: invokevirtual 1160	com/tencent/mm/g/b/a/ik:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: putfield 1161	com/tencent/mm/g/b/a/ik:esR	Ljava/lang/String;
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 217
    //   108: aload 5
    //   110: getfield 220	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lEv	Ljava/lang/String;
    //   113: iconst_1
    //   114: invokevirtual 1160	com/tencent/mm/g/b/a/ik:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   117: putfield 1162	com/tencent/mm/g/b/a/ik:eqt	Ljava/lang/String;
    //   120: aload 4
    //   122: aload 5
    //   124: getfield 241	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mtG	I
    //   127: invokestatic 1168	com/tencent/mm/g/b/a/ik$a:jq	(I)Lcom/tencent/mm/g/b/a/ik$a;
    //   130: putfield 1172	com/tencent/mm/g/b/a/ik:evP	Lcom/tencent/mm/g/b/a/ik$a;
    //   133: aload 4
    //   135: aload 5
    //   137: getfield 254	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   140: i2l
    //   141: putfield 1173	com/tencent/mm/g/b/a/ik:esT	J
    //   144: aload 4
    //   146: aload 5
    //   148: getfield 235	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvi	I
    //   151: i2l
    //   152: putfield 1174	com/tencent/mm/g/b/a/ik:eru	J
    //   155: aload 4
    //   157: aload 5
    //   159: getfield 365	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   162: i2l
    //   163: putfield 1175	com/tencent/mm/g/b/a/ik:dVd	J
    //   166: aload 4
    //   168: aload_1
    //   169: invokevirtual 86	com/tencent/mm/plugin/appbrand/o:aXc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   172: getfield 260	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   175: invokevirtual 1179	com/tencent/mm/g/b/a/ik:nZ	(J)Lcom/tencent/mm/g/b/a/ik;
    //   178: pop
    //   179: aload 4
    //   181: invokevirtual 1183	com/tencent/mm/g/b/a/ik:Vi	()Lcom/tencent/mm/g/b/a/ik;
    //   184: pop
    //   185: aload 4
    //   187: aload 4
    //   189: getfield 1184	com/tencent/mm/g/b/a/ik:euc	J
    //   192: aload 4
    //   194: getfield 1185	com/tencent/mm/g/b/a/ik:eub	J
    //   197: lsub
    //   198: invokevirtual 1188	com/tencent/mm/g/b/a/ik:nY	(J)Lcom/tencent/mm/g/b/a/ik;
    //   201: pop
    //   202: aload 4
    //   204: aload 4
    //   206: ldc_w 283
    //   209: aload_1
    //   210: invokevirtual 1192	com/tencent/mm/plugin/appbrand/o:aXd	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   213: invokevirtual 1197	com/tencent/mm/plugin/appbrand/page/v:getCurrentUrl	()Ljava/lang/String;
    //   216: invokestatic 291	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 296	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: iconst_1
    //   223: invokevirtual 1160	com/tencent/mm/g/b/a/ik:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   226: putfield 1198	com/tencent/mm/g/b/a/ik:evk	Ljava/lang/String;
    //   229: aload 5
    //   231: getfield 302	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvE	Z
    //   234: ifeq +895 -> 1129
    //   237: lconst_1
    //   238: lstore_2
    //   239: aload 4
    //   241: lload_2
    //   242: putfield 1199	com/tencent/mm/g/b/a/ik:etL	J
    //   245: aload 5
    //   247: getfield 309	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvr	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   250: ifnull +889 -> 1139
    //   253: aload 5
    //   255: getfield 309	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvr	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   258: invokevirtual 314	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:bqX	()Z
    //   261: ifeq +873 -> 1134
    //   264: lconst_1
    //   265: lstore_2
    //   266: aload 4
    //   268: lload_2
    //   269: putfield 1200	com/tencent/mm/g/b/a/ik:evl	J
    //   272: aload 4
    //   274: aload 5
    //   276: invokevirtual 320	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxU	()J
    //   279: putfield 1201	com/tencent/mm/g/b/a/ik:etI	J
    //   282: aload 4
    //   284: lconst_0
    //   285: putfield 1204	com/tencent/mm/g/b/a/ik:evt	J
    //   288: aload 4
    //   290: aload 4
    //   292: ldc_w 888
    //   295: invokestatic 382	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   298: invokestatic 893	com/tencent/mm/plugin/appbrand/report/q:dK	(Landroid/content/Context;)Ljava/lang/String;
    //   301: iconst_1
    //   302: invokevirtual 1160	com/tencent/mm/g/b/a/ik:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   305: putfield 1205	com/tencent/mm/g/b/a/ik:etv	Ljava/lang/String;
    //   308: aload_1
    //   309: invokevirtual 1028	com/tencent/mm/plugin/appbrand/o:aXb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   312: getfield 1209	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:cni	Ljava/util/List;
    //   315: astore 6
    //   317: aload_1
    //   318: invokevirtual 1028	com/tencent/mm/plugin/appbrand/o:aXb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   321: getfield 1058	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:jYh	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   324: getfield 1213	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:jIZ	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   327: astore 7
    //   329: aload 6
    //   331: ifnull +833 -> 1164
    //   334: aload 6
    //   336: invokeinterface 1217 1 0
    //   341: ifle +823 -> 1164
    //   344: aload 4
    //   346: lconst_1
    //   347: putfield 1220	com/tencent/mm/g/b/a/ik:evu	J
    //   350: aload 4
    //   352: aload 5
    //   354: getfield 178	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvA	J
    //   357: putfield 1221	com/tencent/mm/g/b/a/ik:evm	J
    //   360: aload 5
    //   362: invokevirtual 1224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxV	()Z
    //   365: ifeq +847 -> 1212
    //   368: lconst_1
    //   369: lstore_2
    //   370: aload 4
    //   372: lload_2
    //   373: putfield 1227	com/tencent/mm/g/b/a/ik:evv	J
    //   376: aload 4
    //   378: aload_1
    //   379: invokevirtual 428	com/tencent/mm/plugin/appbrand/o:aXj	()I
    //   382: i2l
    //   383: putfield 1228	com/tencent/mm/g/b/a/ik:evc	J
    //   386: aload_1
    //   387: invokevirtual 86	com/tencent/mm/plugin/appbrand/o:aXc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   390: getfield 1231	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:jXF	Z
    //   393: ifeq +824 -> 1217
    //   396: lconst_1
    //   397: lstore_2
    //   398: aload 4
    //   400: lload_2
    //   401: putfield 1234	com/tencent/mm/g/b/a/ik:evR	J
    //   404: aload_1
    //   405: invokevirtual 613	com/tencent/mm/plugin/appbrand/o:aVF	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   408: astore 6
    //   410: aload 6
    //   412: ifnull +810 -> 1222
    //   415: aload 4
    //   417: aload 4
    //   419: ldc_w 1236
    //   422: aload 6
    //   424: invokeinterface 1239 1 0
    //   429: iconst_1
    //   430: invokevirtual 1160	com/tencent/mm/g/b/a/ik:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   433: putfield 1242	com/tencent/mm/g/b/a/ik:evQ	Ljava/lang/String;
    //   436: aload 4
    //   438: aload 5
    //   440: getfield 329	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvq	J
    //   443: putfield 1243	com/tencent/mm/g/b/a/ik:evn	J
    //   446: aload 4
    //   448: aload 5
    //   450: invokevirtual 900	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxX	()J
    //   453: putfield 1244	com/tencent/mm/g/b/a/ik:evK	J
    //   456: aload 4
    //   458: invokevirtual 1245	com/tencent/mm/g/b/a/ik:aLk	()Z
    //   461: pop
    //   462: invokestatic 909	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bew	()Z
    //   465: ifeq +64 -> 529
    //   468: aload 5
    //   470: getfield 302	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvE	Z
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
    //   494: invokestatic 819	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   497: aastore
    //   498: invokestatic 1253	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   501: astore 5
    //   503: aload 4
    //   505: getfield 1161	com/tencent/mm/g/b/a/ik:esR	Ljava/lang/String;
    //   508: ldc_w 1255
    //   511: ldc_w 1257
    //   514: aload 4
    //   516: getfield 1185	com/tencent/mm/g/b/a/ik:eub	J
    //   519: aload 4
    //   521: getfield 1184	com/tencent/mm/g/b/a/ik:euc	J
    //   524: aload 5
    //   526: invokestatic 1260	com/tencent/mm/plugin/appbrand/performance/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
    //   529: new 1262	com/tencent/mm/g/b/a/jc
    //   532: dup
    //   533: invokespecial 1263	com/tencent/mm/g/b/a/jc:<init>	()V
    //   536: astore 4
    //   538: aload_0
    //   539: iconst_1
    //   540: invokestatic 208	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   543: astore 5
    //   545: aload 5
    //   547: ifnull +256 -> 803
    //   550: aload 5
    //   552: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   555: putfield 1266	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvp	J
    //   558: aload 4
    //   560: aload 4
    //   562: ldc 229
    //   564: aload 5
    //   566: getfield 191	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   569: iconst_1
    //   570: invokevirtual 1267	com/tencent/mm/g/b/a/jc:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   573: putfield 1268	com/tencent/mm/g/b/a/jc:esR	Ljava/lang/String;
    //   576: aload 4
    //   578: aload 4
    //   580: ldc 217
    //   582: aload 5
    //   584: getfield 220	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lEv	Ljava/lang/String;
    //   587: iconst_1
    //   588: invokevirtual 1267	com/tencent/mm/g/b/a/jc:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   591: putfield 1269	com/tencent/mm/g/b/a/jc:eqt	Ljava/lang/String;
    //   594: aload 4
    //   596: aload 5
    //   598: getfield 241	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mtG	I
    //   601: invokestatic 1275	com/tencent/mm/g/b/a/jc$a:jI	(I)Lcom/tencent/mm/g/b/a/jc$a;
    //   604: putfield 1279	com/tencent/mm/g/b/a/jc:ezJ	Lcom/tencent/mm/g/b/a/jc$a;
    //   607: aload 4
    //   609: aload 5
    //   611: getfield 254	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   614: i2l
    //   615: putfield 1280	com/tencent/mm/g/b/a/jc:esT	J
    //   618: aload 4
    //   620: aload 5
    //   622: getfield 235	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvi	I
    //   625: i2l
    //   626: putfield 1281	com/tencent/mm/g/b/a/jc:eru	J
    //   629: aload 4
    //   631: aload 5
    //   633: getfield 365	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   636: i2l
    //   637: putfield 1282	com/tencent/mm/g/b/a/jc:dVd	J
    //   640: aload 4
    //   642: aload 5
    //   644: getfield 947	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvn	J
    //   647: invokevirtual 1286	com/tencent/mm/g/b/a/jc:pz	(J)Lcom/tencent/mm/g/b/a/jc;
    //   650: pop
    //   651: aload 4
    //   653: invokevirtual 1290	com/tencent/mm/g/b/a/jc:Vq	()Lcom/tencent/mm/g/b/a/jc;
    //   656: pop
    //   657: aload 4
    //   659: aload 4
    //   661: getfield 1291	com/tencent/mm/g/b/a/jc:euc	J
    //   664: aload 5
    //   666: getfield 947	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvn	J
    //   669: lsub
    //   670: invokevirtual 1294	com/tencent/mm/g/b/a/jc:py	(J)Lcom/tencent/mm/g/b/a/jc;
    //   673: pop
    //   674: aload 4
    //   676: aload 5
    //   678: invokevirtual 320	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxU	()J
    //   681: putfield 1295	com/tencent/mm/g/b/a/jc:etI	J
    //   684: aload 4
    //   686: aload 4
    //   688: ldc_w 283
    //   691: aload_1
    //   692: invokevirtual 1192	com/tencent/mm/plugin/appbrand/o:aXd	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   695: invokevirtual 1197	com/tencent/mm/plugin/appbrand/page/v:getCurrentUrl	()Ljava/lang/String;
    //   698: invokestatic 296	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   701: iconst_1
    //   702: invokevirtual 1267	com/tencent/mm/g/b/a/jc:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   705: putfield 1296	com/tencent/mm/g/b/a/jc:evk	Ljava/lang/String;
    //   708: aload 4
    //   710: lconst_0
    //   711: putfield 1297	com/tencent/mm/g/b/a/jc:evt	J
    //   714: aload 4
    //   716: aload 4
    //   718: ldc_w 888
    //   721: invokestatic 382	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   724: invokestatic 893	com/tencent/mm/plugin/appbrand/report/q:dK	(Landroid/content/Context;)Ljava/lang/String;
    //   727: iconst_1
    //   728: invokevirtual 1267	com/tencent/mm/g/b/a/jc:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   731: putfield 1298	com/tencent/mm/g/b/a/jc:etv	Ljava/lang/String;
    //   734: aload 4
    //   736: aload 5
    //   738: getfield 178	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvA	J
    //   741: putfield 1299	com/tencent/mm/g/b/a/jc:evm	J
    //   744: aload 5
    //   746: invokevirtual 1224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxV	()Z
    //   749: ifeq +500 -> 1249
    //   752: lconst_1
    //   753: lstore_2
    //   754: aload 4
    //   756: lload_2
    //   757: putfield 1300	com/tencent/mm/g/b/a/jc:evv	J
    //   760: aload 4
    //   762: aload 5
    //   764: invokevirtual 900	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxX	()J
    //   767: putfield 1301	com/tencent/mm/g/b/a/jc:evK	J
    //   770: aload 4
    //   772: invokevirtual 1302	com/tencent/mm/g/b/a/jc:aLk	()Z
    //   775: pop
    //   776: invokestatic 909	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bew	()Z
    //   779: ifeq +24 -> 803
    //   782: aload 4
    //   784: getfield 1268	com/tencent/mm/g/b/a/jc:esR	Ljava/lang/String;
    //   787: ldc_w 1304
    //   790: aload 4
    //   792: getfield 1305	com/tencent/mm/g/b/a/jc:eub	J
    //   795: aload 4
    //   797: getfield 1291	com/tencent/mm/g/b/a/jc:euc	J
    //   800: invokestatic 917	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   803: new 1307	com/tencent/mm/g/b/a/ih
    //   806: dup
    //   807: invokespecial 1308	com/tencent/mm/g/b/a/ih:<init>	()V
    //   810: astore 4
    //   812: aload_0
    //   813: iconst_1
    //   814: invokestatic 208	com/tencent/mm/plugin/appbrand/report/quality/a:aA	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   817: astore 5
    //   819: aload 5
    //   821: ifnull +275 -> 1096
    //   824: aload 4
    //   826: aload 4
    //   828: ldc 229
    //   830: aload 5
    //   832: getfield 191	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   835: iconst_1
    //   836: invokevirtual 1309	com/tencent/mm/g/b/a/ih:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   839: putfield 1310	com/tencent/mm/g/b/a/ih:esR	Ljava/lang/String;
    //   842: aload 4
    //   844: aload 4
    //   846: ldc 217
    //   848: aload 5
    //   850: getfield 220	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:lEv	Ljava/lang/String;
    //   853: iconst_1
    //   854: invokevirtual 1309	com/tencent/mm/g/b/a/ih:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   857: putfield 1311	com/tencent/mm/g/b/a/ih:eqt	Ljava/lang/String;
    //   860: aload 4
    //   862: aload 5
    //   864: getfield 241	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mtG	I
    //   867: invokestatic 1317	com/tencent/mm/g/b/a/ih$a:jo	(I)Lcom/tencent/mm/g/b/a/ih$a;
    //   870: putfield 1321	com/tencent/mm/g/b/a/ih:evs	Lcom/tencent/mm/g/b/a/ih$a;
    //   873: aload 4
    //   875: aload 5
    //   877: getfield 254	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   880: i2l
    //   881: putfield 1322	com/tencent/mm/g/b/a/ih:esT	J
    //   884: aload 4
    //   886: aload 5
    //   888: getfield 235	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvi	I
    //   891: i2l
    //   892: putfield 1323	com/tencent/mm/g/b/a/ih:eru	J
    //   895: aload 4
    //   897: aload 5
    //   899: getfield 365	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   902: i2l
    //   903: putfield 1324	com/tencent/mm/g/b/a/ih:dVd	J
    //   906: aload 4
    //   908: aload 5
    //   910: getfield 845	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvo	J
    //   913: invokevirtual 1328	com/tencent/mm/g/b/a/ih:nT	(J)Lcom/tencent/mm/g/b/a/ih;
    //   916: pop
    //   917: aload 4
    //   919: invokevirtual 1332	com/tencent/mm/g/b/a/ih:Vf	()Lcom/tencent/mm/g/b/a/ih;
    //   922: pop
    //   923: aload 4
    //   925: aload 4
    //   927: getfield 1333	com/tencent/mm/g/b/a/ih:euc	J
    //   930: aload 5
    //   932: getfield 845	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvo	J
    //   935: lsub
    //   936: invokevirtual 1336	com/tencent/mm/g/b/a/ih:nS	(J)Lcom/tencent/mm/g/b/a/ih;
    //   939: pop
    //   940: aload 4
    //   942: aload 5
    //   944: invokevirtual 320	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxU	()J
    //   947: putfield 1337	com/tencent/mm/g/b/a/ih:etI	J
    //   950: aload 4
    //   952: aload 4
    //   954: ldc_w 283
    //   957: aload_1
    //   958: invokevirtual 1192	com/tencent/mm/plugin/appbrand/o:aXd	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   961: invokevirtual 1197	com/tencent/mm/plugin/appbrand/page/v:getCurrentUrl	()Ljava/lang/String;
    //   964: invokestatic 296	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   967: iconst_1
    //   968: invokevirtual 1309	com/tencent/mm/g/b/a/ih:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   971: putfield 1338	com/tencent/mm/g/b/a/ih:evk	Ljava/lang/String;
    //   974: aload 4
    //   976: lconst_0
    //   977: putfield 1339	com/tencent/mm/g/b/a/ih:evt	J
    //   980: aload 4
    //   982: aload 4
    //   984: ldc_w 888
    //   987: invokestatic 382	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   990: invokestatic 893	com/tencent/mm/plugin/appbrand/report/q:dK	(Landroid/content/Context;)Ljava/lang/String;
    //   993: iconst_1
    //   994: invokevirtual 1309	com/tencent/mm/g/b/a/ih:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   997: putfield 1340	com/tencent/mm/g/b/a/ih:etv	Ljava/lang/String;
    //   1000: aload_1
    //   1001: invokevirtual 1028	com/tencent/mm/plugin/appbrand/o:aXb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1004: getfield 1209	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:cni	Ljava/util/List;
    //   1007: astore 6
    //   1009: aload_1
    //   1010: invokevirtual 1028	com/tencent/mm/plugin/appbrand/o:aXb	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   1013: getfield 1058	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:jYh	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   1016: getfield 1213	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:jIZ	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   1019: astore_1
    //   1020: aload 6
    //   1022: ifnull +232 -> 1254
    //   1025: aload 6
    //   1027: invokeinterface 1217 1 0
    //   1032: ifle +222 -> 1254
    //   1035: aload 4
    //   1037: lconst_1
    //   1038: putfield 1341	com/tencent/mm/g/b/a/ih:evu	J
    //   1041: aload 4
    //   1043: aload 5
    //   1045: getfield 178	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:mvA	J
    //   1048: putfield 1342	com/tencent/mm/g/b/a/ih:evm	J
    //   1051: aload 5
    //   1053: invokevirtual 1224	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:bxV	()Z
    //   1056: ifeq +241 -> 1297
    //   1059: lconst_1
    //   1060: lstore_2
    //   1061: aload 4
    //   1063: lload_2
    //   1064: putfield 1343	com/tencent/mm/g/b/a/ih:evv	J
    //   1067: aload 4
    //   1069: invokevirtual 1344	com/tencent/mm/g/b/a/ih:aLk	()Z
    //   1072: pop
    //   1073: invokestatic 909	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bew	()Z
    //   1076: ifeq +20 -> 1096
    //   1079: aload_0
    //   1080: ldc_w 1346
    //   1083: aload 4
    //   1085: getfield 1347	com/tencent/mm/g/b/a/ih:eub	J
    //   1088: aload 4
    //   1090: getfield 1333	com/tencent/mm/g/b/a/ih:euc	J
    //   1093: invokestatic 917	com/tencent/mm/plugin/appbrand/performance/c:b	(Ljava/lang/String;Ljava/lang/String;JJ)V
    //   1096: ldc_w 1152
    //   1099: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1102: return
    //   1103: astore 6
    //   1105: ldc 57
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
    //   1123: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1126: goto -897 -> 229
    //   1129: lconst_0
    //   1130: lstore_2
    //   1131: goto -892 -> 239
    //   1134: lconst_0
    //   1135: lstore_2
    //   1136: goto -870 -> 266
    //   1139: getstatic 661	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   1142: ifeq -870 -> 272
    //   1145: new 663	java/lang/IllegalStateException
    //   1148: dup
    //   1149: ldc_w 942
    //   1152: invokespecial 668	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1155: astore_0
    //   1156: ldc_w 1152
    //   1159: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1162: aload_0
    //   1163: athrow
    //   1164: aload 7
    //   1166: ifnull +37 -> 1203
    //   1169: aload 7
    //   1171: ldc_w 1351
    //   1174: invokevirtual 1357	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:LN	(Ljava/lang/String;)Ljava/util/List;
    //   1177: astore 6
    //   1179: aload 6
    //   1181: ifnull -831 -> 350
    //   1184: aload 6
    //   1186: invokeinterface 1217 1 0
    //   1191: ifle -841 -> 350
    //   1194: aload 4
    //   1196: lconst_1
    //   1197: putfield 1220	com/tencent/mm/g/b/a/ik:evu	J
    //   1200: goto -850 -> 350
    //   1203: aload 4
    //   1205: lconst_0
    //   1206: putfield 1220	com/tencent/mm/g/b/a/ik:evu	J
    //   1209: goto -859 -> 350
    //   1212: lconst_0
    //   1213: lstore_2
    //   1214: goto -844 -> 370
    //   1217: lconst_0
    //   1218: lstore_2
    //   1219: goto -821 -> 398
    //   1222: ldc 57
    //   1224: ldc_w 1359
    //   1227: iconst_1
    //   1228: anewarray 4	java/lang/Object
    //   1231: dup
    //   1232: iconst_0
    //   1233: aload_1
    //   1234: getfield 65	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   1237: aastore
    //   1238: invokestatic 1362	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1262: invokevirtual 1357	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:LN	(Ljava/lang/String;)Ljava/util/List;
    //   1265: astore_1
    //   1266: aload_1
    //   1267: ifnull -226 -> 1041
    //   1270: aload_1
    //   1271: invokeinterface 1217 1 0
    //   1276: ifle -235 -> 1041
    //   1279: aload 4
    //   1281: lconst_1
    //   1282: putfield 1341	com/tencent/mm/g/b/a/ih:evu	J
    //   1285: goto -244 -> 1041
    //   1288: aload 4
    //   1290: lconst_0
    //   1291: putfield 1341	com/tencent/mm/g/b/a/ih:evu	J
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
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48187);
        QualitySessionRuntime localQualitySessionRuntime = a.Ut(this.jBr);
        if ((localQualitySessionRuntime != null) && (paramb != null))
        {
          Object localObject;
          if ((paramb.mqr != null) && (paramb.mqr.HRQ != 0))
          {
            ad.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.mqr.HRQ), Integer.valueOf(paramb.mqr.HRR) });
            localObject = null;
            switch (paramb.mqr.HRQ)
            {
            default: 
              ad.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
            }
          }
          for (;;)
          {
            if (localObject != null) {
              localQualitySessionRuntime.mvu.a(localQualitySessionRuntime, paramb.mqr.HRR, (e.a)localObject, true);
            }
            if ((paramb.mqt == null) || (!paramb.mqt.HRN)) {
              break label324;
            }
            localObject = com.tencent.luggage.game.e.a.DO();
            boolean bool = paramb.mqt.HRN;
            int i = paramb.mqt.HRO;
            double d = paramb.mqt.HRP;
            try
            {
              ad.i("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Double.valueOf(d) });
              ((com.tencent.luggage.game.e.a)localObject).clE = bool;
              ((com.tencent.luggage.game.e.a)localObject).clF = i;
              ((com.tencent.luggage.game.e.a)localObject).clG = d;
              AppMethodBeat.o(48187);
              return;
              localObject = e.a.muA;
              continue;
              localObject = e.a.muB;
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
  
  private static QualitySessionRuntime aA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48191);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (mum)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)mum.get(paramString);
      if (localQualitySessionRuntime != null) {
        break label108;
      }
      paramString = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[] { paramString });
      if ((paramBoolean) && ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)))
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
  
  public static b bxN()
  {
    return mul;
  }
  
  public static final class a
  {
    boolean mur = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */