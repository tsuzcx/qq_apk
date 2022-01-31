package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class GameLibraryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameLibraryUI$2(GameLibraryUI paramGameLibraryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.lcP, GameSearchUI.class);
    paramMenuItem.putExtra("game_report_from_scene", 1109);
    this.lcP.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.2
 * JD-Core Version:    0.7.0.1
 */