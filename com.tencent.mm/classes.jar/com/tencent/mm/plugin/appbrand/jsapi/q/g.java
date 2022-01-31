package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.t.t.a;
import java.util.HashMap;
import java.util.Map;

final class g
  extends ai
{
  static final int CTRL_INDEX = 473;
  static final String NAME = "onDeviceOrientationChange";
  
  final void a(t.a parama)
  {
    AppMethodBeat.i(126385);
    parama = parama.name().replace("_", "");
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", parama);
    x(localHashMap).aBz();
    AppMethodBeat.o(126385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.g
 * JD-Core Version:    0.7.0.1
 */