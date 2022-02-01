package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.snackbar.b;

public final class t
  extends a
{
  public t()
  {
    super(x.tkr.ordinal());
    AppMethodBeat.i(47662);
    AppMethodBeat.o(47662);
  }
  
  public final void a(Context paramContext, ad paramad, s params, String paramString)
  {
    AppMethodBeat.i(47663);
    int i;
    if (!((com.tencent.mm.plugin.appbrand.widget.recent.k)h.ax(com.tencent.mm.plugin.appbrand.widget.recent.k.class)).cSP())
    {
      boolean bool = AppBrandStickyBannerLogic.a.dk(paramString, paramad.getRuntime().asG().qYY.qHO);
      i = this.tlb;
      if (!bool) {
        break label74;
      }
    }
    label74:
    for (paramContext = paramContext.getString(ba.i.app_brand_action_sheet_unstick_in_wechat);; paramContext = paramContext.getString(ba.i.app_brand_action_sheet_stick_in_wechat))
    {
      params.c(i, paramContext);
      AppMethodBeat.o(47663);
      return;
    }
  }
  
  public final void a(Context paramContext, ad paramad, String paramString, w paramw)
  {
    AppMethodBeat.i(47664);
    paramw = paramad.getRuntime().asG();
    if (AppBrandStickyBannerLogic.a.dk(paramw.appId, paramw.qYY.qHO))
    {
      AppBrandStickyBannerLogic.a.agm(paramw.appId);
      b.a(paramContext, ((Activity)paramContext).findViewById(16908290), paramContext.getString(ba.i.app_brand_action_sheet_unstick_in_wechat_toast), null);
    }
    for (;;)
    {
      j.a(paramString, paramad.cgR(), 13, "", Util.nowSecond(), 1, 0);
      AppMethodBeat.o(47664);
      return;
      com.tencent.mm.plugin.appbrand.k.a(paramString, k.d.qrJ);
      AppBrandStickyBannerLogic.a.a(paramContext, paramw.appId, paramw.qYY.qHO, paramw.hEy, paramw.phA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.t
 * JD-Core Version:    0.7.0.1
 */