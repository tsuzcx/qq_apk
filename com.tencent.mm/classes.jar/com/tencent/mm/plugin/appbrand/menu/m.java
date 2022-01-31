package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;

public final class m
  extends a
{
  public m()
  {
    super(o.gPr.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    com.tencent.mm.kernel.g.r(d.class);
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    paramn = paramq.getRuntime().ZB();
    paramn.aej();
    AppBrandStickyBannerLogic.a.apw();
    com.tencent.mm.plugin.appbrand.g.a(paramString, g.c.fyc);
    AppBrandStickyBannerLogic.a.a(paramContext, paramn.appId, paramn.aej(), paramn.bJw, paramn.fPM);
    c.a(paramString, paramq.getURL(), 13, "", bk.UX(), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.m
 * JD-Core Version:    0.7.0.1
 */