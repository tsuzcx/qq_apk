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
import com.tencent.mm.sdk.platformtools.ap;
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
  final LinkedList<RUNTIME> jfa;
  final Class<? extends RUNTIME> jfd;
  private boolean jfu;
  private final n jfv;
  final Map<String, RUNTIME> jfw;
  private e jfx;
  private final FrameLayout mContentView;
  private boolean mResumed;
  
  private void D(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(193354);
    this.jfa.remove(paramRUNTIME);
    this.jfa.push(paramRUNTIME);
    paramRUNTIME.jdA.setVisibility(0);
    b(paramRUNTIME.jdA);
    AppMethodBeat.o(193354);
  }
  
  private void E(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(193360);
    if (this.jfa.contains(paramRUNTIME))
    {
      AppMethodBeat.o(193360);
      return;
    }
    this.jfa.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.jdA) == -1) {
      a(paramRUNTIME.jdA);
    }
    this.jfw.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(193360);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(193358);
    int i = this.mContentView.getChildCount();
    if ((aTw()) && (aTv())) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramd.getTag(), Integer.valueOf(i) });
      this.mContentView.addView(paramd, i);
      aTD();
      aTC();
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(193344);
          boolean bool = false;
          if (l.a(l.this) != null) {
            bool = l.a(l.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(193344);
          return bool;
        }
      });
      AppMethodBeat.o(193358);
      return;
      i = 0;
    }
  }
  
  private void aTC()
  {
    AppMethodBeat.i(193356);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193343);
          l.f(l.this);
          AppMethodBeat.o(193343);
        }
      });
      AppMethodBeat.o(193356);
      return;
    }
    if (this.jfu) {
      this.mContentView.setPadding(0, 0, 0, 0);
    }
    if (aTx()) {}
    for (c.a locala = getWindowCompatInfo();; locala = lOO)
    {
      this.mContentView.setPadding(locala.l, locala.t, locala.r, locala.b);
      AppMethodBeat.o(193356);
      return;
    }
  }
  
  private void aTD()
  {
    AppMethodBeat.i(193357);
    this.mContentView.setBackgroundColor(getResources().getColor(2131099651));
    AppMethodBeat.o(193357);
  }
  
  private boolean aTv()
  {
    AppMethodBeat.i(193359);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.jfv != null)))
    {
      AppMethodBeat.o(193359);
      return true;
    }
    AppMethodBeat.o(193359);
    return false;
  }
  
  private boolean aTw()
  {
    return this.jfv != null;
  }
  
  private void b(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(193355);
    if (this.mContentView.indexOfChild(paramd) == -1)
    {
      com.tencent.mm.sdk.platformtools.ac.w("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(193355);
      return;
    }
    this.mContentView.bringChildToFront(paramd);
    if (aTw()) {
      this.mContentView.bringChildToFront(this.jfv);
    }
    aTC();
    aTD();
    AppMethodBeat.o(193355);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(193345);
    if (ap.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(193345);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(193345);
  }
  
  public final boolean A(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193363);
    boolean bool = this.jfa.contains(paramAppBrandRuntime);
    AppMethodBeat.o(193363);
    return bool;
  }
  
  public final void B(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193352);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(193352);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193342);
        com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        Object localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193340);
            com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { l.3.this.ceV.mAppId });
            if (l.3.this.ceV.mResumed) {
              l.3.this.ceV.dispatchPause();
            }
            l.3.this.ceV.dispatchDestroy();
            l.e(l.this).removeView(l.3.this.ceV.jdA);
            l.d(l.this).remove(l.3.this.ceV.mAppId);
            l.c(l.this).remove(l.3.this.ceV);
            AppMethodBeat.o(193340);
          }
        };
        if (!l.this.A(paramAppBrandRuntime))
        {
          com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramAppBrandRuntime.mAppId });
          ((Runnable)localObject).run();
          AppMethodBeat.o(193342);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = l.this.z(paramAppBrandRuntime);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193341);
            boolean bool = l.this.C(l.3.this.ceV);
            if (localAppBrandRuntime != null) {
              localAppBrandRuntime.b(l.3.this.ceV.DJ(), null);
            }
            this.jfm.run();
            if ((bool) && (localAppBrandRuntime != null) && (l.b(l.this))) {
              localAppBrandRuntime.dispatchResume();
            }
            if (localAppBrandRuntime == null) {}
            for (String str = "null";; str = localAppBrandRuntime.mAppId)
            {
              com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(l.b(l.this)) });
              AppMethodBeat.o(193341);
              return;
            }
          }
        };
        l.this.b(localAppBrandRuntime, paramAppBrandRuntime, (Runnable)localObject);
        AppMethodBeat.o(193342);
      }
    });
    AppMethodBeat.o(193352);
  }
  
  protected final boolean C(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(193353);
    if (this.jfa.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(193353);
      return true;
    }
    AppMethodBeat.o(193353);
    return false;
  }
  
  public final void F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193361);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(193361);
      return;
    }
    this.jfa.remove(paramAppBrandRuntime);
    AppMethodBeat.o(193361);
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.d a(d.b paramb)
  {
    AppMethodBeat.i(193369);
    paramb = (com.tencent.mm.plugin.appbrand.r.a.d)com.tencent.mm.plugin.appbrand.utils.l.g("Luggage.WXA.WindowFullscreenHandler.Dummy", com.tencent.mm.plugin.appbrand.r.a.d.class);
    AppMethodBeat.o(193369);
    return paramb;
  }
  
  protected final void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(193348);
    paramRUNTIME2.jdw = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.jfa.push(paramRUNTIME2);
    a(paramRUNTIME2.jdA);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aSx();
    AppMethodBeat.o(193348);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(193347);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(193347);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193337);
        l.a(l.this).bAl();
        Object localObject1;
        if (paramAppBrandRuntime == null)
        {
          localObject1 = l.this;
          localObject2 = ((l)localObject1).jfa.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandRuntime)((Iterator)localObject2).next();
            ((AppBrandRuntime)localObject3).jdA.setVisibility(8);
            ((l)localObject1).jfw.put(((AppBrandRuntime)localObject3).mAppId, localObject3);
            ((AppBrandRuntime)localObject3).aSV();
          }
          ((l)localObject1).jfa.clear();
        }
        Object localObject2 = l.this;
        Object localObject3 = paramAppBrandInitConfig.appId;
        Iterator localIterator = ((l)localObject2).jfa.iterator();
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
          localObject1 = (AppBrandRuntime)org.a.a.bD(((l)localObject1).jfd).ai(new Object[] { localObject1 }).object;
          l.this.a(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
          AppMethodBeat.o(193337);
          return;
          localObject1 = (AppBrandRuntime)((l)localObject2).jfw.get(localObject3);
        }
        l.this.b(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
        AppMethodBeat.o(193337);
      }
    });
    AppMethodBeat.o(193347);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(193350);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(193350);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193339);
        if (!l.this.C(paramAppBrandRuntime))
        {
          com.tencent.mm.sdk.platformtools.ac.e("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(193339);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = l.this.z(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.DJ(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close before run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(l.b(l.this)) });
          l.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193338);
              if (localAppBrandRuntime != null)
              {
                l.2.this.jfp.jdA.setVisibility(8);
                l.c(l.this).remove(l.2.this.jfp);
                l.d(l.this).put(l.2.this.jfp.mAppId, l.2.this.jfp);
                l.a(l.this, localAppBrandRuntime);
                l.b(l.this, localAppBrandRuntime);
              }
              l.2.this.jfp.dispatchPause();
              if ((l.b(l.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = l.2.this.jfp.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                com.tencent.mm.sdk.platformtools.ac.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(l.b(l.this)) });
                AppMethodBeat.o(193338);
                return;
              }
            }
          });
          AppMethodBeat.o(193339);
          return;
        }
      }
    });
    AppMethodBeat.o(193350);
  }
  
  public final boolean aTE()
  {
    return false;
  }
  
  public final boolean aTs()
  {
    return false;
  }
  
  public final boolean aTx()
  {
    return !this.jfu;
  }
  
  protected final void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(193349);
    E(paramRUNTIME2);
    D(paramRUNTIME2);
    paramRUNTIME2.jdw = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.dispatchPause();
      paramRUNTIME2.dispatchResume();
    }
    AppMethodBeat.o(193349);
  }
  
  protected void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193346);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if ((localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed()))
      {
        localAppBrandRuntime.onBackPressed();
        AppMethodBeat.o(193346);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(193346);
    return bool;
  }
  
  public AppBrandRuntime getActiveRuntime()
  {
    AppMethodBeat.i(193365);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.jfa.peek();
    AppMethodBeat.o(193365);
    return localAppBrandRuntime;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(193351);
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(this.context);
    AppMethodBeat.o(193351);
    return localActivity;
  }
  
  public c.c getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    AppMethodBeat.i(193368);
    if (this.jfx == null) {
      this.jfx = new ac(this);
    }
    e locale = this.jfx;
    AppMethodBeat.o(193368);
    return locale;
  }
  
  public Rect getSafeAreaInsets()
  {
    return null;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(193362);
    int i = this.jfa.size();
    AppMethodBeat.o(193362);
    return i;
  }
  
  public c.d getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(193366);
    Object localObject = getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    localObject = getWindowCompatInfo();
    localDisplayMetrics.widthPixels = (getWidth() - ((c.a)localObject).l - ((c.a)localObject).r);
    localDisplayMetrics.heightPixels = (getHeight() - ((c.a)localObject).t - ((c.a)localObject).b);
    AppMethodBeat.o(193366);
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
    AppMethodBeat.i(193367);
    if (!aTx())
    {
      localObject = lOO;
      AppMethodBeat.o(193367);
      return localObject;
    }
    Object localObject = new Point();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
    com.tencent.mm.sdk.platformtools.ac.v("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "getWindowCompatInfo: android orientation = [%d]", new Object[] { Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    double d = ((Point)localObject).y / 1.777777777777778D;
    int i = (int)((((Point)localObject).x - d) / 2.0D);
    localObject = new c.a(i, i);
    AppMethodBeat.o(193367);
    return localObject;
  }
  
  public void setResizeable(boolean paramBoolean)
  {
    AppMethodBeat.i(193370);
    this.jfu = paramBoolean;
    aTC();
    AppMethodBeat.o(193370);
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.b paramb) {}
  
  public final RUNTIME z(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193364);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(193364);
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
        AppMethodBeat.o(193364);
        return localAppBrandRuntime;
      }
    }
    if (i == 0)
    {
      paramAppBrandRuntime = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramAppBrandRuntime.mAppId }));
      AppMethodBeat.o(193364);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(193364);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */