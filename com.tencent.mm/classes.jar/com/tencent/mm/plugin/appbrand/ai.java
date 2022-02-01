package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class ai
{
  public static boolean acd(String paramString)
  {
    AppMethodBeat.i(265774);
    if ((paramString != null) && (paramString.startsWith("__wx__")))
    {
      AppMethodBeat.o(265774);
      return true;
    }
    AppMethodBeat.o(265774);
    return false;
  }
  
  public static boolean q(t paramt)
  {
    AppMethodBeat.i(265773);
    if ((paramt != null) && (paramt.Qv()) && (paramt.bDy().nBq != null) && (paramt.bDy().nBq.startsWith("__wx__")))
    {
      AppMethodBeat.o(265773);
      return true;
    }
    AppMethodBeat.o(265773);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai
 * JD-Core Version:    0.7.0.1
 */