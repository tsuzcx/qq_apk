package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameCenterUI5$1
  implements MenuItem.OnMenuItemClickListener
{
  GameCenterUI5$1(GameCenterUI5 paramGameCenterUI5) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111787);
    this.nwz.finish();
    AppMethodBeat.o(111787);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.1
 * JD-Core Version:    0.7.0.1
 */