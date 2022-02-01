package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.c.a;
import com.tencent.mm.plugin.appbrand.r.a.c.b;
import com.tencent.mm.plugin.appbrand.r.a.c.c;
import com.tencent.mm.plugin.appbrand.r.a.c.d;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class l<RUNTIME extends AppBrandRuntime>
  extends FrameLayout
  implements ai, c
{
  private Context context;
  private boolean jyA;
  private final n jyB;
  final Map<String, RUNTIME> jyC;
  private e jyD;
  final LinkedList<RUNTIME> jyh;
  final Class<? extends RUNTIME> jyk;
  private final FrameLayout mContentView;
  private boolean mResumed;
  
  private void A(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(197238);
    this.jyh.remove(paramRUNTIME);
    this.jyh.push(paramRUNTIME);
    paramRUNTIME.jwJ.setVisibility(0);
    b(paramRUNTIME.jwJ);
    AppMethodBeat.o(197238);
  }
  
  private void B(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(197244);
    if (this.jyh.contains(paramRUNTIME))
    {
      AppMethodBeat.o(197244);
      return;
    }
    this.jyh.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.jwJ) == -1) {
      a(paramRUNTIME.jwJ);
    }
    this.jyC.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(197244);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(197242);
    int i = this.mContentView.getChildCount();
    if ((aWE()) && (aWD())) {
      i -= 1;
    }
    for (;;)
    {
      ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramd.getTag(), Integer.valueOf(i) });
      this.mContentView.addView(paramd, i);
      aWL();
      aWK();
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(197228);
          boolean bool = false;
          if (l.a(l.this) != null) {
            bool = l.a(l.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(197228);
          return bool;
        }
      });
      AppMethodBeat.o(197242);
      return;
      i = 0;
    }
  }
  
  private boolean aWD()
  {
    AppMethodBeat.i(197243);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.jyB != null)))
    {
      AppMethodBeat.o(197243);
      return true;
    }
    AppMethodBeat.o(197243);
    return false;
  }
  
  private boolean aWE()
  {
    return this.jyB != null;
  }
  
  private void aWK()
  {
    AppMethodBeat.i(197240);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197227);
          l.f(l.this);
          AppMethodBeat.o(197227);
        }
      });
      AppMethodBeat.o(197240);
      return;
    }
    if (this.jyA) {
      this.mContentView.setPadding(0, 0, 0, 0);
    }
    if (aWN()) {}
    for (c.a locala = getWindowCompatInfo();; locala = moE)
    {
      this.mContentView.setPadding(locala.l, locala.t, locala.r, locala.b);
      AppMethodBeat.o(197240);
      return;
    }
  }
  
  private void aWL()
  {
    AppMethodBeat.i(197241);
    this.mContentView.setBackgroundColor(getResources().getColor(2131099651));
    AppMethodBeat.o(197241);
  }
  
  private void b(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(197239);
    if (this.mContentView.indexOfChild(paramd) == -1)
    {
      ad.w("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(197239);
      return;
    }
    this.mContentView.bringChildToFront(paramd);
    if (aWE()) {
      this.mContentView.bringChildToFront(this.jyB);
    }
    aWK();
    aWL();
    AppMethodBeat.o(197239);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(197229);
    if (aq.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(197229);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(197229);
  }
  
  public final void C(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197245);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(197245);
      return;
    }
    this.jyh.remove(paramAppBrandRuntime);
    AppMethodBeat.o(197245);
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d a(d.b paramb)
  {
    AppMethodBeat.i(197253);
    paramb = (com.tencent.mm.plugin.appbrand.r.a.d)com.tencent.mm.plugin.appbrand.utils.l.g("Luggage.WXA.WindowFullscreenHandler.Dummy", com.tencent.mm.plugin.appbrand.r.a.d.class);
    AppMethodBeat.o(197253);
    return paramb;
  }
  
  protected final void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(197232);
    paramRUNTIME2.jwF = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.jyh.push(paramRUNTIME2);
    a(paramRUNTIME2.jwJ);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aVJ();
    AppMethodBeat.o(197232);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(197231);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(197231);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197221);
        l.a(l.this).bEn();
        Object localObject1;
        if (paramAppBrandRuntime == null)
        {
          localObject1 = l.this;
          localObject2 = ((l)localObject1).jyh.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandRuntime)((Iterator)localObject2).next();
            ((AppBrandRuntime)localObject3).jwJ.setVisibility(8);
            ((l)localObject1).jyC.put(((AppBrandRuntime)localObject3).mAppId, localObject3);
            ((AppBrandRuntime)localObject3).aWj();
          }
          ((l)localObject1).jyh.clear();
        }
        Object localObject2 = l.this;
        Object localObject3 = paramAppBrandInitConfig.appId;
        Iterator localIterator = ((l)localObject2).jyh.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (AppBrandRuntime)localIterator.next();
        } while (!((AppBrandRuntime)localObject1).mAppId.equals(localObject3));
        while (localObject1 == null)
        {
          localObject1 = l.this;
          localObject1 = (AppBrandRuntime)org.a.a.bF(((l)localObject1).jyk).aj(new Object[] { localObject1 }).object;
          l.this.a(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
          AppMethodBeat.o(197221);
          return;
          localObject1 = (AppBrandRuntime)((l)localObject2).jyC.get(localObject3);
        }
        l.this.b(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
        AppMethodBeat.o(197221);
      }
    });
    AppMethodBeat.o(197231);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(197234);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(197234);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197223);
        if (!l.this.z(paramAppBrandRuntime))
        {
          ad.e("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(197223);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = l.this.w(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Fi(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close before run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(l.b(l.this)) });
          l.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197222);
              if (localAppBrandRuntime != null)
              {
                l.2.this.jyv.jwJ.setVisibility(8);
                l.c(l.this).remove(l.2.this.jyv);
                l.d(l.this).put(l.2.this.jyv.mAppId, l.2.this.jyv);
                l.a(l.this, localAppBrandRuntime);
                l.b(l.this, localAppBrandRuntime);
              }
              l.2.this.jyv.dispatchPause();
              if ((l.b(l.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = l.2.this.jyv.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(l.b(l.this)) });
                AppMethodBeat.o(197222);
                return;
              }
            }
          });
          AppMethodBeat.o(197223);
          return;
        }
      }
    });
    AppMethodBeat.o(197234);
  }
  
  public final boolean aWA()
  {
    return false;
  }
  
  public final boolean aWM()
  {
    return false;
  }
  
  public final boolean aWN()
  {
    return !this.jyA;
  }
  
  protected final void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(197233);
    B(paramRUNTIME2);
    A(paramRUNTIME2);
    paramRUNTIME2.jwF = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.dispatchPause();
      paramRUNTIME2.dispatchResume();
    }
    AppMethodBeat.o(197233);
  }
  
  protected void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(197230);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if ((localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed()))
      {
        localAppBrandRuntime.onBackPressed();
        AppMethodBeat.o(197230);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(197230);
    return bool;
  }
  
  public final void fA(boolean paramBoolean) {}
  
  public AppBrandRuntime getActiveRuntime()
  {
    AppMethodBeat.i(197249);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.jyh.peek();
    AppMethodBeat.o(197249);
    return localAppBrandRuntime;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(197235);
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(this.context);
    AppMethodBeat.o(197235);
    return localActivity;
  }
  
  public c.c getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    AppMethodBeat.i(197252);
    if (this.jyD == null) {
      this.jyD = new ac(this);
    }
    e locale = this.jyD;
    AppMethodBeat.o(197252);
    return locale;
  }
  
  public Rect getSafeAreaInsets()
  {
    return null;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(197246);
    int i = this.jyh.size();
    AppMethodBeat.o(197246);
    return i;
  }
  
  public c.d getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(197250);
    Object localObject = getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    localObject = getWindowCompatInfo();
    localDisplayMetrics.widthPixels = (getWidth() - ((c.a)localObject).l - ((c.a)localObject).r);
    localDisplayMetrics.heightPixels = (getHeight() - ((c.a)localObject).t - ((c.a)localObject).b);
    AppMethodBeat.o(197250);
    return localDisplayMetrics;
  }
  
  public c getWindowAndroid()
  {
    return this;
  }
  
  public int getWindowColor()
  {
    return -1;
  }
  
  public c.a getWindowCompatInfo()
  {
    AppMethodBeat.i(197251);
    if (!aWN())
    {
      localObject = moE;
      AppMethodBeat.o(197251);
      return localObject;
    }
    Object localObject = new Point();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
    ad.v("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "getWindowCompatInfo: android orientation = [%d]", new Object[] { Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    double d = ((Point)localObject).y / 1.777777777777778D;
    int i = (int)((((Point)localObject).x - d) / 2.0D);
    localObject = new c.a(i, i);
    AppMethodBeat.o(197251);
    return localObject;
  }
  
  public void setResizeable(boolean paramBoolean)
  {
    AppMethodBeat.i(197254);
    this.jyA = paramBoolean;
    aWK();
    AppMethodBeat.o(197254);
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.b paramb) {}
  
  public final RUNTIME w(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197248);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(197248);
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
        AppMethodBeat.o(197248);
        return localAppBrandRuntime;
      }
    }
    if (i == 0)
    {
      paramAppBrandRuntime = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramAppBrandRuntime.mAppId }));
      AppMethodBeat.o(197248);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(197248);
    return null;
  }
  
  public final boolean x(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197247);
    boolean bool = this.jyh.contains(paramAppBrandRuntime);
    AppMethodBeat.o(197247);
    return bool;
  }
  
  public final void y(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197236);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(197236);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197226);
        ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        Object localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197224);
            ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { l.3.this.cpm.mAppId });
            if (l.3.this.cpm.mResumed) {
              l.3.this.cpm.dispatchPause();
            }
            l.3.this.cpm.dispatchDestroy();
            l.e(l.this).removeView(l.3.this.cpm.jwJ);
            l.d(l.this).remove(l.3.this.cpm.mAppId);
            l.c(l.this).remove(l.3.this.cpm);
            AppMethodBeat.o(197224);
          }
        };
        if (!l.this.x(paramAppBrandRuntime))
        {
          ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramAppBrandRuntime.mAppId });
          ((Runnable)localObject).run();
          AppMethodBeat.o(197226);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = l.this.w(paramAppBrandRuntime);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197225);
            boolean bool = l.this.z(l.3.this.cpm);
            if (localAppBrandRuntime != null) {
              localAppBrandRuntime.b(l.3.this.cpm.Fi(), null);
            }
            this.jys.run();
            if ((bool) && (localAppBrandRuntime != null) && (l.b(l.this))) {
              localAppBrandRuntime.dispatchResume();
            }
            if (localAppBrandRuntime == null) {}
            for (String str = "null";; str = localAppBrandRuntime.mAppId)
            {
              ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(l.b(l.this)) });
              AppMethodBeat.o(197225);
              return;
            }
          }
        };
        l.this.b(localAppBrandRuntime, paramAppBrandRuntime, (Runnable)localObject);
        AppMethodBeat.o(197226);
      }
    });
    AppMethodBeat.o(197236);
  }
  
  protected final boolean z(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(197237);
    if (this.jyh.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(197237);
      return true;
    }
    AppMethodBeat.o(197237);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */