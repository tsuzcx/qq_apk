package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(116519);
    long l = System.currentTimeMillis() - i.j(this.ckT);
    ab.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(this.ckT) + " timeWait:" + l + " sending:" + i.g(this.ckT) + " recving:" + i.f(this.ckT));
    if (i.e(this.ckT))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(116519);
        return;
      }
      ab.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(this.ckT) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.g(this.ckT) + " recving:" + i.f(this.ckT));
    }
    i.k(this.ckT);
    i.b(this.ckT);
    i.a(this.ckT, 3);
    i.a(this.ckT);
    this.ckT.ckQ.etf = SystemClock.elapsedRealtime();
    i.l(this.ckT).ag(10L, 10L);
    AppMethodBeat.o(116519);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(116520);
    String str = super.toString() + "|run";
    AppMethodBeat.o(116520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.i.2
 * JD-Core Version:    0.7.0.1
 */