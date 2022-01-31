package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;

final class b$b$1
  implements com.tencent.mm.plugin.appbrand.t.k.a
{
  b$b$1(b.b paramb, c paramc) {}
  
  public final boolean j(Object... paramVarArgs)
  {
    AppMethodBeat.i(126370);
    paramVarArgs = (float[])paramVarArgs[0];
    HashMap localHashMap = new HashMap();
    localHashMap.put("x", Float.valueOf(-paramVarArgs[0] / 10.0F));
    localHashMap.put("y", Float.valueOf(-paramVarArgs[1] / 10.0F));
    localHashMap.put("z", Float.valueOf(-paramVarArgs[2] / 10.0F));
    this.hYy.hYx.x(localHashMap);
    boolean bool = k.a.hZf.a(this.hYy.hYx, this.hxW);
    AppMethodBeat.o(126370);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.b.b.1
 * JD-Core Version:    0.7.0.1
 */