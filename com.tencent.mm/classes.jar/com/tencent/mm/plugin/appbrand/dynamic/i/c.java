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
  private String hes;
  private String kZe;
  private Map<String, Integer> lpp;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121458);
    this.lpp = new HashMap();
    this.appId = paramString1;
    this.hes = paramString2;
    this.kZe = (this.hes + "-" + this.appId);
    AppMethodBeat.o(121458);
  }
  
  public final void YD(String paramString)
  {
    AppMethodBeat.i(121459);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121459);
      return;
    }
    Integer localInteger2 = (Integer)this.lpp.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.lpp.put(paramString, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(121459);
  }
  
  public final void report()
  {
    AppMethodBeat.i(121460);
    Iterator localIterator = this.lpp.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      h.CyF.a(14705, new Object[] { localEntry.getKey(), localEntry.getValue(), this.kZe, this.hes, this.appId });
    }
    this.lpp.clear();
    AppMethodBeat.o(121460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.c
 * JD-Core Version:    0.7.0.1
 */