package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appusage.a.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.mm;

final class AppBrandRecommendCategoryListUI$1
  extends c
{
  AppBrandRecommendCategoryListUI$1(AppBrandRecommendCategoryListUI paramAppBrandRecommendCategoryListUI, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  final void F(Runnable paramRunnable)
  {
    this.hkp.runOnUiThread(paramRunnable);
  }
  
  public final long aqa()
  {
    return a.adA().fKl;
  }
  
  public final boolean aqb()
  {
    return false;
  }
  
  public final String aqc()
  {
    return this.hkp.getString(y.j.app_brand_recommend_list_header_text_category_name, new Object[] { this.hkp.hko.sJp });
  }
  
  public final boolean aqd()
  {
    return false;
  }
  
  public final mm aqe()
  {
    return this.hkp.hko;
  }
  
  final boolean aqf()
  {
    return true;
  }
  
  public final View getContentView()
  {
    return AppBrandRecommendCategoryListUI.a(this.hkp);
  }
  
  public final int getFilterType()
  {
    return 4;
  }
  
  public final void init()
  {
    a.adA().fKl = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendCategoryListUI.1
 * JD-Core Version:    0.7.0.1
 */