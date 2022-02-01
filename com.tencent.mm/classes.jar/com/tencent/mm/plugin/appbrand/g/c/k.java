package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public static String Yg(String paramString)
  {
    AppMethodBeat.i(159021);
    paramString = paramString.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("'", "&apos;");
    AppMethodBeat.o(159021);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.k
 * JD-Core Version:    0.7.0.1
 */