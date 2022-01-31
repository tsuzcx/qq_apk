package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class d$1
  extends e.c
{
  d$1(d paramd, r paramr) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(141762);
    ab.i("MicroMsg.JsApiShowToast", "destory");
    e.b(this.bAW.getAppId(), this);
    if (this.hXF.hXE != null)
    {
      d.x(this.hXF.hXE);
      this.hXF.hXE = null;
    }
    if (this.hXF.gIs != null)
    {
      this.hXF.gIs.stopTimer();
      this.hXF.gIs = null;
    }
    AppMethodBeat.o(141762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.d.1
 * JD-Core Version:    0.7.0.1
 */