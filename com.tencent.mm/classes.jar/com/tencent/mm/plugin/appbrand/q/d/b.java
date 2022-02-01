package com.tencent.mm.plugin.appbrand.q.d;

import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.e.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.appbrand.q.a.e
{
  private e.c lyz;
  
  public b(e.a parama, q paramq)
  {
    super(parama, paramq);
  }
  
  public final void bpC()
  {
    AppMethodBeat.i(147408);
    com.tencent.mm.plugin.appbrand.permission.e locale = ((c)this.ceh.getRuntime()).cfa;
    if (locale == null)
    {
      ac.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      AppMethodBeat.o(147408);
      return;
    }
    this.lyz = new e.c()
    {
      public final void g(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        AppMethodBeat.i(147407);
        ac.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
        HashMap localHashMap = new HashMap();
        localHashMap.put("fg", paramAnonymousArrayOfByte1);
        localHashMap.put("bg", paramAnonymousArrayOfByte2);
        b.this.Q(localHashMap);
        AppMethodBeat.o(147407);
      }
    };
    e.c localc = this.lyz;
    synchronized (locale.lIH)
    {
      locale.lIL.add(localc);
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
    if (this.lyz == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    if (this.ceh.getRuntime() == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.e locale = ((c)this.ceh.getRuntime()).cfa;
    if (locale == null)
    {
      AppMethodBeat.o(147409);
      return;
    }
    e.c localc = this.lyz;
    synchronized (locale.lIH)
    {
      locale.lIL.remove(localc);
      AppMethodBeat.o(147409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.b
 * JD-Core Version:    0.7.0.1
 */