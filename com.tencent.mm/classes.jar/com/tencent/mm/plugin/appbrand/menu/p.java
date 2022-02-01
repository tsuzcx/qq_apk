package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;

public final class p
  extends a
{
  public p()
  {
    super(r.lSR.ordinal());
    AppMethodBeat.i(47662);
    AppMethodBeat.o(47662);
  }
  
  public final void a(Context paramContext, aa paramaa, l paraml, String paramString)
  {
    AppMethodBeat.i(47663);
    com.tencent.mm.kernel.g.ab(d.class);
    AppMethodBeat.o(47663);
  }
  
  public final void a(Context paramContext, aa paramaa, String paramString, q paramq)
  {
    AppMethodBeat.i(47664);
    paramq = paramaa.getRuntime().Fh();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = paramq.jYh;
    AppBrandStickyBannerLogic.a.bAc();
    com.tencent.mm.plugin.appbrand.g.a(paramString, g.d.jwo);
    AppBrandStickyBannerLogic.a.a(paramContext, paramq.appId, paramq.jYh.jIU, paramq.doD, paramq.iAa);
    h.a(paramString, paramaa.kuf, 13, "", bt.aQJ(), 1, 0);
    AppMethodBeat.o(47664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.p
 * JD-Core Version:    0.7.0.1
 */