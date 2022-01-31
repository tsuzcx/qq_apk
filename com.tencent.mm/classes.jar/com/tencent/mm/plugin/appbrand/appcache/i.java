package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private static final o gUc;
  
  static
  {
    AppMethodBeat.i(101714);
    gUc = new c();
    AppMethodBeat.o(101714);
  }
  
  public static String yn(String paramString)
  {
    AppMethodBeat.i(101713);
    paramString = gUc.openRead(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101713);
      return "";
    }
    paramString = com.tencent.luggage.g.i.convertStreamToString(paramString);
    AppMethodBeat.o(101713);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.i
 * JD-Core Version:    0.7.0.1
 */