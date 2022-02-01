package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a lCT;
  
  static
  {
    AppMethodBeat.i(187696);
    lCT = new a();
    AppMethodBeat.o(187696);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(187691);
    Object localObject = lCT;
    String str = a.b(parama.bqy(), paramString, parama);
    ((a)localObject).lCU.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.bqs();
    ((b)localObject).a(parama.bqy(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(187691);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(187694);
    b.a.bqs().a(parama.bqy(), paramString, parama, paramLong);
    AppMethodBeat.o(187694);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(187695);
    b localb = b.a.bqs();
    if (paramb != null)
    {
      List localList = (List)localb.kXr.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.kXr.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(187695);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(187692);
    b localb = b.a.bqs();
    localb.a(parama.bqy(), new b.5(localb, paramString, parama, lCT.a(parama.bqy(), paramString, parama)));
    AppMethodBeat.o(187692);
  }
  
  static void dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187689);
    b localb = b.a.bqs();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(187689);
  }
  
  static void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187690);
    b localb = b.a.bqs();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(187690);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(187693);
    b.a.bqs().a(parama.bqy(), paramString, parama, lCT.a(parama.bqy(), paramString, parama));
    AppMethodBeat.o(187693);
  }
  
  static final class a
  {
    final Map<String, Long> lCU;
    
    a()
    {
      AppMethodBeat.i(187686);
      this.lCU = new ConcurrentHashMap();
      AppMethodBeat.o(187686);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(187688);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(187688);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(187687);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.lCU.containsKey(paramString1))
      {
        paramString2 = (Long)this.lCU.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(187687);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.lCU.remove(paramString1);
        AppMethodBeat.o(187687);
        return l1 - l2;
      }
      AppMethodBeat.o(187687);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */