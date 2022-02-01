package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.core.content.a;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ay;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class o
  implements com.tencent.mm.plugin.appbrand.platform.window.c
{
  public Context mContext;
  private k tMp;
  protected c tMq;
  private WindowInsets tMr;
  private final SparseArray<Rect> tMs;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(MMApplicationContext.getContext());
    this.tMs = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets cIc()
  {
    AppMethodBeat.i(178639);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localObject != null)
    {
      localObject = ay.bY((Activity)localObject);
      this.tMr = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.tMr != null)
    {
      localObject = this.tMr;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(317583);
    paramb = new b(this, paramb);
    AppMethodBeat.o(317583);
    return paramb;
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(317635);
    if ((paramInt == 0) || (paramInt >> 24 != 0)) {}
    for (int i = 1;; i = 0)
    {
      paramAppBrandRuntime = AndroidContextUtil.castActivityOrNull(this.mContext);
      if (paramAppBrandRuntime != null) {
        break;
      }
      AppMethodBeat.o(317635);
      return;
    }
    Window localWindow = paramAppBrandRuntime.getWindow();
    if (i != 0) {}
    for (paramAppBrandRuntime = new ColorDrawable(0);; paramAppBrandRuntime = new ColorDrawable(paramInt))
    {
      localWindow.setBackgroundDrawable(paramAppBrandRuntime);
      AppMethodBeat.o(317635);
      return;
    }
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(317630);
    e locale = paramAppBrandRuntime.qsk;
    if ((locale instanceof com.tencent.mm.plugin.appbrand.widget.c))
    {
      ((com.tencent.mm.plugin.appbrand.widget.c)locale).setWxaLayoutParams(paramWxaWindowLayoutParams);
      AppMethodBeat.o(317630);
      return;
    }
    paramAppBrandRuntime.qsk.setLayoutParams(paramWxaWindowLayoutParams);
    paramAppBrandRuntime.qsk.setScaleX(paramWxaWindowLayoutParams.scale);
    paramAppBrandRuntime.qsk.setScaleY(paramWxaWindowLayoutParams.scale);
    AppMethodBeat.o(317630);
  }
  
  public final boolean asq()
  {
    AppMethodBeat.i(178636);
    AppMethodBeat.o(178636);
    return false;
  }
  
  public final boolean ast()
  {
    return false;
  }
  
  public final boolean asu()
  {
    AppMethodBeat.i(176763);
    boolean bool = ac.fo(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public final void b(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(176767);
    a(paramLayoutParams);
    AppMethodBeat.o(176767);
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(176760);
    if (this.mContext == paramContext)
    {
      AppMethodBeat.o(176760);
      return;
    }
    if (ccd()) {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.WindowAndroidActivityImpl", "resetContext, this:%s, new:%s, old:%s, stack:%s", new Object[] { getClass().getName(), paramContext, this.mContext, android.util.Log.getStackTraceString(new Throwable()) });
    }
    this.mContext = paramContext;
    paramContext = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (paramContext == null)
    {
      paramContext = new k.a.1();
      paramContext = (k)Proxy.newProxyInstance(k.class.getClassLoader(), new Class[] { k.class }, paramContext);
    }
    for (;;)
    {
      this.tMp = paramContext;
      cIb();
      cIc();
      AppMethodBeat.o(176760);
      return;
      if (Build.VERSION.SDK_INT >= 28) {
        paramContext = new l(paramContext);
      } else {
        paramContext = new m(paramContext);
      }
    }
  }
  
  public final WindowManager cIa()
  {
    AppMethodBeat.i(177597);
    WindowManager localWindowManager = (WindowManager)a.a(this.mContext, WindowManager.class);
    AppMethodBeat.o(177597);
    return localWindowManager;
  }
  
  public final c cIb()
  {
    AppMethodBeat.i(176765);
    if ((this.tMq == null) || (((this.tMq instanceof d)) && (((d)this.tMq).activity != AndroidContextUtil.castActivityOrNull(this.mContext))))
    {
      if (this.tMq != null) {
        this.tMq.release();
      }
      this.tMq = new d(this);
    }
    c localc = this.tMq;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  protected boolean ccd()
  {
    return false;
  }
  
  public boolean ccf()
  {
    return false;
  }
  
  public final boolean ccm()
  {
    AppMethodBeat.i(317572);
    if (Build.VERSION.SDK_INT >= 24)
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
        Objects.requireNonNull(localActivity);
      }
      if ((localActivity != null) && (localActivity.isInMultiWindowMode()))
      {
        AppMethodBeat.o(317572);
        return true;
      }
      AppMethodBeat.o(317572);
      return false;
    }
    AppMethodBeat.o(317572);
    return false;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176766);
    if (n.a(getContext().getResources().getConfiguration(), paramConfiguration)) {}
    synchronized (this.tMs)
    {
      this.tMs.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      cIb().onConfigurationChanged(paramConfiguration);
      this.tMp.e(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(176769);
    long l1 = Util.currentTicks();
    long l2;
    boolean bool;
    int k;
    int j;
    int i;
    try
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
      if (localActivity == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
        l2 = Util.currentTicks();
        if (Looper.getMainLooper() == Looper.myLooper()) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, cost:%dms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2 - l1) });
          AppMethodBeat.o(176769);
          return null;
        }
      }
      if (localActivity.getWindow() == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
        l2 = Util.currentTicks();
        if (Looper.getMainLooper() == Looper.myLooper()) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, cost:%dms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2 - l1) });
          AppMethodBeat.o(176769);
          return null;
        }
      }
      k = localActivity.getWindowManager().getDefaultDisplay().getRotation();
      synchronized (this.tMs)
      {
        Object localObject1 = (Rect)this.tMs.get(k);
        if (localObject1 != null) {
          break label688;
        }
        if (z.au(localActivity.getWindow().getDecorView()))
        {
          localObject1 = localActivity.getWindow().getDecorView();
          j = ((View)localObject1).getWidth();
        }
        for (i = ((View)localObject1).getHeight(); !this.tMp.Xg(); i = getVDisplayMetrics().heightPixels)
        {
          localObject1 = new Rect(0, 0, j, i);
          this.tMs.put(k, localObject1);
          label285:
          l2 = Util.currentTicks();
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break label676;
          }
          bool = true;
          label305:
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, cost:%dms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2 - l1) });
          AppMethodBeat.o(176769);
          return localObject1;
          j = getVDisplayMetrics().widthPixels;
        }
        if (!this.tMp.Xg()) {
          break label660;
        }
        if (Build.VERSION.SDK_INT < 28) {
          break label531;
        }
        localObject1 = ((l)this.tMp).CW(k);
        if (localObject1 == null) {
          break label531;
        }
        localObject1 = ((WindowInsets)localObject1).getDisplayCutout();
        if (localObject1 == null) {
          break label523;
        }
        localObject1 = new Rect(((DisplayCutout)localObject1).getSafeInsetLeft(), ((DisplayCutout)localObject1).getSafeInsetTop(), j - ((DisplayCutout)localObject1).getSafeInsetRight(), i - ((DisplayCutout)localObject1).getSafeInsetBottom());
      }
      bool = true;
    }
    finally
    {
      l2 = Util.currentTicks();
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label682;
      }
    }
    label483:
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, cost:%dms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2 - l1) });
    AppMethodBeat.o(176769);
    throw localObject3;
    label523:
    com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
    label531:
    int m = this.tMp.cHZ();
    switch (k)
    {
    }
    for (;;)
    {
      Rect localRect = new Rect(0, 0, j, i);
      break;
      localRect = new Rect(0, m, j, i);
      break;
      localRect = new Rect(m, 0, j, i);
      break;
      localRect = new Rect(0, 0, j, i - m);
      break;
      localRect = new Rect(0, 0, j - m, i);
      break;
      label660:
      localRect = new Rect(0, 0, j, i);
      break;
      label676:
      bool = false;
      break label305;
      label682:
      bool = false;
      break label483;
      label688:
      break label285;
    }
  }
  
  public float getScale()
  {
    return 1.0F;
  }
  
  public c.c getStatusBar()
  {
    AppMethodBeat.i(176768);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = cIc();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.c();
        ((c.c)localObject).height = i;
        if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
          if (!ae.fm(AndroidContextUtil.castActivityOrNull(this.mContext))) {
            break label94;
          }
        }
      }
      label94:
      for (int i = 8;; i = 0)
      {
        ((c.c)localObject).visibility = i;
        AppMethodBeat.o(176768);
        return localObject;
        i = com.tencent.luggage.l.k.exm.by(getContext());
        break;
      }
    }
    AppMethodBeat.o(176768);
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(178635);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    AppMethodBeat.o(178635);
    return localDisplayMetrics;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(176771);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(176771);
      return;
    }
    if ((AndroidContextUtil.castActivityOrNull(this.mContext) == null) || (parama == null))
    {
      AppMethodBeat.o(176771);
      return;
    }
    try
    {
      AndroidContextUtil.castActivityOrNull(this.mContext).setTaskDescription(n.a(parama));
      AppMethodBeat.o(176771);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", new Object[] { localException });
      try
      {
        AndroidContextUtil.castActivityOrNull(this.mContext).setTaskDescription(n.a(new c.a(parama.label, parama.tLg, -16777216)));
        AppMethodBeat.o(176771);
        return;
      }
      catch (Exception parama)
      {
        com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", new Object[] { parama });
        AppMethodBeat.o(176771);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.o
 * JD-Core Version:    0.7.0.1
 */