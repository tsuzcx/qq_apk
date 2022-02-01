package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.x.a;
import com.tencent.mm.plugin.appbrand.page.x.d;
import java.util.concurrent.Callable;

public class f
  implements x.a
{
  public ad a(x paramx, String paramString)
  {
    AppMethodBeat.i(220151);
    paramx = new c(h.class);
    AppMethodBeat.o(220151);
    return paramx;
  }
  
  public final u a(String paramString, cb paramcb, x paramx, Callable<u> paramCallable)
  {
    AppMethodBeat.i(177439);
    paramString = new e(paramx.getContext(), paramx);
    AppMethodBeat.o(177439);
    return paramString;
  }
  
  public final boolean a(ad paramad, String paramString)
  {
    return paramad != null;
  }
  
  public final boolean a(String paramString, cb paramcb, x paramx, x.d paramd)
  {
    AppMethodBeat.i(130639);
    switch (1.enn[paramcb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130639);
      return true;
      paramd.proceed();
      continue;
      paramx.a(null, paramx.getCurrentPage(), cb.tBs, paramString, false);
      paramx.getCurrentPage().a(paramString, paramcb);
      paramx.a(null, paramx.getCurrentPage(), cb.tBs);
    }
  }
  
  public final boolean apY()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.f
 * JD-Core Version:    0.7.0.1
 */