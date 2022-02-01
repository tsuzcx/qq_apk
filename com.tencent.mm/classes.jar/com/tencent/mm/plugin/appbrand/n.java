package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.b;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import org.a.a;

@SuppressLint({"ViewConstructor"})
public class n<RUNTIME extends AppBrandRuntime>
  extends FrameLayout
  implements ak, com.tencent.mm.plugin.appbrand.platform.window.c
{
  private Context context;
  final LinkedList<RUNTIME> kCb;
  final Class<? extends RUNTIME> kCe;
  private boolean kCq;
  private final com.tencent.mm.plugin.appbrand.widget.input.n kCr;
  final Map<String, RUNTIME> kCs;
  private e kCt;
  n<RUNTIME>.a kCu;
  private final FrameLayout mContentView;
  private boolean mResumed;
  
  private void C(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(219254);
    if (this.kCb.contains(paramRUNTIME))
    {
      AppMethodBeat.o(219254);
      return;
    }
    this.kCb.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.kAt) == -1) {
      a(paramRUNTIME.kAt);
    }
    this.kCs.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(219254);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.c paramc)
  {
    AppMethodBeat.i(219252);
    int i = this.mContentView.getChildCount();
    if ((bsg()) && (bsf())) {
      i -= 1;
    }
    for (;;)
    {
      Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramc.getTag(), Integer.valueOf(i) });
      this.mContentView.addView(paramc, i);
      bsi();
      bsh();
      getActiveRuntime().a(4, 1, new al()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(219238);
          boolean bool = false;
          if (n.a(n.this) != null) {
            bool = n.a(n.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(219238);
          return bool;
        }
      });
      AppMethodBeat.o(219252);
      return;
      i = 0;
    }
  }
  
  private void b(com.tencent.mm.plugin.appbrand.widget.c paramc)
  {
    AppMethodBeat.i(219249);
    if (this.mContentView.indexOfChild(paramc) == -1)
    {
      Log.w("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(219249);
      return;
    }
    this.mContentView.bringChildToFront(paramc);
    if (bsg()) {
      this.mContentView.bringChildToFront(this.kCr);
    }
    bsh();
    bsi();
    AppMethodBeat.o(219249);
  }
  
  private boolean bsf()
  {
    AppMethodBeat.i(219253);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.kCr != null)))
    {
      AppMethodBeat.o(219253);
      return true;
    }
    AppMethodBeat.o(219253);
    return false;
  }
  
  private boolean bsg()
  {
    return this.kCr != null;
  }
  
  private void bsh()
  {
    AppMethodBeat.i(219250);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219237);
          n.f(n.this);
          AppMethodBeat.o(219237);
        }
      });
      AppMethodBeat.o(219250);
      return;
    }
    if (this.kCq) {
      this.mContentView.setPadding(0, 0, 0, 0);
    }
    a locala = this.kCu;
    this.mContentView.setPadding(locala.l, locala.t, locala.r, locala.b);
    AppMethodBeat.o(219250);
  }
  
  private void bsi()
  {
    AppMethodBeat.i(219251);
    this.mContentView.setBackgroundColor(getResources().getColor(2131099651));
    AppMethodBeat.o(219251);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(219239);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(219239);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(219239);
  }
  
  private void z(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(219248);
    this.kCb.remove(paramRUNTIME);
    this.kCb.push(paramRUNTIME);
    paramRUNTIME.kAt.setVisibility(0);
    b(paramRUNTIME.kAt);
    AppMethodBeat.o(219248);
  }
  
  public final void A(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219255);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(219255);
      return;
    }
    this.kCb.remove(paramAppBrandRuntime);
    AppMethodBeat.o(219255);
  }
  
  public final boolean OD()
  {
    return false;
  }
  
  public boolean OG()
  {
    return false;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(219262);
    paramb = (d)m.g("Luggage.WXA.WindowFullscreenHandler.Dummy", d.class);
    AppMethodBeat.o(219262);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime) {}
  
  protected final void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(219242);
    paramRUNTIME2.kAp = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.kCb.push(paramRUNTIME2);
    a(paramRUNTIME2.kAt);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.brd();
    AppMethodBeat.o(219242);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(219241);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(219241);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219231);
        n.a(n.this).cbu();
        Object localObject1;
        if (paramAppBrandRuntime == null)
        {
          localObject1 = n.this;
          localObject2 = ((n)localObject1).kCb.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandRuntime)((Iterator)localObject2).next();
            ((AppBrandRuntime)localObject3).kAt.setVisibility(8);
            ((n)localObject1).kCs.put(((AppBrandRuntime)localObject3).mAppId, localObject3);
            ((AppBrandRuntime)localObject3).brH();
          }
          ((n)localObject1).kCb.clear();
        }
        Object localObject2 = n.this;
        Object localObject3 = paramAppBrandInitConfig.appId;
        Iterator localIterator = ((n)localObject2).kCb.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (AppBrandRuntime)localIterator.next();
        } while (!((AppBrandRuntime)localObject1).mAppId.equals(localObject3));
        while (localObject1 == null)
        {
          localObject1 = n.this;
          localObject1 = (AppBrandRuntime)a.bF(((n)localObject1).kCe).ak(new Object[] { localObject1 }).object;
          n.this.a(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
          AppMethodBeat.o(219231);
          return;
          localObject1 = (AppBrandRuntime)((n)localObject2).kCs.get(localObject3);
        }
        n.this.b(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
        AppMethodBeat.o(219231);
      }
    });
    AppMethodBeat.o(219241);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(219244);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(219244);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219233);
        if (!n.this.y(paramAppBrandRuntime))
        {
          Log.e("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(219233);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = n.this.u(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.OU(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close before run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(n.b(n.this)) });
          n.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219232);
              if (localAppBrandRuntime != null)
              {
                n.2.this.cBo.kAt.setVisibility(8);
                n.c(n.this).remove(n.2.this.cBo);
                n.d(n.this).put(n.2.this.cBo.mAppId, n.2.this.cBo);
                n.a(n.this, localAppBrandRuntime);
                n.b(n.this, localAppBrandRuntime);
              }
              n.2.this.cBo.dispatchPause();
              if ((n.b(n.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = n.2.this.cBo.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(n.b(n.this)) });
                AppMethodBeat.o(219232);
                return;
              }
            }
          });
          AppMethodBeat.o(219233);
          return;
        }
      }
    });
    AppMethodBeat.o(219244);
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime) {}
  
  protected final void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(219243);
    C(paramRUNTIME2);
    z(paramRUNTIME2);
    paramRUNTIME2.kAp = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.dispatchPause();
      paramRUNTIME2.dispatchResume();
    }
    AppMethodBeat.o(219243);
  }
  
  protected void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable) {}
  
  public final boolean bsc()
  {
    return false;
  }
  
  public final boolean bsj()
  {
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(219240);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if ((localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed()))
      {
        localAppBrandRuntime.onBackPressed();
        AppMethodBeat.o(219240);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(219240);
    return bool;
  }
  
  public AppBrandRuntime getActiveRuntime()
  {
    AppMethodBeat.i(219259);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.kCb.peek();
    AppMethodBeat.o(219259);
    return localAppBrandRuntime;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(219245);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.context);
    AppMethodBeat.o(219245);
    return localActivity;
  }
  
  public c.b getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    AppMethodBeat.i(219261);
    if (this.kCt == null) {
      this.kCt = new ad(this);
    }
    e locale = this.kCt;
    AppMethodBeat.o(219261);
    return locale;
  }
  
  public Rect getSafeAreaInsets()
  {
    return null;
  }
  
  public float getScale()
  {
    return 1.0F;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(219256);
    int i = this.kCb.size();
    AppMethodBeat.o(219256);
    return i;
  }
  
  public c.c getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(219260);
    Object localObject = getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    localObject = getWindowCompatInfo();
    localDisplayMetrics.widthPixels = (getWidth() - ((a)localObject).l - ((a)localObject).r);
    localDisplayMetrics.heightPixels = (getHeight() - ((a)localObject).t - ((a)localObject).b);
    AppMethodBeat.o(219260);
    return localDisplayMetrics;
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this;
  }
  
  public n<RUNTIME>.a getWindowCompatInfo()
  {
    return this.kCu;
  }
  
  public final boolean isInMultiWindowMode()
  {
    return false;
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.a parama) {}
  
  public final RUNTIME u(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219258);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(219258);
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
        AppMethodBeat.o(219258);
        return localAppBrandRuntime;
      }
    }
    if (i == 0)
    {
      paramAppBrandRuntime = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramAppBrandRuntime.mAppId }));
      AppMethodBeat.o(219258);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(219258);
    return null;
  }
  
  public final boolean v(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219257);
    boolean bool = this.kCb.contains(paramAppBrandRuntime);
    AppMethodBeat.o(219257);
    return bool;
  }
  
  public final void w(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219246);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(219246);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219236);
        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        Object localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219234);
            Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { n.3.this.cCi.mAppId });
            if (n.3.this.cCi.mResumed) {
              n.3.this.cCi.dispatchPause();
            }
            n.3.this.cCi.dispatchDestroy();
            n.e(n.this).removeView(n.3.this.cCi.kAt);
            n.d(n.this).remove(n.3.this.cCi.mAppId);
            n.c(n.this).remove(n.3.this.cCi);
            AppMethodBeat.o(219234);
          }
        };
        if (!n.this.v(paramAppBrandRuntime))
        {
          Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramAppBrandRuntime.mAppId });
          ((Runnable)localObject).run();
          AppMethodBeat.o(219236);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = n.this.u(paramAppBrandRuntime);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219235);
            boolean bool = n.this.y(n.3.this.cCi);
            if (localAppBrandRuntime != null) {
              localAppBrandRuntime.b(n.3.this.cCi.OU(), null);
            }
            this.kCk.run();
            if ((bool) && (localAppBrandRuntime != null) && (n.b(n.this))) {
              localAppBrandRuntime.dispatchResume();
            }
            if (localAppBrandRuntime == null) {}
            for (String str = "null";; str = localAppBrandRuntime.mAppId)
            {
              Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(n.b(n.this)) });
              AppMethodBeat.o(219235);
              return;
            }
          }
        };
        n.this.b(localAppBrandRuntime, paramAppBrandRuntime, (Runnable)localObject);
        AppMethodBeat.o(219236);
      }
    });
    AppMethodBeat.o(219246);
  }
  
  protected final boolean y(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(219247);
    if (this.kCb.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(219247);
      return true;
    }
    AppMethodBeat.o(219247);
    return false;
  }
  
  final class a
  {
    public final int b;
    public final int l;
    public final int r;
    public final int t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */