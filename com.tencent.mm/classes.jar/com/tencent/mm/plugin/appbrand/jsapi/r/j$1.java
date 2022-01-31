package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  extends e.c
{
  j$1(j paramj, c paramc) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(126420);
    ab.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
    if (j.a(this.iaU)) {
      j.b(this.iaU);
    }
    AppMethodBeat.o(126420);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126419);
    ab.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
    if (j.a(this.iaU)) {
      j.b(this.iaU);
    }
    e.b(this.hxW.getAppId(), this);
    AppMethodBeat.o(126419);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126421);
    ab.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
    if (j.access$200()) {
      j.c(this.iaU);
    }
    AppMethodBeat.o(126421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.j.1
 * JD-Core Version:    0.7.0.1
 */