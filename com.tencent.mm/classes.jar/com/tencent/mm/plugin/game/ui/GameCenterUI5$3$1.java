package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.game.f.c;

final class GameCenterUI5$3$1
  implements Runnable
{
  GameCenterUI5$3$1(GameCenterUI5.3 param3) {}
  
  public final void run()
  {
    if (this.kYG.kYC.isFinishing()) {
      return;
    }
    GameCenterUI5.a(this.kYG.kYC, c.dA(this.kYG.kYC));
    GameCenterUI5.a(this.kYG.kYC).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.3.1
 * JD-Core Version:    0.7.0.1
 */