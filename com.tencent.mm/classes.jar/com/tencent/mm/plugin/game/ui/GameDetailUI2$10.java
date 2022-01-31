package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

final class GameDetailUI2$10
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GameDetailUI2$10(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onGlobalLayout()
  {
    if (GameDetailUI2.b(this.laq).getLineCount() > 3)
    {
      GameDetailUI2.c(this.laq).setVisibility(0);
      return;
    }
    GameDetailUI2.c(this.laq).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.10
 * JD-Core Version:    0.7.0.1
 */