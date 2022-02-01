package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

final class b$2
  implements Runnable
{
  b$2(g paramg, boolean paramBoolean, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(103256);
    ac.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.qIb.field_id), Long.valueOf(this.qIb.field_localId), Boolean.valueOf(this.qIc) });
    b.a(this.qIb, this.qIc);
    ap.f(this.qId);
    b.s(this.qIb);
    AppMethodBeat.o(103256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b.2
 * JD-Core Version:    0.7.0.1
 */