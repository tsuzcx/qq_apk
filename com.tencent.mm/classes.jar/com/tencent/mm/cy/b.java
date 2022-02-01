package com.tencent.mm.cy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void azP(int paramInt)
  {
    AppMethodBeat.i(152890);
    Log.i("BigImageReporter", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 24)
    {
      h.IzE.p(896L, 0L, 1L);
      AppMethodBeat.o(152890);
      return;
    }
    if (paramInt == 25) {
      h.IzE.p(896L, 1L, 1L);
    }
    AppMethodBeat.o(152890);
  }
  
  public static void azQ(int paramInt)
  {
    AppMethodBeat.i(200696);
    Log.i("BigImageReporter", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      h.IzE.p(896L, 2L, 1L);
      AppMethodBeat.o(200696);
      return;
    }
    if (paramInt == 5) {
      h.IzE.p(896L, 3L, 1L);
    }
    AppMethodBeat.o(200696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cy.b
 * JD-Core Version:    0.7.0.1
 */