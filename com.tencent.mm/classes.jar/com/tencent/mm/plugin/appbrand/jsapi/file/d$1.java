package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(102758);
    if (!this.hza.isRunning())
    {
      AppMethodBeat.o(102758);
      return;
    }
    h.a locala = d.a(this.hLR).c(this.hza, this.bBa);
    this.hza.h(this.bAX, this.hLR.a(this.hza, locala.errMsg, locala.values));
    AppMethodBeat.o(102758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.d.1
 * JD-Core Version:    0.7.0.1
 */