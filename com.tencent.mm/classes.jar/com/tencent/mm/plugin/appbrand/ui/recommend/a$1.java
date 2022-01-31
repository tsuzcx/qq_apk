package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.mm;

final class a$1
  extends c
{
  a$1(a parama, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  final void F(Runnable paramRunnable)
  {
    this.hkc.F(paramRunnable);
  }
  
  public final long aqa()
  {
    return com.tencent.mm.plugin.appbrand.appusage.a.a.adA().fKk;
  }
  
  public final boolean aqb()
  {
    return true;
  }
  
  public final String aqc()
  {
    return this.hkc.getString(y.j.app_brand_recommend_list_header_text_all_use);
  }
  
  public final boolean aqd()
  {
    return true;
  }
  
  public final mm aqe()
  {
    return null;
  }
  
  final boolean aqf()
  {
    return false;
  }
  
  public final View getContentView()
  {
    return this.hkc.QR;
  }
  
  public final int getFilterType()
  {
    return 3;
  }
  
  public final void init()
  {
    com.tencent.mm.plugin.appbrand.appusage.a.a.adA().fKk = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.1
 * JD-Core Version:    0.7.0.1
 */