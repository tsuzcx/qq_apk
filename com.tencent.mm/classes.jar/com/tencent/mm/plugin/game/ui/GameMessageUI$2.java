package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class GameMessageUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameMessageUI$2(GameMessageUI paramGameMessageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112101);
    GameMessageUI.a(this.nBZ, new GameMessageUI.2.1(this));
    GameMessageUI.b(this.nBZ, new GameMessageUI.2.2(this));
    h.a(this.nBZ.getContext(), 2131300339, 0, GameMessageUI.c(this.nBZ), GameMessageUI.d(this.nBZ));
    AppMethodBeat.o(112101);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.2
 * JD-Core Version:    0.7.0.1
 */