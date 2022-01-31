package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.sdk.platformtools.ab;

final class aj$2
  implements aj.a
{
  aj$2(bg parambg) {}
  
  public final void onComplete()
  {
    AppMethodBeat.i(111417);
    ab.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
    ((e)g.E(e.class)).bET().b("game_index4_tab_nav", this.npi);
    AppMethodBeat.o(111417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj.2
 * JD-Core Version:    0.7.0.1
 */