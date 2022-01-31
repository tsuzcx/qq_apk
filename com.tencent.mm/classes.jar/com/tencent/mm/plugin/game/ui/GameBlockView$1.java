package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameBlockView$1
  implements View.OnClickListener
{
  GameBlockView$1(GameBlockView paramGameBlockView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111743);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String)))
    {
      AppMethodBeat.o(111743);
      return;
    }
    paramView = (String)paramView.getTag();
    int i = com.tencent.mm.plugin.game.f.c.t(this.nvH.getContext(), paramView, "game_center_mygame_more");
    com.tencent.mm.game.report.c.a(this.nvH.getContext(), 10, 1002, 99, i, this.nvG, null);
    AppMethodBeat.o(111743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBlockView.1
 * JD-Core Version:    0.7.0.1
 */