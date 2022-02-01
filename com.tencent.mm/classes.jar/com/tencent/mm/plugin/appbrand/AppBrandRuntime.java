package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.p.a.c;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w.f;
import com.tencent.mm.plugin.appbrand.pip.b.1;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x;

public class AppBrandRuntime
  implements com.tencent.mm.plugin.appbrand.utils.p<com.tencent.mm.vending.e.a>
{
  public volatile boolean SO;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e jCK;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<com.tencent.mm.plugin.appbrand.jsapi.m> kAA;
  public final au kAB;
  private final ConcurrentSkipListSet<aq> kAC;
  final av kAD;
  private final LinkedHashSet<n> kAE;
  private final z kAF;
  private com.tencent.mm.plugin.appbrand.utils.e kAG;
  public volatile com.tencent.mm.plugin.appbrand.a.c kAH;
  public com.tencent.mm.plugin.appbrand.p.a kAI;
  protected boolean kAJ;
  public boolean kAK;
  private boolean kAL;
  public ap kAM;
  public boolean kAN;
  public boolean kAO;
  public boolean kAP;
  public com.tencent.mm.plugin.appbrand.pip.f kAQ;
  private AppBrandPipContainerView kAR;
  private AppBrandGlobalNativeWidgetContainerView kAS;
  public j kAT;
  public boolean kAU;
  private LinkedList<b> kAV;
  ConcurrentLinkedQueue<b> kAW;
  private final AppBrandMainProcessService.a kAX;
  private final MTimerHandler kAY;
  private final Deque<Runnable> kAZ;
  public ak kAl;
  private com.tencent.mm.plugin.appbrand.platform.window.c kAm;
  private final MMHandler kAn;
  private final ba kAo;
  AppBrandRuntime kAp;
  public volatile AppBrandInitConfig kAq;
  private volatile s kAr;
  private volatile com.tencent.mm.plugin.appbrand.page.w kAs;
  public com.tencent.mm.plugin.appbrand.widget.c kAt;
  protected ab kAu;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e kAv;
  public com.tencent.mm.plugin.appbrand.ad.f kAw;
  public com.tencent.mm.plugin.appbrand.page.capsulebar.e kAx;
  private volatile Boolean kAy;
  private volatile q kAz;
  public SparseArray<Set<al>> kBa;
  public volatile String mAppId;
  public Context mContext;
  private boolean mDestroyed;
  public volatile boolean mInitialized;
  public boolean mResumed;
  
  private AppBrandRuntime(Context paramContext)
  {
    AppMethodBeat.i(219196);
    this.kAy = null;
    this.kAz = null;
    this.kAA = new ConcurrentLinkedDeque() {};
    this.kAB = new au();
    this.kAC = new ConcurrentSkipListSet(new Comparator() {});
    this.kAD = new av();
    this.kAE = new LinkedHashSet();
    this.kAF = new z();
    this.mResumed = false;
    this.kAN = false;
    this.kAO = true;
    this.kAU = false;
    this.kAV = new LinkedList();
    this.kAW = null;
    this.kAX = new AppBrandMainProcessService.a()
    {
      private volatile boolean kBf = false;
      
      public final void Uf(String paramAnonymousString)
      {
        AppMethodBeat.i(219186);
        if (this.kBf) {
          AppBrandRuntime.s(AppBrandRuntime.this);
        }
        this.kBf = false;
        AppMethodBeat.o(219186);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        this.kBf = true;
      }
    };
    this.kAY = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(219188);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppBrandRuntime.this.bru();
        AppMethodBeat.o(219188);
        return false;
      }
    }, false);
    this.kAZ = new LinkedBlockingDeque();
    this.kBa = new SparseArray();
    this.mContext = paramContext;
    this.kAn = new MMHandler(Looper.getMainLooper());
    this.kAo = new ba();
    this.kAt = new com.tencent.mm.plugin.appbrand.widget.c(this.mContext);
    this.kAt.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jCK = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.kAv = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.kAG = new com.tencent.mm.plugin.appbrand.utils.e();
    this.kAP = false;
    AppMethodBeat.o(219196);
  }
  
  public AppBrandRuntime(ak paramak)
  {
    this(paramak.getContext());
    AppMethodBeat.i(176500);
    this.kAl = paramak;
    this.kAm = null;
    AppMethodBeat.o(176500);
  }
  
  protected AppBrandRuntime(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this(paramc.getContext());
    AppMethodBeat.i(219197);
    this.kAl = null;
    this.kAm = paramc;
    AppMethodBeat.o(219197);
  }
  
  private void brA()
  {
    AppMethodBeat.i(134500);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitService", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134448);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit_Game);
        AppBrandRuntime.p(AppBrandRuntime.this).init();
        AppMethodBeat.o(134448);
      }
    });
    AppMethodBeat.o(134500);
  }
  
  private void brz()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitPageContainer", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134447);
        AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.brx());
        AppBrandRuntime.n(AppBrandRuntime.this).setOnReadyListener(new w.f()
        {
          public final void brP()
          {
            AppMethodBeat.i(176492);
            AppBrandRuntime.m(AppBrandRuntime.this);
            AppBrandRuntime.a(AppBrandRuntime.this, null);
            AppMethodBeat.o(176492);
          }
        });
        az.kFK.a(AppBrandRuntime.this, AppBrandRuntime.n(AppBrandRuntime.this));
        AppBrandRuntime.n(AppBrandRuntime.this).init(AppBrandRuntime.o(AppBrandRuntime.this).kHw);
        AppMethodBeat.o(134447);
      }
    });
    AppMethodBeat.o(134499);
  }
  
  protected boolean N(Runnable paramRunnable)
  {
    return false;
  }
  
  public s NY()
  {
    return this.kAr;
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.SO) || (isDestroyed()))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134518);
      return;
    }
    if (this.mInitialized)
    {
      i(paramRunnable, 0L);
      AppMethodBeat.o(134518);
      return;
    }
    this.kAZ.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  protected q OL()
  {
    AppMethodBeat.i(134486);
    com.tencent.mm.plugin.appbrand.appstorage.w localw = new com.tencent.mm.plugin.appbrand.appstorage.w(this);
    AppMethodBeat.o(134486);
    return localw;
  }
  
  protected void OO() {}
  
  protected com.tencent.mm.plugin.appbrand.p.a OR()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public com.tencent.mm.plugin.appbrand.config.l OT()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.l locall = (com.tencent.mm.plugin.appbrand.config.l)av(com.tencent.mm.plugin.appbrand.config.l.class);
    AppMethodBeat.o(134481);
    return locall;
  }
  
  public AppBrandInitConfig OU()
  {
    return this.kAq;
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(258638);
    i(paramRunnable, 0L);
    AppMethodBeat.o(258638);
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(219211);
    if (isDestroyed())
    {
      AppMethodBeat.o(219211);
      return;
    }
    paramRunnable = u.a(this.kAo, paramRunnable);
    keep(paramRunnable);
    com.tencent.f.h.RTc.o(paramRunnable, 0L);
    AppMethodBeat.o(219211);
  }
  
  public final void R(final Object paramObject)
  {
    AppMethodBeat.i(176509);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219185);
        if ((!AppBrandRuntime.this.mInitialized) || (AppBrandRuntime.this.isDestroyed()))
        {
          if (AppBrandRuntime.r(AppBrandRuntime.this) == null)
          {
            AppBrandRuntime.this.dispatchDestroy();
            AppMethodBeat.o(219185);
            return;
          }
          AppBrandRuntime.r(AppBrandRuntime.this).w(AppBrandRuntime.this);
          AppMethodBeat.o(219185);
          return;
        }
        if (AppBrandRuntime.r(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchPause();
          AppMethodBeat.o(219185);
          return;
        }
        AppBrandRuntime.r(AppBrandRuntime.this).a(AppBrandRuntime.this, paramObject);
        AppMethodBeat.o(219185);
      }
    }, 0L);
    AppMethodBeat.o(176509);
  }
  
  protected <T extends com.tencent.mm.kernel.c.a> T V(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final al paramal)
  {
    AppMethodBeat.i(178506);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134457);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
        paramal.kEW = paramInt2;
        paramal.kEV = paramInt1;
        int i;
        if (AppBrandRuntime.t(AppBrandRuntime.this).get(paramal.kEV) != null)
        {
          i = 1;
          if (i == 0) {
            break label125;
          }
        }
        label125:
        for (Object localObject = (Set)AppBrandRuntime.t(AppBrandRuntime.this).get(paramal.kEV);; localObject = new CopyOnWriteArraySet())
        {
          ((Set)localObject).add(paramal);
          if (i == 0) {
            AppBrandRuntime.t(AppBrandRuntime.this).put(paramal.kEV, localObject);
          }
          AppMethodBeat.o(134457);
          return;
          i = 0;
          break;
        }
      }
    }, 0L);
    AppMethodBeat.o(178506);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(134476);
    this.kAV.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ak paramak)
  {
    AppMethodBeat.i(219198);
    this.kAl = paramak;
    if (this.kAl != null)
    {
      this.kAB.b(this.kAl);
      AppMethodBeat.o(219198);
      return;
    }
    this.kAB.btq();
    AppMethodBeat.o(219198);
  }
  
  public final void a(final al paramal)
  {
    AppMethodBeat.i(134522);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176497);
        Set localSet = (Set)AppBrandRuntime.t(AppBrandRuntime.this).get(paramal.kEV);
        if (localSet != null) {
          localSet.remove(paramal);
        }
        AppMethodBeat.o(176497);
      }
    }, 0L);
    AppMethodBeat.o(134522);
  }
  
  protected final void a(aq paramaq)
  {
    AppMethodBeat.i(219203);
    if (this.mInitialized)
    {
      paramaq.btr();
      AppMethodBeat.o(219203);
      return;
    }
    this.kAC.add(paramaq);
    AppMethodBeat.o(219203);
  }
  
  protected final void a(aw paramaw)
  {
    AppMethodBeat.i(219204);
    av localav = this.kAD;
    if (localav.kFB.get())
    {
      AppMethodBeat.o(219204);
      return;
    }
    localav.kFA.add(paramaw);
    AppMethodBeat.o(219204);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.kAq = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(219207);
    if (!this.mResumed)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", new Object[] { this.mAppId, paramString });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.kAq = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(219207);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", new Object[] { this.mAppId, paramString, android.util.Log.getStackTraceString(new Throwable()) });
    dispatchPause();
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      brd();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(219207);
      return;
      paramAppBrandInitConfig = OU();
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this.kAm = paramc;
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.kAo.a(parama);
    AppMethodBeat.o(160924);
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(134493);
    if (paramn == null)
    {
      AppMethodBeat.o(134493);
      return false;
    }
    synchronized (this.kAE)
    {
      this.kAE.add(paramn);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T af(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.kAF.ap(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.g.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.g.olr);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    paramClass = V(paramClass);
    AppMethodBeat.o(134494);
    return paramClass;
  }
  
  public final void ag(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(134496);
    this.kAF.ag(paramClass);
    AppMethodBeat.o(134496);
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T av(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.kAU) {}
    for (boolean bool = true;; bool = false)
    {
      paramClass = d(paramClass, bool);
      AppMethodBeat.o(134491);
      return paramClass;
    }
  }
  
  public final <T extends n> T aw(Class<T> paramClass)
  {
    AppMethodBeat.i(134492);
    if (paramClass == null)
    {
      AppMethodBeat.o(134492);
      return null;
    }
    synchronized (this.kAE)
    {
      Iterator localIterator = this.kAE.iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)localIterator.next();
        if (paramClass.isInstance(localn))
        {
          AppMethodBeat.o(134492);
          return localn;
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
  
  public final void b(com.tencent.mm.plugin.appbrand.config.b paramb)
  {
    AppMethodBeat.i(134483);
    this.kAA.add(paramb);
    AppMethodBeat.o(134483);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(134495);
    this.kAF.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(219201);
    if (paramn == null)
    {
      AppMethodBeat.o(219201);
      return false;
    }
    synchronized (this.kAE)
    {
      this.kAE.remove(paramn);
      AppMethodBeat.o(219201);
      return true;
    }
  }
  
  protected void brB() {}
  
  protected final void brC()
  {
    AppMethodBeat.i(134513);
    this.kAJ = true;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  protected final boolean brD()
  {
    return this.kAJ;
  }
  
  protected final void brE()
  {
    AppMethodBeat.i(219208);
    if (this.kAJ)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
      AppMethodBeat.o(219208);
      return;
    }
    this.kAK = true;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(219208);
  }
  
  protected final boolean brF()
  {
    return this.kAK;
  }
  
  public final boolean brG()
  {
    AppMethodBeat.i(134514);
    if (!this.kAO)
    {
      AppMethodBeat.o(134514);
      return false;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      AppMethodBeat.o(134514);
      return false;
    }
    if ((this.kAs != null) && (this.kAs.getCurrentPage() != null) && (!this.kAs.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  final void brH()
  {
    AppMethodBeat.i(134515);
    this.kAH.kQM.a(d.a.kRn);
    h.TW(this.mAppId);
    AppMethodBeat.o(134515);
  }
  
  public void brI()
  {
    AppMethodBeat.i(176510);
    Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134456);
        final com.tencent.mm.plugin.appbrand.platform.window.c localc = AppBrandRuntime.this.getWindowAndroid();
        if (localc == null)
        {
          AppMethodBeat.o(134456);
          return;
        }
        Object localObject = AppBrandRuntime.this.getAppConfig();
        if (localObject == null) {}
        int i;
        for (localObject = new com.tencent.mm.plugin.appbrand.platform.window.c.a(AppBrandRuntime.this.OU().brandName);; localObject = new com.tencent.mm.plugin.appbrand.platform.window.c.a(AppBrandRuntime.this.OU().brandName, null, i))
        {
          localc.setWindowDescription((com.tencent.mm.plugin.appbrand.platform.window.c.a)localObject);
          com.tencent.mm.modelappbrand.a.b.aXY().a(new b.c()
          {
            public final void I(Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(219189);
              localc.setWindowDescription(new com.tencent.mm.plugin.appbrand.platform.window.c.a(this.kBh.label, paramAnonymous2Bitmap, this.kBh.colorPrimary));
              AppMethodBeat.o(219189);
            }
          }, AppBrandRuntime.this.OU().iconUrl, com.tencent.mm.modelappbrand.a.g.iJB);
          AppMethodBeat.o(134456);
          return;
          i = com.tencent.mm.plugin.appbrand.ac.g.cu(((com.tencent.mm.plugin.appbrand.config.b)localObject).bzF().lci, -16777216);
        }
      }
    });
    AppMethodBeat.o(176510);
  }
  
  public boolean brJ()
  {
    AppMethodBeat.i(134517);
    if (this.kAH.kQM.bwY() == com.tencent.mm.plugin.appbrand.a.b.kQJ) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      AppMethodBeat.o(134517);
      return true;
    }
    AppMethodBeat.o(134517);
    return false;
  }
  
  protected ab brK()
  {
    return this.kAu;
  }
  
  public final boolean brL()
  {
    AppMethodBeat.i(219212);
    if (this.kAy == null) {
      this.kAy = Boolean.valueOf(((k)com.tencent.luggage.a.e.M(k.class)).H(this));
    }
    boolean bool = this.kAy.booleanValue();
    AppMethodBeat.o(219212);
    return bool;
  }
  
  public final boolean brM()
  {
    AppMethodBeat.i(219213);
    if ((this.kAu instanceof ac)) {}
    for (boolean bool = ((ac)this.kAu).brM();; bool = false)
    {
      String str2 = this.mAppId;
      if (this.kAu == null) {}
      for (String str1 = "null";; str1 = this.kAu.getClass().getSimpleName())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
        AppMethodBeat.o(219213);
        return bool;
      }
    }
  }
  
  public final void brN()
  {
    this.kAu = null;
  }
  
  public final void brO()
  {
    this.kAP = true;
  }
  
  public final void brd()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    long l = Util.currentTicks();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    bre();
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219191);
        AppBrandRuntime.f(AppBrandRuntime.this);
        AppMethodBeat.o(219191);
      }
    });
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134463);
        AppBrandRuntime.a(AppBrandRuntime.this, new AppBrandRuntime.c(AppBrandRuntime.this, (byte)0));
        AppMethodBeat.o(134463);
      }
    });
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134464);
        AppBrandRuntime.this.brp();
        AppMethodBeat.o(134464);
      }
    });
    this.kAY.startTimer(10000L);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(Util.currentTicks() - l) });
    AppMethodBeat.o(134475);
  }
  
  protected void bre() {}
  
  public final int brf()
  {
    return this.kAq.eix;
  }
  
  public final AppBrandRuntime brg()
  {
    AppMethodBeat.i(134478);
    if (this.kAl == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.kAl.u(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public com.tencent.mm.plugin.appbrand.page.w brh()
  {
    return this.kAs;
  }
  
  public final ak bri()
  {
    return this.kAl;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.c brj()
  {
    return this.kAt;
  }
  
  public void brk() {}
  
  public final com.tencent.mm.plugin.appbrand.a.c brl()
  {
    return this.kAH;
  }
  
  public final void brm()
  {
    AppMethodBeat.i(134485);
    if (this.kAz == null) {
      this.kAz = OL();
    }
    AppMethodBeat.o(134485);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m brn()
  {
    return this.kAv;
  }
  
  protected ab bro()
  {
    return null;
  }
  
  protected final void brp()
  {
    AppMethodBeat.i(134487);
    if (this.kAu != null)
    {
      com.tencent.mm.plugin.appbrand.ui.l.a(this.kAu);
      this.kAu = null;
    }
    Object localObject = bro();
    if (localObject == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    ((ab)localObject).eo(OU().iconUrl, OU().brandName);
    final View localView = ((ab)localObject).getView();
    az.kFQ.a(this, localView);
    this.kAu = ((ab)localObject);
    String str = this.mAppId;
    if (this.kAu == null) {}
    for (localObject = "null";; localObject = this.kAu.getClass().getSimpleName())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", new Object[] { str, localObject });
      localView.setClickable(true);
      this.kAt.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2) {}
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(219195);
          if ((paramAnonymousView2 == localView) && (!AppBrandRuntime.this.isDestroyed()))
          {
            paramAnonymousView1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219194);
                if (AppBrandRuntime.this.mResumed)
                {
                  AppBrandRuntime.this.brh().setActuallyVisible(true);
                  AppMethodBeat.o(219194);
                  return;
                }
                AppBrandRuntime.this.kAH.a(new com.tencent.mm.plugin.appbrand.a.c.a()
                {
                  public final void a(String paramAnonymous3String, com.tencent.mm.plugin.appbrand.a.b paramAnonymous3b)
                  {
                    AppMethodBeat.i(219193);
                    if (com.tencent.mm.plugin.appbrand.a.b.kQH == paramAnonymous3b)
                    {
                      AppBrandRuntime.this.brh().setActuallyVisible(true);
                      AppBrandRuntime.this.kAH.b(this);
                    }
                    AppMethodBeat.o(219193);
                  }
                });
                AppMethodBeat.o(219194);
              }
            };
            AppBrandRuntime.this.brq();
            if (AppBrandRuntime.this.brh() == null)
            {
              AppBrandRuntime.this.O(paramAnonymousView1);
              AppMethodBeat.o(219195);
              return;
            }
            paramAnonymousView1.run();
          }
          AppMethodBeat.o(219195);
        }
      });
      AppMethodBeat.o(134487);
      return;
    }
  }
  
  protected void brq() {}
  
  public final void brr()
  {
    AppMethodBeat.i(134488);
    if (isDestroyed())
    {
      if (this.kAu != null) {
        com.tencent.mm.plugin.appbrand.ui.l.a(this.kAu);
      }
      this.kAu = null;
      AppMethodBeat.o(134488);
      return;
    }
    if (this.kAu == null)
    {
      AppMethodBeat.o(134488);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.printInfoStack("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", new Object[] { this.kAu.getClass().getSimpleName() });
    kotlin.g.a.a local23 = new kotlin.g.a.a() {};
    if ((this.kAu instanceof af))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "[weishi] hideSplash, hideLoadingSplashFromRuntime");
      ((af)this.kAu).B(local23);
      AppMethodBeat.o(134488);
      return;
    }
    this.kAu.z(local23);
    AppMethodBeat.o(134488);
  }
  
  public final String brs()
  {
    AppMethodBeat.i(134489);
    if (this.kAq == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (Util.isNullOrNil(this.kAq.kHw))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().bzI();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.kAq.kHw;
    AppMethodBeat.o(134489);
    return str;
  }
  
  public final boolean brt()
  {
    return this.mInitialized;
  }
  
  protected void bru()
  {
    AppMethodBeat.i(219202);
    this.kAD.bru();
    AppMethodBeat.o(219202);
  }
  
  protected void brv() {}
  
  protected s brw()
  {
    AppMethodBeat.i(134497);
    s locals = new s();
    AppMethodBeat.o(134497);
    return locals;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.w brx()
  {
    AppMethodBeat.i(134498);
    com.tencent.mm.plugin.appbrand.page.w localw = new com.tencent.mm.plugin.appbrand.page.w(this.mContext, this);
    AppMethodBeat.o(134498);
    return localw;
  }
  
  public boolean bry()
  {
    return false;
  }
  
  protected final void c(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134474);
    if (paramAppBrandInitConfig == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      AppMethodBeat.o(134474);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", new Object[] { paramAppBrandInitConfig });
    this.kAq = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.kAH = new com.tencent.mm.plugin.appbrand.a.c(this);
    this.kAH.kQM.start();
    this.kAH.a(new com.tencent.mm.plugin.appbrand.a.c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(219190);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntime.this;
        HashMap localHashMap = new HashMap();
        switch (com.tencent.mm.plugin.appbrand.page.p.1.kRf[paramAnonymousb.ordinal()])
        {
        default: 
          AppMethodBeat.o(219190);
          return;
        case 1: 
          paramAnonymousString = "background";
        }
        for (;;)
        {
          localHashMap.put("status", paramAnonymousString);
          new com.tencent.mm.plugin.appbrand.page.p().K(localHashMap).g(localAppBrandRuntime.NY()).bEo();
          AppMethodBeat.o(219190);
          return;
          paramAnonymousString = "active";
          continue;
          paramAnonymousString = "suspend";
        }
      }
    });
    this.mInitialized = false;
    try
    {
      this.mDestroyed = false;
      this.SO = false;
      this.kAJ = false;
      this.kAK = false;
      this.kAL = false;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { this.mAppId });
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
    com.tencent.luggage.h.g.aM(AndroidContextUtil.castActivityOrNull(this.mContext));
    R(null);
    AppMethodBeat.o(134511);
  }
  
  public final void ct(View paramView)
  {
    AppMethodBeat.i(219200);
    az.kFO.a(this, paramView);
    AppMethodBeat.o(219200);
  }
  
  /* Error */
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T d(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1470
    //   3: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 194	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAA	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1475	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 518 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 522 1 0
    //   38: checkcast 1477	com/tencent/mm/plugin/appbrand/jsapi/m
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1177	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1483	org/a/a:bF	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1487	org/a/a:hPX	()Lorg/a/a;
    //   65: getfield 1491	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1477	com/tencent/mm/plugin/appbrand/jsapi/m
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 194	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAA	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 1186 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1470
    //   99: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 362
    //   109: ldc_w 1493
    //   112: iconst_1
    //   113: anewarray 5	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1496	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 668	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   20	83	3	localm1	com.tencent.mm.plugin.appbrand.jsapi.m
    //   129	1	3	localException1	java.lang.Exception
    //   132	1	3	localException2	java.lang.Exception
    //   7	87	4	localm2	com.tencent.mm.plugin.appbrand.jsapi.m
    //   104	27	4	localException3	java.lang.Exception
    //   16	16	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   58	73	104	java/lang/Exception
    //   81	93	129	java/lang/Exception
  }
  
  protected final void d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 1;
    AppMethodBeat.i(134477);
    if (!this.mInitialized)
    {
      if ((!isDestroyed()) && (!this.SO))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] config[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { this.mAppId, paramAppBrandInitConfig });
        a(paramAppBrandInitConfig, "dispatchNewConfigBeforeInitialized");
        AppMethodBeat.o(134477);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig FATAL!! appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
      AppMethodBeat.o(134477);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
    int i;
    if (paramAppBrandInitConfig != null) {
      if (this.kAL)
      {
        this.kAL = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        brC();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(134477);
      return;
      i = j;
      if (paramAppBrandInitConfig.eix == this.kAq.eix)
      {
        i = j;
        if (paramAppBrandInitConfig.ldK == this.kAq.ldK) {
          i = 0;
        }
      }
    }
  }
  
  /* Error */
  final void dispatchDestroy()
  {
    // Byte code:
    //   0: ldc_w 1516
    //   3: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 652	com/tencent/mm/plugin/appbrand/AppBrandRuntime:isDestroyed	()Z
    //   10: istore_1
    //   11: ldc_w 362
    //   14: ldc_w 1518
    //   17: iconst_2
    //   18: anewarray 5	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 837	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 654	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   34: invokestatic 837	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iload_1
    //   42: ifeq +10 -> 52
    //   45: ldc_w 1516
    //   48: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: aload_0
    //   53: monitorenter
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 1448	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mDestroyed	Z
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_0
    //   62: getfield 237	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAW	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   65: astore_2
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 237	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAW	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   71: aload_2
    //   72: ifnull +12 -> 84
    //   75: aload_2
    //   76: invokeinterface 1521 1 0
    //   81: ifeq +79 -> 160
    //   84: ldc_w 362
    //   87: ldc_w 1523
    //   90: iconst_1
    //   91: anewarray 5	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_0
    //   105: invokevirtual 1526	com/tencent/mm/plugin/appbrand/AppBrandRuntime:onDestroy	()V
    //   108: aload_0
    //   109: getfield 278	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAo	Lcom/tencent/mm/plugin/appbrand/ba;
    //   112: astore_2
    //   113: aload_2
    //   114: getfield 1530	com/tencent/mm/plugin/appbrand/ba:kFT	Ljava/util/Set;
    //   117: invokeinterface 1533 1 0
    //   122: astore_3
    //   123: aload_3
    //   124: invokeinterface 518 1 0
    //   129: ifeq +87 -> 216
    //   132: aload_3
    //   133: invokeinterface 522 1 0
    //   138: checkcast 1535	com/tencent/mm/vending/e/a
    //   141: invokeinterface 1538 1 0
    //   146: goto -23 -> 123
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: ldc_w 1516
    //   155: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: athrow
    //   160: ldc_w 362
    //   163: ldc_w 1540
    //   166: iconst_2
    //   167: anewarray 5	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_2
    //   173: invokeinterface 1543 1 0
    //   178: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_0
    //   185: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_2
    //   193: invokeinterface 1521 1 0
    //   198: ifne -94 -> 104
    //   201: aload_2
    //   202: invokeinterface 1546 1 0
    //   207: checkcast 70	com/tencent/mm/plugin/appbrand/AppBrandRuntime$b
    //   210: invokevirtual 1549	com/tencent/mm/plugin/appbrand/AppBrandRuntime$b:interrupt	()V
    //   213: goto -21 -> 192
    //   216: aload_2
    //   217: getfield 1530	com/tencent/mm/plugin/appbrand/ba:kFT	Ljava/util/Set;
    //   220: invokeinterface 1552 1 0
    //   225: aload_0
    //   226: aconst_null
    //   227: putfield 189	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAz	Lcom/tencent/mm/plugin/appbrand/appstorage/q;
    //   230: aload_0
    //   231: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   234: invokestatic 1555	com/tencent/mm/plugin/appbrand/media/a/a:Zl	(Ljava/lang/String;)V
    //   237: aload_0
    //   238: getfield 240	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAX	Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandMainProcessService$a;
    //   241: invokestatic 1557	com/tencent/mm/plugin/appbrand/ipc/AppBrandMainProcessService:b	(Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandMainProcessService$a;)V
    //   244: aload_0
    //   245: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   248: invokestatic 1560	com/tencent/mm/plugin/appbrand/h:TV	(Ljava/lang/String;)V
    //   251: aload_0
    //   252: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   255: getstatic 1563	com/tencent/mm/plugin/appbrand/h$b:kzN	Lcom/tencent/mm/plugin/appbrand/h$b;
    //   258: invokestatic 642	com/tencent/mm/plugin/appbrand/h:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/h$b;)V
    //   261: aload_0
    //   262: getfield 266	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mContext	Landroid/content/Context;
    //   265: invokestatic 1217	com/tencent/mm/sdk/system/AndroidContextUtil:castActivityOrNull	(Landroid/content/Context;)Landroid/app/Activity;
    //   268: invokestatic 1460	com/tencent/luggage/h/g:aM	(Landroid/content/Context;)Z
    //   271: pop
    //   272: aload_0
    //   273: getfield 606	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAH	Lcom/tencent/mm/plugin/appbrand/a/c;
    //   276: astore_3
    //   277: aload_3
    //   278: getfield 612	com/tencent/mm/plugin/appbrand/a/c:kQM	Lcom/tencent/mm/plugin/appbrand/a/d;
    //   281: invokevirtual 1566	com/tencent/mm/plugin/appbrand/a/d:stop	()V
    //   284: aload_3
    //   285: getfield 1570	com/tencent/mm/plugin/appbrand/a/c:kQN	Landroid/support/v4/e/a;
    //   288: astore_2
    //   289: aload_2
    //   290: monitorenter
    //   291: aload_3
    //   292: getfield 1570	com/tencent/mm/plugin/appbrand/a/c:kQN	Landroid/support/v4/e/a;
    //   295: invokevirtual 1573	android/support/v4/e/a:clear	()V
    //   298: aload_2
    //   299: monitorexit
    //   300: aload_0
    //   301: aconst_null
    //   302: putfield 1575	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAM	Lcom/tencent/mm/plugin/appbrand/ap;
    //   305: invokestatic 1581	com/tencent/mm/plugin/appbrand/s/f:bPA	()Lcom/tencent/mm/plugin/appbrand/s/f;
    //   308: astore_2
    //   309: aload_0
    //   310: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   313: astore_3
    //   314: aload_2
    //   315: getfield 1585	com/tencent/mm/plugin/appbrand/s/f:nhY	Ljava/util/HashMap;
    //   318: aload_3
    //   319: invokevirtual 1590	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   322: ifeq +49 -> 371
    //   325: aload_2
    //   326: getfield 1585	com/tencent/mm/plugin/appbrand/s/f:nhY	Ljava/util/HashMap;
    //   329: aload_3
    //   330: invokevirtual 1592	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   333: checkcast 1594	com/tencent/mm/plugin/appbrand/s/d
    //   336: astore_3
    //   337: aload_3
    //   338: getfield 1598	com/tencent/mm/plugin/appbrand/s/d:nia	Ljava/util/ArrayList;
    //   341: astore_2
    //   342: aload_2
    //   343: monitorenter
    //   344: aload_3
    //   345: getfield 1598	com/tencent/mm/plugin/appbrand/s/d:nia	Ljava/util/ArrayList;
    //   348: invokevirtual 1601	java/util/ArrayList:clear	()V
    //   351: aload_2
    //   352: monitorexit
    //   353: aload_3
    //   354: getfield 1604	com/tencent/mm/plugin/appbrand/s/d:nic	Ljava/util/Set;
    //   357: invokeinterface 1552 1 0
    //   362: aload_3
    //   363: getfield 1607	com/tencent/mm/plugin/appbrand/s/d:nib	Ljava/util/Set;
    //   366: invokeinterface 1552 1 0
    //   371: invokestatic 1613	com/tencent/mm/plugin/appbrand/s/c:bPx	()Lcom/tencent/mm/plugin/appbrand/s/c;
    //   374: astore_2
    //   375: aload_0
    //   376: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   379: astore_3
    //   380: aload_2
    //   381: getfield 1614	com/tencent/mm/plugin/appbrand/s/c:nhY	Ljava/util/HashMap;
    //   384: aload_3
    //   385: invokevirtual 1590	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   388: ifeq +100 -> 488
    //   391: aload_2
    //   392: getfield 1614	com/tencent/mm/plugin/appbrand/s/c:nhY	Ljava/util/HashMap;
    //   395: aload_3
    //   396: invokevirtual 1592	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   399: checkcast 1616	com/tencent/mm/plugin/appbrand/s/b
    //   402: astore_3
    //   403: aload_3
    //   404: getfield 1619	com/tencent/mm/plugin/appbrand/s/b:nhU	Ljava/util/ArrayList;
    //   407: astore_2
    //   408: aload_2
    //   409: monitorenter
    //   410: aload_3
    //   411: getfield 1619	com/tencent/mm/plugin/appbrand/s/b:nhU	Ljava/util/ArrayList;
    //   414: invokevirtual 1620	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   417: astore 4
    //   419: aload 4
    //   421: invokeinterface 518 1 0
    //   426: ifeq +53 -> 479
    //   429: aload 4
    //   431: invokeinterface 522 1 0
    //   436: checkcast 1622	com/tencent/mm/plugin/appbrand/s/a/b
    //   439: iconst_0
    //   440: putfield 1625	com/tencent/mm/plugin/appbrand/s/a/b:isRunning	Z
    //   443: goto -24 -> 419
    //   446: astore_3
    //   447: aload_2
    //   448: monitorexit
    //   449: ldc_w 1516
    //   452: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: aload_3
    //   456: athrow
    //   457: astore_3
    //   458: aload_2
    //   459: monitorexit
    //   460: ldc_w 1516
    //   463: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   466: aload_3
    //   467: athrow
    //   468: astore_3
    //   469: aload_2
    //   470: monitorexit
    //   471: ldc_w 1516
    //   474: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: aload_3
    //   478: athrow
    //   479: aload_3
    //   480: getfield 1619	com/tencent/mm/plugin/appbrand/s/b:nhU	Ljava/util/ArrayList;
    //   483: invokevirtual 1601	java/util/ArrayList:clear	()V
    //   486: aload_2
    //   487: monitorexit
    //   488: invokestatic 1631	com/tencent/mm/plugin/appbrand/s/i:bPC	()Lcom/tencent/mm/plugin/appbrand/s/i;
    //   491: astore_2
    //   492: aload_0
    //   493: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   496: astore_3
    //   497: aload_2
    //   498: getfield 1632	com/tencent/mm/plugin/appbrand/s/i:nhY	Ljava/util/HashMap;
    //   501: aload_3
    //   502: invokevirtual 1590	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   505: ifeq +78 -> 583
    //   508: aload_2
    //   509: getfield 1632	com/tencent/mm/plugin/appbrand/s/i:nhY	Ljava/util/HashMap;
    //   512: aload_3
    //   513: invokevirtual 1592	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   516: checkcast 1634	com/tencent/mm/plugin/appbrand/s/g
    //   519: astore_3
    //   520: aload_3
    //   521: getfield 1637	com/tencent/mm/plugin/appbrand/s/g:niD	Ljava/util/ArrayList;
    //   524: astore_2
    //   525: aload_2
    //   526: monitorenter
    //   527: aload_3
    //   528: getfield 1637	com/tencent/mm/plugin/appbrand/s/g:niD	Ljava/util/ArrayList;
    //   531: invokevirtual 1620	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   534: astore 4
    //   536: aload 4
    //   538: invokeinterface 518 1 0
    //   543: ifeq +31 -> 574
    //   546: aload 4
    //   548: invokeinterface 522 1 0
    //   553: checkcast 1639	com/tencent/mm/plugin/appbrand/s/h
    //   556: iconst_0
    //   557: putfield 1640	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
    //   560: goto -24 -> 536
    //   563: astore_3
    //   564: aload_2
    //   565: monitorexit
    //   566: ldc_w 1516
    //   569: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: aload_3
    //   573: athrow
    //   574: aload_3
    //   575: getfield 1637	com/tencent/mm/plugin/appbrand/s/g:niD	Ljava/util/ArrayList;
    //   578: invokevirtual 1601	java/util/ArrayList:clear	()V
    //   581: aload_2
    //   582: monitorexit
    //   583: invokestatic 1646	com/tencent/mm/plugin/appbrand/s/l:bPF	()Lcom/tencent/mm/plugin/appbrand/s/l;
    //   586: astore_2
    //   587: aload_0
    //   588: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   591: astore_3
    //   592: aload_2
    //   593: getfield 1647	com/tencent/mm/plugin/appbrand/s/l:nhY	Ljava/util/HashMap;
    //   596: aload_3
    //   597: invokevirtual 1590	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   600: ifeq +25 -> 625
    //   603: aload_2
    //   604: getfield 1647	com/tencent/mm/plugin/appbrand/s/l:nhY	Ljava/util/HashMap;
    //   607: aload_3
    //   608: invokevirtual 1592	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   611: checkcast 1649	com/tencent/mm/plugin/appbrand/jsapi/websocket/d
    //   614: astore_2
    //   615: aload_2
    //   616: ifnull +9 -> 625
    //   619: aload_2
    //   620: invokeinterface 1652 1 0
    //   625: aload_0
    //   626: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   629: invokestatic 1655	com/tencent/mm/plugin/appbrand/h:Ua	(Ljava/lang/String;)V
    //   632: aload_0
    //   633: getfield 284	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAt	Lcom/tencent/mm/plugin/appbrand/widget/c;
    //   636: aconst_null
    //   637: invokevirtual 1384	com/tencent/mm/plugin/appbrand/widget/c:setOnHierarchyChangeListener	(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V
    //   640: aload_0
    //   641: getfield 284	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAt	Lcom/tencent/mm/plugin/appbrand/widget/c;
    //   644: invokevirtual 1658	com/tencent/mm/plugin/appbrand/widget/c:removeAllViewsInLayout	()V
    //   647: aload_0
    //   648: getfield 298	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jCK	Lcom/tencent/mm/plugin/appbrand/widget/dialog/e;
    //   651: invokevirtual 1661	com/tencent/mm/plugin/appbrand/widget/dialog/e:caW	()V
    //   654: aload_0
    //   655: getfield 300	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAv	Lcom/tencent/mm/plugin/appbrand/widget/dialog/e;
    //   658: invokevirtual 1661	com/tencent/mm/plugin/appbrand/widget/dialog/e:caW	()V
    //   661: aload_0
    //   662: getfield 729	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAx	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/e;
    //   665: ifnull +83 -> 748
    //   668: aload_0
    //   669: getfield 729	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAx	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/e;
    //   672: astore_2
    //   673: aload_2
    //   674: checkcast 726	com/tencent/mm/plugin/appbrand/page/capsulebar/e
    //   677: getfield 761	com/tencent/mm/plugin/appbrand/page/capsulebar/e:nvi	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/d;
    //   680: ifnull +39 -> 719
    //   683: aload_2
    //   684: getfield 761	com/tencent/mm/plugin/appbrand/page/capsulebar/e:nvi	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/d;
    //   687: astore_3
    //   688: aload_3
    //   689: ifnonnull +9 -> 698
    //   692: ldc_w 763
    //   695: invokestatic 766	kotlin/g/b/p:btv	(Ljava/lang/String;)V
    //   698: aload_3
    //   699: getfield 1665	com/tencent/mm/plugin/appbrand/page/capsulebar/d:nvg	Landroid/view/View;
    //   702: ifnull +13 -> 715
    //   705: aload_3
    //   706: getfield 1665	com/tencent/mm/plugin/appbrand/page/capsulebar/d:nvg	Landroid/view/View;
    //   709: invokevirtual 1669	android/view/View:animate	()Landroid/view/ViewPropertyAnimator;
    //   712: invokevirtual 1674	android/view/ViewPropertyAnimator:cancel	()V
    //   715: aload_3
    //   716: invokevirtual 1677	com/tencent/mm/plugin/appbrand/page/capsulebar/d:removeAllViews	()V
    //   719: aload_2
    //   720: checkcast 726	com/tencent/mm/plugin/appbrand/page/capsulebar/e
    //   723: getfield 781	com/tencent/mm/plugin/appbrand/page/capsulebar/e:nvk	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/h;
    //   726: ifnull +22 -> 748
    //   729: aload_2
    //   730: getfield 781	com/tencent/mm/plugin/appbrand/page/capsulebar/e:nvk	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/h;
    //   733: astore_2
    //   734: aload_2
    //   735: ifnonnull +9 -> 744
    //   738: ldc_w 1679
    //   741: invokestatic 766	kotlin/g/b/p:btv	(Ljava/lang/String;)V
    //   744: aload_2
    //   745: invokevirtual 1682	com/tencent/mm/plugin/appbrand/page/capsulebar/h:clearAnimation	()V
    //   748: aload_0
    //   749: aconst_null
    //   750: putfield 187	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAy	Ljava/lang/Boolean;
    //   753: aload_0
    //   754: getfield 1684	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAw	Lcom/tencent/mm/plugin/appbrand/ad/f;
    //   757: ifnull +15 -> 772
    //   760: aload_0
    //   761: getfield 1684	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAw	Lcom/tencent/mm/plugin/appbrand/ad/f;
    //   764: invokevirtual 1687	com/tencent/mm/plugin/appbrand/ad/f:removeAllViews	()V
    //   767: aload_0
    //   768: aconst_null
    //   769: putfield 1684	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAw	Lcom/tencent/mm/plugin/appbrand/ad/f;
    //   772: aload_0
    //   773: getfield 654	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   776: ifeq +27 -> 803
    //   779: aload_0
    //   780: getfield 693	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAr	Lcom/tencent/mm/plugin/appbrand/s;
    //   783: invokevirtual 1690	com/tencent/mm/plugin/appbrand/s:cleanup	()V
    //   786: aload_0
    //   787: aconst_null
    //   788: putfield 693	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAr	Lcom/tencent/mm/plugin/appbrand/s;
    //   791: aload_0
    //   792: getfield 332	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAs	Lcom/tencent/mm/plugin/appbrand/page/w;
    //   795: invokevirtual 1691	com/tencent/mm/plugin/appbrand/page/w:cleanup	()V
    //   798: aload_0
    //   799: aconst_null
    //   800: putfield 332	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAs	Lcom/tencent/mm/plugin/appbrand/page/w;
    //   803: aload_0
    //   804: getfield 194	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAA	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   807: invokeinterface 1692 1 0
    //   812: aload_0
    //   813: getfield 217	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAE	Ljava/util/LinkedHashSet;
    //   816: astore_2
    //   817: aload_2
    //   818: monitorenter
    //   819: aload_0
    //   820: getfield 217	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAE	Ljava/util/LinkedHashSet;
    //   823: invokevirtual 1693	java/util/LinkedHashSet:clear	()V
    //   826: aload_2
    //   827: monitorexit
    //   828: aload_0
    //   829: invokestatic 1697	com/tencent/mm/plugin/appbrand/appcache/bg:N	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)Z
    //   832: pop
    //   833: aload_0
    //   834: getfield 222	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAF	Lcom/tencent/mm/plugin/appbrand/z;
    //   837: invokevirtual 1700	com/tencent/mm/plugin/appbrand/z:unregisterAll	()V
    //   840: aload_0
    //   841: getfield 259	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAZ	Ljava/util/Deque;
    //   844: invokeinterface 1701 1 0
    //   849: aload_0
    //   850: getfield 273	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAn	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   853: aconst_null
    //   854: invokevirtual 1704	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   857: aload_0
    //   858: getfield 254	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAY	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   861: invokevirtual 952	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   864: aload_0
    //   865: getfield 264	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kBa	Landroid/util/SparseArray;
    //   868: invokevirtual 1705	android/util/SparseArray:clear	()V
    //   871: aload_0
    //   872: invokestatic 1709	com/tencent/mm/plugin/appbrand/page/z:af	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V
    //   875: aload_0
    //   876: getfield 207	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAC	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   879: invokevirtual 1710	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   882: aload_0
    //   883: getfield 212	com/tencent/mm/plugin/appbrand/AppBrandRuntime:kAD	Lcom/tencent/mm/plugin/appbrand/av;
    //   886: astore_2
    //   887: aload_2
    //   888: getfield 1105	com/tencent/mm/plugin/appbrand/av:kFA	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   891: invokevirtual 1710	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   894: aload_2
    //   895: getfield 1097	com/tencent/mm/plugin/appbrand/av:kFB	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   898: iconst_0
    //   899: invokevirtual 1713	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   902: ldc_w 1516
    //   905: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   908: return
    //   909: astore_3
    //   910: aload_2
    //   911: monitorexit
    //   912: ldc_w 1516
    //   915: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   918: aload_3
    //   919: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	920	0	this	AppBrandRuntime
    //   10	32	1	bool	boolean
    //   65	49	2	localObject1	Object
    //   149	68	2	localObject2	Object
    //   122	289	3	localObject4	Object
    //   446	10	3	localObject5	Object
    //   457	10	3	localObject6	Object
    //   468	12	3	localObject7	Object
    //   496	32	3	localObject8	Object
    //   563	12	3	localObject9	Object
    //   591	125	3	localObject10	Object
    //   909	10	3	localObject11	Object
    //   417	130	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   54	61	149	finally
    //   150	152	149	finally
    //   410	419	446	finally
    //   419	443	446	finally
    //   447	449	446	finally
    //   479	488	446	finally
    //   291	300	457	finally
    //   458	460	457	finally
    //   344	353	468	finally
    //   469	471	468	finally
    //   527	536	563	finally
    //   536	560	563	finally
    //   564	566	563	finally
    //   574	583	563	finally
    //   819	828	909	finally
    //   910	912	909	finally
  }
  
  protected final void dispatchPause()
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.kAH.kQM.a(d.a.kRi);
    this.kAr.Mx();
    this.kAs.onBackground();
    h.TX(this.mAppId);
    h.a(this.mAppId, h.b.kzL);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
      AppMethodBeat.o(176504);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
      AppMethodBeat.o(176504);
    }
  }
  
  protected final void dispatchResume()
  {
    AppMethodBeat.i(176508);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(176508);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((isDestroyed()) || (this.kAJ))
    {
      this.mResumed = true;
      a(null, "");
      AppMethodBeat.o(176508);
      return;
    }
    this.mResumed = true;
    h.Ub(this.mAppId);
    h.TY(this.mAppId);
    h.a(this.mAppId, h.b.kzK);
    boolean bool = this.kAK;
    this.kAs.onForeground();
    this.kAH.kQM.a(d.a.kRj, "onRuntimeResume");
    this.kAr.bX(bool);
    onResume();
    if (bool) {
      this.kAs.ax(brs(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.e locale = this.kAG;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), locale.ogG);
      brI();
      this.kAJ = false;
      this.kAK = false;
      AppMethodBeat.o(176508);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] resume set callback", new Object[0]);
      }
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134507);
    super.finalize();
    this.kAn.removeCallbacksAndMessages(null);
    AppMethodBeat.o(134507);
  }
  
  public void finish()
  {
    AppMethodBeat.i(134508);
    if (isDestroyed())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(134508);
      return;
    }
    this.SO = true;
    com.tencent.luggage.h.g.aM(AndroidContextUtil.castActivityOrNull(this.mContext));
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176493);
        if (AppBrandRuntime.r(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchDestroy();
          AppMethodBeat.o(176493);
          return;
        }
        AppBrandRuntime.r(AppBrandRuntime.this).w(AppBrandRuntime.this);
        AppMethodBeat.o(176493);
      }
    }, 0L);
    AppMethodBeat.o(134508);
  }
  
  public final com.tencent.mm.plugin.appbrand.config.b getAppConfig()
  {
    AppMethodBeat.i(134482);
    com.tencent.mm.plugin.appbrand.config.b localb = (com.tencent.mm.plugin.appbrand.config.b)d(com.tencent.mm.plugin.appbrand.config.b.class, false);
    AppMethodBeat.o(134482);
    return localb;
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
    AppMethodBeat.i(258637);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    AppMethodBeat.o(258637);
    return localActivity;
  }
  
  public bw getDecorWidgetFactory()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer()
  {
    return this.jCK;
  }
  
  public q getFileSystem()
  {
    return this.kAz;
  }
  
  public final com.tencent.mm.plugin.appbrand.ad.f getRuntimeAdViewContainer()
  {
    AppMethodBeat.i(176513);
    com.tencent.mm.plugin.appbrand.ad.f localf = null;
    String str2;
    if ((this.kAu instanceof ac))
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use AdLoadingSplash RuntimeAdViewContainer", new Object[] { this.mAppId });
      localf = ((ac)this.kAu).getRuntimeAdViewContainer();
      str2 = this.mAppId;
      if (this.kAu != null) {
        break label135;
      }
    }
    label135:
    for (String str1 = "null";; str1 = this.kAu.getClass().getSimpleName())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer:%s, appId:%s, splash:%s", new Object[] { localf, str2, str1 });
      AppMethodBeat.o(176513);
      return localf;
      if (this.kAw == null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use secondaryRuntimeAdViewContainer", new Object[] { this.mAppId });
      localf = this.kAw;
      break;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.kAl == null)
    {
      String str = this.mAppId;
      if (this.kAm == null) {}
      for (localObject = null;; localObject = this.kAm.getClass().getName())
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return default %s", new Object[] { str, localObject });
        if (this.kAm == null) {
          break;
        }
        localObject = this.kAm;
        AppMethodBeat.o(176502);
        return localObject;
      }
      localObject = new o();
      this.kAm = ((com.tencent.mm.plugin.appbrand.platform.window.c)localObject);
      AppMethodBeat.o(176502);
      return localObject;
    }
    Object localObject = this.kAl.getWindowAndroid();
    AppMethodBeat.o(176502);
    return localObject;
  }
  
  public final void gs(boolean paramBoolean)
  {
    AppMethodBeat.i(219209);
    this.kAN = paramBoolean;
    if (brh() == null) {}
    for (t localt = null;; localt = brh().getCurrentPage())
    {
      if (localt != null) {
        localt.bQP();
      }
      AppMethodBeat.o(219209);
      return;
    }
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(134520);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(134520);
      return;
    }
    if (isDestroyed())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134520);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    if ((MMHandlerThread.isMainThread()) && (0L == l))
    {
      paramRunnable.run();
      AppMethodBeat.o(134520);
      return;
    }
    paramRunnable = u.a(this.kAo, paramRunnable);
    keep(paramRunnable);
    this.kAn.postDelayed(paramRunnable, l);
    AppMethodBeat.o(134520);
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
    return this.SO;
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(134479);
    if ((this.kAl != null) && (this.kAl.v(this)))
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
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(134473);
    this.kAo.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(219206);
    if (this.kAu == null)
    {
      if (this.kAv.onBackPressed())
      {
        AppMethodBeat.o(219206);
        return;
      }
      if (this.jCK.onBackPressed())
      {
        AppMethodBeat.o(219206);
        return;
      }
      if (this.kAs != null)
      {
        this.kAs.onBackPressed();
        AppMethodBeat.o(219206);
      }
    }
    else
    {
      h.a(this.mAppId, h.d.kzQ);
      finish();
    }
    AppMethodBeat.o(219206);
  }
  
  protected void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(176503);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(176491);
        AppBrandRuntime.a(AppBrandRuntime.this, paramConfiguration);
        AppMethodBeat.o(176491);
        return false;
      }
    });
    if (this.kAQ != null)
    {
      com.tencent.mm.plugin.appbrand.pip.f localf = this.kAQ;
      com.tencent.mm.sdk.platformtools.Log.i(localf.cDW, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (localf.nDg != null)
      {
        paramConfiguration = localf.nDg;
        com.tencent.mm.sdk.platformtools.Log.i(paramConfiguration.cDW, "onConfigurationChanged");
        if (!paramConfiguration.nCc)
        {
          com.tencent.mm.sdk.platformtools.Log.d(paramConfiguration.cDW, "onConfigurationChanged, false == mHandleStarted");
          AppMethodBeat.o(176503);
          return;
        }
        paramConfiguration.nBZ.a(paramConfiguration.cwK, new b.1(paramConfiguration));
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
    AppMethodBeat.i(219205);
    this.kAr.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.kAr.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(219205);
  }
  
  protected void onResume() {}
  
  static abstract interface a
  {
    public abstract void done();
  }
  
  public static abstract class b
  {
    AppBrandRuntime.a kBs;
    
    public void KY()
    {
      if (this.kBs != null) {
        this.kBs.done();
      }
    }
    
    public void interrupt() {}
    
    public abstract void prepare();
  }
  
  final class c
    implements AppBrandRuntime.a, com.tencent.mm.vending.e.a
  {
    private final String kBt;
    volatile boolean kBu;
    
    private c()
    {
      AppMethodBeat.i(134470);
      this.kBt = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()) });
      AppBrandRuntime.this.keep(this);
      this.kBu = false;
      AppMethodBeat.o(134470);
    }
    
    public final void dead()
    {
      this.kBu = true;
    }
    
    public final void done()
    {
      AppMethodBeat.i(134471);
      if (!this.kBu)
      {
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134469);
            if (!AppBrandRuntime.c.this.kBu)
            {
              AppBrandRuntime.g(AppBrandRuntime.this);
              AppBrandRuntime.h(AppBrandRuntime.this);
              AppMethodBeat.o(134469);
              return;
            }
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
            AppMethodBeat.o(134469);
          }
        };
        AppBrandRuntime.this.i(local1, 0L);
        AppMethodBeat.o(134471);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
      AppMethodBeat.o(134471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */