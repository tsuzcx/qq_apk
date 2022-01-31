package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;

public final class b
  extends com.tencent.mm.plugin.appbrand.menu.a.a
{
  b()
  {
    super(o.gPj.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    if (paramq.getRuntime().ZH()) {}
    do
    {
      return;
      paramq = paramq.getRuntime().Zz();
    } while ((!(paramq instanceof com.tencent.mm.plugin.appbrand.page.o)) || (!((com.tencent.mm.plugin.appbrand.page.o)paramq).gTs));
    paraml.e(this.gPE, paramContext.getString(y.j.app_brand_back_to_home));
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    paramq.getRuntime().Zz().aa(paramq.getRuntime().getAppConfig().adV(), true);
    if (paramq.gTF != null) {
      c.a(paramString, paramq.getURL(), 20, "", bk.UX(), 1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b
 * JD-Core Version:    0.7.0.1
 */