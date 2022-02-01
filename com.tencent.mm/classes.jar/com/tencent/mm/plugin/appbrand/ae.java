package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class ae
{
  public static boolean KL(String paramString)
  {
    AppMethodBeat.i(187935);
    if ((paramString != null) && (paramString.startsWith("__wx__")))
    {
      AppMethodBeat.o(187935);
      return true;
    }
    AppMethodBeat.o(187935);
    return false;
  }
  
  public static boolean m(o paramo)
  {
    AppMethodBeat.i(187934);
    if ((paramo != null) && (paramo.Eb()) && (paramo.aXc().jCN != null) && (paramo.aXc().jCN.startsWith("__wx__")))
    {
      AppMethodBeat.o(187934);
      return true;
    }
    AppMethodBeat.o(187934);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae
 * JD-Core Version:    0.7.0.1
 */