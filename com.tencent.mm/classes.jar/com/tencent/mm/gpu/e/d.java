package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.b.a;
import com.tencent.mm.plugin.report.service.h;

public final class d
{
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(209433);
    h.wUl.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(209433);
  }
  
  public static int tv(String paramString)
  {
    AppMethodBeat.i(209434);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(209434);
      return -1;
    }
    if (a.gae.equals(paramString))
    {
      AppMethodBeat.o(209434);
      return 1406;
    }
    if (paramString.startsWith(a.gaf))
    {
      AppMethodBeat.o(209434);
      return 1410;
    }
    if (a.gag.equals(paramString))
    {
      AppMethodBeat.o(209434);
      return 1412;
    }
    if (a.gah.equals(paramString))
    {
      AppMethodBeat.o(209434);
      return 1413;
    }
    AppMethodBeat.o(209434);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.e.d
 * JD-Core Version:    0.7.0.1
 */