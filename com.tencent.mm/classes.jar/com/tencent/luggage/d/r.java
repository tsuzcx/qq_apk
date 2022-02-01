package com.tencent.luggage.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class r
{
  private static ConcurrentHashMap<Integer, p> ejQ;
  
  static
  {
    AppMethodBeat.i(140441);
    ejQ = new ConcurrentHashMap();
    AppMethodBeat.o(140441);
  }
  
  public static p a(Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(140439);
    if ((paramInteger == null) || (!ejQ.containsKey(paramInteger)))
    {
      AppMethodBeat.o(140439);
      return null;
    }
    paramInteger = (p)ejQ.remove(paramInteger);
    paramInteger.setContext(paramContext);
    paramInteger.aoD();
    Log.i(r.class.getSimpleName(), "retrieve, holding size: %d", new Object[] { Integer.valueOf(ejQ.size()) });
    AppMethodBeat.o(140439);
    return paramInteger;
  }
  
  public static Integer a(Context paramContext, p paramp)
  {
    AppMethodBeat.i(140438);
    paramp.setContext(paramContext);
    paramContext = paramp.ejx.keySet().iterator();
    while (paramContext.hasNext())
    {
      o localo = paramp.getBridge();
      String str = (String)paramContext.next();
      localo.eiJ.remove(str);
    }
    paramp.ejx.clear();
    paramp.ejI = null;
    paramp.ejy = null;
    paramp.ejK = true;
    ejQ.put(Integer.valueOf(paramp.hashCode()), paramp);
    Log.i(r.class.getSimpleName(), "stash, holding size: %d", new Object[] { Integer.valueOf(ejQ.size()) });
    int i = paramp.hashCode();
    AppMethodBeat.o(140438);
    return Integer.valueOf(i);
  }
  
  public static Integer c(Context paramContext, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(140437);
    paramContext = new p(paramContext, paramClass);
    if (!TextUtils.isEmpty(null)) {
      paramContext.loadUrl(null);
    }
    ejQ.put(Integer.valueOf(paramContext.hashCode()), paramContext);
    Log.i(r.class.getSimpleName(), "preload, url: %s, holding size: %d", new Object[] { null, Integer.valueOf(ejQ.size()) });
    int i = paramContext.hashCode();
    AppMethodBeat.o(140437);
    return Integer.valueOf(i);
  }
  
  public static p d(Integer paramInteger)
  {
    AppMethodBeat.i(140440);
    if ((paramInteger == null) || (!ejQ.containsKey(paramInteger)))
    {
      AppMethodBeat.o(140440);
      return null;
    }
    paramInteger = (p)ejQ.remove(paramInteger);
    paramInteger.aoD();
    AppMethodBeat.o(140440);
    return paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.r
 * JD-Core Version:    0.7.0.1
 */