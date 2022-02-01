package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import java.util.HashMap;
import java.util.Map;

final class g
  extends bc
{
  static final int CTRL_INDEX = 473;
  static final String NAME = "onDeviceOrientationChange";
  
  final void b(ak.a parama)
  {
    AppMethodBeat.i(137639);
    parama = parama.name().replace("_", "");
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", parama);
    try
    {
      L(localHashMap).cpV();
      AppMethodBeat.o(137639);
      return;
    }
    catch (NullPointerException parama)
    {
      AppMethodBeat.o(137639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.g
 * JD-Core Version:    0.7.0.1
 */