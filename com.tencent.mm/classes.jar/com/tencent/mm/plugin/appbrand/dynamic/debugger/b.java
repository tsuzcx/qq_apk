package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.n.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static final Map<String, List<n.a>> gej;
  private static final Map<String, DebuggerInfo> jLW;
  
  static
  {
    AppMethodBeat.i(121294);
    gej = new ConcurrentHashMap();
    jLW = new ConcurrentHashMap();
    AppMethodBeat.o(121294);
  }
  
  public static DebuggerInfo Li(String paramString)
  {
    AppMethodBeat.i(121289);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(121289);
      return null;
    }
    paramString = (DebuggerInfo)jLW.get(paramString);
    AppMethodBeat.o(121289);
    return paramString;
  }
  
  public static void M(String paramString, int paramInt)
  {
    AppMethodBeat.i(121293);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(121293);
      return;
    }
    paramString = (List)gej.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(121293);
      return;
    }
    paramString = new LinkedList(paramString).iterator();
    while (paramString.hasNext()) {
      ((n.a)paramString.next()).oo(paramInt);
    }
    AppMethodBeat.o(121293);
  }
  
  public static void a(String paramString, DebuggerInfo paramDebuggerInfo)
  {
    AppMethodBeat.i(121290);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(121290);
      return;
    }
    jLW.put(paramString, paramDebuggerInfo);
    AppMethodBeat.o(121290);
  }
  
  public static boolean c(String paramString, n.a parama)
  {
    AppMethodBeat.i(121291);
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(121291);
      return false;
    }
    Object localObject = (List)gej.get(paramString);
    if (localObject == null)
    {
      localObject = new LinkedList();
      gej.put(paramString, localObject);
      paramString = (String)localObject;
    }
    do
    {
      boolean bool = paramString.add(parama);
      AppMethodBeat.o(121291);
      return bool;
      paramString = (String)localObject;
    } while (!((List)localObject).contains(parama));
    AppMethodBeat.o(121291);
    return true;
  }
  
  public static boolean d(String paramString, n.a parama)
  {
    AppMethodBeat.i(121292);
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(121292);
      return false;
    }
    List localList = (List)gej.get(paramString);
    if (localList == null)
    {
      AppMethodBeat.o(121292);
      return false;
    }
    boolean bool = localList.remove(parama);
    if (localList.isEmpty()) {
      gej.remove(paramString);
    }
    AppMethodBeat.o(121292);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.b
 * JD-Core Version:    0.7.0.1
 */