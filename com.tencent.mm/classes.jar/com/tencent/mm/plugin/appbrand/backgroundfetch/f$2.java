package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.sdk.platformtools.y;

public final class f$2
  implements c.a
{
  public f$2(MMToClientEvent.c paramc) {}
  
  public final void a(String paramString, b paramb)
  {
    if (paramb == b.fFL)
    {
      MMToClientEvent.b(paramString, this.fKO);
      y.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app stop listening, appId:%s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.f.2
 * JD-Core Version:    0.7.0.1
 */