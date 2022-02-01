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
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.b;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class m<RUNTIME extends AppBrandRuntime>
  extends FrameLayout
  implements ai, c
{
  private Context context;
  private final n jBA;
  final Map<String, RUNTIME> jBB;
  private e jBC;
  m<RUNTIME>.a jBD;
  final LinkedList<RUNTIME> jBi;
  final Class<? extends RUNTIME> jBl;
  private boolean jBz;
  private final FrameLayout mContentView;
  private boolean mResumed;
  
  private void A(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(207715);
    this.jBi.remove(paramRUNTIME);
    this.jBi.push(paramRUNTIME);
    paramRUNTIME.jzF.setVisibility(0);
    b(paramRUNTIME.jzF);
    AppMethodBeat.o(207715);
  }
  
  private void B(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(207721);
    if (this.jBi.contains(paramRUNTIME))
    {
      AppMethodBeat.o(207721);
      return;
    }
    this.jBi.push(paramRUNTIME);
    if (this.mContentView.indexOfChild(paramRUNTIME.jzF) == -1) {
      a(paramRUNTIME.jzF);
    }
    this.jBB.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(207721);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(207719);
    int i = this.mContentView.getChildCount();
    if ((aXf()) && (aXe())) {
      i -= 1;
    }
    for (;;)
    {
      ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramd.getTag(), Integer.valueOf(i) });
      this.mContentView.addView(paramd, i);
      aXh();
      aXg();
      getActiveRuntime().a(4, 1, new aj()
      {
        public final boolean c(KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(207705);
          boolean bool = false;
          if (m.a(m.this) != null) {
            bool = m.a(m.this).d(paramAnonymousKeyEvent);
          }
          AppMethodBeat.o(207705);
          return bool;
        }
      });
      AppMethodBeat.o(207719);
      return;
      i = 0;
    }
  }
  
  private boolean aXe()
  {
    AppMethodBeat.i(207720);
    int i = this.mContentView.getChildCount();
    if ((i > 1) || ((i == 1) && (this.jBA != null)))
    {
      AppMethodBeat.o(207720);
      return true;
    }
    AppMethodBeat.o(207720);
    return false;
  }
  
  private boolean aXf()
  {
    return this.jBA != null;
  }
  
  private void aXg()
  {
    AppMethodBeat.i(207717);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207704);
          m.f(m.this);
          AppMethodBeat.o(207704);
        }
      });
      AppMethodBeat.o(207717);
      return;
    }
    if (this.jBz) {
      this.mContentView.setPadding(0, 0, 0, 0);
    }
    a locala = this.jBD;
    this.mContentView.setPadding(locala.l, locala.t, locala.r, locala.b);
    AppMethodBeat.o(207717);
  }
  
  private void aXh()
  {
    AppMethodBeat.i(207718);
    this.mContentView.setBackgroundColor(getResources().getColor(2131099651));
    AppMethodBeat.o(207718);
  }
  
  private void b(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(207716);
    if (this.mContentView.indexOfChild(paramd) == -1)
    {
      ae.w("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
      AppMethodBeat.o(207716);
      return;
    }
    this.mContentView.bringChildToFront(paramd);
    if (aXf()) {
      this.mContentView.bringChildToFront(this.jBA);
    }
    aXg();
    aXh();
    AppMethodBeat.o(207716);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(207706);
    if (ar.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(207706);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(207706);
  }
  
  public final void C(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207722);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(207722);
      return;
    }
    this.jBi.remove(paramAppBrandRuntime);
    AppMethodBeat.o(207722);
  }
  
  public final boolean EX()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(207729);
    paramb = (com.tencent.mm.plugin.appbrand.platform.window.d)com.tencent.mm.plugin.appbrand.utils.m.g("Luggage.WXA.WindowFullscreenHandler.Dummy", com.tencent.mm.plugin.appbrand.platform.window.d.class);
    AppMethodBeat.o(207729);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime) {}
  
  protected final void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(207709);
    paramRUNTIME2.jzB = paramRUNTIME1;
    paramRUNTIME2.c(paramAppBrandInitConfig);
    this.jBi.push(paramRUNTIME2);
    a(paramRUNTIME2.jzF);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.dispatchPause();
    }
    paramRUNTIME2.aWi();
    AppMethodBeat.o(207709);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(207708);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(207708);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207698);
        m.a(m.this).bFf();
        Object localObject1;
        if (paramAppBrandRuntime == null)
        {
          localObject1 = m.this;
          localObject2 = ((m)localObject1).jBi.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppBrandRuntime)((Iterator)localObject2).next();
            ((AppBrandRuntime)localObject3).jzF.setVisibility(8);
            ((m)localObject1).jBB.put(((AppBrandRuntime)localObject3).mAppId, localObject3);
            ((AppBrandRuntime)localObject3).aWK();
          }
          ((m)localObject1).jBi.clear();
        }
        Object localObject2 = m.this;
        Object localObject3 = paramAppBrandInitConfig.appId;
        Iterator localIterator = ((m)localObject2).jBi.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (AppBrandRuntime)localIterator.next();
        } while (!((AppBrandRuntime)localObject1).mAppId.equals(localObject3));
        while (localObject1 == null)
        {
          localObject1 = m.this;
          localObject1 = (AppBrandRuntime)org.a.a.bF(((m)localObject1).jBl).ai(new Object[] { localObject1 }).object;
          m.this.a(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
          AppMethodBeat.o(207698);
          return;
          localObject1 = (AppBrandRuntime)((m)localObject2).jBB.get(localObject3);
        }
        m.this.b(paramAppBrandRuntime, (AppBrandRuntime)localObject1, paramAppBrandInitConfig);
        AppMethodBeat.o(207698);
      }
    });
    AppMethodBeat.o(207708);
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(207711);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(207711);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207700);
        if (!m.this.z(paramAppBrandRuntime))
        {
          ae.e("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", new Object[] { paramAppBrandRuntime.mAppId });
          AppMethodBeat.o(207700);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = m.this.v(paramAppBrandRuntime);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.b(paramAppBrandRuntime.Fn(), paramObject);
        }
        String str2 = paramAppBrandRuntime.mAppId;
        if (localAppBrandRuntime == null) {}
        for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
        {
          ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close before run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(m.b(m.this)) });
          m.this.b(localAppBrandRuntime, paramAppBrandRuntime, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207699);
              if (localAppBrandRuntime != null)
              {
                m.2.this.jBu.jzF.setVisibility(8);
                m.c(m.this).remove(m.2.this.jBu);
                m.d(m.this).put(m.2.this.jBu.mAppId, m.2.this.jBu);
                m.a(m.this, localAppBrandRuntime);
                m.b(m.this, localAppBrandRuntime);
              }
              m.2.this.jBu.dispatchPause();
              if ((m.b(m.this)) && (localAppBrandRuntime != null)) {
                localAppBrandRuntime.dispatchResume();
              }
              String str2 = m.2.this.jBu.mAppId;
              if (localAppBrandRuntime == null) {}
              for (String str1 = "null";; str1 = localAppBrandRuntime.mAppId)
              {
                ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(m.b(m.this)) });
                AppMethodBeat.o(207699);
                return;
              }
            }
          });
          AppMethodBeat.o(207700);
          return;
        }
      }
    });
    AppMethodBeat.o(207711);
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final boolean aXc()
  {
    return false;
  }
  
  public final boolean aXi()
  {
    return false;
  }
  
  protected final void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(207710);
    B(paramRUNTIME2);
    A(paramRUNTIME2);
    paramRUNTIME2.jzB = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.dispatchPause();
      paramRUNTIME2.dispatchResume();
    }
    AppMethodBeat.o(207710);
  }
  
  protected void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(207707);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if ((localAppBrandRuntime != null) && (!localAppBrandRuntime.isDestroyed()))
      {
        localAppBrandRuntime.onBackPressed();
        AppMethodBeat.o(207707);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(207707);
    return bool;
  }
  
  public AppBrandRuntime getActiveRuntime()
  {
    AppMethodBeat.i(207726);
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.jBi.peek();
    AppMethodBeat.o(207726);
    return localAppBrandRuntime;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(207712);
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(this.context);
    AppMethodBeat.o(207712);
    return localActivity;
  }
  
  public c.b getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    AppMethodBeat.i(207728);
    if (this.jBC == null) {
      this.jBC = new ac(this);
    }
    e locale = this.jBC;
    AppMethodBeat.o(207728);
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
    AppMethodBeat.i(207723);
    int i = this.jBi.size();
    AppMethodBeat.o(207723);
    return i;
  }
  
  public c.c getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(207727);
    Object localObject = getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    localObject = getWindowCompatInfo();
    localDisplayMetrics.widthPixels = (getWidth() - ((a)localObject).l - ((a)localObject).r);
    localDisplayMetrics.heightPixels = (getHeight() - ((a)localObject).t - ((a)localObject).b);
    AppMethodBeat.o(207727);
    return localDisplayMetrics;
  }
  
  public c getWindowAndroid()
  {
    return this;
  }
  
  public m<RUNTIME>.a getWindowCompatInfo()
  {
    return this.jBD;
  }
  
  public final boolean isInMultiWindowMode()
  {
    return false;
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.a parama) {}
  
  public final RUNTIME v(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207725);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(207725);
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
        AppMethodBeat.o(207725);
        return localAppBrandRuntime;
      }
    }
    if (i == 0)
    {
      paramAppBrandRuntime = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramAppBrandRuntime.mAppId }));
      AppMethodBeat.o(207725);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(207725);
    return null;
  }
  
  public final boolean w(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207724);
    boolean bool = this.jBi.contains(paramAppBrandRuntime);
    AppMethodBeat.o(207724);
    return bool;
  }
  
  public final void x(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207713);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(207713);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207703);
        ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        Object localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(207701);
            ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { m.3.this.cpP.mAppId });
            if (m.3.this.cpP.mResumed) {
              m.3.this.cpP.dispatchPause();
            }
            m.3.this.cpP.dispatchDestroy();
            m.e(m.this).removeView(m.3.this.cpP.jzF);
            m.d(m.this).remove(m.3.this.cpP.mAppId);
            m.c(m.this).remove(m.3.this.cpP);
            AppMethodBeat.o(207701);
          }
        };
        if (!m.this.w(paramAppBrandRuntime))
        {
          ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramAppBrandRuntime.mAppId });
          ((Runnable)localObject).run();
          AppMethodBeat.o(207703);
          return;
        }
        final AppBrandRuntime localAppBrandRuntime = m.this.v(paramAppBrandRuntime);
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(207702);
            boolean bool = m.this.z(m.3.this.cpP);
            if (localAppBrandRuntime != null) {
              localAppBrandRuntime.b(m.3.this.cpP.Fn(), null);
            }
            this.jBr.run();
            if ((bool) && (localAppBrandRuntime != null) && (m.b(m.this))) {
              localAppBrandRuntime.dispatchResume();
            }
            if (localAppBrandRuntime == null) {}
            for (String str = "null";; str = localAppBrandRuntime.mAppId)
            {
              ae.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), str, Boolean.valueOf(m.b(m.this)) });
              AppMethodBeat.o(207702);
              return;
            }
          }
        };
        m.this.b(localAppBrandRuntime, paramAppBrandRuntime, (Runnable)localObject);
        AppMethodBeat.o(207703);
      }
    });
    AppMethodBeat.o(207713);
  }
  
  protected final boolean z(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(207714);
    if (this.jBi.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(207714);
      return true;
    }
    AppMethodBeat.o(207714);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */