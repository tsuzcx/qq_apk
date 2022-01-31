package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.collection.f;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;

final class i
  extends a
{
  i()
  {
    super(o.gPt.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    paramContext = ((AppBrandSysConfigWC)paramq.getRuntime().ZB()).bFn;
    int j = paramq.getRuntime().fyn.fEL;
    try
    {
      boolean bool = ((af)g.r(af.class)).ap(paramContext, j);
      int k = this.gPE;
      if (bool) {}
      for (int i = y.j.app_brand_usage_remove_collection;; i = y.j.app_brand_usage_add_collection)
      {
        paraml.fq(k, i);
        m.qI(paramString).fzA = bool;
        return;
      }
      return;
    }
    catch (Exception paramq)
    {
      paraml.removeItem(this.gPE);
      y.e("MicroMsg.MenuDelegate_ModifyCollection", "attachTo, query (%s %d) e = %s", new Object[] { paramContext, Integer.valueOf(j), paramq });
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    boolean bool1 = m.qH(paramString).fzA;
    boolean bool2 = f.a(bool1, paramContext, ((AppBrandSysConfigWC)paramq.getRuntime().ZB()).bFn, paramq.getRuntime().fyn.fEL);
    int i;
    if (bool1)
    {
      i = 25;
      if (!bool2) {
        break label83;
      }
    }
    label83:
    for (int j = 1;; j = 2)
    {
      c.a(paramString, paramq.getURL(), i, "", bk.UX(), j, 0);
      return;
      i = 24;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.i
 * JD-Core Version:    0.7.0.1
 */