package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameCategoryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameCategoryUI$2(GameCategoryUI paramGameCategoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111746);
    paramMenuItem = new Intent(this.nvT, GameSearchUI.class);
    switch (GameCategoryUI.a(this.nvT))
    {
    }
    for (;;)
    {
      this.nvT.startActivity(paramMenuItem);
      AppMethodBeat.o(111746);
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