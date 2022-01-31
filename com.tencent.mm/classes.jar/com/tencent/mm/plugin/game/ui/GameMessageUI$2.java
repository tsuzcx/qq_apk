package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class GameMessageUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameMessageUI$2(GameMessageUI paramGameMessageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    GameMessageUI.a(this.lee, new GameMessageUI.2.1(this));
    GameMessageUI.b(this.lee, new GameMessageUI.2.2(this));
    h.a(this.lee.mController.uMN, g.i.game_clear_message, 0, GameMessageUI.c(this.lee), GameMessageUI.d(this.lee));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.2
 * JD-Core Version:    0.7.0.1
 */