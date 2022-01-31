package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDetailUI2$3
  implements View.OnClickListener
{
  GameDetailUI2$3(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111842);
    com.tencent.mm.plugin.game.f.c.a(paramView, this.nyn);
    com.tencent.mm.game.report.c.a(this.nyn.getContext(), 12, 1205, 1, 7, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
    AppMethodBeat.o(111842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.3
 * JD-Core Version:    0.7.0.1
 */