package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.sdk.platformtools.y;

final class GameDownloadGuidanceUI$5$1
  implements Runnable
{
  GameDownloadGuidanceUI$5$1(GameDownloadGuidanceUI.5 param5, ac paramac) {}
  
  public final void run()
  {
    try
    {
      this.laF.laC.a(this.laE, 2);
      if (GameDownloadGuidanceUI.a(this.laF.laC) != null) {
        GameDownloadGuidanceUI.a(this.laF.laC).dismiss();
      }
      y.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.laF.dhV) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
        this.laF.laC.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.5.1
 * JD-Core Version:    0.7.0.1
 */