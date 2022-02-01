package com.tencent.mm.plugin.datareport.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.a.c.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.i;

public final class b
{
  public static Map<String, Object> a(String paramString, com.tencent.mm.plugin.datareport.d.a.b paramb)
  {
    AppMethodBeat.i(262861);
    if (paramb == null)
    {
      AppMethodBeat.o(262861);
      return null;
    }
    if ((paramb.xhe == null) || (paramb.xhe.size() <= 0))
    {
      AppMethodBeat.o(262861);
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramb.xhe.iterator();
    label195:
    label198:
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramb = (WeakReference)localIterator1.next();
        if (paramb == null) {
          break label195;
        }
        paramb = paramb.get();
        if ((paramb == null) || (!(paramb instanceof a))) {
          break label195;
        }
      }
      for (paramb = (a)paramb;; paramb = null)
      {
        if (paramb == null) {
          break label198;
        }
        paramb = paramb.getDynamicParams(paramString);
        Iterator localIterator2 = paramb.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!i.hm(str))
          {
            Object localObject = paramb.get(str);
            if (localObject != null) {
              localHashMap.put(str, localObject);
            }
          }
        }
        break;
        AppMethodBeat.o(262861);
        return localHashMap;
      }
    }
  }
  
  public static String c(com.tencent.mm.plugin.datareport.d.a.b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.viewId;
  }
  
  public static Map<String, Object> d(com.tencent.mm.plugin.datareport.d.a.b paramb)
  {
    if (paramb == null) {}
    while (paramb.xhi == null) {
      return null;
    }
    return paramb.xhi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.d.c.b
 * JD-Core Version:    0.7.0.1
 */