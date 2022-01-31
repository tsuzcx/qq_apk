package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLibraryUI$5
  implements View.OnClickListener
{
  GameLibraryUI$5(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112035);
    com.tencent.mm.plugin.game.f.c.a(paramView, this.nAK);
    com.tencent.mm.game.report.c.a(this.nAK, 11, 1110, 999, 7, GameLibraryUI.e(this.nAK), null);
    AppMethodBeat.o(112035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.5
 * JD-Core Version:    0.7.0.1
 */