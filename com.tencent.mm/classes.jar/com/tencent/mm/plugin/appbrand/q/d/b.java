package com.tencent.mm.plugin.appbrand.q.d;

import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends e
{
  private d.c lXX;
  
  public b(e.a parama, q paramq)
  {
    super(parama, paramq);
  }
  
  public final void btD()
  {
    AppMethodBeat.i(147408);
    d locald = ((c)this.cox.getRuntime()).cpr;
    if (locald == null)
    {
      ad.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.lXX = new d.c()
    {
      public final void g(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        AppMethodBeat.i(147407);
        ad.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
        HashMap localHashMap = new HashMap();
        localHashMap.put("fg", paramAnonymousArrayOfByte1);
        localHashMap.put("bg", paramAnonymousArrayOfByte2);
        b.this.Q(localHashMap);
        AppMethodBeat.o(147407);
      }
    };
    d.c localc = this.lXX;
    synchronized (locald.mhU)
    {
      locald.mhY.add(localc);
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
    if (this.lXX == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.cox.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    d locald = ((c)this.cox.getRuntime()).cpr;
    if (locald == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    d.c localc = this.lXX;
    synchronized (locald.mhU)
    {
      locald.mhY.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.b
 * JD-Core Version:    0.7.0.1
 */