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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.c.b;
import com.tencent.mm.plugin.appbrand.r.a.c.d;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.am;

public class o
  implements com.tencent.mm.plugin.appbrand.r.a.c
{
  public boolean jyA;
  public Context mContext;
  private k mpL;
  protected c mpM;
  private String mpN;
  private WindowInsets mpO;
  protected boolean mpP;
  private Boolean mpQ;
  private final SparseArray<Rect> mpR;
  
  public o()
  {
    AppMethodBeat.i(176759);
    this.mContext = new MutableContextWrapper(aj.getContext());
    this.jyA = false;
    this.mpP = false;
    this.mpQ = null;
    this.mpR = new SparseArray(4);
    AppMethodBeat.o(176759);
  }
  
  private WindowInsets bwV()
  {
    AppMethodBeat.i(178639);
    Object localObject = a.jq(this.mContext);
    if (localObject != null)
    {
      localObject = am.bh((Activity)localObject);
      this.mpO = ((WindowInsets)localObject);
      AppMethodBeat.o(178639);
      return localObject;
    }
    if (this.mpO != null)
    {
      localObject = this.mpO;
      AppMethodBeat.o(178639);
      return localObject;
    }
    AppMethodBeat.o(178639);
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.r.a.d a(d.b paramb)
  {
    AppMethodBeat.i(197439);
    paramb = new b(this, paramb);
    AppMethodBeat.o(197439);
    return paramb;
  }
  
  protected void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public boolean aWA()
  {
    return false;
  }
  
  public c aWF()
  {
    AppMethodBeat.i(176765);
    if ((this.mpM == null) || (((this.mpM instanceof d)) && (((d)this.mpM).activity != a.jq(this.mContext))))
    {
      if (this.mpM != null) {
        this.mpM.release();
      }
      this.mpM = new d(this);
    }
    c localc = this.mpM;
    AppMethodBeat.o(176765);
    return localc;
  }
  
  public final void aWI()
  {
    AppMethodBeat.i(197442);
    if (!TextUtils.isEmpty(this.mpN))
    {
      ad.i("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.mpN });
      aWF().a(e.b.Uf(this.mpN), null);
      AppMethodBeat.o(197442);
      return;
    }
    if (this.mpM == null)
    {
      ad.w("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation NULL handler, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(197442);
      return;
    }
    e.b localb = this.mpM.aXN();
    if (localb != null)
    {
      ad.i("Luggage.WXA.WindowAndroidActivityImpl", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
      aWF().a(localb, null);
    }
    AppMethodBeat.o(197442);
  }
  
  public final boolean aWM()
  {
    AppMethodBeat.i(176763);
    boolean bool = af.dS(getContext());
    AppMethodBeat.o(176763);
    return bool;
  }
  
  public final boolean aWN()
  {
    AppMethodBeat.i(178636);
    bool2 = af.dS(aj.getContext());
    if ((this.jyA) || (this.mpP))
    {
      AppMethodBeat.o(178636);
      return false;
    }
    try
    {
      if (!com.tencent.mm.sdk.platformtools.i.DEBUG)
      {
        if (this.mpQ == null) {
          if ((!com.tencent.luggage.h.i.cqA.Fv()) || (com.tencent.luggage.h.i.cqA.Fu())) {
            break label93;
          }
        }
        label93:
        for (boolean bool1 = true;; bool1 = false)
        {
          this.mpQ = Boolean.valueOf(bool1);
          bool1 = this.mpQ.booleanValue();
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
      ad.i("Luggage.WXA.WindowAndroidActivityImpl", "shouldInLargeScreenCompatMode: " + localException.getMessage());
      AppMethodBeat.o(178636);
    }
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
    this.mpL = k.a.E(a.jq(this.mContext));
    aWF();
    bwV();
    AppMethodBeat.o(176760);
  }
  
  public final void b(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(176767);
    a(paramLayoutParams);
    AppMethodBeat.o(176767);
  }
  
  public final WindowManager bwU()
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
    synchronized (this.mpR)
    {
      this.mpR.clear();
      getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
      aWF().onConfigurationChanged(paramConfiguration);
      this.mpL.c(paramConfiguration);
      onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(176766);
      return;
    }
  }
  
  public void fA(boolean paramBoolean)
  {
    this.mpP = paramBoolean;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(221151);
    Activity localActivity = a.jq(this.mContext);
    AppMethodBeat.o(221151);
    return localActivity;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(176769);
    Activity localActivity = a.jq(this.mContext);
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
    synchronized (this.mpR)
    {
      Rect localRect2 = (Rect)this.mpR.get(k);
      Object localObject1 = localRect2;
      if (localRect2 == null)
      {
        if (!t.ay(localActivity.getWindow().getDecorView())) {
          break label188;
        }
        localObject1 = localActivity.getWindow().getDecorView();
        j = ((View)localObject1).getWidth();
      }
      for (i = ((View)localObject1).getHeight(); !this.mpL.cx(); i = getVDisplayMetrics().heightPixels)
      {
        localObject1 = new Rect(0, 0, j, i);
        this.mpR.put(k, localObject1);
        AppMethodBeat.o(176769);
        return localObject1;
        label188:
        j = getVDisplayMetrics().widthPixels;
      }
      if (!this.mpL.cx()) {
        break label444;
      }
      if (Build.VERSION.SDK_INT < 28) {
        break label315;
      }
      localObject1 = ((l)this.mpL).vd(k);
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
    int m = this.mpL.bwT();
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
      Object localObject = bwV();
      if (localObject != null)
      {
        i = ((WindowInsets)localObject).getStableInsetTop();
        localObject = new c.d();
        ((c.d)localObject).height = i;
        if (a.jq(this.mContext) != null) {
          if (!s.dP(a.jq(this.mContext))) {
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
        i = com.tencent.luggage.h.i.cqA.aH(getContext());
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
    AppMethodBeat.i(197440);
    if ((af.dS(getContext())) && (!this.mpP)) {
      this.jyA = paramBoolean;
    }
    AppMethodBeat.o(197440);
  }
  
  public void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(197441);
    this.mpN = paramString;
    if (TextUtils.isEmpty(paramString)) {
      ad.w("Luggage.WXA.WindowAndroidActivityImpl", "setSoftOrientation with default value, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(197441);
  }
  
  public void setWindowDescription(c.b paramb)
  {
    AppMethodBeat.i(176771);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(176771);
      return;
    }
    if ((a.jq(this.mContext) == null) || (paramb == null))
    {
      AppMethodBeat.o(176771);
      return;
    }
    try
    {
      a.jq(this.mContext).setTaskDescription(n.a(paramb));
      AppMethodBeat.o(176771);
      return;
    }
    catch (Exception localException)
    {
      ad.e("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", new Object[] { localException });
      try
      {
        a.jq(this.mContext).setTaskDescription(n.a(new c.b(paramb.label, paramb.moF, -16777216)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.o
 * JD-Core Version:    0.7.0.1
 */