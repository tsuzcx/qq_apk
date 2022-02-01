package com.tencent.mm.plugin.appbrand.q.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends e
{
  private d.c mcE;
  
  public b(e.a parama, r paramr)
  {
    super(parama, paramr);
  }
  
  public final void buo()
  {
    AppMethodBeat.i(147408);
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.d.d)this.coz.getRuntime()).cpU;
    if (locald == null)
    {
      ae.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.mcE = new d.c()
    {
      public final void g(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        AppMethodBeat.i(147407);
        ae.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
        HashMap localHashMap = new HashMap();
        localHashMap.put("fg", paramAnonymousArrayOfByte1);
        localHashMap.put("bg", paramAnonymousArrayOfByte2);
        b.this.X(localHashMap);
        AppMethodBeat.o(147407);
      }
    };
    d.c localc = this.mcE;
    synchronized (locald.mmS)
    {
      locald.mmW.add(localc);
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
    if (this.mcE == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.coz.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.d.d)this.coz.getRuntime()).cpU;
    if (locald == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    d.c localc = this.mcE;
    synchronized (locald.mmS)
    {
      locald.mmW.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.b
 * JD-Core Version:    0.7.0.1
 */