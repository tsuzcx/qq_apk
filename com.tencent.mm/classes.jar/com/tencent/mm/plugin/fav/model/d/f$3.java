package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class f$3
  implements MTimerHandler.CallBack
{
  f$3(f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(101652);
    try
    {
      f.d(this.AeR);
      AppMethodBeat.o(101652);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Fav.FavSendService", localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.f.3
 * JD-Core Version:    0.7.0.1
 */