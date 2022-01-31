package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.base.l;

public final class f
  extends a
{
  public f()
  {
    super(o.gPo.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    paramq = (AppBrandSysConfigWC)paramq.D(AppBrandSysConfigWC.class);
    if (paramq.fPS.fEM == 1) {
      if (!paramq.fPT) {
        break label49;
      }
    }
    label49:
    for (paramContext = paramContext.getString(y.j.app_brand_performance_disable);; paramContext = paramContext.getString(y.j.app_brand_performance_enable))
    {
      paraml.e(o.gPo.ordinal(), paramContext);
      return;
    }
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    if (!((AppBrandSysConfigWC)paramq.D(AppBrandSysConfigWC.class)).fPT) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppBrandPerformanceManager.vQ(paramString);
      Toast.makeText(paramContext, y.j.app_brand_performance_enable_toast, 0).show();
      return;
    }
    AppBrandPerformanceManager.vR(paramString);
    Toast.makeText(paramContext, y.j.app_brand_performance_disable_toast, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.f
 * JD-Core Version:    0.7.0.1
 */