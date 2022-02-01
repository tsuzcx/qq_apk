package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a pQa;
  
  static
  {
    AppMethodBeat.i(207532);
    pQa = new a();
    AppMethodBeat.o(207532);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(207524);
    Object localObject = pQa;
    String str = a.b(parama.bZl(), paramString, parama);
    ((a)localObject).pQb.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.bZf();
    ((b)localObject).a(parama.bZl(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(207524);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(207529);
    b.a.bZf().a(parama.bZl(), paramString, parama, paramLong);
    AppMethodBeat.o(207529);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(207530);
    b localb = b.a.bZf();
    if (paramb != null)
    {
      List localList = (List)localb.pew.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.pew.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(207530);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(207526);
    b localb = b.a.bZf();
    localb.a(parama.bZl(), new b.5(localb, paramString, parama, pQa.a(parama.bZl(), paramString, parama)));
    AppMethodBeat.o(207526);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(207527);
    b.a.bZf().a(parama.bZl(), paramString, parama, pQa.a(parama.bZl(), paramString, parama));
    AppMethodBeat.o(207527);
  }
  
  static void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207519);
    b localb = b.a.bZf();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(207519);
  }
  
  static void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207521);
    b localb = b.a.bZf();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(207521);
  }
  
  static final class a
  {
    final Map<String, Long> pQb;
    
    a()
    {
      AppMethodBeat.i(208453);
      this.pQb = new ConcurrentHashMap();
      AppMethodBeat.o(208453);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(208459);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(208459);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(208457);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.pQb.containsKey(paramString1))
      {
        paramString2 = (Long)this.pQb.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(208457);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.pQb.remove(paramString1);
        AppMethodBeat.o(208457);
        return l1 - l2;
      }
      AppMethodBeat.o(208457);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */