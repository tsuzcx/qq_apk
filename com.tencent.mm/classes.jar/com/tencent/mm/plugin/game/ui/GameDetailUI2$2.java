package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDetailUI2$2
  implements View.OnClickListener
{
  GameDetailUI2$2(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111841);
    com.tencent.mm.plugin.game.f.c.a(paramView, this.nyn);
    com.tencent.mm.game.report.c.a(this.nyn.getContext(), 12, 1204, 999, 7, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
    AppMethodBeat.o(111841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.2
 * JD-Core Version:    0.7.0.1
 */