package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
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
  private String fLi;
  private String fTF;
  private Map<String, Integer> fXi = new HashMap();
  
  public c(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.fTF = paramString2;
    this.fLi = (this.fTF + "-" + this.appId);
  }
  
  public final void tk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Integer localInteger2 = (Integer)this.fXi.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.fXi.put(paramString, Integer.valueOf(localInteger1.intValue() + 1));
  }
  
  public final void wn()
  {
    Iterator localIterator = this.fXi.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      h.nFQ.f(14705, new Object[] { localEntry.getKey(), localEntry.getValue(), this.fLi, this.fTF, this.appId });
    }
    this.fXi.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.c
 * JD-Core Version:    0.7.0.1
 */