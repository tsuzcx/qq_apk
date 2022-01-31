package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.sdk.platformtools.y;

final class GameOverSeaCenterUI$2$2
  implements Runnable
{
  GameOverSeaCenterUI$2$2(GameOverSeaCenterUI.2 param2, ag paramag) {}
  
  public final void run()
  {
    try
    {
      GameOverSeaCenterUI.a(this.les.ler, this.let, 1);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
      this.les.ler.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2.2
 * JD-Core Version:    0.7.0.1
 */