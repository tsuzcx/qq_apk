package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.task.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.au;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime>
  extends o
  implements ak
{
  public FrameLayout mContentView;
  public final LinkedList<RUNTIME> nvp;
  private final HashMap<String, RUNTIME> nvq;
  public q nvr;
  private Class<? extends RUNTIME> nvs;
  private boolean nvt;
  private boolean nvu;
  public n nvv;
  private Application.ActivityLifecycleCallbacks nvw;
  private final am nvx;
  
  public AppBrandRuntimeContainer(q paramq, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.nvt = false;
    this.nvu = false;
    this.nvx = new am()
    {
      public final boolean d(KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(244847);
        boolean bool = false;
        if (AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this) != null) {
          bool = AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this).e(paramAnonymousKeyEvent);
        }
        AppMethodBeat.o(244847);
        return bool;
      }
    };
    super.aD(paramq.getContext());
    this.nvp = new LinkedList();
    this.nvq = new HashMap();
    this.mContentView = paramq.cjf();
    this.nvr = paramq;
    this.nvs = paramClass;
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(176524);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).isShown()) && (w.al(AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = au.auk(((Activity)localObject).getWindow().getNavigationBarColor());
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
    paramq = com.tencent.mm.plugin.appbrand.platform.window.a.g.E(AndroidContextUtil.castActivityOrNull(this.mContext));
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramq.mFinished = false;
      paramq = (Application)getContext().getApplicationContext();
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
            AppBrandRuntimeContainer.this.che().onPause();
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
            AppBrandRuntimeContainer.this.che().onResume();
          }
          AppMethodBeat.o(176526);
        }
      };
      this.nvw = paramClass;
      paramq.registerActivityLifecycleCallbacks(paramClass);
      AppMethodBeat.o(134545);
      return;
    }
    finally
    {
      AppMethodBeat.o(134545);
    }
  }
  
  private void B(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134561);
    this.nvp.remove(paramRUNTIME);
    this.nvp.push(paramRUNTIME);
    paramRUNTIME.ntC.setVisibility(0);
    h(paramRUNTIME.ntC);
    AppMethodBeat.o(134561);
  }
  
  private void a(RUNTIME paramRUNTIME, boolean paramBoolean)
  {
    AppMethodBeat.i(245199);
    if ((this.nvp.contains(paramRUNTIME)) && (!paramBoolean))
    {
      AppMethodBeat.o(245199);
      return;
    }
    this.nvp.remove(paramRUNTIME);
    this.nvp.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.ntC) == -1) {
      a(paramRUNTIME.ntC);
    }
    this.nvq.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(245199);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((bCY()) && (bCX())) {
      i -= 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandRuntimeContainer", "attachRtViewToTree: name = [%s], index = [%d]", new Object[] { (String)paramd.getTag(), Integer.valueOf(i) });
      if (paramd.getParent() != null)
      {
        if (BuildInfo.DEBUG)
        {
          paramd = new IllegalArgumentException("runtimeLayout's parent should be null");
          AppMethodBeat.o(178511);
          throw paramd;
        }
        ((ViewGroup)paramd.getParent()).removeAllViews();
      }
      this.mContentView.addView(paramd, i);
      if ((this.nvv != null) && (this.nvv.getParent() == null))
      {
        this.mContentView.addView(this.nvv);
        this.mContentView.bringChildToFront(this.nvv);
      }
      getActiveRuntime().a(4, 1, this.nvx);
      AppMethodBeat.o(178511);
      return;
      i = 0;
    }
  }
  
  private void bCR()
  {
    AppMethodBeat.i(177591);
    if (this.nvw != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.nvw);
      this.nvw = null;
    }
    che().release();
    this.nvr = null;
    AppMethodBeat.o(177591);
  }
  
  private boolean bCX()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.nvv != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean bCY()
  {
    return this.nvv != null;
  }
  
  private void h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(245212);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      Log.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(245212);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (bCY()) {
      this.mContentView.bringChildToFront(this.nvv);
    }
    AppMethodBeat.o(245212);
  }
  
  private void z(final RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(245190);
    Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", new Object[] { paramRUNTIME.mAppId });
    final Runnable local11 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134544);
        Log.i("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", new Object[] { paramRUNTIME.mAppId });
        paramRUNTIME.a(AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this));
        paramRUNTIME.dispatchDestroy();
        AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).removeView(paramRUNTIME.ntC);
        AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).remove(paramRUNTIME.mAppId);
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(paramRUNTIME);
        AppMethodBeat.o(134544);
      }
    };
    if (!x(paramRUNTIME))
    {
      Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramRUNTIME.mAppId });
      local11.run();
      AppMethodBeat.o(245190);
      return;
    }
    final AppBrandRuntime localAppBrandRuntime = w(paramRUNTIME);
    b(localAppBrandRuntime, paramRUNTIME, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176525);
        boolean bool = AppBrandRuntimeContainer.this.A(paramRUNTIME);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramRUNTIME.Sq(), null);
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
    AppMethodBeat.o(245190);
  }
  
  protected final boolean A(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.nvp.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(134560);
      return true;
    }
    AppMethodBeat.o(134560);
    return false;
  }
  
  public final void C(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.nvp.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  protected final void D(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(245207);
    if (paramRUNTIME == null)
    {
      AppMethodBeat.o(245207);
      return;
    }
    paramRUNTIME.a(this.nvx);
    this.nvp.remove(paramRUNTIME);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.nvq.remove(paramRUNTIME.mAppId, paramRUNTIME);
      AppMethodBeat.o(245207);
      return;
    }
    this.nvq.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(245207);
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(245215);
    super.a(paramInt, paramAppBrandRuntime);
    paramAppBrandRuntime = (View)paramAppBrandRuntime.ntC.getParent();
    if (paramAppBrandRuntime != null) {
      paramAppBrandRuntime.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(245215);
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.nty = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.nvp.push(paramRUNTIME2);
    a(paramRUNTIME2.ntC);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.bBT();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(245159);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(245159);
      return;
    }
    AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245726);
        n.J(AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.abR(paramAppBrandInitConfig.appId);
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.abQ(paramAppBrandInitConfig.appId);
        if (localAppBrandRuntime == null)
        {
          localAppBrandRuntime = AppBrandRuntimeContainer.this.e(paramAppBrandInitConfig);
          AppBrandRuntimeContainer.this.a(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
          AppMethodBeat.o(245726);
          return;
        }
        AppBrandRuntimeContainer.this.b(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
        AppMethodBeat.o(245726);
      }
    });
    AppMethodBeat.o(245159);
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
        if (!AppBrandRuntimeContainer.this.A(paramAppBrandRuntime))
        {
          Log.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134539);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.w(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Sq(), paramObject);
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
              AppBrandRuntimeContainer.6.this.cAw.ntC.setVisibility(8);
              AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.6.this.cAw);
              AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.6.this.cAw.mAppId, AppBrandRuntimeContainer.6.this.cAw);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.6.this.cAw.dispatchPause();
              if ((AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.6.this.cAw.mAppId;
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
  
  public final RUNTIME abQ(String paramString)
  {
    AppMethodBeat.i(245177);
    Iterator localIterator = this.nvp.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(245177);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.nvq.get(paramString);
    AppMethodBeat.o(245177);
    return paramString;
  }
  
  public final void abR(String paramString)
  {
    AppMethodBeat.i(245201);
    Iterator localIterator = this.nvp.iterator();
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
        localAppBrandRuntime.ntC.setVisibility(8);
        this.nvq.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
        localAppBrandRuntime.ntR.nKU.a(d.a.nLv);
        k.abG(localAppBrandRuntime.mAppId);
        if (!localAppBrandRuntime.mInitialized)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", new Object[] { localAppBrandRuntime.mAppId });
          z(localAppBrandRuntime);
        }
        else if (localAppBrandRuntime.mResumed)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", new Object[] { localAppBrandRuntime.mAppId });
          localAppBrandRuntime.dispatchPause();
        }
      }
    }
    AppMethodBeat.o(245201);
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    a(paramRUNTIME2, false);
    B(paramRUNTIME2);
    paramRUNTIME2.nty = paramRUNTIME1;
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
  
  public final boolean bCQ()
  {
    return true;
  }
  
  public final boolean bCS()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.nvr.bCS();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  public final boolean bCT()
  {
    return this.nvt;
  }
  
  public final boolean bCU()
  {
    return this.nvu;
  }
  
  protected final Iterator<RUNTIME> bCV()
  {
    AppMethodBeat.i(245206);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.nvp);
    ((LinkedList)localObject).addAll(this.nvq.values());
    localObject = ((LinkedList)localObject).iterator();
    AppMethodBeat.o(245206);
    return localObject;
  }
  
  protected final LinkedList<RUNTIME> bCW()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.nvp);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134563);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.nvp);
    ((LinkedList)localObject).addAll(this.nvq.values());
    abR(null);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.nua = false;
      y(localAppBrandRuntime);
    }
    Log.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    bCR();
    AppMethodBeat.o(134563);
  }
  
  public RUNTIME e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.ce(this.nvs).ao(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.nvp.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.nvp.size();
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
    if (this.nvp != null)
    {
      Iterator localIterator = this.nvp.iterator();
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
          Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainer", localException, "doOnResume e=%s", new Object[] { localException });
          AppMethodBeat.o(134541);
        }
      }
    });
    AppMethodBeat.o(134555);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(245154);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(245154);
      return;
    }
    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null)
    {
      AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(paramRunnable);
      AppMethodBeat.o(245154);
      return;
    }
    Log.e("MicroMsg.AppBrandRuntimeContainer", "runOnUiThread getActivity()==null");
    new MMHandler(Looper.getMainLooper()).post(paramRunnable);
    AppMethodBeat.o(245154);
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
    ListIterator localListIterator = this.nvp.listIterator();
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
    boolean bool = this.nvp.contains(paramAppBrandRuntime);
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
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134543);
        com.tencent.luggage.k.g.aK(AppBrandRuntimeContainer.this.getContext());
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this, paramAppBrandRuntime);
        AppMethodBeat.o(134543);
      }
    });
    AppMethodBeat.o(134558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */