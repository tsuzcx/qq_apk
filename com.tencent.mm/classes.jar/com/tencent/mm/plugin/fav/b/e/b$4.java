package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$4
  implements ap.a
{
  b$4(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(5354);
    try
    {
      b.b(this.mvg);
      AppMethodBeat.o(5354);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5355);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(5355);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.4
 * JD-Core Version:    0.7.0.1
 */