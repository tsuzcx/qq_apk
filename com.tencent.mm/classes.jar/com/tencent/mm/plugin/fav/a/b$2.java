package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class b$2
  implements Runnable
{
  b$2(g paramg, boolean paramBoolean, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(103256);
    Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.sZT.field_id), Long.valueOf(this.sZT.field_localId), Boolean.valueOf(this.sZU) });
    b.a(this.sZT, this.sZU);
    MMHandlerThread.postToMainThread(this.sZV);
    b.s(this.sZT);
    AppMethodBeat.o(103256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b.2
 * JD-Core Version:    0.7.0.1
 */