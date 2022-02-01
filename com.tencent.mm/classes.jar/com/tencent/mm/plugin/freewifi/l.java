package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class l
{
  public static void Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(24694);
    h.CyF.a(12651, new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(24694);
  }
  
  public static void R(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(24695);
    h.CyF.a(12651, new Object[] { Integer.valueOf(2), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(24695);
  }
  
  public static void S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(24696);
    h.CyF.a(12651, new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(24696);
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(24697);
    if (paramBoolean)
    {
      h.CyF.a(12651, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(1), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(24697);
      return;
    }
    h.CyF.a(12651, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(24697);
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(24698);
    if (paramBoolean)
    {
      h.CyF.a(12651, new Object[] { Integer.valueOf(5), paramString1, Integer.valueOf(1), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(24698);
      return;
    }
    h.CyF.a(12651, new Object[] { Integer.valueOf(5), paramString1, Integer.valueOf(0), paramString2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(24698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.l
 * JD-Core Version:    0.7.0.1
 */