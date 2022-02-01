package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class e$3
  implements av.a
{
  e$3(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101652);
    try
    {
      e.d(this.qbV);
      AppMethodBeat.o(101652);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Fav.FavSendService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101653);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(101653);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.3
 * JD-Core Version:    0.7.0.1
 */