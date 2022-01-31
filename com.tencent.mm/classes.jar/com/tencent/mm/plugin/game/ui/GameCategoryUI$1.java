package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameCategoryUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GameCategoryUI$1(GameCategoryUI paramGameCategoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111745);
    this.nvT.finish();
    AppMethodBeat.o(111745);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.1
 * JD-Core Version:    0.7.0.1
 */