package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static final Map<String, List<l.a>> dGN = new ConcurrentHashMap();
  private static final Map<String, DebuggerInfo> fUZ = new ConcurrentHashMap();
  
  public static void D(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return;
      paramString = (List)dGN.get(paramString);
      if (paramString != null)
      {
        paramString = new LinkedList(paramString).iterator();
        while (paramString.hasNext()) {
          ((l.a)paramString.next()).ie(paramInt);
        }
      }
    }
  }
  
  public static void a(String paramString, DebuggerInfo paramDebuggerInfo)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    fUZ.put(paramString, paramDebuggerInfo);
  }
  
  public static boolean c(String paramString, l.a parama)
  {
    if ((bk.bl(paramString)) || (parama == null)) {
      return false;
    }
    Object localObject = (List)dGN.get(paramString);
    if (localObject == null)
    {
      localObject = new LinkedList();
      dGN.put(paramString, localObject);
      paramString = (String)localObject;
    }
    do
    {
      return paramString.add(parama);
      paramString = (String)localObject;
    } while (!((List)localObject).contains(parama));
    return true;
  }
  
  public static boolean d(String paramString, l.a parama)
  {
    if ((bk.bl(paramString)) || (parama == null)) {
      return false;
    }
    List localList = (List)dGN.get(paramString);
    if (localList == null) {
      return false;
    }
    boolean bool = localList.remove(parama);
    if (localList.isEmpty()) {
      dGN.remove(paramString);
    }
    return bool;
  }
  
  public static DebuggerInfo te(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    return (DebuggerInfo)fUZ.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.b
 * JD-Core Version:    0.7.0.1
 */