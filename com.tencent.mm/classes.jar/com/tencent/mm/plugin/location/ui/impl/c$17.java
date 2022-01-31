package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.ActionBarSearchView.a;

final class c$17
  implements ActionBarSearchView.a
{
  c$17(c paramc) {}
  
  public final void bMn()
  {
    AppMethodBeat.i(113613);
    ab.d("MicroMsg.MMPoiMapUI", "back pressed");
    c.a(this.ogD, c.bMk(), c.v(this.ogD).lxQ, true);
    c.a(this.ogD, null);
    AppMethodBeat.o(113613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.17
 * JD-Core Version:    0.7.0.1
 */