package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static final Map<String, List<l.a>> eEq;
  private static final Map<String, DebuggerInfo> hoB;
  
  static
  {
    AppMethodBeat.i(10812);
    eEq = new ConcurrentHashMap();
    hoB = new ConcurrentHashMap();
    AppMethodBeat.o(10812);
  }
  
  public static DebuggerInfo Bg(String paramString)
  {
    AppMethodBeat.i(10807);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(10807);
      return null;
    }
    paramString = (DebuggerInfo)hoB.get(paramString);
    AppMethodBeat.o(10807);
    return paramString;
  }
  
  public static void I(String paramString, int paramInt)
  {
    AppMethodBeat.i(10811);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(10811);
      return;
    }
    paramString = (List)eEq.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(10811);
      return;
    }
    paramString = new LinkedList(paramString).iterator();
    while (paramString.hasNext()) {
      ((l.a)paramString.next()).kR(paramInt);
    }
    AppMethodBeat.o(10811);
  }
  
  public static void a(String paramString, DebuggerInfo paramDebuggerInfo)
  {
    AppMethodBeat.i(10808);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(10808);
      return;
    }
    hoB.put(paramString, paramDebuggerInfo);
    AppMethodBeat.o(10808);
  }
  
  public static boolean c(String paramString, l.a parama)
  {
    AppMethodBeat.i(10809);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(10809);
      return false;
    }
    Object localObject = (List)eEq.get(paramString);
    if (localObject == null)
    {
      localObject = new LinkedList();
      eEq.put(paramString, localObject);
      paramString = (String)localObject;
    }
    do
    {
      boolean bool = paramString.add(parama);
      AppMethodBeat.o(10809);
      return bool;
      paramString = (String)localObject;
    } while (!((List)localObject).contains(parama));
    AppMethodBeat.o(10809);
    return true;
  }
  
  public static boolean d(String paramString, l.a parama)
  {
    AppMethodBeat.i(10810);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(10810);
      return false;
    }
    List localList = (List)eEq.get(paramString);
    if (localList == null)
    {
      AppMethodBeat.o(10810);
      return false;
    }
    boolean bool = localList.remove(parama);
    if (localList.isEmpty()) {
      eEq.remove(paramString);
    }
    AppMethodBeat.o(10810);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.b
 * JD-Core Version:    0.7.0.1
 */