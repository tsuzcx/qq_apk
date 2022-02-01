package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
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
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;

public class q<RUNTIME extends AppBrandRuntime>
  extends FrameLayout
  implements ap, c
{
  public final void A(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(316646);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(316646);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(318339);
        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(317228);
            Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { q.2.this.evs.mAppId });
            if (q.2.this.evs.mResumed) {
              q.2.this.evs.dispatchPause();
            }
            q.2.this.evs.dispatchDestroy();
            q.ccq().removeView(q.2.this.evs.qsk);
            q.ccp().remove(q.2.this.evs.mAppId);
            q.cco().remove(q.2.this.evs);
            AppMethodBeat.o(317228);
          }
        };
        AppMethodBeat.o(318339);
        throw null;
      }
    };
    AppMethodBeat.o(316646);
    throw null;
  }
  
  public final void E(AppBrandRuntime paramAppBrandRuntime)
  {
    if (paramAppBrandRuntime == null) {
      return;
    }
    throw null;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(316684);
    paramb = (d)r.k("Luggage.WXA.WindowFullscreenHandler.Dummy", d.class);
    AppMethodBeat.o(316684);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(316638);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(316638);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(318495);
        q.ccn().cRg();
        if (paramAppBrandRuntime == null)
        {
          AppMethodBeat.o(318495);
          throw null;
        }
        AppMethodBeat.o(318495);
        throw null;
      }
    };
    AppMethodBeat.o(316638);
    throw null;
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime, Object paramObject, Runnable paramRunnable) {}
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final boolean asq()
  {
    return false;
  }
  
  public boolean ast()
  {
    return false;
  }
  
  public final boolean asu()
  {
    return false;
  }
  
  public final boolean ccf()
  {
    return false;
  }
  
  public final boolean ccm()
  {
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(316626);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppMethodBeat.o(316626);
      throw null;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(316626);
    return bool;
  }
  
  public AppBrandRuntime getActiveRuntime()
  {
    throw null;
  }
  
  public final Activity getActivity()
  {
    throw null;
  }
  
  public c.b getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    throw null;
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
    throw null;
  }
  
  public c.c getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(316670);
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    new DisplayMetrics().setTo(localDisplayMetrics);
    AppMethodBeat.o(316670);
    throw null;
  }
  
  public c getWindowAndroid()
  {
    return this;
  }
  
  public q<RUNTIME>.a getWindowCompatInfo()
  {
    throw null;
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.a parama) {}
  
  public final RUNTIME y(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(316659);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(316659);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(316659);
    throw null;
  }
  
  public final boolean z(AppBrandRuntime paramAppBrandRuntime)
  {
    throw null;
  }
  
  class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */