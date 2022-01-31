package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class n$2
  implements Runnable
{
  n$2(n paramn, h paramh, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, n.a parama, int paramInt2, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(102073);
    String str = p.a(((b)e.q(b.class)).cc(this.hDn.getAppId()).b(this.iaq, this.val$appId, this.val$key, this.bBG, this.iaF));
    if (this.iaG != null) {
      this.iaG.a(str, this.hDn, this.bAX);
    }
    n.b(2, r.bB(this.val$key, this.bBG), this.fET, this.hDn);
    AppMethodBeat.o(102073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n.2
 * JD-Core Version:    0.7.0.1
 */