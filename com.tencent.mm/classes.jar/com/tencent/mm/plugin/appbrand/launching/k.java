package com.tencent.mm.plugin.appbrand.launching;

import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.l;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
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
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final aw liA;
  private static final ConcurrentHashMap<String, QualitySession> liB;
  private static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> liV;
  private static final android.support.v4.e.a<String, k> liz;
  final String appId;
  private final boolean bYk;
  final AppBrandLaunchReferrer cce;
  final int dxE;
  final int enterScene;
  final int hxM;
  private final QualitySession jDH;
  final ICommLibReader jEn;
  final String jjf;
  private AppBrandLaunchFromNotifyReferrer jjr;
  private final String lht;
  volatile b liC;
  volatile boolean liD;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> liE;
  volatile long liF;
  final String liG;
  final boolean liH;
  private final WxaAttributes.WxaVersionInfo liI;
  private boolean liJ;
  private final AppStartupPerformanceReportBundle liK;
  private volatile long liL;
  private final List<kv_14609> liM;
  private final com.tencent.mm.sdk.b.c<kg> liN;
  private final List<hr> liO;
  private final com.tencent.mm.sdk.b.c<yu> liP;
  private final com.tencent.mm.sdk.b.c<yv> liQ;
  private volatile au liR;
  volatile Boolean liS;
  private volatile HashMap<String, AppRuntimeApiPermissionBundle> liT;
  volatile boolean liU;
  volatile boolean started;
  final String username;
  
  static
  {
    AppMethodBeat.i(47151);
    liz = new android.support.v4.e.a();
    liA = aw.aKT("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]");
    liB = new ConcurrentHashMap();
    liV = com.tencent.mm.vending.j.a.i(null, null, null);
    AppMethodBeat.o(47151);
  }
  
  k(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(str1, str2, i, j, k, paramAppBrandStatObject, localAppBrandLaunchReferrer, str3, com.tencent.mm.plugin.appbrand.appcache.ar.aWJ(), paramAppBrandInitConfigWC.cch, paramAppBrandInitConfigWC.CC(), paramAppBrandInitConfigWC.ccb, paramAppBrandInitConfigWC.jDH, paramAppBrandInitConfigWC.jjr);
    AppMethodBeat.i(47135);
    AppMethodBeat.o(47135);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, ICommLibReader paramICommLibReader, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, QualitySession paramQualitySession, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(186816);
    this.liF = -1L;
    this.liJ = false;
    this.liM = new CopyOnWriteArrayList();
    this.liN = new com.tencent.mm.sdk.b.c() {};
    this.liO = new CopyOnWriteArrayList();
    this.liP = new com.tencent.mm.sdk.b.c() {};
    this.liQ = new com.tencent.mm.sdk.b.c() {};
    this.liS = null;
    this.liU = false;
    this.username = paramString1;
    this.appId = paramString2;
    this.hxM = paramInt1;
    this.dxE = paramInt2;
    this.enterScene = paramInt3;
    this.jjf = paramString3;
    this.cce = paramAppBrandLaunchReferrer;
    this.liG = paramString4;
    this.jEn = paramICommLibReader;
    this.lht = paramQualitySession.lht;
    this.jjr = paramAppBrandLaunchFromNotifyReferrer;
    Assert.assertNotNull("<init> NULL wxaVersionInfo ".concat(String.valueOf(paramString2)), paramWxaVersionInfo);
    this.liI = paramWxaVersionInfo;
    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> username[%s] appId[%s] versionType[%d] appVersion[%d], scene[%d] sessionId[%s] instanceId[%s]", new Object[] { this.username, this.appId, Integer.valueOf(this.hxM), Integer.valueOf(paramWxaVersionInfo.aBM), Integer.valueOf(this.enterScene), this.liG, this.lht });
    if (paramICommLibReader == null) {
      ac.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL acceptedLibReader");
    }
    this.bYk = paramBoolean1;
    this.liH = paramBoolean2;
    this.jDH = paramQualitySession;
    this.liK = new AppStartupPerformanceReportBundle(paramQualitySession.lht);
    liB.put(paramQualitySession.lht, paramQualitySession);
    if (paramBoolean1) {
      v.HW(paramString2);
    }
    AppMethodBeat.o(186816);
  }
  
  static k Ok(String paramString)
  {
    AppMethodBeat.i(47132);
    for (;;)
    {
      synchronized (liz)
      {
        k localk = (k)liz.remove(paramString);
        ??? = Log.getStackTraceString(new Throwable());
        if (localk != null)
        {
          ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s), stacktrace=%s", new Object[] { localk.appId, Integer.valueOf(localk.hxM), paramString, ??? });
          AppMethodBeat.o(47132);
          return localk;
        }
      }
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess sessionId(%s) get NULL, stacktrace=%s", new Object[] { paramString, ??? });
    }
  }
  
  static k Ol(String paramString)
  {
    AppMethodBeat.i(47133);
    synchronized (liz)
    {
      paramString = (k)liz.get(paramString);
      AppMethodBeat.o(47133);
      return paramString;
    }
  }
  
  static QualitySession Om(String paramString)
  {
    AppMethodBeat.i(47134);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(47134);
      return null;
    }
    paramString = (QualitySession)liB.get(paramString);
    AppMethodBeat.o(47134);
    return paramString;
  }
  
  private void b(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47141);
    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", new Object[] { this.appId, Integer.valueOf(this.hxM) });
    a(paramd);
    Object localObject = com.tencent.luggage.sdk.e.c.cfq;
    localObject = com.tencent.luggage.sdk.e.c.cm(this.lht);
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
      ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).d(this.jDH);
    }
    localObject = com.tencent.luggage.sdk.e.c.cfq;
    com.tencent.luggage.sdk.e.c.cn(this.lht);
    liB.remove(this.lht);
    paramd = (com.tencent.mm.plugin.appbrand.config.k)paramd.get(0);
    localObject = this.appId;
    int i = this.hxM;
    int j = this.enterScene;
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      LaunchBroadCast.a((String)localObject, i, j, bool);
      AppMethodBeat.o(47141);
      return;
    }
  }
  
  private void bnh()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174932);
    Object localObject1 = this.appId;
    Object localObject2;
    if (this.liC != null)
    {
      bool1 = true;
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForDB start with appId:%s callback!=null:%b ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      localObject1 = new Timer();
      ((Timer)localObject1).schedule(new TimerTask()
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(186815);
          String str = k.this.appId;
          if (k.this.liC != null) {
            bool = true;
          }
          ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD with appId:%s, callback!=null:%b", new Object[] { str, Boolean.valueOf(bool) });
          if (k.this.liC != null) {
            k.this.liC.rc(3);
          }
          AppMethodBeat.o(186815);
        }
      }, 5000L);
      localObject2 = this.appId;
      if (this.liC == null) {
        break label191;
      }
    }
    label191:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START with appId:%s, callback!=null:%b", new Object[] { localObject2, Boolean.valueOf(bool1) });
      if (this.liC != null) {
        this.liC.rc(1);
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.e(this.appId);
      int i = 0;
      while (i <= 0)
      {
        al localal = new al[] { localObject2 }[0];
        if (localal.nP(com.tencent.mm.protocal.d.DIc)) {
          localal.transfer(com.tencent.mm.protocal.d.DIc);
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    ((Timer)localObject1).cancel();
    localObject1 = this.appId;
    bool1 = bool2;
    if (this.liC != null) {
      bool1 = true;
    }
    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH with appId:%s, callback!=null:%b", new Object[] { localObject1, Boolean.valueOf(bool1) });
    if (this.liC != null) {
      this.liC.rc(2);
    }
    AppMethodBeat.o(174932);
  }
  
  private void ty(int paramInt)
  {
    AppMethodBeat.i(47136);
    if (this.liJ)
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!"wxb6d22f922f37b35a".equals(this.appId))
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!j.a.rq(this.hxM))
    {
      AppMethodBeat.o(47136);
      return;
    }
    this.liJ = true;
    com.tencent.mm.plugin.report.service.h.wUl.dB(1089, paramInt);
    String str = this.appId;
    if (this.liI == null) {}
    for (int i = 0;; i = this.liI.aBM)
    {
      com.tencent.mm.plugin.appbrand.report.g.b(str, i, this.hxM, 1089, paramInt);
      AppMethodBeat.o(47136);
      return;
    }
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47138);
    this.liE = paramd;
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramd.get(0);
    Object localObject = (AppBrandLaunchErrorAction)paramd.get(1);
    if (this.liR != null)
    {
      if (localAppBrandSysConfigWC != null)
      {
        this.liR.a(localAppBrandSysConfigWC);
        ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.ccr, this.username, this.appId });
      }
      localObject = AppBrandLaunchErrorAction.CREATOR;
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = AppBrandLaunchErrorAction.a.a(this.appId, this.hxM, this.liR);
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, updated errorAction[%s] username[%s] appId[%s]", new Object[] { localAppBrandLaunchErrorAction, this.username, this.appId });
      localObject = localAppBrandLaunchErrorAction;
      if (localAppBrandLaunchErrorAction != null)
      {
        localAppBrandSysConfigWC = null;
        localObject = localAppBrandLaunchErrorAction;
      }
    }
    for (;;)
    {
      if ((this.liT != null) && (localAppBrandSysConfigWC != null))
      {
        localAppBrandSysConfigWC.ccs = this.liT;
        ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate]] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.ccr, this.username, this.appId });
      }
      if (this.liC != null)
      {
        this.liC.a(localAppBrandSysConfigWC, (AppBrandLaunchErrorAction)localObject, (AppStartupPerformanceReportBundle)paramd.get(2));
        Ok(this.liG);
      }
      AppMethodBeat.o(47138);
      return;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, au paramau)
  {
    AppMethodBeat.i(47139);
    if (this.liE != null)
    {
      Object localObject = AppBrandLaunchErrorAction.CREATOR;
      localObject = AppBrandLaunchErrorAction.a.a(this.appId, this.hxM, paramau);
      if (localObject != null)
      {
        this.liE = com.tencent.mm.vending.j.a.i(null, localObject, this.liK);
        AppMethodBeat.o(47139);
        return;
      }
      localObject = (AppBrandSysConfigWC)this.liE.get(0);
      if (localObject == null)
      {
        ac.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(47139);
        return;
      }
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramau });
      paramau.a((AppBrandSysConfigWC)localObject);
      this.liE = com.tencent.mm.vending.j.a.i(localObject, null, this.liK);
      AppMethodBeat.o(47139);
      return;
    }
    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] set mMaybeUpdatedLaunchPB appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramau });
    this.liR = paramau;
    AppMethodBeat.o(47139);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(186817);
    if (this.liE != null)
    {
      AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)this.liE.get(0);
      if (localAppBrandSysConfigWC == null)
      {
        ac.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(186817);
        return;
      }
      if (paramHashMap == null) {}
      for (;;)
      {
        ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localAppBrandSysConfigWC.ccs = paramHashMap;
        this.liE = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.liK);
        AppMethodBeat.o(186817);
        return;
        i = paramHashMap.size();
      }
    }
    if (paramHashMap == null) {}
    for (i = j;; i = paramHashMap.size())
    {
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] set mMaybeUpdatedPluginPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      this.liT = paramHashMap;
      AppMethodBeat.o(186817);
      return;
    }
  }
  
  public final void bne()
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
    this.liL = bs.eWj();
    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d]", new Object[] { this.appId, Integer.valueOf(this.hxM), Integer.valueOf(this.enterScene) });
    synchronized (liz)
    {
      liz.put(this.liG, this);
      ??? = new a(this.liG, this.lht, this.jDH);
      long l = TimeUnit.SECONDS.toMillis(300L);
      ((com.tencent.mm.sdk.platformtools.au)???).au(l, l);
      if (this.liI == null)
      {
        ac.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", new Object[] { this.username, this.appId });
        bc.tG(2131755507);
        b(liV);
        AppMethodBeat.o(47140);
        return;
      }
    }
    new ao(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.hxM) })).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47123);
        try
        {
          k.a(k.this, k.this.bnf());
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
          AppMethodBeat.o(47123);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess, localException.getLocalizedMessage());
          bc.tG(2131755506);
          k.a(k.this, k.bni());
          k.f(k.this);
          AppMethodBeat.o(47123);
        }
      }
    });
    AppMethodBeat.o(47140);
  }
  
  public final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> bnf()
  {
    AppMethodBeat.i(47142);
    AppBrandSysConfigWC localAppBrandSysConfigWC = u.Ki(this.appId);
    if (localAppBrandSysConfigWC == null) {
      bc.Oq(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755578, new Object[] { "" }));
    }
    if (localAppBrandSysConfigWC == null)
    {
      ac.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!");
      localObject1 = liV;
      AppMethodBeat.o(47142);
      return localObject1;
    }
    ((com.tencent.mm.plugin.appbrand.appusage.k)j.T(com.tencent.mm.plugin.appbrand.appusage.k.class)).I(u.Kn(this.appId), bs.aNx());
    com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    this.liN.alive();
    Object localObject3;
    Object localObject4;
    int i;
    label205:
    Object localObject2;
    label274:
    Object localObject6;
    Object localObject5;
    if (this.hxM == 0)
    {
      this.liP.alive();
      localAppBrandSysConfigWC.jEn = this.jEn;
      localObject3 = new bf(localAppBrandSysConfigWC.appId, this.hxM, this.jjf, this.enterScene, this.liI, this.bYk, this.jEn, this.jDH)
      {
        public final void bnc()
        {
          AppMethodBeat.i(47124);
          super.bnc();
          k.g(k.this);
          AppMethodBeat.o(47124);
        }
        
        public final void bnk()
        {
          AppMethodBeat.i(47125);
          super.bnk();
          k.h(k.this);
          AppMethodBeat.o(47125);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47126);
          super.onDownloadProgress(paramAnonymousInt);
          if (k.this.liC != null) {
            k.this.liC.onDownloadProgress(paramAnonymousInt);
          }
          AppMethodBeat.o(47126);
        }
      };
      localObject4 = ((bf)localObject3).bnK();
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOq, true);
      if (!bool) {
        break label460;
      }
      i = 1;
      ac.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
      if (!bool) {
        break label465;
      }
      localObject2 = new bd(this.appId, this.hxM, this.bYk, this.liI, this.enterScene, this.liG, this.jDH)
      {
        final void aUh()
        {
          AppMethodBeat.i(186813);
          k.i(k.this);
          AppMethodBeat.o(186813);
        }
      };
      localObject1 = ((bd)localObject2).bnK();
      localObject6 = new bg(this.appId, this.hxM, this.dxE, this.enterScene, this.jjf, this.cce, this.liG, this.jEn, this.jDH, this.username, this.jjr)
      {
        final void aUg()
        {
          AppMethodBeat.i(186814);
          k.j(k.this);
          AppMethodBeat.o(186814);
        }
      };
      localObject5 = (au)((bg)localObject6).bnL();
      this.liK.ljb = ((bg)localObject6).lnD;
      this.liK.ljc = ((bg)localObject6).lnE;
      if (localObject5 != null) {
        break label474;
      }
      ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", new Object[] { this.username, this.appId });
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { this.username, this.appId });
        localObject1 = com.tencent.mm.vending.j.a.i(null, locali.value, this.liK);
        AppMethodBeat.o(47142);
        return localObject1;
        this.liQ.alive();
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
        localObject6 = AppBrandLaunchErrorAction.a.a(this.appId, this.hxM, (au)localObject5);
        if (localObject6 != null)
        {
          locali.value = localObject6;
          ty(54);
          ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", new Object[] { this.username, this.appId, Integer.valueOf(((au)localObject5).field_launchAction.DLI) });
          i = 0;
        }
        else
        {
          this.liK.ljh = ((au)localObject5).lnb;
          if ((((au)localObject5).field_jsapiInfo == null) || (((au)localObject5).field_jsapiInfo.Epw == null))
          {
            ty(54);
            ac.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", new Object[] { this.username, this.appId });
            i = 0;
          }
          else
          {
            ((au)localObject5).a(localAppBrandSysConfigWC);
            localObject5 = (WxaPkgWrappingInfo)((Pair)((Future)localObject4).get()).first;
            localObject4 = (List)((Pair)((Future)localObject4).get()).second;
            this.liD = true;
            bng();
            this.liN.dead();
            this.liP.dead();
            this.liQ.dead();
            this.liK.liY.addAll(this.liO);
            this.liK.liZ.addAll(this.liM);
            this.liK.ljd = ((bf)localObject3).lnD;
            this.liK.lje = ((bf)localObject3).lnE;
            if (localObject5 == null)
            {
              ty(55);
              ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", new Object[] { this.username, this.appId });
              i = 0;
            }
            else
            {
              localAppBrandSysConfigWC.jEg = ((WxaPkgWrappingInfo)localObject5);
              localAppBrandSysConfigWC.ccS = ((List)localObject4);
              if (localAppBrandSysConfigWC.jEg.jpa != 0) {
                localAppBrandSysConfigWC.jEg.pkgVersion = 0;
              }
              ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", new Object[] { this.username, localAppBrandSysConfigWC.appId, localAppBrandSysConfigWC.jEg });
              label892:
              long l;
              if (com.tencent.mm.plugin.appbrand.ui.recommend.e.cb(this.appId, this.hxM))
              {
                if (this.liF <= 0L)
                {
                  i = 1;
                  localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
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
                  this.liK.ljf = ((bd)localObject2).lnD;
                  this.liK.ljg = ((bd)localObject2).lnE;
                  if (((Future)localObject1).get() != null)
                  {
                    localObject2 = (HashMap)((Pair)((Future)localObject1).get()).first;
                    if (localObject2 == null) {
                      break label1245;
                    }
                    i = ((HashMap)localObject2).size();
                    label986:
                    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkWxaJsApiInfoHashMap size:%d", new Object[] { Integer.valueOf(i) });
                    localAppBrandSysConfigWC.ccs = ((HashMap)localObject2);
                    this.liK.lji = ((Boolean)((Pair)((Future)localObject1).get()).second).booleanValue();
                  }
                }
                localAppBrandSysConfigWC.ccO = AppBrandGlobalSystemConfig.bat();
                localObject1 = com.tencent.mm.plugin.appbrand.message.h.lvl;
                localObject1 = com.tencent.mm.plugin.appbrand.message.h.dT(this.appId, "copypath");
                if (localObject1 != null) {
                  break label1250;
                }
                l = 0L;
                label1070:
                localAppBrandSysConfigWC.ccN = l;
                ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + localAppBrandSysConfigWC.ccN);
                com.tencent.e.h.JZN.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(47129);
                    Object localObject = u.Kk(k.this.username);
                    if ((localObject != null) && (localObject.length > 0))
                    {
                      int j = localObject.length;
                      int i = 0;
                      while (i < j)
                      {
                        String str = localObject[i];
                        com.tencent.mm.modelappbrand.a.b.aAS().zt(str);
                        i += 1;
                      }
                    }
                    if (k.bnj())
                    {
                      localObject = new l(12);
                      com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject, 0);
                    }
                    AppMethodBeat.o(47129);
                  }
                }, "AppLaunchPrepareProcess#ExtraWorks");
                ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { this.username, this.appId });
                bnh();
                if (com.tencent.mm.vfs.p.fyy()) {
                  break label1259;
                }
                ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "isVFSSwitchOpen = false, appId = [%s]", new Object[] { this.appId });
                label1177:
                localObject1 = com.tencent.mm.plugin.appbrand.appstorage.e.jsh;
                localAppBrandSysConfigWC.jEh = e.a.IO(this.appId);
                localAppBrandSysConfigWC.jEi = f.jsl.aXU();
                i = localAppBrandSysConfigWC.jEh;
                if (i != 2) {
                  break label2124;
                }
                com.tencent.mm.plugin.report.service.h.wUl.n(1016L, 7L, 1L);
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
                localObject1 = com.tencent.mm.plugin.appbrand.appstorage.b.b.jtT;
                localObject1 = com.tencent.mm.plugin.appbrand.appstorage.b.b.a.Jk(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").fxV()));
                if (localObject1 == null)
                {
                  ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: srcBaseDirPath ==null");
                  break label1177;
                }
                if (com.tencent.mm.sdcard_migrate.b.aKl((String)localObject1))
                {
                  ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: Migrated");
                  break label1177;
                }
                com.tencent.mm.kernel.g.agP();
                localObject2 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin());
                localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.b();
                d.g.b.k.h(localObject2, "uin");
                ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject1).uin = ((String)localObject2);
                localObject4 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject1).Jj(this.appId);
                localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).cqB;
                localObject5 = new StringBuilder();
                localObject6 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).appId;
                if (localObject6 == null) {
                  d.g.b.k.aVY("appId");
                }
                localObject5 = ((StringBuilder)localObject5).append((String)localObject6);
                localObject4 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).uin;
                if (localObject4 == null) {
                  d.g.b.k.aVY("uin");
                }
                if (((aw)localObject3).getBoolean((String)localObject4, false))
                {
                  com.tencent.mm.plugin.report.service.h.wUl.dB(1323, 2);
                  ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForCompatibility: appId = [%s] isTransferred", new Object[] { this.appId });
                  break label1177;
                }
                localObject6 = com.tencent.mm.plugin.appbrand.jsapi.file.ar.m(new String[] { localObject2, this.appId }) + "/";
                localObject3 = com.tencent.mm.plugin.appbrand.jsapi.file.ar.m(new String[] { localObject2, this.appId, "opendata" }) + "/";
                localObject4 = com.tencent.mm.plugin.appbrand.jsapi.file.ar.m(new String[] { localObject2, this.appId, "clientdata" }) + "/";
                localObject2 = com.tencent.mm.loader.j.b.aph();
                localObject5 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject1).Jj(this.appId);
                d.g.b.k.h(localObject2, "path");
                localObject1 = localObject2;
                if (!d.n.n.nc((String)localObject2, "/")) {
                  localObject1 = (String)localObject2 + '/';
                }
                ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).jtR = ((String)localObject1);
                d.g.b.k.h(localObject6, "nonFlattenedFSPath");
                d.g.b.k.h(localObject3, "nonFlattenedOpenFSPath");
                d.g.b.k.h(localObject4, "nonFlattenedClientFSPath");
                localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).hYj;
                if (localObject1 == null) {
                  d.g.b.k.fOy();
                }
                if (d.n.n.nc((String)localObject1, "/")) {}
                for (localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).hYj;; localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).hYj + "/")
                {
                  localObject2 = new StringBuilder().append((String)localObject1).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.jtY.jub).append('/');
                  Object localObject7 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).appId;
                  if (localObject7 == null) {
                    d.g.b.k.aVY("appId");
                  }
                  localObject2 = (String)localObject7 + '/';
                  localObject7 = new StringBuilder();
                  String str = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).jtR;
                  if (str == null) {
                    d.g.b.k.aVY("appBrandTargetFolder");
                  }
                  localObject7 = ((StringBuilder)localObject7).append(str).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.jtY.jub).append('/');
                  str = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).appId;
                  if (str == null) {
                    d.g.b.k.aVY("appId");
                  }
                  localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.b.c((String)localObject2, str + '/');
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).jtS.add(localObject2);
                  localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.b.c((String)localObject1 + com.tencent.mm.plugin.appbrand.appstorage.b.d.jtZ.jub + d.n.n.nh((String)localObject6, com.tencent.mm.plugin.appbrand.appstorage.b.d.jtZ.jub), (String)localObject6);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).jtS.add(localObject2);
                  localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.b.c((String)localObject1 + com.tencent.mm.plugin.appbrand.appstorage.b.d.jtZ.jub + d.n.n.nh((String)localObject3, com.tencent.mm.plugin.appbrand.appstorage.b.d.jtZ.jub), (String)localObject3);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).jtS.add(localObject2);
                  localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c((String)localObject1 + com.tencent.mm.plugin.appbrand.appstorage.b.d.jtZ.jub + d.n.n.nh((String)localObject4, com.tencent.mm.plugin.appbrand.appstorage.b.d.jtZ.jub), (String)localObject4);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).jtS.add(localObject1);
                  ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject5).commit();
                  break;
                }
                label2124:
                if (i == 3) {
                  com.tencent.mm.plugin.report.service.h.wUl.n(1016L, 8L, 1L);
                } else if (i == 1) {
                  if (f.jsl.aXT()) {
                    com.tencent.mm.plugin.report.service.h.wUl.n(1016L, 10L, 1L);
                  } else {
                    com.tencent.mm.plugin.report.service.h.wUl.n(1016L, 9L, 1L);
                  }
                }
              }
            }
          }
        }
      }
    }
    ac.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { this.username, this.appId });
    this.liK.liL = this.liL;
    this.liK.lja = bs.eWj();
    Object localObject1 = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.liK);
    AppMethodBeat.o(47142);
    return localObject1;
  }
  
  final void bng()
  {
    AppMethodBeat.i(47143);
    if (this.liC != null) {
      this.liC.onDownloadProgress(100);
    }
    AppMethodBeat.o(47143);
  }
  
  static final class a
    extends com.tencent.mm.sdk.platformtools.au
  {
    public a(final String paramString1, String paramString2, final QualitySession paramQualitySession)
    {
      super(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47130);
          Object localObject = com.tencent.luggage.sdk.e.c.cfq;
          localObject = com.tencent.luggage.sdk.e.c.cm(k.a.this);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
            ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).d(paramQualitySession);
          }
          localObject = com.tencent.luggage.sdk.e.c.cfq;
          com.tencent.luggage.sdk.e.c.cn(k.a.this);
          k.aNj().remove(k.a.this);
          localObject = k.Ok(paramString1);
          String str;
          if (localObject != null)
          {
            str = ((k)localObject).appId;
            if (k.a((k)localObject) != null) {
              break label105;
            }
          }
          label105:
          for (int i = 0;; i = k.a((k)localObject).aBM)
          {
            m.a(23, str, i, ((k)localObject).hxM, k.b((k)localObject));
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
    
    public abstract void aUg();
    
    public abstract void aUh();
    
    public abstract void bnc();
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.k
 * JD-Core Version:    0.7.0.1
 */