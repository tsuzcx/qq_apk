package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.l;

public final class e
  extends a
{
  public e()
  {
    super(o.gPx.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    if (AppBrandPerformanceManager.vS(paramString))
    {
      paramContext = paramContext.getString(y.j.app_brand_performance_dump_trace);
      paraml.e(o.gPx.ordinal(), paramContext);
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    Toast.makeText(paramContext, y.j.app_brand_performance_dump_trace_start, 0).show();
    c.DS().O(new e.1(this, paramString, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.e
 * JD-Core Version:    0.7.0.1
 */