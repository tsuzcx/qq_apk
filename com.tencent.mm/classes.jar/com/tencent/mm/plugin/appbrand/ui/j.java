package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.core.g.z;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;

public class j
  extends com.tencent.mm.ui.statusbar.b
  implements ah, aj
{
  private w qts;
  private WxaAttributes.WxaVersionInfo rbC;
  private f ubx;
  private kotlin.g.a.a<kotlin.ah> uby;
  
  public j(Context paramContext, w paramw, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(322221);
    this.qts = paramw;
    this.rbC = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(a.a.BG_2));
    this.ubx = new ar(paramContext);
    this.ubx.setBackgroundColor(com.tencent.mm.cd.a.w(paramContext, a.a.transparent));
    addView(this.ubx.getActionView());
    cKP();
    AppMethodBeat.o(322221);
  }
  
  private boolean asE()
  {
    AppMethodBeat.i(322226);
    if ((this.qts != null) && ((this.qts instanceof d)) && (this.qts.asE()))
    {
      AppMethodBeat.o(322226);
      return true;
    }
    AppMethodBeat.o(322226);
    return false;
  }
  
  public final void Cj(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(androidx.core.graphics.b.av(paramInt, getContext().getResources().getColor(a.a.BG_2)));
    AppMethodBeat.o(147674);
  }
  
  public final void as(final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322261);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147670);
        j.this.setVisibility(8);
        if (j.this.getParent() != null) {
          ((ViewGroup)j.this.getParent()).removeView(j.this);
        }
        j.c(j.this).destroy();
        if (parama != null) {
          parama.invoke();
        }
        AppMethodBeat.o(147670);
      }
    });
    AppMethodBeat.o(322261);
  }
  
  public final void av(kotlin.g.a.a<kotlin.ah> parama)
  {
    this.uby = parama;
  }
  
  protected final void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(322248);
    this.ubx.setMainTitle(paramString1);
    this.ubx.setForegroundStyle(paramString2);
    this.ubx.setLoadingIconVisibility(true);
    this.ubx.setForegroundColor(paramInt2);
    aj(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(322248);
  }
  
  protected void cKP()
  {
    AppMethodBeat.i(322242);
    this.ubx.hZ(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (j.a(j.this) != null)
        {
          k.a(j.a(j.this).mAppId, k.d.qrG);
          j.a(j.this).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147669);
          return;
          if (j.b(j.this) != null) {
            j.b(j.this).invoke();
          }
        }
      }
    };
    this.ubx.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.ubx.setBackButtonClickListener((View.OnClickListener)localObject);
    int k = getContext().getResources().getColor(a.a.BG_2);
    int i = getContext().getResources().getColor(a.a.normal_text_color);
    String str = "white";
    if (this.qts == null)
    {
      localObject = null;
      if ((localObject == null) || (!((AppBrandInitConfigWC)localObject).qAT.isEnable()) || ((((AppBrandInitConfigWC)localObject).qAT.ckP() != HalfScreenConfig.f.rax) && (((AppBrandInitConfigWC)localObject).qAT.ckP() != HalfScreenConfig.f.raw))) {
        break label249;
      }
      if (((AppBrandInitConfigWC)localObject).qAT.ckP() != HalfScreenConfig.f.rax) {
        break label214;
      }
      j = Color.parseColor("#191919");
      i = Color.parseColor("#CCFFFFFF");
    }
    for (localObject = "black";; localObject = "white")
    {
      this.ubx.setLoadingIconVisibility(false);
      b(getContext().getString(a.g.app_brand_action_plugin_splash_loading), j, (String)localObject, i);
      Cj(j);
      AppMethodBeat.o(322242);
      return;
      localObject = this.qts.getInitConfig();
      break;
      label214:
      j = getContext().getResources().getColor(a.a.White);
      i = getContext().getResources().getColor(a.a.UN_BW_0_Alpha_0_9);
    }
    label249:
    int m = k;
    int j = i;
    localObject = str;
    if (this.rbC != null)
    {
      if (!aw.isDarkMode()) {
        break label378;
      }
      j = k;
      if (!Util.isNullOrNil(this.rbC.rcy)) {
        j = i.dq(this.rbC.rcy, getContext().getResources().getColor(a.a.BG_2));
      }
      if (!Util.isNullOrNil(this.rbC.rcx)) {
        i = i.dq(this.rbC.rcx, getContext().getResources().getColor(a.a.normal_text_color));
      }
      localObject = "white";
      k = i;
      i = j;
    }
    for (;;)
    {
      this.ubx.setLoadingIconVisibility(true);
      j = k;
      m = i;
      i = j;
      j = m;
      break;
      label378:
      if (!Util.isNullOrNil(this.rbC.rcw)) {
        k = i.dq(this.rbC.rcw, getContext().getResources().getColor(a.a.BG_2));
      }
      j = i;
      if (!Util.isNullOrNil(this.rbC.rcv)) {
        j = i.dq(this.rbC.rcv, getContext().getResources().getColor(a.a.normal_text_color));
      }
      localObject = "black";
      i = k;
      k = j;
    }
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.ubx.setMainTitle(getContext().getString(a.g.app_brand_action_plugin_splash_loading));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(322276);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(322276);
      return false;
    }
    if ((!z.ay(this)) && (asE()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(322276);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(322276);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(322282);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(322282);
      return false;
    }
    if ((!z.ay(this)) && (asE()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(322282);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(322282);
    return bool;
  }
  
  public void setBackButtonVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(322254);
    f localf = this.ubx;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localf.setNavHidden(paramBoolean);
      AppMethodBeat.o(322254);
      return;
    }
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(322251);
    this.ubx.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(322251);
  }
  
  public void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */