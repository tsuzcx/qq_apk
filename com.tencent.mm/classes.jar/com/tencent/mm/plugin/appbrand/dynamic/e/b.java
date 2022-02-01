package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.d;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static boolean jnb;
  
  static
  {
    AppMethodBeat.i(121388);
    if (!jnb)
    {
      String str = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psK, "");
      ad.i("MicroMsg.Widget.AppBrandV8JsEngineImpl", "set v8 flag:%s", new Object[] { str });
      V8.setFlags(str);
      jnb = true;
      x.a(new b.1());
    }
    jnb = false;
    AppMethodBeat.o(121388);
  }
  
  public static d cs(Object paramObject)
  {
    AppMethodBeat.i(121387);
    paramObject = new a(paramObject);
    AppMethodBeat.o(121387);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.b
 * JD-Core Version:    0.7.0.1
 */