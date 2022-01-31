package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import android.view.View.OnClickListener;

final class BaseAppBrandRecentView$c$1
  implements View.OnClickListener
{
  BaseAppBrandRecentView$c$1(BaseAppBrandRecentView.c paramc, BaseAppBrandRecentView paramBaseAppBrandRecentView) {}
  
  public final void onClick(View paramView)
  {
    a locala = (a)paramView.getTag();
    locala.position = this.hCV.id();
    if (this.hCV.hCR.getOnItemClickListener() != null) {
      this.hCV.hCR.getOnItemClickListener().a(paramView, locala, BaseAppBrandRecentView.c(this.hCV.hCR), BaseAppBrandRecentView.d(this.hCV.hCR));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c.1
 * JD-Core Version:    0.7.0.1
 */