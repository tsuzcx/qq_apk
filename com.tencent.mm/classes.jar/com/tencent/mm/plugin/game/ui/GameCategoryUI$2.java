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
    AppMethodBeat.i(41913);
    Object localObject = new Intent(this.xPl, GameSearchUI.class);
    switch (GameCategoryUI.a(this.xPl))
    {
    }
    for (;;)
    {
      paramMenuItem = this.xPl;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(41913);
      return true;
      ((Intent)localObject).putExtra("game_report_from_scene", 1602);
      continue;
      ((Intent)localObject).putExtra("game_report_from_scene", 1502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.2
 * JD-Core Version:    0.7.0.1
 */