package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.u.a.d;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends d
{
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(147394);
    parami = (String)j.akW(parami.optString("url")).get("host");
    HashMap localHashMap = new HashMap();
    if (j.akY(parami) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isLANIp", Boolean.valueOf(bool));
      parami = paramc.R(localHashMap);
      AppMethodBeat.o(147394);
      return parami;
    }
  }
  
  public final int ccB()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.f
 * JD-Core Version:    0.7.0.1
 */