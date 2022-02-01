package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class b
  extends e
{
  private d.c qlN;
  
  public b(e.a parama, v paramv)
  {
    super(parama, paramv);
  }
  
  public final void ccC()
  {
    AppMethodBeat.i(147408);
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.e.d)this.czP.getRuntime()).cCQ;
    if (locald == null)
    {
      Log.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.qlN = new b.1(this);
    d.c localc = this.qlN;
    synchronized (locald.qzu)
    {
      locald.qzA.add(localc);
      AppMethodBeat.o(147408);
      return;
    }
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147409);
    if (this.qlN == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.czP.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.e.d)this.czP.getRuntime()).cCQ;
    if (locald == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    d.c localc = this.qlN;
    synchronized (locald.qzu)
    {
      locald.qzA.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.b
 * JD-Core Version:    0.7.0.1
 */