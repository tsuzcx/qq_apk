package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(5374);
    long l = System.currentTimeMillis() - d.f(this.mvl);
    if (d.g(this.mvl))
    {
      if (l < 60000L)
      {
        AppMethodBeat.o(5374);
        return;
      }
      ab.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.g(this.mvl) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + d.g(this.mvl));
    }
    d.a(this.mvl);
    d.h(this.mvl);
    d.i(this.mvl);
    d.j(this.mvl).ag(10L, 10L);
    AppMethodBeat.o(5374);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5375);
    String str = super.toString() + "|run";
    AppMethodBeat.o(5375);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.2
 * JD-Core Version:    0.7.0.1
 */