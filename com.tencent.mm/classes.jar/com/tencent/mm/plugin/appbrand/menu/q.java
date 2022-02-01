package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;

public final class q
  extends a
{
  public q()
  {
    super(s.lXs.ordinal());
    AppMethodBeat.i(47662);
    AppMethodBeat.o(47662);
  }
  
  public final void a(Context paramContext, z paramz, l paraml, String paramString)
  {
    AppMethodBeat.i(47663);
    g.ab(d.class);
    AppMethodBeat.o(47663);
  }
  
  public final void a(Context paramContext, z paramz, String paramString, r paramr)
  {
    AppMethodBeat.i(47664);
    paramr = paramz.getRuntime().Fm();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = paramr.kbw;
    AppBrandStickyBannerLogic.a.bAX();
    com.tencent.mm.plugin.appbrand.h.a(paramString, h.d.jzk);
    AppBrandStickyBannerLogic.a.a(paramContext, paramr.appId, paramr.kbw.jLV, paramr.dpI, paramr.iCT);
    com.tencent.mm.plugin.appbrand.report.h.a(paramString, paramz.kxv, 13, "", bu.aRi(), 1, 0);
    AppMethodBeat.o(47664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.q
 * JD-Core Version:    0.7.0.1
 */