package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;

final class e$1
  implements a<Void, String>
{
  e$1(e parame) {}
  
  private static Void yP(String paramString)
  {
    AppMethodBeat.i(129447);
    try
    {
      e.yO(paramString);
      AppMethodBeat.o(129447);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", paramString, "process pbBase64", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.1
 * JD-Core Version:    0.7.0.1
 */