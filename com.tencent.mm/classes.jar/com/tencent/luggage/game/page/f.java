package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.w.a;
import com.tencent.mm.plugin.appbrand.page.w.d;
import java.util.concurrent.Callable;

public class f
  implements w.a
{
  public final boolean MX()
  {
    return true;
  }
  
  public ac a(w paramw)
  {
    AppMethodBeat.i(177440);
    paramw = new c(h.class);
    AppMethodBeat.o(177440);
    return paramw;
  }
  
  public final t a(String paramString, bx parambx, w paramw, Callable<t> paramCallable)
  {
    AppMethodBeat.i(177439);
    paramString = new e(paramw.getContext(), paramw);
    AppMethodBeat.o(177439);
    return paramString;
  }
  
  public final boolean a(String paramString, bx parambx, w paramw, w.d paramd)
  {
    AppMethodBeat.i(130639);
    switch (1.cwL[parambx.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130639);
      return true;
      paramd.proceed();
      continue;
      paramw.a(null, paramw.getCurrentPage(), bx.nuJ, paramString, false);
      paramw.getCurrentPage().loadUrl(paramString);
      paramw.a(null, paramw.getCurrentPage(), bx.nuJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.f
 * JD-Core Version:    0.7.0.1
 */