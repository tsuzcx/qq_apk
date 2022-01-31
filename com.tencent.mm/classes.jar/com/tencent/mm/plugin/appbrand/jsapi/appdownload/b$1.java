package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.o;
import org.json.JSONObject;

final class b$1
  implements MMToClientEvent.c
{
  b$1(b paramb, o paramo) {}
  
  public final void aG(Object paramObject)
  {
    if ((paramObject instanceof AppbrandDownloadState))
    {
      paramObject = (AppbrandDownloadState)paramObject;
      if (this.gcp != null) {
        this.ghN.d(this.gcp).tL(paramObject.ahT().toString()).dispatch();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b.1
 * JD-Core Version:    0.7.0.1
 */