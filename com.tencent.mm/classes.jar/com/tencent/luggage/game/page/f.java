package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.by;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.a;
import com.tencent.mm.plugin.appbrand.page.t.d;
import java.util.concurrent.Callable;

public class f
  implements t.a
{
  public final boolean Cu()
  {
    return true;
  }
  
  public aa a(t paramt)
  {
    AppMethodBeat.i(177440);
    paramt = new c(h.class);
    AppMethodBeat.o(177440);
    return paramt;
  }
  
  public final q a(String paramString, by paramby, t paramt, Callable<q> paramCallable)
  {
    AppMethodBeat.i(177439);
    paramString = new e(paramt.getContext(), paramt);
    AppMethodBeat.o(177439);
    return paramString;
  }
  
  public final boolean a(String paramString, by paramby, t paramt, t.d paramd)
  {
    AppMethodBeat.i(130639);
    switch (1.cdA[paramby.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130639);
      return true;
      paramd.proceed();
      continue;
      paramt.a(null, paramt.getCurrentPage(), by.lgu, paramString);
      paramt.getCurrentPage().loadUrl(paramString);
      paramt.a(null, paramt.getCurrentPage(), by.lgu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.f
 * JD-Core Version:    0.7.0.1
 */