package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.view.View;
import com.tencent.mm.plugin.game.model.z;

final class GameCategoryUI$5$1
  implements Runnable
{
  GameCategoryUI$5$1(GameCategoryUI.5 param5, z paramz) {}
  
  public final void run()
  {
    GameCategoryUI localGameCategoryUI = this.kXU.kXR;
    z localz = this.kXT;
    if (GameCategoryUI.h(this.kXU.kXR) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      GameCategoryUI.a(localGameCategoryUI, localz, bool);
      GameCategoryUI.i(this.kXU.kXR);
      GameCategoryUI.f(this.kXU.kXR).setVisibility(8);
      GameCategoryUI.a(this.kXU.kXR, GameCategoryUI.h(this.kXU.kXR) + 15);
      if (GameCategoryUI.j(this.kXU.kXR) != null) {
        GameCategoryUI.j(this.kXU.kXR).dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.5.1
 * JD-Core Version:    0.7.0.1
 */