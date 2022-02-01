package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.e;
import com.tencent.mm.ipcinvoker.h.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
{
  private static final Map<String, e> mza;
  
  static
  {
    AppMethodBeat.i(158758);
    mza = new ConcurrentHashMap();
    AppMethodBeat.o(158758);
  }
  
  public static <T> T c(Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(158756);
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        c.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        AppMethodBeat.o(158756);
        return null;
      }
      if (paramClass1.isAnnotationPresent(com.tencent.mm.ipcinvoker.c.b.class))
      {
        String str = paramClass1.getName();
        e locale = (e)mza.get(str);
        paramClass2 = locale;
        if (locale == null)
        {
          paramClass2 = new e(paramClass1);
          mza.put(str, paramClass2);
        }
        paramClass1 = paramClass2.get();
        AppMethodBeat.o(158756);
        return paramClass1;
      }
      paramClass1 = com.tencent.mm.ipcinvoker.g.b.d(paramClass1, paramClass2);
      AppMethodBeat.o(158756);
      return paramClass1;
    }
    catch (Exception paramClass1)
    {
      AppMethodBeat.o(158756);
    }
    return null;
  }
  
  public static <T> T f(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(158755);
    try
    {
      Class localClass = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(localClass))
      {
        c.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass, localClass });
        AppMethodBeat.o(158755);
        return null;
      }
      if (localClass.isAnnotationPresent(com.tencent.mm.ipcinvoker.c.b.class))
      {
        e locale = (e)mza.get(paramString);
        paramClass = locale;
        if (locale == null)
        {
          paramClass = new e(localClass);
          mza.put(paramString, paramClass);
        }
        paramString = paramClass.get();
        AppMethodBeat.o(158755);
        return paramString;
      }
      paramString = com.tencent.mm.ipcinvoker.g.b.g(paramString, paramClass);
      AppMethodBeat.o(158755);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(158755);
    }
    return null;
  }
  
  public static <T> T g(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(158757);
    paramString = com.tencent.mm.ipcinvoker.g.b.g(paramString, paramClass);
    AppMethodBeat.o(158757);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.r
 * JD-Core Version:    0.7.0.1
 */