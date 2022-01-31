package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDetailRankLikedUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GameDetailRankLikedUI$1(GameDetailRankLikedUI paramGameDetailRankLikedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111823);
    this.nxg.finish();
    AppMethodBeat.o(111823);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.1
 * JD-Core Version:    0.7.0.1
 */