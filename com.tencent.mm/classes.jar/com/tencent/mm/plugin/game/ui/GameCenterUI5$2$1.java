package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.sdk.platformtools.y;

final class GameCenterUI5$2$1
  implements Runnable
{
  GameCenterUI5$2$1(GameCenterUI5.2 param2, ad paramad) {}
  
  public final void run()
  {
    try
    {
      GameCenterUI5.a(this.kYF.kYC, this.kYE, 2);
      if (GameCenterUI5.a(this.kYF.kYC) != null) {
        GameCenterUI5.a(this.kYF.kYC).dismiss();
      }
      y.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.kYF.dhV) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[] { localException.getMessage() });
        this.kYF.kYC.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.2.1
 * JD-Core Version:    0.7.0.1
 */