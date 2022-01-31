package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.game.f.c;

final class GameOverSeaCenterUI$2$1
  implements Runnable
{
  GameOverSeaCenterUI$2$1(GameOverSeaCenterUI.2 param2) {}
  
  public final void run()
  {
    if (this.les.ler.isFinishing()) {
      return;
    }
    GameOverSeaCenterUI.a(this.les.ler, c.dA(this.les.ler));
    GameOverSeaCenterUI.a(this.les.ler).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2.1
 * JD-Core Version:    0.7.0.1
 */