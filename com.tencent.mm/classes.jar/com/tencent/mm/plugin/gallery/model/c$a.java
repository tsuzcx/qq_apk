package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;

final class c$a
{
  private c$a(c paramc) {}
  
  public final void d(az.a parama)
  {
    AppMethodBeat.i(21227);
    g localg = e.bDR();
    if (localg == null)
    {
      ab.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
      AppMethodBeat.o(21227);
      return;
    }
    localg.U(new c.a.1(this, parama));
    AppMethodBeat.o(21227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c.a
 * JD-Core Version:    0.7.0.1
 */