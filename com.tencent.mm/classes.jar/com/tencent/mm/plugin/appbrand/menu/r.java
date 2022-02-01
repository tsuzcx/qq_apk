package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class r
  extends a
{
  public r()
  {
    super(u.nff.ordinal());
    AppMethodBeat.i(47662);
    AppMethodBeat.o(47662);
  }
  
  public final void a(Context paramContext, ac paramac, m paramm, String paramString)
  {
    AppMethodBeat.i(47663);
    g.af(com.tencent.mm.plugin.appbrand.widget.recent.l.class);
    AppMethodBeat.o(47663);
  }
  
  public final void a(Context paramContext, ac paramac, String paramString, t paramt)
  {
    AppMethodBeat.i(47664);
    paramt = paramac.getRuntime().OT();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = paramt.leE;
    AppBrandStickyBannerLogic.a.bYc();
    h.a(paramString, h.d.kzS);
    AppBrandStickyBannerLogic.a.a(paramContext, paramt.appId, paramt.leE.kNW, paramt.brandName, paramt.jyi);
    i.a(paramString, paramac.lBI, 13, "", Util.nowSecond(), 1, 0);
    AppMethodBeat.o(47664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.r
 * JD-Core Version:    0.7.0.1
 */