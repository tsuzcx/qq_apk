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
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p.a.c;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x.f;
import com.tencent.mm.plugin.appbrand.pip.b.1;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.utils.w;
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

public class AppBrandRuntime
  implements com.tencent.mm.plugin.appbrand.utils.r<com.tencent.mm.vending.e.a>
{
  public volatile boolean aol;
  public volatile String mAppId;
  public Context mContext;
  public volatile boolean mInitialized;
  public boolean mResumed;
  public com.tencent.mm.plugin.appbrand.widget.dialog.d msX;
  private volatile v ntA;
  private volatile com.tencent.mm.plugin.appbrand.page.x ntB;
  public com.tencent.mm.plugin.appbrand.widget.d ntC;
  protected com.tencent.mm.plugin.appbrand.ui.aa ntD;
  public com.tencent.mm.plugin.appbrand.widget.dialog.d ntE;
  public com.tencent.mm.plugin.appbrand.ad.f ntF;
  public com.tencent.mm.plugin.appbrand.page.capsulebar.e ntG;
  private volatile Boolean ntH;
  private volatile com.tencent.mm.plugin.appbrand.appstorage.r ntI;
  private AtomicBoolean ntJ;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<com.tencent.mm.plugin.appbrand.jsapi.l> ntK;
  public final aw ntL;
  private final ConcurrentSkipListSet<ar> ntM;
  final ax ntN;
  private final LinkedHashSet<m> ntO;
  private final ad ntP;
  private com.tencent.mm.plugin.appbrand.utils.g ntQ;
  public volatile com.tencent.mm.plugin.appbrand.a.c ntR;
  public com.tencent.mm.plugin.appbrand.p.a ntS;
  private volatile boolean ntT;
  public final AtomicBoolean ntU;
  private boolean ntV;
  public boolean ntW;
  private boolean ntX;
  public aq ntY;
  public boolean ntZ;
  public ak ntu;
  private com.tencent.mm.plugin.appbrand.platform.window.c ntv;
  private final MMHandler ntw;
  private final bc ntx;
  AppBrandRuntime nty;
  public volatile AppBrandInitConfig ntz;
  public boolean nua;
  public boolean nub;
  public com.tencent.mm.plugin.appbrand.pip.f nuc;
  private AppBrandPipContainerView nud;
  private AppBrandGlobalNativeWidgetContainerView nue;
  public com.tencent.mm.plugin.appbrand.page.k nuf;
  public boolean nug;
  private LinkedList<b> nuh;
  private ConcurrentLinkedQueue<b> nui;
  private final com.tencent.mm.ipcinvoker.p nuj;
  private final com.tencent.mm.ipcinvoker.q nuk;
  private final MTimerHandler nul;
  private final Deque<Runnable> nun;
  public SparseArray<Set<am>> nuo;
  
  private AppBrandRuntime(Context paramContext)
  {
    AppMethodBeat.i(246354);
    this.ntH = null;
    this.ntI = null;
    this.ntJ = new AtomicBoolean(false);
    this.ntK = new AppBrandRuntime.1(this);
    this.ntL = new aw();
    this.ntM = new ConcurrentSkipListSet(new Comparator() {});
    this.ntN = new ax();
    this.ntO = new LinkedHashSet();
    this.ntP = new ad();
    this.mResumed = false;
    this.ntU = new AtomicBoolean(false);
    this.ntZ = false;
    this.nua = true;
    this.nug = false;
    this.nuh = new LinkedList();
    this.nui = null;
    this.nuj = new com.tencent.mm.ipcinvoker.p()
    {
      public final void aFw()
      {
        AppMethodBeat.i(242691);
        AppBrandRuntime.t(AppBrandRuntime.this).set(true);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onDisconnect: appId=[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppMethodBeat.o(242691);
      }
    };
    this.nuk = new com.tencent.mm.ipcinvoker.q()
    {
      public final void aFx()
      {
        AppMethodBeat.i(244196);
        if (AppBrandRuntime.t(AppBrandRuntime.this).getAndSet(false)) {
          AppBrandRuntime.u(AppBrandRuntime.this);
        }
        AppMethodBeat.o(244196);
      }
    };
    this.nul = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(245697);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppBrandRuntime.this.bCk();
        AppMethodBeat.o(245697);
        return false;
      }
    }, false);
    this.nun = new LinkedBlockingDeque();
    this.nuo = new SparseArray();
    this.mContext = paramContext;
    this.ntw = new MMHandler(Looper.getMainLooper());
    this.ntx = new bc();
    this.ntC = dC(paramContext);
    this.ntC.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.msX = new com.tencent.mm.plugin.appbrand.widget.dialog.d(this.mContext);
    this.ntE = new com.tencent.mm.plugin.appbrand.widget.dialog.d(this.mContext);
    this.ntQ = new com.tencent.mm.plugin.appbrand.utils.g();
    this.nub = false;
    AppMethodBeat.o(246354);
  }
  
  public AppBrandRuntime(ak paramak)
  {
    this(paramak.getContext());
    AppMethodBeat.i(176500);
    this.ntu = paramak;
    this.ntv = null;
    AppMethodBeat.o(176500);
  }
  
  protected AppBrandRuntime(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this(paramc.getContext());
    AppMethodBeat.i(246357);
    this.ntu = null;
    this.ntv = paramc;
    AppMethodBeat.o(246357);
  }
  
  private void bCp()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.h.d.a(this.mAppId + ":performInitPageContainer", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134447);
        AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.bCn());
        AppBrandRuntime.n(AppBrandRuntime.this).setOnReadyListener(new x.f()
        {
          public final void bCF()
          {
            AppMethodBeat.i(176492);
            AppBrandRuntime.m(AppBrandRuntime.this);
            AppBrandRuntime.a(AppBrandRuntime.this, null);
            AppMethodBeat.o(176492);
          }
        });
        bb.nzr.a(AppBrandRuntime.this, AppBrandRuntime.n(AppBrandRuntime.this));
        AppBrandRuntime.n(AppBrandRuntime.this).init(AppBrandRuntime.o(AppBrandRuntime.this).nBq);
        AppMethodBeat.o(134447);
      }
    });
    AppMethodBeat.o(134499);
  }
  
  private void bCq()
  {
    AppMethodBeat.i(134500);
    com.tencent.luggage.sdk.h.d.a(this.mAppId + ":performInitService", new Runnable()
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
  
  protected boolean N(Runnable paramRunnable)
  {
    return false;
  }
  
  protected void NR()
  {
    AppMethodBeat.i(246384);
    this.ntA.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.ntA.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(246384);
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.aol) || (this.ntU.get()))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134518);
      return;
    }
    if (this.mInitialized)
    {
      h(paramRunnable, 0L);
      AppMethodBeat.o(134518);
      return;
    }
    this.nun.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(292970);
    h(paramRunnable, 0L);
    AppMethodBeat.o(292970);
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(292971);
    R(paramRunnable);
    AppMethodBeat.o(292971);
  }
  
  public v QW()
  {
    return this.ntA;
  }
  
  public final void R(Runnable paramRunnable)
  {
    AppMethodBeat.i(246394);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(246394);
      return;
    }
    if (this.ntU.get())
    {
      AppMethodBeat.o(246394);
      return;
    }
    paramRunnable = w.a(this.ntx, paramRunnable);
    keep(paramRunnable);
    com.tencent.e.h.ZvG.o(paramRunnable, 0L);
    AppMethodBeat.o(246394);
  }
  
  protected com.tencent.mm.plugin.appbrand.appstorage.r Si()
  {
    AppMethodBeat.i(134486);
    y localy = new y(this);
    AppMethodBeat.o(134486);
    return localy;
  }
  
  protected void Sl() {}
  
  protected com.tencent.mm.plugin.appbrand.p.a Sn()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public com.tencent.mm.plugin.appbrand.config.l Sp()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.l locall = (com.tencent.mm.plugin.appbrand.config.l)au(com.tencent.mm.plugin.appbrand.config.l.class);
    AppMethodBeat.o(134481);
    return locall;
  }
  
  public AppBrandInitConfig Sq()
  {
    return this.ntz;
  }
  
  protected <T extends com.tencent.mm.kernel.c.a> T V(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final am paramam)
  {
    AppMethodBeat.i(178506);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
    h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176497);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
        paramam.nyD = paramInt2;
        paramam.nyC = paramInt1;
        int i;
        if (AppBrandRuntime.v(AppBrandRuntime.this).get(paramam.nyC) != null)
        {
          i = 1;
          if (i == 0) {
            break label125;
          }
        }
        label125:
        for (Object localObject = (Set)AppBrandRuntime.v(AppBrandRuntime.this).get(paramam.nyC);; localObject = new CopyOnWriteArraySet())
        {
          ((Set)localObject).add(paramam);
          if (i == 0) {
            AppBrandRuntime.v(AppBrandRuntime.this).put(paramam.nyC, localObject);
          }
          AppMethodBeat.o(176497);
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
    this.nuh.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ak paramak)
  {
    AppMethodBeat.i(246359);
    this.ntu = paramak;
    if (this.ntu != null)
    {
      this.ntL.b(this.ntu);
      AppMethodBeat.o(246359);
      return;
    }
    this.ntL.bEn();
    AppMethodBeat.o(246359);
  }
  
  public final void a(final am paramam)
  {
    AppMethodBeat.i(134522);
    h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176498);
        Set localSet = (Set)AppBrandRuntime.v(AppBrandRuntime.this).get(paramam.nyC);
        if (localSet != null) {
          localSet.remove(paramam);
        }
        AppMethodBeat.o(176498);
      }
    }, 0L);
    AppMethodBeat.o(134522);
  }
  
  protected final void a(ar paramar)
  {
    AppMethodBeat.i(246381);
    if (this.mInitialized)
    {
      paramar.bEo();
      AppMethodBeat.o(246381);
      return;
    }
    this.ntM.add(paramar);
    AppMethodBeat.o(246381);
  }
  
  protected final void a(ay paramay)
  {
    AppMethodBeat.i(246383);
    ax localax = this.ntN;
    if (localax.nzh.get())
    {
      AppMethodBeat.o(246383);
      return;
    }
    localax.nzg.add(paramay);
    AppMethodBeat.o(246383);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.ntz = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(246387);
    if (!this.mResumed)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", new Object[] { this.mAppId, paramString });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.ntz = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(246387);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", new Object[] { this.mAppId, paramString, android.util.Log.getStackTraceString(new Throwable()) });
    dispatchPause();
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      bBT();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(246387);
      return;
      paramAppBrandInitConfig = Sq();
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this.ntv = paramc;
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.ntx.a(parama);
    AppMethodBeat.o(160924);
  }
  
  public final boolean a(m paramm)
  {
    AppMethodBeat.i(134493);
    if (paramm == null)
    {
      AppMethodBeat.o(134493);
      return false;
    }
    synchronized (this.ntO)
    {
      this.ntO.add(paramm);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  protected final void abO(String paramString)
  {
    AppMethodBeat.i(246374);
    Object localObject = this.nui;
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { paramString, ((b)((Iterator)localObject).next()).toString() });
      }
      AppMethodBeat.o(246374);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { paramString });
    AppMethodBeat.o(246374);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ae(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.ntP.ao(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.j.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.j.rnO);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    paramClass = V(paramClass);
    AppMethodBeat.o(134494);
    return paramClass;
  }
  
  public final void af(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(134496);
    this.ntP.af(paramClass);
    AppMethodBeat.o(134496);
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.l> T au(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.nug) {}
    for (boolean bool = true;; bool = false)
    {
      paramClass = d(paramClass, bool);
      AppMethodBeat.o(134491);
      return paramClass;
    }
  }
  
  public final <T extends m> T av(Class<T> paramClass)
  {
    AppMethodBeat.i(134492);
    if (paramClass == null)
    {
      AppMethodBeat.o(134492);
      return null;
    }
    synchronized (this.ntO)
    {
      Iterator localIterator = this.ntO.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        if (paramClass.isInstance(localm))
        {
          AppMethodBeat.o(134492);
          return localm;
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
    this.ntK.add(paramb);
    AppMethodBeat.o(134483);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(134495);
    this.ntP.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final boolean b(m paramm)
  {
    AppMethodBeat.i(246370);
    if (paramm == null)
    {
      AppMethodBeat.o(246370);
      return false;
    }
    synchronized (this.ntO)
    {
      this.ntO.remove(paramm);
      AppMethodBeat.o(246370);
      return true;
    }
  }
  
  public final void bBT()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    long l = Util.currentTicks();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    bBU();
    com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242657);
        AppBrandRuntime.f(AppBrandRuntime.this);
        AppMethodBeat.o(242657);
      }
    });
    com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134463);
        AppBrandRuntime.a(AppBrandRuntime.this, new AppBrandRuntime.c(AppBrandRuntime.this, (byte)0));
        AppMethodBeat.o(134463);
      }
    });
    com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134464);
        AppBrandRuntime.this.bCf();
        AppMethodBeat.o(134464);
      }
    });
    this.nul.startTimer(10000L);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(Util.currentTicks() - l) });
    AppMethodBeat.o(134475);
  }
  
  protected void bBU() {}
  
  public final int bBV()
  {
    return this.ntz.cBI;
  }
  
  public final AppBrandRuntime bBW()
  {
    AppMethodBeat.i(134478);
    if (this.ntu == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.ntu.w(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public com.tencent.mm.plugin.appbrand.page.x bBX()
  {
    return this.ntB;
  }
  
  public final ak bBY()
  {
    return this.ntu;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.d bBZ()
  {
    return this.ntC;
  }
  
  public final boolean bCA()
  {
    AppMethodBeat.i(246395);
    if (this.ntH == null) {
      this.ntH = Boolean.valueOf(((com.tencent.mm.plugin.appbrand.ad.k)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.k.class)).I(this));
    }
    boolean bool = this.ntH.booleanValue();
    AppMethodBeat.o(246395);
    return bool;
  }
  
  public final boolean bCB()
  {
    AppMethodBeat.i(246396);
    if ((this.ntD instanceof ab)) {}
    for (boolean bool = ((ab)this.ntD).bCB();; bool = false)
    {
      String str2 = this.mAppId;
      if (this.ntD == null) {}
      for (String str1 = "null";; str1 = this.ntD.getClass().getSimpleName())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
        AppMethodBeat.o(246396);
        return bool;
      }
    }
  }
  
  public final void bCC()
  {
    this.ntD = null;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.capsulebar.e bCD()
  {
    return this.ntG;
  }
  
  public final void bCE()
  {
    this.nub = true;
  }
  
  public void bCa() {}
  
  public final com.tencent.mm.plugin.appbrand.a.c bCb()
  {
    return this.ntR;
  }
  
  public final void bCc()
  {
    AppMethodBeat.i(134485);
    if (this.ntI == null) {
      this.ntI = Si();
    }
    AppMethodBeat.o(134485);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.l bCd()
  {
    return this.ntE;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.aa bCe()
  {
    return null;
  }
  
  protected final void bCf()
  {
    AppMethodBeat.i(134487);
    if (this.ntD != null)
    {
      com.tencent.mm.plugin.appbrand.ui.j.a(this.ntD);
      this.ntD = null;
    }
    Object localObject = bCe();
    if (localObject == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.aa)localObject).eC(Sq().iconUrl, Sq().fzM);
    View localView = ((com.tencent.mm.plugin.appbrand.ui.aa)localObject).getView();
    bb.nzx.a(this, localView);
    this.ntD = ((com.tencent.mm.plugin.appbrand.ui.aa)localObject);
    String str = this.mAppId;
    if (this.ntD == null) {}
    for (localObject = "null";; localObject = this.ntD.getClass().getSimpleName())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", new Object[] { str, localObject });
      localView.setClickable(true);
      final int i = localView.hashCode();
      this.ntC.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2) {}
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(243140);
          if ((paramAnonymousView2.hashCode() == i) && (!AppBrandRuntime.this.ntU.get()))
          {
            paramAnonymousView1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243360);
                if (AppBrandRuntime.this.mResumed)
                {
                  AppBrandRuntime.this.bBX().setActuallyVisible(true);
                  AppMethodBeat.o(243360);
                  return;
                }
                AppBrandRuntime.this.ntR.a(new com.tencent.mm.plugin.appbrand.a.c.a()
                {
                  public final void a(String paramAnonymous3String, com.tencent.mm.plugin.appbrand.a.b paramAnonymous3b)
                  {
                    AppMethodBeat.i(244376);
                    if (com.tencent.mm.plugin.appbrand.a.b.nKP == paramAnonymous3b)
                    {
                      AppBrandRuntime.this.bBX().setActuallyVisible(true);
                      AppBrandRuntime.this.ntR.b(this);
                    }
                    AppMethodBeat.o(244376);
                  }
                });
                AppMethodBeat.o(243360);
              }
            };
            AppBrandRuntime.this.bCg();
            if (AppBrandRuntime.this.bBX() == null)
            {
              AppBrandRuntime.this.O(paramAnonymousView1);
              AppMethodBeat.o(243140);
              return;
            }
            paramAnonymousView1.run();
          }
          AppMethodBeat.o(243140);
        }
      });
      AppMethodBeat.o(134487);
      return;
    }
  }
  
  protected void bCg() {}
  
  public final void bCh()
  {
    AppMethodBeat.i(134488);
    if (this.ntU.get())
    {
      if (this.ntD != null) {
        com.tencent.mm.plugin.appbrand.ui.j.a(this.ntD);
      }
      this.ntD = null;
      AppMethodBeat.o(134488);
      return;
    }
    if (this.ntD == null)
    {
      AppMethodBeat.o(134488);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.printInfoStack("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", new Object[] { this.ntD.getClass().getSimpleName() });
    kotlin.g.a.a local24 = new kotlin.g.a.a() {};
    if ((this.ntD instanceof ae))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "[weishi] hideSplash, hideLoadingSplashFromRuntime");
      ((ae)this.ntD).z(local24);
      AppMethodBeat.o(134488);
      return;
    }
    this.ntD.x(local24);
    AppMethodBeat.o(134488);
  }
  
  public final String bCi()
  {
    AppMethodBeat.i(134489);
    if (this.ntz == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (Util.isNullOrNil(this.ntz.nBq))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().bKX();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.ntz.nBq;
    AppMethodBeat.o(134489);
    return str;
  }
  
  public final boolean bCj()
  {
    return this.mInitialized;
  }
  
  protected void bCk()
  {
    AppMethodBeat.i(246373);
    this.ntN.bCk();
    AppMethodBeat.o(246373);
  }
  
  protected void bCl() {}
  
  protected v bCm()
  {
    AppMethodBeat.i(134497);
    v localv = new v();
    AppMethodBeat.o(134497);
    return localv;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.x bCn()
  {
    AppMethodBeat.i(134498);
    com.tencent.mm.plugin.appbrand.page.x localx = new com.tencent.mm.plugin.appbrand.page.x(this.mContext, this);
    AppMethodBeat.o(134498);
    return localx;
  }
  
  public boolean bCo()
  {
    return true;
  }
  
  protected void bCr() {}
  
  protected final void bCs()
  {
    AppMethodBeat.i(134513);
    this.ntV = true;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  protected final boolean bCt()
  {
    return this.ntV;
  }
  
  protected final void bCu()
  {
    AppMethodBeat.i(246388);
    if (this.ntV)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
      AppMethodBeat.o(246388);
      return;
    }
    this.ntW = true;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(246388);
  }
  
  protected final boolean bCv()
  {
    return this.ntW;
  }
  
  public final boolean bCw()
  {
    AppMethodBeat.i(134514);
    if (!this.nua)
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
    if ((this.ntB != null) && (this.ntB.getCurrentPage() != null) && (!this.ntB.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  public void bCx()
  {
    AppMethodBeat.i(176510);
    R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134457);
        final com.tencent.mm.plugin.appbrand.platform.window.c localc = AppBrandRuntime.this.getWindowAndroid();
        if (localc == null)
        {
          AppMethodBeat.o(134457);
          return;
        }
        Object localObject = AppBrandRuntime.this.getAppConfig();
        if (localObject == null) {}
        int i;
        for (localObject = new com.tencent.mm.plugin.appbrand.platform.window.c.a(AppBrandRuntime.this.Sq().fzM);; localObject = new com.tencent.mm.plugin.appbrand.platform.window.c.a(AppBrandRuntime.this.Sq().fzM, null, i))
        {
          localc.setWindowDescription((com.tencent.mm.plugin.appbrand.platform.window.c.a)localObject);
          com.tencent.mm.modelappbrand.a.b.bhh().a(new b.c()
          {
            public final void G(Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(243898);
              localc.setWindowDescription(new com.tencent.mm.plugin.appbrand.platform.window.c.a(this.nuu.label, paramAnonymous2Bitmap, this.nuu.colorPrimary));
              AppMethodBeat.o(243898);
            }
          }, AppBrandRuntime.this.Sq().iconUrl, com.tencent.mm.modelappbrand.a.g.lzF);
          AppMethodBeat.o(134457);
          return;
          i = com.tencent.mm.plugin.appbrand.ac.g.cO(((com.tencent.mm.plugin.appbrand.config.b)localObject).bKU().nWr, -16777216);
        }
      }
    });
    AppMethodBeat.o(176510);
  }
  
  public boolean bCy()
  {
    AppMethodBeat.i(134517);
    if (this.ntR.nKU.bIg() == com.tencent.mm.plugin.appbrand.a.b.nKR) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      AppMethodBeat.o(134517);
      return true;
    }
    AppMethodBeat.o(134517);
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.aa bCz()
  {
    return this.ntD;
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
    this.ntz = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.ntR = new com.tencent.mm.plugin.appbrand.a.c(this);
    this.ntR.nKU.start();
    this.ntR.a(new com.tencent.mm.plugin.appbrand.a.c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(245618);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntime.this;
        HashMap localHashMap = new HashMap();
        switch (com.tencent.mm.plugin.appbrand.page.q.1.nLn[paramAnonymousb.ordinal()])
        {
        default: 
          AppMethodBeat.o(245618);
          return;
        case 1: 
          paramAnonymousString = "background";
        }
        for (;;)
        {
          localHashMap.put("status", paramAnonymousString);
          new com.tencent.mm.plugin.appbrand.page.q().D(localHashMap).i(localAppBrandRuntime.QW()).bPO();
          AppMethodBeat.o(245618);
          return;
          paramAnonymousString = "active";
          continue;
          paramAnonymousString = "suspend";
        }
      }
    });
    this.mInitialized = false;
    this.ntT = false;
    this.ntU.set(false);
    this.aol = false;
    this.ntV = false;
    this.ntW = false;
    this.ntX = false;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(134474);
  }
  
  public final void cM(View paramView)
  {
    AppMethodBeat.i(246366);
    bb.nzv.a(this, paramView);
    AppMethodBeat.o(246366);
  }
  
  public void close()
  {
    AppMethodBeat.i(134511);
    com.tencent.luggage.k.g.aK(AndroidContextUtil.castActivityOrNull(this.mContext));
    cp(null);
    AppMethodBeat.o(134511);
  }
  
  public final void cp(final Object paramObject)
  {
    AppMethodBeat.i(176509);
    h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243341);
        if ((!AppBrandRuntime.this.mInitialized) || (AppBrandRuntime.this.ntU.get()))
        {
          if (AppBrandRuntime.s(AppBrandRuntime.this) == null)
          {
            AppBrandRuntime.this.dispatchDestroy();
            AppMethodBeat.o(243341);
            return;
          }
          AppBrandRuntime.s(AppBrandRuntime.this).y(AppBrandRuntime.this);
          AppMethodBeat.o(243341);
          return;
        }
        if (AppBrandRuntime.s(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchPause();
          AppMethodBeat.o(243341);
          return;
        }
        AppBrandRuntime.s(AppBrandRuntime.this).a(AppBrandRuntime.this, paramObject);
        AppMethodBeat.o(243341);
      }
    }, 0L);
    AppMethodBeat.o(176509);
  }
  
  /* Error */
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.l> T d(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1519
    //   3: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 208	com/tencent/mm/plugin/appbrand/AppBrandRuntime:ntK	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1524	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 540 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 544 1 0
    //   38: checkcast 1526	com/tencent/mm/plugin/appbrand/jsapi/l
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1229	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1532	org/a/a:ce	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1536	org/a/a:iVg	()Lorg/a/a;
    //   65: getfield 1540	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1526	com/tencent/mm/plugin/appbrand/jsapi/l
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 208	com/tencent/mm/plugin/appbrand/AppBrandRuntime:ntK	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 1236 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1519
    //   99: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 384
    //   109: ldc_w 1542
    //   112: iconst_1
    //   113: anewarray 5	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1545	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 698	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   20	83	3	locall1	com.tencent.mm.plugin.appbrand.jsapi.l
    //   129	1	3	localException1	java.lang.Exception
    //   132	1	3	localException2	java.lang.Exception
    //   7	87	4	locall2	com.tencent.mm.plugin.appbrand.jsapi.l
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
      if ((!this.ntU.get()) && (!this.aol))
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
      if (this.ntX)
      {
        this.ntX = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        bCs();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(134477);
      return;
      i = j;
      if (paramAppBrandInitConfig.cBI == this.ntz.cBI)
      {
        i = j;
        if (paramAppBrandInitConfig.nXY == this.ntz.nXY) {
          i = 0;
        }
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.widget.d dC(Context paramContext)
  {
    AppMethodBeat.i(246356);
    if (com.tencent.mm.plugin.appbrand.utils.x.es(paramContext))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.widget.c(paramContext);
      AppMethodBeat.o(246356);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.appbrand.widget.d(paramContext);
    AppMethodBeat.o(246356);
    return paramContext;
  }
  
  final void dispatchDestroy()
  {
    AppMethodBeat.i(176506);
    boolean bool = this.ntU.getAndSet(true);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "dispatchDestroy, appId[%s] destroyed?[%b] initialized?[%b] initReady?[%b]", new Object[] { this.mAppId, Boolean.valueOf(bool), Boolean.valueOf(this.mInitialized), Boolean.valueOf(this.ntT) });
    if (bool)
    {
      AppMethodBeat.o(176506);
      return;
    }
    ??? = this.nui;
    this.nui = null;
    if ((??? == null) || (((Queue)???).isEmpty())) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { this.mAppId });
    }
    for (;;)
    {
      onDestroy();
      ??? = this.ntx;
      localObject2 = ((bc)???).nzA.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject2).next()).dead();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", new Object[] { Integer.valueOf(((Queue)???).size()), this.mAppId });
      while (!((Queue)???).isEmpty()) {
        ((b)((Queue)???).poll()).interrupt();
      }
    }
    ((bc)???).nzA.clear();
    this.ntI = null;
    com.tencent.mm.plugin.appbrand.media.a.a.agY(this.mAppId);
    ??? = MMApplicationContext.getMainProcessName();
    com.tencent.mm.ipcinvoker.j.c((String)???, this.nuj);
    com.tencent.mm.ipcinvoker.j.c((String)???, this.nuk);
    k.abF(this.mAppId);
    k.a(this.mAppId, k.b.nsZ);
    com.tencent.luggage.k.g.aK(AndroidContextUtil.castActivityOrNull(this.mContext));
    Object localObject2 = this.ntR;
    ((com.tencent.mm.plugin.appbrand.a.c)localObject2).nKU.stop();
    synchronized (((com.tencent.mm.plugin.appbrand.a.c)localObject2).nKV)
    {
      ((com.tencent.mm.plugin.appbrand.a.c)localObject2).nKV.clear();
      this.ntY = null;
      ??? = com.tencent.mm.plugin.appbrand.s.f.cbR();
      localObject2 = this.mAppId;
      if (((com.tencent.mm.plugin.appbrand.s.f)???).qiH.containsKey(localObject2)) {
        localObject2 = (com.tencent.mm.plugin.appbrand.s.d)((com.tencent.mm.plugin.appbrand.s.f)???).qiH.remove(localObject2);
      }
    }
    Iterator localIterator;
    synchronized (((com.tencent.mm.plugin.appbrand.s.d)localObject2).qiJ)
    {
      ((com.tencent.mm.plugin.appbrand.s.d)localObject2).qiJ.clear();
      ((com.tencent.mm.plugin.appbrand.s.d)localObject2).qiL.clear();
      ((com.tencent.mm.plugin.appbrand.s.d)localObject2).qiK.clear();
      ??? = com.tencent.mm.plugin.appbrand.s.c.cbO();
      localObject2 = this.mAppId;
      if (!((com.tencent.mm.plugin.appbrand.s.c)???).qiH.containsKey(localObject2)) {
        break label502;
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.s.b)((com.tencent.mm.plugin.appbrand.s.c)???).qiH.remove(localObject2);
      synchronized (((com.tencent.mm.plugin.appbrand.s.b)localObject2).qiD)
      {
        localIterator = ((com.tencent.mm.plugin.appbrand.s.b)localObject2).qiD.iterator();
        if (!localIterator.hasNext()) {
          break label493;
        }
        ((com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next()).isRunning = false;
      }
      localObject4 = finally;
      AppMethodBeat.o(176506);
      throw localObject4;
    }
    label493:
    localObject5.qiD.clear();
    label502:
    ??? = com.tencent.mm.plugin.appbrand.s.i.cbT();
    Object localObject6 = this.mAppId;
    if (((com.tencent.mm.plugin.appbrand.s.i)???).qiH.containsKey(localObject6))
    {
      localObject6 = (com.tencent.mm.plugin.appbrand.s.g)((com.tencent.mm.plugin.appbrand.s.i)???).qiH.remove(localObject6);
      synchronized (((com.tencent.mm.plugin.appbrand.s.g)localObject6).qjo)
      {
        localIterator = ((com.tencent.mm.plugin.appbrand.s.g)localObject6).qjo.iterator();
        if (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.appbrand.s.h)localIterator.next()).isRunning = false;
        }
      }
      localObject7.qjo.clear();
    }
    ??? = com.tencent.mm.plugin.appbrand.s.l.cbW();
    Object localObject8 = this.mAppId;
    if (((com.tencent.mm.plugin.appbrand.s.l)???).qiH.containsKey(localObject8))
    {
      ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((com.tencent.mm.plugin.appbrand.s.l)???).qiH.remove(localObject8);
      if (??? != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
      }
    }
    k.abK(this.mAppId);
    this.ntC.setOnHierarchyChangeListener(null);
    this.ntC.removeAllViewsInLayout();
    this.msX.cnJ();
    this.ntE.cnJ();
    if (this.ntG != null)
    {
      ??? = this.ntG;
      if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).qxe != null)
      {
        localObject8 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).qxe;
        if (localObject8 == null) {
          kotlin.g.b.p.bGy("capsuleBarView");
        }
        if (((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject8).qxc != null) {
          ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject8).qxc.animate().cancel();
        }
        ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject8).removeAllViews();
      }
      if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).qxg != null)
      {
        ??? = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).qxg;
        if (??? == null) {
          kotlin.g.b.p.bGy("blinkWrapper");
        }
        ((com.tencent.mm.plugin.appbrand.page.capsulebar.h)???).cfD();
      }
    }
    this.ntH = null;
    if (this.ntF != null)
    {
      this.ntF.removeAllViews();
      this.ntF = null;
    }
    if (this.mInitialized)
    {
      this.ntA.cleanup();
      this.ntA = null;
      this.ntB.cleanup();
      this.ntB = null;
    }
    this.ntK.clear();
    synchronized (this.ntO)
    {
      this.ntO.clear();
      bl.O(this);
      this.ntP.unregisterAll();
      this.nun.clear();
      this.ntw.removeCallbacksAndMessages(null);
      this.nul.stopTimer();
      this.nuo.clear();
      com.tencent.mm.plugin.appbrand.page.aa.af(this);
      this.ntM.clear();
      ??? = this.ntN;
      ((ax)???).nzg.clear();
      ((ax)???).nzh.set(false);
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
    if (this.ntU.get())
    {
      AppMethodBeat.o(176504);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.ntR.nKU.a(d.a.nLq);
    this.ntA.Pp();
    this.ntB.onBackground();
    k.abH(this.mAppId);
    k.a(this.mAppId, k.b.nsX);
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
    if ((this.ntU.get()) || (this.ntV))
    {
      this.mResumed = true;
      a(null, "");
      AppMethodBeat.o(176508);
      return;
    }
    this.mResumed = true;
    k.abL(this.mAppId);
    k.abI(this.mAppId);
    k.a(this.mAppId, k.b.nsW);
    boolean bool = this.ntW;
    this.ntB.onForeground();
    this.ntR.nKU.a(d.a.nLr, "onRuntimeResume");
    this.ntA.ci(bool);
    onResume();
    if (bool) {
      this.ntB.az(bCi(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.g localg = this.ntQ;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), localg.rit);
      bCx();
      this.ntV = false;
      this.ntW = false;
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
    this.ntw.removeCallbacksAndMessages(null);
    AppMethodBeat.o(134507);
  }
  
  public void finish()
  {
    AppMethodBeat.i(134508);
    if (this.ntU.get())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(134508);
      return;
    }
    this.aol = true;
    h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176493);
        if (AppBrandRuntime.s(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchDestroy();
          AppMethodBeat.o(176493);
          return;
        }
        AppBrandRuntime.s(AppBrandRuntime.this).y(AppBrandRuntime.this);
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
    AppMethodBeat.i(292968);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    AppMethodBeat.o(292968);
    return localActivity;
  }
  
  public bz getDecorWidgetFactory()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer()
  {
    return this.msX;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.r getFileSystem()
  {
    return this.ntI;
  }
  
  public final com.tencent.mm.plugin.appbrand.ad.f getRuntimeAdViewContainer()
  {
    AppMethodBeat.i(176513);
    com.tencent.mm.plugin.appbrand.ad.f localf = null;
    String str2;
    if ((this.ntD instanceof ab))
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use AdLoadingSplash RuntimeAdViewContainer", new Object[] { this.mAppId });
      localf = ((ab)this.ntD).getRuntimeAdViewContainer();
      str2 = this.mAppId;
      if (this.ntD != null) {
        break label135;
      }
    }
    label135:
    for (String str1 = "null";; str1 = this.ntD.getClass().getSimpleName())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer:%s, appId:%s, splash:%s", new Object[] { localf, str2, str1 });
      AppMethodBeat.o(176513);
      return localf;
      if (this.ntF == null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use secondaryRuntimeAdViewContainer", new Object[] { this.mAppId });
      localf = this.ntF;
      break;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.ntu == null)
    {
      String str = this.mAppId;
      if (this.ntv == null) {}
      for (localObject = null;; localObject = this.ntv.getClass().getName())
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return default %s", new Object[] { str, localObject });
        if (this.ntv == null) {
          break;
        }
        localObject = this.ntv;
        AppMethodBeat.o(176502);
        return localObject;
      }
      localObject = new o();
      this.ntv = ((com.tencent.mm.plugin.appbrand.platform.window.c)localObject);
      AppMethodBeat.o(176502);
      return localObject;
    }
    Object localObject = this.ntu.getWindowAndroid();
    AppMethodBeat.o(176502);
    return localObject;
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(134520);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(134520);
      return;
    }
    if (this.ntU.get())
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
    paramRunnable = w.a(this.ntx, paramRunnable);
    keep(paramRunnable);
    this.ntw.postDelayed(paramRunnable, l);
    AppMethodBeat.o(134520);
  }
  
  public final void he(boolean paramBoolean)
  {
    AppMethodBeat.i(246389);
    this.ntZ = paramBoolean;
    if (bBX() == null) {}
    for (u localu = null;; localu = bBX().getCurrentPage())
    {
      if (localu != null) {
        localu.cdF();
      }
      AppMethodBeat.o(246389);
      return;
    }
  }
  
  public final boolean isDestroyed()
  {
    AppMethodBeat.i(292969);
    boolean bool = this.ntU.get();
    AppMethodBeat.o(292969);
    return bool;
  }
  
  public final boolean isFinishing()
  {
    return this.aol;
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(134479);
    if ((this.ntu != null) && (this.ntu.x(this)))
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
    this.ntx.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(246385);
    if (this.ntD == null)
    {
      if (this.ntE.onBackPressed())
      {
        AppMethodBeat.o(246385);
        return;
      }
      if (this.msX.onBackPressed())
      {
        AppMethodBeat.o(246385);
        return;
      }
      if (this.ntB != null)
      {
        this.ntB.onBackPressed();
        AppMethodBeat.o(246385);
      }
    }
    else
    {
      k.a(this.mAppId, k.d.ntc);
      finish();
    }
    AppMethodBeat.o(246385);
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
    if (this.nuc != null)
    {
      com.tencent.mm.plugin.appbrand.pip.f localf = this.nuc;
      com.tencent.mm.sdk.platformtools.Log.i(localf.cED, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (localf.qFr != null)
      {
        paramConfiguration = localf.qFr;
        com.tencent.mm.sdk.platformtools.Log.i(paramConfiguration.cED, "onConfigurationChanged");
        if (!paramConfiguration.qEn)
        {
          com.tencent.mm.sdk.platformtools.Log.d(paramConfiguration.cED, "onConfigurationChanged, false == mHandleStarted");
          AppMethodBeat.o(176503);
          return;
        }
        paramConfiguration.qEk.a(paramConfiguration.cvo, new b.1(paramConfiguration));
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
  
  protected void onResume() {}
  
  static abstract interface a
  {
    public abstract void done();
  }
  
  public static abstract class b
  {
    AppBrandRuntime.a nuF;
    
    public void NO()
    {
      if (this.nuF != null) {
        this.nuF.done();
      }
    }
    
    public void interrupt() {}
    
    public abstract void prepare();
  }
  
  final class c
    implements AppBrandRuntime.a, com.tencent.mm.vending.e.a
  {
    private final String nuG;
    private volatile boolean nuH;
    
    private c()
    {
      AppMethodBeat.i(134470);
      this.nuG = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()) });
      AppBrandRuntime.this.keep(this);
      this.nuH = false;
      AppMethodBeat.o(134470);
    }
    
    public final void dead()
    {
      this.nuH = true;
    }
    
    public final void done()
    {
      AppMethodBeat.i(134471);
      if (!this.nuH)
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
        AppBrandRuntime.this.h(local1, 0L);
        AppMethodBeat.o(134471);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
      AppMethodBeat.o(134471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */