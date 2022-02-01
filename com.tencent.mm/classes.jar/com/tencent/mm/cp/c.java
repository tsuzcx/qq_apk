package com.tencent.mm.cp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  public static void adU(int paramInt)
  {
    AppMethodBeat.i(152890);
    ac.i("BigImageReporter", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 24)
    {
      h.wUl.n(896L, 0L, 1L);
      AppMethodBeat.o(152890);
      return;
    }
    if (paramInt == 25) {
      h.wUl.n(896L, 1L, 1L);
    }
    AppMethodBeat.o(152890);
  }
  
  public static void adV(int paramInt)
  {
    AppMethodBeat.i(192721);
    ac.i("BigImageReporter", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      h.wUl.n(896L, 2L, 1L);
      AppMethodBeat.o(192721);
      return;
    }
    if (paramInt == 5) {
      h.wUl.n(896L, 3L, 1L);
    }
    AppMethodBeat.o(192721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cp.c
 * JD-Core Version:    0.7.0.1
 */