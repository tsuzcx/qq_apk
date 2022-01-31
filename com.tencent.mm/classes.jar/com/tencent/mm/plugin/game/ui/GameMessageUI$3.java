package com.tencent.mm.plugin.game.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.p.a;

final class GameMessageUI$3
  implements p.a
{
  GameMessageUI$3(GameMessageUI paramGameMessageUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(112102);
    if (GameMessageUI.b(this.nBZ).getCount() == 0)
    {
      GameMessageUI.e(this.nBZ).setVisibility(8);
      GameMessageUI.a(this.nBZ, 0);
      this.nBZ.enableOptionMenu(false);
      AppMethodBeat.o(112102);
      return;
    }
    GameMessageUI.e(this.nBZ).setVisibility(0);
    GameMessageUI.a(this.nBZ, 8);
    this.nBZ.enableOptionMenu(true);
    AppMethodBeat.o(112102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.3
 * JD-Core Version:    0.7.0.1
 */