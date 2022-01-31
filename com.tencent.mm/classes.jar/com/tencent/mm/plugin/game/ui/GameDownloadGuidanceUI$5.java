package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.sdk.platformtools.al;

final class GameDownloadGuidanceUI$5
  implements Runnable
{
  GameDownloadGuidanceUI$5(GameDownloadGuidanceUI paramGameDownloadGuidanceUI, a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(111886);
    if (this.nwA == null) {
      GameDownloadGuidanceUI.a(this.nyy, new bi());
    }
    for (;;)
    {
      al.d(new GameDownloadGuidanceUI.5.1(this, new ab(this.nwA)));
      AppMethodBeat.o(111886);
      return;
      GameDownloadGuidanceUI.a(this.nyy, (bi)this.nwA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.5
 * JD-Core Version:    0.7.0.1
 */