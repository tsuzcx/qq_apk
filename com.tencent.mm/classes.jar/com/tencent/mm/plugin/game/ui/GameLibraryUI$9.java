package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.sdk.platformtools.al;

final class GameLibraryUI$9
  implements Runnable
{
  GameLibraryUI$9(GameLibraryUI paramGameLibraryUI, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(112040);
    Object localObject = this.nwA;
    if ((GameLibraryUI.m(this.nAK) == 0) && (!GameLibraryUI.n(this.nAK))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new ae((a)localObject, bool, GameLibraryUI.m(this.nAK));
      GameLibraryUI.o(this.nAK);
      al.d(new GameLibraryUI.9.1(this, (ae)localObject));
      AppMethodBeat.o(112040);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.9
 * JD-Core Version:    0.7.0.1
 */