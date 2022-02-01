package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a mPh;
  
  static
  {
    AppMethodBeat.i(221307);
    mPh = new a();
    AppMethodBeat.o(221307);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(221302);
    Object localObject = mPh;
    String str = a.b(parama.bMU(), paramString, parama);
    ((a)localObject).mPi.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.bMO();
    ((b)localObject).a(parama.bMU(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(221302);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(221305);
    b.a.bMO().a(parama.bMU(), paramString, parama, paramLong);
    AppMethodBeat.o(221305);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(221306);
    b localb = b.a.bMO();
    if (paramb != null)
    {
      List localList = (List)localb.mgp.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.mgp.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(221306);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(221303);
    b localb = b.a.bMO();
    localb.a(parama.bMU(), new b.5(localb, paramString, parama, mPh.a(parama.bMU(), paramString, parama)));
    AppMethodBeat.o(221303);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(221304);
    b.a.bMO().a(parama.bMU(), paramString, parama, mPh.a(parama.bMU(), paramString, parama));
    AppMethodBeat.o(221304);
  }
  
  static void ea(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221300);
    b localb = b.a.bMO();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(221300);
  }
  
  static void eb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221301);
    b localb = b.a.bMO();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(221301);
  }
  
  static final class a
  {
    final Map<String, Long> mPi;
    
    a()
    {
      AppMethodBeat.i(221297);
      this.mPi = new ConcurrentHashMap();
      AppMethodBeat.o(221297);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(221299);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(221299);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(221298);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.mPi.containsKey(paramString1))
      {
        paramString2 = (Long)this.mPi.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(221298);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.mPi.remove(paramString1);
        AppMethodBeat.o(221298);
        return l1 - l2;
      }
      AppMethodBeat.o(221298);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */