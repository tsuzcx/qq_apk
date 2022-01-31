package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.sdk.platformtools.y;

final class GameDownloadGuidanceUI$2$2
  implements Runnable
{
  GameDownloadGuidanceUI$2$2(GameDownloadGuidanceUI.2 param2, ac paramac) {}
  
  public final void run()
  {
    try
    {
      this.laD.laC.a(this.laE, 1);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
      this.laD.laC.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2.2
 * JD-Core Version:    0.7.0.1
 */