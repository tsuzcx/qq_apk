package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.a;
import com.tencent.mm.plugin.appbrand.page.t.d;
import com.tencent.mm.plugin.appbrand.page.z;
import java.util.concurrent.Callable;

public class f
  implements t.a
{
  public final boolean DA()
  {
    return true;
  }
  
  public final q a(String paramString, br parambr, t paramt, Callable<q> paramCallable)
  {
    AppMethodBeat.i(177439);
    paramString = new e(paramt.getContext(), paramt);
    AppMethodBeat.o(177439);
    return paramString;
  }
  
  public z a(t paramt)
  {
    AppMethodBeat.i(177440);
    paramt = new c(h.class);
    AppMethodBeat.o(177440);
    return paramt;
  }
  
  public final boolean a(String paramString, br parambr, t paramt, t.d paramd)
  {
    AppMethodBeat.i(130639);
    switch (1.ckQ[parambr.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130639);
      return true;
      paramd.proceed();
      continue;
      paramt.a(null, paramt.getCurrentPage(), br.mkm, paramString, false);
      paramt.getCurrentPage().loadUrl(paramString);
      paramt.a(null, paramt.getCurrentPage(), br.mkm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.f
 * JD-Core Version:    0.7.0.1
 */