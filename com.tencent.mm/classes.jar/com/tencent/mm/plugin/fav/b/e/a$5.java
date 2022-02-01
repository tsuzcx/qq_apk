package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;

final class a$5
  implements au.a
{
  a$5(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101589);
    try
    {
      this.qKq.aEU();
      AppMethodBeat.o(101589);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101590);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(101590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.5
 * JD-Core Version:    0.7.0.1
 */