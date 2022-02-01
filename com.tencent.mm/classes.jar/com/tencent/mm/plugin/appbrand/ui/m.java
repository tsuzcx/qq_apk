package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public class m
  extends com.tencent.mm.ui.statusbar.b
  implements ab, ad
{
  private AppBrandRuntime kEc;
  private WxaAttributes.WxaVersionInfo lgq;
  private e nUs;
  private kotlin.g.a.a<x> nUt;
  
  public m(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(147671);
    this.kEc = paramAppBrandRuntime;
    this.lgq = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(2131099650));
    this.nUs = new aj(paramContext);
    this.nUs.setBackgroundColor(com.tencent.mm.cb.a.n(paramContext, 2131101287));
    addView(this.nUs.getActionView());
    bWX();
    AppMethodBeat.o(147671);
  }
  
  private boolean OS()
  {
    AppMethodBeat.i(227624);
    if ((this.kEc != null) && ((this.kEc instanceof d)) && (((d)this.kEc).OS()))
    {
      AppMethodBeat.o(227624);
      return true;
    }
    AppMethodBeat.o(227624);
    return false;
  }
  
  public final void C(kotlin.g.a.a<x> parama)
  {
    this.nUt = parama;
  }
  
  protected final void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(227621);
    this.nUs.setMainTitle(paramString1);
    this.nUs.setForegroundStyle(paramString2);
    this.nUs.setLoadingIconVisibility(true);
    this.nUs.setForegroundColor(paramInt2);
    S(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(227621);
  }
  
  protected void bWX()
  {
    AppMethodBeat.i(227620);
    this.nUs.gz(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (m.a(m.this) != null)
        {
          h.a(m.a(m.this).mAppId, h.d.kzP);
          m.a(m.this).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147669);
          return;
          if (m.b(m.this) != null) {
            m.b(m.this).invoke();
          }
        }
      }
    };
    this.nUs.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.nUs.setBackButtonClickListener((View.OnClickListener)localObject);
    int j = getContext().getResources().getColor(2131099650);
    int i = getContext().getResources().getColor(2131100904);
    String str = "white";
    if (this.kEc == null)
    {
      localObject = null;
      if ((!(localObject instanceof AppBrandInitConfigWC)) || (!((AppBrandInitConfigWC)localObject).kHL.isEnable()) || (!((AppBrandInitConfigWC)localObject).kHL.kuZ)) {
        break label193;
      }
      j = getContext().getResources().getColor(2131099844);
      i = getContext().getResources().getColor(2131099836);
      localObject = "white";
      this.nUs.setLoadingIconVisibility(false);
    }
    for (;;)
    {
      b(getContext().getString(2131755329), j, (String)localObject, i);
      yu(j);
      AppMethodBeat.o(227620);
      return;
      localObject = this.kEc.OU();
      break;
      label193:
      if (this.lgq != null)
      {
        if (ao.isDarkMode())
        {
          if (Util.isNullOrNil(this.lgq.lhf)) {
            break label375;
          }
          j = g.cu(this.lgq.lhf, getContext().getResources().getColor(2131099650));
        }
        label375:
        for (;;)
        {
          if (!Util.isNullOrNil(this.lgq.lhe)) {
            i = g.cu(this.lgq.lhe, getContext().getResources().getColor(2131100904));
          }
          for (;;)
          {
            for (localObject = "white";; localObject = "black")
            {
              this.nUs.setLoadingIconVisibility(true);
              break;
              if (!Util.isNullOrNil(this.lgq.lhd)) {
                j = g.cu(this.lgq.lhd, getContext().getResources().getColor(2131099650));
              }
              if (!Util.isNullOrNil(this.lgq.lhc)) {
                i = g.cu(this.lgq.lhc, getContext().getResources().getColor(2131100904));
              }
            }
          }
        }
      }
      localObject = str;
    }
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.nUs.setMainTitle(getContext().getString(2131755329));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(227625);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(227625);
      return false;
    }
    if ((!u.aD(this)) && (OS()))
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(227625);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(227625);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(227626);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(227626);
      return false;
    }
    if ((!u.aD(this)) && (OS()))
    {
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(227626);
      return true;
    }
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(227626);
    return bool;
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(227622);
    this.nUs.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(227622);
  }
  
  public void setProgress(int paramInt) {}
  
  public final void yu(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(android.support.v4.graphics.b.v(paramInt, getContext().getResources().getColor(2131099650)));
    AppMethodBeat.o(147674);
  }
  
  public final void z(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227623);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147670);
        m.this.setVisibility(8);
        if (m.this.getParent() != null) {
          ((ViewGroup)m.this.getParent()).removeView(m.this);
        }
        m.c(m.this).destroy();
        if (parama != null) {
          parama.invoke();
        }
        AppMethodBeat.o(147670);
      }
    });
    AppMethodBeat.o(227623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */