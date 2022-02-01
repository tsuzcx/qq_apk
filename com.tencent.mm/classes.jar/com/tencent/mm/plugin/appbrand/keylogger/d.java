package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a kEC;
  
  static
  {
    AppMethodBeat.i(194869);
    kEC = new a();
    AppMethodBeat.o(194869);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(194864);
    Object localObject = kEC;
    String str = a.b(parama.bfT(), paramString, parama);
    ((a)localObject).kED.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.bfN();
    ((b)localObject).a(parama.bfT(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(194864);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(194867);
    b.a.bfN().a(parama.bfT(), paramString, parama, paramLong);
    AppMethodBeat.o(194867);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(194868);
    b localb = b.a.bfN();
    if (paramb != null)
    {
      List localList = (List)localb.kax.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.kax.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(194868);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(194865);
    b localb = b.a.bfN();
    localb.a(parama.bfT(), new b.5(localb, paramString, parama, kEC.a(parama.bfT(), paramString, parama)));
    AppMethodBeat.o(194865);
  }
  
  static void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194862);
    b localb = b.a.bfN();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(194862);
  }
  
  static void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194863);
    b localb = b.a.bfN();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(194863);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(194866);
    b.a.bfN().a(parama.bfT(), paramString, parama, kEC.a(parama.bfT(), paramString, parama));
    AppMethodBeat.o(194866);
  }
  
  static final class a
  {
    final Map<String, Long> kED;
    
    a()
    {
      AppMethodBeat.i(194859);
      this.kED = new ConcurrentHashMap();
      AppMethodBeat.o(194859);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(194861);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(194861);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(194860);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.kED.containsKey(paramString1))
      {
        paramString2 = (Long)this.kED.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(194860);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.kED.remove(paramString1);
        AppMethodBeat.o(194860);
        return l1 - l2;
      }
      AppMethodBeat.o(194860);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */