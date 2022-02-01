package com.tencent.luggage.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class m
{
  private static ConcurrentHashMap<Integer, k> caH;
  
  static
  {
    AppMethodBeat.i(140441);
    caH = new ConcurrentHashMap();
    AppMethodBeat.o(140441);
  }
  
  public static k a(Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(140439);
    if ((paramInteger == null) || (!caH.containsKey(paramInteger)))
    {
      AppMethodBeat.o(140439);
      return null;
    }
    paramInteger = (k)caH.remove(paramInteger);
    paramInteger.setContext(paramContext);
    paramInteger.Bi();
    ad.i(m.class.getSimpleName(), "retrieve, holding size: %d", new Object[] { Integer.valueOf(caH.size()) });
    AppMethodBeat.o(140439);
    return paramInteger;
  }
  
  public static Integer a(Context paramContext, k paramk)
  {
    AppMethodBeat.i(140438);
    paramk.setContext(paramContext);
    paramContext = paramk.caB.keySet().iterator();
    while (paramContext.hasNext())
    {
      o localo = paramk.bZw;
      String str = (String)paramContext.next();
      localo.bZE.remove(str);
    }
    paramk.caB.clear();
    paramk.cau = null;
    paramk.cax = null;
    paramk.caw = true;
    caH.put(Integer.valueOf(paramk.hashCode()), paramk);
    ad.i(m.class.getSimpleName(), "stash, holding size: %d", new Object[] { Integer.valueOf(caH.size()) });
    int i = paramk.hashCode();
    AppMethodBeat.o(140438);
    return Integer.valueOf(i);
  }
  
  public static k b(Integer paramInteger)
  {
    AppMethodBeat.i(140440);
    if ((paramInteger == null) || (!caH.containsKey(paramInteger)))
    {
      AppMethodBeat.o(140440);
      return null;
    }
    paramInteger = (k)caH.remove(paramInteger);
    paramInteger.Bi();
    AppMethodBeat.o(140440);
    return paramInteger;
  }
  
  public static Integer b(Context paramContext, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(140437);
    paramContext = new k(paramContext, paramClass);
    if (!TextUtils.isEmpty(null)) {
      paramContext.loadUrl(null);
    }
    caH.put(Integer.valueOf(paramContext.hashCode()), paramContext);
    ad.i(m.class.getSimpleName(), "preload, url: %s, holding size: %d", new Object[] { null, Integer.valueOf(caH.size()) });
    int i = paramContext.hashCode();
    AppMethodBeat.o(140437);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.m
 * JD-Core Version:    0.7.0.1
 */