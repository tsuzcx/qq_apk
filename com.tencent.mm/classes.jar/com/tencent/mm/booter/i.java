package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class i
{
  public static boolean Iu()
  {
    AppMethodBeat.i(15852);
    try
    {
      aw.aaz();
      ah.d((Long)c.Ru().get(66817, null));
      if (ah.gz(0L) * 1000L > 1800000L)
      {
        AppMethodBeat.o(15852);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", localException, "", new Object[0]);
      }
      AppMethodBeat.o(15852);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.i
 * JD-Core Version:    0.7.0.1
 */