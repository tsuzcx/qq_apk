package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class ae
{
  public static boolean Ll(String paramString)
  {
    AppMethodBeat.i(222045);
    if ((paramString != null) && (paramString.startsWith("__wx__")))
    {
      AppMethodBeat.o(222045);
      return true;
    }
    AppMethodBeat.o(222045);
    return false;
  }
  
  public static boolean n(p paramp)
  {
    AppMethodBeat.i(222044);
    if ((paramp != null) && (paramp.Ee()) && (paramp.aXx().jFL != null) && (paramp.aXx().jFL.startsWith("__wx__")))
    {
      AppMethodBeat.o(222044);
      return true;
    }
    AppMethodBeat.o(222044);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae
 * JD-Core Version:    0.7.0.1
 */