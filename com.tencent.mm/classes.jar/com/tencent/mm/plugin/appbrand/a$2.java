package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class a$2
  extends LinkedHashMap
{
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    AppMethodBeat.i(154310);
    if (size() > a.gOH) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramEntry = (o)paramEntry.getValue();
        ab.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", new Object[] { paramEntry.toString() });
        al.d(new a.2.1(this, paramEntry));
      }
      AppMethodBeat.o(154310);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.2
 * JD-Core Version:    0.7.0.1
 */