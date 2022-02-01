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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import d.y;

@SuppressLint({"ViewConstructor"})
class i
  extends com.tencent.mm.ui.statusbar.b
  implements u, v
{
  private WxaAttributes.WxaVersionInfo jFp;
  private AppBrandRuntime jgY;
  private f mch;
  private d.g.a.a<y> mci;
  
  public i(Context paramContext, AppBrandRuntime paramAppBrandRuntime, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    super(paramContext);
    AppMethodBeat.i(147671);
    this.jgY = paramAppBrandRuntime;
    this.jFp = paramWxaVersionInfo;
    setBackgroundColor(getResources().getColor(2131099650));
    this.mch = new aa(paramContext);
    this.mch.setBackgroundColor(com.tencent.mm.cc.a.n(paramContext, 2131101053));
    addView(this.mch.getActionView());
    buX();
    AppMethodBeat.o(147671);
  }
  
  protected final void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(187032);
    this.mch.setMainTitle(paramString1);
    this.mch.setForegroundStyle(paramString2);
    this.mch.setLoadingIconVisibility(true);
    this.mch.setForegroundColor(paramInt2);
    L(paramInt1, "black".equals(paramString2));
    AppMethodBeat.o(187032);
  }
  
  public final void boo()
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
  
  protected void buX()
  {
    AppMethodBeat.i(187031);
    this.mch.hA(false);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147669);
        if (i.a(i.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(i.a(i.this).mAppId, g.d.jdc);
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
    this.mch.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.mch.setBackButtonClickListener((View.OnClickListener)localObject);
    int m = getContext().getResources().getColor(2131099650);
    int i = getContext().getResources().getColor(2131100711);
    localObject = "white";
    int j = m;
    int k = i;
    if (this.jFp != null)
    {
      if (!aj.DT()) {
        break label205;
      }
      j = m;
      if (!bs.isNullOrNil(this.jFp.jGa)) {
        j = com.tencent.mm.plugin.appbrand.z.g.cd(this.jFp.jGa, getContext().getResources().getColor(2131099650));
      }
      if (!bs.isNullOrNil(this.jFp.jFZ)) {
        i = com.tencent.mm.plugin.appbrand.z.g.cd(this.jFp.jFZ, getContext().getResources().getColor(2131100711));
      }
      localObject = "white";
    }
    for (k = i;; k = i)
    {
      a(getContext().getString(2131755293), j, (String)localObject, k);
      tT(j);
      AppMethodBeat.o(187031);
      return;
      label205:
      j = m;
      if (!bs.isNullOrNil(this.jFp.jFY)) {
        j = com.tencent.mm.plugin.appbrand.z.g.cd(this.jFp.jFY, getContext().getResources().getColor(2131099650));
      }
      if (!bs.isNullOrNil(this.jFp.jFX)) {
        i = com.tencent.mm.plugin.appbrand.z.g.cd(this.jFp.jFX, getContext().getResources().getColor(2131100711));
      }
      localObject = "black";
    }
  }
  
  public final void dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147672);
    this.mch.setMainTitle(getContext().getString(2131755293));
    AppMethodBeat.o(147672);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setProgress(int paramInt) {}
  
  public final void tT(int paramInt)
  {
    AppMethodBeat.i(147674);
    setBackgroundColor(android.support.v4.graphics.b.o(paramInt, getContext().getResources().getColor(2131099650)));
    AppMethodBeat.o(147674);
  }
  
  public final void u(d.g.a.a<y> parama)
  {
    this.mci = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */