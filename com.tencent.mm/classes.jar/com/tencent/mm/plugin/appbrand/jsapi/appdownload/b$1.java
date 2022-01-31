package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import org.json.JSONObject;

final class b$1
  implements MMToClientEvent.c
{
  b$1(b paramb, r paramr) {}
  
  public final void aZ(Object paramObject)
  {
    AppMethodBeat.i(143270);
    if ((paramObject instanceof AppbrandDownloadState))
    {
      paramObject = (AppbrandDownloadState)paramObject;
      if (this.bAW != null) {
        this.hAT.i(this.bAW).BM(paramObject.aBI().toString()).aBz();
      }
    }
    AppMethodBeat.o(143270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b.1
 * JD-Core Version:    0.7.0.1
 */