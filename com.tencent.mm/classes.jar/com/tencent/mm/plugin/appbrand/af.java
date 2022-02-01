package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public final class af
{
  public static boolean Ut(String paramString)
  {
    AppMethodBeat.i(226246);
    if ((paramString != null) && (paramString.startsWith("__wx__")))
    {
      AppMethodBeat.o(226246);
      return true;
    }
    AppMethodBeat.o(226246);
    return false;
  }
  
  public static boolean p(q paramq)
  {
    AppMethodBeat.i(226245);
    if ((paramq != null) && (paramq.NA()) && (paramq.bsC().kHw != null) && (paramq.bsC().kHw.startsWith("__wx__")))
    {
      AppMethodBeat.o(226245);
      return true;
    }
    AppMethodBeat.o(226245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af
 * JD-Core Version:    0.7.0.1
 */