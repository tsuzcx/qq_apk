package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.w;

final class GameOverSeaCenterUI$3
  implements Runnable
{
  GameOverSeaCenterUI$3(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(112130);
    ((e)g.E(e.class)).bET().b("pb_over_sea", GameOverSeaCenterUI.c(this.nCm));
    AppMethodBeat.o(112130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.3
 * JD-Core Version:    0.7.0.1
 */