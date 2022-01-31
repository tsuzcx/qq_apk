package com.tencent.mm.api;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  public static String bT(String paramString)
  {
    String str = paramString;
    if (bk.bl(paramString)) {
      str = "tempConv";
    }
    paramString = new StringBuilder(c.FH());
    paramString.append(g.o(str.getBytes())).append("/");
    paramString.append("conv/");
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.api.a
 * JD-Core Version:    0.7.0.1
 */