package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;

final class MenuAppBrandRecentView$1
  implements AppBrandRecentView.b
{
  MenuAppBrandRecentView$1(MenuAppBrandRecentView paramMenuAppBrandRecentView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134382);
    if (MenuAppBrandRecentView.a(this.jvP) != null) {}
    for (boolean bool = MenuAppBrandRecentView.a(this.jvP).a(paramView, parama, paramFloat1, paramFloat2);; bool = false)
    {
      if (bool)
      {
        AppMethodBeat.o(134382);
        return true;
      }
      if (parama.type != 2)
      {
        paramView = new AppBrandStatObject();
        paramView.scene = 1090;
        ((j)g.E(j.class)).a(this.jvP.getContext(), parama.jfk.username, null, parama.jfk.hcr, -1, null, paramView);
      }
      AppMethodBeat.o(134382);
      return false;
    }
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134383);
    boolean bool = false;
    if (MenuAppBrandRecentView.a(this.jvP) != null) {
      bool = MenuAppBrandRecentView.a(this.jvP).b(paramView, parama, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(134383);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView.1
 * JD-Core Version:    0.7.0.1
 */