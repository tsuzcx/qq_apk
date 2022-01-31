package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class l
{
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20617);
    h.qsU.e(12651, new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(20617);
  }
  
  public static void B(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20618);
    h.qsU.e(12651, new Object[] { Integer.valueOf(2), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(20618);
  }
  
  public static void C(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20619);
    h.qsU.e(12651, new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(20619);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20620);
    if (paramBoolean)
    {
      h.qsU.e(12651, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(1), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(20620);
      return;
    }
    h.qsU.e(12651, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(20620);
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20621);
    if (paramBoolean)
    {
      h.qsU.e(12651, new Object[] { Integer.valueOf(5), paramString1, Integer.valueOf(1), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(20621);
      return;
    }
    h.qsU.e(12651, new Object[] { Integer.valueOf(5), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(20621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.l
 * JD-Core Version:    0.7.0.1
 */