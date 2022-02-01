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
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.a.c;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime>
  extends o
  implements ai
{
  private Application.ActivityLifecycleCallbacks cFh;
  public final LinkedList<RUNTIME> jBi;
  public final HashMap<String, RUNTIME> jBj;
  public final com.tencent.mm.plugin.appbrand.task.g jBk;
  private Class<? extends RUNTIME> jBl;
  private boolean jBm;
  protected boolean jBn;
  public n jBo;
  public FrameLayout mContentView;
  
  public AppBrandRuntimeContainer(com.tencent.mm.plugin.appbrand.task.g paramg, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.jBm = false;
    this.jBn = false;
    super.ax(paramg.getContext());
    this.jBi = new LinkedList();
    this.jBj = new HashMap();
    this.mContentView = paramg.bzE();
    this.jBk = paramg;
    this.jBl = paramClass;
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(176524);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).isShown()) && (t.aC(AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = com.tencent.mm.sdk.f.a.jw(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = ao.acF(((Activity)localObject).getWindow().getNavigationBarColor());
            localObject = ((Activity)localObject).getWindow();
            if (!bool) {}
            for (paramAnonymousInt = 1; (localObject == null) || (((Window)localObject).getDecorView() == null); paramAnonymousInt = 0)
            {
              AppMethodBeat.o(176524);
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
          AppMethodBeat.o(176524);
          return;
        }
      }
    });
    paramg = com.tencent.mm.plugin.appbrand.platform.window.a.g.D(com.tencent.mm.sdk.f.a.jw(this.mContext));
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramg.mFinished = false;
      paramg = (Application)getContext().getApplicationContext();
      paramClass = new com.tencent.mm.plugin.appbrand.y.a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(176528);
          if (com.tencent.mm.sdk.f.a.jw(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ae.i("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this);
          }
          AppMethodBeat.o(176528);
        }
        
        public final void onActivityPaused(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(176527);
          if (com.tencent.mm.sdk.f.a.jw(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ae.i("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.this.bxN().onPause();
          }
          AppMethodBeat.o(176527);
        }
        
        public final void onActivityResumed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(176526);
          if (com.tencent.mm.sdk.f.a.jw(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            ae.i("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.this.bxN().onResume();
          }
          AppMethodBeat.o(176526);
        }
      };
      this.cFh = paramClass;
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
    this.jBi.remove(paramRUNTIME);
    this.jBi.push(paramRUNTIME);
    paramRUNTIME.jzF.setVisibility(0);
    g(paramRUNTIME.jzF);
    AppMethodBeat.o(134561);
  }
  
  private void B(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134562);
    if (this.jBi.contains(paramRUNTIME))
    {
      AppMethodBeat.o(134562);
      return;
    }
    this.jBi.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.jzF) == -1) {
      a(paramRUNTIME.jzF);
    }
    this.jBj.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(134562);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((aXf()) && (aXe())) {
      i -= 1;
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrandRuntimeContainer", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { (String)paramd.getTag(), Integer.valueOf(i) });
      if (paramd.getParent() != null) {
        ((ViewGroup)paramd.getParent()).removeAllViews();
      }
      this.mContentView.addView(paramd, i);
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(207690);
          boolean bool = false;
          if (AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this) != null) {
            bool = AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(207690);
          return bool;
        }
      });
      AppMethodBeat.o(178511);
      return;
      i = 0;
    }
  }
  
  private void aXb()
  {
    AppMethodBeat.i(177591);
    if (this.cFh != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.cFh);
      this.cFh = null;
    }
    bxN().release();
    AppMethodBeat.o(177591);
  }
  
  private boolean aXe()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.jBo != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean aXf()
  {
    return this.jBo != null;
  }
  
  private void g(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(207696);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      ae.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(207696);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (aXf()) {
      this.mContentView.bringChildToFront(this.jBo);
    }
    AppMethodBeat.o(207696);
  }
  
  private void y(final RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(207694);
    ae.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", new Object[] { paramRUNTIME.mAppId });
    final Runnable local11 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134544);
        ae.i("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", new Object[] { paramRUNTIME.mAppId });
        paramRUNTIME.dispatchDestroy();
        AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).removeView(paramRUNTIME.jzF);
        AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).remove(paramRUNTIME.mAppId);
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(paramRUNTIME);
        AppMethodBeat.o(134544);
      }
    };
    if (!w(paramRUNTIME))
    {
      ae.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramRUNTIME.mAppId });
      local11.run();
      AppMethodBeat.o(207694);
      return;
    }
    final AppBrandRuntime localAppBrandRuntime = v(paramRUNTIME);
    b(localAppBrandRuntime, paramRUNTIME, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176525);
        boolean bool = AppBrandRuntimeContainer.this.z(paramRUNTIME);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramRUNTIME.Fn(), null);
        }
        local11.run();
        if ((bool) && (localAppBrandRuntime != null) && (AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this))) {
          localAppBrandRuntime.dispatchResume();
        }
        if (localAppBrandRuntime == null) {}
        for (String str = "null";; str = localAppBrandRuntime.mAppId)
        {
          ae.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
          AppMethodBeat.o(176525);
          return;
        }
      }
    });
    AppMethodBeat.o(207694);
  }
  
  public final void C(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.jBi.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  public final RUNTIME KY(String paramString)
  {
    AppMethodBeat.i(207693);
    Iterator localIterator = this.jBi.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(207693);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.jBj.get(paramString);
    AppMethodBeat.o(207693);
    return paramString;
  }
  
  public final void KZ(String paramString)
  {
    AppMethodBeat.i(207695);
    Iterator localIterator = this.jBi.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if ((paramString != null) && (paramString.equals(localAppBrandRuntime.mAppId)))
      {
        ae.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, exclude appId(%s)", new Object[] { paramString });
      }
      else
      {
        localIterator.remove();
        localAppBrandRuntime.jzF.setVisibility(8);
        this.jBj.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
        localAppBrandRuntime.aWK();
        if (!localAppBrandRuntime.mInitialized)
        {
          ae.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", new Object[] { localAppBrandRuntime.mAppId });
          y(localAppBrandRuntime);
        }
        else if (localAppBrandRuntime.mResumed)
        {
          ae.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", new Object[] { localAppBrandRuntime.mAppId });
          localAppBrandRuntime.dispatchPause();
        }
      }
    }
    AppMethodBeat.o(207695);
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207697);
    super.a(paramInt, paramAppBrandRuntime);
    ((View)paramAppBrandRuntime.jzF.getParent()).setBackgroundColor(paramInt);
    AppMethodBeat.o(207697);
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.jzB = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.jBi.push(paramRUNTIME2);
    a(paramRUNTIME2.jzF);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aWi();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(207692);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(207692);
      return;
    }
    com.tencent.mm.sdk.f.a.jw(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207691);
        n.J(com.tencent.mm.sdk.f.a.jw(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.KZ(paramAppBrandInitConfig.appId);
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.KY(paramAppBrandInitConfig.appId);
        if (localAppBrandRuntime == null)
        {
          localAppBrandRuntime = AppBrandRuntimeContainer.this.e(paramAppBrandInitConfig);
          AppBrandRuntimeContainer.this.a(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
          AppMethodBeat.o(207691);
          return;
        }
        AppBrandRuntimeContainer.this.b(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
        AppMethodBeat.o(207691);
      }
    });
    AppMethodBeat.o(207692);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(176531);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    localActivity.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134539);
        if (!AppBrandRuntimeContainer.this.z(paramAppBrandRuntime))
        {
          ae.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134539);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.v(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Fn(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          ae.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
          AppBrandRuntimeContainer.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176529);
              AppBrandRuntimeContainer.6.this.jBu.jzF.setVisibility(8);
              AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.6.this.jBu);
              AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.6.this.jBu.mAppId, AppBrandRuntimeContainer.6.this.jBu);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.6.this.jBu.dispatchPause();
              if ((AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.6.this.jBu.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ae.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
                AppMethodBeat.o(176529);
                return;
              }
            }
          });
          AppMethodBeat.o(134539);
          return;
        }
      }
    });
    AppMethodBeat.o(176531);
  }
  
  public final boolean aXc()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.jBk.aXc();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  protected final LinkedList<RUNTIME> aXd()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.jBi);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    B(paramRUNTIME2);
    A(paramRUNTIME2);
    paramRUNTIME2.jzB = paramRUNTIME1;
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
      ae.i("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { paramAppBrandRuntime1, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      AppMethodBeat.o(134550);
      return;
    }
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(134563);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.jBi);
    ((LinkedList)localObject).addAll(this.jBj.values());
    KZ(null);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.jzX = false;
      x(localAppBrandRuntime);
    }
    ae.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    aXb();
    AppMethodBeat.o(134563);
  }
  
  public RUNTIME e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.bF(this.jBl).ai(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.jBi.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.jBi.size();
    AppMethodBeat.o(185921);
    return i;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(178516);
    DisplayMetrics localDisplayMetrics = super.getVDisplayMetrics();
    if (this.mContentView.isLaidOut())
    {
      localDisplayMetrics.widthPixels = this.mContentView.getMeasuredWidth();
      localDisplayMetrics.heightPixels = this.mContentView.getMeasuredHeight();
    }
    AppMethodBeat.o(178516);
    return localDisplayMetrics;
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
        ae.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", new Object[] { localException });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134542);
            Exception localException = localException;
            AppMethodBeat.o(134542);
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
    if (this.jBi != null)
    {
      Iterator localIterator = this.jBi.iterator();
      while (localIterator.hasNext()) {
        ((AppBrandRuntime)localIterator.next()).onConfigurationChanged(paramConfiguration);
      }
    }
    AppMethodBeat.o(134557);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134555);
    ae.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.mm.sdk.f.a.jw(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134541);
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.dispatchResume();
        }
        AppMethodBeat.o(134541);
      }
    });
    AppMethodBeat.o(134555);
  }
  
  public final RUNTIME v(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134552);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(134552);
      throw paramAppBrandRuntime;
    }
    ListIterator localListIterator = this.jBi.listIterator();
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
  
  public final boolean w(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134554);
    boolean bool = this.jBi.contains(paramAppBrandRuntime);
    AppMethodBeat.o(134554);
    return bool;
  }
  
  public final void x(final AppBrandRuntime paramAppBrandRuntime)
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
        AppMethodBeat.i(134543);
        AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this, paramAppBrandRuntime);
        AppMethodBeat.o(134543);
      }
    };
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramAppBrandRuntime.run();
      AppMethodBeat.o(134558);
      return;
    }
    if (com.tencent.mm.sdk.f.a.jw(this.mContext) != null)
    {
      com.tencent.mm.sdk.f.a.jw(this.mContext).runOnUiThread(paramAppBrandRuntime);
      AppMethodBeat.o(134558);
      return;
    }
    new aq(Looper.getMainLooper()).post(paramAppBrandRuntime);
    AppMethodBeat.o(134558);
  }
  
  protected final boolean z(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.jBi.peekFirst() == paramRUNTIME)
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