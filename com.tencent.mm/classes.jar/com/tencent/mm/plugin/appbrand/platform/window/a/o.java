package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
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
import androidx.core.g.w;
import com.tencent.luggage.k.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.as;
import java.lang.reflect.Proxy;

public class o
  implements com.tencent.mm.plugin.appbrand.platform.window.c
{
  public Context mContext;
  private k qHG;
  protected c qHH;
  private WindowInsets qHI;
  private final SparseArray<Rect> qHJ;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(MMApplicationContext.getContext());
    this.qHJ = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets chf()
  {
    AppMethodBeat.i(178639);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localObject != null)
    {
      localObject = as.bu((Activity)localObject);
      this.qHI = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.qHI != null)
    {
      localObject = this.qHI;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public final boolean RZ()
  {
    AppMethodBeat.i(178636);
    AppMethodBeat.o(178636);
    return false;
  }
  
  public final boolean Sc()
  {
    return false;
  }
  
  public final boolean Sd()
  {
    AppMethodBeat.i(176763);
    boolean bool = com.tencent.mm.plugin.appbrand.utils.x.es(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(244584);
    paramb = new b(this, paramb);
    AppMethodBeat.o(244584);
    return paramb;
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(244599);
    if ((paramInt == 0) || (paramInt >> 24 != 0)) {}
    for (int i = 1;; i = 0)
    {
      paramAppBrandRuntime = AndroidContextUtil.castActivityOrNull(this.mContext);
      if (paramAppBrandRuntime != null) {
        break;
      }
      AppMethodBeat.o(244599);
      return;
    }
    Window localWindow = paramAppBrandRuntime.getWindow();
    if (i != 0) {}
    for (paramAppBrandRuntime = new ColorDrawable(0);; paramAppBrandRuntime = new ColorDrawable(paramInt))
    {
      localWindow.setBackgroundDrawable(paramAppBrandRuntime);
      AppMethodBeat.o(244599);
      return;
    }
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(244597);
    com.tencent.mm.plugin.appbrand.widget.d locald = paramAppBrandRuntime.ntC;
    if ((locald instanceof com.tencent.mm.plugin.appbrand.widget.c))
    {
      ((com.tencent.mm.plugin.appbrand.widget.c)locald).setWxaLayoutParams(paramWxaWindowLayoutParams);
      AppMethodBeat.o(244597);
      return;
    }
    paramAppBrandRuntime.ntC.setLayoutParams(paramWxaWindowLayoutParams);
    paramAppBrandRuntime.ntC.setScaleX(paramWxaWindowLayoutParams.scale);
    paramAppBrandRuntime.ntC.setScaleY(paramWxaWindowLayoutParams.scale);
    AppMethodBeat.o(244597);
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(176760);
    if (this.mContext == paramContext)
    {
      AppMethodBeat.o(176760);
      return;
    }
    if (bCQ()) {
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
      this.qHG = paramContext;
      che();
      chf();
      AppMethodBeat.o(176760);
      return;
      if (Build.VERSION.SDK_INT >= 28) {
        paramContext = new l(paramContext);
      } else {
        paramContext = new m(paramContext);
      }
    }
  }
  
  public final void b(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(176767);
    a(paramLayoutParams);
    AppMethodBeat.o(176767);
  }
  
  protected boolean bCQ()
  {
    return false;
  }
  
  public boolean bCS()
  {
    return false;
  }
  
  public final boolean bCZ()
  {
    AppMethodBeat.i(244583);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = AndroidContextUtil.castActivityOrNull(this.mContext).isInMultiWindowMode();
      AppMethodBeat.o(244583);
      return bool;
    }
    AppMethodBeat.o(244583);
    return false;
  }
  
  public final WindowManager chd()
  {
    AppMethodBeat.i(177597);
    WindowManager localWindowManager = (WindowManager)a.a(this.mContext, WindowManager.class);
    AppMethodBeat.o(177597);
    return localWindowManager;
  }
  
  public final c che()
  {
    AppMethodBeat.i(176765);
    if ((this.qHH == null) || (((this.qHH instanceof d)) && (((d)this.qHH).activity != AndroidContextUtil.castActivityOrNull(this.mContext))))
    {
      if (this.qHH != null) {
        this.qHH.release();
      }
      this.qHH = new d(this);
    }
    c localc = this.qHH;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176766);
    if (n.a(getContext().getResources().getConfiguration(), paramConfiguration)) {}
    synchronized (this.qHJ)
    {
      this.qHJ.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      che().onConfigurationChanged(paramConfiguration);
      this.qHG.c(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(292946);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    AppMethodBeat.o(292946);
    return localActivity;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(176769);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localActivity == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
      AppMethodBeat.o(176769);
      return null;
    }
    if (localActivity.getWindow() == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
      AppMethodBeat.o(176769);
      return null;
    }
    int k = localActivity.getWindowManager().getDefaultDisplay().getRotation();
    int j;
    int i;
    synchronized (this.qHJ)
    {
      Rect localRect2 = (Rect)this.qHJ.get(k);
      Object localObject1 = localRect2;
      if (localRect2 == null)
      {
        if (!w.ah(localActivity.getWindow().getDecorView())) {
          break label188;
        }
        localObject1 = localActivity.getWindow().getDecorView();
        j = ((View)localObject1).getWidth();
      }
      for (i = ((View)localObject1).getHeight(); !this.qHG.xJ(); i = getVDisplayMetrics().heightPixels)
      {
        localObject1 = new Rect(0, 0, j, i);
        this.qHJ.put(k, localObject1);
        AppMethodBeat.o(176769);
        return localObject1;
        label188:
        j = getVDisplayMetrics().widthPixels;
      }
      if (!this.qHG.xJ()) {
        break label444;
      }
      if (Build.VERSION.SDK_INT < 28) {
        break label315;
      }
      localObject1 = ((l)this.qHG).CF(k);
      if (localObject1 == null) {
        break label315;
      }
      localObject1 = ((WindowInsets)localObject1).getDisplayCutout();
      if (localObject1 != null) {
        localObject1 = new Rect(((DisplayCutout)localObject1).getSafeInsetLeft(), ((DisplayCutout)localObject1).getSafeInsetTop(), j - ((DisplayCutout)localObject1).getSafeInsetRight(), i - ((DisplayCutout)localObject1).getSafeInsetBottom());
      }
    }
    com.tencent.mm.sdk.platformtools.Log.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
    label315:
    int m = this.qHG.chc();
    switch (k)
    {
    }
    for (;;)
    {
      Rect localRect1 = new Rect(0, 0, j, i);
      break;
      localRect1 = new Rect(0, m, j, i);
      break;
      localRect1 = new Rect(m, 0, j, i);
      break;
      localRect1 = new Rect(0, 0, j, i - m);
      break;
      localRect1 = new Rect(0, 0, j - m, i);
      break;
      label444:
      localRect1 = new Rect(0, 0, j, i);
      break;
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
      Object localObject = chf();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.c();
        ((c.c)localObject).height = i;
        if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
          if (!com.tencent.mm.plugin.appbrand.ui.x.eq(AndroidContextUtil.castActivityOrNull(this.mContext))) {
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
        i = j.cEc.aO(getContext());
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
        AndroidContextUtil.castActivityOrNull(this.mContext).setTaskDescription(n.a(new c.a(parama.label, parama.qGu, -16777216)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.o
 * JD-Core Version:    0.7.0.1
 */