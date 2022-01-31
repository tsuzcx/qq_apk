package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class e$2
  implements b.c
{
  e$2(e parame, c paramc) {}
  
  public final void hw(long paramLong)
  {
    AppMethodBeat.i(143160);
    ab.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: relative ticks in ms: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = this.hty.htu;
    locala.i(this.htp);
    ab.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch stamp change: %d", new Object[] { Long.valueOf(paramLong) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("state", "timeUpdate");
    localHashMap.put("currentTime", Long.valueOf(paramLong));
    locala.w(localHashMap).aBz();
    AppMethodBeat.o(143160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.e.2
 * JD-Core Version:    0.7.0.1
 */