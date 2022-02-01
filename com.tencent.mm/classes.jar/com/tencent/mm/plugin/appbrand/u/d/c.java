package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a nkr;
  
  public c(e.a parama, s params)
  {
    super(parama, params);
  }
  
  public final void bPV()
  {
    AppMethodBeat.i(147411);
    this.nkr = new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(147410);
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("state", Integer.valueOf(paramAnonymousb.ordinal()));
        c.this.aa(paramAnonymousString);
        AppMethodBeat.o(147410);
      }
    };
    this.cAJ.getRuntime().kAH.a(this.nkr);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.nkr == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.cAJ.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.a.c localc = this.cAJ.getRuntime().kAH;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.nkr);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.c
 * JD-Core Version:    0.7.0.1
 */