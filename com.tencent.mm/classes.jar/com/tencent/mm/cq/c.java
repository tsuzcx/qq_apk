package com.tencent.mm.cq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void aqp(int paramInt)
  {
    AppMethodBeat.i(152890);
    Log.i("BigImageReporter", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 24)
    {
      h.CyF.n(896L, 0L, 1L);
      AppMethodBeat.o(152890);
      return;
    }
    if (paramInt == 25) {
      h.CyF.n(896L, 1L, 1L);
    }
    AppMethodBeat.o(152890);
  }
  
  public static void aqq(int paramInt)
  {
    AppMethodBeat.i(223906);
    Log.i("BigImageReporter", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      h.CyF.n(896L, 2L, 1L);
      AppMethodBeat.o(223906);
      return;
    }
    if (paramInt == 5) {
      h.CyF.n(896L, 3L, 1L);
    }
    AppMethodBeat.o(223906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cq.c
 * JD-Core Version:    0.7.0.1
 */