package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameRegionSelectUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GameRegionSelectUI$1(GameRegionSelectUI paramGameRegionSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112158);
    this.nCz.setResult(0);
    this.nCz.hideVKB();
    this.nCz.finish();
    AppMethodBeat.o(112158);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI.1
 * JD-Core Version:    0.7.0.1
 */