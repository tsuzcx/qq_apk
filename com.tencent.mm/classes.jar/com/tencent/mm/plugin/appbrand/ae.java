package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class ae
{
  public static boolean v(o paramo)
  {
    AppMethodBeat.i(186274);
    if ((paramo != null) && (paramo.CC()) && (paramo.aTS().jjf != null) && (paramo.aTS().jjf.startsWith("__wx__")))
    {
      AppMethodBeat.o(186274);
      return true;
    }
    AppMethodBeat.o(186274);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae
 * JD-Core Version:    0.7.0.1
 */