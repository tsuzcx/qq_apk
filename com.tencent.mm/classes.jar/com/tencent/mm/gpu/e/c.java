package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.b.a;
import com.tencent.mm.plugin.report.service.g;

public final class c
{
  public static void agO()
  {
    AppMethodBeat.i(219542);
    e(1403L, 19L, 1L);
    e(1403L, 21L, 1L);
    AppMethodBeat.o(219542);
  }
  
  public static void agP()
  {
    AppMethodBeat.i(219543);
    e(1403L, 20L, 1L);
    e(1403L, 21L, 1L);
    AppMethodBeat.o(219543);
  }
  
  public static void agQ()
  {
    AppMethodBeat.i(219545);
    e(1403L, 1L, 1L);
    e(1403L, 3L, 1L);
    AppMethodBeat.o(219545);
  }
  
  public static void agR()
  {
    AppMethodBeat.i(219546);
    e(1403L, 2L, 1L);
    e(1403L, 3L, 1L);
    AppMethodBeat.o(219546);
  }
  
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(219544);
    g.yhR.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(219544);
  }
  
  public static int wl(String paramString)
  {
    AppMethodBeat.i(219547);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(219547);
      return -1;
    }
    if (a.gtD.equals(paramString))
    {
      AppMethodBeat.o(219547);
      return 1406;
    }
    if (paramString.startsWith(a.gtE))
    {
      AppMethodBeat.o(219547);
      return 1410;
    }
    if (a.gtF.equals(paramString))
    {
      AppMethodBeat.o(219547);
      return 1412;
    }
    if (a.gtG.equals(paramString))
    {
      AppMethodBeat.o(219547);
      return 1413;
    }
    AppMethodBeat.o(219547);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.c
 * JD-Core Version:    0.7.0.1
 */