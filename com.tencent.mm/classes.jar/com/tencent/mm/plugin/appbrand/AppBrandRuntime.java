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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.f;
import com.tencent.mm.plugin.appbrand.pip.b.1;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bu;
import d.z;
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
  implements com.tencent.mm.plugin.appbrand.utils.p<com.tencent.mm.vending.e.a>
{
  public volatile boolean SB;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e iGI;
  private AppBrandPipContainerView jAa;
  private AppBrandGlobalNativeWidgetContainerView jAb;
  public com.tencent.mm.plugin.appbrand.page.g jAc;
  private com.tencent.mm.plugin.appbrand.platform.window.c jAd;
  public boolean jAe;
  private LinkedList<b> jAf;
  ConcurrentLinkedQueue<b> jAg;
  private AppBrandMainProcessService.a jAh;
  private final aw jAi;
  private final Deque<Runnable> jAj;
  public SparseArray<Set<aj>> jAk;
  private final ap jzA;
  AppBrandRuntime jzB;
  public volatile AppBrandInitConfig jzC;
  private volatile r jzD;
  private volatile t jzE;
  public com.tencent.mm.plugin.appbrand.widget.d jzF;
  public com.tencent.mm.plugin.appbrand.ui.w jzG;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e jzH;
  public com.tencent.mm.plugin.appbrand.ad.f jzI;
  public com.tencent.mm.plugin.appbrand.page.capsulebar.e jzJ;
  private volatile Boolean jzK;
  private volatile com.tencent.mm.plugin.appbrand.appstorage.q jzL;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<com.tencent.mm.plugin.appbrand.jsapi.j> jzM;
  private final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.k> jzN;
  private final y jzO;
  private com.tencent.mm.plugin.appbrand.utils.e jzP;
  public volatile com.tencent.mm.plugin.appbrand.a.c jzQ;
  public com.tencent.mm.plugin.appbrand.m.a jzR;
  protected boolean jzS;
  public boolean jzT;
  private boolean jzU;
  public al jzV;
  public boolean jzW;
  public boolean jzX;
  public boolean jzY;
  public com.tencent.mm.plugin.appbrand.pip.f jzZ;
  public ai jzy;
  private final aq jzz;
  public volatile String mAppId;
  public Context mContext;
  private boolean mDestroyed;
  public volatile boolean mInitialized;
  public boolean mResumed;
  
  public AppBrandRuntime(ai paramai)
  {
    AppMethodBeat.i(176500);
    this.jzK = null;
    this.jzL = null;
    this.jzM = new AppBrandRuntime.1(this);
    this.jzN = new LinkedHashSet();
    this.jzO = new y();
    this.mResumed = false;
    this.jzW = false;
    this.jzX = true;
    this.jAe = false;
    this.jAf = new LinkedList();
    this.jAg = null;
    this.jAh = new AppBrandRuntime.9(this);
    this.jAi = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(134452);
        ae.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppBrandRuntime.this.aWz();
        AppMethodBeat.o(134452);
        return false;
      }
    }, false);
    this.jAj = new LinkedBlockingDeque();
    this.jAk = new SparseArray();
    this.mContext = paramai.getContext();
    this.jzy = paramai;
    this.jzz = new aq(Looper.getMainLooper());
    this.jzA = new ap();
    this.jzF = new com.tencent.mm.plugin.appbrand.widget.d(this.mContext);
    this.jzF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.iGI = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.jzH = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.jzP = new com.tencent.mm.plugin.appbrand.utils.e();
    this.jzY = false;
    AppMethodBeat.o(176500);
  }
  
  private void aWE()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitPageContainer", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134446);
        AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.aWC());
        AppBrandRuntime.p(AppBrandRuntime.this).setOnReadyListener(new t.f()
        {
          public final void aWR()
          {
            AppMethodBeat.i(134445);
            AppBrandRuntime.o(AppBrandRuntime.this);
            AppBrandRuntime.a(AppBrandRuntime.this, null);
            AppMethodBeat.o(134445);
          }
        });
        ao.jEb.a(AppBrandRuntime.this, AppBrandRuntime.p(AppBrandRuntime.this));
        AppBrandRuntime.p(AppBrandRuntime.this).SM(AppBrandRuntime.q(AppBrandRuntime.this).jFL);
        AppMethodBeat.o(134446);
      }
    });
    AppMethodBeat.o(134499);
  }
  
  private void aWF()
  {
    AppMethodBeat.i(134500);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitService", new AppBrandRuntime.5(this));
    AppMethodBeat.o(134500);
  }
  
  public r Ey()
  {
    return this.jzD;
  }
  
  protected com.tencent.mm.plugin.appbrand.appstorage.q Fe()
  {
    AppMethodBeat.i(134486);
    com.tencent.mm.plugin.appbrand.appstorage.w localw = new com.tencent.mm.plugin.appbrand.appstorage.w(this);
    AppMethodBeat.o(134486);
    return localw;
  }
  
  protected void Fh() {}
  
  protected com.tencent.mm.plugin.appbrand.m.a Fk()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.q Fl()
  {
    return this.jzL;
  }
  
  public com.tencent.mm.plugin.appbrand.config.k Fm()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.k localk = (com.tencent.mm.plugin.appbrand.config.k)ar(com.tencent.mm.plugin.appbrand.config.k.class);
    AppMethodBeat.o(134481);
    return localk;
  }
  
  public AppBrandInitConfig Fn()
  {
    return this.jzC;
  }
  
  protected boolean I(Runnable paramRunnable)
  {
    return false;
  }
  
  public final void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.SB) || (isDestroyed()))
    {
      ae.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134518);
      return;
    }
    if (this.mInitialized)
    {
      j(paramRunnable, 0L);
      AppMethodBeat.o(134518);
      return;
    }
    this.jAj.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  public final void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(224482);
    j(paramRunnable, 0L);
    AppMethodBeat.o(224482);
  }
  
  public final void L(Runnable paramRunnable)
  {
    AppMethodBeat.i(207683);
    if (isDestroyed())
    {
      AppMethodBeat.o(207683);
      return;
    }
    paramRunnable = u.a(this.jzA, paramRunnable);
    keep(paramRunnable);
    com.tencent.e.h.MqF.r(paramRunnable, 0L);
    AppMethodBeat.o(207683);
  }
  
  public final void R(final Object paramObject)
  {
    AppMethodBeat.i(176509);
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134450);
        if ((!AppBrandRuntime.this.mInitialized) || (AppBrandRuntime.this.isDestroyed()))
        {
          if (AppBrandRuntime.s(AppBrandRuntime.this) == null)
          {
            AppBrandRuntime.this.dispatchDestroy();
            AppMethodBeat.o(134450);
            return;
          }
          AppBrandRuntime.s(AppBrandRuntime.this).x(AppBrandRuntime.this);
          AppMethodBeat.o(134450);
          return;
        }
        if (AppBrandRuntime.s(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchPause();
          AppMethodBeat.o(134450);
          return;
        }
        AppBrandRuntime.s(AppBrandRuntime.this).a(AppBrandRuntime.this, paramObject);
        AppMethodBeat.o(134450);
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
    ae.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134455);
        ae.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
        paramaj.jDO = paramInt2;
        paramaj.jDN = paramInt1;
        int i;
        if (AppBrandRuntime.u(AppBrandRuntime.this).get(paramaj.jDN) != null)
        {
          i = 1;
          if (i == 0) {
            break label125;
          }
        }
        label125:
        for (Object localObject = (Set)AppBrandRuntime.u(AppBrandRuntime.this).get(paramaj.jDN);; localObject = new CopyOnWriteArraySet())
        {
          ((Set)localObject).add(paramaj);
          if (i == 0) {
            AppBrandRuntime.u(AppBrandRuntime.this).put(paramaj.jDN, localObject);
          }
          AppMethodBeat.o(134455);
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
    this.jAf.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ai paramai)
  {
    this.jzy = paramai;
  }
  
  public final void a(final aj paramaj)
  {
    AppMethodBeat.i(134522);
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134456);
        Set localSet = (Set)AppBrandRuntime.u(AppBrandRuntime.this).get(paramaj.jDN);
        if (localSet != null) {
          localSet.remove(paramaj);
        }
        AppMethodBeat.o(134456);
      }
    }, 0L);
    AppMethodBeat.o(134522);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.jzC = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(207680);
    if (!this.mResumed)
    {
      ae.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", new Object[] { this.mAppId, paramString });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.jzC = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(207680);
      return;
    }
    ae.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", new Object[] { this.mAppId, paramString, Log.getStackTraceString(new Throwable()) });
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      aWi();
      ae.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(207680);
      return;
      paramAppBrandInitConfig = Fn();
    }
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.jzA.a(parama);
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
    synchronized (this.jzN)
    {
      this.jzN.add(paramk);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  protected void aWA() {}
  
  protected r aWB()
  {
    AppMethodBeat.i(134497);
    r localr = new r();
    AppMethodBeat.o(134497);
    return localr;
  }
  
  protected t aWC()
  {
    AppMethodBeat.i(134498);
    t localt = new t(com.tencent.mm.sdk.f.a.jw(this.mContext), this);
    AppMethodBeat.o(134498);
    return localt;
  }
  
  public boolean aWD()
  {
    return false;
  }
  
  protected void aWG() {}
  
  protected final void aWH()
  {
    AppMethodBeat.i(134513);
    this.jzS = true;
    ae.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  protected final void aWI()
  {
    AppMethodBeat.i(207681);
    if (this.jzS)
    {
      ae.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
      AppMethodBeat.o(207681);
      return;
    }
    this.jzT = true;
    ae.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(207681);
  }
  
  public final boolean aWJ()
  {
    AppMethodBeat.i(134514);
    if (!this.jzX)
    {
      AppMethodBeat.o(134514);
      return false;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(this.mContext);
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      AppMethodBeat.o(134514);
      return false;
    }
    if ((this.jzE != null) && (this.jzE.getCurrentPage() != null) && (!this.jzE.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  final void aWK()
  {
    AppMethodBeat.i(134515);
    this.jzQ.jOf.a(d.a.jOG);
    h.KO(this.mAppId);
    AppMethodBeat.o(134515);
  }
  
  public void aWL()
  {
    AppMethodBeat.i(176510);
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207666);
        final com.tencent.mm.plugin.appbrand.platform.window.c localc = AppBrandRuntime.this.getWindowAndroid();
        if (localc == null)
        {
          AppMethodBeat.o(207666);
          return;
        }
        Object localObject = AppBrandRuntime.this.getAppConfig();
        if (localObject == null) {}
        int i;
        for (localObject = new c.a(AppBrandRuntime.this.Fn().dpI);; localObject = new c.a(AppBrandRuntime.this.Fn().dpI, null, i))
        {
          localc.setWindowDescription((c.a)localObject);
          com.tencent.mm.modelappbrand.a.b.aEl().a(new b.c()
          {
            public final void F(Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(207665);
              localc.setWindowDescription(new c.a(this.jAq.label, paramAnonymous2Bitmap, this.jAq.colorPrimary));
              AppMethodBeat.o(207665);
            }
          }, AppBrandRuntime.this.Fn().iconUrl, com.tencent.mm.modelappbrand.a.g.hOv);
          AppMethodBeat.o(207666);
          return;
          i = com.tencent.mm.plugin.appbrand.y.g.ck(((com.tencent.mm.plugin.appbrand.config.a)localObject).beo().jZg, -16777216);
        }
      }
    });
    AppMethodBeat.o(176510);
  }
  
  public boolean aWM()
  {
    AppMethodBeat.i(134517);
    if (this.jzQ.jOf.bbI() == com.tencent.mm.plugin.appbrand.a.b.jOc) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      AppMethodBeat.o(134517);
      return true;
    }
    AppMethodBeat.o(134517);
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.w aWN()
  {
    return this.jzG;
  }
  
  public final boolean aWO()
  {
    AppMethodBeat.i(207684);
    if (this.jzK == null) {
      this.jzK = Boolean.valueOf(((com.tencent.mm.plugin.appbrand.ad.k)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.k.class)).H(this));
    }
    boolean bool = this.jzK.booleanValue();
    AppMethodBeat.o(207684);
    return bool;
  }
  
  public final boolean aWP()
  {
    AppMethodBeat.i(207685);
    if ((this.jzG instanceof x)) {}
    for (boolean bool = ((x)this.jzG).aWP();; bool = false)
    {
      String str2 = this.mAppId;
      if (this.jzG == null) {}
      for (String str1 = "null";; str1 = this.jzG.getClass().getSimpleName())
      {
        ae.i("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
        AppMethodBeat.o(207685);
        return bool;
      }
    }
  }
  
  public final void aWQ()
  {
    this.jzY = true;
  }
  
  public final m aWd()
  {
    return this.iGI;
  }
  
  public final void aWi()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    long l = bu.HQ();
    ae.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    aWj();
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207668);
        AppBrandRuntime.f(AppBrandRuntime.this);
        AppMethodBeat.o(207668);
      }
    });
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207669);
        AppBrandRuntime.a(AppBrandRuntime.this, new AppBrandRuntime.c(AppBrandRuntime.this, (byte)0));
        AppMethodBeat.o(207669);
      }
    });
    com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134463);
        AppBrandRuntime.this.aWu();
        AppMethodBeat.o(134463);
      }
    });
    this.jAi.ay(10000L, 10000L);
    ae.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(bu.HQ() - l) });
    AppMethodBeat.o(134475);
  }
  
  protected void aWj() {}
  
  public final int aWk()
  {
    return this.jzC.dQv;
  }
  
  public final AppBrandRuntime aWl()
  {
    AppMethodBeat.i(134478);
    if (this.jzy == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.jzy.v(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public t aWm()
  {
    return this.jzE;
  }
  
  public final ai aWn()
  {
    return this.jzy;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.d aWo()
  {
    return this.jzF;
  }
  
  public void aWp() {}
  
  public final com.tencent.mm.plugin.appbrand.a.c aWq()
  {
    return this.jzQ;
  }
  
  public final void aWr()
  {
    AppMethodBeat.i(134485);
    if (this.jzL == null) {
      this.jzL = Fe();
    }
    AppMethodBeat.o(134485);
  }
  
  public final m aWs()
  {
    return this.jzH;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.w aWt()
  {
    return null;
  }
  
  protected final void aWu()
  {
    AppMethodBeat.i(134487);
    if (this.jzG != null)
    {
      com.tencent.mm.plugin.appbrand.ui.j.a(this.jzG);
      this.jzG = null;
    }
    Object localObject = aWt();
    if (localObject == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.w)localObject).dX(Fn().iconUrl, Fn().dpI);
    final View localView = ((com.tencent.mm.plugin.appbrand.ui.w)localObject).getView();
    ao.jEh.a(this, localView);
    this.jzG = ((com.tencent.mm.plugin.appbrand.ui.w)localObject);
    String str = this.mAppId;
    if (this.jzG == null) {}
    for (localObject = "null";; localObject = this.jzG.getClass().getSimpleName())
    {
      ae.i("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", new Object[] { str, localObject });
      localView.setClickable(true);
      this.jzF.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2) {}
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(207672);
          if ((paramAnonymousView2 == localView) && (!AppBrandRuntime.this.isDestroyed()))
          {
            paramAnonymousView1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207671);
                if (AppBrandRuntime.this.mResumed) {
                  AppBrandRuntime.this.aWm().setActuallyVisible(true);
                }
                AppMethodBeat.o(207671);
              }
            };
            AppBrandRuntime.this.aWv();
            if (AppBrandRuntime.this.aWm() == null)
            {
              AppBrandRuntime.this.J(paramAnonymousView1);
              AppMethodBeat.o(207672);
              return;
            }
            paramAnonymousView1.run();
          }
          AppMethodBeat.o(207672);
        }
      });
      AppMethodBeat.o(134487);
      return;
    }
  }
  
  protected void aWv() {}
  
  public final void aWw()
  {
    AppMethodBeat.i(134488);
    if (isDestroyed())
    {
      if (this.jzG != null) {
        com.tencent.mm.plugin.appbrand.ui.j.a(this.jzG);
      }
      this.jzG = null;
      AppMethodBeat.o(134488);
      return;
    }
    if (this.jzG == null)
    {
      AppMethodBeat.o(134488);
      return;
    }
    ae.m("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", new Object[] { this.jzG.getClass().getSimpleName() });
    if ((this.jzG instanceof x))
    {
      ((x)this.jzG).aYF();
      AppMethodBeat.o(134488);
      return;
    }
    this.jzG.v(new d.g.a.a() {});
    AppMethodBeat.o(134488);
  }
  
  public final String aWx()
  {
    AppMethodBeat.i(134489);
    if (this.jzC == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (bu.isNullOrNil(this.jzC.jFL))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().ber();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.jzC.jFL;
    AppMethodBeat.o(134489);
    return str;
  }
  
  public final boolean aWy()
  {
    return this.mInitialized;
  }
  
  protected void aWz() {}
  
  public final <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.jzO.al(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.h.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.h.mYm);
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
    this.jzO.ac(paramClass);
    AppMethodBeat.o(134496);
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.j> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.jAe) {}
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
    synchronized (this.jzN)
    {
      Iterator localIterator = this.jzN.iterator();
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
  
  public final void b(com.tencent.mm.plugin.appbrand.config.a parama)
  {
    AppMethodBeat.i(134483);
    this.jzM.add(parama);
    AppMethodBeat.o(134483);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(134495);
    this.jzO.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(207677);
    if (paramk == null)
    {
      AppMethodBeat.o(207677);
      return false;
    }
    synchronized (this.jzN)
    {
      this.jzN.remove(paramk);
      AppMethodBeat.o(207677);
      return true;
    }
  }
  
  /* Error */
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.j> T c(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1352
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 173	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jzM	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1357	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 472 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 476 1 0
    //   38: checkcast 1359	com/tencent/mm/plugin/appbrand/jsapi/j
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1333	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1365	org/a/a:bF	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1369	org/a/a:gCT	()Lorg/a/a;
    //   65: getfield 1373	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1359	com/tencent/mm/plugin/appbrand/jsapi/j
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 173	com/tencent/mm/plugin/appbrand/AppBrandRuntime:jzM	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 1342 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1352
    //   99: invokestatic 282	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 316
    //   109: ldc_w 1375
    //   112: iconst_1
    //   113: anewarray 5	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1378	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 623	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      ae.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      AppMethodBeat.o(134474);
      return;
    }
    ae.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", new Object[] { paramAppBrandInitConfig });
    this.jzC = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.jzQ = new com.tencent.mm.plugin.appbrand.a.c(this);
    this.jzQ.jOf.start();
    this.jzQ.a(new AppBrandRuntime.12(this));
    this.mInitialized = false;
    try
    {
      this.mDestroyed = false;
      this.SB = false;
      this.jzS = false;
      this.jzT = false;
      this.jzU = false;
      ae.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(134474);
      return;
    }
    finally
    {
      AppMethodBeat.o(134474);
    }
  }
  
  public final void cC(View paramView)
  {
    AppMethodBeat.i(207676);
    ao.jEf.a(this, paramView);
    AppMethodBeat.o(207676);
  }
  
  public void close()
  {
    AppMethodBeat.i(134511);
    com.tencent.luggage.h.f.aD(com.tencent.mm.sdk.f.a.jw(this.mContext));
    R(null);
    AppMethodBeat.o(134511);
  }
  
  protected final void d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 1;
    AppMethodBeat.i(134477);
    if (!this.mInitialized)
    {
      ae.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramAppBrandInitConfig });
      if ((!isDestroyed()) && (!this.SB))
      {
        ae.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { this.mAppId });
        a(paramAppBrandInitConfig, "dispatchNewConfigBeforeInitialized");
      }
      AppMethodBeat.o(134477);
      return;
    }
    ae.i("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
    int i;
    if (paramAppBrandInitConfig != null) {
      if (this.jzU)
      {
        this.jzU = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        aWH();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(134477);
      return;
      i = j;
      if (paramAppBrandInitConfig.dQv == this.jzC.dQv)
      {
        i = j;
        if (paramAppBrandInitConfig.kaG == this.jzC.kaG) {
          i = 0;
        }
      }
    }
  }
  
  final void dispatchDestroy()
  {
    AppMethodBeat.i(176506);
    boolean bool = isDestroyed();
    ae.i("MicroMsg.AppBrandRuntime", "dispatchDestroy, finished?[%b] initialized?[%b]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.mInitialized) });
    if (bool)
    {
      AppMethodBeat.o(176506);
      return;
    }
    try
    {
      this.mDestroyed = true;
      onDestroy();
      ap localap = this.jzA;
      ??? = localap.jEk.iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)???).next()).dead();
      }
      localObject1.jEk.clear();
    }
    finally
    {
      AppMethodBeat.o(176506);
    }
    this.jzL = null;
    com.tencent.mm.plugin.appbrand.media.a.a.PR(this.mAppId);
    AppBrandMainProcessService.b(this.jAh);
    h.KN(this.mAppId);
    h.a(this.mAppId, h.b.jzf);
    com.tencent.luggage.h.f.aD(com.tencent.mm.sdk.f.a.jw(this.mContext));
    ??? = this.jzQ;
    ??? = ((com.tencent.mm.plugin.appbrand.a.c)???).jOf;
    if (!((com.tencent.mm.plugin.appbrand.a.d)???).jOo.get()) {
      ae.printErrStackTrace(((com.tencent.mm.plugin.appbrand.a.d)???).TAG, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
    }
    for (;;)
    {
      synchronized (((com.tencent.mm.plugin.appbrand.a.c)???).jOg)
      {
        ((com.tencent.mm.plugin.appbrand.a.c)???).jOg.clear();
        this.jzV = null;
        ??? = com.tencent.mm.plugin.appbrand.o.f.btT();
        ??? = this.mAppId;
        if (((com.tencent.mm.plugin.appbrand.o.f)???).mak.containsKey(???)) {
          ??? = (com.tencent.mm.plugin.appbrand.o.d)((com.tencent.mm.plugin.appbrand.o.f)???).mak.remove(???);
        }
        synchronized (((com.tencent.mm.plugin.appbrand.o.d)???).mam)
        {
          ((com.tencent.mm.plugin.appbrand.o.d)???).mam.clear();
          ((com.tencent.mm.plugin.appbrand.o.d)???).mao.clear();
          ((com.tencent.mm.plugin.appbrand.o.d)???).man.clear();
          ??? = com.tencent.mm.plugin.appbrand.o.c.btQ();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.o.c)???).mak.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.o.b)((com.tencent.mm.plugin.appbrand.o.c)???).mak.remove(???)).release();
          }
          ??? = com.tencent.mm.plugin.appbrand.o.i.btV();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.o.i)???).mak.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.o.g)((com.tencent.mm.plugin.appbrand.o.i)???).mak.remove(???)).release();
          }
          ??? = l.btY();
          ??? = this.mAppId;
          if (((l)???).mak.containsKey(???))
          {
            ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((l)???).mak.remove(???);
            if (??? != null) {
              ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
            }
          }
          h.KS(this.mAppId);
          this.jzF.setOnHierarchyChangeListener(null);
          this.jzF.removeAllViewsInLayout();
          this.iGI.bEI();
          this.jzH.bEI();
          if (this.jzJ != null)
          {
            ??? = this.jzJ;
            if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).mkL != null)
            {
              ??? = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).mkL;
              if (??? == null) {
                d.g.b.p.bdF("capsuleBarView");
              }
              if (((com.tencent.mm.plugin.appbrand.page.capsulebar.d)???).mkJ != null) {
                ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)???).mkJ.animate().cancel();
              }
              ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)???).removeAllViews();
            }
            if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).mkM != null)
            {
              ??? = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)???).mkM;
              if (??? == null) {
                d.g.b.p.bdF("blinkWrapper");
              }
              ((com.tencent.mm.plugin.appbrand.page.capsulebar.h)???).clearAnimation();
            }
          }
          this.jzK = null;
          if (this.jzI != null)
          {
            this.jzI.removeAllViews();
            this.jzI = null;
          }
          if (this.mInitialized)
          {
            this.jzD.cleanup();
            this.jzD = null;
            this.jzE.cleanup();
            this.jzE = null;
          }
          ??? = this.jAg;
          this.jAg = null;
          if ((??? == null) || (((Queue)???).isEmpty()))
          {
            ae.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { this.mAppId });
            this.jzM.clear();
          }
        }
      }
      synchronized (this.jzN)
      {
        this.jzN.clear();
        this.jzO.unregisterAll();
        this.jAj.clear();
        this.jzz.removeCallbacksAndMessages(null);
        this.jAi.stopTimer();
        this.jAk.clear();
        com.tencent.mm.plugin.appbrand.page.w.ae(this);
        AppMethodBeat.o(176506);
        return;
        ((com.tencent.mm.plugin.appbrand.a.d)???).jOp.set(true);
        if (((com.tencent.mm.plugin.appbrand.a.d)???).bbH())
        {
          ae.e(((com.tencent.mm.plugin.appbrand.a.d)???).TAG, "stop() called, but still isInConstruction");
          ((com.tencent.mm.plugin.appbrand.a.d)???).quit();
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.a.d)???).a(com.tencent.mm.plugin.appbrand.a.b.jOd);
          break;
          d.c localc = ((com.tencent.mm.sdk.d.d)???).IBf;
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
        ae.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", new Object[] { Integer.valueOf(localObject3.size()), this.mAppId });
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
    ae.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.jzQ.jOf.a(d.a.jOB);
    this.jzD.Db();
    this.jzE.onBackground();
    h.KP(this.mAppId);
    h.a(this.mAppId, h.b.jzd);
    ae.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      bi.a(ak.getContext(), null);
      AppMethodBeat.o(176504);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
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
    ae.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((isDestroyed()) || (this.jzS))
    {
      this.mResumed = true;
      a(null, "");
      AppMethodBeat.o(176508);
      return;
    }
    this.mResumed = true;
    h.KT(this.mAppId);
    h.KQ(this.mAppId);
    h.a(this.mAppId, h.b.jzc);
    boolean bool = this.jzT;
    this.jzE.onForeground();
    this.jzQ.jOf.a(d.a.jOC, "onRuntimeResume");
    this.jzD.bw(bool);
    onResume();
    if (bool) {
      this.jzE.aw(aWx(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.e locale = this.jzP;
    ae.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      bi.a(ak.getContext(), locale.mTD);
      aWL();
      this.jzS = false;
      this.jzT = false;
      AppMethodBeat.o(176508);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] resume set callback", new Object[0]);
      }
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134507);
    super.finalize();
    this.jzz.removeCallbacksAndMessages(null);
    AppMethodBeat.o(134507);
  }
  
  public void finish()
  {
    AppMethodBeat.i(134508);
    if (isDestroyed())
    {
      ae.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(134508);
      return;
    }
    this.SB = true;
    com.tencent.luggage.h.f.aD(com.tencent.mm.sdk.f.a.jw(this.mContext));
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134449);
        if (AppBrandRuntime.s(AppBrandRuntime.this) == null)
        {
          AppBrandRuntime.this.dispatchDestroy();
          AppMethodBeat.o(134449);
          return;
        }
        AppBrandRuntime.s(AppBrandRuntime.this).x(AppBrandRuntime.this);
        AppMethodBeat.o(134449);
      }
    }, 0L);
    AppMethodBeat.o(134508);
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
    AppMethodBeat.i(224481);
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(this.mContext);
    AppMethodBeat.o(224481);
    return localActivity;
  }
  
  public bq getDecorWidgetFactory()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.jzy == null)
    {
      ae.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return dummy", new Object[] { this.mAppId });
      if (this.jAd == null) {
        this.jAd = new o();
      }
      localc = this.jAd;
      AppMethodBeat.o(176502);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.platform.window.c localc = this.jzy.getWindowAndroid();
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
    if ((this.jzy != null) && (this.jzy.w(this)))
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
      ae.w("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134520);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    if ((ar.isMainThread()) && (0L == l))
    {
      paramRunnable.run();
      AppMethodBeat.o(134520);
      return;
    }
    paramRunnable = u.a(this.jzA, paramRunnable);
    keep(paramRunnable);
    this.jzz.postDelayed(paramRunnable, l);
    AppMethodBeat.o(134520);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(134473);
    this.jzA.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(207679);
    if (this.jzG == null)
    {
      if (this.jzH.onBackPressed())
      {
        AppMethodBeat.o(207679);
        return;
      }
      if (this.iGI.onBackPressed())
      {
        AppMethodBeat.o(207679);
        return;
      }
      if (this.jzE != null)
      {
        this.jzE.onBackPressed();
        AppMethodBeat.o(207679);
      }
    }
    else
    {
      h.a(this.mAppId, h.d.jzi);
      finish();
    }
    AppMethodBeat.o(207679);
  }
  
  protected void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(176503);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(207674);
        AppBrandRuntime.a(AppBrandRuntime.this, paramConfiguration);
        AppMethodBeat.o(207674);
        return false;
      }
    });
    if (this.jzZ != null)
    {
      com.tencent.mm.plugin.appbrand.pip.f localf = this.jzZ;
      ae.i(localf.crG, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (localf.msw != null)
      {
        paramConfiguration = localf.msw;
        ae.i(paramConfiguration.crG, "onConfigurationChanged");
        if (!paramConfiguration.mrr)
        {
          ae.d(paramConfiguration.crG, "onConfigurationChanged, false == mHandleStarted");
          AppMethodBeat.o(176503);
          return;
        }
        paramConfiguration.mro.a(paramConfiguration.ckP, new b.1(paramConfiguration));
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
    AppMethodBeat.i(207678);
    this.jzD.aYB().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.jzD.aYB().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(207678);
  }
  
  protected void onResume() {}
  
  static abstract interface a
  {
    public abstract void done();
  }
  
  public static abstract class b
  {
    AppBrandRuntime.a jAB;
    
    public void BJ()
    {
      if (this.jAB != null) {
        this.jAB.done();
      }
    }
    
    public void interrupt() {}
    
    public abstract void prepare();
  }
  
  final class c
    implements AppBrandRuntime.a, com.tencent.mm.vending.e.a
  {
    private final String jAC;
    volatile boolean jAD;
    
    private c()
    {
      AppMethodBeat.i(134470);
      this.jAC = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
      ae.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()) });
      AppBrandRuntime.this.keep(this);
      this.jAD = false;
      AppMethodBeat.o(134470);
    }
    
    public final void dead()
    {
      this.jAD = true;
    }
    
    public final void done()
    {
      AppMethodBeat.i(134471);
      if (!this.jAD)
      {
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134469);
            if (!AppBrandRuntime.c.this.jAD)
            {
              AppBrandRuntime.g(AppBrandRuntime.this);
              AppBrandRuntime.h(AppBrandRuntime.this);
              AppMethodBeat.o(134469);
              return;
            }
            ae.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
            AppMethodBeat.o(134469);
          }
        };
        AppBrandRuntime.this.j(local1, 0L);
        AppMethodBeat.o(134471);
        return;
      }
      ae.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
      AppMethodBeat.o(134471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */