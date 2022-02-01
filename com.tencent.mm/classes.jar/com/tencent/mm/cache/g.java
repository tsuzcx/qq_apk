package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public abstract interface g
{
  public abstract Object get(Object paramObject);
  
  public abstract void m(Object paramObject1, Object paramObject2);
  
  public abstract Object remove(Object paramObject);
  
  public static final class a
  {
    private static Map<String, g> lvT;
    
    static
    {
      AppMethodBeat.i(131947);
      lvT = new HashMap();
      AppMethodBeat.o(131947);
    }
    
    private static g CO(String paramString)
    {
      AppMethodBeat.i(131941);
      paramString = (g)lvT.get(paramString);
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
      lvT.put(paramString, paramg);
      AppMethodBeat.o(131940);
    }
    
    public static <T> T ag(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131942);
      paramString1 = a(CO(paramString1), paramString2);
      AppMethodBeat.o(131942);
      return paramString1;
    }
    
    public static <T> void ah(String paramString1, String paramString2)
    {
      AppMethodBeat.i(131944);
      b(CO(paramString1), paramString2);
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
    
    public static <T> void c(String paramString1, String paramString2, T paramT)
    {
      AppMethodBeat.i(131943);
      paramString1 = CO(paramString1);
      if (paramString1 == null)
      {
        Log.e("MicroMsg.ICacheService.Factory", "null service");
        AppMethodBeat.o(131943);
        return;
      }
      paramString1.m(paramString2, paramT);
      AppMethodBeat.o(131943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cache.g
 * JD-Core Version:    0.7.0.1
 */