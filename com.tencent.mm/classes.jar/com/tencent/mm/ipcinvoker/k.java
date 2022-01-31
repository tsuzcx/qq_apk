package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  private static final Map<String, e> eEq;
  
  static
  {
    AppMethodBeat.i(114048);
    eEq = new ConcurrentHashMap();
    AppMethodBeat.o(114048);
  }
  
  public static <T> T b(Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(114046);
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        AppMethodBeat.o(114046);
        return null;
      }
      if (paramClass1.isAnnotationPresent(a.class))
      {
        String str = paramClass1.getName();
        e locale = (e)eEq.get(str);
        paramClass2 = locale;
        if (locale == null)
        {
          paramClass2 = new e(paramClass1);
          eEq.put(str, paramClass2);
        }
        paramClass1 = paramClass2.get();
        AppMethodBeat.o(114046);
        return paramClass1;
      }
      paramClass1 = com.tencent.mm.ipcinvoker.g.b.c(paramClass1, paramClass2);
      AppMethodBeat.o(114046);
      return paramClass1;
    }
    catch (Exception paramClass1)
    {
      AppMethodBeat.o(114046);
    }
    return null;
  }
  
  public static <T> T c(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(114045);
    try
    {
      Class localClass = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(localClass))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass, localClass });
        AppMethodBeat.o(114045);
        return null;
      }
      if (localClass.isAnnotationPresent(a.class))
      {
        e locale = (e)eEq.get(paramString);
        paramClass = locale;
        if (locale == null)
        {
          paramClass = new e(localClass);
          eEq.put(paramString, paramClass);
        }
        paramString = paramClass.get();
        AppMethodBeat.o(114045);
        return paramString;
      }
      paramString = com.tencent.mm.ipcinvoker.g.b.d(paramString, paramClass);
      AppMethodBeat.o(114045);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(114045);
    }
    return null;
  }
  
  public static <T> T d(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(114047);
    paramString = com.tencent.mm.ipcinvoker.g.b.d(paramString, paramClass);
    AppMethodBeat.o(114047);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.k
 * JD-Core Version:    0.7.0.1
 */