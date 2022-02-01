package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class b
{
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(222203);
    g.yxI.f(16742, new Object[] { paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(0) });
    AppMethodBeat.o(222203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.b
 * JD-Core Version:    0.7.0.1
 */