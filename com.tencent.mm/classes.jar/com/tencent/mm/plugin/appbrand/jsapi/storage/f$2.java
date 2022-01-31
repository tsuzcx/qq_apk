package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  implements Runnable
{
  f$2(f paramf, JsApiGetStorageTask paramJsApiGetStorageTask, h paramh, int paramInt, String paramString, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(102035);
    if (this.iau.value == null) {}
    for (String str = "fail:data not found";; str = "ok")
    {
      f.a(this.iat, str, this.iau.value, this.iau.type, this.hDn, this.bAX);
      f.a(1, r.bB(this.val$key, this.iau.value), this.fET, this.hDn);
      this.iau.aBk();
      ab.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[] { this.iau.key, Long.valueOf(System.currentTimeMillis() - this.dZo) });
      AppMethodBeat.o(102035);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f.2
 * JD-Core Version:    0.7.0.1
 */