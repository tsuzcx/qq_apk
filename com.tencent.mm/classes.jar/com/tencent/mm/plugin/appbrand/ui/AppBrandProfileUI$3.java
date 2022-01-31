package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class AppBrandProfileUI$3
  implements n.c
{
  AppBrandProfileUI$3(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void a(l paraml)
  {
    paraml.clear();
    if (((af)g.r(af.class)).ap(AppBrandProfileUI.b(this.hdE), 0)) {}
    for (int i = y.j.app_brand_usage_remove_collection;; i = y.j.app_brand_usage_add_collection)
    {
      paraml.fq(4, i);
      paraml.fq(2, y.j.app_brand_authorize_settings);
      if ((AppBrandProfileUI.c(this.hdE) != null) && (AppBrandProfileUI.c(this.hdE).from == 3) && (AppBrandProfileUI.d(this.hdE))) {
        paraml.fq(3, y.j.app_brand_profile_action_sheet_feedback);
      }
      paraml.fq(1, y.j.app_brand_export);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.3
 * JD-Core Version:    0.7.0.1
 */