package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n.a.e;
import com.tencent.mm.plugin.appbrand.n.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends e
{
  private c.a iuv;
  
  public c(e.a parama, r paramr)
  {
    super(parama, paramr);
  }
  
  public final void aIC()
  {
    AppMethodBeat.i(102211);
    this.iuv = new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(102210);
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("state", Integer.valueOf(paramAnonymousb.ordinal()));
        c.this.E(paramAnonymousString);
        AppMethodBeat.o(102210);
      }
    };
    this.bEw.getRuntime().gPL.a(this.iuv);
    AppMethodBeat.o(102211);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(102212);
    if (this.iuv == null)
    {
      AppMethodBeat.o(102212);
      return;
    }
    if (this.bEw.getRuntime() == null)
    {
      AppMethodBeat.o(102212);
      return;
    }
    com.tencent.mm.plugin.appbrand.b.c localc = this.bEw.getRuntime().gPL;
    if (localc == null)
    {
      AppMethodBeat.o(102212);
      return;
    }
    localc.b(this.iuv);
    AppMethodBeat.o(102212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d.c
 * JD-Core Version:    0.7.0.1
 */