package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class an
{
  public static boolean u(w paramw)
  {
    AppMethodBeat.i(316667);
    if ((paramw != null) && (paramw.aqJ()) && (paramw.getInitConfig().qAF != null) && (paramw.getInitConfig().qAF.startsWith("__wx__")))
    {
      AppMethodBeat.o(316667);
      return true;
    }
    AppMethodBeat.o(316667);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.an
 * JD-Core Version:    0.7.0.1
 */