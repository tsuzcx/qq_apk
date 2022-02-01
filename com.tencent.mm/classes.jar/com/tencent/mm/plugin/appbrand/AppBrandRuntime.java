package com.tencent.mm.plugin.appbrand;

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
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.capsulebar.l;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.x.f;
import com.tencent.mm.plugin.appbrand.pip.b.1;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.ai;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.plugin.appbrand.utils.am;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class AppBrandRuntime
  implements com.tencent.mm.plugin.appbrand.utils.u<com.tencent.mm.vending.e.a>
{
  public volatile boolean ccV;
  public volatile String mAppId;
  public Context mContext;
  public volatile boolean mInitialized;
  public boolean mResumed;
  public com.tencent.mm.plugin.appbrand.widget.dialog.g pmu;
  private com.tencent.mm.plugin.appbrand.utils.k qsA;
  public volatile com.tencent.mm.plugin.appbrand.b.c qsB;
  public com.tencent.mm.plugin.appbrand.q.a qsC;
  private volatile boolean qsD;
  public final AtomicBoolean qsE;
  protected boolean qsF;
  public boolean qsG;
  private boolean qsH;
  public av qsI;
  public boolean qsJ;
  public boolean qsK;
  public boolean qsL;
  public com.tencent.mm.plugin.appbrand.pip.g qsM;
  private AppBrandPipContainerView qsN;
  private AppBrandGlobalNativeWidgetContainerView qsO;
  public com.tencent.mm.plugin.appbrand.page.k qsP;
  public boolean qsQ;
  private LinkedList<b> qsR;
  private ConcurrentLinkedQueue<b> qsS;
  private final p qsT;
  private final com.tencent.mm.ipcinvoker.q qsU;
  private final MTimerHandler qsV;
  private final Deque<Runnable> qsW;
  public SparseArray<Set<ar>> qsX;
  public am qsY;
  public ap qsc;
  com.tencent.mm.plugin.appbrand.platform.window.c qsd;
  private final MMHandler qse;
  private final bi qsf;
  AppBrandRuntime qsg;
  public volatile AppBrandInitConfig qsh;
  private volatile y qsi;
  private volatile x qsj;
  public com.tencent.mm.plugin.appbrand.widget.e qsk;
  protected com.tencent.mm.plugin.appbrand.ui.ah qsl;
  boolean qsm;
  public com.tencent.mm.plugin.appbrand.widget.dialog.g qsn;
  public com.tencent.mm.plugin.appbrand.ad.f qso;
  public com.tencent.mm.plugin.appbrand.page.capsulebar.e qsp;
  private volatile Boolean qsq;
  private volatile w qsr;
  private AtomicBoolean qss;
  public final ConcurrentLinkedDeque<com.tencent.mm.plugin.appbrand.jsapi.m> qst;
  private final bc qsu;
  private final ConcurrentSkipListSet<ax> qsv;
  final bd qsw;
  public final ConcurrentSkipListSet<aw> qsx;
  private final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.n> qsy;
  private final ah qsz;
  
  private AppBrandRuntime(Context paramContext)
  {
    AppMethodBeat.i(317226);
    this.qsq = null;
    this.qsr = null;
    this.qss = new AtomicBoolean(false);
    this.qst = new ConcurrentLinkedDeque() {};
    this.qsu = new bc();
    this.qsv = new ConcurrentSkipListSet(new Comparator() {});
    this.qsw = new bd();
    this.qsx = new ConcurrentSkipListSet(new Comparator() {});
    this.qsy = new LinkedHashSet();
    this.qsz = new ah();
    this.mResumed = false;
    this.qsE = new AtomicBoolean(false);
    this.qsJ = false;
    this.qsK = true;
    this.qsQ = false;
    this.qsR = new LinkedList();
    this.qsS = null;
    this.qsT = new p()
    {
      public final void onDisconnect()
      {
        AppMethodBeat.i(317233);
        AppBrandRuntime.v(AppBrandRuntime.this).set(true);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onDisconnect: appId=[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppMethodBeat.o(317233);
      }
    };
    this.qsU = new com.tencent.mm.ipcinvoker.q()
    {
      public final void onReconnect()
      {
        AppMethodBeat.i(317229);
        if (AppBrandRuntime.v(AppBrandRuntime.this).getAndSet(false)) {
          AppBrandRuntime.w(AppBrandRuntime.this);
        }
        AppMethodBeat.o(317229);
      }
    };
    this.qsV = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(317224);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppBrandRuntime.this.cbz();
        AppMethodBeat.o(317224);
        return false;
      }
    }, false);
    this.qsW = new LinkedBlockingDeque();
    this.qsX = new SparseArray();
    this.qsY = null;
    this.mContext = paramContext;
    this.qse = new MMHandler(Looper.getMainLooper());
    this.qsf = new bi();
    this.qsk = et(paramContext);
    this.qsk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.pmu = new com.tencent.mm.plugin.appbrand.widget.dialog.g(this.mContext);
    this.qsn = new com.tencent.mm.plugin.appbrand.widget.dialog.g(this.mContext, this.pmu.getShareContext());
    this.qsA = new com.tencent.mm.plugin.appbrand.utils.k();
    this.qsL = false;
    AppMethodBeat.o(317226);
  }
  
  public AppBrandRuntime(ap paramap)
  {
    this(paramap.getContext());
    AppMethodBeat.i(176500);
    this.qsc = paramap;
    this.qsd = null;
    AppMethodBeat.o(176500);
  }
  
  protected AppBrandRuntime(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this(paramc.getContext());
    AppMethodBeat.i(317227);
    this.qsc = null;
    this.qsd = paramc;
    AppMethodBeat.o(317227);
  }
  
  private void cbE()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.h.d.a(this.mAppId + ":performInitPageContainer", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134448);
        AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.cbC());
        AppBrandRuntime.p(AppBrandRuntime.this).setOnReadyListener(new x.f()
        {
          public final void cbS()
          {
            AppMethodBeat.i(316863);
            AppBrandRuntime.o(AppBrandRuntime.this);
            AppBrandRuntime.a(AppBrandRuntime.this, null);
            AppMethodBeat.o(316863);
          }
        });
        bh.qyr.a(AppBrandRuntime.this, AppBrandRuntime.p(AppBrandRuntime.this));
        AppBrandRuntime.p(AppBrandRuntime.this).init(AppBrandRuntime.q(AppBrandRuntime.this).qAF);
        AppMethodBeat.o(134448);
      }
    });
    AppMethodBeat.o(134499);
  }
  
  private void cbF()
  {
    AppMethodBeat.i(134500);
    com.tencent.luggage.sdk.h.d.a(this.mAppId + ":performInitService", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134449);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit_Game);
        AppBrandRuntime.r(AppBrandRuntime.this).init();
        AppMethodBeat.o(134449);
      }
    });
    AppMethodBeat.o(134500);
  }
  
  protected boolean S(Runnable paramRunnable)
  {
    return false;
  }
  
  public boolean T(Runnable paramRunnable)
  {
    AppMethodBeat.i(317483);
    if (this.qsB.qKC.chD() == com.tencent.mm.plugin.appbrand.b.b.qKy) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(317483);
      return true;
    }
    AppMethodBeat.o(317483);
    return false;
  }
  
  public final void U(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.ccV) || (this.qsE.get()))
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
    this.qsW.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  protected final void Uq(String paramString)
  {
    AppMethodBeat.i(317339);
    Object localObject = this.qsS;
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { paramString, ((b)((Iterator)localObject).next()).toString() });
      }
      AppMethodBeat.o(317339);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { paramString });
    AppMethodBeat.o(317339);
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(370005);
    i(paramRunnable, 0L);
    AppMethodBeat.o(370005);
  }
  
  public final void W(Runnable paramRunnable)
  {
    AppMethodBeat.i(370006);
    X(paramRunnable);
    AppMethodBeat.o(370006);
  }
  
  public final void X(Runnable paramRunnable)
  {
    AppMethodBeat.i(317492);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(317492);
      return;
    }
    if (this.qsE.get())
    {
      AppMethodBeat.o(317492);
      return;
    }
    paramRunnable = ab.a(this.qsf, paramRunnable);
    keep(paramRunnable);
    com.tencent.threadpool.h.ahAA.p(paramRunnable, 0L);
    AppMethodBeat.o(317492);
  }
  
  public final void a(final int paramInt1, final int paramInt2, final ar paramar)
  {
    AppMethodBeat.i(178506);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176498);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
        paramar.qxS = paramInt2;
        paramar.qxR = paramInt1;
        int i;
        if (AppBrandRuntime.x(AppBrandRuntime.this).get(paramar.qxR) != null)
        {
          i = 1;
          if (i == 0) {
            break label125;
          }
        }
        label125:
        for (Object localObject = (Set)AppBrandRuntime.x(AppBrandRuntime.this).get(paramar.qxR);; localObject = new CopyOnWriteArraySet())
        {
          ((Set)localObject).add(paramar);
          if (i == 0) {
            AppBrandRuntime.x(AppBrandRuntime.this).put(paramar.qxR, localObject);
          }
          AppMethodBeat.o(176498);
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
    this.qsR.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ap paramap)
  {
    AppMethodBeat.i(317283);
    this.qsc = paramap;
    if (this.qsc != null)
    {
      this.qsu.b(this.qsc);
      AppMethodBeat.o(317283);
      return;
    }
    this.qsu.cdx();
    AppMethodBeat.o(317283);
  }
  
  public final void a(final ar paramar)
  {
    AppMethodBeat.i(134522);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317296);
        Set localSet = (Set)AppBrandRuntime.x(AppBrandRuntime.this).get(paramar.qxR);
        if (localSet != null) {
          localSet.remove(paramar);
        }
        AppMethodBeat.o(317296);
      }
    }, 0L);
    AppMethodBeat.o(134522);
  }
  
  public final void a(au paramau)
  {
    AppMethodBeat.i(317286);
    this.qsu.qyf.add(paramau);
    AppMethodBeat.o(317286);
  }
  
  protected final void a(ax paramax)
  {
    AppMethodBeat.i(317364);
    if (paramax == null)
    {
      AppMethodBeat.o(317364);
      return;
    }
    if (this.mInitialized)
    {
      paramax.onRuntimeInitReady();
      AppMethodBeat.o(317364);
      return;
    }
    this.qsv.add(paramax);
    AppMethodBeat.o(317364);
  }
  
  protected final void a(be parambe)
  {
    AppMethodBeat.i(317371);
    bd localbd = this.qsw;
    if (localbd.qyj.get())
    {
      AppMethodBeat.o(317371);
      return;
    }
    localbd.qyi.add(parambe);
    AppMethodBeat.o(317371);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.qsh = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(317453);
    if (!this.mResumed)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", new Object[] { this.mAppId, paramString });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.qsh = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(317453);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", new Object[] { this.mAppId, paramString, android.util.Log.getStackTraceString(new Throwable()) });
    dispatchPause();
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      cbq();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(317453);
      return;
      paramAppBrandInitConfig = asH();
    }
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> void a(T paramT)
  {
    AppMethodBeat.i(317304);
    this.qst.add(paramT);
    AppMethodBeat.o(317304);
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.qsf.a(parama);
    AppMethodBeat.o(160924);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.n paramn)
  {
    AppMethodBeat.i(134493);
    if (paramn == null)
    {
      AppMethodBeat.o(134493);
      return false;
    }
    synchronized (this.qsy)
    {
      this.qsy.add(paramn);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T aN(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.qsQ) {}
    for (boolean bool = true;; bool = false)
    {
      paramClass = d(paramClass, bool);
      AppMethodBeat.o(134491);
      return paramClass;
    }
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.n> T aO(Class<T> paramClass)
  {
    AppMethodBeat.i(134492);
    if (paramClass == null)
    {
      AppMethodBeat.o(134492);
      return null;
    }
    synchronized (this.qsy)
    {
      Iterator localIterator = this.qsy.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.n localn = (com.tencent.mm.plugin.appbrand.jsapi.n)localIterator.next();
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
  
  protected <T extends com.tencent.mm.kernel.c.a> T ae(Class<T> paramClass)
  {
    return null;
  }
  
  public y ari()
  {
    return this.qsi;
  }
  
  protected void asB() {}
  
  protected com.tencent.mm.plugin.appbrand.q.a asD()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public com.tencent.mm.plugin.appbrand.config.n asG()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.n localn = (com.tencent.mm.plugin.appbrand.config.n)aN(com.tencent.mm.plugin.appbrand.config.n.class);
    AppMethodBeat.o(134481);
    return localn;
  }
  
  public AppBrandInitConfig asH()
  {
    return this.qsh;
  }
  
  protected w asy()
  {
    AppMethodBeat.i(134486);
    com.tencent.mm.plugin.appbrand.appstorage.ac localac = new com.tencent.mm.plugin.appbrand.appstorage.ac(new LinkedList());
    AppMethodBeat.o(134486);
    return localac;
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ax(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.qsz.aH(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.m.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.m.uxJ);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    paramClass = ae(paramClass);
    AppMethodBeat.o(134494);
    return paramClass;
  }
  
  public final void ay(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(134496);
    this.qsz.ay(paramClass);
    AppMethodBeat.o(134496);
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
    this.qst.add(paramb);
    AppMethodBeat.o(134483);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(134495);
    this.qsz.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final void b(final Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(317460);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317241);
        com.tencent.luggage.l.f.bv(AndroidContextUtil.castActivityOrNull(AppBrandRuntime.this.mContext));
        if ((!AppBrandRuntime.this.mInitialized) || (AppBrandRuntime.this.qsE.get())) {
          if (AppBrandRuntime.u(AppBrandRuntime.this) == null) {
            AppBrandRuntime.this.dispatchDestroy();
          }
        }
        while (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(317241);
          return;
          AppBrandRuntime.u(AppBrandRuntime.this).A(AppBrandRuntime.this);
          continue;
          if (AppBrandRuntime.u(AppBrandRuntime.this) == null)
          {
            AppBrandRuntime.this.dispatchPause();
            if (paramRunnable != null)
            {
              paramRunnable.run();
              AppMethodBeat.o(317241);
            }
          }
          else
          {
            AppBrandRuntime.u(AppBrandRuntime.this).a(AppBrandRuntime.this, paramObject, paramRunnable);
          }
        }
        AppMethodBeat.o(317241);
      }
    }, 0L);
    AppMethodBeat.o(317460);
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.n paramn)
  {
    AppMethodBeat.i(317316);
    if (paramn == null)
    {
      AppMethodBeat.o(317316);
      return false;
    }
    synchronized (this.qsy)
    {
      this.qsy.remove(paramn);
      AppMethodBeat.o(317316);
      return true;
    }
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
    this.qsh = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.qsB = new com.tencent.mm.plugin.appbrand.b.c(this);
    this.qsB.qKC.start();
    this.qsB.a(new com.tencent.mm.plugin.appbrand.b.c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(134462);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntime.this;
        HashMap localHashMap = new HashMap();
        switch (com.tencent.mm.plugin.appbrand.page.q.1.qKW[paramAnonymousb.ordinal()])
        {
        default: 
          AppMethodBeat.o(134462);
          return;
        case 1: 
          paramAnonymousString = "background";
        }
        for (;;)
        {
          localHashMap.put("status", paramAnonymousString);
          new com.tencent.mm.plugin.appbrand.page.q().K(localHashMap).h(localAppBrandRuntime.ari()).cpV();
          AppMethodBeat.o(134462);
          return;
          paramAnonymousString = "active";
          continue;
          paramAnonymousString = "suspend";
        }
      }
    });
    this.mInitialized = false;
    this.qsD = false;
    this.qsE.set(false);
    this.ccV = false;
    this.qsF = false;
    this.qsG = false;
    this.qsH = false;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(134474);
  }
  
  protected void cbA() {}
  
  protected y cbB()
  {
    AppMethodBeat.i(134497);
    y localy = new y();
    AppMethodBeat.o(134497);
    return localy;
  }
  
  protected x cbC()
  {
    AppMethodBeat.i(134498);
    x localx = new x(this.mContext, this);
    AppMethodBeat.o(134498);
    return localx;
  }
  
  public boolean cbD()
  {
    return true;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.capsulebar.e cbG()
  {
    AppMethodBeat.i(317351);
    com.tencent.mm.plugin.appbrand.page.capsulebar.e locale = new com.tencent.mm.plugin.appbrand.page.capsulebar.e(this);
    AppMethodBeat.o(317351);
    return locale;
  }
  
  protected final void cbH()
  {
    AppMethodBeat.i(317391);
    Assert.assertNotNull(this.qsB);
    this.qsB.qKC.a(d.a.qLg);
    AppMethodBeat.o(317391);
  }
  
  protected void cbI() {}
  
  protected final void cbJ()
  {
    AppMethodBeat.i(134513);
    this.qsF = true;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  public final boolean cbK()
  {
    AppMethodBeat.i(134514);
    if (!this.qsK)
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
    if ((this.qsj != null) && (this.qsj.getCurrentPage() != null) && (!this.qsj.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  public void cbL()
  {
    AppMethodBeat.i(176510);
    X(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176497);
        final com.tencent.mm.plugin.appbrand.platform.window.c localc = AppBrandRuntime.this.getWindowAndroid();
        if (localc == null)
        {
          AppMethodBeat.o(176497);
          return;
        }
        Object localObject = AppBrandRuntime.this.getAppConfig();
        if (localObject == null) {}
        int i;
        for (localObject = new com.tencent.mm.plugin.appbrand.platform.window.c.a(AppBrandRuntime.this.asH().hEy);; localObject = new com.tencent.mm.plugin.appbrand.platform.window.c.a(AppBrandRuntime.this.asH().hEy, null, i))
        {
          localc.setWindowDescription((com.tencent.mm.plugin.appbrand.platform.window.c.a)localObject);
          com.tencent.mm.modelappbrand.a.b.bEY().a(new b.c()
          {
            public final void onBitmapLoaded(Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(316848);
              localc.setWindowDescription(new com.tencent.mm.plugin.appbrand.platform.window.c.a(this.qte.label, paramAnonymous2Bitmap, this.qte.colorPrimary));
              AppMethodBeat.o(316848);
            }
          }, AppBrandRuntime.this.asH().iconUrl, com.tencent.mm.modelappbrand.a.g.org);
          AppMethodBeat.o(176497);
          return;
          i = com.tencent.mm.plugin.appbrand.af.i.dq(((com.tencent.mm.plugin.appbrand.config.b)localObject).ckt().qWe, -16777216);
        }
      }
    });
    AppMethodBeat.o(176510);
  }
  
  public com.tencent.mm.plugin.appbrand.ui.ah cbM()
  {
    return this.qsl;
  }
  
  public final boolean cbN()
  {
    AppMethodBeat.i(317502);
    if (this.qsq == null) {
      this.qsq = Boolean.valueOf(((com.tencent.mm.plugin.appbrand.ad.k)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.ad.k.class)).L(this));
    }
    boolean bool = this.qsq.booleanValue();
    AppMethodBeat.o(317502);
    return bool;
  }
  
  public final boolean cbO()
  {
    AppMethodBeat.i(317506);
    if ((this.qsl instanceof ai)) {}
    for (boolean bool = ((ai)this.qsl).cbO();; bool = false)
    {
      String str2 = this.mAppId;
      if (this.qsl == null) {}
      for (String str1 = "null";; str1 = this.qsl.getClass().getSimpleName())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
        AppMethodBeat.o(317506);
        return bool;
      }
    }
  }
  
  public final void cbP()
  {
    this.qsl = null;
  }
  
  public final AppBrandGlobalNativeWidgetContainerView cbQ()
  {
    return this.qsO;
  }
  
  public boolean cbR()
  {
    return true;
  }
  
  public final void cbq()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    this.qsm = false;
    long l = Util.currentTicks();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    cbr();
    com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134463);
        AppBrandRuntime.f(AppBrandRuntime.this);
        AppMethodBeat.o(134463);
      }
    });
    com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134464);
        AppBrandRuntime.a(AppBrandRuntime.this, new AppBrandRuntime.c(AppBrandRuntime.this, (byte)0));
        AppMethodBeat.o(134464);
      }
    });
    com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134465);
        AppBrandRuntime.this.cbv();
        AppMethodBeat.o(134465);
      }
    });
    this.qsV.startTimer(10000L);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(Util.currentTicks() - l) });
    AppMethodBeat.o(134475);
  }
  
  protected void cbr() {}
  
  public final AppBrandRuntime cbs()
  {
    AppMethodBeat.i(134478);
    if (this.qsc == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.qsc.y(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public void cbt() {}
  
  protected com.tencent.mm.plugin.appbrand.ui.ah cbu()
  {
    return null;
  }
  
  protected final void cbv()
  {
    AppMethodBeat.i(134487);
    if (this.qsl != null)
    {
      com.tencent.mm.plugin.appbrand.ui.i.a(this.qsl);
      this.qsl = null;
    }
    Object localObject1 = cbu();
    if (localObject1 == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.ah)localObject1).eT(asH().iconUrl, asH().hEy);
    View localView = ((com.tencent.mm.plugin.appbrand.ui.ah)localObject1).getView();
    localView.sendAccessibilityEvent(32768);
    final int i = 0;
    while (i < this.qsk.getChildCount())
    {
      localObject2 = this.qsk.getChildAt(i);
      if (((com.tencent.mm.plugin.appbrand.ui.ah)localObject1).getView() != localObject2) {
        ((View)localObject2).setImportantForAccessibility(4);
      }
      i += 1;
    }
    bh.qyx.a(this, localView);
    this.qsm = true;
    Object localObject2 = this.qsk;
    ((com.tencent.mm.plugin.appbrand.widget.e)localObject2).uxp = true;
    ((com.tencent.mm.plugin.appbrand.widget.e)localObject2).uxq = localView;
    this.qsl = ((com.tencent.mm.plugin.appbrand.ui.ah)localObject1);
    localObject2 = this.mAppId;
    if (this.qsl == null) {}
    for (localObject1 = "null";; localObject1 = this.qsl.getClass().getSimpleName())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", new Object[] { localObject2, localObject1 });
      i = localView.hashCode();
      this.qsk.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(316967);
          if ((paramAnonymousView2.hashCode() != i) && (AppBrandRuntime.i(AppBrandRuntime.this))) {
            paramAnonymousView2.setImportantForAccessibility(4);
          }
          AppMethodBeat.o(316967);
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(134467);
          if (AppBrandRuntime.i(AppBrandRuntime.this)) {
            paramAnonymousView2.setImportantForAccessibility(0);
          }
          if (paramAnonymousView2.hashCode() == i)
          {
            AppBrandRuntime.j(AppBrandRuntime.this);
            paramAnonymousView1 = AppBrandRuntime.this.qsk;
            paramAnonymousView1.uxp = false;
            paramAnonymousView1.uxq = null;
            int i = 0;
            while (i < AppBrandRuntime.this.qsk.getChildCount())
            {
              AppBrandRuntime.this.qsk.getChildAt(i).setImportantForAccessibility(0);
              i += 1;
            }
            if (!AppBrandRuntime.this.qsE.get())
            {
              paramAnonymousView1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(160923);
                  if (AppBrandRuntime.this.mResumed)
                  {
                    AppBrandRuntime.this.getPageContainer().setActuallyVisible(true);
                    AppMethodBeat.o(160923);
                    return;
                  }
                  AppBrandRuntime.this.qsB.a(new com.tencent.mm.plugin.appbrand.b.c.a()
                  {
                    public final void onRunningStateChanged(String paramAnonymous3String, com.tencent.mm.plugin.appbrand.b.b paramAnonymous3b)
                    {
                      AppMethodBeat.i(316778);
                      if (com.tencent.mm.plugin.appbrand.b.b.qKw == paramAnonymous3b)
                      {
                        AppBrandRuntime.this.getPageContainer().setActuallyVisible(true);
                        AppBrandRuntime.this.qsB.b(this);
                      }
                      AppMethodBeat.o(316778);
                    }
                  });
                  AppMethodBeat.o(160923);
                }
              };
              AppBrandRuntime.this.cbw();
              if (AppBrandRuntime.this.getPageContainer() == null)
              {
                AppBrandRuntime.this.U(paramAnonymousView1);
                AppMethodBeat.o(134467);
                return;
              }
              paramAnonymousView1.run();
            }
          }
          AppMethodBeat.o(134467);
        }
      });
      AppMethodBeat.o(134487);
      return;
    }
  }
  
  protected void cbw() {}
  
  public final void cbx()
  {
    Object localObject = null;
    AppMethodBeat.i(134488);
    if (this.qsE.get())
    {
      if (this.qsl != null) {
        com.tencent.mm.plugin.appbrand.ui.i.a(this.qsl);
      }
      this.qsl = null;
      AppMethodBeat.o(134488);
      return;
    }
    if ((this.qsl == null) || (com.tencent.mm.plugin.appbrand.ui.i.ubj.cKW()))
    {
      AppMethodBeat.o(134488);
      return;
    }
    if (this.qsl == null) {}
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.printInfoStack("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", new Object[] { localObject });
      localObject = new kotlin.g.a.a() {};
      if (!(this.qsl instanceof al)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "[weishi] hideSplash, hideLoadingSplashFromRuntime");
      ((al)this.qsl).au((kotlin.g.a.a)localObject);
      AppMethodBeat.o(134488);
      return;
      localObject = this.qsl.getClass().getName();
    }
    this.qsl.as((kotlin.g.a.a)localObject);
    AppMethodBeat.o(134488);
  }
  
  public final String cby()
  {
    AppMethodBeat.i(134489);
    if (this.qsh == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (Util.isNullOrNil(this.qsh.qAF))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().ckv();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.qsh.qAF;
    AppMethodBeat.o(134489);
    return str;
  }
  
  protected void cbz()
  {
    AppMethodBeat.i(317333);
    this.qsw.cbz();
    AppMethodBeat.o(317333);
  }
  
  public void close()
  {
    AppMethodBeat.i(134511);
    b(null, null);
    AppMethodBeat.o(134511);
  }
  
  /* Error */
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T d(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1551
    //   3: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 210	com/tencent/mm/plugin/appbrand/AppBrandRuntime:qst	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1556	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 554 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 558 1 0
    //   38: checkcast 1558	com/tencent/mm/plugin/appbrand/jsapi/m
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1216	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1564	org/a/a:cQ	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1568	org/a/a:kJE	()Lorg/a/a;
    //   65: getfield 1572	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1558	com/tencent/mm/plugin/appbrand/jsapi/m
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 210	com/tencent/mm/plugin/appbrand/AppBrandRuntime:qst	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 1190 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1551
    //   99: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 398
    //   109: ldc_w 1574
    //   112: iconst_1
    //   113: anewarray 5	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1517	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 712	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    int i = 1;
    AppMethodBeat.i(134477);
    if (!this.mInitialized)
    {
      if ((!this.qsE.get()) && (!this.ccV))
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
    if (paramAppBrandInitConfig != null) {
      if (this.qsH) {
        this.qsH = false;
      }
    }
    for (;;)
    {
      if (i != 0) {
        cbJ();
      }
      a(paramAppBrandInitConfig);
      if ((this.qsF) || (this.qsE.get())) {
        break;
      }
      paramAppBrandInitConfig = new LinkedList(this.qsx).iterator();
      while (paramAppBrandInitConfig.hasNext())
      {
        aw localaw = (aw)paramAppBrandInitConfig.next();
        asH();
        localaw.I(this);
      }
      if (paramAppBrandInitConfig.eul == this.qsh.eul) {
        i = 0;
      }
    }
    AppMethodBeat.o(134477);
  }
  
  final void dispatchDestroy()
  {
    AppMethodBeat.i(176506);
    boolean bool = this.qsE.getAndSet(true);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "dispatchDestroy, appId[%s] destroyed?[%b] initialized?[%b] initReady?[%b]", new Object[] { this.mAppId, Boolean.valueOf(bool), Boolean.valueOf(this.mInitialized), Boolean.valueOf(this.qsD) });
    if (bool)
    {
      AppMethodBeat.o(176506);
      return;
    }
    ??? = this.qsS;
    this.qsS = null;
    if ((??? == null) || (((Queue)???).isEmpty())) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { this.mAppId });
    }
    for (;;)
    {
      onDestroy();
      ??? = this.qsf;
      localObject2 = ((bi)???).qyA.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject2).next()).dead();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", new Object[] { Integer.valueOf(((Queue)???).size()), this.mAppId });
      while (!((Queue)???).isEmpty()) {
        ((b)((Queue)???).poll()).interrupt();
      }
    }
    ((bi)???).qyA.clear();
    this.qsr = null;
    com.tencent.mm.plugin.appbrand.media.a.a.ZW(this.mAppId);
    ??? = MMApplicationContext.getMainProcessName();
    j.c((String)???, this.qsT);
    j.c((String)???, this.qsU);
    k.Uh(this.mAppId);
    k.a(this.mAppId, k.b.qrE);
    com.tencent.luggage.l.f.bv(AndroidContextUtil.castActivityOrNull(this.mContext));
    Object localObject2 = this.qsB;
    ((com.tencent.mm.plugin.appbrand.b.c)localObject2).qKC.stop();
    synchronized (((com.tencent.mm.plugin.appbrand.b.c)localObject2).qKD)
    {
      ((com.tencent.mm.plugin.appbrand.b.c)localObject2).qKD.clear();
      this.qsI = null;
      ??? = com.tencent.mm.plugin.appbrand.t.f.cCk();
      localObject2 = this.mAppId;
      if (((com.tencent.mm.plugin.appbrand.t.f)???).tnt.containsKey(localObject2)) {
        localObject2 = (com.tencent.mm.plugin.appbrand.t.d)((com.tencent.mm.plugin.appbrand.t.f)???).tnt.remove(localObject2);
      }
    }
    Object localObject10;
    synchronized (((com.tencent.mm.plugin.appbrand.t.d)localObject2).tnv)
    {
      ((com.tencent.mm.plugin.appbrand.t.d)localObject2).tnv.clear();
      ((com.tencent.mm.plugin.appbrand.t.d)localObject2).tnx.clear();
      ((com.tencent.mm.plugin.appbrand.t.d)localObject2).tnw.clear();
      ??? = com.tencent.mm.plugin.appbrand.t.c.cCh();
      localObject2 = this.mAppId;
      if (!((com.tencent.mm.plugin.appbrand.t.c)???).tnt.containsKey(localObject2)) {
        break label502;
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.t.b)((com.tencent.mm.plugin.appbrand.t.c)???).tnt.remove(localObject2);
      synchronized (((com.tencent.mm.plugin.appbrand.t.b)localObject2).tnp)
      {
        localObject10 = ((com.tencent.mm.plugin.appbrand.t.b)localObject2).tnp.iterator();
        if (!((Iterator)localObject10).hasNext()) {
          break label493;
        }
        ((com.tencent.mm.plugin.appbrand.t.a.b)((Iterator)localObject10).next()).Uz = false;
      }
      localObject4 = finally;
      AppMethodBeat.o(176506);
      throw localObject4;
    }
    label493:
    localObject5.tnp.clear();
    label502:
    ??? = com.tencent.mm.plugin.appbrand.t.h.cCm();
    Object localObject6 = this.mAppId;
    if (((com.tencent.mm.plugin.appbrand.t.h)???).tnt.containsKey(localObject6))
    {
      localObject6 = (com.tencent.mm.plugin.appbrand.t.g)((com.tencent.mm.plugin.appbrand.t.h)???).tnt.remove(localObject6);
      synchronized (((com.tencent.mm.plugin.appbrand.t.g)localObject6).tog)
      {
        localObject10 = ((com.tencent.mm.plugin.appbrand.t.g)localObject6).tog.iterator();
        if (((Iterator)localObject10).hasNext()) {
          ((com.tencent.mm.plugin.appbrand.t.b.a)((Iterator)localObject10).next()).Uz = false;
        }
      }
      localObject7.tog.clear();
    }
    ??? = com.tencent.mm.plugin.appbrand.t.k.cCp();
    Object localObject8 = this.mAppId;
    if (((com.tencent.mm.plugin.appbrand.t.k)???).tnt.containsKey(localObject8))
    {
      ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((com.tencent.mm.plugin.appbrand.t.k)???).tnt.remove(localObject8);
      if (??? != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
      }
    }
    k.Um(this.mAppId);
    this.qsk.setOnHierarchyChangeListener(null);
    this.qsk.removeAllViewsInLayout();
    this.pmu.cQI();
    this.qsn.cQI();
    if (this.qsp != null)
    {
      localObject10 = this.qsp;
      if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject10).tCd != null)
      {
        localObject8 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject10).tCd;
        ??? = localObject8;
        if (localObject8 == null)
        {
          kotlin.g.b.s.bIx("capsuleBarView");
          ??? = null;
        }
        if (((com.tencent.mm.plugin.appbrand.page.capsulebar.d)???).tCb != null) {
          ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)???).tCb.animate().cancel();
        }
        ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)???).removeAllViews();
      }
      if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject10).tCg != null)
      {
        localObject8 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject10).tCg;
        ??? = localObject8;
        if (localObject8 == null)
        {
          kotlin.g.b.s.bIx("blinkWrapper");
          ??? = null;
        }
        ((l)???).cGs();
      }
    }
    this.qsq = null;
    if (this.qso != null)
    {
      this.qso.removeAllViews();
      this.qso = null;
    }
    if (this.mInitialized)
    {
      this.qsi.cleanup();
      this.qsi = null;
      this.qsj.cleanup();
      this.qsj = null;
    }
    this.qst.clear();
    synchronized (this.qsy)
    {
      this.qsy.clear();
      bl.S(this);
      this.qsz.unregisterAll();
      this.qsW.clear();
      this.qse.removeCallbacksAndMessages(null);
      this.qsV.stopTimer();
      this.qsX.clear();
      this.qsm = false;
      aa.at(this);
      com.tencent.mm.plugin.appbrand.jsapi.ad.h.aby(this.mAppId);
      this.qsv.clear();
      ??? = this.qsw;
      ((bd)???).qyi.clear();
      ((bd)???).qyj.set(false);
      this.qsx.clear();
      AppMethodBeat.o(176506);
      return;
    }
  }
  
  protected final void dispatchPause()
  {
    AppMethodBeat.i(176504);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(176504);
      return;
    }
    if (this.qsE.get())
    {
      AppMethodBeat.o(176504);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.qsB.qKC.a(d.a.qKZ);
    this.qsi.apx();
    this.qsj.onBackground();
    k.Uj(this.mAppId);
    k.a(this.mAppId, k.b.qrC);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
      com.tencent.mm.plugin.appbrand.jsapi.audio.d.m(this.qsi);
      AppMethodBeat.o(176504);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
      }
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
    if ((this.qsE.get()) || (this.qsF))
    {
      this.mResumed = true;
      a(null, "");
      AppMethodBeat.o(176508);
      return;
    }
    this.mResumed = true;
    k.Un(this.mAppId);
    k.Uk(this.mAppId);
    k.a(this.mAppId, k.b.qrB);
    boolean bool = this.qsG;
    this.qsj.onForeground();
    this.qsB.qKC.a(d.a.qLa, "onRuntimeResume");
    this.qsi.cP(bool);
    onResume();
    if (bool) {
      this.qsj.aM(cby(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.k localk = this.qsA;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), localk.uqE);
      cbL();
      this.qsF = false;
      this.qsG = false;
      com.tencent.mm.plugin.appbrand.jsapi.audio.d.n(this.qsi);
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
  
  public final void dt(View paramView)
  {
    AppMethodBeat.i(317289);
    bh.qyv.a(this, paramView);
    AppMethodBeat.o(317289);
  }
  
  protected com.tencent.mm.plugin.appbrand.widget.e et(Context paramContext)
  {
    AppMethodBeat.i(317279);
    if (com.tencent.mm.plugin.appbrand.utils.ac.fo(paramContext))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.widget.c(paramContext);
      AppMethodBeat.o(317279);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.appbrand.widget.e(paramContext);
    AppMethodBeat.o(317279);
    return paramContext;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134507);
    super.finalize();
    this.qse.removeCallbacksAndMessages(null);
    AppMethodBeat.o(134507);
  }
  
  public void finish()
  {
    AppMethodBeat.i(134508);
    if (this.qsE.get())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(134508);
      return;
    }
    this.ccV = true;
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317250);
        if (AppBrandRuntime.u(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchDestroy();
          AppMethodBeat.o(317250);
          return;
        }
        AppBrandRuntime.u(AppBrandRuntime.this).A(AppBrandRuntime.this);
        AppMethodBeat.o(317250);
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
  
  public ca getDecorWidgetFactory()
  {
    return null;
  }
  
  public w getFileSystem()
  {
    return this.qsr;
  }
  
  public x getPageContainer()
  {
    return this.qsj;
  }
  
  public final com.tencent.mm.plugin.appbrand.ad.f getRuntimeAdViewContainer()
  {
    AppMethodBeat.i(176513);
    com.tencent.mm.plugin.appbrand.ad.f localf = null;
    String str2;
    if ((this.qsl instanceof ai))
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use AdLoadingSplash RuntimeAdViewContainer", new Object[] { this.mAppId });
      localf = ((ai)this.qsl).getRuntimeAdViewContainer();
      str2 = this.mAppId;
      if (this.qsl != null) {
        break label135;
      }
    }
    label135:
    for (String str1 = "null";; str1 = this.qsl.getClass().getSimpleName())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer:%s, appId:%s, splash:%s", new Object[] { localf, str2, str1 });
      AppMethodBeat.o(176513);
      return localf;
      if (this.qso == null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use secondaryRuntimeAdViewContainer", new Object[] { this.mAppId });
      localf = this.qso;
      break;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.qsc == null)
    {
      String str = this.mAppId;
      if (this.qsd == null) {}
      for (localObject = null;; localObject = this.qsd.getClass().getName())
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return default %s", new Object[] { str, localObject });
        if (this.qsd == null) {
          break;
        }
        localObject = this.qsd;
        AppMethodBeat.o(176502);
        return localObject;
      }
      localObject = new o();
      this.qsd = ((com.tencent.mm.plugin.appbrand.platform.window.c)localObject);
      AppMethodBeat.o(176502);
      return localObject;
    }
    Object localObject = this.qsc.getWindowAndroid();
    AppMethodBeat.o(176502);
    return localObject;
  }
  
  public final void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(317293);
    if ((this.qsr == null) || (paramBoolean)) {
      this.qsr = asy();
    }
    AppMethodBeat.o(317293);
  }
  
  public final void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(317478);
    this.qsJ = paramBoolean;
    if (getPageContainer() == null) {}
    for (com.tencent.mm.plugin.appbrand.page.u localu = null;; localu = getPageContainer().getCurrentPage())
    {
      if (localu != null) {
        localu.cEj();
      }
      AppMethodBeat.o(317478);
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
    if (this.qsE.get())
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
    paramRunnable = ab.a(this.qsf, paramRunnable);
    keep(paramRunnable);
    this.qse.postDelayed(paramRunnable, l);
    AppMethodBeat.o(134520);
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(134479);
    if ((this.qsc != null) && (this.qsc.z(this)))
    {
      AppMethodBeat.o(134479);
      return true;
    }
    AppMethodBeat.o(134479);
    return false;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(134473);
    this.qsf.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(317411);
    if (this.qsl == null)
    {
      if (this.qsn.onBackPressed())
      {
        AppMethodBeat.o(317411);
        return;
      }
      if (this.pmu.onBackPressed())
      {
        AppMethodBeat.o(317411);
        return;
      }
      if (this.qsj != null)
      {
        this.qsj.onBackPressed();
        AppMethodBeat.o(317411);
      }
    }
    else
    {
      k.a(this.mAppId, k.d.qrH);
      finish();
    }
    AppMethodBeat.o(317411);
  }
  
  protected void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(176503);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(316578);
        AppBrandRuntime.a(AppBrandRuntime.this, paramConfiguration);
        AppMethodBeat.o(316578);
        return false;
      }
    });
    Object localObject;
    if (this.qsM != null)
    {
      localObject = this.qsM;
      com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.appbrand.pip.g)localObject).exO, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (((com.tencent.mm.plugin.appbrand.pip.g)localObject).tKh != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.pip.g)localObject).tKh;
        com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.appbrand.pip.b)localObject).exO, "onConfigurationChanged");
        if (((com.tencent.mm.plugin.appbrand.pip.b)localObject).tJc) {
          break label104;
        }
        com.tencent.mm.sdk.platformtools.Log.d(((com.tencent.mm.plugin.appbrand.pip.b)localObject).exO, "onConfigurationChanged, false == mHandleStarted");
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ad.h.a(this.mAppId, paramConfiguration);
      AppMethodBeat.o(176503);
      return;
      label104:
      ((com.tencent.mm.plugin.appbrand.pip.b)localObject).tIZ.a(((com.tencent.mm.plugin.appbrand.pip.b)localObject).enm, new b.1((com.tencent.mm.plugin.appbrand.pip.b)localObject));
    }
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
    AppMethodBeat.i(317377);
    this.qsi.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.qsi.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(317377);
  }
  
  protected void onResume() {}
  
  static abstract interface a
  {
    public abstract void done();
  }
  
  public static abstract class b
  {
    AppBrandRuntime.a qtp;
    
    public void interrupt() {}
    
    public abstract void prepare();
    
    public void ready()
    {
      if (this.qtp != null) {
        this.qtp.done();
      }
    }
  }
  
  final class c
    implements AppBrandRuntime.a, com.tencent.mm.vending.e.a
  {
    private final String _TAG;
    private volatile boolean qtq;
    
    private c()
    {
      AppMethodBeat.i(134470);
      this._TAG = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()) });
      AppBrandRuntime.this.keep(this);
      this.qtq = false;
      AppMethodBeat.o(134470);
    }
    
    public final void dead()
    {
      this.qtq = true;
    }
    
    public final void done()
    {
      AppMethodBeat.i(134471);
      if (!this.qtq)
      {
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134469);
            if (!AppBrandRuntime.c.a(AppBrandRuntime.c.this))
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
        AppBrandRuntime.this.a(this);
        AppMethodBeat.o(134471);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
      AppMethodBeat.o(134471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */