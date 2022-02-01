package com.tencent.mm.plugin.appbrand.launching;

import android.os.Looper;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.acj;
import com.tencent.mm.f.a.ack;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.f.b.a.nh;
import com.tencent.mm.f.b.a.ps;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;

public final class j
  implements ILaunchWxaAppInfoNotify, y
{
  private static final androidx.b.a<String, j> pSK;
  private static final MultiProcessMMKV pSL;
  private static final ConcurrentHashMap<String, QualitySession> pSO;
  private static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> pTl;
  final String appId;
  final String cBH;
  final int cBU;
  private final boolean csz;
  final AppBrandLaunchReferrer cwV;
  final int enterScene;
  final int fXa;
  private AppBrandLaunchFromNotifyReferrer nBB;
  final String nBq;
  final ICommLibReader nYZ;
  private final QualitySession nYk;
  private final com.tencent.luggage.sdk.launching.b pRD;
  private final long pSM;
  private final boolean pSN;
  volatile b pSP;
  volatile boolean pSQ;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> pSR;
  volatile long pSS;
  final String pST;
  final boolean pSU;
  private final WxaAttributes.WxaVersionInfo pSV;
  private boolean pSW;
  private final AppStartupPerformanceReportBundle pSX;
  private volatile long pSY;
  private final List<kv_14609> pSZ;
  private final String pSf;
  private final int pSg;
  private final IListener<lw> pTa;
  private final List<ps> pTb;
  private final IListener<acj> pTc;
  private final IListener<ack> pTd;
  private volatile aj pTe;
  volatile Boolean pTf;
  private volatile HashMap<String, AppRuntimeApiPermissionBundle> pTg;
  private volatile HashMap<String, AppRuntimeAppidABTestPermissionBundle> pTh;
  volatile boolean pTi;
  volatile boolean pTj;
  volatile boolean pTk;
  volatile boolean started;
  final String username;
  
  static
  {
    AppMethodBeat.i(47151);
    pSK = new androidx.b.a();
    pSL = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]");
    pSO = new ConcurrentHashMap();
    pTl = com.tencent.mm.vending.j.a.h(null, null, null);
    AppMethodBeat.o(47151);
  }
  
  j(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(str2, str3, i, j, k, str4, localAppBrandLaunchReferrer, str5, localICommLibReader, localWxaVersionInfo, bool1, bool2, localQualitySession, l, bool3, localb, localAppBrandLaunchFromNotifyReferrer, str1, paramAppBrandInitConfigWC.launchMode);
    AppMethodBeat.i(47135);
    AppMethodBeat.o(47135);
  }
  
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, ICommLibReader paramICommLibReader, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, QualitySession paramQualitySession, long paramLong, boolean paramBoolean3, com.tencent.luggage.sdk.launching.b paramb, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, int paramInt4)
  {
    AppMethodBeat.i(279996);
    this.pSS = -1L;
    this.pSW = false;
    this.pSZ = new CopyOnWriteArrayList();
    this.pTa = new IListener() {};
    this.pTb = new CopyOnWriteArrayList();
    this.pTc = new j.3(this);
    this.pTd = new j.4(this);
    this.pTf = null;
    this.pTh = null;
    this.pTi = false;
    this.pTj = false;
    this.pTk = false;
    this.username = paramString1;
    this.appId = paramString2;
    this.cBU = paramInt1;
    this.fXa = paramInt2;
    this.enterScene = paramInt3;
    this.nBq = paramString3;
    this.cwV = paramAppBrandLaunchReferrer;
    this.pST = paramString4;
    this.nYZ = paramICommLibReader;
    this.cBH = paramQualitySession.cBH;
    this.pSM = paramLong;
    this.pSN = paramBoolean3;
    this.pRD = paramb;
    this.nBB = paramAppBrandLaunchFromNotifyReferrer;
    this.pSf = paramString5;
    this.pSg = paramInt4;
    Assert.assertNotNull("<init> NULL wxaVersionInfo ".concat(String.valueOf(paramString2)), paramWxaVersionInfo);
    this.pSV = paramWxaVersionInfo;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> username[%s] appId[%s] versionType[%d] appVersion[%d], scene[%d] sessionId[%s] instanceId[%s] mIsLaunchedByBackupWxaAttrs[%b]", new Object[] { this.username, this.appId, Integer.valueOf(this.cBU), Integer.valueOf(paramWxaVersionInfo.appVersion), Integer.valueOf(this.enterScene), this.pST, this.cBH, Boolean.valueOf(this.pSN) });
    if (paramICommLibReader == null) {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL acceptedLibReader, instanceId[%s]", new Object[] { this.cBH });
    }
    this.csz = paramBoolean1;
    this.pSU = paramBoolean2;
    this.nYk = paramQualitySession;
    this.pSX = new AppStartupPerformanceReportBundle(paramQualitySession.cBH);
    pSO.put(paramQualitySession.cBH, paramQualitySession);
    if (paramBoolean1) {
      com.tencent.mm.plugin.appbrand.appcache.y.acK(paramString2);
    }
    AppMethodBeat.o(279996);
  }
  
  private void BH(int paramInt)
  {
    AppMethodBeat.i(47136);
    if (this.pSW)
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!"wxb6d22f922f37b35a".equals(this.appId))
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.appcache.j.a.za(this.cBU))
    {
      AppMethodBeat.o(47136);
      return;
    }
    this.pSW = true;
    com.tencent.mm.plugin.report.service.h.IzE.el(1089, paramInt);
    String str = this.appId;
    if (this.pSV == null) {}
    for (int i = 0;; i = this.pSV.appVersion)
    {
      com.tencent.mm.plugin.appbrand.report.j.b(str, i, this.cBU, 1089, paramInt);
      AppMethodBeat.o(47136);
      return;
    }
  }
  
  private boolean a(AppBrandSysConfigWC paramAppBrandSysConfigWC, com.tencent.mm.plugin.appbrand.ac.i<AppBrandLaunchErrorAction> parami)
  {
    AppMethodBeat.i(280002);
    this.pTa.alive();
    j.6 local6;
    Future localFuture2;
    boolean bool;
    label117:
    Object localObject2;
    Object localObject1;
    label191:
    label218:
    j.8 local8;
    if (this.cBU == 0)
    {
      this.pTc.alive();
      paramAppBrandSysConfigWC.nYZ = this.nYZ;
      local6 = new j.6(this, paramAppBrandSysConfigWC.appId, this.cBU, this.nBq, this.enterScene, this.pSV, this.csz, this.nYZ, this.nYk, this.pRD);
      localFuture2 = local6.caf();
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxG, true);
      if (!bool) {
        break label463;
      }
      i = 1;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
      if (!bool) {
        break label468;
      }
      localObject2 = new j.7(this, this.appId, this.cBU, this.csz, this.pSV, this.enterScene, this.pST, this.nYk, this.pRD);
      localObject1 = ((aw)localObject2).caf();
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxI, true);
      if (!bool) {
        break label477;
      }
      i = 1;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PkgABTest", "openGameAppIdABTestPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
      if (!bool) {
        break label482;
      }
      local8 = new j.8(this, this.appId, this.cBU, this.csz, this.pST, this.pSV, this.nYk);
    }
    Object localObject4;
    Object localObject3;
    for (Future localFuture1 = local8.caf();; localFuture1 = null)
    {
      localObject5 = new j.9(this, this.appId, this.cBU, this.fXa, this.enterScene, this.nBq, this.cwV, this.pST, this.nYZ, this.nYk, this.username, this.nBB, this.pSf, this.pRD, this.pSg);
      ((az)localObject5).iR(bZy());
      localObject4 = (Pair)((az)localObject5).cag();
      localObject3 = (aj)((Pair)localObject4).first;
      localObject4 = (cqa)((Pair)localObject4).second;
      this.pSX.pTt = ((az)localObject5).pWY;
      this.pSX.pTu = ((az)localObject5).pWZ;
      if (localObject3 != null) {
        break label491;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", new Object[] { this.username, this.appId });
      AppMethodBeat.o(280002);
      return false;
      this.pTd.alive();
      break;
      label463:
      i = 0;
      break label117;
      label468:
      localObject2 = null;
      localObject1 = null;
      break label191;
      label477:
      i = 0;
      break label218;
      label482:
      local8 = null;
    }
    label491:
    Object localObject5 = AppBrandLaunchErrorAction.CREATOR;
    localObject5 = AppBrandLaunchErrorAction.a.a(this.appId, this.cBU, (aj)localObject3);
    if (localObject5 != null)
    {
      parami.value = localObject5;
      BH(54);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", new Object[] { this.username, this.appId, Integer.valueOf(((aj)localObject3).field_launchAction.SZN) });
      AppMethodBeat.o(280002);
      return false;
    }
    this.pSX.pTC = ((aj)localObject3).pWG;
    if ((((aj)localObject3).field_jsapiInfo == null) || (((aj)localObject3).field_jsapiInfo.SkZ == null))
    {
      BH(54);
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", new Object[] { this.username, this.appId });
      AppMethodBeat.o(280002);
      return false;
    }
    ((aj)localObject3).b(paramAppBrandSysConfigWC);
    if (localObject4 != null)
    {
      if ((((cqa)localObject4).Txx == null) || (!((cqa)localObject4).Txx.TWE)) {
        break label788;
      }
      bool = true;
      paramAppBrandSysConfigWC.cxk.cxR = bool;
      if (bool)
      {
        paramAppBrandSysConfigWC.nYZ = au.bHb();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig(username:%s, appId:%s), LaunchWxaAppResponse.rely_update=true, update acceptedLibReader:%s", new Object[] { this.username, this.appId, paramAppBrandSysConfigWC.nYZ });
      }
    }
    parami = com.tencent.luggage.sdk.f.c.cDf;
    parami = com.tencent.luggage.sdk.f.c.ej(this.cBH).cDb.values().iterator();
    int i = 0;
    label759:
    if (parami.hasNext())
    {
      if (!((com.tencent.luggage.sdk.f.a)parami.next()).cCX) {
        break label2175;
      }
      i = 1;
    }
    label788:
    label878:
    label1651:
    label2175:
    for (;;)
    {
      break label759;
      bool = false;
      break;
      parami = this.pSX;
      long l1;
      int j;
      long l2;
      if (i != 0)
      {
        i = 1;
        parami.pTB = i;
        if ((!com.tencent.mm.plugin.appbrand.appcache.j.a.za(this.cBU)) || (this.pSN)) {
          break label1220;
        }
        parami = ah.eq(this.appId, this.nBq);
        if (!(parami instanceof ah.c.a)) {
          break label1210;
        }
        l1 = ((ah.c.a)parami).pWD - (Util.nowMilliSecond() - this.pSM);
        if (l1 > 0L) {
          break label1205;
        }
        l1 = 9223372036854775807L;
        i = 0;
        localObject4 = this.username;
        localObject5 = this.appId;
        j = this.cBU;
        bool = this.pSN;
        l2 = this.pSM;
        if (i == 0) {
          break label1232;
        }
      }
      for (localObject3 = l1 + "ms";; localObject3 = "false")
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig() before get app pkg, username[%s] appId[%s] versionType[%d] mIsLaunchedByBackupWxaAttrs[%b] clickTimestamp[%d] timeoutStrategy=[%s], fallbackStrategy[%s]", new Object[] { localObject4, localObject5, Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(l2), localObject3, parami });
        try
        {
          localFuture2.get(l1, TimeUnit.MILLISECONDS);
          parami = (WxaPkgWrappingInfo)localFuture2.get();
          this.pSQ = true;
          bZE();
          this.pTa.dead();
          this.pTc.dead();
          this.pTd.dead();
          this.pSX.pTq.addAll(this.pTb);
          this.pSX.pTr.addAll(this.pSZ);
          this.pSX.pTv = local6.pWY;
          this.pSX.pTw = local6.pWZ;
          if (parami != null) {
            break label1545;
          }
          if ((com.tencent.mm.plugin.appbrand.appcache.j.a.za(this.cBU)) && (!this.pSN)) {
            ah.er(this.username, this.appId);
          }
          BH(55);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig NULL app pkg, username:%s, appId:%s, instanceId:%s, sessionId:%s, mIsLaunchedByBackupWxaAttrs:%b", new Object[] { this.username, this.appId, this.cBH, this.pST, Boolean.valueOf(this.pSN) });
          AppMethodBeat.o(280002);
          return false;
        }
        catch (TimeoutException paramAppBrandSysConfigWC)
        {
          if (i == 0) {
            break label1537;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, get app pkg timeout, try fallback backup wxaattrs, username[%s] appId[%s] awaitTimeout[%d]", new Object[] { this.username, this.appId, Long.valueOf(l1) });
          this.pTk = true;
          paramAppBrandSysConfigWC = this.pSP;
          localObject1 = this.username;
          localObject2 = this.appId;
          if (paramAppBrandSysConfigWC != null) {
            break label1511;
          }
          bool = true;
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyFallbackBackupWxaAttrs username[%s] appId[%s] null==callback[%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            if (paramAppBrandSysConfigWC != null) {
              paramAppBrandSysConfigWC.bZA();
            }
            try
            {
              paramAppBrandSysConfigWC = new nh();
              paramAppBrandSysConfigWC.Ef(this.appId);
              paramAppBrandSysConfigWC.Eg(this.username);
              paramAppBrandSysConfigWC.gYC = this.enterScene;
              paramAppBrandSysConfigWC.gYD = this.pSV.appVersion;
              paramAppBrandSysConfigWC.gYE = ((v)m.W(v.class)).d(this.appId, new String[] { "versionInfo" }).bLH().appVersion;
              paramAppBrandSysConfigWC.gYJ = 1L;
              paramAppBrandSysConfigWC.gYK = ((ah.c.a)parami).pWD;
              paramAppBrandSysConfigWC.Eh(com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext()));
              paramAppBrandSysConfigWC.gYI = 0L;
              paramAppBrandSysConfigWC.Ei(this.nYk.cBH);
              paramAppBrandSysConfigWC.bpa();
              ah.b.a(this.nYk.cBH, paramAppBrandSysConfigWC);
              ah.b.ct(this.nYk.cBH, 2);
              AppMethodBeat.o(280002);
              return false;
              bool = false;
            }
            catch (Throwable paramAppBrandSysConfigWC)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, report fallback get exception %s", new Object[] { paramAppBrandSysConfigWC });
              }
            }
          }
          AppMethodBeat.o(280002);
          throw paramAppBrandSysConfigWC;
        }
        i = 0;
        break;
        i = 1;
        break label878;
        l1 = 9223372036854775807L;
        i = 0;
        break label878;
        parami = null;
        i = 0;
        l1 = 9223372036854775807L;
        break label878;
      }
      paramAppBrandSysConfigWC.nYR = parami;
      if (paramAppBrandSysConfigWC.nYR.nHY != 0) {
        paramAppBrandSysConfigWC.nYR.pkgVersion = 0;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username:%s, appId:%s, instanceId:%s, sessionId:%s, pkg:%s", new Object[] { this.username, paramAppBrandSysConfigWC.appId, this.cBH, this.pST, paramAppBrandSysConfigWC.nYR });
      if (com.tencent.mm.plugin.appbrand.ui.recommend.e.cM(this.appId, this.cBU))
      {
        if (this.pSS <= 0L)
        {
          i = 1;
          parami = com.tencent.mm.plugin.report.service.h.IzE;
          if (i == 0) {
            break label2083;
          }
          i = 53;
          parami.el(1089, i);
        }
      }
      else
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.pSX.pTx = ((aw)localObject2).pWY;
          this.pSX.pTy = ((aw)localObject2).pWZ;
          if (((Future)localObject1).get() != null)
          {
            parami = (HashMap)((Pair)((Future)localObject1).get()).first;
            if (parami == null) {
              break label2089;
            }
            i = parami.size();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkWxaJsApiInfoHashMap size:%d", new Object[] { Integer.valueOf(i) });
            paramAppBrandSysConfigWC.cxl = parami;
            this.pSX.pTD = ((Boolean)((Pair)((Future)localObject1).get()).second).booleanValue();
          }
        }
        if ((local8 != null) && (localFuture1 != null))
        {
          this.pSX.pTz = local8.pWY;
          this.pSX.pTA = local8.pWZ;
          if (localFuture1.get() != null)
          {
            parami = (HashMap)((Pair)localFuture1.get()).first;
            if (parami == null) {
              break label2094;
            }
            i = parami.size();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkAppidABTestInfoHashMap size:%d", new Object[] { Integer.valueOf(i) });
            if (parami.size() > 0) {
              paramAppBrandSysConfigWC.cxm = parami;
            }
            this.pSX.pTE = ((Boolean)((Pair)localFuture1.get()).second).booleanValue();
          }
        }
        paramAppBrandSysConfigWC.cxL = AppBrandGlobalSystemConfig.bLe();
        parami = com.tencent.mm.plugin.appbrand.message.h.qhn;
        parami = com.tencent.mm.plugin.appbrand.message.h.eJ(this.appId, "copypath");
        if (parami != null) {
          break label2099;
        }
        l1 = 0L;
        paramAppBrandSysConfigWC.cxK = l1;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + paramAppBrandSysConfigWC.cxK);
        parami = paramAppBrandSysConfigWC.nYR;
        com.tencent.e.h.ZvG.d(new j.10(this, parami), "AppLaunchPrepareProcess#ExtraWorks");
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { this.username, this.appId });
        bZF();
        parami = com.tencent.mm.plugin.appbrand.appstorage.e.rrx;
        paramAppBrandSysConfigWC.nYS = e.a.bkF(this.appId);
        paramAppBrandSysConfigWC.nYT = f.nMh.bIu();
        i = paramAppBrandSysConfigWC.nYS;
        if (i != 2) {
          break label2108;
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(1016L, 7L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(280002);
        return true;
        i = 0;
        break;
        i = 52;
        break label1651;
        i = 0;
        break label1729;
        i = 0;
        break label1849;
        l1 = parami.longValue();
        break label1935;
        if (i == 3) {
          com.tencent.mm.plugin.report.service.h.IzE.p(1016L, 8L, 1L);
        } else if (i == 1) {
          if (f.nMh.bIt()) {
            com.tencent.mm.plugin.report.service.h.IzE.p(1016L, 10L, 1L);
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.p(1016L, 9L, 1L);
          }
        }
      }
    }
  }
  
  static j ajT(String paramString)
  {
    AppMethodBeat.i(47132);
    for (;;)
    {
      synchronized (pSK)
      {
        j localj = (j)pSK.remove(paramString);
        ??? = android.util.Log.getStackTraceString(new Throwable());
        if (localj != null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s), stacktrace=%s", new Object[] { localj.appId, Integer.valueOf(localj.cBU), paramString, ??? });
          AppMethodBeat.o(47132);
          return localj;
        }
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess sessionId(%s) get NULL, stacktrace=%s", new Object[] { paramString, ??? });
    }
  }
  
  static j ajU(String paramString)
  {
    AppMethodBeat.i(47133);
    synchronized (pSK)
    {
      paramString = (j)pSK.get(paramString);
      AppMethodBeat.o(47133);
      return paramString;
    }
  }
  
  private void b(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47141);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process, sessionId:%s, instanceId:%s", new Object[] { this.appId, Integer.valueOf(this.cBU), this.pST, this.cBH });
    a(paramd);
    paramd = com.tencent.luggage.sdk.f.c.cDf;
    paramd = com.tencent.luggage.sdk.f.c.ej(this.cBH);
    if ((paramd instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
      ((com.tencent.mm.plugin.appbrand.launching.d.c)paramd).b(this.nYk);
    }
    paramd = com.tencent.luggage.sdk.f.c.cDf;
    com.tencent.luggage.sdk.f.c.ek(this.cBH);
    pSO.remove(this.cBH);
    AppMethodBeat.o(47141);
  }
  
  private void bZF()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174932);
    Object localObject1 = this.appId;
    Object localObject2;
    if (this.pSP != null)
    {
      bool1 = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForDB start with appId:%s callback!=null:%b ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      localObject1 = com.tencent.e.h.ZvG.o(new Runnable()
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(275173);
          String str = j.this.appId;
          if (j.this.pSP != null) {
            bool = true;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD with appId:%s, callback!=null:%b", new Object[] { str, Boolean.valueOf(bool) });
          if (j.this.pSP != null) {
            j.this.pSP.yL(3);
          }
          AppMethodBeat.o(275173);
        }
      }, 5000L);
      localObject2 = this.appId;
      if (this.pSP == null) {
        break label187;
      }
    }
    label187:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START with appId:%s, callback!=null:%b", new Object[] { localObject2, Boolean.valueOf(bool1) });
      if (this.pSP != null) {
        this.pSP.yL(1);
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.e(this.appId);
      int i = 0;
      while (i <= 0)
      {
        at localat = new at[] { localObject2 }[0];
        if (localat.uQ(com.tencent.mm.protocal.d.RAD)) {
          localat.uP(com.tencent.mm.protocal.d.RAD);
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    ((Future)localObject1).cancel(false);
    localObject1 = this.appId;
    bool1 = bool2;
    if (this.pSP != null) {
      bool1 = true;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH with appId:%s, callback!=null:%b", new Object[] { localObject1, Boolean.valueOf(bool1) });
    if (this.pSP != null) {
      this.pSP.yL(2);
    }
    AppMethodBeat.o(174932);
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47138);
    this.pSR = paramd;
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramd.get(0);
    Object localObject = (AppBrandLaunchErrorAction)paramd.get(1);
    if (this.pTe != null)
    {
      if (localAppBrandSysConfigWC != null)
      {
        this.pTe.b(localAppBrandSysConfigWC);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cxk.cxO, this.username, this.appId });
      }
      localObject = AppBrandLaunchErrorAction.CREATOR;
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = AppBrandLaunchErrorAction.a.a(this.appId, this.cBU, this.pTe);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, updated errorAction[%s] username[%s] appId[%s]", new Object[] { localAppBrandLaunchErrorAction, this.username, this.appId });
      localObject = localAppBrandLaunchErrorAction;
      if (localAppBrandLaunchErrorAction != null)
      {
        localAppBrandSysConfigWC = null;
        localObject = localAppBrandLaunchErrorAction;
      }
    }
    for (;;)
    {
      if ((this.pTg != null) && (localAppBrandSysConfigWC != null))
      {
        localAppBrandSysConfigWC.cxl = this.pTg;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate]] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cxk.cxO, this.username, this.appId });
      }
      if ((this.pTh != null) && (localAppBrandSysConfigWC != null))
      {
        localAppBrandSysConfigWC.cxm = this.pTh;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][notifyAppidABTestPermissionInfoUpdate]] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cxm, this.username, this.appId });
      }
      if (this.pSP != null)
      {
        this.pSP.a(localAppBrandSysConfigWC, (AppBrandLaunchErrorAction)localObject, (AppStartupPerformanceReportBundle)paramd.get(2));
        ajT(this.pST);
      }
      AppMethodBeat.o(47138);
      return;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(279999);
    if (this.pSR != null)
    {
      Object localObject = AppBrandLaunchErrorAction.CREATOR;
      localObject = AppBrandLaunchErrorAction.a.a(this.appId, this.cBU, paramaj);
      if (localObject != null)
      {
        this.pSR = com.tencent.mm.vending.j.a.h(null, localObject, this.pSX);
        AppMethodBeat.o(279999);
        return;
      }
      localObject = (AppBrandSysConfigWC)this.pSR.get(0);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(279999);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramaj });
      paramaj.b((AppBrandSysConfigWC)localObject);
      ((AppBrandSysConfigWC)localObject).cxk.cxR = paramBoolean;
      this.pSR = com.tencent.mm.vending.j.a.h(localObject, null, this.pSX);
      AppMethodBeat.o(279999);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] set mMaybeUpdatedLaunchPB appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramaj });
    this.pTe = paramaj;
    AppMethodBeat.o(279999);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(280000);
    if (this.pSR != null)
    {
      AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)this.pSR.get(0);
      if (localAppBrandSysConfigWC == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(280000);
        return;
      }
      if (paramHashMap == null) {}
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localAppBrandSysConfigWC.cxl = paramHashMap;
        this.pSR = com.tencent.mm.vending.j.a.h(localAppBrandSysConfigWC, null, this.pSX);
        AppMethodBeat.o(280000);
        return;
        i = paramHashMap.size();
      }
    }
    if (paramHashMap == null) {}
    for (i = j;; i = paramHashMap.size())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] set mMaybeUpdatedPluginPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      this.pTg = paramHashMap;
      AppMethodBeat.o(280000);
      return;
    }
  }
  
  public final void b(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(280001);
    if (this.pSR != null)
    {
      AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)this.pSR.get(0);
      if (localAppBrandSysConfigWC == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyAppidABTestPermissionInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(280001);
        return;
      }
      if (paramHashMap == null) {}
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyAppidABTestPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localAppBrandSysConfigWC.cxm = paramHashMap;
        this.pSR = com.tencent.mm.vending.j.a.h(localAppBrandSysConfigWC, null, this.pSX);
        AppMethodBeat.o(280001);
        return;
        i = paramHashMap.size();
      }
    }
    if (paramHashMap == null) {}
    for (i = j;; i = paramHashMap.size())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyAppidABTestPermissionInfoUpdate] set mMaybeUpdatedAppidABTestPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      this.pTh = paramHashMap;
      AppMethodBeat.o(280001);
      return;
    }
  }
  
  public final void bZC()
  {
    AppMethodBeat.i(47140);
    if (this.started)
    {
      AppMethodBeat.o(47140);
      return;
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
    this.started = true;
    this.pSY = Util.nowMilliSecond();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d], instanceId[%s], sessionId[%s]", new Object[] { this.appId, Integer.valueOf(this.cBU), Integer.valueOf(this.enterScene), this.cBH, this.pST });
    synchronized (pSK)
    {
      pSK.put(this.pST, this);
      new a(this.pST, this.cBH, this.nYk).startTimer(TimeUnit.SECONDS.toMillis(300L));
      if (this.pSV == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", new Object[] { this.username, this.appId });
        av.a(au.i.app_brand_launching_get_attrs_invalid_fields, this);
        b(pTl);
        AppMethodBeat.o(47140);
        return;
      }
    }
    new MMHandler(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.cBU) })).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47123);
        try
        {
          j.a(j.this, j.this.bZD());
          com.tencent.mm.plugin.appbrand.keylogger.c.b(j.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(j.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess, localException.getLocalizedMessage());
          av.a(au.i.app_brand_launching_failed, j.this);
          j.a(j.this, j.bZG());
          j.f(j.this);
          return;
        }
        finally
        {
          if (j.this.nYZ != null) {
            org.apache.commons.a.d.closeQuietly(j.this.nYZ);
          }
          AppMethodBeat.o(47123);
        }
        AppMethodBeat.o(47123);
      }
    });
    AppMethodBeat.o(47140);
  }
  
  public final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> bZD()
  {
    int i = 0;
    AppMethodBeat.i(47142);
    AppBrandSysConfigWC localAppBrandSysConfigWC = com.tencent.mm.plugin.appbrand.config.y.afg(this.appId);
    if (localAppBrandSysConfigWC == null) {
      av.a(com.tencent.mm.plugin.appbrand.utils.h.getMMString(au.i.app_brand_preparing_attr_sync_timeout, new Object[] { "" }), this);
    }
    if (localAppBrandSysConfigWC == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!, username:%s, appId:%s", new Object[] { this.username, this.appId });
      if (this.pSV == null) {}
      for (i = 0;; i = this.pSV.appVersion)
      {
        r.a(7, this.appId, i, this.cBU, this.csz);
        localObject = pTl;
        AppMethodBeat.o(47142);
        return localObject;
      }
    }
    ((k)m.W(k.class)).P(com.tencent.mm.plugin.appbrand.config.y.afk(this.appId), Util.nowSecond());
    Object localObject = new com.tencent.mm.plugin.appbrand.ac.i();
    if (!a(localAppBrandSysConfigWC, (com.tencent.mm.plugin.appbrand.ac.i)localObject))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { this.username, this.appId });
      if (this.pSV == null) {}
      for (;;)
      {
        r.a(8, this.appId, i, this.cBU, this.csz);
        localObject = com.tencent.mm.vending.j.a.h(null, ((com.tencent.mm.plugin.appbrand.ac.i)localObject).value, this.pSX);
        AppMethodBeat.o(47142);
        return localObject;
        i = this.pSV.appVersion;
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { this.username, this.appId });
    if (com.tencent.mm.plugin.appbrand.appcache.j.a.za(this.cBU)) {}
    try
    {
      localObject = ah.ajZ(this.username);
      if ((localObject != null) && (((WxaAttributes)localObject).bLH().appVersion == this.pSV.appVersion)) {
        break label507;
      }
      localObject = ((x)m.W(x.class)).c(this.username, new String[0]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs failed with username(%s) appId(%s) by exception:%s", new Object[] { this.username, this.appId, localException });
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs with username(%s) appId(%s), now.versionInfo.appVersion:%d, record.versionInfo.appVersion:%d", new Object[] { this.username, this.appId, Integer.valueOf(this.pSV.appVersion), Integer.valueOf(((WxaAttributes)localObject).bLH().appVersion) });
    if (((WxaAttributes)localObject).bLH().appVersion == this.pSV.appVersion) {
      ((v)m.W(v.class)).d((WxaAttributes)localObject);
    }
    ah.ep(this.username, this.appId);
    ah.es(this.username, this.appId);
    this.pSX.pSY = this.pSY;
    this.pSX.pTs = Util.nowMilliSecond();
    localObject = com.tencent.mm.vending.j.a.h(localAppBrandSysConfigWC, null, this.pSX);
    AppMethodBeat.o(47142);
    return localObject;
  }
  
  final void bZE()
  {
    AppMethodBeat.i(47143);
    if (this.pSP != null) {
      this.pSP.onDownloadProgress(100);
    }
    AppMethodBeat.o(47143);
  }
  
  public final boolean bZy()
  {
    return this.pRD != com.tencent.luggage.sdk.launching.b.cBf;
  }
  
  static final class a
    extends MTimerHandler
  {
    public a(final String paramString1, String paramString2, final QualitySession paramQualitySession)
    {
      super(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47130);
          Object localObject = com.tencent.luggage.sdk.f.c.cDf;
          localObject = com.tencent.luggage.sdk.f.c.ej(j.a.this);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
            ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).b(paramQualitySession);
          }
          localObject = com.tencent.luggage.sdk.f.c.cDf;
          com.tencent.luggage.sdk.f.c.ek(j.a.this);
          j.bvo().remove(j.a.this);
          localObject = j.ajT(paramString1);
          String str;
          if (localObject != null)
          {
            str = ((j)localObject).appId;
            if (j.a((j)localObject) != null) {
              break label105;
            }
          }
          label105:
          for (int i = 0;; i = j.a((j)localObject).appVersion)
          {
            r.a(23, str, i, ((j)localObject).cBU, j.b((j)localObject));
            AppMethodBeat.o(47130);
            return false;
          }
        }
      }, false);
      AppMethodBeat.i(47131);
      AppMethodBeat.o(47131);
    }
  }
  
  static abstract interface b
    extends p
  {
    public abstract void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void bDN();
    
    public abstract void bDO();
    
    public abstract void bDP();
    
    public abstract void bZA();
    
    public abstract void bZz();
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j
 * JD-Core Version:    0.7.0.1
 */