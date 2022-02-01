package com.tencent.mm.plugin.appbrand.launching;

import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.l;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.b.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public final class k
  implements ILaunchWxaAppInfoNotify
{
  private static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> kHB;
  private static final android.support.v4.e.a<String, k> kHf;
  private static final ax kHg;
  private static final ConcurrentHashMap<String, QualitySession> kHh;
  final String appId;
  private final boolean cbn;
  final AppBrandLaunchReferrer cfi;
  final int dzS;
  final int enterScene;
  final int gXn;
  final String iJb;
  private AppBrandLaunchFromNotifyReferrer iJn;
  final ICommLibReader jdZ;
  private final QualitySession jdu;
  private final String kGa;
  volatile boolean kHA;
  volatile b kHi;
  volatile boolean kHj;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> kHk;
  volatile long kHl;
  final String kHm;
  final boolean kHn;
  private final WxaAttributes.WxaVersionInfo kHo;
  private boolean kHp;
  private final AppStartupPerformanceReportBundle kHq;
  private volatile long kHr;
  private final List<kv_14609> kHs;
  private final com.tencent.mm.sdk.b.c<jy> kHt;
  private final List<fz> kHu;
  private final com.tencent.mm.sdk.b.c<yj> kHv;
  private final com.tencent.mm.sdk.b.c<yk> kHw;
  private volatile au kHx;
  volatile Boolean kHy;
  private volatile HashMap<String, AppRuntimeApiPermissionBundle> kHz;
  volatile boolean started;
  final String username;
  
  static
  {
    AppMethodBeat.i(47151);
    kHf = new android.support.v4.e.a();
    kHg = ax.aFC("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]");
    kHh = new ConcurrentHashMap();
    kHB = com.tencent.mm.vending.j.a.i(null, null, null);
    AppMethodBeat.o(47151);
  }
  
  k(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(str1, str2, i, j, k, paramAppBrandStatObject, localAppBrandLaunchReferrer, str3, com.tencent.mm.plugin.appbrand.appcache.ar.aPR(), paramAppBrandInitConfigWC.cfl, paramAppBrandInitConfigWC.CZ(), paramAppBrandInitConfigWC.cfe, paramAppBrandInitConfigWC.jdu, paramAppBrandInitConfigWC.iJn);
    AppMethodBeat.i(47135);
    AppMethodBeat.o(47135);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, ICommLibReader paramICommLibReader, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, QualitySession paramQualitySession, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(195993);
    this.kHl = -1L;
    this.kHp = false;
    this.kHs = new CopyOnWriteArrayList();
    this.kHt = new com.tencent.mm.sdk.b.c() {};
    this.kHu = new CopyOnWriteArrayList();
    this.kHv = new com.tencent.mm.sdk.b.c() {};
    this.kHw = new com.tencent.mm.sdk.b.c() {};
    this.kHy = null;
    this.kHA = false;
    this.username = paramString1;
    this.appId = paramString2;
    this.gXn = paramInt1;
    this.dzS = paramInt2;
    this.enterScene = paramInt3;
    this.iJb = paramString3;
    this.cfi = paramAppBrandLaunchReferrer;
    this.kHm = paramString4;
    this.jdZ = paramICommLibReader;
    this.kGa = paramQualitySession.kGa;
    this.iJn = paramAppBrandLaunchFromNotifyReferrer;
    Assert.assertNotNull("<init> NULL wxaVersionInfo ".concat(String.valueOf(paramString2)), paramWxaVersionInfo);
    this.kHo = paramWxaVersionInfo;
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> username[%s] appId[%s] versionType[%d] appVersion[%d], scene[%d] sessionId[%s] instanceId[%s]", new Object[] { this.username, this.appId, Integer.valueOf(this.gXn), Integer.valueOf(paramWxaVersionInfo.aAS), Integer.valueOf(this.enterScene), this.kHm, this.kGa });
    if (paramICommLibReader == null) {
      ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL acceptedLibReader");
    }
    this.cbn = paramBoolean1;
    this.kHn = paramBoolean2;
    this.jdu = paramQualitySession;
    this.kHq = new AppStartupPerformanceReportBundle(paramQualitySession.kGa);
    kHh.put(paramQualitySession.kGa, paramQualitySession);
    if (paramBoolean1) {
      v.DT(paramString2);
    }
    AppMethodBeat.o(195993);
  }
  
  static k Kd(String paramString)
  {
    AppMethodBeat.i(47132);
    for (;;)
    {
      synchronized (kHf)
      {
        k localk = (k)kHf.remove(paramString);
        ??? = Log.getStackTraceString(new Throwable());
        if (localk != null)
        {
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s), stacktrace=%s", new Object[] { localk.appId, Integer.valueOf(localk.gXn), paramString, ??? });
          AppMethodBeat.o(47132);
          return localk;
        }
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess sessionId(%s) get NULL, stacktrace=%s", new Object[] { paramString, ??? });
    }
  }
  
  static k Ke(String paramString)
  {
    AppMethodBeat.i(47133);
    synchronized (kHf)
    {
      paramString = (k)kHf.get(paramString);
      AppMethodBeat.o(47133);
      return paramString;
    }
  }
  
  static QualitySession Kf(String paramString)
  {
    AppMethodBeat.i(47134);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(47134);
      return null;
    }
    paramString = (QualitySession)kHh.get(paramString);
    AppMethodBeat.o(47134);
    return paramString;
  }
  
  private void b(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47141);
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", new Object[] { this.appId, Integer.valueOf(this.gXn) });
    a(paramd);
    Object localObject = com.tencent.luggage.sdk.e.c.ciu;
    localObject = com.tencent.luggage.sdk.e.c.cx(this.kGa);
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
      ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).d(this.jdu);
    }
    localObject = com.tencent.luggage.sdk.e.c.ciu;
    com.tencent.luggage.sdk.e.c.cy(this.kGa);
    kHh.remove(this.kGa);
    paramd = (com.tencent.mm.plugin.appbrand.config.k)paramd.get(0);
    localObject = this.appId;
    int i = this.gXn;
    int j = this.enterScene;
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      LaunchBroadCast.a((String)localObject, i, j, bool);
      AppMethodBeat.o(47141);
      return;
    }
  }
  
  private void bgn()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174932);
    Object localObject1 = this.appId;
    Object localObject2;
    if (this.kHi != null)
    {
      bool1 = true;
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForDB start with appId:%s callback!=null:%b ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      localObject1 = new Timer();
      ((Timer)localObject1).schedule(new TimerTask()
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(195992);
          String str = k.this.appId;
          if (k.this.kHi != null) {
            bool = true;
          }
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD with appId:%s, callback!=null:%b", new Object[] { str, Boolean.valueOf(bool) });
          if (k.this.kHi != null) {
            k.this.kHi.qp(3);
          }
          AppMethodBeat.o(195992);
        }
      }, 5000L);
      localObject2 = this.appId;
      if (this.kHi == null) {
        break label191;
      }
    }
    label191:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START with appId:%s, callback!=null:%b", new Object[] { localObject2, Boolean.valueOf(bool1) });
      if (this.kHi != null) {
        this.kHi.qp(1);
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.e(this.appId);
      int i = 0;
      while (i <= 0)
      {
        al localal = new al[] { localObject2 }[0];
        if (localal.nb(com.tencent.mm.protocal.d.CpK)) {
          localal.transfer(com.tencent.mm.protocal.d.CpK);
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    ((Timer)localObject1).cancel();
    localObject1 = this.appId;
    bool1 = bool2;
    if (this.kHi != null) {
      bool1 = true;
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH with appId:%s, callback!=null:%b", new Object[] { localObject1, Boolean.valueOf(bool1) });
    if (this.kHi != null) {
      this.kHi.qp(2);
    }
    AppMethodBeat.o(174932);
  }
  
  private void sH(int paramInt)
  {
    AppMethodBeat.i(47136);
    if (this.kHp)
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!"wxb6d22f922f37b35a".equals(this.appId))
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!j.a.qD(this.gXn))
    {
      AppMethodBeat.o(47136);
      return;
    }
    this.kHp = true;
    com.tencent.mm.plugin.report.service.h.vKh.dB(1089, paramInt);
    String str = this.appId;
    if (this.kHo == null) {}
    for (int i = 0;; i = this.kHo.aAS)
    {
      com.tencent.mm.plugin.appbrand.report.h.b(str, i, this.gXn, 1089, paramInt);
      AppMethodBeat.o(47136);
      return;
    }
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47138);
    this.kHk = paramd;
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramd.get(0);
    Object localObject = (AppBrandLaunchErrorAction)paramd.get(1);
    if (this.kHx != null)
    {
      if (localAppBrandSysConfigWC != null)
      {
        this.kHx.a(localAppBrandSysConfigWC);
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cfu, this.username, this.appId });
      }
      localObject = AppBrandLaunchErrorAction.CREATOR;
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = AppBrandLaunchErrorAction.a.a(this.appId, this.gXn, this.kHx);
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
      if ((this.kHz != null) && (localAppBrandSysConfigWC != null))
      {
        localAppBrandSysConfigWC.cfv = this.kHz;
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate]] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cfu, this.username, this.appId });
      }
      if (this.kHi != null)
      {
        this.kHi.a(localAppBrandSysConfigWC, (AppBrandLaunchErrorAction)localObject, (AppStartupPerformanceReportBundle)paramd.get(2));
        Kd(this.kHm);
      }
      AppMethodBeat.o(47138);
      return;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, au paramau)
  {
    AppMethodBeat.i(47139);
    if (this.kHk != null)
    {
      Object localObject = AppBrandLaunchErrorAction.CREATOR;
      localObject = AppBrandLaunchErrorAction.a.a(this.appId, this.gXn, paramau);
      if (localObject != null)
      {
        this.kHk = com.tencent.mm.vending.j.a.i(null, localObject, this.kHq);
        AppMethodBeat.o(47139);
        return;
      }
      localObject = (AppBrandSysConfigWC)this.kHk.get(0);
      if (localObject == null)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(47139);
        return;
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramau });
      paramau.a((AppBrandSysConfigWC)localObject);
      this.kHk = com.tencent.mm.vending.j.a.i(localObject, null, this.kHq);
      AppMethodBeat.o(47139);
      return;
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] set mMaybeUpdatedLaunchPB appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramau });
    this.kHx = paramau;
    AppMethodBeat.o(47139);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(195994);
    if (this.kHk != null)
    {
      AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)this.kHk.get(0);
      if (localAppBrandSysConfigWC == null)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(195994);
        return;
      }
      if (paramHashMap == null) {}
      for (;;)
      {
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localAppBrandSysConfigWC.cfv = paramHashMap;
        this.kHk = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.kHq);
        AppMethodBeat.o(195994);
        return;
        i = paramHashMap.size();
      }
    }
    if (paramHashMap == null) {}
    for (i = j;; i = paramHashMap.size())
    {
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] set mMaybeUpdatedPluginPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      this.kHz = paramHashMap;
      AppMethodBeat.o(195994);
      return;
    }
  }
  
  public final void bgk()
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
    this.kHr = bt.eGO();
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d]", new Object[] { this.appId, Integer.valueOf(this.gXn), Integer.valueOf(this.enterScene) });
    synchronized (kHf)
    {
      kHf.put(this.kHm, this);
      ??? = new a(this.kHm, this.kGa, this.jdu);
      long l = TimeUnit.SECONDS.toMillis(300L);
      ((av)???).av(l, l);
      if (this.kHo == null)
      {
        ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", new Object[] { this.username, this.appId });
        bc.sP(2131755507);
        b(kHB);
        AppMethodBeat.o(47140);
        return;
      }
    }
    new ap(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.gXn) })).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47123);
        try
        {
          k.a(k.this, k.this.bgl());
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
          AppMethodBeat.o(47123);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess, localException.getLocalizedMessage());
          bc.sP(2131755506);
          k.a(k.this, k.bgo());
          k.f(k.this);
          AppMethodBeat.o(47123);
        }
      }
    });
    AppMethodBeat.o(47140);
  }
  
  public final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> bgl()
  {
    AppMethodBeat.i(47142);
    AppBrandSysConfigWC localAppBrandSysConfigWC = u.Ge(this.appId);
    if (localAppBrandSysConfigWC == null) {
      bc.Kj(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755578, new Object[] { "" }));
    }
    if (localAppBrandSysConfigWC == null)
    {
      ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!");
      localObject1 = kHB;
      AppMethodBeat.o(47142);
      return localObject1;
    }
    ((com.tencent.mm.plugin.appbrand.appusage.k)j.T(com.tencent.mm.plugin.appbrand.appusage.k.class)).H(u.Gj(this.appId), bt.aGK());
    com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
    this.kHt.alive();
    Object localObject3;
    Object localObject4;
    int i;
    label205:
    Object localObject2;
    label274:
    Object localObject6;
    Object localObject5;
    if (this.gXn == 0)
    {
      this.kHv.alive();
      localAppBrandSysConfigWC.jdZ = this.jdZ;
      localObject3 = new bf(localAppBrandSysConfigWC.appId, this.gXn, this.iJb, this.enterScene, this.kHo, this.cbn, this.jdZ, this.jdu)
      {
        public final void bgi()
        {
          AppMethodBeat.i(47124);
          super.bgi();
          k.g(k.this);
          AppMethodBeat.o(47124);
        }
        
        public final void bgq()
        {
          AppMethodBeat.i(47125);
          super.bgq();
          k.h(k.this);
          AppMethodBeat.o(47125);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47126);
          super.onDownloadProgress(paramAnonymousInt);
          if (k.this.kHi != null) {
            k.this.kHi.onDownloadProgress(paramAnonymousInt);
          }
          AppMethodBeat.o(47126);
        }
      };
      localObject4 = ((bf)localObject3).bgQ();
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pkZ, true);
      if (!bool) {
        break label460;
      }
      i = 1;
      ad.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
      if (!bool) {
        break label465;
      }
      localObject2 = new bd(this.appId, this.gXn, this.cbn, this.kHo, this.enterScene, this.kHm, this.jdu)
      {
        final void aNr()
        {
          AppMethodBeat.i(195990);
          k.i(k.this);
          AppMethodBeat.o(195990);
        }
      };
      localObject1 = ((bd)localObject2).bgQ();
      localObject6 = new bg(this.appId, this.gXn, this.dzS, this.enterScene, this.iJb, this.cfi, this.kHm, this.jdZ, this.jdu, this.username, this.iJn)
      {
        final void aNq()
        {
          AppMethodBeat.i(195991);
          k.j(k.this);
          AppMethodBeat.o(195991);
        }
      };
      localObject5 = (au)((bg)localObject6).bgR();
      this.kHq.kHH = ((bg)localObject6).kMg;
      this.kHq.kHI = ((bg)localObject6).kMh;
      if (localObject5 != null) {
        break label474;
      }
      ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", new Object[] { this.username, this.appId });
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { this.username, this.appId });
        localObject1 = com.tencent.mm.vending.j.a.i(null, locali.value, this.kHq);
        AppMethodBeat.o(47142);
        return localObject1;
        this.kHw.alive();
        break;
        label460:
        i = 0;
        break label205;
        label465:
        localObject2 = null;
        localObject1 = null;
        break label274;
        label474:
        localObject6 = AppBrandLaunchErrorAction.CREATOR;
        localObject6 = AppBrandLaunchErrorAction.a.a(this.appId, this.gXn, (au)localObject5);
        if (localObject6 != null)
        {
          locali.value = localObject6;
          sH(54);
          ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", new Object[] { this.username, this.appId, Integer.valueOf(((au)localObject5).field_launchAction.Ctr) });
          i = 0;
        }
        else
        {
          this.kHq.kHN = ((au)localObject5).kLF;
          if ((((au)localObject5).field_jsapiInfo == null) || (((au)localObject5).field_jsapiInfo.CWN == null))
          {
            sH(54);
            ad.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", new Object[] { this.username, this.appId });
            i = 0;
          }
          else
          {
            ((au)localObject5).a(localAppBrandSysConfigWC);
            localObject5 = (WxaPkgWrappingInfo)((Pair)((Future)localObject4).get()).first;
            localObject4 = (List)((Pair)((Future)localObject4).get()).second;
            this.kHj = true;
            bgm();
            this.kHt.dead();
            this.kHv.dead();
            this.kHw.dead();
            this.kHq.kHE.addAll(this.kHu);
            this.kHq.kHF.addAll(this.kHs);
            this.kHq.kHJ = ((bf)localObject3).kMg;
            this.kHq.kHK = ((bf)localObject3).kMh;
            if (localObject5 == null)
            {
              sH(55);
              ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", new Object[] { this.username, this.appId });
              i = 0;
            }
            else
            {
              localAppBrandSysConfigWC.jdS = ((WxaPkgWrappingInfo)localObject5);
              localAppBrandSysConfigWC.cfV = ((List)localObject4);
              if (localAppBrandSysConfigWC.jdS.iOQ != 0) {
                localAppBrandSysConfigWC.jdS.pkgVersion = 0;
              }
              ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", new Object[] { this.username, localAppBrandSysConfigWC.appId, localAppBrandSysConfigWC.jdS });
              label892:
              long l;
              if (com.tencent.mm.plugin.appbrand.ui.recommend.e.bW(this.appId, this.gXn))
              {
                if (this.kHl <= 0L)
                {
                  i = 1;
                  localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
                  if (i == 0) {
                    break label1239;
                  }
                  i = 53;
                  label904:
                  ((com.tencent.mm.plugin.report.service.h)localObject3).dB(1089, i);
                }
              }
              else
              {
                if ((localObject2 != null) && (localObject1 != null))
                {
                  this.kHq.kHL = ((bd)localObject2).kMg;
                  this.kHq.kHM = ((bd)localObject2).kMh;
                  if (((Future)localObject1).get() != null)
                  {
                    localObject2 = (HashMap)((Pair)((Future)localObject1).get()).first;
                    if (localObject2 == null) {
                      break label1245;
                    }
                    i = ((HashMap)localObject2).size();
                    label986:
                    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkWxaJsApiInfoHashMap size:%d", new Object[] { Integer.valueOf(i) });
                    localAppBrandSysConfigWC.cfv = ((HashMap)localObject2);
                    this.kHq.kHO = ((Boolean)((Pair)((Future)localObject1).get()).second).booleanValue();
                  }
                }
                localAppBrandSysConfigWC.cfR = AppBrandGlobalSystemConfig.aTv();
                localObject1 = com.tencent.mm.plugin.appbrand.n.g.kTG;
                localObject1 = com.tencent.mm.plugin.appbrand.n.g.dH(this.appId, "copypath");
                if (localObject1 != null) {
                  break label1250;
                }
                l = 0L;
                label1070:
                localAppBrandSysConfigWC.cfQ = l;
                ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + localAppBrandSysConfigWC.cfQ);
                com.tencent.e.h.Iye.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(47129);
                    Object localObject = u.Gg(k.this.username);
                    if ((localObject != null) && (localObject.length > 0))
                    {
                      int j = localObject.length;
                      int i = 0;
                      while (i < j)
                      {
                        String str = localObject[i];
                        com.tencent.mm.modelappbrand.a.b.aub().vn(str);
                        i += 1;
                      }
                    }
                    if (k.bgp())
                    {
                      localObject = new l(12);
                      com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject, 0);
                    }
                    AppMethodBeat.o(47129);
                  }
                }, "AppLaunchPrepareProcess#ExtraWorks");
                ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { this.username, this.appId });
                bgn();
                if (com.tencent.mm.vfs.p.fil()) {
                  break label1259;
                }
                ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "isVFSSwitchOpen = false, appId = [%s]", new Object[] { this.appId });
                label1177:
                localObject1 = com.tencent.mm.plugin.appbrand.appstorage.e.KCi;
                localAppBrandSysConfigWC.jdT = e.a.aUA(this.appId);
                localAppBrandSysConfigWC.jdU = f.iSa.aQZ();
                i = localAppBrandSysConfigWC.jdT;
                if (i != 2) {
                  break label2065;
                }
                com.tencent.mm.plugin.report.service.h.vKh.m(1016L, 7L, 1L);
              }
              for (;;)
              {
                i = 1;
                break;
                i = 0;
                break label892;
                label1239:
                i = 52;
                break label904;
                label1245:
                i = 0;
                break label986;
                label1250:
                l = ((Long)localObject1).longValue();
                break label1070;
                label1259:
                localObject1 = com.tencent.mm.plugin.appbrand.appstorage.b.a.iTH;
                localObject1 = a.a.Fh(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").fhU()));
                if (localObject1 == null)
                {
                  ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: srcBaseDirPath ==null");
                  break label1177;
                }
                if (com.tencent.mm.sdcard_migrate.b.aEU((String)localObject1))
                {
                  ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: Migrated");
                  break label1177;
                }
                localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.a();
                localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject1).Fg(this.appId);
                localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject3).ctt;
                localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject3).appId;
                if (localObject3 == null) {
                  d.g.b.k.aPZ("appId");
                }
                if (((ax)localObject2).getBoolean((String)localObject3, false))
                {
                  com.tencent.mm.plugin.report.service.h.vKh.dB(1323, 2);
                  ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForCompatibility: appId = [%s] isTransferred", new Object[] { this.appId });
                  break label1177;
                }
                com.tencent.mm.kernel.g.afz();
                localObject2 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin());
                localObject6 = com.tencent.mm.plugin.appbrand.jsapi.file.ar.n(new String[] { localObject2, this.appId }) + "/";
                localObject3 = com.tencent.mm.plugin.appbrand.jsapi.file.ar.n(new String[] { localObject2, this.appId, "opendata" }) + "/";
                localObject4 = com.tencent.mm.plugin.appbrand.jsapi.file.ar.n(new String[] { localObject2, this.appId, "clientdata" }) + "/";
                localObject2 = com.tencent.mm.loader.j.b.aih();
                localObject5 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject1).Fg(this.appId);
                d.g.b.k.h(localObject2, "path");
                localObject1 = localObject2;
                if (!d.n.n.mB((String)localObject2, "/")) {
                  localObject1 = (String)localObject2 + '/';
                }
                ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).iTF = ((String)localObject1);
                d.g.b.k.h(localObject6, "nonFlattenedFSPath");
                d.g.b.k.h(localObject3, "nonFlattenedOpenFSPath");
                d.g.b.k.h(localObject4, "nonFlattenedClientFSPath");
                localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).hxI;
                if (localObject1 == null) {
                  d.g.b.k.fvU();
                }
                if (d.n.n.mB((String)localObject1, "/")) {}
                for (localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).hxI;; localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).hxI + "/")
                {
                  localObject2 = new StringBuilder().append((String)localObject1).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.iTM.iTP).append('/');
                  Object localObject7 = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).appId;
                  if (localObject7 == null) {
                    d.g.b.k.aPZ("appId");
                  }
                  localObject2 = (String)localObject7 + '/';
                  localObject7 = new StringBuilder();
                  String str = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).iTF;
                  if (str == null) {
                    d.g.b.k.aPZ("appBrandTargetFolder");
                  }
                  localObject7 = ((StringBuilder)localObject7).append(str).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.iTM.iTP).append('/');
                  str = ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).appId;
                  if (str == null) {
                    d.g.b.k.aPZ("appId");
                  }
                  localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.b.b((String)localObject2, str + '/');
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).iTG.add(localObject2);
                  localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.b.b((String)localObject1 + com.tencent.mm.plugin.appbrand.appstorage.b.d.iTN.iTP + d.n.n.mH((String)localObject6, com.tencent.mm.plugin.appbrand.appstorage.b.d.iTN.iTP), (String)localObject6);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).iTG.add(localObject2);
                  localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.b.b((String)localObject1 + com.tencent.mm.plugin.appbrand.appstorage.b.d.iTN.iTP + d.n.n.mH((String)localObject3, com.tencent.mm.plugin.appbrand.appstorage.b.d.iTN.iTP), (String)localObject3);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).iTG.add(localObject2);
                  localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.b((String)localObject1 + com.tencent.mm.plugin.appbrand.appstorage.b.d.iTN.iTP + d.n.n.mH((String)localObject4, com.tencent.mm.plugin.appbrand.appstorage.b.d.iTN.iTP), (String)localObject4);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).iTG.add(localObject1);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.a)localObject5).commit();
                  break;
                }
                label2065:
                if (i == 3) {
                  com.tencent.mm.plugin.report.service.h.vKh.m(1016L, 8L, 1L);
                } else if (i == 1) {
                  if (f.iSa.aQY()) {
                    com.tencent.mm.plugin.report.service.h.vKh.m(1016L, 10L, 1L);
                  } else {
                    com.tencent.mm.plugin.report.service.h.vKh.m(1016L, 9L, 1L);
                  }
                }
              }
            }
          }
        }
      }
    }
    ad.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { this.username, this.appId });
    this.kHq.kHr = this.kHr;
    this.kHq.kHG = bt.eGO();
    Object localObject1 = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.kHq);
    AppMethodBeat.o(47142);
    return localObject1;
  }
  
  final void bgm()
  {
    AppMethodBeat.i(47143);
    if (this.kHi != null) {
      this.kHi.onDownloadProgress(100);
    }
    AppMethodBeat.o(47143);
  }
  
  static final class a
    extends av
  {
    public a(final String paramString1, String paramString2, final QualitySession paramQualitySession)
    {
      super(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47130);
          Object localObject = com.tencent.luggage.sdk.e.c.ciu;
          localObject = com.tencent.luggage.sdk.e.c.cx(k.a.this);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
            ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).d(paramQualitySession);
          }
          localObject = com.tencent.luggage.sdk.e.c.ciu;
          com.tencent.luggage.sdk.e.c.cy(k.a.this);
          k.aGw().remove(k.a.this);
          localObject = k.Kd(paramString1);
          String str;
          if (localObject != null)
          {
            str = ((k)localObject).appId;
            if (k.a((k)localObject) != null) {
              break label105;
            }
          }
          label105:
          for (int i = 0;; i = k.a((k)localObject).aAS)
          {
            m.a(23, str, i, ((k)localObject).gXn, k.b((k)localObject));
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
    
    public abstract void aNq();
    
    public abstract void aNr();
    
    public abstract void bgi();
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.k
 * JD-Core Version:    0.7.0.1
 */