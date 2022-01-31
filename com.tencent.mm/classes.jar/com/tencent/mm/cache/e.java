package com.tencent.mm.cache;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public abstract interface e
{
  public abstract Object get(Object paramObject);
  
  public abstract void h(Object paramObject1, Object paramObject2);
  
  public abstract Object remove(Object paramObject);
  
  public static final class a
  {
    private static Map<String, e> dla = new HashMap();
    
    public static <T> T A(String paramString1, String paramString2)
    {
      return a(eL(paramString1), paramString2);
    }
    
    public static <T> void B(String paramString1, String paramString2)
    {
      b(eL(paramString1), paramString2);
    }
    
    private static <T> T a(e parame, String paramString)
    {
      if (parame == null)
      {
        y.e("MicroMsg.ICacheService.Factory", "null service");
        return null;
      }
      try
      {
        parame = parame.get(paramString);
        return parame;
      }
      catch (Exception parame)
      {
        y.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        y.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bk.j(parame) });
      }
      return null;
    }
    
    public static void a(String paramString, e parame)
    {
      dla.put(paramString, parame);
    }
    
    public static <T> void a(String paramString1, String paramString2, T paramT)
    {
      paramString1 = eL(paramString1);
      if (paramString1 == null)
      {
        y.e("MicroMsg.ICacheService.Factory", "null service");
        return;
      }
      paramString1.h(paramString2, paramT);
    }
    
    private static <T> T b(e parame, String paramString)
    {
      if (parame == null)
      {
        y.e("MicroMsg.ICacheService.Factory", "null service");
        return null;
      }
      try
      {
        parame = parame.remove(paramString);
        return parame;
      }
      catch (Exception parame)
      {
        y.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        y.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bk.j(parame) });
      }
      return null;
    }
    
    private static e eL(String paramString)
    {
      return (e)dla.get(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cache.e
 * JD-Core Version:    0.7.0.1
 */