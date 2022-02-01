package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public abstract interface g
{
  public abstract void e(Object paramObject1, Object paramObject2);
  
  public abstract Object get(Object paramObject);
  
  public abstract Object remove(Object paramObject);
  
  public static final class a
  {
    private static Map<String, g> fIn;
    
    static
    {
      AppMethodBeat.i(131947);
      fIn = new HashMap();
      AppMethodBeat.o(131947);
    }
    
    public static <T> T U(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131942);
      paramString1 = a(uG(paramString1), paramString2);
      AppMethodBeat.o(131942);
      return paramString1;
    }
    
    public static <T> void V(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131944);
      b(uG(paramString1), paramString2);
      AppMethodBeat.o(131944);
    }
    
    private static <T> T a(g paramg, String paramString)
    {
      AppMethodBeat.i(131945);
      if (paramg == null)
      {
        ad.e("MicroMsg.ICacheService.Factory", "null service");
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
        ad.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        ad.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bt.n(paramg) });
        AppMethodBeat.o(131945);
      }
      return null;
    }
    
    public static void a(String paramString, g paramg)
    {
      AppMethodBeat.i(131940);
      fIn.put(paramString, paramg);
      AppMethodBeat.o(131940);
    }
    
    public static <T> void a(String paramString1, String paramString2, T paramT)
    {
      AppMethodBeat.i(131943);
      paramString1 = uG(paramString1);
      if (paramString1 == null)
      {
        ad.e("MicroMsg.ICacheService.Factory", "null service");
        AppMethodBeat.o(131943);
        return;
      }
      paramString1.e(paramString2, paramT);
      AppMethodBeat.o(131943);
    }
    
    private static <T> T b(g paramg, String paramString)
    {
      AppMethodBeat.i(131946);
      if (paramg == null)
      {
        ad.e("MicroMsg.ICacheService.Factory", "null service");
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
        ad.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        ad.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bt.n(paramg) });
        AppMethodBeat.o(131946);
      }
      return null;
    }
    
    private static g uG(String paramString)
    {
      AppMethodBeat.i(131941);
      paramString = (g)fIn.get(paramString);
      AppMethodBeat.o(131941);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.g
 * JD-Core Version:    0.7.0.1
 */