package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$2$1
  implements ap.a
{
  d$2$1(d.2 param2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(141763);
    d.x(this.hXL.hXF.hXE);
    this.hXL.hXF.hXE = null;
    v.aae().oP(this.hXL.bAW.hashCode() + "toast_name");
    ab.d("MicroMsg.JsApiShowToast", "on timer expired!");
    AppMethodBeat.o(141763);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.d.2.1
 * JD-Core Version:    0.7.0.1
 */