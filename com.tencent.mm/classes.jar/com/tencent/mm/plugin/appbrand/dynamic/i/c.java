package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a
{
  private String appId;
  private String heu;
  private String hng;
  private Map<String, Integer> hqI;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10977);
    this.hqI = new HashMap();
    this.appId = paramString1;
    this.hng = paramString2;
    this.heu = (this.hng + "-" + this.appId);
    AppMethodBeat.o(10977);
  }
  
  public final void Bo(String paramString)
  {
    AppMethodBeat.i(10978);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10978);
      return;
    }
    Integer localInteger2 = (Integer)this.hqI.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.hqI.put(paramString, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(10978);
  }
  
  public final void IE()
  {
    AppMethodBeat.i(10979);
    Iterator localIterator = this.hqI.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      h.qsU.e(14705, new Object[] { localEntry.getKey(), localEntry.getValue(), this.heu, this.hng, this.appId });
    }
    this.hqI.clear();
    AppMethodBeat.o(10979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.c
 * JD-Core Version:    0.7.0.1
 */