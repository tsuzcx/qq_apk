package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.ae;

final class GameLibraryUI$9$1
  implements Runnable
{
  GameLibraryUI$9$1(GameLibraryUI.9 param9, ae paramae) {}
  
  public final void run()
  {
    AppMethodBeat.i(112039);
    GameLibraryUI localGameLibraryUI = this.nAN.nAK;
    ae localae = this.nAL;
    if (GameLibraryUI.m(this.nAN.nAK) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      GameLibraryUI.a(localGameLibraryUI, localae, bool);
      GameLibraryUI.p(this.nAN.nAK);
      GameLibraryUI.l(this.nAN.nAK).setVisibility(8);
      GameLibraryUI.b(this.nAN.nAK, GameLibraryUI.m(this.nAN.nAK) + 15);
      if (GameLibraryUI.q(this.nAN.nAK) != null) {
        GameLibraryUI.q(this.nAN.nAK).dismiss();
      }
      AppMethodBeat.o(112039);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.9.1
 * JD-Core Version:    0.7.0.1
 */