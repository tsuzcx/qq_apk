package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class GameMessageUI$5
  implements View.OnClickListener
{
  GameMessageUI$5(GameMessageUI paramGameMessageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112104);
    if (!bo.isNullOrNil(GameMessageUI.f(this.nBZ)))
    {
      int i = com.tencent.mm.plugin.game.f.c.ax(this.nBZ.getContext(), GameMessageUI.f(this.nBZ));
      com.tencent.mm.game.report.c.a(this.nBZ.getContext(), 13, 1302, 1, i, GameMessageUI.g(this.nBZ), null);
    }
    GameMessageUI.h(this.nBZ);
    AppMethodBeat.o(112104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.5
 * JD-Core Version:    0.7.0.1
 */