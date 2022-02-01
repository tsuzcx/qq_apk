package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a lHs;
  
  static
  {
    AppMethodBeat.i(201263);
    lHs = new a();
    AppMethodBeat.o(201263);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(201258);
    Object localObject = lHs;
    String str = a.b(parama.bri(), paramString, parama);
    ((a)localObject).lHt.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.brc();
    ((b)localObject).a(parama.bri(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(201258);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(201261);
    b.a.brc().a(parama.bri(), paramString, parama, paramLong);
    AppMethodBeat.o(201261);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(201262);
    b localb = b.a.brc();
    if (paramb != null)
    {
      List localList = (List)localb.lba.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.lba.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(201262);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(201259);
    b localb = b.a.brc();
    localb.a(parama.bri(), new b.5(localb, paramString, parama, lHs.a(parama.bri(), paramString, parama)));
    AppMethodBeat.o(201259);
  }
  
  static void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201256);
    b localb = b.a.brc();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(201256);
  }
  
  static void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201257);
    b localb = b.a.brc();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(201257);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(201260);
    b.a.brc().a(parama.bri(), paramString, parama, lHs.a(parama.bri(), paramString, parama));
    AppMethodBeat.o(201260);
  }
  
  static final class a
  {
    final Map<String, Long> lHt;
    
    a()
    {
      AppMethodBeat.i(201253);
      this.lHt = new ConcurrentHashMap();
      AppMethodBeat.o(201253);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(201255);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(201255);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(201254);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.lHt.containsKey(paramString1))
      {
        paramString2 = (Long)this.lHt.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(201254);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.lHt.remove(paramString1);
        AppMethodBeat.o(201254);
        return l1 - l2;
      }
      AppMethodBeat.o(201254);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */