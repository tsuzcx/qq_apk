package com.tencent.mm.plugin.appbrand.s.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.tencent.mm.plugin.appbrand.s.a.c.b;
import com.tencent.mm.plugin.appbrand.s.a.c.d;
import com.tencent.mm.plugin.appbrand.s.a.d.b;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ak;

public class o
  implements com.tencent.mm.plugin.appbrand.s.a.c
{
  protected boolean iFs;
  private k lnV;
  protected c lnW;
  private String lnX;
  private WindowInsets lnY;
  private final SparseArray<Rect> lnZ;
  public Context mContext;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(aj.getContext());
    this.iFs = false;
    this.lnZ = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets blV()
  {
    AppMethodBeat.i(178639);
    Object localObject = a.iV(this.mContext);
    if (localObject != null)
    {
      localObject = ak.bd((Activity)localObject);
      this.lnY = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.lnY != null)
    {
      localObject = this.lnY;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.s.a.d a(d.b paramb)
  {
    AppMethodBeat.i(194529);
    paramb = new b(this, paramb);
    AppMethodBeat.o(194529);
    return paramb;
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public boolean aMC()
  {
    return false;
  }
  
  public boolean aMH()
  {
    AppMethodBeat.i(178636);
    boolean bool1 = ac.dK(aj.getContext());
    if (this.iFs)
    {
      AppMethodBeat.o(178636);
      return false;
    }
    try
    {
      if (i.cjn.Et())
      {
        boolean bool2 = i.cjn.Es();
        if (!bool2)
        {
          AppMethodBeat.o(178636);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      ad.i("Luggage.WXA.WindowAndroidActivityImpl", "shouldInLargeScreenCompatMode: " + localException.getMessage());
      AppMethodBeat.o(178636);
    }
    return bool1;
  }
  
  public c aMI()
  {
    AppMethodBeat.i(176765);
    if ((this.lnW == null) || (((this.lnW instanceof d)) && (((d)this.lnW).activity != a.iV(this.mContext))))
    {
      if (this.lnW != null) {
        this.lnW.release();
      }
      this.lnW = new d(this);
    }
    c localc = this.lnW;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  public final void aMK()
  {
    AppMethodBeat.i(194531);
    if (!TextUtils.isEmpty(this.lnX))
    {
      ad.i("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.lnX });
      aMI().a(e.b.Mq(this.lnX), null);
      AppMethodBeat.o(194531);
      return;
    }
    if (this.lnW == null)
    {
      ad.w("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation NULL handler, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(194531);
      return;
    }
    e.b localb = this.lnW.aNL();
    if (localb != null)
    {
      ad.i("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
      aMI().a(localb, null);
    }
    AppMethodBeat.o(194531);
  }
  
  public final boolean aMO()
  {
    AppMethodBeat.i(176763);
    boolean bool = ac.dK(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public final void av(Context paramContext)
  {
    AppMethodBeat.i(176760);
    if (this.mContext == paramContext)
    {
      AppMethodBeat.o(176760);
      return;
    }
    this.mContext = paramContext;
    this.lnV = k.a.E(a.iV(this.mContext));
    aMI();
    blV();
    AppMethodBeat.o(176760);
  }
  
  public final void b(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(176767);
    a(paramLayoutParams);
    AppMethodBeat.o(176767);
  }
  
  public final WindowManager blU()
  {
    AppMethodBeat.i(177597);
    WindowManager localWindowManager = (WindowManager)android.support.v4.content.b.a(this.mContext, WindowManager.class);
    AppMethodBeat.o(177597);
    return localWindowManager;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176766);
    if (n.a(getContext().getResources().getConfiguration(), paramConfiguration)) {}
    synchronized (this.lnZ)
    {
      this.lnZ.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      aMI().onConfigurationChanged(paramConfiguration);
      this.lnV.c(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(203652);
    Activity localActivity = a.iV(this.mContext);
    AppMethodBeat.o(203652);
    return localActivity;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(176769);
    Activity localActivity = a.iV(this.mContext);
    if (localActivity == null)
    {
      ad.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
      AppMethodBeat.o(176769);
      return null;
    }
    if (localActivity.getWindow() == null)
    {
      ad.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
      AppMethodBeat.o(176769);
      return null;
    }
    int k = localActivity.getWindowManager().getDefaultDisplay().getRotation();
    int j;
    int i;
    synchronized (this.lnZ)
    {
      Rect localRect2 = (Rect)this.lnZ.get(k);
      Object localObject1 = localRect2;
      if (localRect2 == null)
      {
        if (!t.ay(localActivity.getWindow().getDecorView())) {
          break label188;
        }
        localObject1 = localActivity.getWindow().getDecorView();
        j = ((View)localObject1).getWidth();
      }
      for (i = ((View)localObject1).getHeight(); !this.lnV.ca(); i = getVDisplayMetrics().heightPixels)
      {
        localObject1 = new Rect(0, 0, j, i);
        this.lnZ.put(k, localObject1);
        AppMethodBeat.o(176769);
        return localObject1;
        label188:
        j = getVDisplayMetrics().widthPixels;
      }
      if (!this.lnV.ca()) {
        break label444;
      }
      if (Build.VERSION.SDK_INT < 28) {
        break label315;
      }
      localObject1 = ((l)this.lnV).tH(k);
      if (localObject1 == null) {
        break label315;
      }
      localObject1 = ((WindowInsets)localObject1).getDisplayCutout();
      if (localObject1 != null) {
        localObject1 = new Rect(((DisplayCutout)localObject1).getSafeInsetLeft(), ((DisplayCutout)localObject1).getSafeInsetTop(), j - ((DisplayCutout)localObject1).getSafeInsetRight(), i - ((DisplayCutout)localObject1).getSafeInsetBottom());
      }
    }
    ad.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
    label315:
    int m = this.lnV.blT();
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
  
  public c.d getStatusBar()
  {
    AppMethodBeat.i(176768);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = blV();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.d();
        ((c.d)localObject).height = i;
        if (a.iV(this.mContext) != null) {
          if (!r.dI(a.iV(this.mContext))) {
            break label94;
          }
        }
      }
      label94:
      for (int i = 8;; i = 0)
      {
        ((c.d)localObject).visibility = i;
        AppMethodBeat.o(176768);
        return localObject;
        i = i.cjn.aG(getContext());
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
  
  public int getWindowColor()
  {
    AppMethodBeat.i(178638);
    int i = android.support.v4.content.b.n(getContext(), 2131099651);
    AppMethodBeat.o(178638);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void setResizeable(boolean paramBoolean)
  {
    this.iFs = paramBoolean;
  }
  
  public void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(194530);
    this.lnX = paramString;
    if (TextUtils.isEmpty(paramString)) {
      ad.w("Luggage.WXA.WindowAndroidActivityImpl", "setSoftOrientation with default value, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(194530);
  }
  
  public void setWindowDescription(c.b paramb)
  {
    AppMethodBeat.i(176771);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(176771);
      return;
    }
    if ((a.iV(this.mContext) == null) || (paramb == null))
    {
      AppMethodBeat.o(176771);
      return;
    }
    try
    {
      a.iV(this.mContext).setTaskDescription(n.a(paramb));
      AppMethodBeat.o(176771);
      return;
    }
    catch (Exception localException)
    {
      ad.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", new Object[] { localException });
      try
      {
        a.iV(this.mContext).setTaskDescription(n.a(new c.b(paramb.label, paramb.lmN, -16777216)));
        AppMethodBeat.o(176771);
        return;
      }
      catch (Exception paramb)
      {
        ad.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", new Object[] { paramb });
        AppMethodBeat.o(176771);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.o
 * JD-Core Version:    0.7.0.1
 */