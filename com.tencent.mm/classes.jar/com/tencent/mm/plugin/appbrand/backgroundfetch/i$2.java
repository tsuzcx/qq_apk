package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.sdk.platformtools.ab;

final class i$2
  implements c.a
{
  i$2(MMToClientEvent.c paramc) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(129807);
    if (paramb == b.gYh)
    {
      MMToClientEvent.b(paramString, this.hec);
      ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app stop listening background fetched data event, appId:%s", new Object[] { paramString });
    }
    AppMethodBeat.o(129807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.i.2
 * JD-Core Version:    0.7.0.1
 */