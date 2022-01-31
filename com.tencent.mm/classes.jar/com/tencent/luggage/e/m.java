package com.tencent.luggage.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.j.c;
import com.tencent.luggage.webview.a;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class m
{
  private static ConcurrentHashMap<Integer, k> biS = new ConcurrentHashMap();
  
  public static k a(Context paramContext, Integer paramInteger)
  {
    if ((paramInteger == null) || (!biS.containsKey(paramInteger))) {
      return null;
    }
    paramInteger = (k)biS.remove(paramInteger);
    paramInteger.setContext(paramContext);
    paramInteger.aaj();
    c.i(m.class.getSimpleName(), "retrieve, holding size: %d", new Object[] { Integer.valueOf(biS.size()) });
    return paramInteger;
  }
  
  public static k a(Integer paramInteger)
  {
    if ((paramInteger == null) || (!biS.containsKey(paramInteger))) {
      return null;
    }
    paramInteger = (k)biS.remove(paramInteger);
    paramInteger.aaj();
    return paramInteger;
  }
  
  public static Integer a(Context paramContext, k paramk)
  {
    paramk.setContext(paramContext);
    paramContext = paramk.biM.keySet().iterator();
    while (paramContext.hasNext())
    {
      o localo = paramk.bhF;
      String str = (String)paramContext.next();
      localo.bhO.remove(str);
    }
    paramk.biM.clear();
    paramk.biG = null;
    paramk.biJ = null;
    paramk.biI = true;
    biS.put(Integer.valueOf(paramk.hashCode()), paramk);
    c.i(m.class.getSimpleName(), "stash, holding size: %d", new Object[] { Integer.valueOf(biS.size()) });
    return Integer.valueOf(paramk.hashCode());
  }
  
  public static Integer a(Context paramContext, Class<? extends a> paramClass)
  {
    paramContext = new k(paramContext, paramClass);
    if (!TextUtils.isEmpty(null)) {
      paramContext.loadUrl(null);
    }
    biS.put(Integer.valueOf(paramContext.hashCode()), paramContext);
    c.i(m.class.getSimpleName(), "preload, url: %s, holding size: %d", new Object[] { null, Integer.valueOf(biS.size()) });
    return Integer.valueOf(paramContext.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.e.m
 * JD-Core Version:    0.7.0.1
 */