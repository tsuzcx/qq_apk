package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;

final class c$1
  implements a<Void, String>
{
  c$1(c paramc) {}
  
  private static Void rp(String paramString)
  {
    try
    {
      c.ro(paramString);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", paramString, "process pbBase64", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.1
 * JD-Core Version:    0.7.0.1
 */