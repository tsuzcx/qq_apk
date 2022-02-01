package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.e;
import com.tencent.mm.plugin.appbrand.o.k.a;
import java.util.HashMap;
import java.util.Map;

public final class cn
{
  static final Map<String, c.a> kvg;
  
  static
  {
    AppMethodBeat.i(134878);
    kvg = new HashMap();
    AppMethodBeat.o(134878);
  }
  
  public static void biy()
  {
    AppMethodBeat.i(134877);
    e.a(new k.a()
    {
      public final void a(final c paramAnonymousc, final String paramAnonymousString, final e paramAnonymouse)
      {
        AppMethodBeat.i(197275);
        paramAnonymouse = new c.a()
        {
          public final void a(String paramAnonymous2String, b paramAnonymous2b)
          {
            AppMethodBeat.i(134874);
            e.a(paramAnonymousc, paramAnonymous2String, paramAnonymous2b, paramAnonymousString, paramAnonymouse);
            AppMethodBeat.o(134874);
          }
        };
        cn.kvg.put(paramAnonymousString, paramAnonymouse);
        ((h)paramAnonymousc).getRuntime().jwS.a(paramAnonymouse);
        AppMethodBeat.o(197275);
      }
      
      public final void d(c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(197276);
        paramAnonymousString = (c.a)cn.kvg.get(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousc = ((h)paramAnonymousc).getRuntime();
          if (paramAnonymousc != null) {
            paramAnonymousc.jwS.b(paramAnonymousString);
          }
        }
        AppMethodBeat.o(197276);
      }
    });
    AppMethodBeat.o(134877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cn
 * JD-Core Version:    0.7.0.1
 */