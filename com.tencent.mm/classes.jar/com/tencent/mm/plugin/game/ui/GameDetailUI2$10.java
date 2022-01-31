package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDetailUI2$10
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GameDetailUI2$10(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(111849);
    if (GameDetailUI2.b(this.nyn).getLineCount() > 3)
    {
      GameDetailUI2.c(this.nyn).setVisibility(0);
      AppMethodBeat.o(111849);
      return;
    }
    GameDetailUI2.c(this.nyn).setVisibility(8);
    AppMethodBeat.o(111849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.10
 * JD-Core Version:    0.7.0.1
 */