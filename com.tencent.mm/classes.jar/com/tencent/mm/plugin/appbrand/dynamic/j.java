package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.report.service.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j
{
  private static j fUb = new j();
  public Map<String, j.b> fTT = new ConcurrentHashMap();
  
  public static j aeZ()
  {
    return fUb;
  }
  
  public final void C(String paramString, int paramInt1, int paramInt2)
  {
    j.b localb = (j.b)this.fTT.get(paramString);
    if (localb != null)
    {
      b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.nFQ.f(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.bFu), Integer.valueOf(2), localb.bMX, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.dWx) });
    }
  }
  
  public final void aI(String paramString, int paramInt)
  {
    C(sZ(paramString), 626, paramInt);
  }
  
  public final String sZ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Iterator localIterator = this.fTT.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() != null) && (paramString.equals(((j.b)localEntry.getValue()).appId))) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public final void ta(String paramString)
  {
    C(paramString, 626, 26);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */