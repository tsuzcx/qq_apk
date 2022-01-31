package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.mm;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = (mm)paramView.getTag();
    AppBrandRecommendCategoryListUI.a(this.hkh.context, paramView.sJi, paramView.sJp);
    if (this.hkh.hkg != null) {
      this.hkh.hkg.aqg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b.1
 * JD-Core Version:    0.7.0.1
 */