package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.a.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime>
  extends o
  implements ak
{
  private Application.ActivityLifecycleCallbacks cVK;
  public final LinkedList<RUNTIME> kCb;
  final HashMap<String, RUNTIME> kCc;
  public k kCd;
  private Class<? extends RUNTIME> kCe;
  private boolean kCf;
  protected boolean kCg;
  public n kCh;
  public FrameLayout mContentView;
  
  public AppBrandRuntimeContainer(k paramk, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.kCf = false;
    this.kCg = false;
    super.aG(paramk.getContext());
    this.kCb = new LinkedList();
    this.kCc = new HashMap();
    this.mContentView = paramk.bWl();
    this.kCd = paramk;
    this.kCe = paramClass;
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(176524);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).isShown()) && (u.aD(AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = ar.aln(((Activity)localObject).getWindow().getNavigationBarColor());
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
    paramk = g.E(AndroidContextUtil.castActivityOrNull(this.mContext));
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramk.mFinished = false;
      paramk = (Application)getContext().getApplicationContext();
      paramClass = new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(176528);
          if (AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            Log.i("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this);
          }
          AppMethodBeat.o(176528);
        }
        
        public final void onActivityPaused(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(176527);
          if (AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            Log.i("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.this.bTY().onPause();
          }
          AppMethodBeat.o(176527);
        }
        
        public final void onActivityResumed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(176526);
          if (AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext) == paramAnonymousActivity)
          {
            Log.i("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", new Object[] { paramAnonymousActivity.getLocalClassName() });
            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, true);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, false);
            AppBrandRuntimeContainer.this.bTY().onResume();
          }
          AppMethodBeat.o(176526);
        }
      };
      this.cVK = paramClass;
      paramk.registerActivityLifecycleCallbacks(paramClass);
      AppMethodBeat.o(134545);
      return;
    }
    finally
    {
      AppMethodBeat.o(134545);
    }
  }
  
  private void a(RUNTIME paramRUNTIME, boolean paramBoolean)
  {
    AppMethodBeat.i(219225);
    if ((this.kCb.contains(paramRUNTIME)) && (!paramBoolean))
    {
      AppMethodBeat.o(219225);
      return;
    }
    this.kCb.remove(paramRUNTIME);
    this.kCb.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.kAt) == -1) {
      a(paramRUNTIME.kAt);
    }
    this.kCc.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(219225);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.c paramc)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((bsg()) && (bsf())) {
      i -= 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandRuntimeContainer", "attachRtViewToTree: name = [%s], index = [%d]", new Object[] { (String)paramc.getTag(), Integer.valueOf(i) });
      if (paramc.getParent() != null)
      {
        if (BuildInfo.DEBUG)
        {
          paramc = new IllegalArgumentException("runtimeLayout's parent should be null");
          AppMethodBeat.o(178511);
          throw paramc;
        }
        ((ViewGroup)paramc.getParent()).removeAllViews();
      }
      this.mContentView.addView(paramc, i);
      if ((this.kCh != null) && (this.kCh.getParent() == null))
      {
        this.mContentView.addView(this.kCh);
        this.mContentView.bringChildToFront(this.kCh);
      }
      getActiveRuntime().a(4, 1, new al()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(219219);
          boolean bool = false;
          if (AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this) != null) {
            bool = AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(219219);
          return bool;
        }
      });
      AppMethodBeat.o(178511);
      return;
      i = 0;
    }
  }
  
  private void bsb()
  {
    AppMethodBeat.i(177591);
    if (this.cVK != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.cVK);
      this.cVK = null;
    }
    bTY().release();
    this.kCd = null;
    AppMethodBeat.o(177591);
  }
  
  private boolean bsf()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.kCh != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean bsg()
  {
    return this.kCh != null;
  }
  
  private void g(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(219228);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      Log.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(219228);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (bsg()) {
      this.mContentView.bringChildToFront(this.kCh);
    }
    AppMethodBeat.o(219228);
  }
  
  private void x(final RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(219224);
    Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", new Object[] { paramRUNTIME.mAppId });
    final Runnable local11 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134544);
        Log.i("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", new Object[] { paramRUNTIME.mAppId });
        paramRUNTIME.dispatchDestroy();
        AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).removeView(paramRUNTIME.kAt);
        AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).remove(paramRUNTIME.mAppId);
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(paramRUNTIME);
        AppMethodBeat.o(134544);
      }
    };
    if (!v(paramRUNTIME))
    {
      Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramRUNTIME.mAppId });
      local11.run();
      AppMethodBeat.o(219224);
      return;
    }
    final AppBrandRuntime localAppBrandRuntime = u(paramRUNTIME);
    b(localAppBrandRuntime, paramRUNTIME, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176525);
        boolean bool = AppBrandRuntimeContainer.this.y(paramRUNTIME);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramRUNTIME.OU(), null);
        }
        local11.run();
        if ((bool) && (localAppBrandRuntime != null) && (AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this))) {
          localAppBrandRuntime.dispatchResume();
        }
        if (localAppBrandRuntime == null) {}
        for (String str = "null";; str = localAppBrandRuntime.mAppId)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
          AppMethodBeat.o(176525);
          return;
        }
      }
    });
    AppMethodBeat.o(219224);
  }
  
  private void z(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134561);
    this.kCb.remove(paramRUNTIME);
    this.kCb.push(paramRUNTIME);
    paramRUNTIME.kAt.setVisibility(0);
    g(paramRUNTIME.kAt);
    AppMethodBeat.o(134561);
  }
  
  public final void A(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.kCb.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  protected final void B(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(219227);
    if (paramRUNTIME == null)
    {
      AppMethodBeat.o(219227);
      return;
    }
    this.kCb.remove(paramRUNTIME);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.kCc.remove(paramRUNTIME.mAppId, paramRUNTIME);
      AppMethodBeat.o(219227);
      return;
    }
    this.kCc.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(219227);
  }
  
  public final RUNTIME Uh(String paramString)
  {
    AppMethodBeat.i(219223);
    Iterator localIterator = this.kCb.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(219223);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.kCc.get(paramString);
    AppMethodBeat.o(219223);
    return paramString;
  }
  
  public final void Ui(String paramString)
  {
    AppMethodBeat.i(219226);
    Iterator localIterator = this.kCb.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if ((paramString != null) && (paramString.equals(localAppBrandRuntime.mAppId)))
      {
        Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, exclude appId(%s)", new Object[] { paramString });
      }
      else
      {
        localIterator.remove();
        localAppBrandRuntime.kAt.setVisibility(8);
        this.kCc.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
        localAppBrandRuntime.brH();
        if (!localAppBrandRuntime.mInitialized)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", new Object[] { localAppBrandRuntime.mAppId });
          x(localAppBrandRuntime);
        }
        else if (localAppBrandRuntime.mResumed)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", new Object[] { localAppBrandRuntime.mAppId });
          localAppBrandRuntime.dispatchPause();
        }
      }
    }
    AppMethodBeat.o(219226);
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219229);
    super.a(paramInt, paramAppBrandRuntime);
    paramAppBrandRuntime = (View)paramAppBrandRuntime.kAt.getParent();
    if (paramAppBrandRuntime != null) {
      paramAppBrandRuntime.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(219229);
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.kAp = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.kCb.push(paramRUNTIME2);
    a(paramRUNTIME2.kAt);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.brd();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(219222);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(219222);
      return;
    }
    AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219220);
        n.J(AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.Ui(paramAppBrandInitConfig.appId);
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.Uh(paramAppBrandInitConfig.appId);
        if (localAppBrandRuntime == null)
        {
          localAppBrandRuntime = AppBrandRuntimeContainer.this.e(paramAppBrandInitConfig);
          AppBrandRuntimeContainer.this.a(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
          AppMethodBeat.o(219220);
          return;
        }
        AppBrandRuntimeContainer.this.b(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
        AppMethodBeat.o(219220);
      }
    });
    AppMethodBeat.o(219222);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(176531);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(176531);
      return;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
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
        if (!AppBrandRuntimeContainer.this.y(paramAppBrandRuntime))
        {
          Log.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134539);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.u(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.OU(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
          AppBrandRuntimeContainer.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176529);
              AppBrandRuntimeContainer.6.this.cBo.kAt.setVisibility(8);
              AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.6.this.cBo);
              AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.6.this.cBo.mAppId, AppBrandRuntimeContainer.6.this.cBo);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.6.this.cBo.dispatchPause();
              if ((AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.6.this.cBo.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                Log.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
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
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    a(paramRUNTIME2, false);
    z(paramRUNTIME2);
    paramRUNTIME2.kAp = paramRUNTIME1;
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
      Log.i("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { paramAppBrandRuntime1, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      AppMethodBeat.o(134550);
      return;
    }
  }
  
  public final boolean bsa()
  {
    return true;
  }
  
  public final boolean bsc()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.kCd.bsc();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  public final boolean bsd()
  {
    return this.kCf;
  }
  
  protected final LinkedList<RUNTIME> bse()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.kCb);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134563);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.kCb);
    ((LinkedList)localObject).addAll(this.kCc.values());
    Ui(null);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.kAO = false;
      w(localAppBrandRuntime);
    }
    Log.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    bsb();
    AppMethodBeat.o(134563);
  }
  
  public RUNTIME e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.bF(this.kCe).ak(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.kCb.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.kCb.size();
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
        Log.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", new Object[] { localException });
        MMHandlerThread.postToMainThread(new Runnable()
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
    if (this.kCb != null)
    {
      Iterator localIterator = this.kCb.iterator();
      while (localIterator.hasNext()) {
        ((AppBrandRuntime)localIterator.next()).onConfigurationChanged(paramConfiguration);
      }
    }
    AppMethodBeat.o(134557);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134555);
    Log.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134541);
        try
        {
          AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
          if (localAppBrandRuntime != null)
          {
            AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this, localAppBrandRuntime);
            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
            localAppBrandRuntime.dispatchResume();
          }
          AppMethodBeat.o(134541);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandRuntimeContainer", "doOnResume e=%s", new Object[] { localException });
          AppMethodBeat.o(134541);
        }
      }
    });
    AppMethodBeat.o(134555);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(219221);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(219221);
      return;
    }
    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null)
    {
      AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(paramRunnable);
      AppMethodBeat.o(219221);
      return;
    }
    Log.e("MicroMsg.AppBrandRuntimeContainer", "runOnUiThread getActivity()==null");
    new MMHandler(Looper.getMainLooper()).post(paramRunnable);
    AppMethodBeat.o(219221);
  }
  
  public final RUNTIME u(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134552);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(134552);
      throw paramAppBrandRuntime;
    }
    ListIterator localListIterator = this.kCb.listIterator();
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
  
  public final boolean v(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134554);
    boolean bool = this.kCb.contains(paramAppBrandRuntime);
    AppMethodBeat.o(134554);
    return bool;
  }
  
  public final void w(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134558);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134558);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134543);
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this, paramAppBrandRuntime);
        AppMethodBeat.o(134543);
      }
    });
    AppMethodBeat.o(134558);
  }
  
  protected final boolean y(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.kCb.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(134560);
      return true;
    }
    AppMethodBeat.o(134560);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */