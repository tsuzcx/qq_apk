package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.game.f.c;

final class GameDownloadGuidanceUI$2$1
  implements Runnable
{
  GameDownloadGuidanceUI$2$1(GameDownloadGuidanceUI.2 param2) {}
  
  public final void run()
  {
    if (this.laD.laC.isFinishing()) {
      return;
    }
    GameDownloadGuidanceUI.a(this.laD.laC, c.dA(this.laD.laC));
    GameDownloadGuidanceUI.a(this.laD.laC).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2.1
 * JD-Core Version:    0.7.0.1
 */