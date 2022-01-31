package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements c.a
{
  b$2(b paramb, o paramo) {}
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
  {
    if (paramb == com.tencent.mm.plugin.appbrand.b.b.fFL)
    {
      y.d("MicroMsg.DownloadAppStateChangeEvent", "destroyed");
      MMToClientEvent.b(this.gcp.mAppId, b.a(this.ghN));
      b.d(this.gcp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b.2
 * JD-Core Version:    0.7.0.1
 */