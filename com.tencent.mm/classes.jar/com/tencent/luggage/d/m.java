package com.tencent.luggage.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.g.d;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class m
{
  private static ConcurrentHashMap<Integer, k> bzr;
  
  static
  {
    AppMethodBeat.i(90840);
    bzr = new ConcurrentHashMap();
    AppMethodBeat.o(90840);
  }
  
  public static k a(Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(90838);
    if ((paramInteger == null) || (!bzr.containsKey(paramInteger)))
    {
      AppMethodBeat.o(90838);
      return null;
    }
    paramInteger = (k)bzr.remove(paramInteger);
    paramInteger.setContext(paramContext);
    paramInteger.uu();
    d.i(m.class.getSimpleName(), "retrieve, holding size: %d", new Object[] { Integer.valueOf(bzr.size()) });
    AppMethodBeat.o(90838);
    return paramInteger;
  }
  
  public static k a(Integer paramInteger)
  {
    AppMethodBeat.i(90839);
    if ((paramInteger == null) || (!bzr.containsKey(paramInteger)))
    {
      AppMethodBeat.o(90839);
      return null;
    }
    paramInteger = (k)bzr.remove(paramInteger);
    paramInteger.uu();
    AppMethodBeat.o(90839);
    return paramInteger;
  }
  
  public static Integer a(Context paramContext, k paramk)
  {
    AppMethodBeat.i(90837);
    paramk.setContext(paramContext);
    paramContext = paramk.bzk.keySet().iterator();
    while (paramContext.hasNext())
    {
      o localo = paramk.byf;
      String str = (String)paramContext.next();
      localo.byo.remove(str);
    }
    paramk.bzk.clear();
    paramk.bze = null;
    paramk.bzh = null;
    paramk.bzg = true;
    bzr.put(Integer.valueOf(paramk.hashCode()), paramk);
    d.i(m.class.getSimpleName(), "stash, holding size: %d", new Object[] { Integer.valueOf(bzr.size()) });
    int i = paramk.hashCode();
    AppMethodBeat.o(90837);
    return Integer.valueOf(i);
  }
  
  public static Integer a(Context paramContext, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(90836);
    paramContext = new k(paramContext, paramClass);
    if (!TextUtils.isEmpty(null)) {
      paramContext.loadUrl(null);
    }
    bzr.put(Integer.valueOf(paramContext.hashCode()), paramContext);
    d.i(m.class.getSimpleName(), "preload, url: %s, holding size: %d", new Object[] { null, Integer.valueOf(bzr.size()) });
    int i = paramContext.hashCode();
    AppMethodBeat.o(90836);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.d.m
 * JD-Core Version:    0.7.0.1
 */