package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.al;

final class GameCenterUI5$2
  implements Runnable
{
  GameCenterUI5$2(GameCenterUI5 paramGameCenterUI5, a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(111789);
    be localbe;
    if (this.nwA == null) {
      localbe = new be();
    }
    for (;;)
    {
      al.d(new GameCenterUI5.2.1(this, new ac(localbe)));
      AppMethodBeat.o(111789);
      return;
      localbe = (be)this.nwA;
      ((e)g.E(e.class)).bET().b("pb_index_4", localbe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.2
 * JD-Core Version:    0.7.0.1
 */