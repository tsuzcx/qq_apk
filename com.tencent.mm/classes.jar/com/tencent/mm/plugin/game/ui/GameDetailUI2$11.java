package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDetailUI2$11
  implements View.OnClickListener
{
  GameDetailUI2$11(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111850);
    if (!GameDetailUI2.d(this.nyn))
    {
      GameDetailUI2.b(this.nyn).setMaxLines(100);
      GameDetailUI2.c(this.nyn).setText(this.nyn.getResources().getText(2131300341));
      GameDetailUI2.a(this.nyn, true);
      AppMethodBeat.o(111850);
      return;
    }
    GameDetailUI2.b(this.nyn).setMaxLines(3);
    GameDetailUI2.c(this.nyn).setText(this.nyn.getResources().getText(2131300340));
    GameDetailUI2.a(this.nyn, false);
    AppMethodBeat.o(111850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.11
 * JD-Core Version:    0.7.0.1
 */