package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class g$2
  implements Runnable
{
  g$2(g paramg, JsApiGetStorageInfoTask paramJsApiGetStorageInfoTask, h paramh, int paramInt, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(102041);
    g.a(this.iav, this.iaw.iax, this.iaw.size, this.iaw.limit, this.hDn, this.bAX);
    g.a(1, this.iaw.iax, this.iaw.size * 1000, this.fET, this.hDn);
    AppMethodBeat.o(102041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.g.2
 * JD-Core Version:    0.7.0.1
 */