package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDetailUI2$5
  implements View.OnClickListener
{
  GameDetailUI2$5(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111844);
    com.tencent.mm.plugin.game.f.c.a(paramView, this.nyn);
    com.tencent.mm.game.report.c.a(this.nyn.getContext(), 12, 1206, 1, 7, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
    AppMethodBeat.o(111844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.5
 * JD-Core Version:    0.7.0.1
 */