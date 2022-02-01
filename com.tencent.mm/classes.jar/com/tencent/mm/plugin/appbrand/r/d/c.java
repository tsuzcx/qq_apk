package com.tencent.mm.plugin.appbrand.r.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.e;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a kWR;
  
  public c(e.a parama, q paramq)
  {
    super(parama, paramq);
  }
  
  public final void biJ()
  {
    AppMethodBeat.i(147411);
    this.kWR = new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(147410);
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("state", Integer.valueOf(paramAnonymousb.ordinal()));
        c.this.Q(paramAnonymousString);
        AppMethodBeat.o(147410);
      }
    };
    this.chm.getRuntime().iDK.a(this.kWR);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.kWR == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.chm.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.b.c localc = this.chm.getRuntime().iDK;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.kWR);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d.c
 * JD-Core Version:    0.7.0.1
 */