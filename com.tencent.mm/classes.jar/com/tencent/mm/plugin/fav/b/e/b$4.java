package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class b$4
  implements av.a
{
  b$4(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101614);
    try
    {
      b.b(this.qbO);
      AppMethodBeat.o(101614);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101615);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(101615);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.4
 * JD-Core Version:    0.7.0.1
 */