package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public abstract interface g
{
  public abstract void e(Object paramObject1, Object paramObject2);
  
  public abstract Object get(Object paramObject);
  
  public abstract Object remove(Object paramObject);
  
  public static final class a
  {
    private static Map<String, g> iTN;
    
    static
    {
      AppMethodBeat.i(131947);
      iTN = new HashMap();
      AppMethodBeat.o(131947);
    }
    
    private static g Ki(String paramString)
    {
      AppMethodBeat.i(131941);
      paramString = (g)iTN.get(paramString);
      AppMethodBeat.o(131941);
      return paramString;
    }
    
    private static <T> T a(g paramg, String paramString)
    {
      AppMethodBeat.i(131945);
      if (paramg == null)
      {
        Log.e("MicroMsg.ICacheService.Factory", "null service");
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
        Log.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        Log.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { Util.stackTraceToString(paramg) });
        AppMethodBeat.o(131945);
      }
      return null;
    }
    
    public static void a(String paramString, g paramg)
    {
      AppMethodBeat.i(131940);
      iTN.put(paramString, paramg);
      AppMethodBeat.o(131940);
    }
    
    public static <T> void a(String paramString1, String paramString2, T paramT)
    {
      AppMethodBeat.i(131943);
      paramString1 = Ki(paramString1);
      if (paramString1 == null)
      {
        Log.e("MicroMsg.ICacheService.Factory", "null service");
        AppMethodBeat.o(131943);
        return;
      }
      paramString1.e(paramString2, paramT);
      AppMethodBeat.o(131943);
    }
    
    public static <T> T ab(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131942);
      paramString1 = a(Ki(paramString1), paramString2);
      AppMethodBeat.o(131942);
      return paramString1;
    }
    
    public static <T> void ac(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131944);
      b(Ki(paramString1), paramString2);
      AppMethodBeat.o(131944);
    }
    
    private static <T> T b(g paramg, String paramString)
    {
      AppMethodBeat.i(131946);
      if (paramg == null)
      {
        Log.e("MicroMsg.ICacheService.Factory", "null service");
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
        Log.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        Log.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { Util.stackTraceToString(paramg) });
        AppMethodBeat.o(131946);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.g
 * JD-Core Version:    0.7.0.1
 */