package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a.e.a;
import com.tencent.mm.plugin.appbrand.permission.e.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.appbrand.n.a.e
{
  private e.c iut;
  
  public b(e.a parama, r paramr)
  {
    super(parama, paramr);
  }
  
  public final void aIC()
  {
    AppMethodBeat.i(102208);
    com.tencent.mm.plugin.appbrand.permission.e locale = ((com.tencent.luggage.sdk.d.b)this.bEw.getRuntime()).wO();
    if (locale == null)
    {
      ab.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(102208);
      return;
    }
    this.iut = new b.1(this);
    e.c localc = this.iut;
    synchronized (locale.iBT)
    {
      locale.iBV.add(localc);
      AppMethodBeat.o(102208);
      return;
    }
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(102209);
    if (this.iut == null)
    {
      AppMethodBeat.o(102209);
      return;
    }
    if (this.bEw.getRuntime() == null)
    {
      AppMethodBeat.o(102209);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.e locale = ((com.tencent.luggage.sdk.d.b)this.bEw.getRuntime()).wO();
    if (locale == null)
    {
      AppMethodBeat.o(102209);
      return;
    }
    e.c localc = this.iut;
    synchronized (locale.iBT)
    {
      locale.iBV.remove(localc);
      AppMethodBeat.o(102209);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d.b
 * JD-Core Version:    0.7.0.1
 */