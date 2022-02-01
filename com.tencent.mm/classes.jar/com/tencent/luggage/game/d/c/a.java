package com.tencent.luggage.game.d.c;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.j;
import java.util.Map;

public final class a
  extends j<c>
{
  private Map<String, Object> a(c paramc)
  {
    AppMethodBeat.i(130622);
    Map localMap = super.a(paramc);
    int i = com.tencent.luggage.game.g.a.b(paramc);
    if (i > 0) {
      localMap.put("statusBarHeight", Integer.valueOf(i));
    }
    AppMethodBeat.o(130622);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.c.a
 * JD-Core Version:    0.7.0.1
 */