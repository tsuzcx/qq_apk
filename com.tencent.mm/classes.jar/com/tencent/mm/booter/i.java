package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class i
{
  public static boolean TG()
  {
    AppMethodBeat.i(19886);
    try
    {
      az.arV();
      bt.a((Long)c.afk().get(66817, null), 0L);
      if (bt.lZ(0L) * 1000L > 1800000L)
      {
        AppMethodBeat.o(19886);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", localException, "", new Object[0]);
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