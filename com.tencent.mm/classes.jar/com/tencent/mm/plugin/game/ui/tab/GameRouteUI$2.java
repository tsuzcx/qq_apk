package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class GameRouteUI$2
  implements Runnable
{
  GameRouteUI$2(GameRouteUI paramGameRouteUI, bg parambg) {}
  
  public final void run()
  {
    AppMethodBeat.i(112221);
    aj.a(this.npi);
    if ((this.npi != null) && (!bo.es(this.npi.nrw)))
    {
      GameRouteUI.a(this.nDK, this.npi.nrw);
      AppMethodBeat.o(112221);
      return;
    }
    ab.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
    GameRouteUI.a(this.nDK);
    AppMethodBeat.o(112221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameRouteUI.2
 * JD-Core Version:    0.7.0.1
 */