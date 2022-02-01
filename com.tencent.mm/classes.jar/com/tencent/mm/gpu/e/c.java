package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.b.a;
import com.tencent.mm.plugin.report.service.g;

public final class c
{
  public static void ahd()
  {
    AppMethodBeat.i(209664);
    e(1403L, 19L, 1L);
    e(1403L, 21L, 1L);
    AppMethodBeat.o(209664);
  }
  
  public static void ahe()
  {
    AppMethodBeat.i(209665);
    e(1403L, 20L, 1L);
    e(1403L, 21L, 1L);
    AppMethodBeat.o(209665);
  }
  
  public static void ahf()
  {
    AppMethodBeat.i(209667);
    e(1403L, 1L, 1L);
    e(1403L, 3L, 1L);
    AppMethodBeat.o(209667);
  }
  
  public static void ahg()
  {
    AppMethodBeat.i(209668);
    e(1403L, 2L, 1L);
    e(1403L, 3L, 1L);
    AppMethodBeat.o(209668);
  }
  
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(209666);
    g.yxI.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(209666);
  }
  
  public static int wU(String paramString)
  {
    AppMethodBeat.i(209669);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(209669);
      return -1;
    }
    if (a.gwk.equals(paramString))
    {
      AppMethodBeat.o(209669);
      return 1406;
    }
    if (paramString.startsWith(a.gwl))
    {
      AppMethodBeat.o(209669);
      return 1410;
    }
    if (a.gwm.equals(paramString))
    {
      AppMethodBeat.o(209669);
      return 1412;
    }
    if (a.gwn.equals(paramString))
    {
      AppMethodBeat.o(209669);
      return 1413;
    }
    AppMethodBeat.o(209669);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.c
 * JD-Core Version:    0.7.0.1
 */