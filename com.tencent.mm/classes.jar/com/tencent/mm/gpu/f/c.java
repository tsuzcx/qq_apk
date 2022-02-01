package com.tencent.mm.gpu.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.b.a;
import com.tencent.mm.plugin.report.service.h;

public final class c
{
  public static int Me(String paramString)
  {
    AppMethodBeat.i(210659);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(210659);
      return -1;
    }
    if (a.jUS.equals(paramString))
    {
      AppMethodBeat.o(210659);
      return 1406;
    }
    if (paramString.startsWith(a.jUT))
    {
      AppMethodBeat.o(210659);
      return 1410;
    }
    if (a.jUU.equals(paramString))
    {
      AppMethodBeat.o(210659);
      return 1412;
    }
    if (a.jUV.equals(paramString))
    {
      AppMethodBeat.o(210659);
      return 1413;
    }
    AppMethodBeat.o(210659);
    return -1;
  }
  
  public static void aEN()
  {
    AppMethodBeat.i(210656);
    f(1403L, 1L, 1L);
    f(1403L, 3L, 1L);
    AppMethodBeat.o(210656);
  }
  
  public static void aEO()
  {
    AppMethodBeat.i(210658);
    f(1403L, 2L, 1L);
    f(1403L, 3L, 1L);
    AppMethodBeat.o(210658);
  }
  
  public static void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(210654);
    h.IzE.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(210654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.gpu.f.c
 * JD-Core Version:    0.7.0.1
 */