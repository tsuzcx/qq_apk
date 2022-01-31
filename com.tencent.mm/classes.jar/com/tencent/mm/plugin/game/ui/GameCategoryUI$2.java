package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class GameCategoryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameCategoryUI$2(GameCategoryUI paramGameCategoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.kXR, GameSearchUI.class);
    switch (GameCategoryUI.a(this.kXR))
    {
    }
    for (;;)
    {
      this.kXR.startActivity(paramMenuItem);
      return true;
      paramMenuItem.putExtra("game_report_from_scene", 1602);
      continue;
      paramMenuItem.putExtra("game_report_from_scene", 1502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.2
 * JD-Core Version:    0.7.0.1
 */