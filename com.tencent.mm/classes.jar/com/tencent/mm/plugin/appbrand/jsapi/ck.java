package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.j.g;
import com.tencent.mm.plugin.appbrand.q.k.a;
import java.util.HashMap;
import java.util.Map;

public final class ck
{
  static final Map<String, c.a> jAo;
  
  static
  {
    AppMethodBeat.i(134878);
    jAo = new HashMap();
    AppMethodBeat.o(134878);
  }
  
  public static void aXX()
  {
    AppMethodBeat.i(134877);
    g.a(new k.a()
    {
      public final void a(final c paramAnonymousc, final String paramAnonymousString, final g paramAnonymousg)
      {
        AppMethodBeat.i(194466);
        paramAnonymousg = new c.a()
        {
          public final void a(String paramAnonymous2String, b paramAnonymous2b)
          {
            AppMethodBeat.i(134874);
            g.a(paramAnonymousc, paramAnonymous2String, paramAnonymous2b, paramAnonymousString, paramAnonymousg);
            AppMethodBeat.o(134874);
          }
        };
        ck.jAo.put(paramAnonymousString, paramAnonymousg);
        ((h)paramAnonymousc).getRuntime().iDK.a(paramAnonymousg);
        AppMethodBeat.o(194466);
      }
      
      public final void d(c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(194467);
        paramAnonymousString = (c.a)ck.jAo.get(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousc = ((h)paramAnonymousc).getRuntime();
          if (paramAnonymousc != null) {
            paramAnonymousc.iDK.b(paramAnonymousString);
          }
        }
        AppMethodBeat.o(194467);
      }
    });
    AppMethodBeat.o(134877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ck
 * JD-Core Version:    0.7.0.1
 */