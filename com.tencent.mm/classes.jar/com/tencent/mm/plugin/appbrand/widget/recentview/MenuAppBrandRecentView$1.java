package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class MenuAppBrandRecentView$1
  implements AppBrandRecentView.b
{
  MenuAppBrandRecentView$1(MenuAppBrandRecentView paramMenuAppBrandRecentView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    if (MenuAppBrandRecentView.a(this.hDo) != null) {}
    for (boolean bool = MenuAppBrandRecentView.a(this.hDo).a(paramView, parama, paramFloat1, paramFloat2);; bool = false)
    {
      if (bool) {
        return true;
      }
      if (parama.type == 2) {
        ((d)g.r(d.class)).cE(this.hDo.getContext());
      }
      for (;;)
      {
        return false;
        paramView = new AppBrandStatObject();
        paramView.scene = 1090;
        ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(this.hDo.getContext(), parama.hqw.username, null, parama.hqw.fJy, -1, null, paramView);
      }
    }
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if (MenuAppBrandRecentView.a(this.hDo) != null) {
      bool = MenuAppBrandRecentView.a(this.hDo).b(paramView, parama, paramFloat1, paramFloat2);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView.1
 * JD-Core Version:    0.7.0.1
 */