package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$2
  implements Runnable
{
  b$2(g paramg, boolean paramBoolean, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(102521);
    ab.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.msM.field_id), Long.valueOf(this.msM.field_localId), Boolean.valueOf(this.msN) });
    b.a(this.msM, this.msN);
    al.d(this.msO);
    AppMethodBeat.o(102521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b.2
 * JD-Core Version:    0.7.0.1
 */