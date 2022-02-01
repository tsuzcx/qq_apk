package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  public static final String aCB()
  {
    AppMethodBeat.i(126889);
    String str = g.afB().gcW + "draft/";
    AppMethodBeat.o(126889);
    return str;
  }
  
  public static final String zH(String paramString)
  {
    AppMethodBeat.i(126890);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126890);
      return null;
    }
    paramString = aCB() + paramString;
    AppMethodBeat.o(126890);
    return paramString;
  }
  
  public static final String zI(String paramString)
  {
    AppMethodBeat.i(126891);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126891);
      return null;
    }
    paramString = aCB() + paramString + ".thumb";
    AppMethodBeat.o(126891);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.k
 * JD-Core Version:    0.7.0.1
 */