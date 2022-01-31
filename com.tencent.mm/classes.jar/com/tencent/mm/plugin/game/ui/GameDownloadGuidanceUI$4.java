package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDownloadGuidanceUI$4
  implements MenuItem.OnMenuItemClickListener
{
  GameDownloadGuidanceUI$4(GameDownloadGuidanceUI paramGameDownloadGuidanceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111884);
    int i = com.tencent.mm.plugin.game.f.c.ax(this.nyy.getContext(), GameDownloadGuidanceUI.c(this.nyy));
    com.tencent.mm.game.report.c.a(this.nyy.getContext(), 10, 1008, 1, i, this.nyy.nok, null);
    AppMethodBeat.o(111884);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.4
 * JD-Core Version:    0.7.0.1
 */