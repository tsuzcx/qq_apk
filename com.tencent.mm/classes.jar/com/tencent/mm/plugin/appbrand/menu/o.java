package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;

public final class o
  extends a
{
  public o()
  {
    super(q.ltI.ordinal());
    AppMethodBeat.i(47662);
    AppMethodBeat.o(47662);
  }
  
  public final void a(Context paramContext, aa paramaa, l paraml, String paramString)
  {
    AppMethodBeat.i(47663);
    com.tencent.mm.kernel.g.ab(d.class);
    AppMethodBeat.o(47663);
  }
  
  public final void a(Context paramContext, aa paramaa, String paramString, p paramp)
  {
    AppMethodBeat.i(47664);
    paramp = paramaa.getRuntime().DI();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = paramp.jEg;
    AppBrandStickyBannerLogic.a.bvW();
    com.tencent.mm.plugin.appbrand.g.a(paramString, g.d.jdf);
    AppBrandStickyBannerLogic.a.a(paramContext, paramp.appId, paramp.jEg.jpa, paramp.ddh, paramp.igG);
    com.tencent.mm.plugin.appbrand.report.g.a(paramString, paramaa.jZJ, 13, "", bs.aNx(), 1, 0);
    AppMethodBeat.o(47664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o
 * JD-Core Version:    0.7.0.1
 */