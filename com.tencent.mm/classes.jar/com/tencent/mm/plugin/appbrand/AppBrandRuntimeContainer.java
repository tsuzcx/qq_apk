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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.a.c;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
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
  private Application.ActivityLifecycleCallbacks ctF;
  public final LinkedList<RUNTIME> jfa;
  public final HashMap<String, RUNTIME> jfb;
  public final com.tencent.mm.plugin.appbrand.task.g jfc;
  private Class<? extends RUNTIME> jfd;
  private boolean jfe;
  protected boolean jff;
  public n jfg;
  private v jfh;
  protected boolean jfi;
  public FrameLayout mContentView;
  
  public AppBrandRuntimeContainer(final com.tencent.mm.plugin.appbrand.task.g paramg, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.jfe = false;
    this.jff = false;
    this.jfi = false;
    super.aw(paramg.getContext());
    this.jfa = new LinkedList();
    this.jfb = new HashMap();
    this.mContentView = paramg.buF();
    this.jfc = paramg;
    this.jfd = paramClass;
    this.jfh = new v(paramg.getContext())
    {
      public final void aTA()
      {
        AppMethodBeat.i(193313);
        AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this);
        AppMethodBeat.o(193313);
      }
      
      public final ViewGroup aTB()
      {
        AppMethodBeat.i(193317);
        ViewGroup localViewGroup = AppBrandRuntimeContainer.H(AppBrandRuntimeContainer.this.getActiveRuntime());
        AppMethodBeat.o(193317);
        return localViewGroup;
      }
      
      public final boolean aTz()
      {
        AppMethodBeat.i(193312);
        boolean bool = AppBrandRuntimeContainer.this.aTx();
        AppMethodBeat.o(193312);
        return bool;
      }
      
      public final Activity getActivity()
      {
        AppMethodBeat.i(193315);
        Activity localActivity = paramg.getActivity();
        AppMethodBeat.o(193315);
        return localActivity;
      }
      
      public final int getBgColor()
      {
        AppMethodBeat.i(193314);
        int i = AppBrandRuntimeContainer.this.getWindowColor();
        AppMethodBeat.o(193314);
        return i;
      }
      
      public final AppBrandRuntime getRuntime()
      {
        AppMethodBeat.i(193316);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
        AppMethodBeat.o(193316);
        return localAppBrandRuntime;
      }
    };
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(193318);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this).isShown()) && (t.aC(AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = com.tencent.mm.sdk.f.a.jg(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = am.ZN(((Activity)localObject).getWindow().getNavigationBarColor());
            localObject = ((Activity)localObject).getWindow();
            if (!bool) {}
            for (paramAnonymousInt = 1; (localObject == null) || (((Window)localObject).getDecorView() == null); paramAnonymousInt = 0)
            {
              AppMethodBeat.o(193318);
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
          AppMethodBeat.o(193318);
          return;
        }
      }
    });
    paramg = com.tencent.mm.plugin.appbrand.r.a.a.g.C(com.tencent.mm.sdk.f.a.jg(this.mContext));
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramg.mFinished = false;
      paramg = (Application)getContext().getApplicationContext();
      paramClass = new com.tencent.mm.plugin.appbrand.z.a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(193321);
          if (com.tencent.mm.sdk.f.a.jg(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ac.i("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this);
          }
          AppMethodBeat.o(193321);
        }
        
        public final void onActivityPaused(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(193320);
          if (com.tencent.mm.sdk.f.a.jg(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ac.i("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.this.aTy().onPause();
          }
          AppMethodBeat.o(193320);
        }
        
        public final void onActivityResumed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(193319);
          if (com.tencent.mm.sdk.f.a.jg(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ac.i("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.this.aTy().onResume();
          }
          AppMethodBeat.o(193319);
        }
      };
      this.ctF = paramClass;
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
    this.jfa.remove(paramRUNTIME);
    this.jfa.push(paramRUNTIME);
    paramRUNTIME.jdA.setVisibility(0);
    f(G(paramRUNTIME));
    AppMethodBeat.o(134561);
  }
  
  private void E(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134562);
    if (this.jfa.contains(paramRUNTIME))
    {
      AppMethodBeat.o(134562);
      return;
    }
    this.jfa.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.jdA) == -1) {
      a(paramRUNTIME.jdA);
    }
    this.jfb.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(134562);
  }
  
  private static ViewGroup G(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193325);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(193325);
      return null;
    }
    paramAppBrandRuntime = (ViewGroup)paramAppBrandRuntime.jdA.getParent();
    AppMethodBeat.o(193325);
    return paramAppBrandRuntime;
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((aTw()) && (aTv())) {
      i -= 1;
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandRuntimeContainer", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramd.getTag(), Integer.valueOf(i) });
      if (paramd.getParent() != null) {
        ((ViewGroup)paramd.getParent()).removeAllViews();
      }
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView(paramd);
      this.mContentView.addView(localFrameLayout, i);
      this.jfh.aTD();
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
  
  private void aTr()
  {
    AppMethodBeat.i(177591);
    if (this.ctF != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.ctF);
      this.ctF = null;
    }
    aTy().release();
    AppMethodBeat.o(177591);
  }
  
  private boolean aTv()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.jfg != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean aTw()
  {
    return this.jfg != null;
  }
  
  private void f(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(193326);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      ac.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(193326);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (aTw()) {
      this.mContentView.bringChildToFront(this.jfg);
    }
    this.jfh.aTD();
    AppMethodBeat.o(193326);
  }
  
  private void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(193330);
    if (paramBoolean)
    {
      if ((this.lPX != null) && (!(this.lPX instanceof com.tencent.mm.plugin.appbrand.r.a.b.a.a)))
      {
        this.lPX.release();
        this.lPX = null;
        AppMethodBeat.o(193330);
      }
    }
    else if ((this.lPX != null) && ((this.lPX instanceof com.tencent.mm.plugin.appbrand.r.a.b.a.a)))
    {
      this.lPX.release();
      this.lPX = null;
    }
    AppMethodBeat.o(193330);
  }
  
  public final boolean A(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134554);
    boolean bool = this.jfa.contains(paramAppBrandRuntime);
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
    if (com.tencent.mm.sdk.f.a.jg(this.mContext) != null)
    {
      com.tencent.mm.sdk.f.a.jg(this.mContext).runOnUiThread(paramAppBrandRuntime);
      AppMethodBeat.o(134558);
      return;
    }
    new ao(Looper.getMainLooper()).post(paramAppBrandRuntime);
    AppMethodBeat.o(134558);
  }
  
  protected final boolean C(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.jfa.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(134560);
      return true;
    }
    AppMethodBeat.o(134560);
    return false;
  }
  
  public final void F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.jfa.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  public final RUNTIME Hn(String paramString)
  {
    AppMethodBeat.i(193324);
    Iterator localIterator = this.jfa.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(193324);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.jfb.get(paramString);
    AppMethodBeat.o(193324);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d a(d.b paramb)
  {
    AppMethodBeat.i(193328);
    if (aTx())
    {
      paramb = new ar(this, paramb, com.tencent.mm.sdk.f.a.jg(this.mContext));
      AppMethodBeat.o(193328);
      return paramb;
    }
    paramb = super.a(paramb);
    AppMethodBeat.o(193328);
    return paramb;
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.jdw = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.jfa.push(paramRUNTIME2);
    a(paramRUNTIME2.jdA);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aSx();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(193323);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(193323);
      return;
    }
    com.tencent.mm.sdk.f.a.jg(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134539);
        n.I(com.tencent.mm.sdk.f.a.jg(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.aTt();
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.Hn(paramAppBrandInitConfig.appId);
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
    AppMethodBeat.o(193323);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(176531);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(this.mContext);
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
          ac.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134540);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.z(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.DJ(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          ac.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this)) });
          AppBrandRuntimeContainer.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193322);
              AppBrandRuntimeContainer.8.this.jfp.jdA.setVisibility(8);
              AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.8.this.jfp);
              AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.8.this.jfp.mAppId, AppBrandRuntimeContainer.8.this.jfp);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.8.this.jfp.dispatchPause();
              if ((AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.8.this.jfp.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ac.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this)) });
                AppMethodBeat.o(193322);
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
  
  public final boolean aTs()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.jfc.aTs();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(134563);
    Iterator localIterator = this.jfa.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      localAppBrandRuntime.jdA.setVisibility(8);
      this.jfb.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
      localAppBrandRuntime.aSV();
    }
    this.jfa.clear();
    AppMethodBeat.o(134563);
  }
  
  protected final LinkedList<RUNTIME> aTu()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.jfa);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public final boolean aTx()
  {
    boolean bool1 = false;
    AppMethodBeat.i(185548);
    boolean bool2 = super.aTx();
    ac.i("MicroMsg.AppBrandRuntimeContainer", "shouldInLargeScreenCompatMode: shouldInLargeScreenCompatMode = [%b], forceDisableCompatMode = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(this.jfi) });
    if (this.jfi) {}
    for (;;)
    {
      AppMethodBeat.o(185548);
      return bool1;
      bool1 = bool2;
    }
  }
  
  public final c aTy()
  {
    AppMethodBeat.i(193329);
    if (aTx())
    {
      fv(true);
      if (this.lPX != null) {}
    }
    for (this.lPX = new com.tencent.mm.plugin.appbrand.r.a.b.a.a(this);; this.lPX = new com.tencent.mm.plugin.appbrand.r.a.a.d(this))
    {
      c localc = this.lPX;
      AppMethodBeat.o(193329);
      return localc;
      fv(false);
      if ((this.lPX != null) && ((this.lPX instanceof com.tencent.mm.plugin.appbrand.r.a.a.d)) && (((com.tencent.mm.plugin.appbrand.r.a.a.d)this.lPX).activity != com.tencent.mm.sdk.f.a.jg(this.mContext))) {
        this.lPX.release();
      }
    }
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    E(paramRUNTIME2);
    D(paramRUNTIME2);
    paramRUNTIME2.jdw = paramRUNTIME1;
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
      ac.i("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { paramAppBrandRuntime1, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      AppMethodBeat.o(134550);
      return;
    }
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(134559);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.jfa);
    ((LinkedList)localObject).addAll(this.jfb.values());
    aTt();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.jdR = false;
      B(localAppBrandRuntime);
    }
    ac.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    aTr();
    AppMethodBeat.o(134559);
  }
  
  public RUNTIME f(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.bD(this.jfd).ai(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.jfa.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.jfa.size();
    AppMethodBeat.o(185921);
    return i;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(178516);
    DisplayMetrics localDisplayMetrics2 = super.getVDisplayMetrics();
    DisplayMetrics localDisplayMetrics1;
    if ((aTx()) || (this.jfh.jht)) {
      localDisplayMetrics1 = this.jfh.getVDisplayMetrics();
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandRuntimeContainer", "getVDisplayMetrics: [%d,%d, %b]", new Object[] { Integer.valueOf(localDisplayMetrics1.widthPixels), Integer.valueOf(localDisplayMetrics1.heightPixels), Boolean.valueOf(aTx()) });
      this.jfh.jhs = localDisplayMetrics1.heightPixels;
      this.jfh.jhr = localDisplayMetrics1.widthPixels;
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
        ac.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", new Object[] { localException });
        ap.f(new Runnable()
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
    Object localObject = this.jfh;
    k.h(paramConfiguration, "newConfig");
    if ((((v)localObject).gud != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != ((v)localObject).jhp) || (paramConfiguration.screenWidthDp != ((v)localObject).jhq)) {
      if (((paramConfiguration.screenHeightDp == ((v)localObject).jhp) && (paramConfiguration.screenWidthDp == ((v)localObject).jhq)) || (((v)localObject).gud != paramConfiguration.orientation)) {
        break label267;
      }
    }
    label267:
    for (boolean bool = true;; bool = false)
    {
      ((v)localObject).jht = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        if ((((v)localObject).getActivity().isInMultiWindowMode()) || (((v)localObject).jhu)) {
          ((v)localObject).jht = false;
        }
        ((v)localObject).jhu = ((v)localObject).getActivity().isInMultiWindowMode();
      }
      ((v)localObject).aUv();
      if (((v)localObject).getRuntime() != null)
      {
        if ((((v)localObject).jht) && ((paramConfiguration.screenHeightDp != ((v)localObject).jhp) || (paramConfiguration.screenWidthDp != ((v)localObject).jhq))) {
          ((v)localObject).aTA();
        }
        ViewGroup localViewGroup = ((v)localObject).aTB();
        if (localViewGroup != null) {
          localViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)new v.c((v)localObject));
        }
      }
      ((v)localObject).gud = paramConfiguration.orientation;
      ((v)localObject).jhp = paramConfiguration.screenHeightDp;
      ((v)localObject).jhq = paramConfiguration.screenWidthDp;
      if (this.jfa == null) {
        break;
      }
      localObject = this.jfa.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AppBrandRuntime)((Iterator)localObject).next()).onConfigurationChanged(paramConfiguration);
      }
    }
    AppMethodBeat.o(134557);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134555);
    ac.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.mm.sdk.f.a.jg(this.mContext).runOnUiThread(new Runnable()
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
    this.jfh.fA(true);
    this.jfh.aTD();
    AppMethodBeat.o(178515);
  }
  
  public void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(193327);
    super.setSoftOrientation(paramString);
    v localv = this.jfh;
    Object localObject = localv.getRuntime();
    if (localObject != null)
    {
      localObject = ((AppBrandRuntime)localObject).aSA();
      if (localObject != null)
      {
        localObject = ((u)localObject).getPageView();
        if (localObject == null) {}
      }
    }
    for (localObject = ((aa)localObject).getFullscreenImpl();; localObject = null)
    {
      if ((localObject == null) || (!(localObject instanceof ar)) || (!((ar)localObject).jim))
      {
        localv.jhw = paramString;
        if (localv.aTz())
        {
          paramString = localv.aTB();
          if (paramString != null) {
            paramString.addOnLayoutChangeListener((View.OnLayoutChangeListener)new v.f(localv));
          }
          int i = localv.getActivity().getRequestedOrientation();
          if ((i != 14) && (i != -1)) {
            localv.getActivity().setRequestedOrientation(-1);
          }
        }
      }
      AppMethodBeat.o(193327);
      return;
    }
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
    ListIterator localListIterator = this.jfa.listIterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */