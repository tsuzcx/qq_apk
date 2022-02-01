package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.s.k.a;
import java.util.HashMap;
import java.util.Map;

public final class dg
{
  static final Map<String, c.a> oyq;
  
  static
  {
    AppMethodBeat.i(134878);
    oyq = new HashMap();
    AppMethodBeat.o(134878);
  }
  
  public static void bPV()
  {
    AppMethodBeat.i(134877);
    com.tencent.mm.plugin.appbrand.jsapi.p.e.a(new k.a()
    {
      public final void a(final e paramAnonymouse, final String paramAnonymousString, final com.tencent.mm.plugin.appbrand.jsapi.p.e paramAnonymouse1)
      {
        AppMethodBeat.i(245878);
        paramAnonymouse1 = new c.a()
        {
          public final void a(String paramAnonymous2String, b paramAnonymous2b)
          {
            AppMethodBeat.i(134874);
            com.tencent.mm.plugin.appbrand.jsapi.p.e.a(paramAnonymouse, paramAnonymous2String, paramAnonymous2b, paramAnonymousString, paramAnonymouse1);
            AppMethodBeat.o(134874);
          }
        };
        dg.oyq.put(paramAnonymousString, paramAnonymouse1);
        ((j)paramAnonymouse).getRuntime().ntR.a(paramAnonymouse1);
        AppMethodBeat.o(245878);
      }
      
      public final void d(e paramAnonymouse, String paramAnonymousString)
      {
        AppMethodBeat.i(245879);
        paramAnonymousString = (c.a)dg.oyq.get(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymouse = ((j)paramAnonymouse).getRuntime();
          if (paramAnonymouse != null) {
            paramAnonymouse.ntR.b(paramAnonymousString);
          }
        }
        AppMethodBeat.o(245879);
      }
    });
    AppMethodBeat.o(134877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dg
 * JD-Core Version:    0.7.0.1
 */