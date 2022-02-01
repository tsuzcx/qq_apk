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
import com.tencent.mm.ui.ai;
import d.y;

@SuppressLint({"ViewConstructor"})
class i
  extends com.tencent.mm.ui.statusbar.b
  implements v, w
{
  private AppBrandRuntime iGV;
  private WxaAttributes.WxaVersionInfo jfa;
  private f lAl;
  private d.g.a.a<y> lAm;
  
  public i(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(147671);
    this.iGV = paramAppBrandRuntime;
    this.jfa = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(2131099650));
    this.lAl = new ab(paramContext);
    this.lAl.setBackgroundColor(com.tencent.mm.cd.a.n(paramContext, 2131101053));
    addView(this.lAl.getActionView());
    bob();
    AppMethodBeat.o(147671);
  }
  
  protected final void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(196187);
    this.lAl.setMainTitle(paramString1);
    this.lAl.setForegroundStyle(paramString2);
    this.lAl.setLoadingIconVisibility(true);
    this.lAl.setForegroundColor(paramInt2);
    L(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(196187);
  }
  
  public final void bhu()
  {
    AppMethodBeat.i(147673);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147670);
        i.this.setVisibility(8);
        if (i.this.getParent() != null) {
          ((ViewGroup)i.this.getParent()).removeView(i.this);
        }
        i.c(i.this).destroy();
        AppMethodBeat.o(147670);
      }
    });
    AppMethodBeat.o(147673);
  }
  
  protected void bob()
  {
    AppMethodBeat.i(196186);
    this.lAl.hd(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        if (i.a(i.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(i.a(i.this).mAppId, g.d.iDc);
          i.a(i.this).finish();
          AppMethodBeat.o(147669);
          return;
        }
        if (i.b(i.this) != null) {
          i.b(i.this).invoke();
        }
        AppMethodBeat.o(147669);
      }
    };
    this.lAl.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.lAl.setBackButtonClickListener((View.OnClickListener)localObject);
    int m = getContext().getResources().getColor(2131099650);
    int i = getContext().getResources().getColor(2131100711);
    localObject = "white";
    int j = m;
    int k = i;
    if (this.jfa != null)
    {
      if (!ai.Eq()) {
        break label205;
      }
      j = m;
      if (!bt.isNullOrNil(this.jfa.jfL)) {
        j = com.tencent.mm.plugin.appbrand.aa.g.bY(this.jfa.jfL, getContext().getResources().getColor(2131099650));
      }
      if (!bt.isNullOrNil(this.jfa.jfK)) {
        i = com.tencent.mm.plugin.appbrand.aa.g.bY(this.jfa.jfK, getContext().getResources().getColor(2131100711));
      }
      localObject = "white";
    }
    for (k = i;; k = i)
    {
      a(getContext().getString(2131755293), j, (String)localObject, k);
      tc(j);
      AppMethodBeat.o(196186);
      return;
      label205:
      j = m;
      if (!bt.isNullOrNil(this.jfa.jfJ)) {
        j = com.tencent.mm.plugin.appbrand.aa.g.bY(this.jfa.jfJ, getContext().getResources().getColor(2131099650));
      }
      if (!bt.isNullOrNil(this.jfa.jfI)) {
        i = com.tencent.mm.plugin.appbrand.aa.g.bY(this.jfa.jfI, getContext().getResources().getColor(2131100711));
      }
      localObject = "black";
    }
  }
  
  public final void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.lAl.setMainTitle(getContext().getString(2131755293));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void q(d.g.a.a<y> parama)
  {
    this.lAm = parama;
  }
  
  public void setProgress(int paramInt) {}
  
  public final void tc(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(android.support.v4.graphics.b.o(paramInt, getContext().getResources().getColor(2131099650)));
    AppMethodBeat.o(147674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */