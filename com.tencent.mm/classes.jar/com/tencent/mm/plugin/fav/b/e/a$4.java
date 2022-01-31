package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5327);
    long l = System.currentTimeMillis() - this.mvc.ckN;
    if (this.mvc.running)
    {
      if (l < 300000L)
      {
        AppMethodBeat.o(5327);
        return;
      }
      ab.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.mvc.running + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + this.mvc.running);
    }
    ab.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[] { Long.valueOf(l) });
    this.mvc.ckL = false;
    this.mvc.running = true;
    this.mvc.muZ = 0;
    this.mvc.ckM = 3;
    this.mvc.ckR.ag(100L, 100L);
    AppMethodBeat.o(5327);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5328);
    String str = super.toString() + "|run";
    AppMethodBeat.o(5328);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.4
 * JD-Core Version:    0.7.0.1
 */