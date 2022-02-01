package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import java.util.HashMap;
import java.util.Map;

final class g
  extends bc
{
  static final int CTRL_INDEX = 473;
  static final String NAME = "onDeviceOrientationChange";
  
  final void b(ad.a parama)
  {
    AppMethodBeat.i(137639);
    parama = parama.name().replace("_", "");
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", parama);
    L(localHashMap).bEo();
    AppMethodBeat.o(137639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.g
 * JD-Core Version:    0.7.0.1
 */