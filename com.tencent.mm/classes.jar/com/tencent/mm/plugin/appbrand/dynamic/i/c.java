package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a
{
  private String appId;
  private String jSR;
  private String keN;
  private Map<String, Integer> kio;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121458);
    this.kio = new HashMap();
    this.appId = paramString1;
    this.keN = paramString2;
    this.jSR = (this.keN + "-" + this.appId);
    AppMethodBeat.o(121458);
  }
  
  public final void OK(String paramString)
  {
    AppMethodBeat.i(121459);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121459);
      return;
    }
    Integer localInteger2 = (Integer)this.kio.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.kio.put(paramString, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(121459);
  }
  
  public final void report()
  {
    AppMethodBeat.i(121460);
    Iterator localIterator = this.kio.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      g.yhR.f(14705, new Object[] { localEntry.getKey(), localEntry.getValue(), this.jSR, this.keN, this.appId });
    }
    this.kio.clear();
    AppMethodBeat.o(121460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.c
 * JD-Core Version:    0.7.0.1
 */