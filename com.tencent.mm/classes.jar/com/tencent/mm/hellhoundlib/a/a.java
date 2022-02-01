package com.tencent.mm.hellhoundlib.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<String, d> gwq;
  
  static
  {
    AppMethodBeat.i(55540);
    gwq = new HashMap();
    AppMethodBeat.o(55540);
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(183792);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, null, null, paramString2, paramString3, paramString4, paramObject, null);
    AppMethodBeat.o(183792);
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(183794);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramObject, null);
    AppMethodBeat.o(183794);
  }
  
  public static void a(Object paramObject, Object[] paramArrayOfObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(177077);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramObject, paramArrayOfObject);
    AppMethodBeat.o(177077);
  }
  
  public static void a(String paramString1, String arg1, String paramString3, String paramString4, Object paramObject)
  {
    AppMethodBeat.i(206530);
    Object localObject = ??? + "|" + paramString3 + "|" + paramString4;
    synchronized (gwq)
    {
      localObject = (d)gwq.get(localObject);
      if ((localObject == null) || (((d)localObject).gwr == null) || (((d)localObject).gwr.isEmpty()))
      {
        AppMethodBeat.o(206530);
        return;
      }
      localObject = ((d)localObject).gwr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (localb != null) {
          localb.a(paramString1, paramString3, paramString4, paramObject);
        }
      }
    }
    AppMethodBeat.o(206530);
  }
  
  public static void a(String paramString1, String arg1, String paramString3, String paramString4, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(206528);
    Object localObject = ??? + "|" + paramString3 + "|" + paramString4;
    synchronized (gwq)
    {
      localObject = (d)gwq.get(localObject);
      if ((localObject == null) || (((d)localObject).listeners == null) || (((d)localObject).listeners.isEmpty()))
      {
        AppMethodBeat.o(206528);
        return;
      }
      localObject = ((d)localObject).listeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (localc != null) {
          localc.a(paramString1, paramString3, paramString4, paramObject1, paramObject2);
        }
      }
    }
    AppMethodBeat.o(206528);
  }
  
  public static void a(String paramString1, String arg1, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(183790);
    Object localObject = ??? + "|" + paramString3 + "|" + paramString4;
    synchronized (gwq)
    {
      localObject = (d)gwq.get(localObject);
      if ((localObject == null) || (((d)localObject).listeners == null) || (((d)localObject).listeners.isEmpty()))
      {
        AppMethodBeat.o(183790);
        return;
      }
      localObject = ((d)localObject).listeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (localc != null) {
          localc.a(paramString1, paramString3, paramString4, paramObject, paramArrayOfObject);
        }
      }
    }
    AppMethodBeat.o(183790);
  }
  
  public static void a(boolean paramBoolean, Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(206531);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, null, null, paramString2, paramString3, paramString4, paramObject, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206531);
  }
  
  public static boolean a(Object paramObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(206532);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramObject, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206532);
    return paramBoolean;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject)
  {
    AppMethodBeat.i(177075);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, null, null, paramString2, paramString3, paramString4, paramObject, null);
    AppMethodBeat.o(177075);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(177076);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramString1, null, null, paramString2, paramString3, paramString4, paramObject, paramArrayOfObject);
    AppMethodBeat.o(177076);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String arg3, String paramString5, String paramString6, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(206529);
    paramString6 = ??? + "|" + paramString5 + "|" + paramString6;
    synchronized (gwq)
    {
      paramString6 = (d)gwq.get(paramString6);
      if ((paramString6 == null) || (paramString6.gwr == null) || (paramString6.gwr.isEmpty()))
      {
        AppMethodBeat.o(206529);
        return;
      }
      paramString6 = paramString6.gwr.iterator();
      while (paramString6.hasNext())
      {
        b localb = (b)paramString6.next();
        if (localb != null) {
          localb.c(paramString1, paramString2, paramString3, paramString5, paramObject, paramArrayOfObject);
        }
      }
    }
    AppMethodBeat.o(206529);
  }
  
  public static void c(List<Pair<String, String>> paramList, b paramb)
  {
    AppMethodBeat.i(177072);
    if ((paramList == null) || (paramList.isEmpty()) || (paramb == null))
    {
      AppMethodBeat.o(177072);
      return;
    }
    for (;;)
    {
      String str;
      synchronized (gwq)
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (Pair)localIterator.next();
        str = "Undefined|" + (String)paramList.first + "|" + (String)paramList.second;
        if (gwq.containsKey(str))
        {
          d locald = (d)gwq.get(str);
          paramList = locald;
          if (locald == null) {
            paramList = new d();
          }
          if (paramList.gwr.contains(paramb)) {
            continue;
          }
          paramList.gwr.add(paramb);
          gwq.put(str, paramList);
        }
      }
      paramList = new d();
      paramList.gwr.add(paramb);
      gwq.put(str, paramList);
    }
    AppMethodBeat.o(177072);
  }
  
  public static void c(Map<String, List<Pair<String, String>>> paramMap, b paramb)
  {
    AppMethodBeat.i(183788);
    if ((paramMap == null) || (paramMap.isEmpty()) || (paramb == null))
    {
      AppMethodBeat.o(183788);
      return;
    }
    for (;;)
    {
      String str2;
      synchronized (gwq)
      {
        Iterator localIterator1 = paramMap.entrySet().iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator1.next();
        String str1 = (String)paramMap.getKey();
        paramMap = (List)paramMap.getValue();
        if (paramMap == null) {
          continue;
        }
        Iterator localIterator2 = paramMap.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        paramMap = (Pair)localIterator2.next();
        str2 = str1 + "_EXEC_|" + (String)paramMap.first + "|" + (String)paramMap.second;
        if (gwq.containsKey(str2))
        {
          d locald = (d)gwq.get(str2);
          paramMap = locald;
          if (locald == null) {
            paramMap = new d();
          }
          if (paramMap.gwr.contains(paramb)) {
            continue;
          }
          paramMap.gwr.add(paramb);
          gwq.put(str2, paramMap);
        }
      }
      paramMap = new d();
      paramMap.gwr.add(paramb);
      gwq.put(str2, paramMap);
    }
    AppMethodBeat.o(183788);
  }
  
  public static void d(List<Pair<String, String>> paramList, b paramb)
  {
    AppMethodBeat.i(183787);
    if ((paramList == null) || (paramList.isEmpty()) || (paramb == null))
    {
      AppMethodBeat.o(183787);
      return;
    }
    synchronized (gwq)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Pair)paramList.next();
        localObject = "Undefined|" + (String)((Pair)localObject).first + "|" + (String)((Pair)localObject).second;
        d locald = (d)gwq.get(localObject);
        if ((locald != null) && (locald.gwr != null) && (!locald.gwr.isEmpty()) && (locald.gwr.contains(paramb)))
        {
          locald.gwr.remove(paramb);
          if ((locald.gwr.isEmpty()) && (locald.listeners.isEmpty())) {
            gwq.remove(localObject);
          }
        }
      }
    }
    AppMethodBeat.o(183787);
  }
  
  public static void d(Map<String, List<Pair<String, String>>> paramMap, b paramb)
  {
    AppMethodBeat.i(183789);
    if ((paramMap == null) || (paramb == null))
    {
      AppMethodBeat.o(183789);
      return;
    }
    synchronized (gwq)
    {
      Object localObject2;
      d locald;
      do
      {
        do
        {
          paramMap = paramMap.entrySet().iterator();
          Object localObject1;
          String str;
          while (!((Iterator)localObject1).hasNext())
          {
            do
            {
              if (!paramMap.hasNext()) {
                break;
              }
              localObject1 = (Map.Entry)paramMap.next();
              str = (String)((Map.Entry)localObject1).getKey();
              localObject1 = (List)((Map.Entry)localObject1).getValue();
            } while (localObject1 == null);
            localObject1 = ((List)localObject1).iterator();
          }
          localObject2 = (Pair)((Iterator)localObject1).next();
          localObject2 = str + "_EXEC_|" + (String)((Pair)localObject2).first + "|" + (String)((Pair)localObject2).second;
          locald = (d)gwq.get(localObject2);
        } while ((locald == null) || (locald.gwr == null) || (locald.gwr.isEmpty()) || (!locald.gwr.contains(paramb)));
        locald.gwr.remove(paramb);
      } while ((!locald.gwr.isEmpty()) || (!locald.listeners.isEmpty()));
      gwq.remove(localObject2);
    }
    AppMethodBeat.o(183789);
  }
  
  public static void g(Map<String, List<Pair<String, String>>> paramMap, c paramc)
  {
    AppMethodBeat.i(55532);
    if ((paramMap == null) || (paramMap.isEmpty()) || (paramc == null))
    {
      AppMethodBeat.o(55532);
      return;
    }
    for (;;)
    {
      String str2;
      synchronized (gwq)
      {
        Iterator localIterator1 = paramMap.entrySet().iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator1.next();
        String str1 = (String)paramMap.getKey();
        paramMap = (List)paramMap.getValue();
        if (paramMap == null) {
          continue;
        }
        Iterator localIterator2 = paramMap.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        paramMap = (Pair)localIterator2.next();
        str2 = str1 + "|" + (String)paramMap.first + "|" + (String)paramMap.second;
        if (gwq.containsKey(str2))
        {
          d locald = (d)gwq.get(str2);
          paramMap = locald;
          if (locald == null) {
            paramMap = new d();
          }
          if (paramMap.listeners.contains(paramc)) {
            continue;
          }
          paramMap.listeners.add(paramc);
          gwq.put(str2, paramMap);
        }
      }
      paramMap = new d();
      paramMap.listeners.add(paramc);
      gwq.put(str2, paramMap);
    }
    AppMethodBeat.o(55532);
  }
  
  public static void h(Map<String, List<Pair<String, String>>> paramMap, c paramc)
  {
    AppMethodBeat.i(177068);
    if ((paramMap == null) || (paramc == null))
    {
      AppMethodBeat.o(177068);
      return;
    }
    synchronized (gwq)
    {
      Object localObject2;
      d locald;
      do
      {
        do
        {
          paramMap = paramMap.entrySet().iterator();
          Object localObject1;
          String str;
          while (!((Iterator)localObject1).hasNext())
          {
            do
            {
              if (!paramMap.hasNext()) {
                break;
              }
              localObject1 = (Map.Entry)paramMap.next();
              str = (String)((Map.Entry)localObject1).getKey();
              localObject1 = (List)((Map.Entry)localObject1).getValue();
            } while (localObject1 == null);
            localObject1 = ((List)localObject1).iterator();
          }
          localObject2 = (Pair)((Iterator)localObject1).next();
          localObject2 = str + "|" + (String)((Pair)localObject2).first + "|" + (String)((Pair)localObject2).second;
          locald = (d)gwq.get(localObject2);
        } while ((locald == null) || (locald.listeners == null) || (locald.listeners.isEmpty()) || (!locald.listeners.contains(paramc)));
        locald.listeners.remove(paramc);
      } while ((!locald.listeners.isEmpty()) || (!locald.gwr.isEmpty()));
      gwq.remove(localObject2);
    }
    AppMethodBeat.o(177068);
  }
  
  public static void i(Map<String, Pair<String, List<Pair<String, String>>>> paramMap, c paramc)
  {
    AppMethodBeat.i(168722);
    if ((paramMap == null) || (paramMap.isEmpty()) || (paramc == null))
    {
      AppMethodBeat.o(168722);
      return;
    }
    for (;;)
    {
      String str2;
      synchronized (gwq)
      {
        Iterator localIterator1 = paramMap.entrySet().iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator1.next();
        String str1 = (String)paramMap.getKey();
        Pair localPair = (Pair)paramMap.getValue();
        if (localPair == null) {
          continue;
        }
        Iterator localIterator2 = ((List)localPair.second).iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        paramMap = (Pair)localIterator2.next();
        str2 = str1 + (String)localPair.first + "|" + (String)paramMap.first + "|" + (String)paramMap.second;
        if (gwq.containsKey(str2))
        {
          d locald = (d)gwq.get(str2);
          paramMap = locald;
          if (locald == null) {
            paramMap = new d();
          }
          if (paramMap.listeners.contains(paramc)) {
            continue;
          }
          paramMap.listeners.add(paramc);
          gwq.put(str2, paramMap);
        }
      }
      paramMap = new d();
      paramMap.listeners.add(paramc);
      gwq.put(str2, paramMap);
    }
    AppMethodBeat.o(168722);
  }
  
  public static void j(Map<String, Pair<String, List<Pair<String, String>>>> paramMap, c paramc)
  {
    AppMethodBeat.i(177069);
    if (paramMap == null)
    {
      AppMethodBeat.o(177069);
      return;
    }
    synchronized (gwq)
    {
      Object localObject2;
      d locald;
      do
      {
        do
        {
          paramMap = paramMap.entrySet().iterator();
          Object localObject1;
          String str;
          Iterator localIterator;
          while (!localIterator.hasNext())
          {
            do
            {
              if (!paramMap.hasNext()) {
                break;
              }
              localObject1 = (Map.Entry)paramMap.next();
              str = (String)((Map.Entry)localObject1).getKey();
              localObject1 = (Pair)((Map.Entry)localObject1).getValue();
            } while (localObject1 == null);
            localIterator = ((List)((Pair)localObject1).second).iterator();
          }
          localObject2 = (Pair)localIterator.next();
          localObject2 = str + (String)((Pair)localObject1).first + "|" + (String)((Pair)localObject2).first + "|" + (String)((Pair)localObject2).second;
          locald = (d)gwq.get(localObject2);
        } while ((locald == null) || (locald.listeners == null) || (locald.listeners.isEmpty()) || (!locald.listeners.contains(paramc)));
        locald.listeners.remove(paramc);
      } while ((!locald.listeners.isEmpty()) || (!locald.gwr.isEmpty()));
      gwq.remove(localObject2);
    }
    AppMethodBeat.o(177069);
  }
  
  public static void k(Map<String, Map<String, List<Pair<String, String>>>> paramMap, c paramc)
  {
    AppMethodBeat.i(177070);
    if ((paramMap == null) || (paramMap.isEmpty()) || (paramc == null))
    {
      AppMethodBeat.o(177070);
      return;
    }
    for (;;)
    {
      String str3;
      synchronized (gwq)
      {
        Iterator localIterator1 = paramMap.entrySet().iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator1.next();
        String str1 = (String)paramMap.getKey();
        paramMap = (Map)paramMap.getValue();
        if (paramMap == null) {
          continue;
        }
        Iterator localIterator2 = paramMap.entrySet().iterator();
        continue;
        if (!localIterator2.hasNext()) {
          continue;
        }
        paramMap = (Map.Entry)localIterator2.next();
        String str2 = (String)paramMap.getKey();
        Iterator localIterator3 = ((List)paramMap.getValue()).iterator();
        if (!localIterator3.hasNext()) {
          continue;
        }
        paramMap = (Pair)localIterator3.next();
        str3 = str1 + str2 + "|" + (String)paramMap.first + "|" + (String)paramMap.second;
        if (gwq.containsKey(str3))
        {
          d locald = (d)gwq.get(str3);
          paramMap = locald;
          if (locald == null) {
            paramMap = new d();
          }
          if (paramMap.listeners.contains(paramc)) {
            continue;
          }
          paramMap.listeners.add(paramc);
          gwq.put(str3, paramMap);
        }
      }
      paramMap = new d();
      paramMap.listeners.add(paramc);
      gwq.put(str3, paramMap);
    }
    AppMethodBeat.o(177070);
  }
  
  public static void l(Map<String, Map<String, List<Pair<String, String>>>> paramMap, c paramc)
  {
    AppMethodBeat.i(177071);
    if (paramMap == null)
    {
      AppMethodBeat.o(177071);
      return;
    }
    synchronized (gwq)
    {
      paramMap = paramMap.entrySet().iterator();
      break label95;
      label33:
      String str1;
      do
      {
        if (!paramMap.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)paramMap.next();
        str1 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (Map)((Map.Entry)localObject1).getValue();
      } while (localObject1 == null);
      Object localObject1 = ((Map)localObject1).entrySet().iterator();
      label95:
      Object localObject3;
      label146:
      d locald;
      do
      {
        do
        {
          break label146;
          break label146;
          if (!((Iterator)localObject1).hasNext()) {
            break label33;
          }
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str2 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (Pair)((Iterator)localObject2).next();
          localObject3 = str1 + str2 + "|" + (String)((Pair)localObject3).first + "|" + (String)((Pair)localObject3).second;
          locald = (d)gwq.get(localObject3);
        } while ((locald == null) || (locald.listeners == null) || (locald.listeners.isEmpty()) || (!locald.listeners.contains(paramc)));
        locald.listeners.remove(paramc);
      } while ((!locald.listeners.isEmpty()) || (!locald.gwr.isEmpty()));
      gwq.remove(localObject3);
    }
    AppMethodBeat.o(177071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.a.a
 * JD-Core Version:    0.7.0.1
 */