package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class ae
{
  public static boolean v(o paramo)
  {
    AppMethodBeat.i(195574);
    if ((paramo != null) && (paramo.CZ()) && (paramo.aNc().iJb != null) && (paramo.aNc().iJb.startsWith("__wx__")))
    {
      AppMethodBeat.o(195574);
      return true;
    }
    AppMethodBeat.o(195574);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae
 * JD-Core Version:    0.7.0.1
 */