package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.appbrand.s.k.a;
import java.util.HashMap;
import java.util.Map;

public final class de
{
  static final Map<String, c.a> lCO;
  
  static
  {
    AppMethodBeat.i(134878);
    lCO = new HashMap();
    AppMethodBeat.o(134878);
  }
  
  public static void bEv()
  {
    AppMethodBeat.i(134877);
    e.a(new k.a()
    {
      public final void a(final f paramAnonymousf, final String paramAnonymousString, final e paramAnonymouse)
      {
        AppMethodBeat.i(219309);
        paramAnonymouse = new c.a()
        {
          public final void a(String paramAnonymous2String, b paramAnonymous2b)
          {
            AppMethodBeat.i(134874);
            e.a(paramAnonymousf, paramAnonymous2String, paramAnonymous2b, paramAnonymousString, paramAnonymouse);
            AppMethodBeat.o(134874);
          }
        };
        de.lCO.put(paramAnonymousString, paramAnonymouse);
        ((k)paramAnonymousf).getRuntime().kAH.a(paramAnonymouse);
        AppMethodBeat.o(219309);
      }
      
      public final void d(f paramAnonymousf, String paramAnonymousString)
      {
        AppMethodBeat.i(219310);
        paramAnonymousString = (c.a)de.lCO.get(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousf = ((k)paramAnonymousf).getRuntime();
          if (paramAnonymousf != null) {
            paramAnonymousf.kAH.b(paramAnonymousString);
          }
        }
        AppMethodBeat.o(219310);
      }
    });
    AppMethodBeat.o(134877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.de
 * JD-Core Version:    0.7.0.1
 */