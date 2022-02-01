package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

final class k$5
  implements MTimerHandler.CallBack
{
  k$5(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(150649);
    try
    {
      k.e(this.iYI);
      AppMethodBeat.o(150649);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ImgService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150650);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(150650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.k.5
 * JD-Core Version:    0.7.0.1
 */