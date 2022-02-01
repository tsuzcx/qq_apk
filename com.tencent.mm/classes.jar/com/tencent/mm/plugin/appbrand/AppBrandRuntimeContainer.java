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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.bb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime>
  extends o
  implements ap
{
  public FrameLayout mContentView;
  public final LinkedList<RUNTIME> qub;
  private final HashMap<String, RUNTIME> quc;
  public p qud;
  private Class<? extends RUNTIME> que;
  boolean quf;
  private boolean qug;
  public n quh;
  private Application.ActivityLifecycleCallbacks qui;
  private final ar quj;
  
  public AppBrandRuntimeContainer(p paramp, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(134545);
    this.quf = false;
    this.qug = false;
    this.quj = new ar()
    {
      public final boolean i(KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(317482);
        boolean bool = false;
        if (AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this) != null) {
          bool = AppBrandRuntimeContainer.g(AppBrandRuntimeContainer.this).j(paramAnonymousKeyEvent);
        }
        AppMethodBeat.o(317482);
        return bool;
      }
    };
    super.bm(paramp.getContext());
    this.qub = new LinkedList();
    this.quc = new HashMap();
    this.mContentView = paramp.cKf();
    this.qud = paramp;
    this.que = paramClass;
    this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(176524);
        Object localObject;
        int i;
        if ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).isShown()) && (z.ay(AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this))) && (Build.VERSION.SDK_INT >= 26) && ((AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).getWindowSystemUiVisibility() & 0x2) == 0))
        {
          localObject = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.getContext());
          if ((localObject != null) && (((Activity)localObject).getWindow() != null))
          {
            boolean bool = bb.aAF(((Activity)localObject).getWindow().getNavigationBarColor());
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
    paramp = com.tencent.mm.plugin.appbrand.platform.window.a.f.K(AndroidContextUtil.castActivityOrNull(this.mContext));
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      paramp.mFinished = false;
      paramp = (Application)getContext().getApplicationContext();
      paramClass = new com.tencent.mm.plugin.appbrand.af.a()
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
            AppBrandRuntimeContainer.this.cIb().onPause();
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
            AppBrandRuntimeContainer.this.cIb().onResume();
          }
          AppMethodBeat.o(176526);
        }
      };
      this.qui = paramClass;
      paramp.registerActivityLifecycleCallbacks(paramClass);
      AppMethodBeat.o(134545);
      return;
    }
    finally
    {
      AppMethodBeat.o(134545);
    }
  }
  
  private void B(final RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(316941);
    Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", new Object[] { paramRUNTIME.mAppId });
    final Runnable local11 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134544);
        Log.i("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", new Object[] { paramRUNTIME.mAppId });
        paramRUNTIME.a(AppBrandRuntimeContainer.f(AppBrandRuntimeContainer.this));
        paramRUNTIME.dispatchDestroy();
        AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this).removeView(paramRUNTIME.qsk);
        AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).remove(paramRUNTIME.mAppId);
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(paramRUNTIME);
        AppMethodBeat.o(134544);
      }
    };
    if (!z(paramRUNTIME))
    {
      Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramRUNTIME.mAppId });
      local11.run();
      AppMethodBeat.o(316941);
      return;
    }
    final AppBrandRuntime localAppBrandRuntime = y(paramRUNTIME);
    b(localAppBrandRuntime, paramRUNTIME, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176525);
        boolean bool;
        if ((AppBrandRuntimeContainer.this.C(paramRUNTIME)) || (AppBrandRuntimeContainer.this.cch()))
        {
          bool = true;
          if (localAppBrandRuntime != null) {
            localAppBrandRuntime.b(paramRUNTIME.asH(), null);
          }
          local11.run();
          if ((bool) && (localAppBrandRuntime != null))
          {
            localAppBrandRuntime.cbH();
            if (AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) {
              localAppBrandRuntime.dispatchResume();
            }
          }
          if (localAppBrandRuntime != null) {
            break label153;
          }
        }
        label153:
        for (String str = "null";; str = localAppBrandRuntime.mAppId)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
          AppMethodBeat.o(176525);
          return;
          bool = false;
          break;
        }
      }
    });
    AppMethodBeat.o(316941);
  }
  
  private void D(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134561);
    this.qub.remove(paramRUNTIME);
    this.qub.push(paramRUNTIME);
    paramRUNTIME.qsk.setVisibility(0);
    k(paramRUNTIME.qsk);
    AppMethodBeat.o(134561);
  }
  
  private void a(RUNTIME paramRUNTIME, boolean paramBoolean)
  {
    AppMethodBeat.i(316946);
    if ((this.qub.contains(paramRUNTIME)) && (!paramBoolean))
    {
      AppMethodBeat.o(316946);
      return;
    }
    this.qub.remove(paramRUNTIME);
    this.qub.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.qsk) == -1) {
      a(paramRUNTIME.qsk);
    }
    this.quc.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(316946);
  }
  
  private void a(e parame)
  {
    AppMethodBeat.i(178511);
    int i = this.mContentView.getChildCount();
    if ((ccl()) && (cck())) {
      i -= 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandRuntimeContainer", "attachRtViewToTree: name = [%s], index = [%d]", new Object[] { (String)parame.getTag(), Integer.valueOf(i) });
      if (parame.getParent() != null)
      {
        if (BuildInfo.DEBUG)
        {
          parame = new IllegalArgumentException("runtimeLayout's parent should be null");
          AppMethodBeat.o(178511);
          throw parame;
        }
        ((ViewGroup)parame.getParent()).removeAllViews();
      }
      this.mContentView.addView(parame, i);
      if ((this.quh != null) && (this.quh.getParent() == null))
      {
        this.mContentView.addView(this.quh);
        this.mContentView.bringChildToFront(this.quh);
      }
      getActiveRuntime().a(4, 1, this.quj);
      AppMethodBeat.o(178511);
      return;
      i = 0;
    }
  }
  
  private void cce()
  {
    AppMethodBeat.i(177591);
    if (this.qui != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.qui);
      this.qui = null;
    }
    cIb().release();
    this.qud = null;
    AppMethodBeat.o(177591);
  }
  
  private boolean cck()
  {
    AppMethodBeat.i(178513);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.quh != null)))
    {
      AppMethodBeat.o(178513);
      return true;
    }
    AppMethodBeat.o(178513);
    return false;
  }
  
  private boolean ccl()
  {
    return this.quh != null;
  }
  
  private void k(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(316955);
    if (this.mContentView.indexOfChild(paramViewGroup) == -1)
    {
      Log.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(316955);
      return;
    }
    this.mContentView.bringChildToFront(paramViewGroup);
    if (ccl()) {
      this.mContentView.bringChildToFront(this.quh);
    }
    AppMethodBeat.o(316955);
  }
  
  public final void A(final AppBrandRuntime paramAppBrandRuntime)
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
        com.tencent.luggage.l.f.bv(AppBrandRuntimeContainer.this.getContext());
        AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this, paramAppBrandRuntime);
        AppMethodBeat.o(134543);
      }
    });
    AppMethodBeat.o(134558);
  }
  
  protected final boolean C(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(134560);
    if (this.qub.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(134560);
      return true;
    }
    AppMethodBeat.o(134560);
    return false;
  }
  
  public final void E(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134564);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134564);
      return;
    }
    this.qub.remove(paramAppBrandRuntime);
    AppMethodBeat.o(134564);
  }
  
  protected final void F(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(317073);
    if (paramRUNTIME == null)
    {
      AppMethodBeat.o(317073);
      return;
    }
    paramRUNTIME.a(this.quj);
    this.qub.remove(paramRUNTIME);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.quc.remove(paramRUNTIME.mAppId, paramRUNTIME);
      AppMethodBeat.o(317073);
      return;
    }
    this.quc.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(317073);
  }
  
  public final RUNTIME Us(String paramString)
  {
    AppMethodBeat.i(317034);
    Iterator localIterator = this.qub.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if (localAppBrandRuntime.mAppId.equals(paramString))
      {
        AppMethodBeat.o(317034);
        return localAppBrandRuntime;
      }
    }
    paramString = (AppBrandRuntime)this.quc.get(paramString);
    AppMethodBeat.o(317034);
    return paramString;
  }
  
  public final void Ut(String paramString)
  {
    AppMethodBeat.i(317062);
    Iterator localIterator = this.qub.iterator();
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
        localAppBrandRuntime.qsk.setVisibility(8);
        this.quc.put(localAppBrandRuntime.mAppId, localAppBrandRuntime);
        localAppBrandRuntime.qsB.qKC.a(d.a.qLf);
        k.Ui(localAppBrandRuntime.mAppId);
        if (!localAppBrandRuntime.mInitialized)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", new Object[] { localAppBrandRuntime.mAppId });
          B(localAppBrandRuntime);
        }
        else if (localAppBrandRuntime.mResumed)
        {
          Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", new Object[] { localAppBrandRuntime.mAppId });
          localAppBrandRuntime.dispatchPause();
        }
      }
    }
    AppMethodBeat.o(317062);
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(317100);
    super.a(paramInt, paramAppBrandRuntime);
    paramAppBrandRuntime = (View)paramAppBrandRuntime.qsk.getParent();
    if (paramAppBrandRuntime != null) {
      paramAppBrandRuntime.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(317100);
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134546);
    paramRUNTIME2.qsg = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.qub.push(paramRUNTIME2);
    a(paramRUNTIME2.qsk);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.cbq();
    AppMethodBeat.o(134546);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(317006);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(317006);
      return;
    }
    AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317299);
        n.R(AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext));
        if (paramAppBrandRuntime == null) {
          AppBrandRuntimeContainer.this.Ut(paramAppBrandInitConfig.appId);
        }
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.Us(paramAppBrandInitConfig.appId);
        if (localAppBrandRuntime == null)
        {
          localAppBrandRuntime = AppBrandRuntimeContainer.this.e(paramAppBrandInitConfig);
          AppBrandRuntimeContainer.this.a(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
          AppMethodBeat.o(317299);
          return;
        }
        AppBrandRuntimeContainer.this.b(paramAppBrandRuntime, localAppBrandRuntime, paramAppBrandInitConfig);
        AppMethodBeat.o(317299);
      }
    });
    AppMethodBeat.o(317006);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(317017);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(317017);
      return;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(317017);
      return;
    }
    localActivity.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134539);
        if ((!AppBrandRuntimeContainer.this.C(paramAppBrandRuntime)) && (!AppBrandRuntimeContainer.this.cch()))
        {
          Log.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(134539);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.this.y(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.asH(), paramObject);
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
              AppBrandRuntimeContainer.6.this.esR.qsk.setVisibility(8);
              AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this).remove(AppBrandRuntimeContainer.6.this.esR);
              AppBrandRuntimeContainer.e(AppBrandRuntimeContainer.this).put(AppBrandRuntimeContainer.6.this.esR.mAppId, AppBrandRuntimeContainer.6.this.esR);
              if (localAppBrandRuntime != null)
              {
                AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, localAppBrandRuntime);
                AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, localAppBrandRuntime);
              }
              AppBrandRuntimeContainer.6.this.esR.dispatchPause();
              if ((AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = AppBrandRuntimeContainer.6.this.esR.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                Log.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this)) });
                if (AppBrandRuntimeContainer.6.this.val$callback != null) {
                  AppBrandRuntimeContainer.6.this.val$callback.run();
                }
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
    AppMethodBeat.o(317017);
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134548);
    a(paramRUNTIME2, false);
    D(paramRUNTIME2);
    paramRUNTIME2.cbH();
    paramRUNTIME2.qsg = paramRUNTIME1;
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
  
  public final boolean ccd()
  {
    return true;
  }
  
  public final boolean ccf()
  {
    AppMethodBeat.i(176530);
    boolean bool = this.qud.ccf();
    AppMethodBeat.o(176530);
    return bool;
  }
  
  public final boolean ccg()
  {
    return this.qug;
  }
  
  protected boolean cch()
  {
    return false;
  }
  
  protected final Iterator<RUNTIME> cci()
  {
    AppMethodBeat.i(317070);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.qub);
    ((LinkedList)localObject).addAll(this.quc.values());
    localObject = ((LinkedList)localObject).iterator();
    AppMethodBeat.o(317070);
    return localObject;
  }
  
  protected final LinkedList<RUNTIME> ccj()
  {
    AppMethodBeat.i(134565);
    LinkedList localLinkedList = new LinkedList(this.qub);
    AppMethodBeat.o(134565);
    return localLinkedList;
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134563);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.qub);
    ((LinkedList)localObject).addAll(this.quc.values());
    Ut(null);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)((Iterator)localObject).next();
      localAppBrandRuntime.qsK = false;
      A(localAppBrandRuntime);
    }
    Log.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    cce();
    AppMethodBeat.o(134563);
  }
  
  public RUNTIME e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(134547);
    paramAppBrandInitConfig = (AppBrandRuntime)org.a.a.cQ(this.que).av(new Object[] { this }).object;
    AppMethodBeat.o(134547);
    return paramAppBrandInitConfig;
  }
  
  public RUNTIME getActiveRuntime()
  {
    AppMethodBeat.i(134551);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.qub.peek();
    AppMethodBeat.o(134551);
    return localAppBrandRuntime;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(185921);
    int i = this.qub.size();
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
    if (this.qub != null)
    {
      Iterator localIterator = this.qub.iterator();
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
  
  protected void onStop() {}
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(316992);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(316992);
      return;
    }
    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null)
    {
      AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(paramRunnable);
      AppMethodBeat.o(316992);
      return;
    }
    Log.e("MicroMsg.AppBrandRuntimeContainer", "runOnUiThread getActivity()==null");
    new MMHandler(Looper.getMainLooper()).post(paramRunnable);
    AppMethodBeat.o(316992);
  }
  
  public final RUNTIME y(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134552);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(134552);
      throw paramAppBrandRuntime;
    }
    ListIterator localListIterator = this.qub.listIterator();
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
  
  public final boolean z(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134554);
    boolean bool = this.qub.contains(paramAppBrandRuntime);
    AppMethodBeat.o(134554);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */