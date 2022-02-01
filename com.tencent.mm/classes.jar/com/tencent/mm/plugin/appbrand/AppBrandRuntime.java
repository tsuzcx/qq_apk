package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u.f;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.pip.b.1;
import com.tencent.mm.plugin.appbrand.r.a.c.b;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bs;
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
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrandRuntime
  implements o
{
  public volatile boolean QM;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e iky;
  public com.tencent.mm.plugin.appbrand.widget.d jdA;
  private com.tencent.mm.plugin.appbrand.ui.u jdB;
  private com.tencent.mm.plugin.appbrand.ad.e jdC;
  volatile boolean jdD;
  volatile boolean jdE;
  private volatile com.tencent.mm.plugin.appbrand.appstorage.p jdF;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<j> jdG;
  private final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.k> jdH;
  private final y jdI;
  private com.tencent.mm.plugin.appbrand.utils.d jdJ;
  public volatile com.tencent.mm.plugin.appbrand.b.c jdK;
  public com.tencent.mm.plugin.appbrand.n.a jdL;
  protected boolean jdM;
  public boolean jdN;
  private boolean jdO;
  public al jdP;
  public boolean jdQ;
  public boolean jdR;
  public boolean jdS;
  public com.tencent.mm.plugin.appbrand.pip.f jdT;
  private AppBrandPipContainerView jdU;
  private AppBrandGlobalNativeWidgetContainerView jdV;
  public com.tencent.mm.plugin.appbrand.page.h jdW;
  public boolean jdX;
  private LinkedList<b> jdY;
  ConcurrentLinkedQueue<b> jdZ;
  public ai jdt;
  private final ao jdu;
  private final an jdv;
  AppBrandRuntime jdw;
  public volatile AppBrandInitConfig jdx;
  private volatile q jdy;
  private volatile com.tencent.mm.plugin.appbrand.page.u jdz;
  private AppBrandMainProcessService.a jea;
  private final au jeb;
  private final Deque<Runnable> jec;
  public SparseArray<Set<aj>> jed;
  public volatile String mAppId;
  public Context mContext;
  private boolean mDestroyed;
  public volatile boolean mInitialized;
  public boolean mResumed;
  
  public AppBrandRuntime(ai paramai)
  {
    AppMethodBeat.i(176500);
    this.jdD = false;
    this.jdE = false;
    this.jdF = null;
    this.jdG = new ConcurrentLinkedDeque() {};
    this.jdH = new LinkedHashSet();
    this.jdI = new y();
    this.mResumed = false;
    this.jdQ = false;
    this.jdR = true;
    this.jdX = false;
    this.jdY = new LinkedList();
    this.jdZ = null;
    this.jea = new AppBrandMainProcessService.a()
    {
      private boolean jei = false;
      
      public final void Hk(String paramAnonymousString)
      {
        AppMethodBeat.i(176494);
        if (this.jei) {
          AppBrandRuntime.u(AppBrandRuntime.this);
        }
        this.jei = false;
        AppMethodBeat.o(176494);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        this.jei = true;
      }
    };
    this.jeb = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(176495);
        ac.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppBrandRuntime.this.aSK();
        AppMethodBeat.o(176495);
        return false;
      }
    }, false);
    this.jec = new LinkedBlockingDeque();
    this.jed = new SparseArray();
    this.mContext = paramai.getContext();
    this.jdt = paramai;
    this.jdu = new ao(Looper.getMainLooper());
    this.jdv = new an();
    this.jdA = new com.tencent.mm.plugin.appbrand.widget.d(this.mContext);
    this.jdA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.iky = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.jdA.addView(this.iky);
    this.jdJ = new com.tencent.mm.plugin.appbrand.utils.d();
    this.jdS = false;
    AppMethodBeat.o(176500);
  }
  
  private void aSP()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitPageContainer", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134447);
        AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.aSN());
        AppBrandRuntime.p(AppBrandRuntime.this).setOnReadyListener(new u.f()
        {
          public final void aTh()
          {
            AppMethodBeat.i(176492);
            AppBrandRuntime.o(AppBrandRuntime.this);
            AppBrandRuntime.a(AppBrandRuntime.this, null);
            AppMethodBeat.o(176492);
          }
        });
        AppBrandRuntime.q(AppBrandRuntime.this).addView(AppBrandRuntime.p(AppBrandRuntime.this), 0);
        AppBrandRuntime.p(AppBrandRuntime.this).OE(AppBrandRuntime.r(AppBrandRuntime.this).jjf);
        AppMethodBeat.o(134447);
      }
    });
    AppMethodBeat.o(134499);
  }
  
  private void aSQ()
  {
    AppMethodBeat.i(134500);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitService", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134448);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit);
        AppBrandRuntime.s(AppBrandRuntime.this).init();
        AppMethodBeat.o(134448);
      }
    });
    AppMethodBeat.o(134500);
  }
  
  private void aTb()
  {
    AppMethodBeat.i(176512);
    if ((this.jdC == null) && (this.jdD)) {
      com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| initRuntimeAdViewContainer", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176497);
          AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.mContext);
          if ((AppBrandRuntime.w(AppBrandRuntime.this) != null) && ((AppBrandRuntime.w(AppBrandRuntime.this).getParent() instanceof ViewGroup))) {
            ((ViewGroup)AppBrandRuntime.w(AppBrandRuntime.this).getParent()).removeView(AppBrandRuntime.w(AppBrandRuntime.this));
          }
          AppBrandRuntime.q(AppBrandRuntime.this).addView(AppBrandRuntime.w(AppBrandRuntime.this), new ViewGroup.LayoutParams(-1, -1));
          AppMethodBeat.o(176497);
        }
      });
    }
    AppMethodBeat.o(176512);
  }
  
  private void qD(final long paramLong)
  {
    AppMethodBeat.i(134525);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176498);
        if (AppBrandRuntime.this.isDestroyed())
        {
          ac.i("MicroMsg.AppBrandRuntime", "hideSplashInternal, finished appId:%s", new Object[] { AppBrandRuntime.this.mAppId });
          AppBrandRuntime.x(AppBrandRuntime.this);
          AppMethodBeat.o(176498);
          return;
        }
        if (AppBrandRuntime.j(AppBrandRuntime.this) != null)
        {
          ac.i("MicroMsg.AppBrandRuntime", "hideSplashInternal, delayTime:%s", new Object[] { Long.valueOf(paramLong) });
          AppBrandRuntime.j(AppBrandRuntime.this).boo();
          AppBrandRuntime.x(AppBrandRuntime.this);
        }
        AppMethodBeat.o(176498);
      }
    }, paramLong);
    AppMethodBeat.o(134525);
  }
  
  public q CX()
  {
    return this.jdy;
  }
  
  protected com.tencent.mm.plugin.appbrand.appstorage.p DA()
  {
    AppMethodBeat.i(134486);
    com.tencent.mm.plugin.appbrand.appstorage.u localu = new com.tencent.mm.plugin.appbrand.appstorage.u(this);
    AppMethodBeat.o(134486);
    return localu;
  }
  
  protected void DD() {}
  
  protected com.tencent.mm.plugin.appbrand.n.a DG()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.p DH()
  {
    return this.jdF;
  }
  
  public com.tencent.mm.plugin.appbrand.config.k DI()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.k localk = (com.tencent.mm.plugin.appbrand.config.k)ar(com.tencent.mm.plugin.appbrand.config.k.class);
    AppMethodBeat.o(134481);
    return localk;
  }
  
  public AppBrandInitConfig DJ()
  {
    return this.jdx;
  }
  
  protected void Hi(String paramString) {}
  
  protected void Hj(String paramString)
  {
    AppMethodBeat.i(193311);
    Object localObject2 = getAppConfig();
    com.tencent.mm.plugin.appbrand.r.a.c localc = getWindowAndroid();
    if (localc != null) {
      if (localObject2 == null) {
        break label159;
      }
    }
    label159:
    for (boolean bool = getAppConfig().jBH;; bool = false)
    {
      Object localObject1 = "portrait";
      if (localObject2 != null)
      {
        localObject2 = getAppConfig().bak().jCo;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = getAppConfig().jBB.jBP;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "portrait";
          }
        }
      }
      localc.setSoftOrientation((String)localObject1);
      localc.setResizeable(bool);
      ac.i("MicroMsg.AppBrandRuntime", "setResizableToWindow: stage[%s] resizable = [%b], appId = [%s]", new Object[] { paramString, Boolean.valueOf(bool), this.mAppId });
      AppMethodBeat.o(193311);
      return;
      ac.e("MicroMsg.AppBrandRuntime", "setResizableToWindow: window should not be null");
      AppMethodBeat.o(193311);
      return;
    }
  }
  
  protected boolean L(Runnable paramRunnable)
  {
    return false;
  }
  
  public final void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.QM) || (isDestroyed()))
    {
      ac.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134518);
      return;
    }
    if (this.mInitialized)
    {
      i(paramRunnable, 0L);
      AppMethodBeat.o(134518);
      return;
    }
    this.jec.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(210519);
    i(paramRunnable, 0L);
    AppMethodBeat.o(210519);
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(193310);
    if (isDestroyed())
    {
      AppMethodBeat.o(193310);
      return;
    }
    paramRunnable = s.a(this.jdv, paramRunnable);
    keep(paramRunnable);
    com.tencent.e.h.JZN.q(paramRunnable, 0L);
    AppMethodBeat.o(193310);
  }
  
  public final void Q(final Object paramObject)
  {
    AppMethodBeat.i(176509);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176493);
        if ((!AppBrandRuntime.this.mInitialized) || (AppBrandRuntime.this.isDestroyed()))
        {
          if (AppBrandRuntime.t(AppBrandRuntime.this) == null)
          {
            AppBrandRuntime.this.dispatchDestroy();
            AppMethodBeat.o(176493);
            return;
          }
          AppBrandRuntime.t(AppBrandRuntime.this).B(AppBrandRuntime.this);
          AppMethodBeat.o(176493);
          return;
        }
        if (AppBrandRuntime.t(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchPause();
          AppMethodBeat.o(176493);
          return;
        }
        AppBrandRuntime.t(AppBrandRuntime.this).a(AppBrandRuntime.this, paramObject);
        AppMethodBeat.o(176493);
      }
    }, 0L);
    AppMethodBeat.o(176509);
  }
  
  protected <T extends com.tencent.mm.kernel.c.a> T S(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final aj paramaj)
  {
    AppMethodBeat.i(178506);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134456);
        paramaj.jhU = paramInt2;
        paramaj.jhT = paramInt1;
        int i;
        if (AppBrandRuntime.v(AppBrandRuntime.this).get(paramaj.jhT) != null)
        {
          i = 1;
          if (i == 0) {
            break label118;
          }
        }
        label118:
        for (Object localObject = (Set)AppBrandRuntime.v(AppBrandRuntime.this).get(paramaj.jhT);; localObject = new CopyOnWriteArraySet())
        {
          ((Set)localObject).add(paramaj);
          if (i == 0) {
            AppBrandRuntime.v(AppBrandRuntime.this).put(paramaj.jhT, localObject);
          }
          AppMethodBeat.o(134456);
          return;
          i = 0;
          break;
        }
      }
    }, 0L);
    AppMethodBeat.o(178506);
  }
  
  protected final void a(b paramb)
  {
    AppMethodBeat.i(134476);
    this.jdY.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ai paramai)
  {
    this.jdt = paramai;
  }
  
  public final void a(final aj paramaj)
  {
    AppMethodBeat.i(134522);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134457);
        Set localSet = (Set)AppBrandRuntime.v(AppBrandRuntime.this).get(paramaj.jhT);
        if (localSet != null) {
          localSet.remove(paramaj);
        }
        AppMethodBeat.o(134457);
      }
    }, 0L);
    AppMethodBeat.o(134522);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.jdx = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  public final void a(com.tencent.mm.plugin.appbrand.config.a parama)
  {
    AppMethodBeat.i(134483);
    this.jdG.add(parama);
    AppMethodBeat.o(134483);
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.jdv.a(parama);
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
    synchronized (this.jdH)
    {
      this.jdH.add(paramk);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.page.u aSA()
  {
    return this.jdz;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.d aSB()
  {
    return this.jdA;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.c aSC()
  {
    return this.jdK;
  }
  
  public final void aSD()
  {
    AppMethodBeat.i(134485);
    if (this.jdF == null) {
      this.jdF = DA();
    }
    AppMethodBeat.o(134485);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.u aSE()
  {
    return null;
  }
  
  protected final void aSF()
  {
    AppMethodBeat.i(134487);
    if (this.jdB != null)
    {
      com.tencent.mm.plugin.appbrand.ui.h.a(this.jdB);
      this.jdB = null;
    }
    com.tencent.mm.plugin.appbrand.ui.u localu = aSE();
    if (localu == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    localu.dN(DJ().iconUrl, DJ().ddh);
    final View localView = localu.getView();
    com.tencent.mm.plugin.appbrand.ad.e locale;
    int i;
    if ((com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null) && (((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).P(this)))
    {
      locale = aTc();
      if (locale == null)
      {
        i = -1;
        this.jdA.addView(localView, i - 1, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.jdB = localu;
      localView.setClickable(true);
      this.jdE = false;
      this.jdA.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2) {}
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(134467);
          if ((paramAnonymousView2 == localView) && (!AppBrandRuntime.this.isDestroyed()))
          {
            paramAnonymousView1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(160923);
                if (AppBrandRuntime.this.mResumed) {
                  AppBrandRuntime.this.aSA().setActuallyVisible(true);
                }
                AppMethodBeat.o(160923);
              }
            };
            AppBrandRuntime.this.aSG();
            if (AppBrandRuntime.this.aSA() == null)
            {
              AppBrandRuntime.this.M(paramAnonymousView1);
              AppMethodBeat.o(134467);
              return;
            }
            paramAnonymousView1.run();
          }
          AppMethodBeat.o(134467);
        }
      });
      AppMethodBeat.o(134487);
      return;
      i = this.jdA.indexOfChild(locale);
      break;
      this.jdA.addView(localView, -1, -1);
    }
  }
  
  protected void aSG() {}
  
  public final void aSH()
  {
    AppMethodBeat.i(134488);
    if (isDestroyed())
    {
      if (this.jdB != null) {
        com.tencent.mm.plugin.appbrand.ui.h.a(this.jdB);
      }
      this.jdB = null;
      AppMethodBeat.o(134488);
      return;
    }
    if (this.jdB == null)
    {
      AppMethodBeat.o(134488);
      return;
    }
    if (aTe())
    {
      this.jdE = true;
      ac.i("MicroMsg.AppBrandRuntime", "hideSplash, hide splash after ad disappears");
      AppMethodBeat.o(134488);
      return;
    }
    ac.i("MicroMsg.AppBrandRuntime", "hideSplash, no showing ad then reset orientation and hide splash");
    aTg();
    AppMethodBeat.o(134488);
  }
  
  public final String aSI()
  {
    AppMethodBeat.i(134489);
    if (this.jdx == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (bs.isNullOrNil(this.jdx.jjf))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().bam();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.jdx.jjf;
    AppMethodBeat.o(134489);
    return str;
  }
  
  public final boolean aSJ()
  {
    return this.mInitialized;
  }
  
  protected void aSK() {}
  
  protected void aSL() {}
  
  protected q aSM()
  {
    AppMethodBeat.i(134497);
    q localq = new q();
    AppMethodBeat.o(134497);
    return localq;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.u aSN()
  {
    AppMethodBeat.i(134498);
    com.tencent.mm.plugin.appbrand.page.u localu = new com.tencent.mm.plugin.appbrand.page.u(com.tencent.mm.sdk.f.a.jg(this.mContext), this);
    AppMethodBeat.o(134498);
    return localu;
  }
  
  public boolean aSO()
  {
    return false;
  }
  
  protected void aSR() {}
  
  protected final void aSS()
  {
    AppMethodBeat.i(134513);
    this.jdM = true;
    ac.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  protected final void aST()
  {
    AppMethodBeat.i(193308);
    if (this.jdM)
    {
      ac.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
      AppMethodBeat.o(193308);
      return;
    }
    this.jdN = true;
    ac.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(193308);
  }
  
  public final boolean aSU()
  {
    AppMethodBeat.i(134514);
    if (!this.jdR)
    {
      AppMethodBeat.o(134514);
      return false;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(this.mContext);
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      AppMethodBeat.o(134514);
      return false;
    }
    if ((this.jdz != null) && (this.jdz.getCurrentPage() != null) && (!this.jdz.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  final void aSV()
  {
    AppMethodBeat.i(134515);
    this.jdK.jqZ.a(d.a.jrA);
    g.Ha(this.mAppId);
    AppMethodBeat.o(134515);
  }
  
  public void aSW()
  {
    AppMethodBeat.i(176510);
    O(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134455);
        final com.tencent.mm.plugin.appbrand.r.a.c localc = AppBrandRuntime.this.getWindowAndroid();
        if (localc == null)
        {
          AppMethodBeat.o(134455);
          return;
        }
        Object localObject = AppBrandRuntime.this.getAppConfig();
        if (localObject == null) {}
        int i;
        for (localObject = new c.b(AppBrandRuntime.this.DJ().ddh);; localObject = new c.b(AppBrandRuntime.this.DJ().ddh, null, i))
        {
          localc.setWindowDescription((c.b)localObject);
          com.tencent.mm.modelappbrand.a.b.aAS().a(new b.c()
          {
            public final void E(Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(176496);
              localc.setWindowDescription(new c.b(this.jek.label, paramAnonymous2Bitmap, this.jek.colorPrimary));
              AppMethodBeat.o(176496);
            }
          }, AppBrandRuntime.this.DJ().iconUrl, com.tencent.mm.modelappbrand.a.g.htk);
          AppMethodBeat.o(134455);
          return;
          i = com.tencent.mm.plugin.appbrand.z.g.cd(((com.tencent.mm.plugin.appbrand.config.a)localObject).bak().jCh, -16777216);
        }
      }
    });
    AppMethodBeat.o(176510);
  }
  
  public boolean aSX()
  {
    AppMethodBeat.i(134517);
    if (this.jdK.jqZ.aXJ() == com.tencent.mm.plugin.appbrand.b.b.jqW) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      AppMethodBeat.o(134517);
      return true;
    }
    AppMethodBeat.o(134517);
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.u aSY()
  {
    return this.jdB;
  }
  
  protected void aSZ() {}
  
  public final m aSs()
  {
    return this.iky;
  }
  
  public final void aSx()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    long l = bs.Gn();
    ac.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    com.tencent.mm.plugin.appbrand.ad.g localg = (com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class);
    if (localg != null) {}
    for (boolean bool = localg.O(this);; bool = false)
    {
      this.jdD = bool;
      com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134463);
          AppBrandRuntime.f(AppBrandRuntime.this);
          AppMethodBeat.o(134463);
        }
      });
      com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134464);
          AppBrandRuntime.a(AppBrandRuntime.this, new AppBrandRuntime.c(AppBrandRuntime.this, (byte)0));
          AppMethodBeat.o(134464);
        }
      });
      com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134465);
          if (!AppBrandRuntime.g(AppBrandRuntime.this))
          {
            ac.i("MicroMsg.AppBrandRuntime", "launch, not show ad, show splash");
            AppBrandRuntime.this.aTd();
            AppBrandRuntime.this.aSF();
          }
          AppMethodBeat.o(134465);
        }
      });
      this.jeb.au(10000L, 10000L);
      ac.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(bs.Gn() - l) });
      AppMethodBeat.o(134475);
      return;
      ac.i("MicroMsg.AppBrandRuntime", "checkCanShowAd, IAppBrandAdService is null");
    }
  }
  
  public final int aSy()
  {
    return this.jdx.joY;
  }
  
  public final AppBrandRuntime aSz()
  {
    AppMethodBeat.i(134478);
    if (this.jdt == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.jdt.z(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public final boolean aTa()
  {
    return this.jdD;
  }
  
  public final com.tencent.mm.plugin.appbrand.ad.e aTc()
  {
    AppMethodBeat.i(176513);
    aTb();
    com.tencent.mm.plugin.appbrand.ad.e locale = this.jdC;
    AppMethodBeat.o(176513);
    return locale;
  }
  
  public final void aTd()
  {
    AppMethodBeat.i(164050);
    if (this.jdC != null) {
      this.jdC.setVisibility(8);
    }
    AppMethodBeat.o(164050);
  }
  
  public final boolean aTe()
  {
    AppMethodBeat.i(134523);
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null)
    {
      boolean bool = ((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).P(this);
      AppMethodBeat.o(134523);
      return bool;
    }
    ac.i("MicroMsg.AppBrandRuntime", "isShowingLaunchAd, IAppBrandAdService is null");
    AppMethodBeat.o(134523);
    return false;
  }
  
  public final int aTf()
  {
    AppMethodBeat.i(160926);
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null)
    {
      int i = ((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).M(this);
      AppMethodBeat.o(160926);
      return i;
    }
    ac.i("MicroMsg.AppBrandRuntime", "getCheckShowAdTimeThreshold, IAppBrandAdService is null");
    AppMethodBeat.o(160926);
    return 140;
  }
  
  final void aTg()
  {
    AppMethodBeat.i(134526);
    if (!this.mInitialized)
    {
      qD(0L);
      AppMethodBeat.o(134526);
      return;
    }
    ac.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationAndHideSplash, reset orientation and hide splash");
    if (!b(new com.tencent.mm.plugin.appbrand.r.a.e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176499);
        ac.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationAndHideSplash, onOrientationChanged, orientation:%s, success:%s", new Object[] { paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandRuntime.y(AppBrandRuntime.this);
        AppMethodBeat.o(176499);
      }
    })) {
      qD(0L);
    }
    qD(200L);
    AppMethodBeat.o(134526);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.jdI.al(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.h.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.h.msy);
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
    this.jdI.ac(paramClass);
    AppMethodBeat.o(134496);
  }
  
  public final <T extends j> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.jdX) {}
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
    synchronized (this.jdH)
    {
      Iterator localIterator = this.jdH.iterator();
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
    this.jdI.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(193305);
    if (paramk == null)
    {
      AppMethodBeat.o(193305);
      return false;
    }
    synchronized (this.jdH)
    {
      this.jdH.remove(paramk);
      AppMethodBeat.o(193305);
      return true;
    }
  }
  
  final boolean b(com.tencent.mm.plugin.appbrand.r.a.e.a parama)
  {
    AppMethodBeat.i(176514);
    if ((aSA() != null) && (aSA().getPageView() != null))
    {
      com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)aSA().getPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (locald != null)
      {
        String str = locald.Ca();
        ac.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationInternal, request orientation:%s", new Object[] { str });
        if (!bs.isNullOrNil(str))
        {
          locald.a(parama);
          AppMethodBeat.o(176514);
          return true;
        }
      }
    }
    AppMethodBeat.o(176514);
    return false;
  }
  
  /* Error */
  public final <T extends j> T c(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1344
    //   3: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 185	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jdG	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1349	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 513 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 517 1 0
    //   38: checkcast 1351	com/tencent/mm/plugin/appbrand/jsapi/j
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1311	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1357	org/a/a:bD	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1361	org/a/a:gfN	()Lorg/a/a;
    //   65: getfield 1365	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1351	com/tencent/mm/plugin/appbrand/jsapi/j
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 185	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jdG	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 1028 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1344
    //   99: invokestatic 294	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 357
    //   109: ldc_w 1367
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1370	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 673	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   20	83	3	localj1	j
    //   129	1	3	localException1	java.lang.Exception
    //   132	1	3	localException2	java.lang.Exception
    //   7	87	4	localj2	j
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
      ac.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      AppMethodBeat.o(134474);
      return;
    }
    ac.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", new Object[] { paramAppBrandInitConfig });
    this.jdx = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.jdK = new com.tencent.mm.plugin.appbrand.b.c(this);
    this.jdK.jqZ.start();
    this.jdK.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(134462);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntime.this;
        HashMap localHashMap = new HashMap();
        switch (com.tencent.mm.plugin.appbrand.page.n.1.jrs[paramAnonymousb.ordinal()])
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
          new n().A(localHashMap).g(localAppBrandRuntime.CX()).beN();
          AppMethodBeat.o(134462);
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
      this.QM = false;
      this.jdM = false;
      this.jdN = false;
      this.jdO = false;
      ac.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { this.mAppId });
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
    com.tencent.luggage.h.f.aC(com.tencent.mm.sdk.f.a.jg(this.mContext));
    Q(null);
    AppMethodBeat.o(134511);
  }
  
  protected final void d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 1;
    AppMethodBeat.i(134477);
    if (!this.mInitialized)
    {
      ac.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramAppBrandInitConfig });
      if ((!isDestroyed()) && (!this.QM))
      {
        ac.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { this.mAppId });
        e(paramAppBrandInitConfig);
      }
      AppMethodBeat.o(134477);
      return;
    }
    ac.i("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
    int i;
    if (paramAppBrandInitConfig != null) {
      if (this.jdO)
      {
        this.jdO = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        aSS();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(134477);
      return;
      i = j;
      if (paramAppBrandInitConfig.joY == this.jdx.joY)
      {
        i = j;
        if (paramAppBrandInitConfig.jDv == this.jdx.jDv) {
          i = 0;
        }
      }
    }
  }
  
  final void dispatchDestroy()
  {
    AppMethodBeat.i(176506);
    boolean bool = isDestroyed();
    ac.i("MicroMsg.AppBrandRuntime", "dispatchDestroy, finished?[%b] initialized?[%b]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.mInitialized) });
    if (bool)
    {
      AppMethodBeat.o(176506);
      return;
    }
    try
    {
      this.mDestroyed = true;
      onDestroy();
      an localan = this.jdv;
      ??? = localan.jia.iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)???).next()).dead();
      }
      localObject1.jia.clear();
    }
    finally
    {
      AppMethodBeat.o(176506);
    }
    this.jdF = null;
    com.tencent.mm.plugin.appbrand.media.a.a.LP(this.mAppId);
    AppBrandMainProcessService.b(this.jea);
    g.GZ(this.mAppId);
    g.a(this.mAppId, g.b.jda);
    com.tencent.luggage.h.f.aC(com.tencent.mm.sdk.f.a.jg(this.mContext));
    ??? = this.jdK;
    ??? = ((com.tencent.mm.plugin.appbrand.b.c)???).jqZ;
    if (!((com.tencent.mm.plugin.appbrand.b.d)???).jri.get()) {
      ac.printErrStackTrace(((com.tencent.mm.plugin.appbrand.b.d)???).TAG, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
    }
    for (;;)
    {
      synchronized (((com.tencent.mm.plugin.appbrand.b.c)???).jra)
      {
        ((com.tencent.mm.plugin.appbrand.b.c)???).jra.clear();
        this.jdP = null;
        ??? = com.tencent.mm.plugin.appbrand.p.f.bpj();
        ??? = this.mAppId;
        if (((com.tencent.mm.plugin.appbrand.p.f)???).lwt.containsKey(???)) {
          ??? = (com.tencent.mm.plugin.appbrand.p.d)((com.tencent.mm.plugin.appbrand.p.f)???).lwt.remove(???);
        }
        synchronized (((com.tencent.mm.plugin.appbrand.p.d)???).lwv)
        {
          ((com.tencent.mm.plugin.appbrand.p.d)???).lwv.clear();
          ((com.tencent.mm.plugin.appbrand.p.d)???).lwx.clear();
          ((com.tencent.mm.plugin.appbrand.p.d)???).lww.clear();
          ??? = com.tencent.mm.plugin.appbrand.p.c.bpg();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.p.c)???).lwt.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.p.b)((com.tencent.mm.plugin.appbrand.p.c)???).lwt.remove(???)).release();
          }
          ??? = com.tencent.mm.plugin.appbrand.p.i.bpl();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.p.i)???).lwt.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.p.g)((com.tencent.mm.plugin.appbrand.p.i)???).lwt.remove(???)).release();
          }
          ??? = l.bpo();
          ??? = this.mAppId;
          if (((l)???).lwt.containsKey(???))
          {
            ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((l)???).lwt.remove(???);
            if (??? != null) {
              ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
            }
          }
          g.He(this.mAppId);
          this.jdA.setOnHierarchyChangeListener(null);
          this.jdA.removeAllViewsInLayout();
          this.iky.blW();
          if (this.mInitialized)
          {
            this.jdy.cleanup();
            this.jdy = null;
            this.jdz.cleanup();
            this.jdz = null;
          }
          ??? = this.jdZ;
          this.jdZ = null;
          if ((??? == null) || (((Queue)???).isEmpty()))
          {
            ac.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { this.mAppId });
            this.jdG.clear();
          }
        }
      }
      synchronized (this.jdH)
      {
        this.jdH.clear();
        this.jdI.unregisterAll();
        this.jec.clear();
        this.jdu.removeCallbacksAndMessages(null);
        this.jeb.stopTimer();
        this.jed.clear();
        x.al(this);
        AppMethodBeat.o(176506);
        return;
        ((com.tencent.mm.plugin.appbrand.b.d)???).jrj.set(true);
        if (((com.tencent.mm.plugin.appbrand.b.d)???).aXI())
        {
          ac.e(((com.tencent.mm.plugin.appbrand.b.d)???).TAG, "stop() called, but still isInConstruction");
          ((com.tencent.mm.plugin.appbrand.b.d)???).quit();
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.b.d)???).a(com.tencent.mm.plugin.appbrand.b.b.jqX);
          break;
          d.c localc = ((com.tencent.mm.sdk.d.d)???).GuZ;
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
        ac.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", new Object[] { Integer.valueOf(localObject3.size()), this.mAppId });
        if (localObject3.isEmpty()) {
          continue;
        }
        ((b)localObject3.poll()).interrupt();
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
    ac.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.jdK.jqZ.a(d.a.jrv);
    this.jdy.Bz();
    this.jdz.onBackground();
    g.Hb(this.mAppId);
    g.a(this.mAppId, g.b.jcY);
    ac.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      bg.a(com.tencent.mm.sdk.platformtools.ai.getContext(), null);
      AppMethodBeat.o(176504);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
      AppMethodBeat.o(176504);
    }
  }
  
  final void dispatchResume()
  {
    AppMethodBeat.i(176505);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(176505);
      return;
    }
    ac.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((isDestroyed()) || (this.jdM))
    {
      this.mResumed = true;
      e(null);
      AppMethodBeat.o(176505);
      return;
    }
    this.mResumed = true;
    g.Hf(this.mAppId);
    g.Hc(this.mAppId);
    g.a(this.mAppId, g.b.jcX);
    boolean bool = this.jdN;
    Hj("onResume");
    this.jdz.onForeground();
    this.jdK.jqZ.a(d.a.jrw, "onRuntimeResume");
    this.jdy.bw(bool);
    onResume();
    if (bool) {
      this.jdz.au(aSI(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.d locald = this.jdJ;
    ac.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      bg.a(com.tencent.mm.sdk.platformtools.ai.getContext(), locald.mnW);
      aSW();
      this.jdM = false;
      this.jdN = false;
      AppMethodBeat.o(176505);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] resume set callback", new Object[0]);
      }
    }
  }
  
  protected void e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134510);
    if (!this.mResumed)
    {
      ac.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s", new Object[] { this.mAppId });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.jdx = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(134510);
      return;
    }
    ac.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, stacktrace=%s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      aSx();
      ac.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(134510);
      return;
      paramAppBrandInitConfig = DJ();
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134507);
    super.finalize();
    this.jdu.removeCallbacksAndMessages(null);
    AppMethodBeat.o(134507);
  }
  
  public void finish()
  {
    AppMethodBeat.i(134508);
    if (isDestroyed())
    {
      ac.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(134508);
      return;
    }
    this.QM = true;
    com.tencent.luggage.h.f.aC(com.tencent.mm.sdk.f.a.jg(this.mContext));
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134450);
        if (AppBrandRuntime.t(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchDestroy();
          AppMethodBeat.o(134450);
          return;
        }
        AppBrandRuntime.t(AppBrandRuntime.this).B(AppBrandRuntime.this);
        AppMethodBeat.o(134450);
      }
    }, 0L);
    AppMethodBeat.o(134508);
  }
  
  final void fu(boolean paramBoolean)
  {
    this.jdS = paramBoolean;
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
    AppMethodBeat.i(210518);
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(this.mContext);
    AppMethodBeat.o(210518);
    return localActivity;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.jdt == null)
    {
      ac.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(176502);
      return null;
    }
    com.tencent.mm.plugin.appbrand.r.a.c localc = this.jdt.getWindowAndroid();
    AppMethodBeat.o(176502);
    return localc;
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
      ac.w("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134520);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    if ((ap.isMainThread()) && (0L == l))
    {
      paramRunnable.run();
      AppMethodBeat.o(134520);
      return;
    }
    paramRunnable = s.a(this.jdv, paramRunnable);
    keep(paramRunnable);
    this.jdu.postDelayed(paramRunnable, l);
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
    return this.QM;
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(134479);
    if ((this.jdt != null) && (this.jdt.A(this)))
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
    this.jdv.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(193307);
    if (this.jdB == null)
    {
      if (this.iky.onBackPressed())
      {
        AppMethodBeat.o(193307);
        return;
      }
      if (this.jdz != null)
      {
        this.jdz.onBackPressed();
        AppMethodBeat.o(193307);
      }
    }
    else
    {
      g.a(this.mAppId, g.d.jdd);
      finish();
    }
    AppMethodBeat.o(193307);
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
    if (this.jdT != null)
    {
      com.tencent.mm.plugin.appbrand.pip.f localf = this.jdT;
      ac.i(localf.cgL, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (localf.lNL != null)
      {
        paramConfiguration = localf.lNL;
        ac.i(paramConfiguration.cgL, "onConfigurationChanged");
        if (!paramConfiguration.lMG)
        {
          ac.d(paramConfiguration.cgL, "onConfigurationChanged, false == mHandleStarted");
          AppMethodBeat.o(176503);
          return;
        }
        paramConfiguration.lMD.a(paramConfiguration.caw, new b.1(paramConfiguration));
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
    AppMethodBeat.i(193306);
    this.jdy.aUV().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.jdy.aUV().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(193306);
  }
  
  protected void onResume() {}
  
  public final void reload()
  {
    AppMethodBeat.i(176508);
    e(null);
    AppMethodBeat.o(176508);
  }
  
  static abstract interface a
  {
    public abstract void done();
  }
  
  public static abstract class b
  {
    AppBrandRuntime.a jev;
    
    public void Al()
    {
      if (this.jev != null) {
        this.jev.done();
      }
    }
    
    public void interrupt() {}
    
    public abstract void prepare();
  }
  
  final class c
    implements AppBrandRuntime.a, com.tencent.mm.vending.e.a
  {
    private final String jew;
    volatile boolean jex;
    
    private c()
    {
      AppMethodBeat.i(134470);
      this.jew = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
      ac.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()) });
      AppBrandRuntime.this.keep(this);
      this.jex = false;
      AppMethodBeat.o(134470);
    }
    
    public final void dead()
    {
      this.jex = true;
    }
    
    public final void done()
    {
      AppMethodBeat.i(134471);
      if (!this.jex)
      {
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134469);
            if (!AppBrandRuntime.c.this.jex)
            {
              AppBrandRuntime.h(AppBrandRuntime.this);
              AppBrandRuntime.i(AppBrandRuntime.this);
              AppMethodBeat.o(134469);
              return;
            }
            ac.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
            AppMethodBeat.o(134469);
          }
        };
        AppBrandRuntime.this.i(local1, 0L);
        AppMethodBeat.o(134471);
        return;
      }
      ac.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
      AppMethodBeat.o(134471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */