package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a sUA;
  
  static
  {
    AppMethodBeat.i(319515);
    sUA = new a();
    AppMethodBeat.o(319515);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(319486);
    Object localObject = sUA;
    String str = a.b(parama.czx(), paramString, parama);
    ((a)localObject).sUB.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.czr();
    ((b)localObject).a(parama.czx(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(319486);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(319505);
    b.a.czr().a(parama.czx(), paramString, parama, paramLong);
    AppMethodBeat.o(319505);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(319512);
    b localb = b.a.czr();
    if (paramb != null)
    {
      List localList = (List)localb.sjN.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.sjN.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(319512);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(319494);
    b localb = b.a.czr();
    localb.a(parama.czx(), new b.5(localb, paramString, parama, sUA.a(parama.czx(), paramString, parama)));
    AppMethodBeat.o(319494);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(319500);
    b.a.czr().a(parama.czx(), paramString, parama, sUA.a(parama.czx(), paramString, parama));
    AppMethodBeat.o(319500);
  }
  
  static void eE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(319469);
    b localb = b.a.czr();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(319469);
  }
  
  static void eF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(319476);
    b localb = b.a.czr();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(319476);
  }
  
  static final class a
  {
    final Map<String, Long> sUB;
    
    a()
    {
      AppMethodBeat.i(319466);
      this.sUB = new ConcurrentHashMap();
      AppMethodBeat.o(319466);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(319475);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(319475);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(319484);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.sUB.containsKey(paramString1))
      {
        paramString2 = (Long)this.sUB.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(319484);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.sUB.remove(paramString1);
        AppMethodBeat.o(319484);
        return l1 - l2;
      }
      AppMethodBeat.o(319484);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */