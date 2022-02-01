package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public final class b
{
  public static <T> T G(Class<?> paramClass)
  {
    AppMethodBeat.i(158833);
    if (paramClass == null)
    {
      c.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
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
      c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      AppMethodBeat.o(158833);
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
    catch (InvocationTargetException paramClass)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
  }
  
  public static boolean au(Class<?> paramClass)
  {
    AppMethodBeat.i(235669);
    if (paramClass == null)
    {
      AppMethodBeat.o(235669);
      return false;
    }
    if (Modifier.isStatic(paramClass.getModifiers()))
    {
      AppMethodBeat.o(235669);
      return true;
    }
    if (paramClass.isLocalClass())
    {
      AppMethodBeat.o(235669);
      return false;
    }
    if (paramClass.isMemberClass())
    {
      AppMethodBeat.o(235669);
      return false;
    }
    paramClass = paramClass.getDeclaredConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Class[] arrayOfClass = paramClass[i].getParameterTypes();
      if ((arrayOfClass == null) || (arrayOfClass.length == 0))
      {
        AppMethodBeat.o(235669);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(235669);
    return false;
  }
  
  public static <T> T d(Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(158832);
    if (paramClass1 == null)
    {
      c.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(158832);
      return null;
    }
    if (paramClass2 == null)
    {
      c.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
      AppMethodBeat.o(158832);
      return null;
    }
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        c.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
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
      c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      AppMethodBeat.o(158832);
      return null;
    }
    catch (InstantiationException paramClass1)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
    catch (NoSuchMethodException paramClass1)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
    catch (InvocationTargetException paramClass1)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
  }
  
  public static <T> T g(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(158831);
    if ((paramString == null) || (paramString.length() == 0))
    {
      c.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(158831);
      return null;
    }
    if (paramClass == null)
    {
      c.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
      AppMethodBeat.o(158831);
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(paramString))
      {
        c.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass, paramString });
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
      c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      AppMethodBeat.o(158831);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        c.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.b
 * JD-Core Version:    0.7.0.1
 */