package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;

final class GameDetailUI2$13
  implements MenuItem.OnMenuItemClickListener
{
  GameDetailUI2$13(GameDetailUI2 paramGameDetailUI2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111853);
    GameDetailUI2.a(this.nyn, GameDetailUI2.e(this.nyn));
    c.a(this.nyn.getContext(), 12, 1207, 1, 2, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
    AppMethodBeat.o(111853);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.13
 * JD-Core Version:    0.7.0.1
 */