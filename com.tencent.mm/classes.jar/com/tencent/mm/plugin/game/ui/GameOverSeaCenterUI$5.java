package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameOverSeaCenterUI$5
  implements MenuItem.OnMenuItemClickListener
{
  GameOverSeaCenterUI$5(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112132);
    int i = com.tencent.mm.plugin.game.f.c.ax(this.nCm.getContext(), GameOverSeaCenterUI.d(this.nCm));
    com.tencent.mm.game.report.c.a(this.nCm.getContext(), 10, 1008, 1, i, this.nCm.nok, null);
    AppMethodBeat.o(112132);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.5
 * JD-Core Version:    0.7.0.1
 */