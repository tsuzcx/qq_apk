package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.view.View;
import com.tencent.mm.plugin.game.model.af;

final class GameLibraryUI$9$1
  implements Runnable
{
  GameLibraryUI$9$1(GameLibraryUI.9 param9, af paramaf) {}
  
  public final void run()
  {
    GameLibraryUI localGameLibraryUI = this.lcS.lcP;
    af localaf = this.lcQ;
    if (GameLibraryUI.m(this.lcS.lcP) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      GameLibraryUI.a(localGameLibraryUI, localaf, bool);
      GameLibraryUI.p(this.lcS.lcP);
      GameLibraryUI.l(this.lcS.lcP).setVisibility(8);
      GameLibraryUI.b(this.lcS.lcP, GameLibraryUI.m(this.lcS.lcP) + 15);
      if (GameLibraryUI.q(this.lcS.lcP) != null) {
        GameLibraryUI.q(this.lcS.lcP).dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.9.1
 * JD-Core Version:    0.7.0.1
 */