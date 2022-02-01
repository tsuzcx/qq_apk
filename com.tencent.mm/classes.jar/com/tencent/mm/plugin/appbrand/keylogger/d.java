package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final a lfV;
  
  static
  {
    AppMethodBeat.i(201024);
    lfV = new a();
    AppMethodBeat.o(201024);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(201019);
    Object localObject = lfV;
    String str = a.b(parama.bmN(), paramString, parama);
    ((a)localObject).lfW.put(str, Long.valueOf(System.currentTimeMillis()));
    localObject = b.a.bmH();
    ((b)localObject).a(parama.bmN(), new b.3((b)localObject, paramString, parama));
    AppMethodBeat.o(201019);
  }
  
  static void a(String paramString, a parama, long paramLong)
  {
    AppMethodBeat.i(201022);
    b.a.bmH().a(parama.bmN(), paramString, parama, paramLong);
    AppMethodBeat.o(201022);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.b paramb)
  {
    AppMethodBeat.i(201023);
    b localb = b.a.bmH();
    if (paramb != null)
    {
      List localList = (List)localb.kBk.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localb.kBk.put(paramString, localObject);
      }
      ((List)localObject).add(paramb);
    }
    AppMethodBeat.o(201023);
  }
  
  static void d(String paramString, a parama)
  {
    AppMethodBeat.i(201020);
    b localb = b.a.bmH();
    localb.a(parama.bmN(), new b.5(localb, paramString, parama, lfV.a(parama.bmN(), paramString, parama)));
    AppMethodBeat.o(201020);
  }
  
  static void dF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201017);
    b localb = b.a.bmH();
    localb.a(paramString1, new b.1(localb, paramString2));
    AppMethodBeat.o(201017);
  }
  
  static void dG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201018);
    b localb = b.a.bmH();
    localb.a(paramString1, new b.2(localb, paramString2));
    AppMethodBeat.o(201018);
  }
  
  static void e(String paramString, a parama)
  {
    AppMethodBeat.i(201021);
    b.a.bmH().a(parama.bmN(), paramString, parama, lfV.a(parama.bmN(), paramString, parama));
    AppMethodBeat.o(201021);
  }
  
  static final class a
  {
    final Map<String, Long> lfW;
    
    a()
    {
      AppMethodBeat.i(201014);
      this.lfW = new ConcurrentHashMap();
      AppMethodBeat.o(201014);
    }
    
    static String b(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(201016);
      paramString1 = String.format("%s#%s#%s", new Object[] { paramString1, paramString2, parama.name() });
      AppMethodBeat.o(201016);
      return paramString1;
    }
    
    final long a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(201015);
      paramString1 = b(paramString1, paramString2, parama);
      if (this.lfW.containsKey(paramString1))
      {
        paramString2 = (Long)this.lfW.get(paramString1);
        if (paramString2 == null)
        {
          AppMethodBeat.o(201015);
          return -1L;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramString2.longValue();
        this.lfW.remove(paramString1);
        AppMethodBeat.o(201015);
        return l1 - l2;
      }
      AppMethodBeat.o(201015);
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.d
 * JD-Core Version:    0.7.0.1
 */