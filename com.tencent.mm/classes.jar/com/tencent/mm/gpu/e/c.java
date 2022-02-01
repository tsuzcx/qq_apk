package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.b.a;
import com.tencent.mm.plugin.report.service.h;

public final class c
{
  public static int Fi(String paramString)
  {
    AppMethodBeat.i(186201);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(186201);
      return -1;
    }
    if (a.hiY.equals(paramString))
    {
      AppMethodBeat.o(186201);
      return 1406;
    }
    if (paramString.startsWith(a.hiZ))
    {
      AppMethodBeat.o(186201);
      return 1410;
    }
    if (a.hja.equals(paramString))
    {
      AppMethodBeat.o(186201);
      return 1412;
    }
    if (a.hjb.equals(paramString))
    {
      AppMethodBeat.o(186201);
      return 1413;
    }
    AppMethodBeat.o(186201);
    return -1;
  }
  
  public static void axp()
  {
    AppMethodBeat.i(186196);
    e(1403L, 19L, 1L);
    e(1403L, 21L, 1L);
    AppMethodBeat.o(186196);
  }
  
  public static void axq()
  {
    AppMethodBeat.i(186197);
    e(1403L, 20L, 1L);
    e(1403L, 21L, 1L);
    AppMethodBeat.o(186197);
  }
  
  public static void axr()
  {
    AppMethodBeat.i(186199);
    e(1403L, 1L, 1L);
    e(1403L, 3L, 1L);
    AppMethodBeat.o(186199);
  }
  
  public static void axs()
  {
    AppMethodBeat.i(186200);
    e(1403L, 2L, 1L);
    e(1403L, 3L, 1L);
    AppMethodBeat.o(186200);
  }
  
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(186198);
    h.CyF.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(186198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.e.c
 * JD-Core Version:    0.7.0.1
 */