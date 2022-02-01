package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import d.z;

@SuppressLint({"ViewConstructor"})
class j
  extends com.tencent.mm.ui.statusbar.b
  implements v, x
{
  private WxaAttributes.WxaVersionInfo jZu;
  private AppBrandRuntime jzY;
  private f mCp;
  private d.g.a.a<z> mCq;
  
  public j(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(147671);
    this.jzY = paramAppBrandRuntime;
    this.jZu = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(2131099650));
    this.mCp = new ac(paramContext);
    this.mCp.setBackgroundColor(com.tencent.mm.cc.a.n(paramContext, 2131101053));
    addView(this.mCp.getActionView());
    bze();
    AppMethodBeat.o(147671);
  }
  
  protected final void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(188874);
    this.mCp.setMainTitle(paramString1);
    this.mCp.setForegroundStyle(paramString2);
    this.mCp.setLoadingIconVisibility(true);
    this.mCp.setForegroundColor(paramInt2);
    L(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(188874);
  }
  
  protected void bze()
  {
    AppMethodBeat.i(188873);
    this.mCp.hK(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (j.a(j.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(j.a(j.this).mAppId, g.d.jwl);
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
    this.mCp.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.mCp.setBackButtonClickListener((View.OnClickListener)localObject);
    int m = getContext().getResources().getColor(2131099650);
    int i = getContext().getResources().getColor(2131100711);
    localObject = "white";
    int j = m;
    int k = i;
    if (this.jZu != null)
    {
      if (!al.isDarkMode()) {
        break label205;
      }
      j = m;
      if (!bt.isNullOrNil(this.jZu.kaj)) {
        j = com.tencent.mm.plugin.appbrand.z.g.cg(this.jZu.kaj, getContext().getResources().getColor(2131099650));
      }
      if (!bt.isNullOrNil(this.jZu.kai)) {
        i = com.tencent.mm.plugin.appbrand.z.g.cg(this.jZu.kai, getContext().getResources().getColor(2131100711));
      }
      localObject = "white";
    }
    for (k = i;; k = i)
    {
      b(getContext().getString(2131755293), j, (String)localObject, k);
      ux(j);
      AppMethodBeat.o(188873);
      return;
      label205:
      j = m;
      if (!bt.isNullOrNil(this.jZu.kah)) {
        j = com.tencent.mm.plugin.appbrand.z.g.cg(this.jZu.kah, getContext().getResources().getColor(2131099650));
      }
      if (!bt.isNullOrNil(this.jZu.kag)) {
        i = com.tencent.mm.plugin.appbrand.z.g.cg(this.jZu.kag, getContext().getResources().getColor(2131100711));
      }
      localObject = "black";
    }
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.mCp.setMainTitle(getContext().getString(2131755293));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setProgress(int paramInt) {}
  
  public final void u(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(188875);
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
    AppMethodBeat.o(188875);
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(android.support.v4.graphics.b.v(paramInt, getContext().getResources().getColor(2131099650)));
    AppMethodBeat.o(147674);
  }
  
  public final void w(d.g.a.a<z> parama)
  {
    this.mCq = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */