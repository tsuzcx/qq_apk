package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o.k.a;
import java.util.Map;

final class bd$1
  implements k.a
{
  public final void d(c paramc, String paramString)
  {
    bd.1.1 local1 = new bd.1.1(this, paramc, paramString);
    bd.ghI.put(paramString, local1);
    ((f)paramc).getRuntime().fyy.a(local1);
  }
  
  public final void e(c paramc, String paramString)
  {
    paramString = (c.a)bd.ghI.get(paramString);
    if (paramString != null) {
      ((f)paramc).getRuntime().fyy.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bd.1
 * JD-Core Version:    0.7.0.1
 */