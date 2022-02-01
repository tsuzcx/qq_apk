package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;

public final class c
{
  public static int cyW()
  {
    AppMethodBeat.i(90787);
    if (Log.getImpl() != null)
    {
      int i = Log.getImpl().getLogLevel(0L);
      AppMethodBeat.o(90787);
      return i;
    }
    AppMethodBeat.o(90787);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c
 * JD-Core Version:    0.7.0.1
 */