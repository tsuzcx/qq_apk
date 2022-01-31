package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class p
  extends a
{
  public p()
  {
    super(r.iqZ.ordinal());
    AppMethodBeat.i(132251);
    AppMethodBeat.o(132251);
  }
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(132252);
    g.E(d.class);
    AppMethodBeat.o(132252);
  }
  
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(132253);
    paramq = paramv.getRuntime().wY();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = paramq.hiX;
    AppBrandStickyBannerLogic.a.aMM();
    com.tencent.mm.plugin.appbrand.e.a(paramString, e.d.gPh);
    AppBrandStickyBannerLogic.a.a(paramContext, paramq.appId, paramq.hiX.gXe, paramq.cqQ, paramq.hiQ);
    com.tencent.mm.plugin.appbrand.report.e.a(paramString, paramv.hzM, 13, "", bo.aox(), 1, 0);
    AppMethodBeat.o(132253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.p
 * JD-Core Version:    0.7.0.1
 */