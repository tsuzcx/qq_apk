package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(5390);
    long l = System.currentTimeMillis() - e.f(this.mvn);
    if (e.g(this.mvn))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(5390);
        return;
      }
      ab.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.g(this.mvn) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + e.g(this.mvn));
    }
    e.a(this.mvn);
    e.h(this.mvn);
    e.i(this.mvn);
    e.j(this.mvn).ag(10L, 10L);
    AppMethodBeat.o(5390);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5391);
    String str = super.toString() + "|run";
    AppMethodBeat.o(5391);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.2
 * JD-Core Version:    0.7.0.1
 */