package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(101587);
    long l = System.currentTimeMillis() - this.tcj.dAG;
    if (this.tcj.running)
    {
      if (l < 300000L)
      {
        AppMethodBeat.o(101587);
        return;
      }
      Log.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.tcj.running + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + this.tcj.running);
    }
    Log.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[] { Long.valueOf(l) });
    this.tcj.dAE = false;
    this.tcj.running = true;
    this.tcj.tcg = 0;
    this.tcj.dAF = 3;
    this.tcj.dAJ.startTimer(100L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.4
 * JD-Core Version:    0.7.0.1
 */