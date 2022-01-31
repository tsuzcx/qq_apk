package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.w;

final class GameDownloadGuidanceUI$3
  implements Runnable
{
  GameDownloadGuidanceUI$3(GameDownloadGuidanceUI paramGameDownloadGuidanceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111883);
    ((e)g.E(e.class)).bET().b("pb_over_sea", GameDownloadGuidanceUI.b(this.nyy));
    AppMethodBeat.o(111883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.3
 * JD-Core Version:    0.7.0.1
 */