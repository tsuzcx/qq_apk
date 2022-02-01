package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;

public final class t
  extends a
{
  public t()
  {
    super(w.qfN.ordinal());
    AppMethodBeat.i(47662);
    AppMethodBeat.o(47662);
  }
  
  public final void a(Context paramContext, ad paramad, o paramo, String paramString)
  {
    AppMethodBeat.i(47663);
    h.ae(com.tencent.mm.plugin.appbrand.widget.recent.k.class);
    AppMethodBeat.o(47663);
  }
  
  public final void a(Context paramContext, ad paramad, String paramString, v paramv)
  {
    AppMethodBeat.i(47664);
    paramv = paramad.getRuntime().Sp();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = paramv.nYR;
    AppBrandStickyBannerLogic.a.ckN();
    com.tencent.mm.plugin.appbrand.k.a(paramString, k.d.nte);
    AppBrandStickyBannerLogic.a.a(paramContext, paramv.appId, paramv.nYR.nHY, paramv.fzM, paramv.mnM);
    j.a(paramString, paramad.oxe, 13, "", Util.nowSecond(), 1, 0);
    AppMethodBeat.o(47664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.t
 * JD-Core Version:    0.7.0.1
 */