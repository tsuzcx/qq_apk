package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class GameDownloadGuidanceUI$4
  implements MenuItem.OnMenuItemClickListener
{
  GameDownloadGuidanceUI$4(GameDownloadGuidanceUI paramGameDownloadGuidanceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = c.an(this.laC.mController.uMN, GameDownloadGuidanceUI.c(this.laC));
    b.a(this.laC.mController.uMN, 10, 1008, 1, i, this.laC.kQh, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.4
 * JD-Core Version:    0.7.0.1
 */