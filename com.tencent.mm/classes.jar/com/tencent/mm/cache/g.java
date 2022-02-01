package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public abstract interface g
{
  public abstract void c(Object paramObject1, Object paramObject2);
  
  public abstract Object get(Object paramObject);
  
  public abstract Object remove(Object paramObject);
  
  public static final class a
  {
    private static Map<String, g> fqg;
    
    static
    {
      AppMethodBeat.i(131947);
      fqg = new HashMap();
      AppMethodBeat.o(131947);
    }
    
    public static <T> T T(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131942);
      paramString1 = a(rT(paramString1), paramString2);
      AppMethodBeat.o(131942);
      return paramString1;
    }
    
    public static <T> void U(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131944);
      b(rT(paramString1), paramString2);
      AppMethodBeat.o(131944);
    }
    
    private static <T> T a(g paramg, String paramString)
    {
      AppMethodBeat.i(131945);
      if (paramg == null)
      {
        ac.e("MicroMsg.ICacheService.Factory", "null service");
        AppMethodBeat.o(131945);
        return null;
      }
      try
      {
        paramg = paramg.get(paramString);
        AppMethodBeat.o(131945);
        return paramg;
      }
      catch (Exception paramg)
      {
        ac.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        ac.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bs.m(paramg) });
        AppMethodBeat.o(131945);
      }
      return null;
    }
    
    public static void a(String paramString, g paramg)
    {
      AppMethodBeat.i(131940);
      fqg.put(paramString, paramg);
      AppMethodBeat.o(131940);
    }
    
    public static <T> void a(String paramString1, String paramString2, T paramT)
    {
      AppMethodBeat.i(131943);
      paramString1 = rT(paramString1);
      if (paramString1 == null)
      {
        ac.e("MicroMsg.ICacheService.Factory", "null service");
        AppMethodBeat.o(131943);
        return;
      }
      paramString1.c(paramString2, paramT);
      AppMethodBeat.o(131943);
    }
    
    private static <T> T b(g paramg, String paramString)
    {
      AppMethodBeat.i(131946);
      if (paramg == null)
      {
        ac.e("MicroMsg.ICacheService.Factory", "null service");
        AppMethodBeat.o(131946);
        return null;
      }
      try
      {
        paramg = paramg.remove(paramString);
        AppMethodBeat.o(131946);
        return paramg;
      }
      catch (Exception paramg)
      {
        ac.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        ac.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bs.m(paramg) });
        AppMethodBeat.o(131946);
      }
      return null;
    }
    
    private static g rT(String paramString)
    {
      AppMethodBeat.i(131941);
      paramString = (g)fqg.get(paramString);
      AppMethodBeat.o(131941);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cache.g
 * JD-Core Version:    0.7.0.1
 */