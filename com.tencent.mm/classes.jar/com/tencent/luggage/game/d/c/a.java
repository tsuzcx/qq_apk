package com.tencent.luggage.game.d.c;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.l;
import java.util.Map;

public final class a
  extends l<d>
{
  private Map<String, Object> a(d paramd)
  {
    AppMethodBeat.i(130622);
    Map localMap = super.a(paramd);
    int i = com.tencent.luggage.game.g.a.b(paramd);
    if (i > 0) {
      localMap.put("statusBarHeight", Integer.valueOf(i));
    }
    AppMethodBeat.o(130622);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.c.a
 * JD-Core Version:    0.7.0.1
 */