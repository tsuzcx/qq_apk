package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.a.a;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.plugin.appbrand.o.h;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.v.r;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class i
{
  public volatile boolean dNk;
  private boolean fyA;
  boolean fyB;
  public boolean fyC;
  public boolean fyD = false;
  boolean fyE = true;
  private int fyF = 0;
  private Set<a.a> fyG = Collections.newSetFromMap(new ConcurrentHashMap());
  private LinkedList<i.b> fyH = new LinkedList();
  int fyI = 0;
  private AppBrandMainProcessService.a fyJ = new i.4(this);
  Runnable fyK = new i.5(this);
  private final Deque<Runnable> fyL = new LinkedBlockingDeque();
  public Activity fyk;
  public w fyl;
  i fym;
  public volatile AppBrandInitConfig fyn;
  private volatile o fyo;
  public volatile com.tencent.mm.plugin.appbrand.page.n fyp;
  public FrameLayout fyq;
  public com.tencent.mm.plugin.appbrand.ui.n fyr;
  public com.tencent.mm.plugin.appbrand.widget.b.e fys;
  private com.tencent.mm.plugin.appbrand.appstorage.k fyt = new com.tencent.mm.plugin.appbrand.appstorage.e();
  public final ConcurrentLinkedDeque<com.tencent.mm.plugin.appbrand.jsapi.g> fyu = new ConcurrentLinkedDeque();
  private final LinkedHashSet<Object> fyv = new LinkedHashSet();
  private com.tencent.mm.plugin.appbrand.v.b fyw;
  public j fyx;
  public volatile com.tencent.mm.plugin.appbrand.b.c fyy;
  public com.tencent.mm.plugin.appbrand.m.a fyz;
  public volatile String mAppId;
  public volatile boolean mFinished;
  Handler mHandler;
  private boolean sn;
  
  public i(Activity paramActivity, w paramw)
  {
    this.fyk = paramActivity;
    this.fyl = paramw;
    this.mHandler = new Handler();
    this.fyq = new com.tencent.mm.plugin.appbrand.widget.e(paramActivity);
    this.fyq.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.fyw = new com.tencent.mm.plugin.appbrand.v.b();
    this.fyx = new j();
  }
  
  private void ZE()
  {
    if (this.fyr == null)
    {
      y.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
      return;
    }
    com.tencent.mm.plugin.appbrand.page.k localk;
    if (this.fyp != null)
    {
      localk = this.fyp.getCurrentPage();
      if (localk != null) {
        break label67;
      }
      y.e("MicroMsg.AppBrandRuntime", "hideSplash, null currentPage, appId %s", new Object[] { this.mAppId });
    }
    for (;;)
    {
      this.fyr.aoS();
      this.fyr = null;
      return;
      label67:
      this.fyr.a(localk.getPageConfig());
    }
  }
  
  @TargetApi(21)
  private void ZP()
  {
    if (ZG()) {}
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    int i = r.bb(getAppConfig().fNB.fNY, -16777216);
    this.fyk.setTaskDescription(new ActivityManager.TaskDescription(ZA().bJw, null, i));
    com.tencent.mm.modelappbrand.a.b.JD().a(new i.6(this, i), ZA().iconUrl, null);
  }
  
  public AppBrandInitConfig ZA()
  {
    return this.fyn;
  }
  
  public com.tencent.mm.plugin.appbrand.config.i ZB()
  {
    return (com.tencent.mm.plugin.appbrand.config.i)c(com.tencent.mm.plugin.appbrand.config.i.class, true);
  }
  
  protected com.tencent.mm.plugin.appbrand.m.a ZC()
  {
    return new a.c();
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.n ZD()
  {
    return null;
  }
  
  public final String ZF()
  {
    if (this.fyn == null) {
      return "";
    }
    if (bk.bl(this.fyn.fPq))
    {
      if (getAppConfig() == null) {
        return "";
      }
      return getAppConfig().adV();
    }
    return this.fyn.fPq;
  }
  
  @Deprecated
  public final boolean ZG()
  {
    return (this.fyn == null) || (this.fyn.fPs);
  }
  
  @Deprecated
  public final boolean ZH()
  {
    return (this.fyn == null) || (this.fyn.ZH());
  }
  
  protected void ZI() {}
  
  protected o ZJ()
  {
    return new o();
  }
  
  protected com.tencent.mm.plugin.appbrand.page.n ZK()
  {
    return new com.tencent.mm.plugin.appbrand.page.n(getContext(), this);
  }
  
  protected void ZL() {}
  
  public final void ZM()
  {
    if (!this.dNk) {}
    while (this.mFinished) {
      return;
    }
    y.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.sn = true;
    onPause();
    this.fyy.fFN.ku(1);
    this.fyo.aap();
    this.fyp.qa();
    g.qw(this.mAppId);
    g.a(this.mAppId, g.a.fxV);
    y.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    ay.a(ae.getContext(), null);
  }
  
  final void ZN()
  {
    if (!this.dNk) {
      return;
    }
    y.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((this.mFinished) || (this.fyA))
    {
      reload();
      return;
    }
    this.sn = false;
    g.qA(this.mAppId);
    g.qx(this.mAppId);
    g.a(this.mAppId, g.a.fxU);
    onResume();
    this.fyp.pY();
    this.fyy.fFN.ku(3);
    this.fyo.cE(this.fyB);
    if (this.fyB) {
      this.fyp.aa(ZF(), true);
    }
    com.tencent.mm.plugin.appbrand.v.b localb = this.fyw;
    y.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    ay.a(ae.getContext(), localb.hlc);
    ZP();
    this.fyA = false;
    this.fyB = false;
  }
  
  protected void ZO() {}
  
  public final boolean ZQ()
  {
    if ((this.sn) && (this.fyF == 0))
    {
      cleanup();
      return true;
    }
    return false;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.k Zl()
  {
    return this.fyt;
  }
  
  final void Zw()
  {
    if (this.fyr != null) {
      ZE();
    }
    Object localObject = ZD();
    if (localObject != null)
    {
      this.fyq.addView(((com.tencent.mm.plugin.appbrand.ui.n)localObject).getView(), -1, -1);
      this.fyr = ((com.tencent.mm.plugin.appbrand.ui.n)localObject);
      this.fyr.getView().setClickable(true);
    }
    a(new i.7(this));
    y.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", new Object[] { this.fyn.bJw, this.fyn.appId });
    AppBrandMainProcessService.a(this.fyJ);
    onCreate();
    this.fyy.fFN.ku(3);
    g.qA(this.mAppId);
    g.qu(this.mAppId);
    g.a(this.mAppId, g.a.fxT);
    p.tN(this.mAppId);
    localObject = new i.a()
    {
      public final void done()
      {
        i locali = i.this;
        if (!locali.mFinished)
        {
          if (locali.dNk) {
            y.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", new Object[] { bk.j(new Throwable()) });
          }
        }
        else {
          return;
        }
        y.d("MicroMsg.AppBrandRuntime", "initRuntime %s", new Object[] { locali.mAppId });
        i.12 local12 = new i.12(locali);
        int i = locali.fyI + 1;
        locali.fyI = i;
        if (i > 1)
        {
          local12.run();
          return;
        }
        Looper.myQueue().addIdleHandler(new i.13(locali, local12));
      }
    };
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue(this.fyH);
    this.fyH = new LinkedList();
    Iterator localIterator = localConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      i.b localb = (i.b)localIterator.next();
      localb.fyV = new i.9(this, localConcurrentLinkedQueue, localb, (i.a)localObject);
      localb.prepare();
    }
    this.mHandler.postDelayed(this.fyK, 10000L);
  }
  
  public final i Zx()
  {
    return this.fyl.d(this);
  }
  
  public o Zy()
  {
    return this.fyo;
  }
  
  public com.tencent.mm.plugin.appbrand.page.n Zz()
  {
    return this.fyp;
  }
  
  final void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    if (paramAppBrandInitConfig == null)
    {
      y.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      return;
    }
    this.fyn = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.fyy = new com.tencent.mm.plugin.appbrand.b.c(this);
    this.fyy.fFN.start();
    this.fyy.a(new i.1(this));
    this.fys = new com.tencent.mm.plugin.appbrand.widget.b.e(this.fyk);
    y.i("MicroMsg.AppBrandRuntime", "init %s, config %s", new Object[] { this.mAppId, this.fyn });
    this.dNk = false;
    this.sn = false;
    this.mFinished = false;
    this.fyA = false;
    this.fyB = false;
    this.fyC = false;
    this.fyF = 0;
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    Object localObject = null;
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramAppBrandInitConfig.appId;
    localAppBrandLaunchReferrer.fPF = 3;
    String str;
    if (paramMiniProgramNavigationBackResult == null)
    {
      str = null;
      localAppBrandLaunchReferrer.fPG = str;
      if (paramMiniProgramNavigationBackResult != null) {
        break label81;
      }
    }
    label81:
    for (paramMiniProgramNavigationBackResult = localObject;; paramMiniProgramNavigationBackResult = paramMiniProgramNavigationBackResult.fAw.toString())
    {
      localAppBrandLaunchReferrer.fPH = paramMiniProgramNavigationBackResult;
      this.fyn.fPr.a(localAppBrandLaunchReferrer);
      c(paramAppBrandInitConfig);
      return;
      str = paramMiniProgramNavigationBackResult.fAv.toString();
      break;
    }
  }
  
  protected final void a(i.b paramb)
  {
    this.fyH.add(paramb);
  }
  
  protected void b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 0;
    if (!this.dNk)
    {
      y.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramAppBrandInitConfig });
      return;
    }
    y.d("MicroMsg.AppBrandRuntime", "updateConfig %s", new Object[] { paramAppBrandInitConfig });
    int i = j;
    if (paramAppBrandInitConfig != null)
    {
      if (!this.fyC) {
        break label85;
      }
      this.fyC = false;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.fyA = true;
        y.d("MicroMsg.AppBrandRuntime", "setWillRestart");
      }
      this.fyn = paramAppBrandInitConfig;
      return;
      label85:
      i = j;
      if (paramAppBrandInitConfig.fEL != this.fyn.fEL) {
        i = 1;
      }
    }
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.g> T c(Class<T> paramClass, boolean paramBoolean)
  {
    com.tencent.mm.plugin.appbrand.jsapi.g localg2 = null;
    Iterator localIterator = this.fyu.descendingIterator();
    com.tencent.mm.plugin.appbrand.jsapi.g localg1;
    do
    {
      localg1 = localg2;
      if (!localIterator.hasNext()) {
        break;
      }
      localg1 = (com.tencent.mm.plugin.appbrand.jsapi.g)localIterator.next();
    } while (!paramClass.isInstance(localg1));
    if ((localg1 == null) && (paramBoolean)) {
      try
      {
        localg2 = (com.tencent.mm.plugin.appbrand.jsapi.g)paramClass.newInstance();
        return localg2;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
      }
    }
    return localg1;
  }
  
  protected void c(AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void cleanup()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    y.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", new Object[] { this.mAppId });
    onDestroy();
    AppBrandMainProcessService.b(this.fyJ);
    MMToClientEvent.c(this.fyo);
    g.qv(this.mAppId);
    g.a(this.mAppId, g.a.fxX);
    p.tO(this.mAppId);
    com.tencent.luggage.j.e.af(getContext());
    ??? = this.fyy;
    ??? = ((com.tencent.mm.plugin.appbrand.b.c)???).fFN;
    ((com.tencent.mm.plugin.appbrand.b.d)???).fFV.set(true);
    Object localObject8 = ((com.tencent.mm.sdk.d.d)???).ujd;
    if (localObject8 != null) {
      d.c.f((d.c)localObject8);
    }
    ((com.tencent.mm.plugin.appbrand.b.d)???).a(com.tencent.mm.plugin.appbrand.b.b.fFL);
    synchronized (((com.tencent.mm.plugin.appbrand.b.c)???).fFO)
    {
      ((com.tencent.mm.plugin.appbrand.b.c)???).fFO.clear();
      ??? = f.amG();
      ??? = this.mAppId;
      if (((f)???).goq.containsKey(???)) {
        ((f)???).goq.remove(???);
      }
      ??? = com.tencent.mm.plugin.appbrand.o.c.amD();
      ??? = this.mAppId;
      if (!((com.tencent.mm.plugin.appbrand.o.c)???).goq.containsKey(???)) {
        break label256;
      }
      ??? = (com.tencent.mm.plugin.appbrand.o.b)((com.tencent.mm.plugin.appbrand.o.c)???).goq.remove(???);
      synchronized (((com.tencent.mm.plugin.appbrand.o.b)???).gQN)
      {
        localObject8 = ((com.tencent.mm.plugin.appbrand.o.b)???).gQN.iterator();
        if (((Iterator)localObject8).hasNext()) {
          ((com.tencent.mm.plugin.appbrand.o.a.b)((Iterator)localObject8).next()).isRunning = false;
        }
      }
    }
    localObject5.gQN.clear();
    label256:
    ??? = com.tencent.mm.plugin.appbrand.o.i.amI();
    Object localObject6 = this.mAppId;
    if (((com.tencent.mm.plugin.appbrand.o.i)???).goq.containsKey(localObject6))
    {
      localObject6 = (com.tencent.mm.plugin.appbrand.o.g)((com.tencent.mm.plugin.appbrand.o.i)???).goq.remove(localObject6);
      synchronized (((com.tencent.mm.plugin.appbrand.o.g)localObject6).gRm)
      {
        localObject8 = ((com.tencent.mm.plugin.appbrand.o.g)localObject6).gRm.iterator();
        if (((Iterator)localObject8).hasNext()) {
          ((h)((Iterator)localObject8).next()).isRunning = false;
        }
      }
      localObject7.gRm.clear();
    }
    ??? = l.amK();
    String str = this.mAppId;
    if (((l)???).goq.containsKey(str))
    {
      ??? = (com.tencent.mm.plugin.appbrand.o.k)((l)???).goq.remove(str);
      if (??? != null) {
        ((com.tencent.mm.plugin.appbrand.o.k)???).c(((com.tencent.mm.plugin.appbrand.o.k)???).vB("0"));
      }
    }
    g.qz(this.mAppId);
    if (this.fyo != null) {
      this.fyo.cleanup();
    }
    if (this.fyp != null)
    {
      this.fyp.cleanup();
      this.fyq.removeView(this.fyp);
    }
    this.fyL.clear();
  }
  
  public final void close()
  {
    if (this.fyl.ZW() == 1)
    {
      if (ZG())
      {
        this.fyl.a(null);
        return;
      }
      this.fyl.close();
      return;
    }
    finish();
  }
  
  public final void finish()
  {
    this.fyk.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        i.a(i.this, null);
      }
    });
  }
  
  public final com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    return (com.tencent.mm.plugin.appbrand.config.a)c(com.tencent.mm.plugin.appbrand.config.a.class, true);
  }
  
  public Activity getContext()
  {
    return this.fyk;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  protected void onCreate() {}
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onReady() {}
  
  protected void onResume() {}
  
  protected void reload()
  {
    cleanup();
    a(ZA());
    Zw();
    y.i("MicroMsg.AppBrandRuntime", "reload: %s", new Object[] { this.mAppId });
  }
  
  public final void s(Runnable paramRunnable)
  {
    if (this.dNk)
    {
      this.fyk.runOnUiThread(paramRunnable);
      return;
    }
    this.fyL.offerLast(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i
 * JD-Core Version:    0.7.0.1
 */