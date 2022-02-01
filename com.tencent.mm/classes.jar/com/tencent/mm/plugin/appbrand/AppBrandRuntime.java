package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
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
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.o.a.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.af.1;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.f;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
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
  public volatile boolean PR;
  public com.tencent.mm.plugin.appbrand.widget.dialog.e hKb;
  public com.tencent.mm.plugin.appbrand.widget.d iDA;
  private v iDB;
  private com.tencent.mm.plugin.appbrand.ad.e iDC;
  volatile boolean iDD;
  volatile boolean iDE;
  private volatile p iDF;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<j> iDG;
  private final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.k> iDH;
  private final y iDI;
  private com.tencent.mm.plugin.appbrand.utils.d iDJ;
  public volatile com.tencent.mm.plugin.appbrand.b.c iDK;
  public com.tencent.mm.plugin.appbrand.o.a iDL;
  protected boolean iDM;
  public boolean iDN;
  private boolean iDO;
  public al iDP;
  public boolean iDQ;
  public boolean iDR;
  public boolean iDS;
  public com.tencent.mm.plugin.appbrand.page.aj iDT;
  private AppBrandPipContainerView iDU;
  public boolean iDV;
  private LinkedList<AppBrandRuntime.b> iDW;
  ConcurrentLinkedQueue<AppBrandRuntime.b> iDX;
  private AppBrandMainProcessService.a iDY;
  private final av iDZ;
  public ai iDt;
  private final ap iDu;
  private final an iDv;
  AppBrandRuntime iDw;
  public volatile AppBrandInitConfig iDx;
  private volatile q iDy;
  private volatile t iDz;
  private final Deque<Runnable> iEa;
  public SparseArray<Set<aj>> iEb;
  public volatile String mAppId;
  public Context mContext;
  private boolean mDestroyed;
  public volatile boolean mInitialized;
  public boolean mResumed;
  
  public AppBrandRuntime(ai paramai)
  {
    AppMethodBeat.i(176500);
    this.iDD = false;
    this.iDE = false;
    this.iDF = null;
    this.iDG = new AppBrandRuntime.1(this);
    this.iDH = new LinkedHashSet();
    this.iDI = new y();
    this.mResumed = false;
    this.iDQ = false;
    this.iDR = true;
    this.iDV = false;
    this.iDW = new LinkedList();
    this.iDX = null;
    this.iDY = new AppBrandMainProcessService.a()
    {
      private boolean iEg = false;
      
      public final void Dh(String paramAnonymousString)
      {
        AppMethodBeat.i(176494);
        if (this.iEg) {
          AppBrandRuntime.u(AppBrandRuntime.this);
        }
        this.iEg = false;
        AppMethodBeat.o(176494);
      }
      
      public final void onDisconnected(String paramAnonymousString)
      {
        this.iEg = true;
      }
    };
    this.iDZ = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(176495);
        ad.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { AppBrandRuntime.this.mAppId });
        AppBrandRuntime.this.aLU();
        AppMethodBeat.o(176495);
        return false;
      }
    }, false);
    this.iEa = new LinkedBlockingDeque();
    this.iEb = new SparseArray();
    this.mContext = paramai.getContext();
    this.iDt = paramai;
    this.iDu = new ap(Looper.getMainLooper());
    this.iDv = new an();
    this.iDA = new com.tencent.mm.plugin.appbrand.widget.d(this.mContext);
    this.iDA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.hKb = new com.tencent.mm.plugin.appbrand.widget.dialog.e(this.mContext);
    this.iDA.addView(this.hKb);
    this.iDJ = new com.tencent.mm.plugin.appbrand.utils.d();
    this.iDS = false;
    AppMethodBeat.o(176500);
  }
  
  private void aLZ()
  {
    AppMethodBeat.i(134499);
    com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitPageContainer", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134447);
        AppBrandRuntime.a(AppBrandRuntime.this, AppBrandRuntime.this.aLX());
        AppBrandRuntime.p(AppBrandRuntime.this).setOnReadyListener(new t.f()
        {
          public final void aMr()
          {
            AppMethodBeat.i(176492);
            AppBrandRuntime.o(AppBrandRuntime.this);
            AppBrandRuntime.a(AppBrandRuntime.this, null);
            AppMethodBeat.o(176492);
          }
        });
        AppBrandRuntime.q(AppBrandRuntime.this).addView(AppBrandRuntime.p(AppBrandRuntime.this), 0);
        AppBrandRuntime.p(AppBrandRuntime.this).Kx(AppBrandRuntime.r(AppBrandRuntime.this).iJb);
        AppMethodBeat.o(134447);
      }
    });
    AppMethodBeat.o(134499);
  }
  
  private void aMa()
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
  
  private void aMl()
  {
    AppMethodBeat.i(176512);
    if ((this.iDC == null) && (this.iDD)) {
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
  
  private void mO(long paramLong)
  {
    AppMethodBeat.i(134525);
    i(new AppBrandRuntime.17(this, paramLong), paramLong);
    AppMethodBeat.o(134525);
  }
  
  protected p DX()
  {
    AppMethodBeat.i(134486);
    u localu = new u(this);
    AppMethodBeat.o(134486);
    return localu;
  }
  
  protected void Df(String paramString) {}
  
  protected void Dg(String paramString)
  {
    AppMethodBeat.i(194397);
    Object localObject2 = getAppConfig();
    com.tencent.mm.plugin.appbrand.s.a.c localc = getWindowAndroid();
    if (localc != null) {
      if (localObject2 == null) {
        break label159;
      }
    }
    label159:
    for (boolean bool = getAppConfig().jbu;; bool = false)
    {
      Object localObject1 = "portrait";
      if (localObject2 != null)
      {
        localObject2 = getAppConfig().aTm().jcb;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = getAppConfig().jbo.jbC;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "portrait";
          }
        }
      }
      localc.setSoftOrientation((String)localObject1);
      localc.setResizeable(bool);
      ad.i("MicroMsg.AppBrandRuntime", "setResizableToWindow: stage[%s] resizable = [%b], appId = [%s]", new Object[] { paramString, Boolean.valueOf(bool), this.mAppId });
      AppMethodBeat.o(194397);
      return;
      ad.e("MicroMsg.AppBrandRuntime", "setResizableToWindow: window should not be null");
      AppMethodBeat.o(194397);
      return;
    }
  }
  
  public q Du()
  {
    return this.iDy;
  }
  
  protected void Ea() {}
  
  protected com.tencent.mm.plugin.appbrand.o.a Ed()
  {
    AppMethodBeat.i(134484);
    a.c localc = new a.c();
    AppMethodBeat.o(134484);
    return localc;
  }
  
  public p Ee()
  {
    return this.iDF;
  }
  
  public com.tencent.mm.plugin.appbrand.config.k Ef()
  {
    AppMethodBeat.i(134481);
    com.tencent.mm.plugin.appbrand.config.k localk = (com.tencent.mm.plugin.appbrand.config.k)ar(com.tencent.mm.plugin.appbrand.config.k.class);
    AppMethodBeat.o(134481);
    return localk;
  }
  
  public AppBrandInitConfig Eg()
  {
    return this.iDx;
  }
  
  protected boolean J(Runnable paramRunnable)
  {
    return false;
  }
  
  public final void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(134518);
    if ((this.PR) || (isDestroyed()))
    {
      ad.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(134518);
      return;
    }
    if (this.mInitialized)
    {
      i(paramRunnable, 0L);
      AppMethodBeat.o(134518);
      return;
    }
    this.iEa.offerLast(paramRunnable);
    AppMethodBeat.o(134518);
  }
  
  public final void L(Runnable paramRunnable)
  {
    AppMethodBeat.i(203649);
    i(paramRunnable, 0L);
    AppMethodBeat.o(203649);
  }
  
  public final void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(194396);
    if (isDestroyed())
    {
      AppMethodBeat.o(194396);
      return;
    }
    paramRunnable = s.a(this.iDv, paramRunnable);
    keep(paramRunnable);
    com.tencent.e.h.Iye.q(paramRunnable, 0L);
    AppMethodBeat.o(194396);
  }
  
  public final void O(Object paramObject)
  {
    AppMethodBeat.i(176509);
    i(new AppBrandRuntime.9(this, paramObject), 0L);
    AppMethodBeat.o(176509);
  }
  
  protected <T extends com.tencent.mm.kernel.c.a> T S(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, aj paramaj)
  {
    AppMethodBeat.i(178506);
    i(new AppBrandRuntime.14(this, paramaj, paramInt2, paramInt1), 0L);
    AppMethodBeat.o(178506);
  }
  
  protected final void a(AppBrandRuntime.b paramb)
  {
    AppMethodBeat.i(134476);
    this.iDW.add(paramb);
    AppMethodBeat.o(134476);
  }
  
  public void a(ai paramai)
  {
    this.iDt = paramai;
  }
  
  public final void a(aj paramaj)
  {
    AppMethodBeat.i(134522);
    i(new AppBrandRuntime.15(this, paramaj), 0L);
    AppMethodBeat.o(134522);
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.iDx = paramAppBrandInitConfig;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject) {}
  
  public final void a(com.tencent.mm.plugin.appbrand.config.a parama)
  {
    AppMethodBeat.i(134483);
    this.iDG.add(parama);
    AppMethodBeat.o(134483);
  }
  
  public final void a(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(160924);
    this.iDv.a(parama);
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
    synchronized (this.iDH)
    {
      this.iDH.add(paramk);
      AppMethodBeat.o(134493);
      return true;
    }
  }
  
  public final m aLB()
  {
    return this.hKb;
  }
  
  public final void aLH()
  {
    AppMethodBeat.i(134475);
    this.mResumed = true;
    long l = bt.GC();
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { this.mAppId });
    com.tencent.mm.plugin.appbrand.ad.g localg = (com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class);
    if (localg != null) {}
    for (boolean bool = localg.O(this);; bool = false)
    {
      this.iDD = bool;
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
            ad.i("MicroMsg.AppBrandRuntime", "launch, not show ad, show splash");
            AppBrandRuntime.this.aMn();
            AppBrandRuntime.this.aLP();
          }
          AppMethodBeat.o(134465);
        }
      });
      this.iDZ.av(10000L, 10000L);
      ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { this.mAppId, Long.valueOf(bt.GC() - l) });
      AppMethodBeat.o(134475);
      return;
      ad.i("MicroMsg.AppBrandRuntime", "checkCanShowAd, IAppBrandAdService is null");
    }
  }
  
  public final int aLI()
  {
    return this.iDx.iOP;
  }
  
  public final AppBrandRuntime aLJ()
  {
    AppMethodBeat.i(134478);
    if (this.iDt == null)
    {
      AppMethodBeat.o(134478);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = this.iDt.z(this);
    AppMethodBeat.o(134478);
    return localAppBrandRuntime;
  }
  
  public t aLK()
  {
    return this.iDz;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.d aLL()
  {
    return this.iDA;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.c aLM()
  {
    return this.iDK;
  }
  
  public final void aLN()
  {
    AppMethodBeat.i(134485);
    if (this.iDF == null) {
      this.iDF = DX();
    }
    AppMethodBeat.o(134485);
  }
  
  protected v aLO()
  {
    return null;
  }
  
  protected final void aLP()
  {
    AppMethodBeat.i(134487);
    if (this.iDB != null)
    {
      com.tencent.mm.plugin.appbrand.ui.h.a(this.iDB);
      this.iDB = null;
    }
    v localv = aLO();
    if (localv == null)
    {
      AppMethodBeat.o(134487);
      return;
    }
    localv.dB(Eg().iconUrl, Eg().dfM);
    final View localView = localv.getView();
    com.tencent.mm.plugin.appbrand.ad.e locale;
    int i;
    if ((com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null) && (((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).P(this)))
    {
      locale = aMm();
      if (locale == null)
      {
        i = -1;
        this.iDA.addView(localView, i - 1, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.iDB = localv;
      localView.setClickable(true);
      this.iDE = false;
      this.iDA.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
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
                  AppBrandRuntime.this.aLK().setActuallyVisible(true);
                }
                AppMethodBeat.o(160923);
              }
            };
            AppBrandRuntime.this.aLQ();
            if (AppBrandRuntime.this.aLK() == null)
            {
              AppBrandRuntime.this.K(paramAnonymousView1);
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
      i = this.iDA.indexOfChild(locale);
      break;
      this.iDA.addView(localView, -1, -1);
    }
  }
  
  protected void aLQ() {}
  
  public final void aLR()
  {
    AppMethodBeat.i(134488);
    if (isDestroyed())
    {
      if (this.iDB != null) {
        com.tencent.mm.plugin.appbrand.ui.h.a(this.iDB);
      }
      this.iDB = null;
      AppMethodBeat.o(134488);
      return;
    }
    if (this.iDB == null)
    {
      AppMethodBeat.o(134488);
      return;
    }
    if (aMo())
    {
      this.iDE = true;
      ad.i("MicroMsg.AppBrandRuntime", "hideSplash, hide splash after ad disappears");
      AppMethodBeat.o(134488);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "hideSplash, no showing ad then reset orientation and hide splash");
    aMq();
    AppMethodBeat.o(134488);
  }
  
  public final String aLS()
  {
    AppMethodBeat.i(134489);
    if (this.iDx == null)
    {
      AppMethodBeat.o(134489);
      return "";
    }
    if (bt.isNullOrNil(this.iDx.iJb))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(134489);
        return "";
      }
      str = getAppConfig().aTo();
      AppMethodBeat.o(134489);
      return str;
    }
    String str = this.iDx.iJb;
    AppMethodBeat.o(134489);
    return str;
  }
  
  public final boolean aLT()
  {
    return this.mInitialized;
  }
  
  protected void aLU() {}
  
  protected void aLV() {}
  
  protected q aLW()
  {
    AppMethodBeat.i(134497);
    q localq = new q();
    AppMethodBeat.o(134497);
    return localq;
  }
  
  protected t aLX()
  {
    AppMethodBeat.i(134498);
    t localt = new t(com.tencent.mm.sdk.f.a.iV(this.mContext), this);
    AppMethodBeat.o(134498);
    return localt;
  }
  
  public boolean aLY()
  {
    return false;
  }
  
  protected void aMb() {}
  
  protected final void aMc()
  {
    AppMethodBeat.i(134513);
    this.iDM = true;
    ad.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(134513);
  }
  
  protected final void aMd()
  {
    AppMethodBeat.i(194394);
    if (this.iDM)
    {
      ad.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
      AppMethodBeat.o(194394);
      return;
    }
    this.iDN = true;
    ad.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(194394);
  }
  
  public final boolean aMe()
  {
    AppMethodBeat.i(134514);
    if (!this.iDR)
    {
      AppMethodBeat.o(134514);
      return false;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(this.mContext);
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      AppMethodBeat.o(134514);
      return false;
    }
    if ((this.iDz != null) && (this.iDz.getCurrentPage() != null) && (!this.iDz.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(134514);
      return true;
    }
    AppMethodBeat.o(134514);
    return false;
  }
  
  final void aMf()
  {
    AppMethodBeat.i(134515);
    this.iDK.iQP.a(d.a.iRq);
    g.CX(this.mAppId);
    AppMethodBeat.o(134515);
  }
  
  public void aMg()
  {
    AppMethodBeat.i(176510);
    M(new AppBrandRuntime.13(this));
    AppMethodBeat.o(176510);
  }
  
  public boolean aMh()
  {
    AppMethodBeat.i(134517);
    if (this.iDK.iQP.aQO() == com.tencent.mm.plugin.appbrand.b.b.iQM) {}
    for (int i = 1; i != 0; i = 0)
    {
      dispatchDestroy();
      AppMethodBeat.o(134517);
      return true;
    }
    AppMethodBeat.o(134517);
    return false;
  }
  
  protected v aMi()
  {
    return this.iDB;
  }
  
  protected void aMj() {}
  
  public final boolean aMk()
  {
    return this.iDD;
  }
  
  public final com.tencent.mm.plugin.appbrand.ad.e aMm()
  {
    AppMethodBeat.i(176513);
    aMl();
    com.tencent.mm.plugin.appbrand.ad.e locale = this.iDC;
    AppMethodBeat.o(176513);
    return locale;
  }
  
  public final void aMn()
  {
    AppMethodBeat.i(164050);
    if (this.iDC != null) {
      this.iDC.setVisibility(8);
    }
    AppMethodBeat.o(164050);
  }
  
  public final boolean aMo()
  {
    AppMethodBeat.i(134523);
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null)
    {
      boolean bool = ((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).P(this);
      AppMethodBeat.o(134523);
      return bool;
    }
    ad.i("MicroMsg.AppBrandRuntime", "isShowingLaunchAd, IAppBrandAdService is null");
    AppMethodBeat.o(134523);
    return false;
  }
  
  public final int aMp()
  {
    AppMethodBeat.i(160926);
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class) != null)
    {
      int i = ((com.tencent.mm.plugin.appbrand.ad.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ad.g.class)).M(this);
      AppMethodBeat.o(160926);
      return i;
    }
    ad.i("MicroMsg.AppBrandRuntime", "getCheckShowAdTimeThreshold, IAppBrandAdService is null");
    AppMethodBeat.o(160926);
    return 140;
  }
  
  final void aMq()
  {
    AppMethodBeat.i(134526);
    if (!this.mInitialized)
    {
      mO(0L);
      AppMethodBeat.o(134526);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationAndHideSplash, reset orientation and hide splash");
    if (!b(new AppBrandRuntime.18(this))) {
      mO(0L);
    }
    mO(200L);
    AppMethodBeat.o(134526);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ab(Class<T> paramClass)
  {
    AppMethodBeat.i(134494);
    com.tencent.mm.kernel.c.a locala = this.iDI.al(paramClass);
    if (locala != null)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locala);
      AppMethodBeat.o(134494);
      return paramClass;
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.h.class)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.h.lQv);
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
    this.iDI.ac(paramClass);
    AppMethodBeat.o(134496);
  }
  
  public final <T extends j> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(134491);
    if (!this.iDV) {}
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
    synchronized (this.iDH)
    {
      Iterator localIterator = this.iDH.iterator();
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
    this.iDI.b(paramClass, paramN);
    AppMethodBeat.o(134495);
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(194391);
    if (paramk == null)
    {
      AppMethodBeat.o(194391);
      return false;
    }
    synchronized (this.iDH)
    {
      this.iDH.remove(paramk);
      AppMethodBeat.o(194391);
      return true;
    }
  }
  
  final boolean b(com.tencent.mm.plugin.appbrand.s.a.e.a parama)
  {
    AppMethodBeat.i(176514);
    if ((aLK() != null) && (aLK().getPageView() != null))
    {
      com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)aLK().getPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (locald != null)
      {
        String str = locald.Cw();
        ad.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationInternal, request orientation:%s", new Object[] { str });
        if (!bt.isNullOrNil(str))
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
    //   0: ldc_w 1317
    //   3: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 157	com/tencent/mm/plugin/appbrand/AppBrandRuntime:iDG	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 1322	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 486 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 490 1 0
    //   38: checkcast 1324	com/tencent/mm/plugin/appbrand/jsapi/j
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 1283	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 1330	org/a/a:bA	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 1334	org/a/a:fMX	()Lorg/a/a;
    //   65: getfield 1338	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 1324	com/tencent/mm/plugin/appbrand/jsapi/j
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 157	com/tencent/mm/plugin/appbrand/AppBrandRuntime:iDG	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 997 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 1317
    //   99: invokestatic 266	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 330
    //   109: ldc_w 1340
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 1343	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 649	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      ad.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      AppMethodBeat.o(134474);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", new Object[] { paramAppBrandInitConfig });
    this.iDx = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.iDK = new com.tencent.mm.plugin.appbrand.b.c(this);
    this.iDK.iQP.start();
    this.iDK.a(new AppBrandRuntime.20(this));
    this.mInitialized = false;
    try
    {
      this.mDestroyed = false;
      this.PR = false;
      this.iDM = false;
      this.iDN = false;
      this.iDO = false;
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
    com.tencent.luggage.h.f.aB(com.tencent.mm.sdk.f.a.iV(this.mContext));
    O(null);
    AppMethodBeat.o(134511);
  }
  
  protected final void d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 1;
    AppMethodBeat.i(134477);
    if (!this.mInitialized)
    {
      ad.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramAppBrandInitConfig });
      if ((!isDestroyed()) && (!this.PR))
      {
        ad.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { this.mAppId });
        e(paramAppBrandInitConfig);
      }
      AppMethodBeat.o(134477);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
    int i;
    if (paramAppBrandInitConfig != null) {
      if (this.iDO)
      {
        this.iDO = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        aMc();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(134477);
      return;
      i = j;
      if (paramAppBrandInitConfig.iOP == this.iDx.iOP)
      {
        i = j;
        if (paramAppBrandInitConfig.jdi == this.iDx.jdi) {
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
      an localan = this.iDv;
      ??? = localan.iHY.iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)???).next()).dead();
      }
      localObject1.iHY.clear();
    }
    finally
    {
      AppMethodBeat.o(176506);
    }
    this.iDF = null;
    com.tencent.mm.plugin.appbrand.media.a.a.HL(this.mAppId);
    AppBrandMainProcessService.b(this.iDY);
    g.CW(this.mAppId);
    g.a(this.mAppId, g.b.iDa);
    com.tencent.luggage.h.f.aB(com.tencent.mm.sdk.f.a.iV(this.mContext));
    ??? = this.iDK;
    ??? = ((com.tencent.mm.plugin.appbrand.b.c)???).iQP;
    if (!((com.tencent.mm.plugin.appbrand.b.d)???).iQY.get()) {
      ad.printErrStackTrace(((com.tencent.mm.plugin.appbrand.b.d)???).TAG, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
    }
    for (;;)
    {
      synchronized (((com.tencent.mm.plugin.appbrand.b.c)???).iQQ)
      {
        ((com.tencent.mm.plugin.appbrand.b.c)???).iQQ.clear();
        this.iDP = null;
        ??? = com.tencent.mm.plugin.appbrand.q.f.bip();
        ??? = this.mAppId;
        if (((com.tencent.mm.plugin.appbrand.q.f)???).kUJ.containsKey(???)) {
          ??? = (com.tencent.mm.plugin.appbrand.q.d)((com.tencent.mm.plugin.appbrand.q.f)???).kUJ.remove(???);
        }
        synchronized (((com.tencent.mm.plugin.appbrand.q.d)???).kUL)
        {
          ((com.tencent.mm.plugin.appbrand.q.d)???).kUL.clear();
          ((com.tencent.mm.plugin.appbrand.q.d)???).kUN.clear();
          ((com.tencent.mm.plugin.appbrand.q.d)???).kUM.clear();
          ??? = com.tencent.mm.plugin.appbrand.q.c.bim();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.q.c)???).kUJ.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.q.b)((com.tencent.mm.plugin.appbrand.q.c)???).kUJ.remove(???)).release();
          }
          ??? = com.tencent.mm.plugin.appbrand.q.i.bir();
          ??? = this.mAppId;
          if (((com.tencent.mm.plugin.appbrand.q.i)???).kUJ.containsKey(???)) {
            ((com.tencent.mm.plugin.appbrand.q.g)((com.tencent.mm.plugin.appbrand.q.i)???).kUJ.remove(???)).release();
          }
          ??? = l.biu();
          ??? = this.mAppId;
          if (((l)???).kUJ.containsKey(???))
          {
            ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((l)???).kUJ.remove(???);
            if (??? != null) {
              ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
            }
          }
          g.Db(this.mAppId);
          this.iDA.setOnHierarchyChangeListener(null);
          this.iDA.removeAllViewsInLayout();
          this.hKb.fQX();
          if (this.mInitialized)
          {
            this.iDy.cleanup();
            this.iDy = null;
            this.iDz.cleanup();
            this.iDz = null;
          }
          ??? = this.iDX;
          this.iDX = null;
          if ((??? == null) || (((Queue)???).isEmpty()))
          {
            ad.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { this.mAppId });
            this.iDG.clear();
          }
        }
      }
      synchronized (this.iDH)
      {
        this.iDH.clear();
        this.iDI.unregisterAll();
        this.iEa.clear();
        this.iDu.removeCallbacksAndMessages(null);
        this.iDZ.stopTimer();
        this.iEb.clear();
        w.al(this);
        AppMethodBeat.o(176506);
        return;
        ((com.tencent.mm.plugin.appbrand.b.d)???).iQZ.set(true);
        if (((com.tencent.mm.plugin.appbrand.b.d)???).aQN())
        {
          ad.e(((com.tencent.mm.plugin.appbrand.b.d)???).TAG, "stop() called, but still isInConstruction");
          ((com.tencent.mm.plugin.appbrand.b.d)???).quit();
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.b.d)???).a(com.tencent.mm.plugin.appbrand.b.b.iQN);
          break;
          d.c localc = ((com.tencent.mm.sdk.d.d)???).EXN;
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
    this.iDK.iQP.a(d.a.iRl);
    this.iDy.BV();
    this.iDz.onBackground();
    g.CY(this.mAppId);
    g.a(this.mAppId, g.b.iCY);
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
    AppMethodBeat.i(176505);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(176505);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((isDestroyed()) || (this.iDM))
    {
      this.mResumed = true;
      e(null);
      AppMethodBeat.o(176505);
      return;
    }
    this.mResumed = true;
    g.Dc(this.mAppId);
    g.CZ(this.mAppId);
    g.a(this.mAppId, g.b.iCX);
    boolean bool = this.iDN;
    this.iDz.onForeground();
    this.iDK.iQP.a(d.a.iRm, "onRuntimeResume");
    this.iDy.bx(bool);
    onResume();
    if (bool) {
      this.iDz.at(aLS(), true);
    }
    com.tencent.mm.plugin.appbrand.utils.d locald = this.iDJ;
    ad.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      bh.a(com.tencent.mm.sdk.platformtools.aj.getContext(), locald.lLZ);
      aMg();
      Dg("onResume");
      this.iDM = false;
      this.iDN = false;
      AppMethodBeat.o(176505);
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
  
  protected void e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134510);
    if (!this.mResumed)
    {
      ad.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s", new Object[] { this.mAppId });
      dispatchDestroy();
      if (paramAppBrandInitConfig != null) {
        this.iDx = paramAppBrandInitConfig;
      }
      AppMethodBeat.o(134510);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, stacktrace=%s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
    dispatchDestroy();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      c(paramAppBrandInitConfig);
      aLH();
      ad.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { this.mAppId });
      AppMethodBeat.o(134510);
      return;
      paramAppBrandInitConfig = Eg();
    }
  }
  
  final void fa(boolean paramBoolean)
  {
    this.iDS = paramBoolean;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134507);
    super.finalize();
    this.iDu.removeCallbacksAndMessages(null);
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
    this.PR = true;
    com.tencent.luggage.h.f.aB(com.tencent.mm.sdk.f.a.iV(this.mContext));
    i(new AppBrandRuntime.8(this), 0L);
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
    AppMethodBeat.i(203648);
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(this.mContext);
    AppMethodBeat.o(203648);
    return localActivity;
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.c getWindowAndroid()
  {
    AppMethodBeat.i(176502);
    if (this.iDt == null)
    {
      ad.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(176502);
      return null;
    }
    com.tencent.mm.plugin.appbrand.s.a.c localc = this.iDt.getWindowAndroid();
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
    paramRunnable = s.a(this.iDv, paramRunnable);
    keep(paramRunnable);
    this.iDu.postDelayed(paramRunnable, l);
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
    return this.PR;
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(134479);
    if ((this.iDt != null) && (this.iDt.A(this)))
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
    this.iDv.keep(parama);
    AppMethodBeat.o(134473);
  }
  
  protected final void onBackPressed()
  {
    AppMethodBeat.i(194393);
    if (this.iDB == null)
    {
      if (this.hKb.onBackPressed())
      {
        AppMethodBeat.o(194393);
        return;
      }
      if (this.iDz != null)
      {
        this.iDz.onBackPressed();
        AppMethodBeat.o(194393);
      }
    }
    else
    {
      g.a(this.mAppId, g.d.iDd);
      finish();
    }
    AppMethodBeat.o(194393);
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
    if (this.iDT != null)
    {
      com.tencent.mm.plugin.appbrand.page.aj localaj = this.iDT;
      ad.i(localaj.cjP, "onConfigurationChanged: newConfig: ".concat(String.valueOf(paramConfiguration)));
      if (localaj.lcU != null)
      {
        paramConfiguration = localaj.lcU;
        ad.i(paramConfiguration.cjP, "onConfigurationChanged");
        if (!paramConfiguration.lbQ)
        {
          ad.d(paramConfiguration.cjP, "onConfigurationChanged, false == mHandleStarted");
          AppMethodBeat.o(176503);
          return;
        }
        paramConfiguration.lbO.a(paramConfiguration.cdz, new af.1(paramConfiguration));
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
    AppMethodBeat.i(194392);
    this.iDy.aOf().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
    this.iDy.aOf().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    AppMethodBeat.o(194392);
  }
  
  protected void onResume() {}
  
  public final void reload()
  {
    AppMethodBeat.i(176508);
    e(null);
    AppMethodBeat.o(176508);
  }
  
  final class c
    implements AppBrandRuntime.a, com.tencent.mm.vending.e.a
  {
    private final String iEu;
    volatile boolean iEv;
    
    private c()
    {
      AppMethodBeat.i(134470);
      this.iEu = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
      ad.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()) });
      AppBrandRuntime.this.keep(this);
      this.iEv = false;
      AppMethodBeat.o(134470);
    }
    
    public final void dead()
    {
      this.iEv = true;
    }
    
    public final void done()
    {
      AppMethodBeat.i(134471);
      if (!this.iEv)
      {
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134469);
            if (!AppBrandRuntime.c.this.iEv)
            {
              AppBrandRuntime.h(AppBrandRuntime.this);
              AppBrandRuntime.i(AppBrandRuntime.this);
              AppMethodBeat.o(134469);
              return;
            }
            ad.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
            AppMethodBeat.o(134469);
          }
        };
        AppBrandRuntime.this.i(local1, 0L);
        AppMethodBeat.o(134471);
        return;
      }
      ad.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId });
      AppMethodBeat.o(134471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */