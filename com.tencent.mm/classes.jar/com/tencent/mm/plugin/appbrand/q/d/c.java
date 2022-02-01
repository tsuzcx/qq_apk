package com.tencent.mm.plugin.appbrand.q.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a lyB;
  
  public c(e.a parama, q paramq)
  {
    super(parama, paramq);
  }
  
  public final void bpC()
  {
    AppMethodBeat.i(147411);
    this.lyB = new c.a()
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
    this.ceh.getRuntime().jdK.a(this.lyB);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.lyB == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.ceh.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.b.c localc = this.ceh.getRuntime().jdK;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.lyB);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.c
 * JD-Core Version:    0.7.0.1
 */