package com.tencent.mm.cr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void aGF(int paramInt)
  {
    AppMethodBeat.i(152890);
    Log.i("BigImageReporter", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 24)
    {
      h.OAn.p(896L, 0L, 1L);
      AppMethodBeat.o(152890);
      return;
    }
    if (paramInt == 25) {
      h.OAn.p(896L, 1L, 1L);
    }
    AppMethodBeat.o(152890);
  }
  
  public static void aGG(int paramInt)
  {
    AppMethodBeat.i(230970);
    Log.i("BigImageReporter", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      h.OAn.p(896L, 2L, 1L);
      AppMethodBeat.o(230970);
      return;
    }
    if (paramInt == 5) {
      h.OAn.p(896L, 3L, 1L);
    }
    AppMethodBeat.o(230970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cr.b
 * JD-Core Version:    0.7.0.1
 */