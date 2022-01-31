package com.tencent.luggage.game.page;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.r.a;
import com.tencent.mm.plugin.appbrand.page.r.b;
import com.tencent.mm.plugin.appbrand.page.v;

public class f
  implements r.a
{
  public final o a(r paramr)
  {
    AppMethodBeat.i(140495);
    paramr = new e(paramr.getContext(), paramr);
    AppMethodBeat.o(140495);
    return paramr;
  }
  
  public final boolean a(String paramString, bf parambf, r paramr, r.b paramb)
  {
    AppMethodBeat.i(140497);
    switch (f.1.bBL[parambf.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140497);
      return true;
      paramb.proceed();
      continue;
      paramr.a(null, paramr.getCurrentPage(), bf.izV, paramString);
      paramr.getCurrentPage().loadUrl(paramString);
      paramr.a(null, paramr.getCurrentPage(), bf.izV);
    }
  }
  
  public v vw()
  {
    AppMethodBeat.i(140496);
    c localc = new c(h.class);
    AppMethodBeat.o(140496);
    return localc;
  }
  
  public final boolean vx()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.page.f
 * JD-Core Version:    0.7.0.1
 */