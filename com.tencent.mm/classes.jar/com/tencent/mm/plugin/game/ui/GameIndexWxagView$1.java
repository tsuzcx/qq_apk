package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.game.d.dr;

final class GameIndexWxagView$1
  implements View.OnClickListener
{
  GameIndexWxagView$1(GameIndexWxagView paramGameIndexWxagView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111988);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof dr)))
    {
      AppMethodBeat.o(111988);
      return;
    }
    paramView = (dr)paramView.getTag();
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1079;
    ((j)g.E(j.class)).a(this.nzT.getContext(), paramView.jJA, paramView.fKw, paramView.nuw, 0, paramView.nuv, localAppBrandStatObject);
    c.a(this.nzT.getContext(), 10, 1025, 999, 30, paramView.fKw, this.nvG, null);
    AppMethodBeat.o(111988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView.1
 * JD-Core Version:    0.7.0.1
 */