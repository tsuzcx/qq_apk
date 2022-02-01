package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ap;
import java.lang.reflect.Proxy;

public class o
  implements com.tencent.mm.plugin.appbrand.platform.window.c
{
  public Context mContext;
  private k nFv;
  protected c nFw;
  private WindowInsets nFx;
  private final SparseArray<Rect> nFy;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(MMApplicationContext.getContext());
    this.nFy = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets bTZ()
  {
    AppMethodBeat.i(178639);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localObject != null)
    {
      localObject = ap.bo((Activity)localObject);
      this.nFx = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.nFx != null)
    {
      localObject = this.nFx;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public final boolean OD()
  {
    AppMethodBeat.i(178636);
    AppMethodBeat.o(178636);
    return false;
  }
  
  public final boolean OG()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(219585);
    paramb = new b(this, paramb);
    AppMethodBeat.o(219585);
    return paramb;
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219587);
    if ((paramInt == 0) || (paramInt >> 24 != 0)) {}
    for (int i = 1;; i = 0)
    {
      paramAppBrandRuntime = AndroidContextUtil.castActivityOrNull(this.mContext);
      if (paramAppBrandRuntime != null) {
        break;
      }
      AppMethodBeat.o(219587);
      return;
    }
    Window localWindow = paramAppBrandRuntime.getWindow();
    if (i != 0) {}
    for (paramAppBrandRuntime = new ColorDrawable(0);; paramAppBrandRuntime = new ColorDrawable(paramInt))
    {
      localWindow.setBackgroundDrawable(paramAppBrandRuntime);
      AppMethodBeat.o(219587);
      return;
    }
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219586);
    paramAppBrandRuntime.kAt.setLayoutParams(paramWxaWindowLayoutParams);
    paramAppBrandRuntime.kAt.setScaleX(paramWxaWindowLayoutParams.scale);
    paramAppBrandRuntime.kAt.setScaleY(paramWxaWindowLayoutParams.scale);
    AppMethodBeat.o(219586);
  }
  
  public final void aG(Context paramContext)
  {
    AppMethodBeat.i(176760);
    if (this.mContext == paramContext)
    {
      AppMethodBeat.o(176760);
      return;
    }
    if (bsa()) {
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
      this.nFv = paramContext;
      bTY();
      bTZ();
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
  
  public final WindowManager bTX()
  {
    AppMethodBeat.i(177597);
    WindowManager localWindowManager = (WindowManager)android.support.v4.content.b.a(this.mContext, WindowManager.class);
    AppMethodBeat.o(177597);
    return localWindowManager;
  }
  
  public final c bTY()
  {
    AppMethodBeat.i(176765);
    if ((this.nFw == null) || (((this.nFw instanceof d)) && (((d)this.nFw).activity != AndroidContextUtil.castActivityOrNull(this.mContext))))
    {
      if (this.nFw != null) {
        this.nFw.release();
      }
      this.nFw = new d(this);
    }
    c localc = this.nFw;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  protected boolean bsa()
  {
    return false;
  }
  
  public boolean bsc()
  {
    return false;
  }
  
  public final boolean bsj()
  {
    AppMethodBeat.i(176763);
    boolean bool = ai.et(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176766);
    if (n.a(getContext().getResources().getConfiguration(), paramConfiguration)) {}
    synchronized (this.nFy)
    {
      this.nFy.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      bTY().onConfigurationChanged(paramConfiguration);
      this.nFv.c(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(258643);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    AppMethodBeat.o(258643);
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
    synchronized (this.nFy)
    {
      Rect localRect2 = (Rect)this.nFy.get(k);
      Object localObject1 = localRect2;
      if (localRect2 == null)
      {
        if (!u.az(localActivity.getWindow().getDecorView())) {
          break label188;
        }
        localObject1 = localActivity.getWindow().getDecorView();
        j = ((View)localObject1).getWidth();
      }
      for (i = ((View)localObject1).getHeight(); !this.nFv.cz(); i = getVDisplayMetrics().heightPixels)
      {
        localObject1 = new Rect(0, 0, j, i);
        this.nFy.put(k, localObject1);
        AppMethodBeat.o(176769);
        return localObject1;
        label188:
        j = getVDisplayMetrics().widthPixels;
      }
      if (!this.nFv.cz()) {
        break label444;
      }
      if (Build.VERSION.SDK_INT < 28) {
        break label315;
      }
      localObject1 = ((l)this.nFv).za(k);
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
    int m = this.nFv.bTW();
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
      Object localObject = bTZ();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.c();
        ((c.c)localObject).height = i;
        if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
          if (!y.eq(AndroidContextUtil.castActivityOrNull(this.mContext))) {
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
        i = j.cDv.aR(getContext());
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
  
  public final boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(219584);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = AndroidContextUtil.castActivityOrNull(this.mContext).isInMultiWindowMode();
      AppMethodBeat.o(219584);
      return bool;
    }
    AppMethodBeat.o(219584);
    return false;
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
        AndroidContextUtil.castActivityOrNull(this.mContext).setTaskDescription(n.a(new c.a(parama.label, parama.nEk, -16777216)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.o
 * JD-Core Version:    0.7.0.1
 */