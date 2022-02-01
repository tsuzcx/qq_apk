package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.a.c;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import junit.framework.AssertionFailedError;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime>
  extends o
  implements ai
{
  private Application.ActivityLifecycleCallbacks cEA;
  public final LinkedList<RUNTIME> jyh;
  public final HashMap<String, RUNTIME> jyi;
  public final com.tencent.mm.plugin.appbrand.task.g jyj;
  private Class<? extends RUNTIME> jyk;
  private boolean jyl;
  protected boolean jym;
  public n jyn;
  private v jyo;
  public FrameLayout mContentView;
  
  public AppBrandRuntimeContainer(final com.tencent.mm.plugin.appbrand.task.g paramg, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.jyl = false;
    this.jym = false;
    super.aw(paramg.getContext());
    this.jyh = new LinkedList();
    this.jyi = new HashMap();
    this.mContentView = paramg.byJ();
    this.jyj = paramg;
    this.jyk = paramClass;
    this.jyo = new v(paramg.getContext())
    {
      public final boolean aWG()
      {
        AppMethodBeat.i(197195);
        boolean bool = AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this);
        AppMethodBeat.o(197195);
        return bool;
      }
      
      public final boolean aWH()
      {
        AppMethodBeat.i(197196);
        boolean bool = AppBrandRuntimeContainer.this.aWN();
        AppMethodBeat.o(197196);
        return bool;
      }
      
      public final void aWI()
      {
        AppMethodBeat.i(197197);
        AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this);
        AppMethodBeat.o(197197);
      }
      
      public final ViewGroup aWJ()
      {
        AppMethodBeat.i(197201);
        ViewGroup localViewGroup = AppBrandRuntimeContainer.E(AppBrandRuntimeContainer.this.getActiveRuntime());
        AppMethodBeat.o(197201);
        return localViewGroup;
      }
      
      public final Activity getActivity()
      {
        AppMethodBeat.i(197199);
        Activity localActivity = paramg.getActivity();
        AppMethodBeat.o(197199);
        return localActivity;
      }
      
      public final int getBgColor()
      {
        AppMethodBeat.i(197198);
        int i = AppBrandRuntimeContainer.this.getWindowColor();
        AppMethodBeat.o(197198);
        return i;
      }
      
      public final AppBrandRuntime getRuntime()
      {
        AppMethodBeat.i(197200);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
        AppMethodBeat.o(197200);
        return localAppBrandRuntime;
      }
    };
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(197202);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this).isShown()) && (t.aC(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = com.tencent.mm.sdk.f.a.jq(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = ao.abX(((Activity)localObject).getWindow().getNavigationBarColor());
            localObject = ((Activity)localObject).getWindow();
            if (!bool) {}
            for (paramAnonymousInt = 1; (localObject == null) || (((Window)localObject).getDecorView() == null); paramAnonymousInt = 0)
            {
              AppMethodBeat.o(197202);
              return;
            }
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject = ((Window)localObject).getDecorView();
              i = ((View)localObject).getSystemUiVisibility();
              if (paramAnonymousInt == 0) {
                break label170;
              }
            }
          }
        }
        label170:
        for (paramAnonymousInt = i | 0x10;; paramAnonymousInt = i & 0xFFFFFFEF)
        {
          ((View)localObject).setSystemUiVisibility(paramAnonymousInt);
          AppMethodBeat.o(197202);
          return;
        }
      }
    });
    paramg = com.tencent.mm.plugin.appbrand.r.a.a.g.C(com.tencent.mm.sdk.f.a.jq(this.mContext));
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramg.mFinished = false;
      paramg = (Application)getContext().getApplicationContext();
      paramClass = new com.tencent.mm.plugin.appbrand.z.a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(197205);
          if (com.tencent.mm.sdk.f.a.jq(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ad.i("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this);
          }
          AppMethodBeat.o(197205);
        }
        
        public final void onActivityPaused(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(197204);
          if (com.tencent.mm.sdk.f.a.jq(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ad.i("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.this.aWF().onPause();
          }
          AppMethodBeat.o(197204);
        }
        
        public final void onActivityResumed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(197203);
          if (com.tencent.mm.sdk.f.a.jq(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ad.i("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.this.aWF().onResume();
          }
          AppMethodBeat.o(197203);
        }
      };
      this.cEA = paramClass;
      paramg.registerActivityLifecycleCallbacks(paramClass);
      AppMethodBeat.o(134545);
      return;
    }
    finally
    {
      AppMethodBeat.o(134545);
    }
  }
  
  private void A(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134561);
    this.jyh.remove(paramRUNTIME);
    this.jyh.push(paramRUNTIME);
    paramRUNTIME.jwJ.setVisibility(0);
    g(D(paramRUNTIME));
    AppMethodBeat.o(134561);
  }
  
  private void B(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134562);
    if (this.jyh.contains(paramRUNTIME))
    {
      AppMethodBeat.o(134562);
      return;
    }
    this.jyh.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.jwJ) == -1) {
      a(paramRUNTIME.jwJ);
    }
    this.jyi.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(134562);
  }
  
  private static ViewGroup D(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197209);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(197209);
      return null;
    }
    paramAppBrandRuntime = (ViewGroup)paramAppBrandRuntime.jwJ.getParent();
    AppMethodBeat.o(197209);
    return paramAppBrandRuntime;
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((aWE()) && (aWD())) {
      i -= 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandRuntimeContainer", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramd.getTag(), Integer.valueOf(i) });
      if (paramd.getParent() != null) {
        ((ViewGroup)paramd.getParent()).removeAllViews();
      }
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView(paramd);
      this.mContentView.addView(localFrameLayout, i);
      this.jyo.aWL();
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(178508);
          boolean bool = false;
          if (AppBrandRuntimeContainer.h(AppBrandRuntimeContainer.this) != null) {
            bool = AppBrandRuntimeContainer.h(AppBrandRuntimeContainer.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(178508);
          return bool;
        }
      });
      AppMethodBeat.o(178511);
      return;
      i = 0;
    }
  }
  
  private boolean aWD()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.jyn != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean aWE()
  {
    return this.jyn != null;
  }
  
  private void aWz()
  {
    AppMethodBeat.i(177591);
    if (this.cEA != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.cEA);
      this.cEA = null;
    }
    aWF().release();
    AppMethodBeat.o(177591);
  }
  
  private void fz(boolean paramBoolean)
  {
    AppMethodBeat.i(197214);
    if (paramBoolean)
    {
      if ((this.mpM != null) && (!(this.mpM instanceof com.tencent.mm.plugin.appbrand.r.a.b.a.a)))
      {
        this.mpM.release();
        this.mpM = null;
        AppMethodBeat.o(197214);
      }
    }
    else if ((this.mpM != null) && ((this.mpM instanceof com.tencent.mm.plugin.appbrand.r.a.b.a.a)))
    {
      this.mpM.release();
      this.mpM = null;
    }
    AppMethodBeat.o(197214);
  }
  
  private void g(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(197210);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      ad.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(197210);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (aWE()) {
      this.mContentView.bringChildToFront(this.jyn);
    }
    this.jyo.aWL();
    AppMethodBeat.o(197210);
  }
  
  public final void C(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.jyh.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  public final RUNTIME KA(String paramString)
  {
    AppMethodBeat.i(197208);
    Iterator localIterator = this.jyh.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(197208);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.jyi.get(paramString);
    AppMethodBeat.o(197208);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d a(d.b paramb)
  {
    AppMethodBeat.i(197212);
    if (aWN())
    {
      paramb = new as(this, paramb, com.tencent.mm.sdk.f.a.jq(this.mContext));
      AppMethodBeat.o(197212);
      return paramb;
    }
    paramb = super.a(paramb);
    AppMethodBeat.o(197212);
    return paramb;
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.jwF = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.jyh.push(paramRUNTIME2);
    a(paramRUNTIME2.jwJ);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aVJ();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(197207);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(197207);
      return;
    }
    com.tencent.mm.sdk.f.a.jq(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134539);
        n.I(com.tencent.mm.sdk.f.a.jq(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.aWB();
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.KA(paramAppBrandInitConfig.appId);
        if (localAppBrandRuntime == null)
        {
          localAppBrandRuntime = AppBrandRuntimeContainer.this.e(paramAppBrandInitConfig);
          AppBrandRuntimeContainer.this.a(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
          AppMethodBeat.o(134539);
          return;
        }
        AppBrandRuntimeContainer.this.b(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
        AppMethodBeat.o(134539);
      }
    });
    AppMethodBeat.o(197207);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(176531);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    localActivity.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134540);
        if (!AppBrandRuntimeContainer.this.z(paramAppBrandRuntime))
        {
          ad.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134540);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.w(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Fi(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          ad.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this)) });
          AppBrandRuntimeContainer.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197206);
              AppBrandRuntimeContainer.8.this.jyv.jwJ.setVisibility(8);
              AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.8.this.jyv);
              AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.8.this.jyv.mAppId, AppBrandRuntimeContainer.8.this.jyv);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.8.this.jyv.dispatchPause();
              if ((AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.8.this.jyv.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ad.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this)) });
                AppMethodBeat.o(197206);
                return;
              }
            }
          });
          AppMethodBeat.o(134540);
          return;
        }
      }
    });
    AppMethodBeat.o(176531);
  }
  
  public final boolean aWA()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.jyj.aWA();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  public final void aWB()
  {
    AppMethodBeat.i(134563);
    Iterator localIterator = this.jyh.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      localAppBrandRuntime.jwJ.setVisibility(8);
      this.jyi.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
      localAppBrandRuntime.aWj();
      if (localAppBrandRuntime.mResumed) {
        localAppBrandRuntime.dispatchPause();
      }
    }
    this.jyh.clear();
    AppMethodBeat.o(134563);
  }
  
  protected final LinkedList<RUNTIME> aWC()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.jyh);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public final c aWF()
  {
    AppMethodBeat.i(197213);
    if (aWN())
    {
      fz(true);
      if (this.mpM != null) {}
    }
    for (this.mpM = new com.tencent.mm.plugin.appbrand.r.a.b.a.a(this);; this.mpM = new com.tencent.mm.plugin.appbrand.r.a.a.d(this))
    {
      c localc = this.mpM;
      AppMethodBeat.o(197213);
      return localc;
      fz(false);
      if ((this.mpM != null) && ((this.mpM instanceof com.tencent.mm.plugin.appbrand.r.a.a.d)) && (((com.tencent.mm.plugin.appbrand.r.a.a.d)this.mpM).activity != com.tencent.mm.sdk.f.a.jq(this.mContext))) {
        this.mpM.release();
      }
    }
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    B(paramRUNTIME2);
    A(paramRUNTIME2);
    paramRUNTIME2.jwF = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.dispatchPause();
      paramRUNTIME2.dispatchResume();
    }
    AppMethodBeat.o(134548);
  }
  
  public void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(134550);
    if (paramAppBrandRuntime1 == null) {}
    for (paramAppBrandRuntime1 = "null";; paramAppBrandRuntime1 = paramAppBrandRuntime1.mAppId)
    {
      ad.i("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { paramAppBrandRuntime1, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      AppMethodBeat.o(134550);
      return;
    }
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(134559);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.jyh);
    ((LinkedList)localObject).addAll(this.jyi.values());
    aWB();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.jwZ = false;
      y(localAppBrandRuntime);
    }
    ad.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    aWz();
    AppMethodBeat.o(134559);
  }
  
  public RUNTIME e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.bF(this.jyk).aj(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.jyh.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.jyh.size();
    AppMethodBeat.o(185921);
    return i;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(178516);
    DisplayMetrics localDisplayMetrics2 = super.getVDisplayMetrics();
    DisplayMetrics localDisplayMetrics1;
    if ((aWN()) || (this.jyo.jAy)) {
      localDisplayMetrics1 = this.jyo.getVDisplayMetrics();
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandRuntimeContainer", "getVDisplayMetrics: [%d,%d, %b]", new Object[] { Integer.valueOf(localDisplayMetrics1.widthPixels), Integer.valueOf(localDisplayMetrics1.heightPixels), Boolean.valueOf(aWN()) });
      this.jyo.jAx = localDisplayMetrics1.heightPixels;
      this.jyo.jAw = localDisplayMetrics1.widthPixels;
      AppMethodBeat.o(178516);
      return localDisplayMetrics1;
      localDisplayMetrics1 = localDisplayMetrics2;
      if (this.mContentView.isLaidOut())
      {
        localDisplayMetrics2.widthPixels = this.mContentView.getMeasuredWidth();
        localDisplayMetrics2.heightPixels = this.mContentView.getMeasuredHeight();
        localDisplayMetrics1 = localDisplayMetrics2;
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(134556);
    AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
    if (localAppBrandRuntime != null) {
      try
      {
        localAppBrandRuntime.onBackPressed();
        AppMethodBeat.o(134556);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", new Object[] { localException });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134543);
            Exception localException = localException;
            AppMethodBeat.o(134543);
            throw localException;
          }
        });
      }
    }
    AppMethodBeat.o(134556);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(134557);
    Object localObject = this.jyo;
    p.h(paramConfiguration, "newConfig");
    if ((((v)localObject).gNO != paramConfiguration.orientation) && (p.i(((v)localObject).jAC, "auto")) && (((v)localObject).aWH()) && (!((v)localObject).aWG())) {
      ((v)localObject).jAB = v.rF(paramConfiguration.orientation);
    }
    if ((((v)localObject).gNO != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != ((v)localObject).jAu) || (paramConfiguration.screenWidthDp != ((v)localObject).jAv)) {
      if (((paramConfiguration.screenHeightDp == ((v)localObject).jAu) && (paramConfiguration.screenWidthDp == ((v)localObject).jAv)) || (((v)localObject).gNO != paramConfiguration.orientation)) {
        break label316;
      }
    }
    label316:
    for (boolean bool = true;; bool = false)
    {
      ((v)localObject).jAy = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        if ((((v)localObject).getActivity().isInMultiWindowMode()) || (((v)localObject).jAz)) {
          ((v)localObject).jAy = false;
        }
        ((v)localObject).jAz = ((v)localObject).getActivity().isInMultiWindowMode();
      }
      ((v)localObject).aXH();
      if (((v)localObject).getRuntime() != null)
      {
        if ((((v)localObject).jAy) && ((paramConfiguration.screenHeightDp != ((v)localObject).jAu) || (paramConfiguration.screenWidthDp != ((v)localObject).jAv))) {
          ((v)localObject).aWI();
        }
        ViewGroup localViewGroup = ((v)localObject).aWJ();
        if (localViewGroup != null) {
          localViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)new v.d((v)localObject));
        }
      }
      ((v)localObject).gNO = paramConfiguration.orientation;
      ((v)localObject).jAu = paramConfiguration.screenHeightDp;
      ((v)localObject).jAv = paramConfiguration.screenWidthDp;
      if (this.jyh == null) {
        break;
      }
      localObject = this.jyh.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AppBrandRuntime)((Iterator)localObject).next()).onConfigurationChanged(paramConfiguration);
      }
    }
    AppMethodBeat.o(134557);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134555);
    ad.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.mm.sdk.f.a.jq(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134542);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.dispatchResume();
        }
        AppMethodBeat.o(134542);
      }
    });
    AppMethodBeat.o(134555);
  }
  
  public void setResizeable(boolean paramBoolean)
  {
    AppMethodBeat.i(178515);
    super.setResizeable(paramBoolean);
    this.jyo.fE(true);
    this.jyo.aWL();
    AppMethodBeat.o(178515);
  }
  
  public void setSoftOrientation(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(197211);
    super.setSoftOrientation(paramString);
    v localv = this.jyo;
    if (paramString == null) {
      ad.w("Luggage.AppBrandWindowTuner", "unhandled orientation = [%s]", new Object[] { paramString });
    }
    for (;;)
    {
      try
      {
        Object localObject4 = localv.getRuntime();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((AppBrandRuntime)localObject4).aVN();
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((u)localObject4).getPageView();
            localObject1 = localObject3;
            if (localObject4 != null) {
              localObject1 = ((aa)localObject4).getFullscreenImpl();
            }
          }
        }
      }
      catch (AssertionFailedError localAssertionFailedError)
      {
        Object localObject1;
        int i;
        Object localObject2 = localObject3;
        continue;
      }
      if ((localObject1 == null) || (!(localObject1 instanceof as)) || (!((as)localObject1).jBC))
      {
        localv.jAC = paramString;
        if ((localv.aWH()) || (localv.aWG()))
        {
          paramString = localv.aWJ();
          if (paramString != null) {
            paramString.addOnLayoutChangeListener((View.OnLayoutChangeListener)new v.e(localv));
          }
          i = localv.getActivity().getRequestedOrientation();
          if ((i != 14) && (i != -1)) {
            localv.getActivity().setRequestedOrientation(-1);
          }
        }
      }
      AppMethodBeat.o(197211);
      return;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 3005871: 
        if (!paramString.equals("auto")) {
          break;
        }
        localObject1 = localv.ctx.getResources();
        p.g(localObject1, "ctx.resources");
        localv.jAB = v.rF(((Resources)localObject1).getConfiguration().orientation);
        break;
      case 729267099: 
        if (!paramString.equals("portrait")) {
          break;
        }
        localv.jAB = v.c.jAF;
        break;
      case 1430647483: 
        if (!paramString.equals("landscape")) {
          break;
        }
        localv.jAB = v.c.jAE;
      }
    }
  }
  
  public final RUNTIME w(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134552);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(134552);
      throw paramAppBrandRuntime;
    }
    ListIterator localListIterator = this.jyh.listIterator();
    int i = 0;
    while (localListIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localListIterator.next();
      if (localAppBrandRuntime == paramAppBrandRuntime)
      {
        i = 1;
      }
      else if (i != 0)
      {
        AppMethodBeat.o(134552);
        return localAppBrandRuntime;
      }
    }
    if (i == 0)
    {
      paramAppBrandRuntime = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramAppBrandRuntime.mAppId }));
      AppMethodBeat.o(134552);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(134552);
    return null;
  }
  
  public final boolean x(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134554);
    boolean bool = this.jyh.contains(paramAppBrandRuntime);
    AppMethodBeat.o(134554);
    return bool;
  }
  
  public final void y(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134558);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134558);
      return;
    }
    paramAppBrandRuntime = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134544);
        AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this, paramAppBrandRuntime);
        AppMethodBeat.o(134544);
      }
    };
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramAppBrandRuntime.run();
      AppMethodBeat.o(134558);
      return;
    }
    if (com.tencent.mm.sdk.f.a.jq(this.mContext) != null)
    {
      com.tencent.mm.sdk.f.a.jq(this.mContext).runOnUiThread(paramAppBrandRuntime);
      AppMethodBeat.o(134558);
      return;
    }
    new ap(Looper.getMainLooper()).post(paramAppBrandRuntime);
    AppMethodBeat.o(134558);
  }
  
  protected final boolean z(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.jyh.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(134560);
      return true;
    }
    AppMethodBeat.o(134560);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */