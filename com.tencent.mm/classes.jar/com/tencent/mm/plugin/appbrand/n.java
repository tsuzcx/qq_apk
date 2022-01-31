package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.backgroundfetch.f.1;
import com.tencent.mm.plugin.appbrand.backgroundfetch.f.2;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.e.a;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.1;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.2;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.task.d.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class n
  extends i
  implements com.tencent.mm.vending.e.b
{
  public volatile com.tencent.mm.plugin.appbrand.permission.d fzB;
  public volatile com.tencent.mm.plugin.appbrand.appstorage.l fzC;
  private j fzD;
  private AppBrandRemoteTaskController fzE = new AppBrandRemoteTaskController();
  private com.tencent.mm.plugin.appbrand.report.model.m fzF;
  public l fzG = new l();
  public boolean fzH;
  private Boolean fzI = null;
  private boolean fzK;
  private com.tencent.mm.plugin.appbrand.task.e fzL = new com.tencent.mm.plugin.appbrand.task.e()
  {
    public final void finish()
    {
      n.this.finish();
    }
    
    public final void onNetworkChange()
    {
      com.tencent.mm.plugin.appbrand.jsapi.p.f(n.this.aae());
    }
  };
  private final Set<com.tencent.mm.vending.e.a> pHN = new CopyOnWriteArraySet();
  
  public n(Activity paramActivity, w paramw)
  {
    super(paramActivity, paramw);
    AppBrandRemoteTaskController localAppBrandRemoteTaskController = this.fzE;
    paramw = paramw.ZZ();
    com.tencent.mm.plugin.appbrand.task.e locale = this.fzL;
    localAppBrandRemoteTaskController.fAR = paramActivity.getClass().getName();
    if ((paramActivity instanceof AppBrandEmbedUI)) {
      localAppBrandRemoteTaskController.hbA = ((AppBrandEmbedUI)paramActivity).hcA;
    }
    localAppBrandRemoteTaskController.fyY = paramw;
    localAppBrandRemoteTaskController.fzL = locale;
  }
  
  private void a(e.a parama, a.d paramd)
  {
    if (this.mFinished)
    {
      y.i("MicroMsg.AppBrandRuntimeWC", "mFinished is true return,mAppId:%s", new Object[] { this.mAppId });
      return;
    }
    paramd = com.tencent.mm.plugin.appbrand.config.e.a((AppBrandInitConfigWC)super.ZA(), getAppConfig(), paramd);
    com.tencent.mm.plugin.appbrand.config.e.r((MMActivity)super.getContext()).a(paramd, parama);
  }
  
  private a.d aaf()
  {
    Object localObject = (o)super.Zz();
    if (localObject == null) {
      return null;
    }
    localObject = ((o)localObject).getCurrentPage();
    if (localObject == null) {
      return null;
    }
    return ((k)localObject).getPageConfig();
  }
  
  private void kn(int paramInt)
  {
    int i = 369;
    if (ZH()) {
      i = 777;
    }
    h.nFQ.a(i, paramInt, 1L, false);
  }
  
  protected final com.tencent.mm.plugin.appbrand.m.a ZC()
  {
    if ((aaa() != null) && (!bk.dk(aaa().fPS.fEQ))) {}
    for (int i = 1; i != 0; i = 0) {
      return new com.tencent.mm.plugin.appbrand.m.f(this);
    }
    return new b.a(this, (byte)0);
  }
  
  protected final com.tencent.mm.plugin.appbrand.ui.n ZD()
  {
    com.tencent.mm.plugin.appbrand.ui.n localn = com.tencent.mm.plugin.appbrand.ui.e.b((MMActivity)super.getContext(), this);
    localn.cd(((AppBrandInitConfigWC)super.ZA()).iconUrl, ((AppBrandInitConfigWC)super.ZA()).bJw);
    if (aab().scene == 1023) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localn.aoT();
      }
      return localn;
    }
  }
  
  protected final void ZI()
  {
    super.ZI();
    kn(11);
  }
  
  protected final com.tencent.mm.plugin.appbrand.page.n ZK()
  {
    if (ZH()) {
      return new com.tencent.mm.plugin.appbrand.game.page.e((MMActivity)super.getContext(), this);
    }
    return new o((MMActivity)super.getContext(), this);
  }
  
  protected final void ZL()
  {
    a.b(this);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.ZA();
    this.fzG.n(0, System.currentTimeMillis() - localAppBrandInitConfigWC.startTime);
    kn(1);
    com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.ZA()).startTime, System.currentTimeMillis());
    MMToClientEvent.a(this.mAppId, new n.7(this));
    v.o("weapp_id", ((AppBrandInitConfigWC)super.ZA()).appId);
    v.o("weapp_name", ((AppBrandInitConfigWC)super.ZA()).bJw);
    v.o("use_private_classloader", Boolean.valueOf(false));
    ae.getContext().registerComponentCallbacks(new b.1(this));
    this.fzG.n(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)super.ZA()).startTime);
    kn(2);
  }
  
  protected final void ZO()
  {
    this.fzE.a(this.mAppId, ((AppBrandInitConfigWC)super.ZA()).fEL, com.tencent.mm.plugin.appbrand.task.f.e((AppBrandInitConfigWC)super.ZA()));
  }
  
  public final AppBrandSysConfigWC aaa()
  {
    return (AppBrandSysConfigWC)c(AppBrandSysConfigWC.class, false);
  }
  
  public final AppBrandStatObject aab()
  {
    return ((AppBrandInitConfigWC)super.ZA()).fPE;
  }
  
  public final AppBrandInitConfigWC aac()
  {
    return (AppBrandInitConfigWC)super.ZA();
  }
  
  public final o aad()
  {
    return (o)super.Zz();
  }
  
  public final p aae()
  {
    return (p)super.Zy();
  }
  
  public final int aag()
  {
    return aab().scene;
  }
  
  public final boolean aah()
  {
    if (this.fzI != null) {
      return this.fzI.booleanValue();
    }
    AppBrandStatObject localAppBrandStatObject = aab();
    if (((AppBrandInitConfigWC)super.ZA() != null) && (((AppBrandInitConfigWC)super.ZA()).fPx) && ((localAppBrandStatObject.scene == 1011) || (localAppBrandStatObject.scene == 1012) || (localAppBrandStatObject.scene == 1013))) {}
    for (boolean bool = true;; bool = false)
    {
      this.fzI = Boolean.valueOf(bool);
      return this.fzI.booleanValue();
    }
  }
  
  public final MMActivity aai()
  {
    return (MMActivity)super.getContext();
  }
  
  protected final void b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    if (!this.dNk) {
      return;
    }
    Object localObject1 = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    int i;
    if (!this.dNk) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.fyB = true;
        y.d("MicroMsg.AppBrandRuntime", "setWillRelaunch");
      }
      super.b(paramAppBrandInitConfig);
      if ((o)super.Zz() != null) {
        ((o)super.Zz()).getReporter().aee();
      }
      paramAppBrandInitConfig = (AppBrandInitConfigWC)super.ZA();
      localObject1 = aaa();
      Object localObject2 = aab();
      y.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.fEL) });
      String str = paramAppBrandInitConfig.fJO;
      AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, (AppBrandStatObject)localObject2, ((AppBrandSysConfigWC)localObject1).fPS.fEN, WxaCommLibRuntimeReader.abQ().fEN, str, paramAppBrandInitConfig.fPC)));
      y.i("MicroMsg.AppBrandRuntimeWC", "updateStat %s, scene %d", new Object[] { this.mAppId, Integer.valueOf(aab().scene) });
      return;
      localObject2 = ((AppBrandInitConfigWC)localObject1).fPE;
      boolean bool;
      if ((this.fzK) || (((AppBrandStatObject)localObject2).scene == 1099)) {
        if (((AppBrandStatObject)localObject2).scene == 1099)
        {
          bool = true;
          label236:
          this.fzK = bool;
        }
      }
      do
      {
        i = 1;
        break;
        bool = false;
        break label236;
        if ((((AppBrandStatObject)localObject2).scene == 1022) || (((AppBrandStatObject)localObject2).scene == 1001) || (((AppBrandStatObject)localObject2).scene == 1089) || (((AppBrandStatObject)localObject2).scene == 1090) || (((AppBrandStatObject)localObject2).scene == 1038))
        {
          i = 0;
          break;
        }
        localObject2 = (AppBrandInitConfigWC)super.ZA();
      } while ((!bk.bl(((AppBrandInitConfigWC)localObject1).fPq)) || (!bk.bl(((AppBrandInitConfigWC)localObject1).dTX)) || (!bk.bl(((AppBrandInitConfigWC)localObject2).fPq)) || (!bk.bl(((AppBrandInitConfigWC)localObject2).dTX)));
      i = 0;
    }
  }
  
  protected final void c(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppBrandInitConfigWC localAppBrandInitConfigWC = ((AppBrandInitConfigWC)super.ZA()).aeh();
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1038;
    if ((paramAppBrandInitConfig instanceof AppBrandInitConfigWC)) {
      localAppBrandStatObject.bFv = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigWC)paramAppBrandInitConfig).fJO + ':' + (paramAppBrandInitConfig.bFB + 1000));
    }
    localAppBrandInitConfigWC.aee();
    localAppBrandInitConfigWC.fPE = localAppBrandStatObject;
    b(localAppBrandInitConfigWC);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    if (parama != null) {
      this.pHN.add(parama);
    }
  }
  
  final void onConfigurationChanged(Configuration paramConfiguration)
  {
    com.tencent.mm.plugin.appbrand.jsapi.p.g.a(paramConfiguration, this.mAppId);
  }
  
  protected final void onCreate()
  {
    com.tencent.mm.plugin.appbrand.report.quality.a.i(this);
    Object localObject1 = com.tencent.mm.plugin.appbrand.game.e.a.ahj();
    Object localObject2 = this.mAppId;
    com.tencent.mm.plugin.appbrand.game.e.a.appId = (String)localObject2;
    y.i("MicroMsg.MBNiReporter", "hy: appId:%s", new Object[] { localObject2 });
    g.a((String)localObject2, ((com.tencent.mm.plugin.appbrand.game.e.a)localObject1).gda);
    a(new n.1(this));
    a(new n.5(this));
    a(new i.b()
    {
      public final void prepare()
      {
        n.c(n.this, this);
      }
    });
    localObject1 = a.qn(this.mAppId);
    if ((localObject1 != null) && (this != localObject1)) {
      ((i)localObject1).finish();
    }
    localObject1 = this.fzE;
    localObject2 = this.mAppId;
    ((AppBrandRemoteTaskController)localObject1).hbB = AppBrandRemoteTaskController.a.hbQ;
    ((AppBrandRemoteTaskController)localObject1).mAppId = ((String)localObject2);
    AppBrandMainProcessService.a((MainProcessTask)localObject1);
    this.fzE.a(this.mAppId, ((AppBrandInitConfigWC)super.ZA()).fEL, com.tencent.mm.plugin.appbrand.task.f.e((AppBrandInitConfigWC)super.ZA()));
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    m.qE(this.mAppId);
    localObject1 = this.mAppId;
    localObject2 = new a.1();
    MMToClientEvent.a((String)localObject1, (MMToClientEvent.c)localObject2);
    this.fyy.a(new a.2((MMToClientEvent.c)localObject2));
    localObject1 = this.mAppId;
    localObject2 = new f.1((String)localObject1);
    MMToClientEvent.a((String)localObject1, (MMToClientEvent.c)localObject2);
    y.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app start listening, appId:%s", new Object[] { localObject1 });
    this.fyy.a(new f.2((MMToClientEvent.c)localObject2));
    this.fzF = new com.tencent.mm.plugin.appbrand.report.model.m(this);
    this.fzF.gZs = bk.UZ();
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.a(this.mAppId, ZF(), ((AppBrandInitConfigWC)super.ZA()).fPE);
  }
  
  protected final void onDestroy()
  {
    if (DebuggerShell.aeu()) {
      com.tencent.mm.plugin.appbrand.v.c.DS().O(new n.10(this));
    }
    AppBrandStickyBannerLogic.a.wz(this.mAppId);
    Object localObject1 = AppBrandMusicClientService.gNe;
    ((AppBrandMusicClientService)localObject1).gNd.clear();
    ((AppBrandMusicClientService)localObject1).gNf = "";
    com.tencent.mm.plugin.appbrand.media.a.a.tP(this.mAppId);
    m.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    com.tencent.mm.plugin.appbrand.permission.c.vW(this.mAppId);
    localObject1 = this.fzE;
    Object localObject2 = this.mAppId;
    ((AppBrandRemoteTaskController)localObject1).hbB = AppBrandRemoteTaskController.a.hbK;
    ((AppBrandRemoteTaskController)localObject1).mAppId = ((String)localObject2);
    AppBrandMainProcessService.a((MainProcessTask)localObject1);
    localObject1 = this.fzC;
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.appbrand.appstorage.l)localObject1).release();
      this.fzC = null;
    }
    a.a(this);
    a.qr(this.mAppId);
    if (this.fzF != null) {
      localObject1 = this.fzF;
    }
    for (;;)
    {
      try
      {
        localObject2 = m.qH(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gaS.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gYR = com.tencent.mm.plugin.appbrand.report.c.cv(ae.getContext());
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).appId = ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gaS.mAppId;
        if (((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gaS.aaa() != null) {
          continue;
        }
        i = 0;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).cau = i;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).bFu = (((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gaS.fyn.fEL + 1);
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).scene = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gaS.ZA()).fPE.scene;
        if (!((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZt) {
          continue;
        }
        i = 1;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZu = i;
        if (!((m)localObject2).fzv.get()) {
          continue;
        }
        i = 1;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZv = i;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZw = bk.cp(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZs);
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZx = bk.UY();
        y.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).toString());
        com.tencent.mm.plugin.report.f.nEG.f(14576, new Object[] { ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gYR, ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).scene), ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).bIB, Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZv), Long.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZw), Long.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gZx) });
      }
      catch (Exception localException)
      {
        int i;
        y.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[] { localException });
        continue;
        this.pHN.clear();
      }
      this.fzF = null;
      localObject1 = this.pHN.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      continue;
      i = ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).gaS.aaa().fPS.fEN;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  protected final void onPause()
  {
    AppBrandRemoteTaskController localAppBrandRemoteTaskController = this.fzE;
    localAppBrandRemoteTaskController.hbB = AppBrandRemoteTaskController.a.hbS;
    AppBrandMainProcessService.a(localAppBrandRemoteTaskController);
  }
  
  protected final void onReady()
  {
    Object localObject;
    if ((AppBrandPerformanceManager.vS(this.mAppId)) && (this.fzD == null))
    {
      AppBrandPerformanceManager.vP(this.mAppId);
      if (!DebuggerShell.aeu())
      {
        this.fzD = new j((MMActivity)super.getContext(), this.mAppId);
        this.fyq.addView(this.fzD);
        a.a(this.mAppId, this.fzD);
        localObject = this.fzD;
        AppBrandPerformanceManager.vT(((j)localObject).mAppId);
        ((j)localObject).setVisibility(0);
        ((j)localObject).setAlpha(0.0F);
        ((j)localObject).animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    long l = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.ZA()).startTime;
    boolean bool1 = this.fzH;
    boolean bool2 = ZH();
    if (bool2) {}
    for (int j = 775;; j = 367)
    {
      int i;
      label208:
      String str;
      label258:
      label420:
      label435:
      StringBuilder localStringBuilder;
      if (l <= 2000L) {
        if (bool1)
        {
          i = 8;
          h.nFQ.a(j, i, 1L, false);
          if (!bool1) {
            break label854;
          }
          h.nFQ.a(j, 7L, 1L, false);
          y.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
          if ((AppBrandInitConfigWC)super.ZA() == null) {
            break label868;
          }
          localObject = ((AppBrandInitConfigWC)super.ZA()).bJw;
          y.i("MicroMsg.AppBrandRuntimeWC", "onHideSplash: %s, cost: %dms, download : %b", new Object[] { localObject, Long.valueOf(l), Boolean.valueOf(this.fzH) });
          l = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.ZA()).startTime;
          this.fzG.n(5, l);
          localObject = this.fzG;
          bool1 = this.fzH;
          bool2 = ((AppBrandInitConfigWC)super.ZA()).fPD;
          boolean bool3 = ((AppStartupPerformanceReportBundle)c(AppStartupPerformanceReportBundle.class, true)).gKl;
          str = this.mAppId;
          ((l)localObject).mVersion = 0;
          ((l)localObject).mType = 0;
          if (aaa() != null)
          {
            ((l)localObject).mVersion = aaa().fPS.fEN;
            ((l)localObject).mType = (aaa().fPS.fEM + 1);
          }
          if (!bool1) {
            break label876;
          }
          i = 1;
          ((l)localObject).fzm = i;
          if (!ZH()) {
            break label881;
          }
          i = 1;
          ((l)localObject).fzr = i;
          ((l)localObject).fzn = ((AppBrandInitConfigWC)super.ZA()).fPE.scene;
          ((l)localObject).fzp = bool2;
          ((l)localObject).fzq = bool3;
          localStringBuilder = new StringBuilder();
          i = 0;
        }
      }
      for (;;)
      {
        if (i >= ((l)localObject).fzl.length) {
          break label915;
        }
        if (localObject.fzl[i] < 0L)
        {
          y.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject.fzl[i]) });
          AppBrandPerformanceManager.b(this.mAppId, 202, l);
          com.tencent.mm.plugin.appbrand.performance.a.cE(((AppBrandInitConfigWC)super.ZA()).startTime);
          com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "startupDone", ((AppBrandInitConfigWC)super.ZA()).startTime, System.currentTimeMillis());
          com.tencent.mm.plugin.appbrand.report.quality.a.b(this.mAppId, this);
          localObject = this.fzE;
          ((AppBrandRemoteTaskController)localObject).hbB = AppBrandRemoteTaskController.a.hbR;
          AppBrandMainProcessService.a((MainProcessTask)localObject);
          return;
          i = 1;
          break;
          if (l <= 3000L)
          {
            if (bool1)
            {
              i = 9;
              break;
            }
            i = 2;
            break;
          }
          if (l <= 4000L)
          {
            if (bool1)
            {
              i = 10;
              break;
            }
            i = 3;
            break;
          }
          if (l <= 5000L)
          {
            if (bool1)
            {
              i = 11;
              break;
            }
            i = 4;
            break;
          }
          if (l <= 6000L)
          {
            if (bool1)
            {
              i = 12;
              break;
            }
            i = 5;
            break;
          }
          if (bool2)
          {
            if (l <= 7000L)
            {
              if (bool1)
              {
                i = 19;
                break;
              }
              i = 14;
              break;
            }
            if (l <= 8000L)
            {
              if (bool1)
              {
                i = 20;
                break;
              }
              i = 15;
              break;
            }
            if (l <= 9000L)
            {
              if (bool1)
              {
                i = 21;
                break;
              }
              i = 16;
              break;
            }
            if (l <= 10000L)
            {
              if (bool1)
              {
                i = 22;
                break;
              }
              i = 17;
              break;
            }
            if (bool1)
            {
              i = 23;
              break;
            }
            i = 18;
            break;
          }
          if (bool1)
          {
            i = 13;
            break;
          }
          i = 6;
          break;
          label854:
          h.nFQ.a(j, 0L, 1L, false);
          break label208;
          label868:
          localObject = "";
          break label258;
          label876:
          i = 0;
          break label420;
          label881:
          i = 0;
          break label435;
        }
        localStringBuilder.append(localObject.fzl[i]);
        localStringBuilder.append(",");
        i += 1;
      }
      label915:
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.ZA();
      if (localAppBrandInitConfigWC != null) {
        i = localAppBrandInitConfigWC.bFB;
      }
      for (;;)
      {
        i += 1000;
        y.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { str, localStringBuilder.toString(), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.d.aaE()), Integer.valueOf(i) });
        ((l)localObject).e(str, 1, 0, i);
        ((l)localObject).e(str, 2, 1, i);
        ((l)localObject).e(str, 3, 2, i);
        ((l)localObject).e(str, 4, 3, i);
        ((l)localObject).e(str, 6, 4, i);
        ((l)localObject).e(str, 7, 5, i);
        ((l)localObject).e(str, 23, 6, i);
        ((l)localObject).e(str, 24, 7, i);
        ((l)localObject).e(str, 25, 8, i);
        ((l)localObject).e(str, 26, 9, i);
        ((l)localObject).e(str, 27, 10, i);
        ((l)localObject).e(str, 28, 11, i);
        ((l)localObject).e(str, 29, 12, i);
        ((l)localObject).e(str, 30, 13, i);
        ((l)localObject).e(str, 31, 14, i);
        break;
        i = com.tencent.mm.plugin.appbrand.report.d.vZ(str);
        y.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  protected final void onResume()
  {
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.a(this.mAppId, ZF(), ((AppBrandInitConfigWC)super.ZA()).fPE);
    Object localObject = this.fzE;
    String str = this.mAppId;
    int i = ((AppBrandInitConfigWC)super.ZA()).fEL;
    ((AppBrandRemoteTaskController)localObject).hbB = AppBrandRemoteTaskController.a.hbJ;
    ((AppBrandRemoteTaskController)localObject).mAppId = str;
    ((AppBrandRemoteTaskController)localObject).gJA = i;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.fyB) {
      ((o)super.Zz()).getReporter().gXY = true;
    }
    localObject = aaf();
    com.tencent.mm.plugin.appbrand.task.d.wj(this.mAppId);
    a(new n.8(this), (a.d)localObject);
    localObject = this.mAppId;
    i = ((AppBrandInitConfigWC)super.ZA()).fPE.scene;
    AppBrandIDKeyBatchReport.anU().gXk = 1;
    AppBrandIDKeyBatchReport.anU().gXm = ((String)localObject);
    AppBrandIDKeyBatchReport.anU().gXn = i;
    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.anU());
    com.tencent.mm.sdk.f.e.post(new n.9(this), "getCopyPathMenuExpireTime");
  }
  
  protected final void reload()
  {
    ((AppBrandInitConfigWC)super.ZA()).aee();
    cleanup();
    a((AppBrandInitConfigWC)super.ZA());
    Zw();
    y.i("MicroMsg.AppBrandRuntimeWC", "reload: %s", new Object[] { this.mAppId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */