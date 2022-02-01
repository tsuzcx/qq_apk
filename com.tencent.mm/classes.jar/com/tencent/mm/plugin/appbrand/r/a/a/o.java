package com.tencent.mm.plugin.appbrand.r.a.a;

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
import com.tencent.mm.plugin.appbrand.r.a.c.b;
import com.tencent.mm.plugin.appbrand.r.a.c.d;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.ak;

public class o
  implements com.tencent.mm.plugin.appbrand.r.a.c
{
  protected boolean jfu;
  private k lPW;
  protected c lPX;
  private String lPY;
  private WindowInsets lPZ;
  private Boolean lQa;
  private final SparseArray<Rect> lQb;
  public Context mContext;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(ai.getContext());
    this.jfu = false;
    this.lQa = null;
    this.lQb = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets bsR()
  {
    AppMethodBeat.i(178639);
    Object localObject = a.jg(this.mContext);
    if (localObject != null)
    {
      localObject = ak.bh((Activity)localObject);
      this.lPZ = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.lPZ != null)
    {
      localObject = this.lPZ;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.r.a.d a(d.b paramb)
  {
    AppMethodBeat.i(193519);
    paramb = new b(this, paramb);
    AppMethodBeat.o(193519);
    return paramb;
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public final void aTA()
  {
    AppMethodBeat.i(193521);
    if (!TextUtils.isEmpty(this.lPY))
    {
      ac.i("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.lPY });
      aTy().a(e.b.Qz(this.lPY), null);
      AppMethodBeat.o(193521);
      return;
    }
    if (this.lPX == null)
    {
      ac.w("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation NULL handler, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(193521);
      return;
    }
    e.b localb = this.lPX.aUB();
    if (localb != null)
    {
      ac.i("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
      aTy().a(localb, null);
    }
    AppMethodBeat.o(193521);
  }
  
  public final boolean aTE()
  {
    AppMethodBeat.i(176763);
    boolean bool = ad.dS(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public boolean aTs()
  {
    return false;
  }
  
  public boolean aTx()
  {
    AppMethodBeat.i(178636);
    bool2 = ad.dS(ai.getContext());
    if (this.jfu)
    {
      AppMethodBeat.o(178636);
      return false;
    }
    try
    {
      if (!h.DEBUG)
      {
        if (this.lQa == null) {
          if ((!i.cgk.DW()) || (i.cgk.DV())) {
            break label86;
          }
        }
        label86:
        for (boolean bool1 = true;; bool1 = false)
        {
          this.lQa = Boolean.valueOf(bool1);
          bool1 = this.lQa.booleanValue();
          if (!bool1) {
            break;
          }
          AppMethodBeat.o(178636);
          return false;
        }
      }
      return bool2;
    }
    catch (Exception localException)
    {
      ac.i("Luggage.WXA.WindowAndroidActivityImpl", "shouldInLargeScreenCompatMode: " + localException.getMessage());
      AppMethodBeat.o(178636);
    }
  }
  
  public c aTy()
  {
    AppMethodBeat.i(176765);
    if ((this.lPX == null) || (((this.lPX instanceof d)) && (((d)this.lPX).activity != a.jg(this.mContext))))
    {
      if (this.lPX != null) {
        this.lPX.release();
      }
      this.lPX = new d(this);
    }
    c localc = this.lPX;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  public final void aw(Context paramContext)
  {
    AppMethodBeat.i(176760);
    if (this.mContext == paramContext)
    {
      AppMethodBeat.o(176760);
      return;
    }
    this.mContext = paramContext;
    this.lPW = k.a.E(a.jg(this.mContext));
    aTy();
    bsR();
    AppMethodBeat.o(176760);
  }
  
  public final void b(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(176767);
    a(paramLayoutParams);
    AppMethodBeat.o(176767);
  }
  
  public final WindowManager bsQ()
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
    synchronized (this.lQb)
    {
      this.lQb.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      aTy().onConfigurationChanged(paramConfiguration);
      this.lPW.c(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(210528);
    Activity localActivity = a.jg(this.mContext);
    AppMethodBeat.o(210528);
    return localActivity;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(176769);
    Activity localActivity = a.jg(this.mContext);
    if (localActivity == null)
    {
      ac.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
      AppMethodBeat.o(176769);
      return null;
    }
    if (localActivity.getWindow() == null)
    {
      ac.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
      AppMethodBeat.o(176769);
      return null;
    }
    int k = localActivity.getWindowManager().getDefaultDisplay().getRotation();
    int j;
    int i;
    synchronized (this.lQb)
    {
      Rect localRect2 = (Rect)this.lQb.get(k);
      Object localObject1 = localRect2;
      if (localRect2 == null)
      {
        if (!t.ay(localActivity.getWindow().getDecorView())) {
          break label188;
        }
        localObject1 = localActivity.getWindow().getDecorView();
        j = ((View)localObject1).getWidth();
      }
      for (i = ((View)localObject1).getHeight(); !this.lPW.ch(); i = getVDisplayMetrics().heightPixels)
      {
        localObject1 = new Rect(0, 0, j, i);
        this.lQb.put(k, localObject1);
        AppMethodBeat.o(176769);
        return localObject1;
        label188:
        j = getVDisplayMetrics().widthPixels;
      }
      if (!this.lPW.ch()) {
        break label444;
      }
      if (Build.VERSION.SDK_INT < 28) {
        break label315;
      }
      localObject1 = ((l)this.lPW).uz(k);
      if (localObject1 == null) {
        break label315;
      }
      localObject1 = ((WindowInsets)localObject1).getDisplayCutout();
      if (localObject1 != null) {
        localObject1 = new Rect(((DisplayCutout)localObject1).getSafeInsetLeft(), ((DisplayCutout)localObject1).getSafeInsetTop(), j - ((DisplayCutout)localObject1).getSafeInsetRight(), i - ((DisplayCutout)localObject1).getSafeInsetBottom());
      }
    }
    ac.e("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
    label315:
    int m = this.lPW.bsP();
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
      Object localObject = bsR();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.d();
        ((c.d)localObject).height = i;
        if (a.jg(this.mContext) != null) {
          if (!r.dQ(a.jg(this.mContext))) {
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
        i = i.cgk.aH(getContext());
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
    this.jfu = paramBoolean;
  }
  
  public void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(193520);
    this.lPY = paramString;
    if (TextUtils.isEmpty(paramString)) {
      ac.w("Luggage.WXA.WindowAndroidActivityImpl", "setSoftOrientation with default value, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(193520);
  }
  
  public void setWindowDescription(c.b paramb)
  {
    AppMethodBeat.i(176771);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(176771);
      return;
    }
    if ((a.jg(this.mContext) == null) || (paramb == null))
    {
      AppMethodBeat.o(176771);
      return;
    }
    try
    {
      a.jg(this.mContext).setTaskDescription(n.a(paramb));
      AppMethodBeat.o(176771);
      return;
    }
    catch (Exception localException)
    {
      ac.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", new Object[] { localException });
      try
      {
        a.jg(this.mContext).setTaskDescription(n.a(new c.b(paramb.label, paramb.lOP, -16777216)));
        AppMethodBeat.o(176771);
        return;
      }
      catch (Exception paramb)
      {
        ac.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", new Object[] { paramb });
        AppMethodBeat.o(176771);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.o
 * JD-Core Version:    0.7.0.1
 */