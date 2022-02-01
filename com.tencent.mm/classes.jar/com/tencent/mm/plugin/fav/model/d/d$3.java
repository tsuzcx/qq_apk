package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class d$3
  implements MTimerHandler.CallBack
{
  d$3(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101636);
    try
    {
      d.d(this.AeL);
      AppMethodBeat.o(101636);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.d.3
 * JD-Core Version:    0.7.0.1
 */