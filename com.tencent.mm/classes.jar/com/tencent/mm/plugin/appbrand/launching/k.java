package com.tencent.mm.plugin.appbrand.launching;

import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.l;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.zo;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.g.b.a.iv;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.z.i<Lcom.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;>;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;

public final class k
  implements ILaunchWxaAppInfoNotify
{
  private static final android.support.v4.e.a<String, k> lFC;
  private static final com.tencent.mm.sdk.platformtools.ax lFD;
  private static final ConcurrentHashMap<String, QualitySession> lFG;
  private static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> lGb;
  final String appId;
  private final boolean ciC;
  final AppBrandLaunchReferrer cmv;
  final int dJQ;
  final int enterScene;
  final int hQh;
  final String jCN;
  private AppBrandLaunchFromNotifyReferrer jCZ;
  private final QualitySession jXD;
  final ICommLibReader jYp;
  private final String lEv;
  private final long lFE;
  private final boolean lFF;
  volatile b lFH;
  volatile boolean lFI;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> lFJ;
  volatile long lFK;
  final String lFL;
  final boolean lFM;
  private final WxaAttributes.WxaVersionInfo lFN;
  private boolean lFO;
  private final AppStartupPerformanceReportBundle lFP;
  private volatile long lFQ;
  private final List<kv_14609> lFR;
  private final com.tencent.mm.sdk.b.c<ko> lFS;
  private final List<iv> lFT;
  private final com.tencent.mm.sdk.b.c<zo> lFU;
  private final com.tencent.mm.sdk.b.c<zp> lFV;
  private volatile ax lFW;
  volatile Boolean lFX;
  private volatile HashMap<String, AppRuntimeApiPermissionBundle> lFY;
  volatile boolean lFZ;
  volatile boolean lGa;
  volatile boolean started;
  final String username;
  
  static
  {
    AppMethodBeat.i(47151);
    lFC = new android.support.v4.e.a();
    lFD = com.tencent.mm.sdk.platformtools.ax.aQz("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]");
    lFG = new ConcurrentHashMap();
    lGb = com.tencent.mm.vending.j.a.i(null, null, null);
    AppMethodBeat.o(47151);
  }
  
  k(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(str1, str2, i, j, k, paramAppBrandStatObject, localAppBrandLaunchReferrer, str3, as.bag(), paramAppBrandInitConfigWC.cmy, paramAppBrandInitConfigWC.Eb(), paramAppBrandInitConfigWC.cms, paramAppBrandInitConfigWC.jXD, paramAppBrandInitConfigWC.startTime, paramAppBrandInitConfigWC.jXK, paramAppBrandInitConfigWC.jCZ);
    AppMethodBeat.i(47135);
    AppMethodBeat.o(47135);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, ICommLibReader paramICommLibReader, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, QualitySession paramQualitySession, long paramLong, boolean paramBoolean3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(188593);
    this.lFK = -1L;
    this.lFO = false;
    this.lFR = new CopyOnWriteArrayList();
    this.lFS = new com.tencent.mm.sdk.b.c() {};
    this.lFT = new CopyOnWriteArrayList();
    this.lFU = new com.tencent.mm.sdk.b.c() {};
    this.lFV = new com.tencent.mm.sdk.b.c() {};
    this.lFX = null;
    this.lFZ = false;
    this.lGa = false;
    this.username = paramString1;
    this.appId = paramString2;
    this.hQh = paramInt1;
    this.dJQ = paramInt2;
    this.enterScene = paramInt3;
    this.jCN = paramString3;
    this.cmv = paramAppBrandLaunchReferrer;
    this.lFL = paramString4;
    this.jYp = paramICommLibReader;
    this.lEv = paramQualitySession.lEv;
    this.lFE = paramLong;
    this.lFF = paramBoolean3;
    this.jCZ = paramAppBrandLaunchFromNotifyReferrer;
    Assert.assertNotNull("<init> NULL wxaVersionInfo ".concat(String.valueOf(paramString2)), paramWxaVersionInfo);
    this.lFN = paramWxaVersionInfo;
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> username[%s] appId[%s] versionType[%d] appVersion[%d], scene[%d] sessionId[%s] instanceId[%s] mIsLaunchedByBackupWxaAttrs[%b]", new Object[] { this.username, this.appId, Integer.valueOf(this.hQh), Integer.valueOf(paramWxaVersionInfo.aDD), Integer.valueOf(this.enterScene), this.lFL, this.lEv, Boolean.valueOf(this.lFF) });
    if (paramICommLibReader == null) {
      ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL acceptedLibReader, instanceId[%s]", new Object[] { this.lEv });
    }
    this.ciC = paramBoolean1;
    this.lFM = paramBoolean2;
    this.jXD = paramQualitySession;
    this.lFP = new AppStartupPerformanceReportBundle(paramQualitySession.lEv);
    lFG.put(paramQualitySession.lEv, paramQualitySession);
    if (paramBoolean1) {
      w.Lo(paramString2);
    }
    AppMethodBeat.o(188593);
  }
  
  static k RI(String paramString)
  {
    AppMethodBeat.i(47132);
    for (;;)
    {
      synchronized (lFC)
      {
        k localk = (k)lFC.remove(paramString);
        ??? = Log.getStackTraceString(new Throwable());
        if (localk != null)
        {
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s), stacktrace=%s", new Object[] { localk.appId, Integer.valueOf(localk.hQh), paramString, ??? });
          AppMethodBeat.o(47132);
          return localk;
        }
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess sessionId(%s) get NULL, stacktrace=%s", new Object[] { paramString, ??? });
    }
  }
  
  static k RJ(String paramString)
  {
    AppMethodBeat.i(47133);
    synchronized (lFC)
    {
      paramString = (k)lFC.get(paramString);
      AppMethodBeat.o(47133);
      return paramString;
    }
  }
  
  static QualitySession RK(String paramString)
  {
    AppMethodBeat.i(47134);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(47134);
      return null;
    }
    paramString = (QualitySession)lFG.get(paramString);
    AppMethodBeat.o(47134);
    return paramString;
  }
  
  private boolean a(AppBrandSysConfigWC paramAppBrandSysConfigWC, com.tencent.mm.plugin.appbrand.z.i<AppBrandLaunchErrorAction> parami)
  {
    AppMethodBeat.i(188595);
    this.lFS.alive();
    Object localObject4;
    Object localObject5;
    boolean bool;
    label113:
    Object localObject2;
    if (this.hQh == 0)
    {
      this.lFU.alive();
      paramAppBrandSysConfigWC.jYp = this.jYp;
      localObject4 = new bi(paramAppBrandSysConfigWC.appId, this.hQh, this.jCN, this.enterScene, this.lFN, this.ciC, this.jYp, this.jXD)
      {
        public final void bqN()
        {
          AppMethodBeat.i(47124);
          super.bqN();
          k.g(k.this);
          AppMethodBeat.o(47124);
        }
        
        public final void bqW()
        {
          AppMethodBeat.i(47125);
          super.bqW();
          k.h(k.this);
          AppMethodBeat.o(47125);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47126);
          super.onDownloadProgress(paramAnonymousInt);
          if (k.this.lFH != null) {
            k.this.lFH.onDownloadProgress(paramAnonymousInt);
          }
          AppMethodBeat.o(47126);
        }
      };
      localObject5 = ((bi)localObject4).brC();
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qsp, true);
      if (!bool) {
        break label321;
      }
      i = 1;
      ad.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
      if (!bool) {
        break label326;
      }
      localObject2 = new bg(this.appId, this.hQh, this.ciC, this.lFN, this.enterScene, this.lFL, this.jXD)
      {
        final void aXp()
        {
          AppMethodBeat.i(188590);
          k.i(k.this);
          AppMethodBeat.o(188590);
        }
      };
    }
    Object localObject3;
    for (Object localObject1 = ((bg)localObject2).brC();; localObject1 = null)
    {
      localObject6 = new bj(this.appId, this.hQh, this.dJQ, this.enterScene, this.jCN, this.cmv, this.lFL, this.jYp, this.jXD, this.username, this.jCZ)
      {
        final void aXo()
        {
          AppMethodBeat.i(188591);
          k.j(k.this);
          AppMethodBeat.o(188591);
        }
      };
      localObject3 = (ax)((bj)localObject6).brD();
      this.lFP.lGh = ((bj)localObject6).lKV;
      this.lFP.lGi = ((bj)localObject6).lKW;
      if (localObject3 != null) {
        break label335;
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", new Object[] { this.username, this.appId });
      AppMethodBeat.o(188595);
      return false;
      this.lFV.alive();
      break;
      label321:
      i = 0;
      break label113;
      label326:
      localObject2 = null;
    }
    label335:
    Object localObject6 = AppBrandLaunchErrorAction.CREATOR;
    localObject6 = AppBrandLaunchErrorAction.a.a(this.appId, this.hQh, (ax)localObject3);
    if (localObject6 != null)
    {
      parami.value = localObject6;
      uc(54);
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", new Object[] { this.username, this.appId, Integer.valueOf(((ax)localObject3).field_launchAction.FqN) });
      AppMethodBeat.o(188595);
      return false;
    }
    this.lFP.lGo = ((ax)localObject3).lKu;
    if ((((ax)localObject3).field_jsapiInfo == null) || (((ax)localObject3).field_jsapiInfo.FWI == null))
    {
      uc(54);
      ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", new Object[] { this.username, this.appId });
      AppMethodBeat.o(188595);
      return false;
    }
    ((ax)localObject3).a(paramAppBrandSysConfigWC);
    parami = com.tencent.luggage.sdk.e.c.cpG;
    parami = com.tencent.luggage.sdk.e.c.jdMethod_do(this.lEv).cpC.values().iterator();
    int i = 0;
    if (parami.hasNext())
    {
      if (!((com.tencent.luggage.sdk.e.a)parami.next()).cpy) {
        break label2608;
      }
      i = 1;
    }
    label1280:
    label2608:
    for (;;)
    {
      break;
      parami = this.lFP;
      long l1;
      label631:
      String str;
      int j;
      long l2;
      if (i != 0)
      {
        i = 1;
        parami.lGn = i;
        if ((!j.a.rQ(this.hQh)) || (this.lFF)) {
          break label966;
        }
        parami = av.RS(this.appId);
        if (!(parami instanceof av.c.a)) {
          break label956;
        }
        l1 = ((av.c.a)parami).lKr - (bt.flT() - this.lFE);
        if (l1 > 0L) {
          break label951;
        }
        l1 = 9223372036854775807L;
        i = 0;
        localObject6 = this.username;
        str = this.appId;
        j = this.hQh;
        bool = this.lFF;
        l2 = this.lFE;
        if (i == 0) {
          break label978;
        }
      }
      label951:
      label956:
      label966:
      label978:
      for (localObject3 = l1 + "ms";; localObject3 = "false")
      {
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig() before get app pkg, username[%s] appId[%s] versionType[%d] mIsLaunchedByBackupWxaAttrs[%b] clickTimestamp[%d] timeoutStrategy=[%s], fallbackStrategy[%s]", new Object[] { localObject6, str, Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(l2), localObject3, parami });
        try
        {
          ((Future)localObject5).get(l1, TimeUnit.MILLISECONDS);
          parami = (WxaPkgWrappingInfo)((Pair)((Future)localObject5).get()).first;
          localObject3 = (List)((Pair)((Future)localObject5).get()).second;
          this.lFI = true;
          bqS();
          this.lFS.dead();
          this.lFU.dead();
          this.lFV.dead();
          this.lFP.lGe.addAll(this.lFT);
          this.lFP.lGf.addAll(this.lFR);
          this.lFP.lGj = ((bi)localObject4).lKV;
          this.lFP.lGk = ((bi)localObject4).lKW;
          if (parami != null) {
            break label1280;
          }
          if (j.a.rQ(this.hQh)) {
            av.dM(this.username, this.appId);
          }
          uc(55);
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", new Object[] { this.username, this.appId });
          AppMethodBeat.o(188595);
          return false;
        }
        catch (TimeoutException paramAppBrandSysConfigWC)
        {
          if (i == 0) {
            break label1272;
          }
          ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, get app pkg timeout, try fallback backup wxaattrs, username[%s] appId[%s] awaitTimeout[%d]", new Object[] { this.username, this.appId, Long.valueOf(l1) });
          this.lGa = true;
          paramAppBrandSysConfigWC = this.lFH;
          localObject1 = this.username;
          localObject2 = this.appId;
          if (paramAppBrandSysConfigWC != null) {
            break label1246;
          }
          bool = true;
          for (;;)
          {
            ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyFallbackBackupWxaAttrs username[%s] appId[%s] null==callback[%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            if (paramAppBrandSysConfigWC != null) {
              paramAppBrandSysConfigWC.bqO();
            }
            try
            {
              paramAppBrandSysConfigWC = new gv();
              paramAppBrandSysConfigWC.pH(this.appId);
              paramAppBrandSysConfigWC.pI(this.username);
              paramAppBrandSysConfigWC.equ = this.enterScene;
              paramAppBrandSysConfigWC.eqv = this.lFN.aDD;
              paramAppBrandSysConfigWC.eqw = ((s)j.T(s.class)).e(this.appId, new String[] { "versionInfo" }).ben().aDD;
              paramAppBrandSysConfigWC.eqB = 1L;
              paramAppBrandSysConfigWC.eqC = ((av.c.a)parami).lKr;
              paramAppBrandSysConfigWC.pJ(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext()));
              paramAppBrandSysConfigWC.eqA = 0L;
              paramAppBrandSysConfigWC.pK(this.jXD.lEv);
              paramAppBrandSysConfigWC.aLk();
              av.b.a(this.jXD.lEv, paramAppBrandSysConfigWC);
              AppMethodBeat.o(188595);
              return false;
              bool = false;
            }
            catch (Throwable paramAppBrandSysConfigWC)
            {
              for (;;)
              {
                ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, report fallback get exception %s", new Object[] { paramAppBrandSysConfigWC });
              }
            }
          }
          AppMethodBeat.o(188595);
          throw paramAppBrandSysConfigWC;
        }
        i = 0;
        break;
        i = 1;
        break label631;
        l1 = 9223372036854775807L;
        i = 0;
        break label631;
        parami = null;
        i = 0;
        l1 = 9223372036854775807L;
        break label631;
      }
      label1246:
      label1272:
      paramAppBrandSysConfigWC.jYh = parami;
      paramAppBrandSysConfigWC.cni = ((List)localObject3);
      if (paramAppBrandSysConfigWC.jYh.jIU != 0) {
        paramAppBrandSysConfigWC.jYh.pkgVersion = 0;
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", new Object[] { this.username, paramAppBrandSysConfigWC.appId, paramAppBrandSysConfigWC.jYh });
      if (com.tencent.mm.plugin.appbrand.ui.recommend.e.ce(this.appId, this.hQh))
      {
        if (this.lFK <= 0L)
        {
          i = 1;
          parami = com.tencent.mm.plugin.report.service.g.yhR;
          if (i == 0) {
            break label1720;
          }
          i = 53;
          label1378:
          parami.dD(1089, i);
        }
      }
      else
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.lFP.lGl = ((bg)localObject2).lKV;
          this.lFP.lGm = ((bg)localObject2).lKW;
          if (((Future)localObject1).get() != null)
          {
            parami = (HashMap)((Pair)((Future)localObject1).get()).first;
            if (parami == null) {
              break label1726;
            }
            i = parami.size();
            label1456:
            ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkWxaJsApiInfoHashMap size:%d", new Object[] { Integer.valueOf(i) });
            paramAppBrandSysConfigWC.cmJ = parami;
            this.lFP.lGp = ((Boolean)((Pair)((Future)localObject1).get()).second).booleanValue();
          }
        }
        paramAppBrandSysConfigWC.cnf = AppBrandGlobalSystemConfig.bdT();
        parami = com.tencent.mm.plugin.appbrand.message.h.lUu;
        parami = com.tencent.mm.plugin.appbrand.message.h.ec(this.appId, "copypath");
        if (parami != null) {
          break label1731;
        }
        l1 = 0L;
        label1535:
        paramAppBrandSysConfigWC.cne = l1;
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + paramAppBrandSysConfigWC.cne);
        com.tencent.e.h.LTJ.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47129);
            Object localObject = v.ND(k.this.username);
            if ((localObject != null) && (localObject.length > 0))
            {
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                String str = localObject[i];
                com.tencent.mm.modelappbrand.a.b.aDV().Cs(str);
                i += 1;
              }
            }
            if (k.bqV())
            {
              localObject = new l(12);
              com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject, 0);
            }
            AppMethodBeat.o(47129);
          }
        }, "AppLaunchPrepareProcess#ExtraWorks");
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { this.username, this.appId });
        bqT();
        com.tencent.mm.vfs.p.fPs();
        parami = com.tencent.mm.plugin.appbrand.appstorage.b.b.jNN;
        parami = com.tencent.mm.plugin.appbrand.appstorage.b.b.a.MB(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").fOK()));
        if (parami != null) {
          break label1740;
        }
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: srcBaseDirPath ==null");
        label1659:
        parami = com.tencent.mm.plugin.appbrand.appstorage.e.jMk;
        paramAppBrandSysConfigWC.jYi = e.a.Mb(this.appId);
        paramAppBrandSysConfigWC.jYj = f.jMf.bbs();
        i = paramAppBrandSysConfigWC.jYi;
        if (i != 2) {
          break label2541;
        }
        com.tencent.mm.plugin.report.service.g.yhR.n(1016L, 7L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(188595);
        return true;
        i = 0;
        break;
        label1720:
        i = 52;
        break label1378;
        label1726:
        i = 0;
        break label1456;
        label1731:
        l1 = parami.longValue();
        break label1535;
        label1740:
        if (com.tencent.mm.sdcard_migrate.b.aPQ(parami))
        {
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: Migrated");
          break label1659;
        }
        com.tencent.mm.kernel.g.ajA();
        localObject1 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin());
        parami = new com.tencent.mm.plugin.appbrand.appstorage.b.b();
        d.g.b.p.h(localObject1, "uin");
        parami.uin = ((String)localObject1);
        localObject3 = parami.MA(this.appId);
        localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject3).cBy;
        localObject4 = new StringBuilder();
        localObject5 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject3).appId;
        if (localObject5 == null) {
          d.g.b.p.bcb("appId");
        }
        localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
        localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject3).uin;
        if (localObject3 == null) {
          d.g.b.p.bcb("uin");
        }
        if (((com.tencent.mm.sdk.platformtools.ax)localObject2).getBoolean((String)localObject3, false))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1323, 2);
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForCompatibility: appId = [%s] isTransferred", new Object[] { this.appId });
          break label1659;
        }
        localObject5 = ar.m(new String[] { localObject1, this.appId }) + "/";
        localObject2 = ar.m(new String[] { localObject1, this.appId, "opendata" }) + "/";
        localObject3 = ar.m(new String[] { localObject1, this.appId, "clientdata" }) + "/";
        localObject1 = com.tencent.mm.loader.j.b.arU();
        localObject4 = parami.MA(this.appId);
        d.g.b.p.h(localObject1, "path");
        parami = (com.tencent.mm.plugin.appbrand.z.i<AppBrandLaunchErrorAction>)localObject1;
        if (!d.n.n.nA((String)localObject1, "/")) {
          parami = (String)localObject1 + '/';
        }
        ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jNL = parami;
        d.g.b.p.h(localObject5, "nonFlattenedFSPath");
        d.g.b.p.h(localObject2, "nonFlattenedOpenFSPath");
        d.g.b.p.h(localObject3, "nonFlattenedClientFSPath");
        parami = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).irF;
        if (parami == null) {
          d.g.b.p.gfZ();
        }
        if (d.n.n.nA(parami, "/")) {}
        for (parami = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).irF;; parami = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).irF + "/")
        {
          localObject1 = new StringBuilder().append(parami).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.jNS.dir).append('/');
          localObject6 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).appId;
          if (localObject6 == null) {
            d.g.b.p.bcb("appId");
          }
          localObject1 = (String)localObject6 + '/';
          localObject6 = new StringBuilder();
          str = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jNL;
          if (str == null) {
            d.g.b.p.bcb("appBrandTargetFolder");
          }
          localObject6 = ((StringBuilder)localObject6).append(str).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.jNS.dir).append('/');
          str = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).appId;
          if (str == null) {
            d.g.b.p.bcb("appId");
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c((String)localObject1, str + '/');
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jNM.add(localObject1);
          localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c(parami + com.tencent.mm.plugin.appbrand.appstorage.b.d.jNT.dir + d.n.n.nF((String)localObject5, com.tencent.mm.plugin.appbrand.appstorage.b.d.jNT.dir), (String)localObject5);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jNM.add(localObject1);
          localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c(parami + com.tencent.mm.plugin.appbrand.appstorage.b.d.jNT.dir + d.n.n.nF((String)localObject2, com.tencent.mm.plugin.appbrand.appstorage.b.d.jNT.dir), (String)localObject2);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jNM.add(localObject1);
          parami = new com.tencent.mm.plugin.appbrand.appstorage.b.c(parami + com.tencent.mm.plugin.appbrand.appstorage.b.d.jNT.dir + d.n.n.nF((String)localObject3, com.tencent.mm.plugin.appbrand.appstorage.b.d.jNT.dir), (String)localObject3);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jNM.add(parami);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).commit();
          break;
        }
        label2541:
        if (i == 3) {
          com.tencent.mm.plugin.report.service.g.yhR.n(1016L, 8L, 1L);
        } else if (i == 1) {
          if (f.jMf.bbr()) {
            com.tencent.mm.plugin.report.service.g.yhR.n(1016L, 10L, 1L);
          } else {
            com.tencent.mm.plugin.report.service.g.yhR.n(1016L, 9L, 1L);
          }
        }
      }
    }
  }
  
  private void b(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47141);
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", new Object[] { this.appId, Integer.valueOf(this.hQh) });
    a(paramd);
    paramd = com.tencent.luggage.sdk.e.c.cpG;
    paramd = com.tencent.luggage.sdk.e.c.jdMethod_do(this.lEv);
    if ((paramd instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
      ((com.tencent.mm.plugin.appbrand.launching.d.c)paramd).d(this.jXD);
    }
    paramd = com.tencent.luggage.sdk.e.c.cpG;
    com.tencent.luggage.sdk.e.c.dp(this.lEv);
    lFG.remove(this.lEv);
    AppMethodBeat.o(47141);
  }
  
  private void bqT()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174932);
    Object localObject1 = this.appId;
    Object localObject2;
    if (this.lFH != null)
    {
      bool1 = true;
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForDB start with appId:%s callback!=null:%b ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      localObject1 = new Timer();
      ((Timer)localObject1).schedule(new TimerTask()
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(188592);
          String str = k.this.appId;
          if (k.this.lFH != null) {
            bool = true;
          }
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD with appId:%s, callback!=null:%b", new Object[] { str, Boolean.valueOf(bool) });
          if (k.this.lFH != null) {
            k.this.lFH.rC(3);
          }
          AppMethodBeat.o(188592);
        }
      }, 5000L);
      localObject2 = this.appId;
      if (this.lFH == null) {
        break label191;
      }
    }
    label191:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START with appId:%s, callback!=null:%b", new Object[] { localObject2, Boolean.valueOf(bool1) });
      if (this.lFH != null) {
        this.lFH.rC(1);
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.e(this.appId);
      int i = 0;
      while (i <= 0)
      {
        am localam = new am[] { localObject2 }[0];
        if (localam.op(com.tencent.mm.protocal.d.Fnj)) {
          localam.transfer(com.tencent.mm.protocal.d.Fnj);
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    ((Timer)localObject1).cancel();
    localObject1 = this.appId;
    bool1 = bool2;
    if (this.lFH != null) {
      bool1 = true;
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH with appId:%s, callback!=null:%b", new Object[] { localObject1, Boolean.valueOf(bool1) });
    if (this.lFH != null) {
      this.lFH.rC(2);
    }
    AppMethodBeat.o(174932);
  }
  
  private void uc(int paramInt)
  {
    AppMethodBeat.i(47136);
    if (this.lFO)
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!"wxb6d22f922f37b35a".equals(this.appId))
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!j.a.rQ(this.hQh))
    {
      AppMethodBeat.o(47136);
      return;
    }
    this.lFO = true;
    com.tencent.mm.plugin.report.service.g.yhR.dD(1089, paramInt);
    String str = this.appId;
    if (this.lFN == null) {}
    for (int i = 0;; i = this.lFN.aDD)
    {
      com.tencent.mm.plugin.appbrand.report.h.b(str, i, this.hQh, 1089, paramInt);
      AppMethodBeat.o(47136);
      return;
    }
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47138);
    this.lFJ = paramd;
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramd.get(0);
    Object localObject = (AppBrandLaunchErrorAction)paramd.get(1);
    if (this.lFW != null)
    {
      if (localAppBrandSysConfigWC != null)
      {
        this.lFW.a(localAppBrandSysConfigWC);
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cmI, this.username, this.appId });
      }
      localObject = AppBrandLaunchErrorAction.CREATOR;
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = AppBrandLaunchErrorAction.a.a(this.appId, this.hQh, this.lFW);
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, updated errorAction[%s] username[%s] appId[%s]", new Object[] { localAppBrandLaunchErrorAction, this.username, this.appId });
      localObject = localAppBrandLaunchErrorAction;
      if (localAppBrandLaunchErrorAction != null)
      {
        localAppBrandSysConfigWC = null;
        localObject = localAppBrandLaunchErrorAction;
      }
    }
    for (;;)
    {
      if ((this.lFY != null) && (localAppBrandSysConfigWC != null))
      {
        localAppBrandSysConfigWC.cmJ = this.lFY;
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate]] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cmI, this.username, this.appId });
      }
      if (this.lFH != null)
      {
        this.lFH.a(localAppBrandSysConfigWC, (AppBrandLaunchErrorAction)localObject, (AppStartupPerformanceReportBundle)paramd.get(2));
        RI(this.lFL);
      }
      AppMethodBeat.o(47138);
      return;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, ax paramax)
  {
    AppMethodBeat.i(47139);
    if (this.lFJ != null)
    {
      Object localObject = AppBrandLaunchErrorAction.CREATOR;
      localObject = AppBrandLaunchErrorAction.a.a(this.appId, this.hQh, paramax);
      if (localObject != null)
      {
        this.lFJ = com.tencent.mm.vending.j.a.i(null, localObject, this.lFP);
        AppMethodBeat.o(47139);
        return;
      }
      localObject = (AppBrandSysConfigWC)this.lFJ.get(0);
      if (localObject == null)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(47139);
        return;
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramax });
      paramax.a((AppBrandSysConfigWC)localObject);
      this.lFJ = com.tencent.mm.vending.j.a.i(localObject, null, this.lFP);
      AppMethodBeat.o(47139);
      return;
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] set mMaybeUpdatedLaunchPB appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramax });
    this.lFW = paramax;
    AppMethodBeat.o(47139);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(188594);
    if (this.lFJ != null)
    {
      AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)this.lFJ.get(0);
      if (localAppBrandSysConfigWC == null)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(188594);
        return;
      }
      if (paramHashMap == null) {}
      for (;;)
      {
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localAppBrandSysConfigWC.cmJ = paramHashMap;
        this.lFJ = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.lFP);
        AppMethodBeat.o(188594);
        return;
        i = paramHashMap.size();
      }
    }
    if (paramHashMap == null) {}
    for (i = j;; i = paramHashMap.size())
    {
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] set mMaybeUpdatedPluginPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      this.lFY = paramHashMap;
      AppMethodBeat.o(188594);
      return;
    }
  }
  
  public final void bqQ()
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
    this.lFQ = bt.flT();
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d]", new Object[] { this.appId, Integer.valueOf(this.hQh), Integer.valueOf(this.enterScene) });
    synchronized (lFC)
    {
      lFC.put(this.lFL, this);
      ??? = new a(this.lFL, this.lEv, this.jXD);
      long l = TimeUnit.SECONDS.toMillis(300L);
      ((com.tencent.mm.sdk.platformtools.av)???).az(l, l);
      if (this.lFN == null)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", new Object[] { this.username, this.appId });
        bf.uk(2131755507);
        b(lGb);
        AppMethodBeat.o(47140);
        return;
      }
    }
    new ap(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.hQh) })).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47123);
        try
        {
          k.a(k.this, k.this.bqR());
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
          AppMethodBeat.o(47123);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess, localException.getLocalizedMessage());
          bf.uk(2131755506);
          k.a(k.this, k.bqU());
          k.f(k.this);
          AppMethodBeat.o(47123);
        }
      }
    });
    AppMethodBeat.o(47140);
  }
  
  public final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> bqR()
  {
    int i = 0;
    AppMethodBeat.i(47142);
    AppBrandSysConfigWC localAppBrandSysConfigWC = v.NB(this.appId);
    if (localAppBrandSysConfigWC == null) {
      bf.RO(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755578, new Object[] { "" }));
    }
    if (localAppBrandSysConfigWC == null)
    {
      ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!, username:%s, appId:%s", new Object[] { this.username, this.appId });
      if (this.lFN == null) {}
      for (i = 0;; i = this.lFN.aDD)
      {
        m.a(7, this.appId, i, this.hQh, this.ciC);
        localObject = lGb;
        AppMethodBeat.o(47142);
        return localObject;
      }
    }
    ((com.tencent.mm.plugin.appbrand.appusage.k)j.T(com.tencent.mm.plugin.appbrand.appusage.k.class)).P(v.NG(this.appId), bt.aQJ());
    Object localObject = new com.tencent.mm.plugin.appbrand.z.i();
    if (!a(localAppBrandSysConfigWC, (com.tencent.mm.plugin.appbrand.z.i)localObject))
    {
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { this.username, this.appId });
      if (this.lFN == null) {}
      for (;;)
      {
        m.a(8, this.appId, i, this.hQh, this.ciC);
        localObject = com.tencent.mm.vending.j.a.i(null, ((com.tencent.mm.plugin.appbrand.z.i)localObject).value, this.lFP);
        AppMethodBeat.o(47142);
        return localObject;
        i = this.lFN.aDD;
      }
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { this.username, this.appId });
    if (j.a.rQ(this.hQh)) {}
    try
    {
      localObject = av.RR(this.username);
      if ((localObject != null) && (((WxaAttributes)localObject).ben().aDD == this.lFN.aDD)) {
        break label506;
      }
      localObject = ((u)j.T(u.class)).d(this.username, new String[0]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs failed with username(%s) appId(%s) by exception:%s", new Object[] { this.username, this.appId, localException });
      }
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs with username(%s) appId(%s), now.versionInfo.appVersion:%d, record.versionInfo.appVersion:%d", new Object[] { this.username, this.appId, Integer.valueOf(this.lFN.aDD), Integer.valueOf(((WxaAttributes)localObject).ben().aDD) });
    if (((WxaAttributes)localObject).ben().aDD == this.lFN.aDD) {
      ((s)j.T(s.class)).d((WxaAttributes)localObject);
    }
    av.dL(this.username, this.appId);
    av.dN(this.username, this.appId);
    this.lFP.lFQ = this.lFQ;
    this.lFP.lGg = bt.flT();
    localObject = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.lFP);
    AppMethodBeat.o(47142);
    return localObject;
  }
  
  final void bqS()
  {
    AppMethodBeat.i(47143);
    if (this.lFH != null) {
      this.lFH.onDownloadProgress(100);
    }
    AppMethodBeat.o(47143);
  }
  
  static final class a
    extends com.tencent.mm.sdk.platformtools.av
  {
    public a(final String paramString1, String paramString2, final QualitySession paramQualitySession)
    {
      super(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47130);
          Object localObject = com.tencent.luggage.sdk.e.c.cpG;
          localObject = com.tencent.luggage.sdk.e.c.jdMethod_do(k.a.this);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
            ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).d(paramQualitySession);
          }
          localObject = com.tencent.luggage.sdk.e.c.cpG;
          com.tencent.luggage.sdk.e.c.dp(k.a.this);
          k.aQu().remove(k.a.this);
          localObject = k.RI(paramString1);
          String str;
          if (localObject != null)
          {
            str = ((k)localObject).appId;
            if (k.a((k)localObject) != null) {
              break label105;
            }
          }
          label105:
          for (int i = 0;; i = k.a((k)localObject).aDD)
          {
            m.a(23, str, i, ((k)localObject).hQh, k.b((k)localObject));
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
    extends q
  {
    public abstract void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void aXo();
    
    public abstract void aXp();
    
    public abstract void bqN();
    
    public abstract void bqO();
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.k
 * JD-Core Version:    0.7.0.1
 */