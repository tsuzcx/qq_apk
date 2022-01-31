package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.k.a.c;
import com.tencent.mm.plugin.appbrand.luggage.b.m;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.plugin.appbrand.t.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

public class i
  implements com.tencent.mm.vending.e.b
{
  public volatile boolean IR;
  private volatile r gPA;
  volatile com.tencent.mm.plugin.appbrand.page.r gPB;
  public com.tencent.mm.plugin.appbrand.widget.d gPC;
  com.tencent.mm.plugin.appbrand.ui.r gPD;
  public com.tencent.mm.plugin.appbrand.widget.b.e gPE;
  private volatile com.tencent.mm.plugin.appbrand.appstorage.o gPF;
  @TargetApi(21)
  public final ConcurrentLinkedDeque<j> gPG;
  private final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.k> gPH;
  final y gPI;
  private com.tencent.mm.plugin.appbrand.t.d gPJ;
  public com.tencent.mm.plugin.appbrand.page.n gPK;
  public volatile com.tencent.mm.plugin.appbrand.b.c gPL;
  public com.tencent.mm.plugin.appbrand.k.a gPM;
  protected boolean gPN;
  protected boolean gPO;
  public boolean gPP;
  public boolean gPQ;
  public boolean gPR;
  public boolean gPS;
  private final Set<com.tencent.mm.vending.e.a> gPT;
  LinkedList<i.c> gPU;
  private AppBrandMainProcessService.a gPV;
  Runnable gPW;
  final Deque<Runnable> gPX;
  public ad gPw;
  final i.a gPx;
  i gPy;
  public volatile AppBrandInitConfig gPz;
  public volatile String mAppId;
  public Context mContext;
  public volatile boolean mFinished;
  public volatile boolean mInitialized;
  public boolean mResumed;
  
  public i(Context paramContext, ad paramad)
  {
    AppMethodBeat.i(141628);
    this.gPF = null;
    this.gPG = new ConcurrentLinkedDeque();
    this.gPH = new LinkedHashSet();
    this.gPI = new y();
    this.mResumed = false;
    this.gPQ = false;
    this.gPR = true;
    this.gPS = false;
    this.gPT = new CopyOnWriteArraySet();
    this.gPU = new LinkedList();
    this.gPV = new i.3(this);
    this.gPW = new i.4(this);
    this.gPX = new LinkedBlockingDeque();
    this.mContext = paramContext;
    this.gPw = paramad;
    this.gPx = new i.a(this);
    this.gPC = new com.tencent.mm.plugin.appbrand.widget.d(paramContext);
    this.gPC.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.gPE = new com.tencent.mm.plugin.appbrand.widget.b.e(paramContext);
    this.gPC.addView(this.gPE);
    this.gPJ = new com.tencent.mm.plugin.appbrand.t.d();
    this.gPK = new com.tencent.mm.plugin.appbrand.page.n();
    AppMethodBeat.o(141628);
  }
  
  public final void A(Runnable paramRunnable)
  {
    AppMethodBeat.i(156862);
    k(paramRunnable, 0L);
    AppMethodBeat.o(156862);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T E(Class<T> paramClass)
  {
    AppMethodBeat.i(86687);
    paramClass = this.gPI.O(paramClass);
    AppMethodBeat.o(86687);
    return paramClass;
  }
  
  public final <T extends j> T U(Class<T> paramClass)
  {
    AppMethodBeat.i(86684);
    if (!this.gPS) {}
    for (boolean bool = true;; bool = false)
    {
      paramClass = d(paramClass, bool);
      AppMethodBeat.o(86684);
      return paramClass;
    }
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.k> T V(Class<T> paramClass)
  {
    AppMethodBeat.i(86685);
    if (paramClass == null)
    {
      AppMethodBeat.o(86685);
      return null;
    }
    synchronized (this.gPH)
    {
      Iterator localIterator = this.gPH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.k localk = (com.tencent.mm.plugin.appbrand.jsapi.k)localIterator.next();
        if (paramClass.isInstance(localk))
        {
          AppMethodBeat.o(86685);
          return localk;
        }
      }
      AppMethodBeat.o(86685);
      return null;
    }
  }
  
  public final void a(final MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    AppMethodBeat.i(86699);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(86652);
        if ((!i.this.mInitialized) || (i.this.mFinished))
        {
          i.this.gPw.h(i.this);
          AppMethodBeat.o(86652);
          return;
        }
        i.this.gPw.a(i.this, paramMiniProgramNavigationBackResult);
        AppMethodBeat.o(86652);
      }
    }, 0L);
    AppMethodBeat.o(86699);
  }
  
  public void a(ad paramad)
  {
    this.gPw = paramad;
  }
  
  protected void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(86673);
    this.gPz = paramAppBrandInitConfig;
    AppMethodBeat.o(86673);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    Object localObject = null;
    AppMethodBeat.i(86696);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramAppBrandInitConfig.appId;
    localAppBrandLaunchReferrer.hiK = 3;
    String str;
    if (paramMiniProgramNavigationBackResult == null)
    {
      str = null;
      localAppBrandLaunchReferrer.cAh = str;
      if (paramMiniProgramNavigationBackResult != null) {
        break label93;
      }
    }
    label93:
    for (paramMiniProgramNavigationBackResult = localObject;; paramMiniProgramNavigationBackResult = paramMiniProgramNavigationBackResult.gSf.toString())
    {
      localAppBrandLaunchReferrer.hiL = paramMiniProgramNavigationBackResult;
      this.gPz.hiz.a(localAppBrandLaunchReferrer);
      c(paramAppBrandInitConfig);
      AppMethodBeat.o(86696);
      return;
      str = paramMiniProgramNavigationBackResult.gSe.toString();
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.config.a parama)
  {
    AppMethodBeat.i(86677);
    this.gPG.add(parama);
    AppMethodBeat.o(86677);
  }
  
  protected final void a(i.c paramc)
  {
    AppMethodBeat.i(86672);
    this.gPU.add(paramc);
    AppMethodBeat.o(86672);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(86686);
    if (paramk == null)
    {
      AppMethodBeat.o(86686);
      return false;
    }
    synchronized (this.gPH)
    {
      this.gPH.add(paramk);
      AppMethodBeat.o(86686);
      return true;
    }
  }
  
  public final void atA()
  {
    AppMethodBeat.i(86702);
    this.gPL.gYj.a(d.a.gYF);
    AppMethodBeat.o(86702);
  }
  
  @TargetApi(21)
  protected void atB()
  {
    AppMethodBeat.i(86703);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(86703);
      return;
    }
    Activity localActivity = getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(86703);
      return;
    }
    if (getAppConfig() == null) {}
    int i;
    for (ActivityManager.TaskDescription localTaskDescription = new ActivityManager.TaskDescription(wZ().cqQ);; localTaskDescription = new ActivityManager.TaskDescription(wZ().cqQ, null, i))
    {
      localActivity.setTaskDescription(localTaskDescription);
      com.tencent.mm.modelappbrand.a.b.acD().a(new i.5(this, localActivity, localTaskDescription), wZ().iconUrl, com.tencent.mm.modelappbrand.a.f.fqU);
      AppMethodBeat.o(86703);
      return;
      i = v.by(getAppConfig().hgL.hhp, -16777216);
    }
  }
  
  public boolean atC()
  {
    AppMethodBeat.i(86704);
    if (this.gPL.gYj.awr() == com.tencent.mm.plugin.appbrand.b.b.gYg) {}
    for (int i = 1; i != 0; i = 0)
    {
      cleanup();
      AppMethodBeat.o(86704);
      return true;
    }
    AppMethodBeat.o(86704);
    return false;
  }
  
  public final void atg()
  {
    AppMethodBeat.i(86671);
    this.mResumed = true;
    if (this.gPD != null) {
      atn();
    }
    Object localObject1 = atm();
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.appbrand.ui.r)localObject1).getView();
      this.gPC.addView((View)localObject2, -1, -1);
      this.gPD = ((com.tencent.mm.plugin.appbrand.ui.r)localObject1);
      ((View)localObject2).setClickable(true);
      this.gPC.setOnHierarchyChangeListener(new i.8(this, (View)localObject2));
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", new Object[] { this.gPz.cqQ, this.gPz.appId });
    AppBrandMainProcessService.a(this.gPV);
    n.xZ(this.mAppId);
    b(com.tencent.mm.plugin.appbrand.jsapi.base.f.class, new z());
    b(com.tencent.mm.plugin.appbrand.networking.b.class, new com.tencent.mm.plugin.appbrand.networking.d(this));
    b(com.tencent.mm.plugin.appbrand.widget.h.class, com.tencent.mm.plugin.appbrand.widget.h.jaB);
    b(com.tencent.mm.plugin.appbrand.e.b.class, new m(this));
    b(com.tencent.mm.plugin.appbrand.e.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.k(this));
    onCreate();
    this.gPL.gYj.a(d.a.gYB);
    e.xW(this.mAppId);
    e.xP(this.mAppId);
    e.a(this.mAppId, e.b.gOY);
    atB();
    Object localObject2 = new i.d(this, (byte)0);
    if (this.gPD == null) {}
    for (localObject1 = this.gPC;; localObject1 = this.gPD.getView())
    {
      ((View)localObject1).getViewTreeObserver().addOnPreDrawListener(new i.6(this, (View)localObject1, (i.d)localObject2));
      k(this.gPW, 10000L);
      AppMethodBeat.o(86671);
      return;
    }
  }
  
  public final int ath()
  {
    return this.gPz.gXd;
  }
  
  public final i ati()
  {
    AppMethodBeat.i(86674);
    i locali = this.gPw.f(this);
    AppMethodBeat.o(86674);
    return locali;
  }
  
  public com.tencent.mm.plugin.appbrand.page.r atj()
  {
    return this.gPB;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.c atk()
  {
    return this.gPL;
  }
  
  public final void atl()
  {
    AppMethodBeat.i(86679);
    if (this.gPF == null) {
      this.gPF = wQ();
    }
    AppMethodBeat.o(86679);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.r atm()
  {
    return null;
  }
  
  public final void atn()
  {
    AppMethodBeat.i(86681);
    if (this.mFinished)
    {
      this.gPD = null;
      AppMethodBeat.o(86681);
      return;
    }
    if (this.gPD == null)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
      AppMethodBeat.o(86681);
      return;
    }
    this.gPD.aHA();
    this.gPD = null;
    AppMethodBeat.o(86681);
  }
  
  public final String ato()
  {
    AppMethodBeat.i(86682);
    if (this.gPz == null)
    {
      AppMethodBeat.o(86682);
      return "";
    }
    if (bo.isNullOrNil(this.gPz.hiw))
    {
      if (getAppConfig() == null)
      {
        AppMethodBeat.o(86682);
        return "";
      }
      str = getAppConfig().ayn();
      AppMethodBeat.o(86682);
      return str;
    }
    String str = this.gPz.hiw;
    AppMethodBeat.o(86682);
    return str;
  }
  
  public final boolean atp()
  {
    return this.mInitialized;
  }
  
  protected void atq() {}
  
  protected void atr() {}
  
  protected r ats()
  {
    AppMethodBeat.i(86690);
    r localr = new r();
    AppMethodBeat.o(86690);
    return localr;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.r att()
  {
    AppMethodBeat.i(86691);
    com.tencent.mm.plugin.appbrand.page.r localr = new com.tencent.mm.plugin.appbrand.page.r(getContext(), this);
    AppMethodBeat.o(86691);
    return localr;
  }
  
  public boolean atu()
  {
    return false;
  }
  
  public final void atv()
  {
    AppMethodBeat.i(86692);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(86692);
      return;
    }
    if (this.mFinished)
    {
      AppMethodBeat.o(86692);
      return;
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[] { this.mAppId });
    this.mResumed = false;
    onPause();
    this.gPL.gYj.a(d.a.gYA);
    this.gPA.vc();
    this.gPB.onBackground();
    e.xR(this.mAppId);
    e.a(this.mAppId, e.b.gPa);
    ab.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
    try
    {
      bc.a(ah.getContext(), null);
      AppMethodBeat.o(86692);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] pause set null callback", new Object[0]);
      AppMethodBeat.o(86692);
    }
  }
  
  final void atw()
  {
    AppMethodBeat.i(86693);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(86693);
      return;
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[] { this.mAppId });
    if ((this.mFinished) || (this.gPN))
    {
      f(null);
      AppMethodBeat.o(86693);
      return;
    }
    this.mResumed = true;
    e.xW(this.mAppId);
    e.xS(this.mAppId);
    e.a(this.mAppId, e.b.gOZ);
    onResume();
    this.gPB.onForeground();
    this.gPL.gYj.a(d.a.gYB);
    boolean bool = this.gPO;
    this.gPA.be(bool);
    if (bool) {
      this.gPB.aq(ato(), true);
    }
    com.tencent.mm.plugin.appbrand.t.d locald = this.gPJ;
    ab.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
    try
    {
      bc.a(ah.getContext(), locald.iXx);
      atB();
      this.gPN = false;
      this.gPO = false;
      AppMethodBeat.o(86693);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", localSecurityException, "[NOT CRASH] resume set callback", new Object[0]);
      }
    }
  }
  
  protected void atx() {}
  
  protected final void aty()
  {
    AppMethodBeat.i(86700);
    this.gPN = true;
    com.tencent.luggage.g.d.d("MicroMsg.AppBrandRuntime", "setWillRestart");
    AppMethodBeat.o(86700);
  }
  
  public final boolean atz()
  {
    AppMethodBeat.i(86701);
    if (!this.gPR)
    {
      AppMethodBeat.o(86701);
      return false;
    }
    Activity localActivity = getContext();
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      AppMethodBeat.o(86701);
      return false;
    }
    if ((this.gPB != null) && (this.gPB.getCurrentPage() != null) && (!this.gPB.getCurrentPage().mSwiping))
    {
      AppMethodBeat.o(86701);
      return true;
    }
    AppMethodBeat.o(86701);
    return false;
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(86688);
    this.gPI.b(paramClass, paramN);
    AppMethodBeat.o(86688);
  }
  
  protected void c(AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void cleanup()
  {
    AppMethodBeat.i(86694);
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "dl: cleanup, finished?[%b] initialized?[%b]", new Object[] { Boolean.valueOf(this.mFinished), Boolean.valueOf(this.mInitialized) });
    if (this.mFinished)
    {
      AppMethodBeat.o(86694);
      return;
    }
    this.mFinished = true;
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", new Object[] { this.mAppId });
    onDestroy();
    ??? = this.gPT.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)???).next()).dead();
    }
    this.gPT.clear();
    this.gPF = null;
    AppBrandMainProcessService.b(this.gPV);
    MMToClientEvent.f(this.gPA);
    e.xQ(this.mAppId);
    e.a(this.mAppId, e.b.gPc);
    com.tencent.luggage.g.f.av(getContext());
    Object localObject2 = this.gPL;
    ((com.tencent.mm.plugin.appbrand.b.c)localObject2).gYj.stop();
    Iterator localIterator;
    synchronized (((com.tencent.mm.plugin.appbrand.b.c)localObject2).gYk)
    {
      ((com.tencent.mm.plugin.appbrand.b.c)localObject2).gYk.clear();
      ??? = com.tencent.mm.plugin.appbrand.m.f.aIk();
      localObject2 = this.mAppId;
      if (((com.tencent.mm.plugin.appbrand.m.f)???).hIm.containsKey(localObject2)) {
        ((com.tencent.mm.plugin.appbrand.m.f)???).hIm.remove(localObject2);
      }
      ??? = com.tencent.mm.plugin.appbrand.m.c.aIh();
      localObject2 = this.mAppId;
      if (!((com.tencent.mm.plugin.appbrand.m.c)???).hIm.containsKey(localObject2)) {
        break label331;
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.m.b)((com.tencent.mm.plugin.appbrand.m.c)???).hIm.remove(localObject2);
      synchronized (((com.tencent.mm.plugin.appbrand.m.b)localObject2).isC)
      {
        localIterator = ((com.tencent.mm.plugin.appbrand.m.b)localObject2).isC.iterator();
        if (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.appbrand.m.a.b)localIterator.next()).isRunning = false;
        }
      }
    }
    localObject4.isC.clear();
    label331:
    ??? = com.tencent.mm.plugin.appbrand.m.i.aIm();
    Object localObject5 = this.mAppId;
    if (((com.tencent.mm.plugin.appbrand.m.i)???).hIm.containsKey(localObject5))
    {
      localObject5 = (g)((com.tencent.mm.plugin.appbrand.m.i)???).hIm.remove(localObject5);
      synchronized (((g)localObject5).itb)
      {
        localIterator = ((g)localObject5).itb.iterator();
        if (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.appbrand.m.h)localIterator.next()).isRunning = false;
        }
      }
      localObject6.itb.clear();
    }
    ??? = l.aIp();
    String str = this.mAppId;
    if (((l)???).hIm.containsKey(str))
    {
      ??? = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d)((l)???).hIm.remove(str);
      if (??? != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)???).release();
      }
    }
    e.xV(this.mAppId);
    if (this.mInitialized)
    {
      this.gPA.cleanup();
      this.gPB.cleanup();
    }
    this.gPC.removeAllViews();
    this.gPC.setOnHierarchyChangeListener(null);
    this.gPG.clear();
    synchronized (this.gPH)
    {
      this.gPH.clear();
      this.gPI.unregisterAll();
      this.gPX.clear();
      this.gPx.removeCallbacksAndMessages(null);
      AppMethodBeat.o(86694);
      return;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(86698);
    com.tencent.luggage.g.f.av(getContext());
    a(null);
    AppMethodBeat.o(86698);
  }
  
  /* Error */
  public final <T extends j> T d(Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 953
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 104	com/tencent/mm/plugin/appbrand/i:gPG	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   13: invokevirtual 956	java/util/concurrent/ConcurrentLinkedDeque:descendingIterator	()Ljava/util/Iterator;
    //   16: astore 5
    //   18: aload 4
    //   20: astore_3
    //   21: aload 5
    //   23: invokeinterface 370 1 0
    //   28: ifeq +22 -> 50
    //   31: aload 5
    //   33: invokeinterface 374 1 0
    //   38: checkcast 958	com/tencent/mm/plugin/appbrand/jsapi/j
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 382	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   47: ifeq -29 -> 18
    //   50: aload_3
    //   51: ifnonnull +85 -> 136
    //   54: iload_2
    //   55: ifeq +81 -> 136
    //   58: aload_1
    //   59: invokestatic 964	org/a/a:ba	(Ljava/lang/Class;)Lorg/a/a;
    //   62: invokevirtual 968	org/a/a:erv	()Lorg/a/a;
    //   65: getfield 972	org/a/a:object	Ljava/lang/Object;
    //   68: checkcast 958	com/tencent/mm/plugin/appbrand/jsapi/j
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: getfield 104	com/tencent/mm/plugin/appbrand/i:gPG	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   85: aload 4
    //   87: invokeinterface 441 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: ldc_w 953
    //   99: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore 4
    //   106: ldc_w 306
    //   109: ldc_w 974
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 977	java/lang/Class:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 979	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -30 -> 96
    //   129: astore_3
    //   130: aload 4
    //   132: astore_3
    //   133: goto -27 -> 106
    //   136: goto -40 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	i
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
  
  protected final void d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(86670);
    if (paramAppBrandInitConfig == null)
    {
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
      AppMethodBeat.o(86670);
      return;
    }
    this.gPz = paramAppBrandInitConfig;
    this.mAppId = paramAppBrandInitConfig.appId;
    this.gPL = new com.tencent.mm.plugin.appbrand.b.c(this);
    this.gPL.gYj.start();
    this.gPL.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(86651);
        i locali = i.this;
        HashMap localHashMap = new HashMap();
        switch (com.tencent.mm.plugin.appbrand.page.k.1.gYx[paramAnonymousb.ordinal()])
        {
        default: 
          AppMethodBeat.o(86651);
          return;
        case 1: 
          paramAnonymousString = "background";
        }
        for (;;)
        {
          localHashMap.put("status", paramAnonymousString);
          new com.tencent.mm.plugin.appbrand.page.k().w(localHashMap).i(locali.ws()).aBz();
          AppMethodBeat.o(86651);
          return;
          paramAnonymousString = "active";
          continue;
          paramAnonymousString = "suspend";
        }
      }
    });
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "init %s, config %s", new Object[] { this.mAppId, this.gPz });
    this.mInitialized = false;
    this.mFinished = false;
    this.IR = false;
    this.gPN = false;
    this.gPO = false;
    this.gPP = false;
    AppMethodBeat.o(86670);
  }
  
  protected final void e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    int j = 1;
    AppMethodBeat.i(141629);
    if (!this.mInitialized)
    {
      com.tencent.luggage.g.d.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramAppBrandInitConfig });
      if ((!this.mFinished) && (!this.IR))
      {
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { this.mAppId });
        this.gPz = paramAppBrandInitConfig;
        f(null);
      }
      AppMethodBeat.o(141629);
      return;
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig });
    int i;
    if (paramAppBrandInitConfig != null) {
      if (this.gPP)
      {
        this.gPP = false;
        i = j;
      }
    }
    for (;;)
    {
      if (i != 0) {
        aty();
      }
      a(paramAppBrandInitConfig);
      AppMethodBeat.o(141629);
      return;
      i = j;
      if (paramAppBrandInitConfig.gXd == this.gPz.gXd)
      {
        i = j;
        if (paramAppBrandInitConfig.hiA == this.gPz.hiA) {
          i = 0;
        }
      }
    }
  }
  
  protected void f(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(138229);
    cleanup();
    if (paramAppBrandInitConfig != null) {}
    for (;;)
    {
      d(paramAppBrandInitConfig);
      atg();
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntime", "reload: %s", new Object[] { this.mAppId });
      AppMethodBeat.o(138229);
      return;
      paramAppBrandInitConfig = wZ();
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(141633);
    super.finalize();
    this.gPx.removeCallbacksAndMessages(null);
    AppMethodBeat.o(141633);
  }
  
  public void finish()
  {
    AppMethodBeat.i(86695);
    this.IR = true;
    com.tencent.luggage.g.f.av(getContext());
    k(new i.13(this), 0L);
    AppMethodBeat.o(86695);
  }
  
  public final boolean finished()
  {
    return this.mFinished;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    AppMethodBeat.i(86676);
    com.tencent.mm.plugin.appbrand.config.a locala = (com.tencent.mm.plugin.appbrand.config.a)d(com.tencent.mm.plugin.appbrand.config.a.class, false);
    AppMethodBeat.o(86676);
    return locala;
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public Activity getContext()
  {
    AppMethodBeat.i(141630);
    Activity localActivity = com.tencent.mm.sdk.f.a.hr(this.mContext);
    AppMethodBeat.o(141630);
    return localActivity;
  }
  
  public final boolean isFinishing()
  {
    return this.IR;
  }
  
  public final boolean isInBackStack()
  {
    AppMethodBeat.i(154658);
    if ((this.gPw != null) && (this.gPw.g(this)))
    {
      AppMethodBeat.o(154658);
      return true;
    }
    AppMethodBeat.o(154658);
    return false;
  }
  
  public final boolean isResumed()
  {
    return this.mResumed;
  }
  
  public final void k(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(141636);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(141636);
      return;
    }
    if (this.mFinished)
    {
      AppMethodBeat.o(141636);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    if ((al.isMainThread()) && (0L == l))
    {
      paramRunnable.run();
      AppMethodBeat.o(141636);
      return;
    }
    paramRunnable = com.tencent.mm.plugin.appbrand.t.p.M(paramRunnable);
    keep(paramRunnable);
    this.gPx.sendMessageDelayed(this.gPx.obtainMessage(1, paramRunnable), l);
    AppMethodBeat.o(141636);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(86669);
    if (parama != null) {
      this.gPT.add(parama);
    }
    AppMethodBeat.o(86669);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {}
  
  protected void onCreate()
  {
    AppMethodBeat.i(141631);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    AppMethodBeat.o(141631);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(141632);
    com.tencent.mm.plugin.appbrand.media.a.a.BP(this.mAppId);
    AppMethodBeat.o(141632);
  }
  
  protected void onPause() {}
  
  protected void onReady() {}
  
  protected void onResume() {}
  
  protected com.tencent.mm.plugin.appbrand.appstorage.o wQ()
  {
    AppMethodBeat.i(86680);
    t localt = new t(this);
    AppMethodBeat.o(86680);
    return localt;
  }
  
  protected void wT() {}
  
  protected com.tencent.mm.plugin.appbrand.k.a wW()
  {
    AppMethodBeat.i(86678);
    a.c localc = new a.c();
    AppMethodBeat.o(86678);
    return localc;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.o wX()
  {
    return this.gPF;
  }
  
  public com.tencent.mm.plugin.appbrand.config.h wY()
  {
    AppMethodBeat.i(86675);
    com.tencent.mm.plugin.appbrand.config.h localh = (com.tencent.mm.plugin.appbrand.config.h)U(com.tencent.mm.plugin.appbrand.config.h.class);
    AppMethodBeat.o(86675);
    return localh;
  }
  
  public AppBrandInitConfig wZ()
  {
    return this.gPz;
  }
  
  public r ws()
  {
    return this.gPA;
  }
  
  public final void z(Runnable paramRunnable)
  {
    AppMethodBeat.i(141634);
    if ((this.IR) || (this.mFinished))
    {
      com.tencent.luggage.g.d.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(141634);
      return;
    }
    if (this.mInitialized)
    {
      k(paramRunnable, 0L);
      AppMethodBeat.o(141634);
      return;
    }
    this.gPX.offerLast(paramRunnable);
    AppMethodBeat.o(141634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i
 * JD-Core Version:    0.7.0.1
 */