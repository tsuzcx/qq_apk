package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.pip.b.1;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrandRuntime
  implements o
{
  public volatile boolean SB;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e iDP;
  public ai jwC;
  private final ap jwD;
  private final ao jwE;
  AppBrandRuntime jwF;
  public volatile AppBrandInitConfig jwG;
  private volatile q jwH;
  private volatile com.tencent.mm.plugin.appbrand.page.u jwI;
  public com.tencent.mm.plugin.appbrand.widget.d jwJ;
  public v jwK;
  public com.tencent.mm.plugin.appbrand.ad.e jwL;
  private volatile Boolean jwM;
  private volatile p jwN;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<com.tencent.mm.plugin.appbrand.jsapi.j> jwO;
  private final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.k> jwP;
  private final y jwQ;
  private com.tencent.mm.plugin.appbrand.utils.d jwR;
  public volatile com.tencent.mm.plugin.appbrand.a.c jwS;
  public com.tencent.mm.plugin.appbrand.m.a jwT;
  protected boolean jwU;
  public boolean jwV;
  private boolean jwW;
  public al jwX;
  public boolean jwY;
  public boolean jwZ;
  public boolean jxa;
  public com.tencent.mm.plugin.appbrand.pip.f jxb;
  private AppBrandPipContainerView jxc;
  private AppBrandGlobalNativeWidgetContainerView jxd;
  public com.tencent.mm.plugin.appbrand.page.h jxe;
  public boolean jxf;
  private LinkedList<AppBrandRuntime.b> jxg;
  ConcurrentLinkedQueue<AppBrandRuntime.b> jxh;
  private AppBrandMainProcessService.a jxi;
  private final av jxj;
  private final Deque<Runnable> jxk;
  public SparseArray<Set<aj>> jxl;
  public volatile String mAppId;
  public Context mContext;
  private boolean mDestroyed;
  public volatile boolean mInitialized;
  public boolean mResumed;
  
  public AppBrandRuntime(ai paramai)
  {
    AppMethodBeat.i(176500);
    this.jwM = null;
    this.jwN = null;
    this.jwO = new AppBrandRuntime.1(this);
    this.jwP = new LinkedHashSet();
    this.jwQ = new y();
    this.mResumed = false;
    this.jwY = false;
    this.jwZ = true;
    this.jxf = false;
    this.jxg = new LinkedList();
    this.jxh = null;
    this.jxi = new AppBrandMainProcessService.a()
    {
      private boolean jxp = false;
      
      public final void Ky(String paramAnonymousString)
      {
        AppMethodBeat.i(134451);
        if (this.jxp) {
          AppBrandRuntime.u(AppBrandRuntime.this);
        }
        this.jxp = false;
        AppMethodBeat.o(134451);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        this.jxp = true;
      }
    };
    this.jxj = new av(Looper.getMainLooper(), new AppBrandRuntime.10(this), false);
    this.jxk = new LinkedBlockingDeque();
    this.jxl = new SparseArray();
    this.mContext = paramai.getContext();
    this.jwC = paramai;
    this.jwD = new ap(Looper.getMainLooper());
    this.jwE = new ao();
    this.jwJ = new com.tencent.mm.plugin.appbrand.widget.d(this.mContext);
    this.jwJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.iDP = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.jwJ.addView(this.iDP);
    this.jwR = new com.tencent.mm.plugin.appbrand.utils.d();
    this.jxa = false;
    AppMethodBeat.o(176500);
  }
  
  private void aWd()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitPageContainer", new AppBrandRuntime.4(this));
    AppMethodBeat.o(134499);
  }
  
  private void aWe()
  {
    AppMethodBeat.i(134500);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitService", new AppBrandRuntime.5(this));
    AppMethodBeat.o(134500);
  }
  
  protected p EZ()
  {
    AppMethodBeat.i(134486);
    com.tencent.mm.plugin.appbrand.appstorage.u localu = new com.tencent.mm.plugin.appbrand.appstorage.u(this);
    AppMethodBeat.o(134486);
    return localu;
  }
  
  public q Ew()
  {
    return this.jwH;
  }
  
  protected void Fc() {}
  
  protected com.tencent.mm.plugin.appbrand.m.a Ff()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public p Fg()
  {
    return this.jwN;
  }
  
  public com.tencent.mm.plugin.appbrand.config.k Fh()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.k localk = (com.tencent.mm.plugin.appbrand.config.k)ar(com.tencent.mm.plugin.appbrand.config.k.class);
    AppMethodBeat.o(134481);
    return localk;
  }
  
  public AppBrandInitConfig Fi()
  {
    return this.jwG;
  }
  
  protected boolean K(Runnable paramRunnable)
  {
    return false;
  }
  
  protected void Kx(String paramString)
  {
    AppMethodBeat.i(197190);
    Object localObject2 = getAppConfig();
    com.tencent.mm.plugin.appbrand.r.a.c localc = getWindowAndroid();
    if (localc != null) {
      if (localObject2 == null) {
        break label159;
      }
    }
    label159:
    for (boolean bool = getAppConfig().jVD;; bool = false)
    {
      Object localObject1 = "portrait";
      if (localObject2 != null)
      {
        localObject2 = getAppConfig().bdJ().jWk;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = getAppConfig().jVw.jVL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "portrait";
          }
        }
      }
      localc.setSoftOrientation((String)localObject1);
      localc.setResizeable(bool);
      ad.i("MicroMsg.AppBrandRuntime", "setResizableToWindow: stage[%s] resizable = [%b], appId = [%s]", new Object[] { paramString, Boolean.valueOf(bool), this.mAppId });
      AppMethodBeat.o(197190);
      return;
      ad.e("MicroMsg.AppBrandRuntime", "setResizableToWindow: window should not be null");
      AppMethodBeat.o(197190);
      return;
    }
  }
  
  public final void L(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.SB) || (isDestroyed()))
    {
      ad.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134518);
      return;
    }
    if (this.mInitialized)
    {
      j(paramRunnable, 0L);
      AppMethodBeat.o(134518);
      return;
    }
    this.jxk.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  public final void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(221145);
    j(paramRunnable, 0L);
    AppMethodBeat.o(221145);
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(197187);
    if (isDestroyed())
    {
      AppMethodBeat.o(197187);
      return;
    }
    paramRunnable = s.a(this.jwE, paramRunnable);
    keep(paramRunnable);
    com.tencent.e.h.LTJ.r(paramRunnable, 0L);
    AppMethodBeat.o(197187);
  }
  
  public final void R(Object paramObject)
  {
    AppMethodBeat.i(176509);
    j(new AppBrandRuntime.8(this, paramObject), 0L);
    AppMethodBeat.o(176509);
  }
  
  protected <T extends com.tencent.mm.kernel.c.a> T S(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, aj paramaj)
  {
    AppMethodBeat.i(178506);
    j(new AppBrandRuntime.13(this, paramaj, paramInt2, paramInt1), 0L);
    AppMethodBeat.o(178506);
  }
  
  public final void a(AppBrandRuntime.b paramb)
  {
    AppMethodBeat.i(134476);
    this.jxg.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ai paramai)
  {
    this.jwC = paramai;
  }
  
  public final void a(aj paramaj)
  {
    AppMethodBeat.i(134522);
    j(new AppBrandRuntime.14(this, paramaj), 0L);
    AppMethodBeat.o(134522);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.jwG = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(197184);
    if (!this.mResumed)
    {
      ad.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", new Object[] { this.mAppId, paramString });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.jwG = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(197184);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", new Object[] { this.mAppId, paramString, Log.getStackTraceString(new Throwable()) });
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      aVJ();
      ad.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(197184);
      return;
      paramAppBrandInitConfig = Fi();
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.config.a parama)
  {
    AppMethodBeat.i(134483);
    this.jwO.add(parama);
    AppMethodBeat.o(134483);
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.jwE.a(parama);
    AppMethodBeat.o(160924);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(134493);
    if (paramk == null)
    {
      AppMethodBeat.o(134493);
      return false;
    }
    synchronized (this.jwP)
    {
      this.jwP.add(paramk);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  public final m aVE()
  {
    return this.iDP;
  }
  
  public final void aVJ()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    long l = bt.HI();
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    aVK();
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new AppBrandRuntime.15(this));
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new AppBrandRuntime.16(this));
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new AppBrandRuntime.17(this));
    this.jxj.az(10000L, 10000L);
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(bt.HI() - l) });
    AppMethodBeat.o(134475);
  }
  
  protected void aVK() {}
  
  public final int aVL()
  {
    return this.jwG.dPf;
  }
  
  public final AppBrandRuntime aVM()
  {
    AppMethodBeat.i(134478);
    if (this.jwC == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.jwC.w(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public com.tencent.mm.plugin.appbrand.page.u aVN()
  {
    return this.jwI;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.d aVO()
  {
    return this.jwJ;
  }
  
  public void aVP() {}
  
  public final com.tencent.mm.plugin.appbrand.a.c aVQ()
  {
    return this.jwS;
  }
  
  public final void aVR()
  {
    AppMethodBeat.i(134485);
    if (this.jwN == null) {
      this.jwN = EZ();
    }
    AppMethodBeat.o(134485);
  }
  
  protected v aVS()
  {
    return null;
  }
  
  protected final void aVT()
  {
    AppMethodBeat.i(134487);
    if (this.jwK != null)
    {
      com.tencent.mm.plugin.appbrand.ui.i.a(this.jwK);
      this.jwK = null;
    }
    Object localObject = aVS();
    if (localObject == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    ((v)localObject).dV(Fi().iconUrl, Fi().doD);
    View localView = ((v)localObject).getView();
    this.jwJ.addView(localView, -1, -1);
    this.jwK = ((v)localObject);
    String str = this.mAppId;
    if (this.jwK == null) {}
    for (localObject = "null";; localObject = this.jwK.getClass().getSimpleName())
    {
      ad.i("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", new Object[] { str, localObject });
      localView.setClickable(true);
      this.jwJ.setOnHierarchyChangeListener(new AppBrandRuntime.19(this, localView));
      AppMethodBeat.o(134487);
      return;
    }
  }
  
  protected void aVU() {}
  
  public final void aVV()
  {
    AppMethodBeat.i(134488);
    if (isDestroyed())
    {
      if (this.jwK != null) {
        com.tencent.mm.plugin.appbrand.ui.i.a(this.jwK);
      }
      this.jwK = null;
      AppMethodBeat.o(134488);
      return;
    }
    if (this.jwK == null)
    {
      AppMethodBeat.o(134488);
      return;
    }
    ad.m("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", new Object[] { this.jwK.getClass().getSimpleName() });
    if ((this.jwK instanceof w))
    {
      ((w)this.jwK).aYl();
      AppMethodBeat.o(134488);
      return;
    }
    this.jwK.u(new AppBrandRuntime.20(this));
    AppMethodBeat.o(134488);
  }
  
  public final String aVW()
  {
    AppMethodBeat.i(134489);
    if (this.jwG == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (bt.isNullOrNil(this.jwG.jCN))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().bdL();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.jwG.jCN;
    AppMethodBeat.o(134489);
    return str;
  }
  
  public final boolean aVX()
  {
    return this.mInitialized;
  }
  
  protected void aVY() {}
  
  protected void aVZ() {}
  
  protected q aWa()
  {
    AppMethodBeat.i(134497);
    q localq = new q();
    AppMethodBeat.o(134497);
    return localq;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.u aWb()
  {
    AppMethodBeat.i(134498);
    com.tencent.mm.plugin.appbrand.page.u localu = new com.tencent.mm.plugin.appbrand.page.u(com.tencent.mm.sdk.f.a.jq(this.mContext), this);
    AppMethodBeat.o(134498);
    return localu;
  }
  
  public boolean aWc()
  {
    return false;
  }
  
  protected void aWf() {}
  
  protected final void aWg()
  {
    AppMethodBeat.i(134513);
    this.jwU = true;
    ad.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  protected final void aWh()
  {
    AppMethodBeat.i(197185);
    if (this.jwU)
    {
      ad.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
      AppMethodBeat.o(197185);
      return;
    }
    this.jwV = true;
    ad.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(197185);
  }
  
  public final boolean aWi()
  {
    AppMethodBeat.i(134514);
    if (!this.jwZ)
    {
      AppMethodBeat.o(134514);
      return false;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(this.mContext);
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      AppMethodBeat.o(134514);
      return false;
    }
    if ((this.jwI != null) && (this.jwI.getCurrentPage() != null) && (!this.jwI.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  final void aWj()
  {
    AppMethodBeat.i(134515);
    this.jwS.jKT.a(d.a.jLu);
    g.Kp(this.mAppId);
    AppMethodBeat.o(134515);
  }
  
  public void aWk()
  {
    AppMethodBeat.i(176510);
    N(new AppBrandRuntime.11(this));
    AppMethodBeat.o(176510);
  }
  
  public boolean aWl()
  {
    AppMethodBeat.i(134517);
    if (this.jwS.jKT.bbg() == com.tencent.mm.plugin.appbrand.a.b.jKQ) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      AppMethodBeat.o(134517);
      return true;
    }
    AppMethodBeat.o(134517);
    return false;
  }
  
  protected v aWm()
  {
    return this.jwK;
  }
  
  public final boolean aWn()
  {
    AppMethodBeat.i(197188);
    if (this.jwM == null) {
      this.jwM = Boolean.valueOf(((com.tencent.mm.plugin.appbrand.ad.j)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.j.class)).J(this));
    }
    boolean bool = this.jwM.booleanValue();
    AppMethodBeat.o(197188);
    return bool;
  }
  
  public final boolean aWo()
  {
    AppMethodBeat.i(197189);
    if ((this.jwK instanceof w)) {}
    for (boolean bool = ((w)this.jwK).aWo();; bool = false)
    {
      String str2 = this.mAppId;
      if (this.jwK == null) {}
      for (String str1 = "null";; str1 = this.jwK.getClass().getSimpleName())
      {
        ad.i("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
        AppMethodBeat.o(197189);
        return bool;
      }
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.jwQ.al(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.h.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.h.mTe);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    paramClass = S(paramClass);
    AppMethodBeat.o(134494);
    return paramClass;
  }
  
  public final void ac(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(134496);
    this.jwQ.ac(paramClass);
    AppMethodBeat.o(134496);
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.j> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.jxf) {}
    for (boolean bool = true;; bool = false)
    {
      paramClass = c(paramClass, bool);
      AppMethodBeat.o(134491);
      return paramClass;
    }
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.k> T as(Class<T> paramClass)
  {
    AppMethodBeat.i(134492);
    if (paramClass == null)
    {
      AppMethodBeat.o(134492);
      return null;
    }
    synchronized (this.jwP)
    {
      Iterator localIterator = this.jwP.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.k localk = (com.tencent.mm.plugin.appbrand.jsapi.k)localIterator.next();
        if (paramClass.isInstance(localk))
        {
          AppMethodBeat.o(134492);
          return localk;
        }
      }
      AppMethodBeat.o(134492);
      return null;
    }
  }
  
  final void b(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(176507);
    a(paramAppBrandInitConfig, paramObject);
    AppMethodBeat.o(176507);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(134495);
    this.jwQ.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(197181);
    if (paramk == null)
    {
      AppMethodBeat.o(197181);
      return false;
    }
    synchronized (this.jwP)
    {
      this.jwP.remove(paramk);
      AppMethodBeat.o(197181);
      return true;
    }
  }
  
  /* Error */
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.j> T c(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1256
    //   3: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 122	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jwO	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1261	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 424 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 428 1 0
    //   38: checkcast 1263	com/tencent/mm/plugin/appbrand/jsapi/j
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1242	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1269	org/a/a:bF	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1273	org/a/a:gyr	()Lorg/a/a;
    //   65: getfield 1277	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1263	com/tencent/mm/plugin/appbrand/jsapi/j
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 122	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jwO	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 964 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1256
    //   99: invokestatic 233	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 268
    //   109: ldc_w 1279
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1282	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 585	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -30 -> 96
    //   129: astore_3
    //   130: aload 4
    //   132: astore_3
    //   133: goto -27 -> 106
    //   136: goto -40 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	AppBrandRuntime
    //   0	139	1	paramClass	Class<T>
    //   0	139	2	paramBoolean	boolean
    //   20	83	3	localj1	com.tencent.mm.plugin.appbrand.jsapi.j
    //   129	1	3	localException1	java.lang.Exception
    //   132	1	3	localException2	java.lang.Exception
    //   7	87	4	localj2	com.tencent.mm.plugin.appbrand.jsapi.j
    //   104	27	4	localException3	java.lang.Exception
    //   16	16	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   58	73	104	java/lang/Exception
    //   81	93	129	java/lang/Exception
  }
  
  protected final void c(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134474);
    if (paramAppBrandInitConfig == null)
    {
      ad.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      AppMethodBeat.o(134474);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", new Object[] { paramAppBrandInitConfig });
    this.jwG = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.jwS = new com.tencent.mm.plugin.appbrand.a.c(this);
    this.jwS.jKT.start();
    this.jwS.a(new AppBrandRuntime.12(this));
    this.mInitialized = false;
    try
    {
      this.mDestroyed = false;
      this.SB = false;
      this.jwU = false;
      this.jwV = false;
      this.jwW = false;
      ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(134474);
      return;
    }
    finally
    {
      AppMethodBeat.o(134474);
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(134511);
    com.tencent.luggage.h.f.aC(com.tencent.mm.sdk.f.a.jq(this.mContext));
    R(null);
    AppMethodBeat.o(134511);
  }
  
  protected final void d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 1;
    AppMethodBeat.i(134477);
    if (!this.mInitialized)
    {
      ad.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramAppBrandInitConfig });
      if ((!isDestroyed()) && (!this.SB))
      {
        ad.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { this.mAppId });
        a(paramAppBrandInitConfig, "dispatchNewConfigBeforeInitialized");
      }
      AppMethodBeat.o(134477);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
    int i;
    if (paramAppBrandInitConfig != null) {
      if (this.jwW)
      {
        this.jwW = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        aWg();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(134477);
      return;
      i = j;
      if (paramAppBrandInitConfig.dPf == this.jwG.dPf)
      {
        i = j;
        if (paramAppBrandInitConfig.jXr == this.jwG.jXr) {
          i = 0;
        }
      }
    }
  }
  
  final void dispatchDestroy()
  {
    AppMethodBeat.i(176506);
    boolean bool = isDestroyed();
    ad.i("MicroMsg.AppBrandRuntime", "dispatchDestroy, finished?[%b] initialized?[%b]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.mInitialized) });
    if (bool)
    {
      AppMethodBeat.o(176506);
      return;
    }
    try
    {
      this.mDestroyed = true;
      onDestroy();
      ao localao = this.jwE;
      ??? = localao.jBq.iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)???).next()).dead();
      }
      localObject1.jBq.clear();
    }
    finally
    {
      AppMethodBeat.o(176506);
    }
    this.jwN = null;
    com.tencent.mm.plugin.appbrand.media.a.a.Pj(this.mAppId);
    AppBrandMainProcessService.b(this.jxi);
    g.Ko(this.mAppId);
    g.a(this.mAppId, g.b.jwj);
    com.tencent.luggage.h.f.aC(com.tencent.mm.sdk.f.a.jq(this.mContext));
    ??? = this.jwS;
    ??? = ((com.tencent.mm.plugin.appbrand.a.c)???).jKT;
    if (!((com.tencent.mm.plugin.appbrand.a.d)???).jLc.get()) {
      ad.printErrStackTrace(((com.tencent.mm.plugin.appbrand.a.d)???).TAG, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
    }
    for (;;)
    {
      synchronized (((com.tencent.mm.plugin.appbrand.a.c)???).jKU)
      {
        ((com.tencent.mm.plugin.appbrand.a.c)???).jKU.clear();
        this.jwX = null;
        ??? = com.tencent.mm.plugin.appbrand.o.f.bti();
        ??? = this.mAppId;
        if (((com.tencent.mm.plugin.appbrand.o.f)???).lVG.containsKey(???)) {
          ??? = (com.tencent.mm.plugin.appbrand.o.d)((com.tencent.mm.plugin.appbrand.o.f)???).lVG.remove(???);
        }
        synchronized (((com.tencent.mm.plugin.appbrand.o.d)???).lVI)
        {
          ((com.tencent.mm.plugin.appbrand.o.d)???).lVI.clear();
          ((com.tencent.mm.plugin.appbrand.o.d)???).lVK.clear();
          ((com.tencent.mm.plugin.appbrand.o.d)???).lVJ.clear();
          ??? = com.tencent.mm.plugin.appbrand.o.c.btf();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.o.c)???).lVG.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.o.b)((com.tencent.mm.plugin.appbrand.o.c)???).lVG.remove(???)).release();
          }
          ??? = com.tencent.mm.plugin.appbrand.o.i.btk();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.o.i)???).lVG.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.o.g)((com.tencent.mm.plugin.appbrand.o.i)???).lVG.remove(???)).release();
          }
          ??? = l.btn();
          ??? = this.mAppId;
          if (((l)???).lVG.containsKey(???))
          {
            ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((l)???).lVG.remove(???);
            if (??? != null) {
              ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
            }
          }
          g.Kt(this.mAppId);
          this.jwJ.setOnHierarchyChangeListener(null);
          this.jwJ.removeAllViewsInLayout();
          this.iDP.My();
          this.jwM = null;
          if (this.jwL != null)
          {
            this.jwL.removeAllViews();
            this.jwL = null;
          }
          if (this.mInitialized)
          {
            this.jwH.cleanup();
            this.jwH = null;
            this.jwI.cleanup();
            this.jwI = null;
          }
          ??? = this.jxh;
          this.jxh = null;
          if ((??? == null) || (((Queue)???).isEmpty()))
          {
            ad.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { this.mAppId });
            this.jwO.clear();
          }
        }
      }
      synchronized (this.jwP)
      {
        this.jwP.clear();
        this.jwQ.unregisterAll();
        this.jxk.clear();
        this.jwD.removeCallbacksAndMessages(null);
        this.jxj.stopTimer();
        this.jxl.clear();
        x.af(this);
        AppMethodBeat.o(176506);
        return;
        ((com.tencent.mm.plugin.appbrand.a.d)???).jLd.set(true);
        if (((com.tencent.mm.plugin.appbrand.a.d)???).bbf())
        {
          ad.e(((com.tencent.mm.plugin.appbrand.a.d)???).TAG, "stop() called, but still isInConstruction");
          ((com.tencent.mm.plugin.appbrand.a.d)???).quit();
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.a.d)???).a(com.tencent.mm.plugin.appbrand.a.b.jKR);
          break;
          d.c localc = ((com.tencent.mm.sdk.d.d)???).IgU;
          if (localc != null) {
            d.c.f(localc);
          }
        }
        localObject3 = finally;
        AppMethodBeat.o(176506);
        throw localObject3;
        localObject5 = finally;
        AppMethodBeat.o(176506);
        throw localObject5;
        ad.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", new Object[] { Integer.valueOf(localObject3.size()), this.mAppId });
        if (localObject3.isEmpty()) {
          continue;
        }
        ((AppBrandRuntime.b)localObject3.poll()).interrupt();
      }
    }
  }
  
  public final void dispatchPause()
  {
    AppMethodBeat.i(176504);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(176504);
      return;
    }
    if (isDestroyed())
    {
      AppMethodBeat.o(176504);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.jwS.jKT.a(d.a.jLp);
    this.jwH.CY();
    this.jwI.onBackground();
    g.Kq(this.mAppId);
    g.a(this.mAppId, g.b.jwh);
    ad.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      bh.a(com.tencent.mm.sdk.platformtools.aj.getContext(), null);
      AppMethodBeat.o(176504);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
      AppMethodBeat.o(176504);
    }
  }
  
  final void dispatchResume()
  {
    AppMethodBeat.i(176508);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(176508);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((isDestroyed()) || (this.jwU))
    {
      this.mResumed = true;
      a(null, "");
      AppMethodBeat.o(176508);
      return;
    }
    this.mResumed = true;
    g.Ku(this.mAppId);
    g.Kr(this.mAppId);
    g.a(this.mAppId, g.b.jwg);
    boolean bool = this.jwV;
    Kx("onResume");
    this.jwI.onForeground();
    this.jwS.jKT.a(d.a.jLq, "onRuntimeResume");
    this.jwH.bw(bool);
    onResume();
    if (bool) {
      this.jwI.aw(aVW(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.d locald = this.jwR;
    ad.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      bh.a(com.tencent.mm.sdk.platformtools.aj.getContext(), locald.mOy);
      aWk();
      this.jwU = false;
      this.jwV = false;
      AppMethodBeat.o(176508);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] resume set callback", new Object[0]);
      }
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134507);
    super.finalize();
    this.jwD.removeCallbacksAndMessages(null);
    AppMethodBeat.o(134507);
  }
  
  public void finish()
  {
    AppMethodBeat.i(134508);
    if (isDestroyed())
    {
      ad.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(134508);
      return;
    }
    this.SB = true;
    com.tencent.luggage.h.f.aC(com.tencent.mm.sdk.f.a.jq(this.mContext));
    j(new AppBrandRuntime.7(this), 0L);
    AppMethodBeat.o(134508);
  }
  
  final void fy(boolean paramBoolean)
  {
    this.jxa = paramBoolean;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    AppMethodBeat.i(134482);
    com.tencent.mm.plugin.appbrand.config.a locala = (com.tencent.mm.plugin.appbrand.config.a)c(com.tencent.mm.plugin.appbrand.config.a.class, false);
    AppMethodBeat.o(134482);
    return locala;
  }
  
  public final Context getAppContext()
  {
    return this.mContext;
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(221144);
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(this.mContext);
    AppMethodBeat.o(221144);
    return localActivity;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.jwC == null)
    {
      ad.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(176502);
      return null;
    }
    com.tencent.mm.plugin.appbrand.r.a.c localc = this.jwC.getWindowAndroid();
    AppMethodBeat.o(176502);
    return localc;
  }
  
  public final boolean isDestroyed()
  {
    try
    {
      boolean bool = this.mDestroyed;
      return bool;
    }
    finally {}
  }
  
  public final boolean isFinishing()
  {
    return this.SB;
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(134479);
    if ((this.jwC != null) && (this.jwC.x(this)))
    {
      AppMethodBeat.o(134479);
      return true;
    }
    AppMethodBeat.o(134479);
    return false;
  }
  
  public final boolean isResumed()
  {
    return this.mResumed;
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(134520);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(134520);
      return;
    }
    if (isDestroyed())
    {
      ad.w("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134520);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    if ((aq.isMainThread()) && (0L == l))
    {
      paramRunnable.run();
      AppMethodBeat.o(134520);
      return;
    }
    paramRunnable = s.a(this.jwE, paramRunnable);
    keep(paramRunnable);
    this.jwD.postDelayed(paramRunnable, l);
    AppMethodBeat.o(134520);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(134473);
    this.jwE.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(197183);
    if (this.jwK == null)
    {
      if (this.iDP.onBackPressed())
      {
        AppMethodBeat.o(197183);
        return;
      }
      if (this.jwI != null)
      {
        this.jwI.onBackPressed();
        AppMethodBeat.o(197183);
      }
    }
    else
    {
      g.a(this.mAppId, g.d.jwm);
      finish();
    }
    AppMethodBeat.o(197183);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176503);
    Looper.myQueue().addIdleHandler(new AppBrandRuntime.21(this, paramConfiguration));
    if (this.jxb != null)
    {
      com.tencent.mm.plugin.appbrand.pip.f localf = this.jxb;
      ad.i(localf.crd, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (localf.mny != null)
      {
        paramConfiguration = localf.mny;
        ad.i(paramConfiguration.crd, "onConfigurationChanged");
        if (!paramConfiguration.mmu)
        {
          ad.d(paramConfiguration.crd, "onConfigurationChanged, false == mHandleStarted");
          AppMethodBeat.o(176503);
          return;
        }
        paramConfiguration.mmr.a(paramConfiguration.ckN, new b.1(paramConfiguration));
      }
    }
    AppMethodBeat.o(176503);
  }
  
  protected void onCreate()
  {
    AppMethodBeat.i(134501);
    AppMethodBeat.o(134501);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(134504);
    AppMethodBeat.o(134504);
  }
  
  protected void onPause() {}
  
  protected void onReady()
  {
    AppMethodBeat.i(197182);
    this.jwH.aYh().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.jwH.aYh().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(197182);
  }
  
  protected void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */