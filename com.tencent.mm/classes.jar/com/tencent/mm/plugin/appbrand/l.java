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
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.s.a.c.a;
import com.tencent.mm.plugin.appbrand.s.a.c.b;
import com.tencent.mm.plugin.appbrand.s.a.c.c;
import com.tencent.mm.plugin.appbrand.s.a.c.d;
import com.tencent.mm.plugin.appbrand.s.a.d.b;
import com.tencent.mm.plugin.appbrand.s.a.e;
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
  final LinkedList<RUNTIME> iEY;
  final Class<? extends RUNTIME> iFb;
  private boolean iFs;
  private final n iFt;
  final Map<String, RUNTIME> iFu;
  private e iFv;
  private final FrameLayout mContentView;
  private boolean mResumed;
  
  private void D(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(194440);
    this.iEY.remove(paramRUNTIME);
    this.iEY.push(paramRUNTIME);
    paramRUNTIME.iDA.setVisibility(0);
    b(paramRUNTIME.iDA);
    AppMethodBeat.o(194440);
  }
  
  private void E(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(194446);
    if (this.iEY.contains(paramRUNTIME))
    {
      AppMethodBeat.o(194446);
      return;
    }
    this.iEY.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.iDA) == -1) {
      a(paramRUNTIME.iDA);
    }
    this.iFu.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(194446);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(194444);
    int i = this.mContentView.getChildCount();
    if ((aMG()) && (aMF())) {
      i -= 1;
    }
    for (;;)
    {
      ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramd.getTag(), Integer.valueOf(i) });
      this.mContentView.addView(paramd, i);
      aMN();
      aMM();
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(194430);
          boolean bool = false;
          if (l.a(l.this) != null) {
            bool = l.a(l.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(194430);
          return bool;
        }
      });
      AppMethodBeat.o(194444);
      return;
      i = 0;
    }
  }
  
  private boolean aMF()
  {
    AppMethodBeat.i(194445);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.iFt != null)))
    {
      AppMethodBeat.o(194445);
      return true;
    }
    AppMethodBeat.o(194445);
    return false;
  }
  
  private boolean aMG()
  {
    return this.iFt != null;
  }
  
  private void aMM()
  {
    AppMethodBeat.i(194442);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194429);
          l.f(l.this);
          AppMethodBeat.o(194429);
        }
      });
      AppMethodBeat.o(194442);
      return;
    }
    if (this.iFs) {
      this.mContentView.setPadding(0, 0, 0, 0);
    }
    if (aMH()) {}
    for (c.a locala = getWindowCompatInfo();; locala = lmM)
    {
      this.mContentView.setPadding(locala.l, locala.t, locala.r, locala.b);
      AppMethodBeat.o(194442);
      return;
    }
  }
  
  private void aMN()
  {
    AppMethodBeat.i(194443);
    this.mContentView.setBackgroundColor(getResources().getColor(2131099651));
    AppMethodBeat.o(194443);
  }
  
  private void b(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(194441);
    if (this.mContentView.indexOfChild(paramd) == -1)
    {
      ad.w("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(194441);
      return;
    }
    this.mContentView.bringChildToFront(paramd);
    if (aMG()) {
      this.mContentView.bringChildToFront(this.iFt);
    }
    aMM();
    aMN();
    AppMethodBeat.o(194441);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(194431);
    if (aq.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(194431);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(194431);
  }
  
  public final boolean A(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194449);
    boolean bool = this.iEY.contains(paramAppBrandRuntime);
    AppMethodBeat.o(194449);
    return bool;
  }
  
  public final void B(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194438);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(194438);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194428);
        ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        Object localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194426);
            ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { l.3.this.cia.mAppId });
            if (l.3.this.cia.mResumed) {
              l.3.this.cia.dispatchPause();
            }
            l.3.this.cia.dispatchDestroy();
            l.e(l.this).removeView(l.3.this.cia.iDA);
            l.d(l.this).remove(l.3.this.cia.mAppId);
            l.c(l.this).remove(l.3.this.cia);
            AppMethodBeat.o(194426);
          }
        };
        if (!l.this.A(paramAppBrandRuntime))
        {
          ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramAppBrandRuntime.mAppId });
          ((Runnable)localObject).run();
          AppMethodBeat.o(194428);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = l.this.z(paramAppBrandRuntime);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194427);
            boolean bool = l.this.C(l.3.this.cia);
            if (localAppBrandRuntime != null) {
              localAppBrandRuntime.b(l.3.this.cia.Eg(), null);
            }
            this.iFk.run();
            if ((bool) && (localAppBrandRuntime != null) && (l.b(l.this))) {
              localAppBrandRuntime.dispatchResume();
            }
            if (localAppBrandRuntime == null) {}
            for (String str = "null";; str = localAppBrandRuntime.mAppId)
            {
              ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(l.b(l.this)) });
              AppMethodBeat.o(194427);
              return;
            }
          }
        };
        l.this.b(localAppBrandRuntime, paramAppBrandRuntime, (Runnable)localObject);
        AppMethodBeat.o(194428);
      }
    });
    AppMethodBeat.o(194438);
  }
  
  protected final boolean C(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(194439);
    if (this.iEY.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(194439);
      return true;
    }
    AppMethodBeat.o(194439);
    return false;
  }
  
  public final void F(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194447);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(194447);
      return;
    }
    this.iEY.remove(paramAppBrandRuntime);
    AppMethodBeat.o(194447);
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.d a(d.b paramb)
  {
    AppMethodBeat.i(194455);
    paramb = (com.tencent.mm.plugin.appbrand.s.a.d)com.tencent.mm.plugin.appbrand.utils.l.g("Luggage.WXA.WindowFullscreenHandler.Dummy", com.tencent.mm.plugin.appbrand.s.a.d.class);
    AppMethodBeat.o(194455);
    return paramb;
  }
  
  protected final void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(194434);
    paramRUNTIME2.iDw = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.iEY.push(paramRUNTIME2);
    a(paramRUNTIME2.iDA);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aLH();
    AppMethodBeat.o(194434);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(194433);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(194433);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194423);
        l.a(l.this).btl();
        Object localObject1;
        if (paramAppBrandRuntime == null)
        {
          localObject1 = l.this;
          localObject2 = ((l)localObject1).iEY.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandRuntime)((Iterator)localObject2).next();
            ((AppBrandRuntime)localObject3).iDA.setVisibility(8);
            ((l)localObject1).iFu.put(((AppBrandRuntime)localObject3).mAppId, localObject3);
            ((AppBrandRuntime)localObject3).aMf();
          }
          ((l)localObject1).iEY.clear();
        }
        Object localObject2 = l.this;
        Object localObject3 = paramAppBrandInitConfig.appId;
        Iterator localIterator = ((l)localObject2).iEY.iterator();
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
          localObject1 = (AppBrandRuntime)org.a.a.bA(((l)localObject1).iFb).ag(new Object[] { localObject1 }).object;
          l.this.a(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
          AppMethodBeat.o(194423);
          return;
          localObject1 = (AppBrandRuntime)((l)localObject2).iFu.get(localObject3);
        }
        l.this.b(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
        AppMethodBeat.o(194423);
      }
    });
    AppMethodBeat.o(194433);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(194436);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(194436);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194425);
        if (!l.this.C(paramAppBrandRuntime))
        {
          ad.e("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(194425);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = l.this.z(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Eg(), paramObject);
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
              AppMethodBeat.i(194424);
              if (localAppBrandRuntime != null)
              {
                l.2.this.iFn.iDA.setVisibility(8);
                l.c(l.this).remove(l.2.this.iFn);
                l.d(l.this).put(l.2.this.iFn.mAppId, l.2.this.iFn);
                l.a(l.this, localAppBrandRuntime);
                l.b(l.this, localAppBrandRuntime);
              }
              l.2.this.iFn.dispatchPause();
              if ((l.b(l.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = l.2.this.iFn.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ad.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(l.b(l.this)) });
                AppMethodBeat.o(194424);
                return;
              }
            }
          });
          AppMethodBeat.o(194425);
          return;
        }
      }
    });
    AppMethodBeat.o(194436);
  }
  
  public final boolean aMC()
  {
    return false;
  }
  
  public final boolean aMH()
  {
    return !this.iFs;
  }
  
  public final boolean aMO()
  {
    return false;
  }
  
  protected final void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(194435);
    E(paramRUNTIME2);
    D(paramRUNTIME2);
    paramRUNTIME2.iDw = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.dispatchPause();
      paramRUNTIME2.dispatchResume();
    }
    AppMethodBeat.o(194435);
  }
  
  protected void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(194432);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if ((localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed()))
      {
        localAppBrandRuntime.onBackPressed();
        AppMethodBeat.o(194432);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(194432);
    return bool;
  }
  
  public AppBrandRuntime getActiveRuntime()
  {
    AppMethodBeat.i(194451);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.iEY.peek();
    AppMethodBeat.o(194451);
    return localAppBrandRuntime;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(194437);
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(this.context);
    AppMethodBeat.o(194437);
    return localActivity;
  }
  
  public c.c getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    AppMethodBeat.i(194454);
    if (this.iFv == null) {
      this.iFv = new ac(this);
    }
    e locale = this.iFv;
    AppMethodBeat.o(194454);
    return locale;
  }
  
  public Rect getSafeAreaInsets()
  {
    return null;
  }
  
  public int getStackSize()
  {
    AppMethodBeat.i(194448);
    int i = this.iEY.size();
    AppMethodBeat.o(194448);
    return i;
  }
  
  public c.d getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(194452);
    Object localObject = getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    localObject = getWindowCompatInfo();
    localDisplayMetrics.widthPixels = (getWidth() - ((c.a)localObject).l - ((c.a)localObject).r);
    localDisplayMetrics.heightPixels = (getHeight() - ((c.a)localObject).t - ((c.a)localObject).b);
    AppMethodBeat.o(194452);
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
    AppMethodBeat.i(194453);
    if (!aMH())
    {
      localObject = lmM;
      AppMethodBeat.o(194453);
      return localObject;
    }
    Object localObject = new Point();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
    ad.v("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "getWindowCompatInfo: android orientation = [%d]", new Object[] { Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    double d = ((Point)localObject).y / 1.777777777777778D;
    int i = (int)((((Point)localObject).x - d) / 2.0D);
    localObject = new c.a(i, i);
    AppMethodBeat.o(194453);
    return localObject;
  }
  
  public void setResizeable(boolean paramBoolean)
  {
    AppMethodBeat.i(194456);
    this.iFs = paramBoolean;
    aMM();
    AppMethodBeat.o(194456);
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.b paramb) {}
  
  public final RUNTIME z(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194450);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(194450);
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
        AppMethodBeat.o(194450);
        return localAppBrandRuntime;
      }
    }
    if (i == 0)
    {
      paramAppBrandRuntime = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramAppBrandRuntime.mAppId }));
      AppMethodBeat.o(194450);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(194450);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */