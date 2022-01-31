package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class y$a$3
  implements Runnable
{
  y$a$3(y.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(50870);
    long l = System.currentTimeMillis() - y.a.l(this.fYk);
    ab.d("MicroMsg.VideoService", "Try Run service runningFlag:" + y.a.h(this.fYk) + " timeWait:" + l + " sending:" + y.a.j(this.fYk) + " recving:" + y.a.i(this.fYk));
    if (y.a.h(this.fYk))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(50870);
        return;
      }
      ab.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + y.a.h(this.fYk) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + y.a.j(this.fYk) + " recving:" + y.a.i(this.fYk));
    }
    y.a.a(this.fYk, 3);
    y.a.m(this.fYk);
    y.a.d(this.fYk);
    y.a.b(this.fYk);
    y.a.e(this.fYk);
    y.a.c(this.fYk);
    this.fYk.ckQ.etf = SystemClock.elapsedRealtime();
    y.a.n(this.fYk).ag(10L, 10L);
    AppMethodBeat.o(50870);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50871);
    String str = super.toString() + "|run";
    AppMethodBeat.o(50871);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a.3
 * JD-Core Version:    0.7.0.1
 */