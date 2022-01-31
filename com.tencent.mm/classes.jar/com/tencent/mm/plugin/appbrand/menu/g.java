package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.base.l;
import java.util.Map;

public final class g
  extends a
{
  g()
  {
    super(o.gPq.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    if (bl.csf()) {
      paraml.a(this.gPE, paramContext.getResources().getColor(y.d.red_text_color), paramContext.getString(y.j.app_brand_back));
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    paramq.Zy().aau().get("exitMiniProgram");
    paramContext = paramq.Zy();
    new com.tencent.mm.ab.i();
    paramContext.getRuntime().finish();
    c.a(paramString, paramq.getURL(), 10, "", bk.UX(), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.g
 * JD-Core Version:    0.7.0.1
 */