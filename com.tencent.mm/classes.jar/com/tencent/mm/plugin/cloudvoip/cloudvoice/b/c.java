package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ab.a;

public final class c
{
  public static int bhk()
  {
    AppMethodBeat.i(135467);
    if (ab.dsH() != null)
    {
      int i = ab.dsH().getLogLevel();
      AppMethodBeat.o(135467);
      return i;
    }
    AppMethodBeat.o(135467);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.b.c
 * JD-Core Version:    0.7.0.1
 */