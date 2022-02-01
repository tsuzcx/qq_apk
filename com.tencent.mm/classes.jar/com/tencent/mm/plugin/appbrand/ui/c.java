package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.ad.e.4;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.z;

@SuppressLint({"ViewConstructor"})
public final class c
  extends com.tencent.mm.ui.statusbar.b
  implements q, v, w, x, y
{
  private com.tencent.mm.plugin.appbrand.o jCo;
  private v mzr;
  private e mzs;
  private com.tencent.mm.plugin.appbrand.ad.i mzt;
  private Boolean mzu;
  
  public c(Context paramContext, AppBrandRuntime paramAppBrandRuntime, v paramv, com.tencent.mm.plugin.appbrand.ad.i parami)
  {
    super(paramContext);
    AppMethodBeat.i(188797);
    this.jCo = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    this.mzr = paramv;
    this.mzt = parami;
    paramAppBrandRuntime = this.jCo;
    ad.i("MicroMsg.AppBrandAdLoadingSplash", "initRuntimeAdViewContainer, runtime:%s", new Object[] { paramAppBrandRuntime });
    this.mzs = new e(paramContext, paramAppBrandRuntime);
    this.mzs.aYd();
    this.mzs.aYe();
    this.mzs.setForegroundStyle(false);
    this.mzs.setCloseButtonClickListener(new c.1(this));
    this.mzs.setOnHideListener(new c.2(this));
    this.mzs.setOptionButtonClickListener(new c.3(this));
    if (this.mzr != null) {
      addView(this.mzr.getView(), new ViewGroup.LayoutParams(-1, -1));
    }
    if (this.mzs != null) {
      addView(this.mzs, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(188797);
  }
  
  public final boolean aWo()
  {
    AppMethodBeat.i(188803);
    if ((this.mzs != null) && (indexOfChild(this.mzs) >= 0) && (this.mzs.getVisibility() == 0) && (n.KE(this.jCo.mAppId).jyS.jBJ))
    {
      AppMethodBeat.o(188803);
      return true;
    }
    AppMethodBeat.o(188803);
    return false;
  }
  
  public final void aYl()
  {
    AppMethodBeat.i(188799);
    if (this.mzt != null) {
      this.mzt.aYl();
    }
    AppMethodBeat.o(188799);
  }
  
  public final void aYn()
  {
    AppMethodBeat.i(188800);
    if (this.mzs != null)
    {
      e locale = this.mzs;
      if (aq.isMainThread())
      {
        locale.setVisibility(8);
        AppMethodBeat.o(188800);
        return;
      }
      aq.f(new e.4(locale));
    }
    AppMethodBeat.o(188800);
  }
  
  public final void byT()
  {
    AppMethodBeat.i(188802);
    this.jCo.j(new c.4(this), 0L);
    AppMethodBeat.o(188802);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188804);
    if (this.mzr != null) {
      this.mzr.dV(paramString1, paramString2);
    }
    AppMethodBeat.o(188804);
  }
  
  public final v getInternalLoadingSplash()
  {
    return this.mzr;
  }
  
  public final e getRuntimeAdViewContainer()
  {
    return this.mzs;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void l(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(188801);
    if (this.mzs != null) {
      this.mzs.j(paramBoolean, paramString);
    }
    AppMethodBeat.o(188801);
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(188798);
    super.onAttachedToWindow();
    int i = getResources().getColor(2131099650);
    if (this.mzu == null) {
      this.mzu = Boolean.valueOf(com.tencent.luggage.h.i.cqA.isDarkMode());
    }
    boolean bool;
    if (!this.mzu.booleanValue())
    {
      bool = true;
      L(i, bool);
    }
    for (;;)
    {
      try
      {
        Object localObject1 = getContext().getResources().getConfiguration();
        if ((this.jCo.getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.r.a.a.o))
        {
          Object localObject2 = com.tencent.mm.sdk.f.a.jq(((com.tencent.mm.plugin.appbrand.r.a.a.o)this.jCo.getWindowAndroid()).mContext);
          if (((Configuration)localObject1).orientation != 2) {
            break label233;
          }
          i = 1;
          if (((i == 0) || (localObject2 == null) || (Build.VERSION.SDK_INT < 24) || (!((Activity)localObject2).isInMultiWindowMode()) || (((Activity)localObject2).getRequestedOrientation() != 1)) && (localObject2 != null))
          {
            localObject1 = ((Activity)localObject2).getWindow();
            localObject2 = ((Window)localObject1).getDecorView();
            if (i != 0)
            {
              ((Window)localObject1).addFlags(1024);
              ((View)localObject2).setSystemUiVisibility(((View)localObject2).getSystemUiVisibility() | 0x4 | 0x100);
              AppMethodBeat.o(188798);
              return;
            }
            s.a((Window)localObject1, false, false);
          }
        }
        AppMethodBeat.o(188798);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppBrandAdLoadingSplash", "onAttachedToWindow exception", new Object[] { localException });
        AppMethodBeat.o(188798);
        return;
      }
      bool = false;
      break;
      label233:
      i = 0;
    }
  }
  
  public final void rC(int paramInt)
  {
    AppMethodBeat.i(188808);
    if ((this.mzr instanceof q)) {
      ((q)this.mzr).rC(paramInt);
    }
    AppMethodBeat.o(188808);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(188809);
    if ((this.mzr instanceof y)) {
      ((y)this.mzr).setCanShowHideAnimation(paramBoolean);
    }
    AppMethodBeat.o(188809);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(188806);
    if (this.mzr != null) {
      this.mzr.setProgress(paramInt);
    }
    AppMethodBeat.o(188806);
  }
  
  public final void u(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(188805);
    if (this.mzr != null) {
      this.mzr.u(parama);
    }
    AppMethodBeat.o(188805);
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(188807);
    if (this.mzr != null) {
      this.mzr.ux(paramInt);
    }
    AppMethodBeat.o(188807);
  }
  
  public final void w(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(188810);
    if ((this.mzr instanceof x)) {
      ((x)this.mzr).w(parama);
    }
    AppMethodBeat.o(188810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */