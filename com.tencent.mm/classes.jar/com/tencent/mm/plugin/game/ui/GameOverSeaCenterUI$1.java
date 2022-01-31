package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameOverSeaCenterUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GameOverSeaCenterUI$1(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112125);
    this.nCm.finish();
    AppMethodBeat.o(112125);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.1
 * JD-Core Version:    0.7.0.1
 */