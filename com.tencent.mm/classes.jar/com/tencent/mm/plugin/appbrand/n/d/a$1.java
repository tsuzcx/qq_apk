package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

final class a$1
  implements s.b
{
  a$1(a parama) {}
  
  public final void aui()
  {
    AppMethodBeat.i(102204);
    ab.i("MicroMsg.ProxyAppBrandServiceOnInitListener", "onRuntimeReady");
    Object localObject1 = this.ius.bEw.getRuntime();
    if (localObject1 == null)
    {
      localObject1 = new IllegalStateException("onRuntimeReady runtime null");
      AppMethodBeat.o(102204);
      throw ((Throwable)localObject1);
    }
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((com.tencent.luggage.sdk.d.b)localObject1).wO();
    if (localObject2 == null) {
      ab.w("MicroMsg.ProxyAppBrandServiceOnInitListener", "fillPermissionBytes controller null");
    }
    for (;;)
    {
      localHashMap.put("state", Integer.valueOf(((i)localObject1).gPL.gYj.awr().ordinal()));
      localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.n.b.b.D((i)localObject1));
      this.ius.E(localHashMap);
      AppMethodBeat.o(102204);
      return;
      localObject2 = ((e)localObject2).aKy();
      if (localObject2 == null)
      {
        ab.i("MicroMsg.ProxyAppBrandServiceOnInitListener", "fillPermissionBytes getPermissionBytes null");
      }
      else
      {
        localHashMap.put("fg", ((Vector)localObject2).elementAt(0));
        localHashMap.put("bg", ((Vector)localObject2).elementAt(1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d.a.1
 * JD-Core Version:    0.7.0.1
 */