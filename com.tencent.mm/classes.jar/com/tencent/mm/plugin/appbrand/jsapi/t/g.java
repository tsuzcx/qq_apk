package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import java.util.HashMap;
import java.util.Map;

final class g
  extends ar
{
  static final int CTRL_INDEX = 473;
  static final String NAME = "onDeviceOrientationChange";
  
  final void b(aa.a parama)
  {
    AppMethodBeat.i(137639);
    parama = parama.name().replace("_", "");
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", parama);
    B(localHashMap).beN();
    AppMethodBeat.o(137639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.g
 * JD-Core Version:    0.7.0.1
 */