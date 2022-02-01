package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static String dH(String paramString)
  {
    AppMethodBeat.i(116343);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = "tempConv";
    }
    paramString = new StringBuilder(d.apX());
    paramString.append(g.getMessageDigest(str.getBytes())).append("/");
    paramString.append("conv/");
    paramString = paramString.toString();
    AppMethodBeat.o(116343);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.a
 * JD-Core Version:    0.7.0.1
 */