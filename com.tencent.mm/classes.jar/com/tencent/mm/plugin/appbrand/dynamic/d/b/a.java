package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static Map<String, Map<Integer, e>> fVL;
  
  public static e aJ(String paramString, int paramInt)
  {
    if (fVL == null)
    {
      localObject = new HashMap();
      fVL = (Map)localObject;
      ((Map)localObject).put(paramString, new HashMap());
    }
    Object localObject = (Map)fVL.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      fVL.put(paramString, localObject);
    }
    for (;;)
    {
      e locale = (e)((Map)localObject).get(Integer.valueOf(paramInt));
      paramString = locale;
      if (locale == null) {
        switch (paramInt)
        {
        default: 
          paramString = new c();
        }
      }
      for (;;)
      {
        ((Map)localObject).put(Integer.valueOf(paramInt), paramString);
        return paramString;
        paramString = new b();
        continue;
        paramString = new c();
        continue;
        paramString = new d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a
 * JD-Core Version:    0.7.0.1
 */