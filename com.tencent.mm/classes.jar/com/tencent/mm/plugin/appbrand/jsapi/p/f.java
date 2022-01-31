package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.bl.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import java.util.HashMap;
import java.util.Map;

final class f
  extends l
{
  static final int CTRL_INDEX = 473;
  static final String NAME = "onDeviceOrientationChange";
  
  final void a(a.a parama)
  {
    parama = parama.name().replace("_", "");
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", parama);
    o(localHashMap).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.f
 * JD-Core Version:    0.7.0.1
 */