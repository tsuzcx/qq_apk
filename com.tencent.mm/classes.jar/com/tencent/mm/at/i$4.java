package com.tencent.mm.at;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class i$4
  implements Runnable
{
  i$4(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(78287);
    long l = System.currentTimeMillis() - i.g(this.fFd);
    if (i.h(this.fFd))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(78287);
        return;
      }
      ab.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.h(this.fFd) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.h(this.fFd));
    }
    ab.i("MicroMsg.ImgService", "run from run");
    i.i(this.fFd);
    i.j(this.fFd);
    this.fFd.ckQ.etf = SystemClock.elapsedRealtime();
    i.k(this.fFd).ag(10L, 10L);
    AppMethodBeat.o(78287);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78288);
    String str = super.toString() + "|run";
    AppMethodBeat.o(78288);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.i.4
 * JD-Core Version:    0.7.0.1
 */