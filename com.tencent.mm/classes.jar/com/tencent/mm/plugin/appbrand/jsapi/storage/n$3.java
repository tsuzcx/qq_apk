package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class n$3
  implements Runnable
{
  n$3(n paramn, n.a parama, JsApiSetStorageTask paramJsApiSetStorageTask, h paramh, int paramInt, String paramString1, String paramString2, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(102074);
    if (this.iaG != null) {
      this.iaG.a(this.iaH.result, this.hDn, this.bAX);
    }
    n.b(1, r.bB(this.val$key, this.bBG), this.fET, this.hDn);
    this.iaH.aBk();
    AppMethodBeat.o(102074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n.3
 * JD-Core Version:    0.7.0.1
 */