package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static String cV(String paramString)
  {
    AppMethodBeat.i(105476);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = "tempConv";
    }
    paramString = new StringBuilder(c.YL());
    paramString.append(g.w(str.getBytes())).append("/");
    paramString.append("conv/");
    paramString = paramString.toString();
    AppMethodBeat.o(105476);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.api.a
 * JD-Core Version:    0.7.0.1
 */