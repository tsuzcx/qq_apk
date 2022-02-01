package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends e
{
  private d.c nkp;
  
  public b(e.a parama, s params)
  {
    super(parama, params);
  }
  
  public final void bPV()
  {
    AppMethodBeat.i(147408);
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.d.d)this.cAJ.getRuntime()).cCn;
    if (locald == null)
    {
      Log.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.nkp = new d.c()
    {
      public final void g(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        AppMethodBeat.i(147407);
        Log.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
        HashMap localHashMap = new HashMap();
        localHashMap.put("fg", paramAnonymousArrayOfByte1);
        localHashMap.put("bg", paramAnonymousArrayOfByte2);
        b.this.aa(localHashMap);
        AppMethodBeat.o(147407);
      }
    };
    d.c localc = this.nkp;
    synchronized (locald.nxs)
    {
      locald.nxw.add(localc);
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
    if (this.nkp == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.cAJ.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.d.d)this.cAJ.getRuntime()).cCn;
    if (locald == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    d.c localc = this.nkp;
    synchronized (locald.nxs)
    {
      locald.nxw.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.b
 * JD-Core Version:    0.7.0.1
 */