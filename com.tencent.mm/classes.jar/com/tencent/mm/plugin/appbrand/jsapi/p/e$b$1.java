package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.v.g.a;
import java.util.HashMap;
import java.util.Map;

final class e$b$1
  implements g.a
{
  e$b$1(e.b paramb, f paramf) {}
  
  public final boolean i(Object... paramVarArgs)
  {
    paramVarArgs = (float[])paramVarArgs[0];
    HashMap localHashMap = new HashMap();
    localHashMap.put("x", Float.valueOf(paramVarArgs[0]));
    localHashMap.put("y", Float.valueOf(paramVarArgs[1]));
    localHashMap.put("z", Float.valueOf(paramVarArgs[2]));
    this.gAZ.gAY.o(localHashMap);
    return h.ajW().a(this.gAZ.gAY, this.gfy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.e.b.1
 * JD-Core Version:    0.7.0.1
 */