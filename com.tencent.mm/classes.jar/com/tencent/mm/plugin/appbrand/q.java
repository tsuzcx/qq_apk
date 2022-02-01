package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
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
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class q<RUNTIME extends AppBrandRuntime>
  extends FrameLayout
  implements ak, c
{
  public final void C(AppBrandRuntime paramAppBrandRuntime)
  {
    if (paramAppBrandRuntime == null) {
      return;
    }
    throw null;
  }
  
  public final boolean RZ()
  {
    return false;
  }
  
  public boolean Sc()
  {
    return false;
  }
  
  public final boolean Sd()
  {
    return false;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(243171);
    paramb = (d)o.g("Luggage.WXA.WindowFullscreenHandler.Dummy", d.class);
    AppMethodBeat.o(243171);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(243164);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(243164);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244435);
        q.bDa().coE();
        if (paramAppBrandRuntime == null)
        {
          AppMethodBeat.o(244435);
          throw null;
        }
        AppMethodBeat.o(244435);
        throw null;
      }
    };
    AppMethodBeat.o(243164);
    throw null;
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime, final Object paramObject)
  {
    AppMethodBeat.i(243166);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(243166);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        throw null;
      }
    };
    AppMethodBeat.o(243166);
    throw null;
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final boolean bCS()
  {
    return false;
  }
  
  public final boolean bCZ()
  {
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(243159);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      AppMethodBeat.o(243159);
      throw null;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(243159);
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
    AppMethodBeat.i(243169);
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    new DisplayMetrics().setTo(localDisplayMetrics);
    AppMethodBeat.o(243169);
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
  
  public final RUNTIME w(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(243168);
    if (paramAppBrandRuntime == null)
    {
      paramAppBrandRuntime = new NullPointerException("Null runtime");
      AppMethodBeat.o(243168);
      throw paramAppBrandRuntime;
    }
    AppMethodBeat.o(243168);
    throw null;
  }
  
  public final boolean x(AppBrandRuntime paramAppBrandRuntime)
  {
    throw null;
  }
  
  public final void y(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(243167);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(243167);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242576);
        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243976);
            Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { q.3.this.cCM.mAppId });
            if (q.3.this.cCM.mResumed) {
              q.3.this.cCM.dispatchPause();
            }
            q.3.this.cCM.dispatchDestroy();
            q.bDd().removeView(q.3.this.cCM.ntC);
            q.bDc().remove(q.3.this.cCM.mAppId);
            q.bDb().remove(q.3.this.cCM);
            AppMethodBeat.o(243976);
          }
        };
        AppMethodBeat.o(242576);
        throw null;
      }
    };
    AppMethodBeat.o(243167);
    throw null;
  }
  
  class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */