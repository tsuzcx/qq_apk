package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.e;
import com.tencent.mm.plugin.appbrand.t.j.a;
import java.util.HashMap;
import java.util.Map;

public final class do
{
  static final Map<String, c.a> rBK;
  
  static
  {
    AppMethodBeat.i(134878);
    rBK = new HashMap();
    AppMethodBeat.o(134878);
  }
  
  public static void cpZ()
  {
    AppMethodBeat.i(134877);
    e.a(new j.a()
    {
      public final void a(final f paramAnonymousf, final String paramAnonymousString, final e paramAnonymouse)
      {
        AppMethodBeat.i(326193);
        paramAnonymouse = new c.a()
        {
          public final void onRunningStateChanged(String paramAnonymous2String, b paramAnonymous2b)
          {
            AppMethodBeat.i(134874);
            e.a(paramAnonymousf, paramAnonymous2String, paramAnonymous2b, paramAnonymousString, paramAnonymouse);
            AppMethodBeat.o(134874);
          }
        };
        do.rBK.put(paramAnonymousString, paramAnonymouse);
        ((k)paramAnonymousf).getRuntime().qsB.a(paramAnonymouse);
        AppMethodBeat.o(326193);
      }
      
      public final void d(f paramAnonymousf, String paramAnonymousString)
      {
        AppMethodBeat.i(326196);
        paramAnonymousString = (c.a)do.rBK.get(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousf = ((k)paramAnonymousf).getRuntime();
          if (paramAnonymousf != null) {
            paramAnonymousf.qsB.b(paramAnonymousString);
          }
        }
        AppMethodBeat.o(326196);
      }
    });
    AppMethodBeat.o(134877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.do
 * JD-Core Version:    0.7.0.1
 */