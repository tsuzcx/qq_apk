package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class GameOverSeaCenterUI$5
  implements MenuItem.OnMenuItemClickListener
{
  GameOverSeaCenterUI$5(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = c.an(this.ler.mController.uMN, GameOverSeaCenterUI.d(this.ler));
    b.a(this.ler.mController.uMN, 10, 1008, 1, i, this.ler.kQh, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.5
 * JD-Core Version:    0.7.0.1
 */