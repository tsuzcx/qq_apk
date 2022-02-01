package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bt;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.u.a;
import com.tencent.mm.plugin.appbrand.page.u.d;
import java.util.concurrent.Callable;

public class f
  implements u.a
{
  public final boolean BY()
  {
    return true;
  }
  
  public aa a(u paramu)
  {
    AppMethodBeat.i(177440);
    paramu = new c(h.class);
    AppMethodBeat.o(177440);
    return paramu;
  }
  
  public final r a(String paramString, bt parambt, u paramu, Callable<r> paramCallable)
  {
    AppMethodBeat.i(177439);
    paramString = new e(paramu.getContext(), paramu);
    AppMethodBeat.o(177439);
    return paramString;
  }
  
  public final boolean a(String paramString, bt parambt, u paramu, u.d paramd)
  {
    AppMethodBeat.i(130639);
    switch (1.cax[parambt.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130639);
      return true;
      paramd.proceed();
      continue;
      paramu.a(null, paramu.getCurrentPage(), bt.lGo, paramString);
      paramu.getCurrentPage().loadUrl(paramString);
      paramu.a(null, paramu.getCurrentPage(), bt.lGo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.f
 * JD-Core Version:    0.7.0.1
 */