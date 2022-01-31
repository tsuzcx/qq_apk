package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import org.json.JSONObject;

final class ag$1
  implements Runnable
{
  ag$1(ag paramag, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(102804);
    if (!this.hxW.isRunning())
    {
      AppMethodBeat.o(102804);
      return;
    }
    m.a locala = ag.d(this.hxW, this.bBa);
    this.hxW.h(this.bAX, this.hMh.j(locala.errMsg, locala.values));
    AppMethodBeat.o(102804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ag.1
 * JD-Core Version:    0.7.0.1
 */