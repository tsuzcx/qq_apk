package com.tencent.luggage.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class r
{
  private static ConcurrentHashMap<Integer, p> chW;
  
  static
  {
    AppMethodBeat.i(140441);
    chW = new ConcurrentHashMap();
    AppMethodBeat.o(140441);
  }
  
  public static p a(Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(140439);
    if ((paramInteger == null) || (!chW.containsKey(paramInteger)))
    {
      AppMethodBeat.o(140439);
      return null;
    }
    paramInteger = (p)chW.remove(paramInteger);
    paramInteger.setContext(paramContext);
    paramInteger.Co();
    ae.i(r.class.getSimpleName(), "retrieve, holding size: %d", new Object[] { Integer.valueOf(chW.size()) });
    AppMethodBeat.o(140439);
    return paramInteger;
  }
  
  public static Integer a(Context paramContext, p paramp)
  {
    AppMethodBeat.i(140438);
    paramp.setContext(paramContext);
    paramContext = paramp.chF.keySet().iterator();
    while (paramContext.hasNext())
    {
      o localo = paramp.getBridge();
      String str = (String)paramContext.next();
      localo.cgQ.remove(str);
    }
    paramp.chF.clear();
    paramp.chO = null;
    paramp.chG = null;
    paramp.chQ = true;
    chW.put(Integer.valueOf(paramp.hashCode()), paramp);
    ae.i(r.class.getSimpleName(), "stash, holding size: %d", new Object[] { Integer.valueOf(chW.size()) });
    int i = paramp.hashCode();
    AppMethodBeat.o(140438);
    return Integer.valueOf(i);
  }
  
  public static Integer b(Context paramContext, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(140437);
    paramContext = new p(paramContext, paramClass);
    if (!TextUtils.isEmpty(null)) {
      paramContext.loadUrl(null);
    }
    chW.put(Integer.valueOf(paramContext.hashCode()), paramContext);
    ae.i(r.class.getSimpleName(), "preload, url: %s, holding size: %d", new Object[] { null, Integer.valueOf(chW.size()) });
    int i = paramContext.hashCode();
    AppMethodBeat.o(140437);
    return Integer.valueOf(i);
  }
  
  public static p c(Integer paramInteger)
  {
    AppMethodBeat.i(140440);
    if ((paramInteger == null) || (!chW.containsKey(paramInteger)))
    {
      AppMethodBeat.o(140440);
      return null;
    }
    paramInteger = (p)chW.remove(paramInteger);
    paramInteger.Co();
    AppMethodBeat.o(140440);
    return paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.r
 * JD-Core Version:    0.7.0.1
 */