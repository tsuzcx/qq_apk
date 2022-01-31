package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
{
  public static final String alx()
  {
    AppMethodBeat.i(50727);
    String str = g.RL().eHR + "draft/";
    AppMethodBeat.o(50727);
    return str;
  }
  
  public static final String uV(String paramString)
  {
    AppMethodBeat.i(50728);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50728);
      return null;
    }
    paramString = alx() + paramString;
    AppMethodBeat.o(50728);
    return paramString;
  }
  
  public static final String uW(String paramString)
  {
    AppMethodBeat.i(50729);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50729);
      return null;
    }
    paramString = alx() + paramString + ".thumb";
    AppMethodBeat.o(50729);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.k
 * JD-Core Version:    0.7.0.1
 */