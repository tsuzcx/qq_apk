package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class b$4
  implements MTimerHandler.CallBack
{
  b$4(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101614);
    try
    {
      b.b(this.AeG);
      AppMethodBeat.o(101614);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.b.4
 * JD-Core Version:    0.7.0.1
 */