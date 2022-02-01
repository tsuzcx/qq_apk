package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(101587);
    long l = System.currentTimeMillis() - this.qKq.cXc;
    if (this.qKq.running)
    {
      if (l < 300000L)
      {
        AppMethodBeat.o(101587);
        return;
      }
      ac.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.qKq.running + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + this.qKq.running);
    }
    ac.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[] { Long.valueOf(l) });
    this.qKq.cXa = false;
    this.qKq.running = true;
    this.qKq.qKn = 0;
    this.qKq.cXb = 3;
    this.qKq.cXg.au(100L, 100L);
    AppMethodBeat.o(101587);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101588);
    String str = super.toString() + "|run";
    AppMethodBeat.o(101588);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.4
 * JD-Core Version:    0.7.0.1
 */