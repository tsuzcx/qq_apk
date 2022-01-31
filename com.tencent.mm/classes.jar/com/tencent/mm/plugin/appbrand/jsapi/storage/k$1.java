package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class k$1
  implements Runnable
{
  k$1(k paramk, h paramh, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(102060);
    ((b)e.q(b.class)).cc(this.hDn.getAppId()).l(this.iaq, this.iaC.w(this.hDn), this.val$key);
    AppMethodBeat.o(102060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.k.1
 * JD-Core Version:    0.7.0.1
 */