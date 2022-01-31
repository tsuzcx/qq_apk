package com.tencent.mm.plugin.downloader_app.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.c;
import com.tencent.mm.plugin.game.luggage.d.a;
import com.tencent.mm.sdk.platformtools.ah;

final class d$1
  implements d.a
{
  public final void tU()
  {
    AppMethodBeat.i(136054);
    if (d.bjI() != null) {
      d.destroy();
    }
    d.a(com.tencent.mm.plugin.game.luggage.d.aq(ah.getContext(), d.access$100()));
    if (d.bjI() != null) {
      c.a(d.bjI(), d.access$100(), false);
    }
    AppMethodBeat.o(136054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.d.1
 * JD-Core Version:    0.7.0.1
 */