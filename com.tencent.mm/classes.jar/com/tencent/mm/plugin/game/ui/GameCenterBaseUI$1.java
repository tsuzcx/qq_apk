package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.model.q;

final class GameCenterBaseUI$1
  implements Runnable
{
  GameCenterBaseUI$1(GameCenterBaseUI paramGameCenterBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111759);
    GameCenterBaseUI.a(this.nwg);
    if (this.nwg.nwa)
    {
      GameCenterBaseUI.b(this.nwg);
      ((d)g.E(d.class)).bER();
      q.bGq();
    }
    AppMethodBeat.o(111759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI.1
 * JD-Core Version:    0.7.0.1
 */