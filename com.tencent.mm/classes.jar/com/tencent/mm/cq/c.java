package com.tencent.mm.cq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static void abB(int paramInt)
  {
    AppMethodBeat.i(152890);
    ad.i("BigImageReporter", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 24)
    {
      h.vKh.m(896L, 0L, 1L);
      AppMethodBeat.o(152890);
      return;
    }
    if (paramInt == 25) {
      h.vKh.m(896L, 1L, 1L);
    }
    AppMethodBeat.o(152890);
  }
  
  public static void abC(int paramInt)
  {
    AppMethodBeat.i(190804);
    ad.i("BigImageReporter", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      h.vKh.m(896L, 2L, 1L);
      AppMethodBeat.o(190804);
      return;
    }
    if (paramInt == 5) {
      h.vKh.m(896L, 3L, 1L);
    }
    AppMethodBeat.o(190804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cq.c
 * JD-Core Version:    0.7.0.1
 */