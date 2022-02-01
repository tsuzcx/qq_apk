package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
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
import com.tencent.mm.plugin.appbrand.s.a.a.c;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.plugin.appbrand.s.a.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.am;
import d.g.b.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime>
  extends o
  implements ai
{
  private Application.ActivityLifecycleCallbacks cww;
  public final LinkedList<RUNTIME> iEY;
  public final HashMap<String, RUNTIME> iEZ;
  public final com.tencent.mm.plugin.appbrand.task.g iFa;
  private Class<? extends RUNTIME> iFb;
  private boolean iFc;
  protected boolean iFd;
  public n iFe;
  private v iFf;
  protected boolean iFg;
  public FrameLayout mContentView;
  
  public AppBrandRuntimeContainer(final com.tencent.mm.plugin.appbrand.task.g paramg, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.iFc = false;
    this.iFd = false;
    this.iFg = false;
    super.av(paramg.getContext());
    this.iEY = new LinkedList();
    this.iEZ = new HashMap();
    this.mContentView = paramg.bnJ();
    this.iFa = paramg;
    this.iFb = paramClass;
    this.iFf = new v(paramg.getContext())
    {
      public final boolean aMJ()
      {
        AppMethodBeat.i(194398);
        boolean bool = AppBrandRuntimeContainer.this.aMH();
        AppMethodBeat.o(194398);
        return bool;
      }
      
      public final void aMK()
      {
        AppMethodBeat.i(194399);
        AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this);
        AppMethodBeat.o(194399);
      }
      
      public final ViewGroup aML()
      {
        AppMethodBeat.i(194403);
        ViewGroup localViewGroup = AppBrandRuntimeContainer.H(AppBrandRuntimeContainer.this.getActiveRuntime());
        AppMethodBeat.o(194403);
        return localViewGroup;
      }
      
      public final Activity getActivity()
      {
        AppMethodBeat.i(194401);
        Activity localActivity = paramg.getActivity();
        AppMethodBeat.o(194401);
        return localActivity;
      }
      
      public final int getBgColor()
      {
        AppMethodBeat.i(194400);
        int i = AppBrandRuntimeContainer.this.getWindowColor();
        AppMethodBeat.o(194400);
        return i;
      }
      
      public final AppBrandRuntime getRuntime()
      {
        AppMethodBeat.i(194402);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
        AppMethodBeat.o(194402);
        return localAppBrandRuntime;
      }
    };
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(194404);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this).isShown()) && (t.aC(AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = com.tencent.mm.sdk.f.a.iV(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = am.XC(((Activity)localObject).getWindow().getNavigationBarColor());
            localObject = ((Activity)localObject).getWindow();
            if (!bool) {}
            for (paramAnonymousInt = 1; (localObject == null) || (((Window)localObject).getDecorView() == null); paramAnonymousInt = 0)
            {
              AppMethodBeat.o(194404);
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
          AppMethodBeat.o(194404);
          return;
        }
      }
    });
    paramg = com.tencent.mm.plugin.appbrand.s.a.a.g.C(com.tencent.mm.sdk.f.a.iV(this.mContext));
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramg.mFinished = false;
      paramg = (Application)getContext().getApplicationContext();
      paramClass = new com.tencent.mm.plugin.appbrand.aa.a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(194407);
          if (com.tencent.mm.sdk.f.a.iV(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ad.i("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this);
          }
          AppMethodBeat.o(194407);
        }
        
        public final void onActivityPaused(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(194406);
          if (com.tencent.mm.sdk.f.a.iV(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ad.i("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.this.aMI().onPause();
          }
          AppMethodBeat.o(194406);
        }
        
        public final void onActivityResumed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(194405);
          if (com.tencent.mm.sdk.f.a.iV(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ad.i("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.this.aMI().onResume();
          }
          AppMethodBeat.o(194405);
        }
      };
      this.cww = paramClass;
      paramg.registerActivityLifecycleCallbacks(paramClass);
      AppMethodBeat.o(134545);
      return;
    }
    finally
    {
      AppMethodBeat.o(134545);
    }
  }
  
  private void D(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134561);
    this.iEY.remove(paramRUNTIME);
    this.iEY.push(paramRUNTIME);
    paramRUNTIME.iDA.setVisibility(0);
    f(G(paramRUNTIME));
    AppMethodBeat.o(134561);
  }
  
  private void E(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134562);
    if (this.iEY.contains(paramRUNTIME))
    {
      AppMethodBeat.o(134562);
      return;
    }
    this.iEY.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.iDA) == -1) {
      a(paramRUNTIME.iDA);
    }
    this.iEZ.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(134562);
  }
  
  private static ViewGroup G(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194411);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(194411);
      return null;
    }
    paramAppBrandRuntime = (ViewGroup)paramAppBrandRuntime.iDA.getParent();
    AppMethodBeat.o(194411);
    return paramAppBrandRuntime;
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((aMG()) && (aMF())) {
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
      this.iFf.aMN();
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(178508);
          boolean bool = false;
          if (AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this) != null) {
            bool = AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this).d(paramAnonymousKeyEvent);
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
  
  private void aMB()
  {
    AppMethodBeat.i(177591);
    if (this.cww != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.cww);
      this.cww = null;
    }
    aMI().release();
    AppMethodBeat.o(177591);
  }
  
  private boolean aMF()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.iFe != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean aMG()
  {
    return this.iFe != null;
  }
  
  private void f(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(194412);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      ad.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(194412);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (aMG()) {
      this.mContentView.bringChildToFront(this.iFe);
    }
    this.iFf.aMN();
    AppMethodBeat.o(194412);
  }
  
  private void fb(boolean paramBoolean)
  {
    AppMethodBeat.i(194416);
    if (paramBoolean)
    {
      if ((this.lnW != null) && (!(this.lnW instanceof com.tencent.mm.plugin.appbrand.s.a.b.a.a)))
      {
        this.lnW.release();
        this.lnW = null;
        AppMethodBeat.o(194416);
      }
    }
    else if ((this.lnW != null) && ((this.lnW instanceof com.tencent.mm.plugin.appbrand.s.a.b.a.a)))
    {
      this.lnW.release();
      this.lnW = null;
    }
    AppMethodBeat.o(194416);
  }
  
  public final boolean A(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134554);
    boolean bool = this.iEY.contains(paramAppBrandRuntime);
    AppMethodBeat.o(134554);
    return bool;
  }
  
  public final void B(final AppBrandRuntime paramAppBrandRuntime)
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
    if (Looper.getMainLooper() == Looper.myLooper()) {
      paramAppBrandRuntime.run();
    }
    if (com.tencent.mm.sdk.f.a.iV(this.mContext) != null)
    {
      com.tencent.mm.sdk.f.a.iV(this.mContext).runOnUiThread(paramAppBrandRuntime);
      AppMethodBeat.o(134558);
      return;
    }
    new ap(Looper.getMainLooper()).post(paramAppBrandRuntime);
    AppMethodBeat.o(134558);
  }
  
  protected final boolean C(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.iEY.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(134560);
      return true;
    }
    AppMethodBeat.o(134560);
    return false;
  }
  
  public final RUNTIME Dk(String paramString)
  {
    AppMethodBeat.i(194410);
    Iterator localIterator = this.iEY.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(194410);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.iEZ.get(paramString);
    AppMethodBeat.o(194410);
    return paramString;
  }
  
  public final void F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.iEY.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.d a(d.b paramb)
  {
    AppMethodBeat.i(194414);
    if (aMH())
    {
      paramb = new ar(this, paramb);
      AppMethodBeat.o(194414);
      return paramb;
    }
    paramb = super.a(paramb);
    AppMethodBeat.o(194414);
    return paramb;
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.iDw = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.iEY.push(paramRUNTIME2);
    a(paramRUNTIME2.iDA);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aLH();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(194409);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(194409);
      return;
    }
    com.tencent.mm.sdk.f.a.iV(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134539);
        n.I(com.tencent.mm.sdk.f.a.iV(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.aMD();
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.Dk(paramAppBrandInitConfig.appId);
        if (localAppBrandRuntime == null)
        {
          localAppBrandRuntime = AppBrandRuntimeContainer.this.f(paramAppBrandInitConfig);
          AppBrandRuntimeContainer.this.a(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
          AppMethodBeat.o(134539);
          return;
        }
        AppBrandRuntimeContainer.this.b(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
        AppMethodBeat.o(134539);
      }
    });
    AppMethodBeat.o(194409);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(176531);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(this.mContext);
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
        if (!AppBrandRuntimeContainer.this.C(paramAppBrandRuntime))
        {
          ad.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134540);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.z(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Eg(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          ad.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this)) });
          AppBrandRuntimeContainer.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194408);
              AppBrandRuntimeContainer.8.this.iFn.iDA.setVisibility(8);
              AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.8.this.iFn);
              AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.8.this.iFn.mAppId, AppBrandRuntimeContainer.8.this.iFn);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.8.this.iFn.dispatchPause();
              if ((AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.8.this.iFn.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ad.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this)) });
                AppMethodBeat.o(194408);
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
  
  public final boolean aMC()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.iFa.aMC();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  public final void aMD()
  {
    AppMethodBeat.i(134563);
    Iterator localIterator = this.iEY.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      localAppBrandRuntime.iDA.setVisibility(8);
      this.iEZ.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
      localAppBrandRuntime.aMf();
    }
    this.iEY.clear();
    AppMethodBeat.o(134563);
  }
  
  protected final LinkedList<RUNTIME> aME()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.iEY);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public final boolean aMH()
  {
    boolean bool1 = false;
    AppMethodBeat.i(185548);
    boolean bool2 = super.aMH();
    ad.i("MicroMsg.AppBrandRuntimeContainer", "shouldInLargeScreenCompatMode: shouldInLargeScreenCompatMode = [%b], forceDisableCompatMode = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(this.iFg) });
    if (this.iFg) {}
    for (;;)
    {
      AppMethodBeat.o(185548);
      return bool1;
      bool1 = bool2;
    }
  }
  
  public final c aMI()
  {
    AppMethodBeat.i(194415);
    if (aMH())
    {
      fb(true);
      if (this.lnW != null) {}
    }
    for (this.lnW = new com.tencent.mm.plugin.appbrand.s.a.b.a.a(this);; this.lnW = new com.tencent.mm.plugin.appbrand.s.a.a.d(this))
    {
      c localc = this.lnW;
      AppMethodBeat.o(194415);
      return localc;
      fb(false);
      if ((this.lnW != null) && ((this.lnW instanceof com.tencent.mm.plugin.appbrand.s.a.a.d)) && (((com.tencent.mm.plugin.appbrand.s.a.a.d)this.lnW).activity != com.tencent.mm.sdk.f.a.iV(this.mContext))) {
        this.lnW.release();
      }
    }
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    E(paramRUNTIME2);
    D(paramRUNTIME2);
    paramRUNTIME2.iDw = paramRUNTIME1;
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
    ((LinkedList)localObject).addAll(this.iEY);
    ((LinkedList)localObject).addAll(this.iEZ.values());
    aMD();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.iDR = false;
      B(localAppBrandRuntime);
    }
    ad.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    aMB();
    AppMethodBeat.o(134559);
  }
  
  public RUNTIME f(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.bA(this.iFb).ag(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.iEY.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.iEY.size();
    AppMethodBeat.o(185921);
    return i;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(178516);
    DisplayMetrics localDisplayMetrics2 = super.getVDisplayMetrics();
    DisplayMetrics localDisplayMetrics1;
    if ((aMH()) || (this.iFf.iHr)) {
      localDisplayMetrics1 = this.iFf.getVDisplayMetrics();
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandRuntimeContainer", "getVDisplayMetrics: [%d,%d, %b]", new Object[] { Integer.valueOf(localDisplayMetrics1.widthPixels), Integer.valueOf(localDisplayMetrics1.heightPixels), Boolean.valueOf(aMH()) });
      this.iFf.iHq = localDisplayMetrics1.heightPixels;
      this.iFf.iHp = localDisplayMetrics1.widthPixels;
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
    Object localObject = this.iFf;
    k.h(paramConfiguration, "newConfig");
    if ((((v)localObject).iHo != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != ((v)localObject).iHm) || (paramConfiguration.screenWidthDp != ((v)localObject).iHn)) {
      if (((paramConfiguration.screenHeightDp == ((v)localObject).iHm) && (paramConfiguration.screenWidthDp == ((v)localObject).iHn)) || (((v)localObject).iHo != paramConfiguration.orientation)) {
        break label267;
      }
    }
    label267:
    for (boolean bool = true;; bool = false)
    {
      ((v)localObject).iHr = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        if ((((v)localObject).getActivity().isInMultiWindowMode()) || (((v)localObject).iHs)) {
          ((v)localObject).iHr = false;
        }
        ((v)localObject).iHs = ((v)localObject).getActivity().isInMultiWindowMode();
      }
      ((v)localObject).aNF();
      if (((v)localObject).getRuntime() != null)
      {
        if ((((v)localObject).iHr) && ((paramConfiguration.screenHeightDp != ((v)localObject).iHm) || (paramConfiguration.screenWidthDp != ((v)localObject).iHn))) {
          ((v)localObject).aMK();
        }
        ViewGroup localViewGroup = ((v)localObject).aML();
        if (localViewGroup != null) {
          localViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)new v.c((v)localObject));
        }
      }
      ((v)localObject).iHo = paramConfiguration.orientation;
      ((v)localObject).iHm = paramConfiguration.screenHeightDp;
      ((v)localObject).iHn = paramConfiguration.screenWidthDp;
      if (this.iEY == null) {
        break;
      }
      localObject = this.iEY.iterator();
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
    com.tencent.mm.sdk.f.a.iV(this.mContext).runOnUiThread(new Runnable()
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
    this.iFf.ff(true);
    this.iFf.aMN();
    AppMethodBeat.o(178515);
  }
  
  public void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(194413);
    super.setSoftOrientation(paramString);
    v localv = this.iFf;
    localv.iHu = paramString;
    if (localv.aMJ())
    {
      paramString = localv.aML();
      if (paramString != null) {
        paramString.addOnLayoutChangeListener((View.OnLayoutChangeListener)new v.f(localv));
      }
      int i = localv.getActivity().getRequestedOrientation();
      if ((i != 14) && (i != -1)) {
        localv.getActivity().setRequestedOrientation(-1);
      }
    }
    AppMethodBeat.o(194413);
  }
  
  public final RUNTIME z(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134552);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(134552);
      throw paramAppBrandRuntime;
    }
    ListIterator localListIterator = this.iEY.listIterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */