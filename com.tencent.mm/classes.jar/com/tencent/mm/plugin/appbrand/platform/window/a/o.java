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
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.am;

public class o
  implements com.tencent.mm.plugin.appbrand.platform.window.c
{
  public Context mContext;
  private k muM;
  protected c muN;
  private WindowInsets muO;
  private final SparseArray<Rect> muP;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(ak.getContext());
    this.muP = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets bxO()
  {
    AppMethodBeat.i(178639);
    Object localObject = a.jw(this.mContext);
    if (localObject != null)
    {
      localObject = am.bi((Activity)localObject);
      this.muO = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.muO != null)
    {
      localObject = this.muO;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public final boolean EX()
  {
    AppMethodBeat.i(178636);
    AppMethodBeat.o(178636);
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(207981);
    paramb = new b(this, paramb);
    AppMethodBeat.o(207981);
    return paramb;
  }
  
  public void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207983);
    int i;
    Window localWindow;
    if ((paramInt == 0) || (paramInt >> 24 != 0))
    {
      i = 1;
      localWindow = a.jw(this.mContext).getWindow();
      if (i == 0) {
        break label60;
      }
    }
    label60:
    for (paramAppBrandRuntime = new ColorDrawable(0);; paramAppBrandRuntime = new ColorDrawable(paramInt))
    {
      localWindow.setBackgroundDrawable(paramAppBrandRuntime);
      AppMethodBeat.o(207983);
      return;
      i = 0;
      break;
    }
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207982);
    paramAppBrandRuntime.jzF.setLayoutParams(paramWxaWindowLayoutParams);
    paramAppBrandRuntime.jzF.setScaleX(paramWxaWindowLayoutParams.scale);
    paramAppBrandRuntime.jzF.setScaleY(paramWxaWindowLayoutParams.scale);
    AppMethodBeat.o(207982);
  }
  
  public boolean aXc()
  {
    return false;
  }
  
  public final boolean aXi()
  {
    AppMethodBeat.i(176763);
    boolean bool = ai.dW(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public final void ax(Context paramContext)
  {
    AppMethodBeat.i(176760);
    if (this.mContext == paramContext)
    {
      AppMethodBeat.o(176760);
      return;
    }
    this.mContext = paramContext;
    this.muM = k.a.F(a.jw(this.mContext));
    bxN();
    bxO();
    AppMethodBeat.o(176760);
  }
  
  public final void b(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(176767);
    a(paramLayoutParams);
    AppMethodBeat.o(176767);
  }
  
  public final WindowManager bxM()
  {
    AppMethodBeat.i(177597);
    WindowManager localWindowManager = (WindowManager)android.support.v4.content.b.a(this.mContext, WindowManager.class);
    AppMethodBeat.o(177597);
    return localWindowManager;
  }
  
  public final c bxN()
  {
    AppMethodBeat.i(176765);
    if ((this.muN == null) || (((this.muN instanceof d)) && (((d)this.muN).activity != a.jw(this.mContext))))
    {
      if (this.muN != null) {
        this.muN.release();
      }
      this.muN = new d(this);
    }
    c localc = this.muN;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176766);
    if (n.a(getContext().getResources().getConfiguration(), paramConfiguration)) {}
    synchronized (this.muP)
    {
      this.muP.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      bxN().onConfigurationChanged(paramConfiguration);
      this.muM.c(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(224487);
    Activity localActivity = a.jw(this.mContext);
    AppMethodBeat.o(224487);
    return localActivity;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(176769);
    Activity localActivity = a.jw(this.mContext);
    if (localActivity == null)
    {
      ae.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
      AppMethodBeat.o(176769);
      return null;
    }
    if (localActivity.getWindow() == null)
    {
      ae.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
      AppMethodBeat.o(176769);
      return null;
    }
    int k = localActivity.getWindowManager().getDefaultDisplay().getRotation();
    int j;
    int i;
    synchronized (this.muP)
    {
      Rect localRect2 = (Rect)this.muP.get(k);
      Object localObject1 = localRect2;
      if (localRect2 == null)
      {
        if (!android.support.v4.view.t.ay(localActivity.getWindow().getDecorView())) {
          break label182;
        }
        localObject1 = localActivity.getWindow().getDecorView();
        j = ((View)localObject1).getWidth();
      }
      for (i = ((View)localObject1).getHeight(); !this.muM.cx(); i = getVDisplayMetrics().heightPixels)
      {
        localObject1 = new Rect(0, 0, j, i);
        this.muP.put(k, localObject1);
        AppMethodBeat.o(176769);
        return localObject1;
        label182:
        j = getVDisplayMetrics().widthPixels;
      }
      if (!this.muM.cx()) {
        break label440;
      }
      if (Build.VERSION.SDK_INT < 28) {
        break label308;
      }
      localObject1 = ((l)this.muM).vi(k);
      if (localObject1 == null) {
        break label308;
      }
      localObject1 = ((WindowInsets)localObject1).getDisplayCutout();
      if (localObject1 != null) {
        localObject1 = new Rect(((DisplayCutout)localObject1).getSafeInsetLeft(), ((DisplayCutout)localObject1).getSafeInsetTop(), j - ((DisplayCutout)localObject1).getSafeInsetRight(), i - ((DisplayCutout)localObject1).getSafeInsetBottom());
      }
    }
    ae.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
    label308:
    int m = this.muM.bxL();
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
      label440:
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
      Object localObject = bxO();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.c();
        ((c.c)localObject).height = i;
        if (a.jw(this.mContext) != null) {
          if (!com.tencent.mm.plugin.appbrand.ui.t.dT(a.jw(this.mContext))) {
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
        i = i.cre.aI(getContext());
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
    AppMethodBeat.i(207980);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = a.jw(this.mContext).isInMultiWindowMode();
      AppMethodBeat.o(207980);
      return bool;
    }
    AppMethodBeat.o(207980);
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
    if ((a.jw(this.mContext) == null) || (parama == null))
    {
      AppMethodBeat.o(176771);
      return;
    }
    try
    {
      a.jw(this.mContext).setTaskDescription(n.a(parama));
      AppMethodBeat.o(176771);
      return;
    }
    catch (Exception localException)
    {
      ae.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", new Object[] { localException });
      try
      {
        a.jw(this.mContext).setTaskDescription(n.a(new c.a(parama.label, parama.mtC, -16777216)));
        AppMethodBeat.o(176771);
        return;
      }
      catch (Exception parama)
      {
        ae.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", new Object[] { parama });
        AppMethodBeat.o(176771);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.o
 * JD-Core Version:    0.7.0.1
 */