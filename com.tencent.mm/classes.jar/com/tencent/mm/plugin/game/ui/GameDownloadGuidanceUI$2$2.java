package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDownloadGuidanceUI$2$2
  implements Runnable
{
  GameDownloadGuidanceUI$2$2(GameDownloadGuidanceUI.2 param2, com.tencent.mm.plugin.game.model.ab paramab) {}
  
  public final void run()
  {
    AppMethodBeat.i(111881);
    try
    {
      this.nyz.nyy.a(this.nyA, 1);
      AppMethodBeat.o(111881);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
      this.nyz.nyy.finish();
      AppMethodBeat.o(111881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2.2
 * JD-Core Version:    0.7.0.1
 */