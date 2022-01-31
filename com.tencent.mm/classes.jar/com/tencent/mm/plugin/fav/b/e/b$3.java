package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(5352);
    long l = System.currentTimeMillis() - b.d(this.mvg);
    if (b.e(this.mvg))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(5352);
        return;
      }
      ab.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.e(this.mvg) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + b.e(this.mvg));
    }
    b.a(this.mvg);
    b.f(this.mvg);
    b.g(this.mvg).ag(10L, 10L);
    AppMethodBeat.o(5352);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5353);
    String str = super.toString() + "|run";
    AppMethodBeat.o(5353);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.3
 * JD-Core Version:    0.7.0.1
 */