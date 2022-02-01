package com.tencent.mm.plugin.appbrand.q.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a lXZ;
  
  public c(e.a parama, q paramq)
  {
    super(parama, paramq);
  }
  
  public final void btD()
  {
    AppMethodBeat.i(147411);
    this.lXZ = new c.a()
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
    this.cox.getRuntime().jwS.a(this.lXZ);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.lXZ == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.cox.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.a.c localc = this.cox.getRuntime().jwS;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.lXZ);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.c
 * JD-Core Version:    0.7.0.1
 */