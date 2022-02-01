package com.tencent.mm.plugin.appbrand.q.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a mcG;
  
  public c(e.a parama, r paramr)
  {
    super(parama, paramr);
  }
  
  public final void buo()
  {
    AppMethodBeat.i(147411);
    this.mcG = new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(147410);
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("state", Integer.valueOf(paramAnonymousb.ordinal()));
        c.this.X(paramAnonymousString);
        AppMethodBeat.o(147410);
      }
    };
    this.coz.getRuntime().jzQ.a(this.mcG);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.mcG == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.coz.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.a.c localc = this.coz.getRuntime().jzQ;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.mcG);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.c
 * JD-Core Version:    0.7.0.1
 */