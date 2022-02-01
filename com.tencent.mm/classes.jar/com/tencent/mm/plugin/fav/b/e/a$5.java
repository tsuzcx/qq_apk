package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class a$5
  implements MTimerHandler.CallBack
{
  a$5(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101589);
    try
    {
      this.tcj.bck();
      AppMethodBeat.o(101589);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.5
 * JD-Core Version:    0.7.0.1
 */