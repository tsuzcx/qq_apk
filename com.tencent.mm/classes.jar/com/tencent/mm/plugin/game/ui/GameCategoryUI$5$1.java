package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.y;

final class GameCategoryUI$5$1
  implements Runnable
{
  GameCategoryUI$5$1(GameCategoryUI.5 param5, y paramy) {}
  
  public final void run()
  {
    AppMethodBeat.i(111749);
    GameCategoryUI localGameCategoryUI = this.nvW.nvT;
    y localy = this.nvV;
    if (GameCategoryUI.h(this.nvW.nvT) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      GameCategoryUI.a(localGameCategoryUI, localy, bool);
      GameCategoryUI.i(this.nvW.nvT);
      GameCategoryUI.f(this.nvW.nvT).setVisibility(8);
      GameCategoryUI.a(this.nvW.nvT, GameCategoryUI.h(this.nvW.nvT) + 15);
      if (GameCategoryUI.j(this.nvW.nvT) != null) {
        GameCategoryUI.j(this.nvW.nvT).dismiss();
      }
      AppMethodBeat.o(111749);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.5.1
 * JD-Core Version:    0.7.0.1
 */