package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$3
  implements ap.a
{
  d$3(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(5376);
    try
    {
      d.d(this.mvl);
      AppMethodBeat.o(5376);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5377);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(5377);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.3
 * JD-Core Version:    0.7.0.1
 */