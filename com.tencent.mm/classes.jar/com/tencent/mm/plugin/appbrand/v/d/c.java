package com.tencent.mm.plugin.appbrand.v.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.v.a.e;
import com.tencent.mm.plugin.appbrand.v.a.e.a;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a tqR;
  
  public c(e.a parama, y paramy)
  {
    super(parama, paramy);
  }
  
  public final void cCY()
  {
    AppMethodBeat.i(147411);
    this.tqR = new c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(147410);
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("state", Integer.valueOf(paramAnonymousb.ordinal()));
        c.this.aa(paramAnonymousString);
        AppMethodBeat.o(147410);
      }
    };
    this.esk.getRuntime().qsB.a(this.tqR);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.tqR == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.esk.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.b.c localc = this.esk.getRuntime().qsB;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.tqR);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.d.c
 * JD-Core Version:    0.7.0.1
 */