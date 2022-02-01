package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
{
  public static final String PG(String paramString)
  {
    AppMethodBeat.i(126890);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126890);
      return null;
    }
    paramString = bOa() + paramString;
    AppMethodBeat.o(126890);
    return paramString;
  }
  
  public static final String PH(String paramString)
  {
    AppMethodBeat.i(126891);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126891);
      return null;
    }
    paramString = bOa() + paramString + ".thumb";
    AppMethodBeat.o(126891);
    return paramString;
  }
  
  public static final String bOa()
  {
    AppMethodBeat.i(126889);
    String str = h.baE().mCJ + "draft/";
    AppMethodBeat.o(126889);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.r
 * JD-Core Version:    0.7.0.1
 */