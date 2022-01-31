package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(g paramg, boolean paramBoolean, Runnable paramRunnable) {}
  
  public final void run()
  {
    y.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[] { Integer.valueOf(this.jYs.field_id), Long.valueOf(this.jYs.field_localId), Boolean.valueOf(this.jYt) });
    b.a(this.jYs, this.jYt);
    ai.d(this.jYu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.b.2
 * JD-Core Version:    0.7.0.1
 */