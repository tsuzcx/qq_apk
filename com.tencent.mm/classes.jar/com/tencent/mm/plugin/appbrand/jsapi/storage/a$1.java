package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class a$1
  implements Runnable
{
  a$1(a parama, h paramh, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(102022);
    ((b)e.q(b.class)).cc(this.hxk.getAppId()).I(this.iaq, this.hxk.getAppId());
    AppMethodBeat.o(102022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.a.1
 * JD-Core Version:    0.7.0.1
 */