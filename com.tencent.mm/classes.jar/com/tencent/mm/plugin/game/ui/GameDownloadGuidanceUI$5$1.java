package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDownloadGuidanceUI$5$1
  implements Runnable
{
  GameDownloadGuidanceUI$5$1(GameDownloadGuidanceUI.5 param5, com.tencent.mm.plugin.game.model.ab paramab) {}
  
  public final void run()
  {
    AppMethodBeat.i(111885);
    try
    {
      this.nyB.nyy.a(this.nyA, 2);
      if (GameDownloadGuidanceUI.a(this.nyB.nyy) != null) {
        GameDownloadGuidanceUI.a(this.nyB.nyy).dismiss();
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.nyB.dZo) });
      AppMethodBeat.o(111885);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
        this.nyB.nyy.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.5.1
 * JD-Core Version:    0.7.0.1
 */