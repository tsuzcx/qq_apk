package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$5
  implements ap.a
{
  a$5(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(5329);
    try
    {
      this.mvc.ahb();
      AppMethodBeat.o(5329);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5330);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(5330);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.5
 * JD-Core Version:    0.7.0.1
 */