package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private static Map<String, g.a> fxP = new HashMap();
  private static Map<String, g.c> fxQ = new HashMap();
  private static Map<String, Set<g.b>> fxR = new ConcurrentHashMap();
  
  public static void a(String paramString, g.a parama)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    fxP.put(paramString, parama);
  }
  
  public static void a(String paramString, g.b paramb)
  {
    if ((paramString == null) || (paramb == null)) {
      return;
    }
    if (!fxR.containsKey(paramString)) {
      fxR.put(paramString, Collections.newSetFromMap(new ConcurrentHashMap()));
    }
    ((Set)fxR.get(paramString)).add(paramb);
  }
  
  public static void a(String paramString, g.c paramc)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    fxQ.put(paramString, paramc);
  }
  
  public static void b(String paramString, g.b paramb)
  {
    if (paramb == null) {}
    do
    {
      return;
      paramString = (Set)fxR.get(paramString);
    } while ((paramString == null) || (paramString.isEmpty()));
    paramString.remove(paramb);
  }
  
  public static void qA(String paramString)
  {
    a(paramString, g.c.fyb);
  }
  
  public static g.c qB(String paramString)
  {
    g.c localc = (g.c)fxQ.get(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = g.c.fyb;
    }
    return paramString;
  }
  
  public static g.a qC(String paramString)
  {
    g.a locala = (g.a)fxP.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = g.a.fxS;
    }
    return paramString;
  }
  
  private static Iterator<g.b> qt(String paramString)
  {
    Map localMap = fxR;
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    localObject = (Set)localMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new HashSet();
    }
    return paramString.iterator();
  }
  
  public static void qu(String paramString)
  {
    paramString = qt(paramString);
    while (paramString.hasNext()) {
      ((g.b)paramString.next()).onCreate();
    }
  }
  
  public static void qv(String paramString)
  {
    paramString = qt(paramString);
    while (paramString.hasNext()) {
      ((g.b)paramString.next()).onDestroy();
    }
  }
  
  public static void qw(String paramString)
  {
    Iterator localIterator = qt(paramString);
    while (localIterator.hasNext()) {
      ((g.b)localIterator.next()).a(qB(paramString));
    }
  }
  
  public static void qx(String paramString)
  {
    paramString = qt(paramString);
    while (paramString.hasNext()) {
      ((g.b)paramString.next()).onResume();
    }
  }
  
  public static void qy(String paramString)
  {
    paramString = qt(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
  }
  
  public static void qz(String paramString)
  {
    fxR.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */