package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDownloadGuidanceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GameDownloadGuidanceUI$1(GameDownloadGuidanceUI paramGameDownloadGuidanceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111879);
    this.nyy.finish();
    AppMethodBeat.o(111879);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.1
 * JD-Core Version:    0.7.0.1
 */