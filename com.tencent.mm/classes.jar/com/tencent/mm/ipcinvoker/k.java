package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, e> dGN = new ConcurrentHashMap();
  
  public static <T> T a(Class<?> paramClass1, Class<?> paramClass2)
  {
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        return null;
      }
      if (paramClass1.isAnnotationPresent(a.class))
      {
        String str = paramClass1.getName();
        e locale = (e)dGN.get(str);
        paramClass2 = locale;
        if (locale == null)
        {
          paramClass2 = new e(paramClass1);
          dGN.put(str, paramClass2);
        }
        return paramClass2.get();
      }
      paramClass1 = com.tencent.mm.ipcinvoker.g.b.b(paramClass1, paramClass2);
      return paramClass1;
    }
    catch (Exception paramClass1) {}
    return null;
  }
  
  public static <T> T d(String paramString, Class<?> paramClass)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(localClass))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass, localClass });
        return null;
      }
      if (localClass.isAnnotationPresent(a.class))
      {
        e locale = (e)dGN.get(paramString);
        paramClass = locale;
        if (locale == null)
        {
          paramClass = new e(localClass);
          dGN.put(paramString, paramClass);
        }
        return paramClass.get();
      }
      paramString = com.tencent.mm.ipcinvoker.g.b.e(paramString, paramClass);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static <T> T e(String paramString, Class<?> paramClass)
  {
    return com.tencent.mm.ipcinvoker.g.b.e(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.k
 * JD-Core Version:    0.7.0.1
 */