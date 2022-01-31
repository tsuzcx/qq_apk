package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;

final class d$b$1
  implements com.tencent.mm.plugin.appbrand.t.k.a
{
  d$b$1(d.b paramb, c paramc) {}
  
  public final boolean j(Object... paramVarArgs)
  {
    AppMethodBeat.i(126376);
    paramVarArgs = (float[])paramVarArgs[0];
    HashMap localHashMap = new HashMap();
    localHashMap.put("alpha", Float.valueOf(paramVarArgs[0]));
    localHashMap.put("beta", Float.valueOf(paramVarArgs[1]));
    localHashMap.put("gamma", Float.valueOf(paramVarArgs[2]));
    this.hYJ.hYI.x(localHashMap);
    boolean bool = k.a.hZf.a(this.hYJ.hYI, this.hxW);
    AppMethodBeat.o(126376);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.d.b.1
 * JD-Core Version:    0.7.0.1
 */