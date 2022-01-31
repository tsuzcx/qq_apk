package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.da;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class GameDetailUI2$7
  implements n.c
{
  GameDetailUI2$7(GameDetailUI2 paramGameDetailUI2, da paramda) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(111846);
    if (this.nyo.nug) {
      paraml.a(0, this.nyn.getString(2131300454), 2131231038);
    }
    if (this.nyo.nuh) {
      paraml.a(1, this.nyn.getString(2131300458), 2131231024);
    }
    AppMethodBeat.o(111846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.7
 * JD-Core Version:    0.7.0.1
 */