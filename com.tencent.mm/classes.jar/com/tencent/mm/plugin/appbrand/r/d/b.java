package com.tencent.mm.plugin.appbrand.r.d;

import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.e.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.appbrand.r.a.e
{
  private e.c kWP;
  
  public b(e.a parama, q paramq)
  {
    super(parama, paramq);
  }
  
  public final void biJ()
  {
    AppMethodBeat.i(147408);
    com.tencent.mm.plugin.appbrand.permission.e locale = ((c)this.chm.getRuntime()).cif;
    if (locale == null)
    {
      ad.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.kWP = new e.c()
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
    e.c localc = this.kWP;
    synchronized (locale.liP)
    {
      locale.liT.add(localc);
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
    if (this.kWP == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.chm.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.e locale = ((c)this.chm.getRuntime()).cif;
    if (locale == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    e.c localc = this.kWP;
    synchronized (locale.liP)
    {
      locale.liT.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d.b
 * JD-Core Version:    0.7.0.1
 */