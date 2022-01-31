package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.plugin.game.e.b;

final class GameIndexWxagView$1
  implements View.OnClickListener
{
  GameIndexWxagView$1(GameIndexWxagView paramGameIndexWxagView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof do))) {
      return;
    }
    paramView = (do)paramView.getTag();
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1079;
    ((d)g.r(d.class)).a(this.lbY.getContext(), paramView.hPY, paramView.euK, paramView.kWu, 0, paramView.kWt, localAppBrandStatObject);
    b.a(this.lbY.getContext(), 10, 1025, 999, 30, paramView.euK, this.kXE, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView.1
 * JD-Core Version:    0.7.0.1
 */