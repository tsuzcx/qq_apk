package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class d$3
  implements av.a
{
  d$3(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101636);
    try
    {
      d.d(this.qbT);
      AppMethodBeat.o(101636);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101637);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(101637);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.3
 * JD-Core Version:    0.7.0.1
 */