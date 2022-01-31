package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$3
  implements ap.a
{
  e$3(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(5392);
    try
    {
      e.d(this.mvn);
      AppMethodBeat.o(5392);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavSendService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5393);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(5393);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.3
 * JD-Core Version:    0.7.0.1
 */