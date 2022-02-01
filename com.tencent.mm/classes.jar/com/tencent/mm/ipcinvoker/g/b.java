package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b
{
  public static <T> T H(Class<?> paramClass)
  {
    AppMethodBeat.i(158833);
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(158833);
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass.setAccessible(true);
      paramClass = paramClass.newInstance(new Object[0]);
      AppMethodBeat.o(158833);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      AppMethodBeat.o(158833);
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
    catch (InvocationTargetException paramClass)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
  }
  
  public static <T> T c(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(158831);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(158831);
      return null;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
      AppMethodBeat.o(158831);
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(paramString))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass, paramString });
        AppMethodBeat.o(158831);
        return null;
      }
      paramString = paramString.getDeclaredConstructor(new Class[0]);
      paramString.setAccessible(true);
      paramString = paramString.newInstance(new Object[0]);
      AppMethodBeat.o(158831);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      AppMethodBeat.o(158831);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
  }
  
  public static <T> T j(Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(158832);
    if (paramClass1 == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(158832);
      return null;
    }
    if (paramClass2 == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
      AppMethodBeat.o(158832);
      return null;
    }
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        AppMethodBeat.o(158832);
        return null;
      }
      paramClass1 = paramClass1.getDeclaredConstructor(new Class[0]);
      paramClass1.setAccessible(true);
      paramClass1 = paramClass1.newInstance(new Object[0]);
      AppMethodBeat.o(158832);
      return paramClass1;
    }
    catch (IllegalAccessException paramClass1)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      AppMethodBeat.o(158832);
      return null;
    }
    catch (InstantiationException paramClass1)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
    catch (NoSuchMethodException paramClass1)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
    catch (InvocationTargetException paramClass1)
    {
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.b
 * JD-Core Version:    0.7.0.1
 */