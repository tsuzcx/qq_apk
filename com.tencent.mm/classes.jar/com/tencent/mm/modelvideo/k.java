package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  public static final String GS(String paramString)
  {
    AppMethodBeat.i(126890);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126890);
      return null;
    }
    paramString = aMC() + paramString;
    AppMethodBeat.o(126890);
    return paramString;
  }
  
  public static final String GT(String paramString)
  {
    AppMethodBeat.i(126891);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126891);
      return null;
    }
    paramString = aMC() + paramString + ".thumb";
    AppMethodBeat.o(126891);
    return paramString;
  }
  
  public static final String aMC()
  {
    AppMethodBeat.i(126889);
    String str = g.ajC().gBm + "draft/";
    AppMethodBeat.o(126889);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.k
 * JD-Core Version:    0.7.0.1
 */