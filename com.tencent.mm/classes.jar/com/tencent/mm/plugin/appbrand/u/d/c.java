package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a qlP;
  
  public c(e.a parama, v paramv)
  {
    super(parama, paramv);
  }
  
  public final void ccC()
  {
    AppMethodBeat.i(147411);
    this.qlP = new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(147410);
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("state", Integer.valueOf(paramAnonymousb.ordinal()));
        c.this.T(paramAnonymousString);
        AppMethodBeat.o(147410);
      }
    };
    this.czP.getRuntime().ntR.a(this.qlP);
    AppMethodBeat.o(147411);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147412);
    if (this.qlP == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    if (this.czP.getRuntime() == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    com.tencent.mm.plugin.appbrand.a.c localc = this.czP.getRuntime().ntR;
    if (localc == null)
    {
      AppMethodBeat.o(147412);
      return;
    }
    localc.b(this.qlP);
    AppMethodBeat.o(147412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.c
 * JD-Core Version:    0.7.0.1
 */