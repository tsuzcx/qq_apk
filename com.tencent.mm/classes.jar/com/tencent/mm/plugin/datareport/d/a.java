package com.tencent.mm.plugin.datareport.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.i;

public final class a
{
  private static final com.tencent.mm.plugin.datareport.d.b.a.b xgZ;
  private static final com.tencent.mm.plugin.datareport.d.b.a.a xha;
  
  static
  {
    AppMethodBeat.i(263065);
    xgZ = new com.tencent.mm.plugin.datareport.d.b.a.b();
    xha = new com.tencent.mm.plugin.datareport.d.b.a.a();
    AppMethodBeat.o(263065);
  }
  
  public static List<com.tencent.mm.plugin.datareport.a.b.b> a(com.tencent.mm.plugin.datareport.d.a.a parama, int paramInt)
  {
    AppMethodBeat.i(263061);
    if (parama == null)
    {
      AppMethodBeat.o(263061);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parama.xhg.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((i & paramInt) != 0) {
        localArrayList.addAll((Collection)parama.xhg.get(Integer.valueOf(i)));
      }
    }
    AppMethodBeat.o(263061);
    return localArrayList;
  }
  
  public static List<com.tencent.mm.plugin.datareport.a.b.b> a(com.tencent.mm.plugin.datareport.d.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(263040);
    if (paramb == null)
    {
      AppMethodBeat.o(263040);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramb.xhg.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((i & paramInt) != 0) {
        localArrayList.addAll((Collection)paramb.xhg.get(Integer.valueOf(i)));
      }
    }
    AppMethodBeat.o(263040);
    return localArrayList;
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(263014);
    if (paramc == null)
    {
      AppMethodBeat.o(263014);
      return;
    }
    com.tencent.mm.plugin.datareport.d.b.a.a locala = xha;
    if ((paramc == null) || (!(paramc instanceof c)))
    {
      AppMethodBeat.o(263014);
      return;
    }
    paramc = (c)paramc;
    if (paramc.xho)
    {
      str = paramc.xhn;
      if ((!i.hm(str)) && (locala.xhl.containsKey(str)))
      {
        locala.xhl.remove(str);
        Log.i("PageDataEntityStorage", "[clear] page : " + paramc + ", mPageDataMap size : " + locala.xhk.size() + ", mFragDataMap size : " + locala.xhl.size());
      }
      AppMethodBeat.o(263014);
      return;
    }
    String str = paramc.xhn + "_" + paramc.hIa;
    if ((!i.hm(str)) && (locala.xhk.containsKey(str)))
    {
      locala.xhk.remove(str);
      Log.i("PageDataEntityStorage", "[clear] page : " + paramc + ", mPageDataMap size : " + locala.xhk.size() + ", mFragDataMap size : " + locala.xhl.size());
    }
    AppMethodBeat.o(263014);
  }
  
  public static void a(Object paramObject, com.tencent.mm.plugin.datareport.d.a.a parama)
  {
    AppMethodBeat.i(262980);
    paramObject = g(paramObject, true);
    if (paramObject != null) {
      paramObject.xhd = parama;
    }
    AppMethodBeat.o(262980);
  }
  
  public static void a(Object paramObject, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262870);
    paramObject = h(paramObject, true);
    if ((paramObject == null) || (paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(262870);
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!i.hm(str))
      {
        Object localObject = paramMap.get(str);
        if (localObject != null) {
          paramObject.xhi.put(str, localObject);
        }
      }
    }
    AppMethodBeat.o(262870);
  }
  
  public static void b(Object paramObject, com.tencent.mm.plugin.datareport.a.c.a parama)
  {
    AppMethodBeat.i(262882);
    paramObject = h(paramObject, true);
    if ((paramObject == null) || (parama == null))
    {
      AppMethodBeat.o(262882);
      return;
    }
    paramObject.xhe.add(new WeakReference(parama));
    AppMethodBeat.o(262882);
  }
  
  public static void c(Object paramObject, com.tencent.mm.plugin.datareport.a.c.a parama)
  {
    AppMethodBeat.i(262962);
    paramObject = g(paramObject, true);
    if ((paramObject == null) || (parama == null))
    {
      AppMethodBeat.o(262962);
      return;
    }
    paramObject.xhe.add(new WeakReference(parama));
    AppMethodBeat.o(262962);
  }
  
  public static void d(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(262946);
    paramObject1 = g(paramObject1, true);
    if ((paramObject1 == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(262946);
      return;
    }
    paramObject1.xhc.put(paramString, paramObject2);
    AppMethodBeat.o(262946);
  }
  
  public static void e(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(262862);
    paramObject1 = h(paramObject1, true);
    if ((paramObject1 == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(262862);
      return;
    }
    paramObject1.xhi.put(paramString, paramObject2);
    AppMethodBeat.o(262862);
  }
  
  public static int eC(Object paramObject)
  {
    AppMethodBeat.i(262914);
    int i = com.tencent.mm.plugin.datareport.d.c.a.a(g(paramObject, false));
    AppMethodBeat.o(262914);
    return i;
  }
  
  public static boolean eJ(Object paramObject)
  {
    AppMethodBeat.i(262845);
    if (paramObject == null)
    {
      AppMethodBeat.o(262845);
      return false;
    }
    if (!i.hm(eK(paramObject)))
    {
      AppMethodBeat.o(262845);
      return true;
    }
    AppMethodBeat.o(262845);
    return false;
  }
  
  public static String eK(Object paramObject)
  {
    AppMethodBeat.i(262855);
    paramObject = com.tencent.mm.plugin.datareport.d.c.b.c(h(paramObject, false));
    AppMethodBeat.o(262855);
    return paramObject;
  }
  
  public static void eL(Object paramObject)
  {
    AppMethodBeat.i(262874);
    paramObject = h(paramObject, false);
    if (paramObject != null) {
      paramObject.xhi.clear();
    }
    AppMethodBeat.o(262874);
  }
  
  public static boolean eM(Object paramObject)
  {
    AppMethodBeat.i(262902);
    if (paramObject == null)
    {
      AppMethodBeat.o(262902);
      return false;
    }
    if (eC(paramObject) > 0)
    {
      AppMethodBeat.o(262902);
      return true;
    }
    AppMethodBeat.o(262902);
    return false;
  }
  
  public static String eN(Object paramObject)
  {
    AppMethodBeat.i(262928);
    paramObject = g(paramObject, false);
    if (paramObject == null)
    {
      AppMethodBeat.o(262928);
      return null;
    }
    paramObject = paramObject.hJW;
    AppMethodBeat.o(262928);
    return paramObject;
  }
  
  public static void eO(Object paramObject)
  {
    AppMethodBeat.i(262955);
    paramObject = g(paramObject, false);
    if (paramObject != null) {
      paramObject.xhc.clear();
    }
    AppMethodBeat.o(262955);
  }
  
  public static com.tencent.mm.plugin.datareport.d.a.a eP(Object paramObject)
  {
    AppMethodBeat.i(262988);
    paramObject = g(paramObject, false);
    if (paramObject == null)
    {
      AppMethodBeat.o(262988);
      return null;
    }
    paramObject = paramObject.xhd;
    AppMethodBeat.o(262988);
    return paramObject;
  }
  
  public static int eQ(Object paramObject)
  {
    AppMethodBeat.i(263030);
    paramObject = h(paramObject, false);
    if (paramObject == null)
    {
      AppMethodBeat.o(263030);
      return 0;
    }
    paramObject = paramObject.xhg.keySet().iterator();
    for (int i = 0; paramObject.hasNext(); i = ((Integer)paramObject.next()).intValue() | i) {}
    AppMethodBeat.o(263030);
    return i;
  }
  
  public static int eR(Object paramObject)
  {
    AppMethodBeat.i(263045);
    paramObject = g(paramObject, false);
    if (paramObject == null)
    {
      AppMethodBeat.o(263045);
      return 0;
    }
    paramObject = paramObject.xhg.keySet().iterator();
    for (int i = 0; paramObject.hasNext(); i = ((Integer)paramObject.next()).intValue() | i) {}
    AppMethodBeat.o(263045);
    return i;
  }
  
  public static void eS(Object paramObject)
  {
    AppMethodBeat.i(263053);
    com.tencent.mm.plugin.datareport.d.a.a locala = g(paramObject, true);
    if (locala != null)
    {
      paramObject = new ArrayList();
      paramObject.add(Integer.valueOf(8));
      paramObject.add(Integer.valueOf(32));
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        Object localObject = (List)locala.xhg.get(Integer.valueOf(i));
        paramObject = localObject;
        if (localObject == null)
        {
          paramObject = new ArrayList();
          locala.xhg.put(Integer.valueOf(i), paramObject);
        }
        localObject = new com.tencent.mm.plugin.datareport.a.b.b();
        ((com.tencent.mm.plugin.datareport.a.b.b)localObject).xgH = 24184;
        ((com.tencent.mm.plugin.datareport.a.b.b)localObject).xgI = false;
        paramObject.add(localObject);
      }
    }
    AppMethodBeat.o(263053);
  }
  
  public static void f(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(262890);
    paramObject1 = h(paramObject1, false);
    if ((paramObject1 == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(262890);
      return;
    }
    paramObject1.xhf.put(paramString, paramObject2);
    AppMethodBeat.o(262890);
  }
  
  public static com.tencent.mm.plugin.datareport.d.a.a g(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(262995);
    if (paramObject == null)
    {
      AppMethodBeat.o(262995);
      return null;
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof c)) {
      localObject = new c(paramObject);
    }
    com.tencent.mm.plugin.datareport.d.a.a locala = xha.eT(localObject);
    paramObject = locala;
    if (locala == null)
    {
      paramObject = locala;
      if (paramBoolean)
      {
        paramObject = new com.tencent.mm.plugin.datareport.d.a.a();
        xha.b(localObject, paramObject);
      }
    }
    AppMethodBeat.o(262995);
    return paramObject;
  }
  
  public static void g(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263022);
    com.tencent.mm.plugin.datareport.d.a.b localb = h(paramObject, true);
    if (localb != null)
    {
      paramObject = new ArrayList();
      if ((paramInt1 & 0x1) != 0) {
        paramObject.add(Integer.valueOf(1));
      }
      if ((paramInt1 & 0x2) != 0) {
        paramObject.add(Integer.valueOf(2));
      }
      if ((paramInt1 & 0x4) != 0) {
        paramObject.add(Integer.valueOf(4));
      }
      if ((paramInt1 & 0x8) != 0) {
        paramObject.add(Integer.valueOf(8));
      }
      if ((paramInt1 & 0x10) != 0) {
        paramObject.add(Integer.valueOf(16));
      }
      if ((paramInt1 & 0x20) != 0) {
        paramObject.add(Integer.valueOf(32));
      }
      if ((paramInt1 & 0x40) != 0) {
        paramObject.add(Integer.valueOf(64));
      }
      if ((paramInt1 & 0x80) != 0) {
        paramObject.add(Integer.valueOf(128));
      }
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        paramInt1 = ((Integer)localIterator.next()).intValue();
        Object localObject = (List)localb.xhg.get(Integer.valueOf(paramInt1));
        paramObject = localObject;
        if (localObject == null)
        {
          paramObject = new ArrayList();
          localb.xhg.put(Integer.valueOf(paramInt1), paramObject);
        }
        localObject = new com.tencent.mm.plugin.datareport.a.b.b();
        ((com.tencent.mm.plugin.datareport.a.b.b)localObject).xgH = paramInt2;
        ((com.tencent.mm.plugin.datareport.a.b.b)localObject).xgI = false;
        paramObject.add(localObject);
      }
    }
    AppMethodBeat.o(263022);
  }
  
  public static void g(Object paramObject, String paramString)
  {
    AppMethodBeat.i(262920);
    paramObject = g(paramObject, true);
    if ((paramObject == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(262920);
      return;
    }
    paramObject.hJW = paramString;
    AppMethodBeat.o(262920);
  }
  
  public static com.tencent.mm.plugin.datareport.d.a.b h(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(263001);
    if (paramObject == null)
    {
      AppMethodBeat.o(263001);
      return null;
    }
    com.tencent.mm.plugin.datareport.d.a.b localb2 = com.tencent.mm.plugin.datareport.d.b.a.b.eU(paramObject);
    com.tencent.mm.plugin.datareport.d.a.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = localb2;
      if (paramBoolean)
      {
        localb1 = new com.tencent.mm.plugin.datareport.d.a.b();
        com.tencent.mm.plugin.datareport.d.b.a.b.a(paramObject, localb1);
      }
    }
    AppMethodBeat.o(263001);
    return localb1;
  }
  
  public static void h(Object paramObject, String paramString)
  {
    AppMethodBeat.i(262934);
    paramObject = g(paramObject, true);
    if ((paramObject == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(262934);
      return;
    }
    paramObject.xhb = paramString;
    AppMethodBeat.o(262934);
  }
  
  public static void i(Object paramObject, String paramString)
  {
    AppMethodBeat.i(262852);
    paramObject = h(paramObject, true);
    if (paramObject != null) {
      paramObject.viewId = paramString;
    }
    AppMethodBeat.o(262852);
  }
  
  public static int k(Object paramObject, String paramString)
  {
    AppMethodBeat.i(262895);
    paramObject = h(paramObject, false);
    if ((paramObject == null) || (i.hm(paramString))) {}
    for (paramObject = null; paramObject == null; paramObject = paramObject.xhf.get(paramString))
    {
      AppMethodBeat.o(262895);
      return 0;
    }
    int i = ((Integer)paramObject).intValue();
    AppMethodBeat.o(262895);
    return i;
  }
  
  public static Map<String, Object> l(Object paramObject, String paramString)
  {
    AppMethodBeat.i(262971);
    paramObject = g(paramObject, false);
    if (paramObject == null)
    {
      AppMethodBeat.o(262971);
      return null;
    }
    if ((paramObject.xhe == null) || (paramObject.xhe.size() <= 0))
    {
      AppMethodBeat.o(262971);
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramObject.xhe.iterator();
    label205:
    label208:
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramObject = (WeakReference)localIterator1.next();
        if (paramObject == null) {
          break label205;
        }
        paramObject = paramObject.get();
        if ((paramObject == null) || (!(paramObject instanceof com.tencent.mm.plugin.datareport.a.c.a))) {
          break label205;
        }
      }
      for (paramObject = (com.tencent.mm.plugin.datareport.a.c.a)paramObject;; paramObject = null)
      {
        if (paramObject == null) {
          break label208;
        }
        paramObject = paramObject.getDynamicParams(paramString);
        Iterator localIterator2 = paramObject.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!i.hm(str))
          {
            Object localObject = paramObject.get(str);
            if (localObject != null) {
              localHashMap.put(str, localObject);
            }
          }
        }
        break;
        AppMethodBeat.o(262971);
        return localHashMap;
      }
    }
  }
  
  public static void p(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(262909);
    paramObject = g(paramObject, true);
    if ((paramObject == null) || (paramInt <= 0))
    {
      AppMethodBeat.o(262909);
      return;
    }
    paramObject.tBy = paramInt;
    AppMethodBeat.o(262909);
  }
  
  public static void q(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(262938);
    paramObject = g(paramObject, true);
    if (paramObject != null) {
      paramObject.xhh = paramInt;
    }
    AppMethodBeat.o(262938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.d.a
 * JD-Core Version:    0.7.0.1
 */