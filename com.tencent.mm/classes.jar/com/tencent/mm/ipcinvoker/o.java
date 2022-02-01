package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class o
{
  private static final Map<String, e> hno;
  
  static
  {
    AppMethodBeat.i(158758);
    hno = new ConcurrentHashMap();
    AppMethodBeat.o(158758);
  }
  
  public static <T> T b(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(158755);
    try
    {
      Class localClass = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(localClass))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass, localClass });
        AppMethodBeat.o(158755);
        return null;
      }
      if (localClass.isAnnotationPresent(a.class))
      {
        e locale = (e)hno.get(paramString);
        paramClass = locale;
        if (locale == null)
        {
          paramClass = new e(localClass);
          hno.put(paramString, paramClass);
        }
        paramString = paramClass.get();
        AppMethodBeat.o(158755);
        return paramString;
      }
      paramString = com.tencent.mm.ipcinvoker.g.b.c(paramString, paramClass);
      AppMethodBeat.o(158755);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(158755);
    }
    return null;
  }
  
  public static <T> T c(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(158757);
    paramString = com.tencent.mm.ipcinvoker.g.b.c(paramString, paramClass);
    AppMethodBeat.o(158757);
    return paramString;
  }
  
  public static <T> T i(Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(158756);
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        AppMethodBeat.o(158756);
        return null;
      }
      if (paramClass1.isAnnotationPresent(a.class))
      {
        String str = paramClass1.getName();
        e locale = (e)hno.get(str);
        paramClass2 = locale;
        if (locale == null)
        {
          paramClass2 = new e(paramClass1);
          hno.put(str, paramClass2);
        }
        paramClass1 = paramClass2.get();
        AppMethodBeat.o(158756);
        return paramClass1;
      }
      paramClass1 = com.tencent.mm.ipcinvoker.g.b.j(paramClass1, paramClass2);
      AppMethodBeat.o(158756);
      return paramClass1;
    }
    catch (Exception paramClass1)
    {
      AppMethodBeat.o(158756);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.o
 * JD-Core Version:    0.7.0.1
 */