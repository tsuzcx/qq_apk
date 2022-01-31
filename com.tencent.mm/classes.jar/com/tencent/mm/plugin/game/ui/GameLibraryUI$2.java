package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLibraryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameLibraryUI$2(GameLibraryUI paramGameLibraryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112031);
    paramMenuItem = new Intent(this.nAK, GameSearchUI.class);
    paramMenuItem.putExtra("game_report_from_scene", 1109);
    this.nAK.startActivity(paramMenuItem);
    AppMethodBeat.o(112031);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.2
 * JD-Core Version:    0.7.0.1
 */