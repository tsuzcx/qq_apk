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
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.z;

@SuppressLint({"ViewConstructor"})
class k
  extends com.tencent.mm.ui.statusbar.b
  implements w, y
{
  private AppBrandRuntime jDb;
  private WxaAttributes.WxaVersionInfo kcL;
  private e mHu;
  private d.g.a.a<z> mHv;
  
  public k(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(147671);
    this.jDb = paramAppBrandRuntime;
    this.kcL = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(2131099650));
    this.mHu = new ad(paramContext);
    this.mHu.setBackgroundColor(com.tencent.mm.cb.a.n(paramContext, 2131101053));
    addView(this.mHu.getActionView());
    bzZ();
    AppMethodBeat.o(147671);
  }
  
  protected final void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(223106);
    this.mHu.setMainTitle(paramString1);
    this.mHu.setForegroundStyle(paramString2);
    this.mHu.setLoadingIconVisibility(true);
    this.mHu.setForegroundColor(paramInt2);
    M(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(223106);
  }
  
  protected void bzZ()
  {
    AppMethodBeat.i(223105);
    this.mHu.fE(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandPluginLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (k.a(k.this) != null)
        {
          h.a(k.a(k.this).mAppId, h.d.jzh);
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
    this.mHu.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.mHu.setBackButtonClickListener((View.OnClickListener)localObject);
    int m = getContext().getResources().getColor(2131099650);
    int i = getContext().getResources().getColor(2131100711);
    localObject = "white";
    int j = m;
    int k = i;
    if (this.kcL != null)
    {
      if (!al.isDarkMode()) {
        break label205;
      }
      j = m;
      if (!bu.isNullOrNil(this.kcL.kdA)) {
        j = g.ck(this.kcL.kdA, getContext().getResources().getColor(2131099650));
      }
      if (!bu.isNullOrNil(this.kcL.kdz)) {
        i = g.ck(this.kcL.kdz, getContext().getResources().getColor(2131100711));
      }
      localObject = "white";
    }
    for (k = i;; k = i)
    {
      b(getContext().getString(2131755293), j, (String)localObject, k);
      uD(j);
      AppMethodBeat.o(223105);
      return;
      label205:
      j = m;
      if (!bu.isNullOrNil(this.kcL.kdy)) {
        j = g.ck(this.kcL.kdy, getContext().getResources().getColor(2131099650));
      }
      if (!bu.isNullOrNil(this.kcL.kdx)) {
        i = g.ck(this.kcL.kdx, getContext().getResources().getColor(2131100711));
      }
      localObject = "black";
    }
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.mHu.setMainTitle(getContext().getString(2131755293));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setProgress(int paramInt) {}
  
  public final void uD(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(android.support.v4.graphics.b.v(paramInt, getContext().getResources().getColor(2131099650)));
    AppMethodBeat.o(147674);
  }
  
  public final void v(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223107);
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
    AppMethodBeat.o(223107);
  }
  
  public final void x(d.g.a.a<z> parama)
  {
    this.mHv = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */