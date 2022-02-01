package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.core.g.w;
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public class k
  extends com.tencent.mm.ui.statusbar.b
  implements aa, ac
{
  private AppBrandRuntime nxs;
  private WxaAttributes.WxaVersionInfo oaQ;
  private f qVP;
  private kotlin.g.a.a<x> qVQ;
  
  public k(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(147671);
    this.nxs = paramAppBrandRuntime;
    this.oaQ = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(a.a.BG_2));
    this.qVP = new aj(paramContext);
    this.qVP.setBackgroundColor(com.tencent.mm.ci.a.w(paramContext, a.a.transparent));
    addView(this.qVP.getActionView());
    cjB();
    AppMethodBeat.o(147671);
  }
  
  private boolean So()
  {
    AppMethodBeat.i(278043);
    if ((this.nxs != null) && ((this.nxs instanceof d)) && (((d)this.nxs).So()))
    {
      AppMethodBeat.o(278043);
      return true;
    }
    AppMethodBeat.o(278043);
    return false;
  }
  
  public final void A(kotlin.g.a.a<x> parama)
  {
    this.qVQ = parama;
  }
  
  public final void BU(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(androidx.core.graphics.b.A(paramInt, getContext().getResources().getColor(a.a.BG_2)));
    AppMethodBeat.o(147674);
  }
  
  protected final void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(278032);
    this.qVP.setMainTitle(paramString1);
    this.qVP.setForegroundStyle(paramString2);
    this.qVP.setLoadingIconVisibility(true);
    this.qVP.setForegroundColor(paramInt2);
    T(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(278032);
  }
  
  protected void cjB()
  {
    AppMethodBeat.i(278030);
    this.qVP.hk(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (k.a(k.this) != null)
        {
          com.tencent.mm.plugin.appbrand.k.a(k.a(k.this).mAppId, k.d.ntb);
          k.a(k.this).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147669);
          return;
          if (k.b(k.this) != null) {
            k.b(k.this).invoke();
          }
        }
      }
    };
    this.qVP.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.qVP.setBackButtonClickListener((View.OnClickListener)localObject);
    int j = getContext().getResources().getColor(a.a.BG_2);
    int i = getContext().getResources().getColor(a.a.normal_text_color);
    String str = "white";
    if (this.nxs == null)
    {
      localObject = null;
      if ((!(localObject instanceof AppBrandInitConfigWC)) || (!((AppBrandInitConfigWC)localObject).nBE.isEnable()) || (!((AppBrandInitConfigWC)localObject).nBE.nnk)) {
        break label198;
      }
      j = getContext().getResources().getColor(a.a.White);
      i = getContext().getResources().getColor(a.a.UN_BW_0_Alpha_0_9);
      localObject = "white";
      this.qVP.setLoadingIconVisibility(false);
    }
    for (;;)
    {
      b(getContext().getString(a.g.app_brand_action_plugin_splash_loading), j, (String)localObject, i);
      BU(j);
      AppMethodBeat.o(278030);
      return;
      localObject = this.nxs.Sq();
      break;
      label198:
      if (this.oaQ != null)
      {
        if (ar.isDarkMode())
        {
          if (Util.isNullOrNil(this.oaQ.obL)) {
            break label384;
          }
          j = g.cO(this.oaQ.obL, getContext().getResources().getColor(a.a.BG_2));
        }
        for (;;)
        {
          if (!Util.isNullOrNil(this.oaQ.obK)) {
            i = g.cO(this.oaQ.obK, getContext().getResources().getColor(a.a.normal_text_color));
          }
          for (;;)
          {
            for (localObject = "white";; localObject = "black")
            {
              this.qVP.setLoadingIconVisibility(true);
              break;
              if (!Util.isNullOrNil(this.oaQ.obJ)) {
                j = g.cO(this.oaQ.obJ, getContext().getResources().getColor(a.a.BG_2));
              }
              if (!Util.isNullOrNil(this.oaQ.obI)) {
                i = g.cO(this.oaQ.obI, getContext().getResources().getColor(a.a.normal_text_color));
              }
            }
          }
        }
      }
      label384:
      localObject = str;
    }
  }
  
  public final void eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.qVP.setMainTitle(getContext().getString(a.g.app_brand_action_plugin_splash_loading));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(278045);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(278045);
      return false;
    }
    if ((!w.al(this)) && (So()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(278045);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(278045);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(278047);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(278047);
      return false;
    }
    if ((!w.al(this)) && (So()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(278047);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(278047);
    return bool;
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(278034);
    this.qVP.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(278034);
  }
  
  public void setProgress(int paramInt) {}
  
  public final void x(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(278037);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147670);
        k.this.setVisibility(8);
        if (k.this.getParent() != null) {
          ((ViewGroup)k.this.getParent()).removeView(k.this);
        }
        k.c(k.this).destroy();
        if (parama != null) {
          parama.invoke();
        }
        AppMethodBeat.o(147670);
      }
    });
    AppMethodBeat.o(278037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */