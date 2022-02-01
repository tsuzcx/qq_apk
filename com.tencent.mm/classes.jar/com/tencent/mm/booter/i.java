package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class i
{
  public static boolean aKG()
  {
    AppMethodBeat.i(19886);
    try
    {
      bh.bCz();
      Util.nullAs((Long)c.ban().d(66817, null), 0L);
      if (Util.secondsToNow(0L) * 1000L > 1800000L)
      {
        AppMethodBeat.o(19886);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", localException, "", new Object[0]);
      }
      AppMethodBeat.o(19886);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.i
 * JD-Core Version:    0.7.0.1
 */