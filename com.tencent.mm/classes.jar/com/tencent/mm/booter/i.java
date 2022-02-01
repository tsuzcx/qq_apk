package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class i
{
  public static boolean WZ()
  {
    AppMethodBeat.i(19886);
    try
    {
      bc.aCg();
      bu.a((Long)c.ajA().get(66817, null), 0L);
      if (bu.rZ(0L) * 1000L > 1800000L)
      {
        AppMethodBeat.o(19886);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", localException, "", new Object[0]);
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