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
  private String mpa;
  private String qTb;
  private Map<String, Integer> rnB;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121458);
    this.rnB = new HashMap();
    this.appId = paramString1;
    this.mpa = paramString2;
    this.qTb = (this.mpa + "-" + this.appId);
    AppMethodBeat.o(121458);
  }
  
  public final void Zn(String paramString)
  {
    AppMethodBeat.i(121459);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121459);
      return;
    }
    Integer localInteger2 = (Integer)this.rnB.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.rnB.put(paramString, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(121459);
  }
  
  public final void report()
  {
    AppMethodBeat.i(121460);
    Iterator localIterator = this.rnB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      h.OAn.b(14705, new Object[] { localEntry.getKey(), localEntry.getValue(), this.qTb, this.mpa, this.appId });
    }
    this.rnB.clear();
    AppMethodBeat.o(121460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.c
 * JD-Core Version:    0.7.0.1
 */