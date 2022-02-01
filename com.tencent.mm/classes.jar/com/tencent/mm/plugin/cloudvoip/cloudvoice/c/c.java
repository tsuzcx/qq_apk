package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;

public final class c
{
  public static int bZS()
  {
    AppMethodBeat.i(90787);
    if (ad.fkt() != null)
    {
      int i = ad.fkt().getLogLevel(0L);
      AppMethodBeat.o(90787);
      return i;
    }
    AppMethodBeat.o(90787);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c
 * JD-Core Version:    0.7.0.1
 */