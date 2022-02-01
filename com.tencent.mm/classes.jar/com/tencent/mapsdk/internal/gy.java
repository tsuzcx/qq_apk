package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class gy
{
  public static <T> Class<? extends T> a(String paramString, Class<T> paramClass, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(225796);
    try
    {
      paramString = Class.forName(paramString, false, paramClassLoader);
      boolean bool = paramClass.isAssignableFrom(paramString);
      if (bool)
      {
        AppMethodBeat.o(225796);
        return paramString;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      kh.b(paramString.getMessage(), paramString);
      AppMethodBeat.o(225796);
    }
    return null;
  }
  
  public static Class a(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(225785);
    try
    {
      paramString = Class.forName(paramString, false, paramClassLoader);
      AppMethodBeat.o(225785);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      kh.b(paramString.getMessage(), paramString);
      AppMethodBeat.o(225785);
    }
    return null;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(225716);
    if ((paramClass == null) || (paramClass.isEnum()) || (paramClass.isInterface()) || (paramClass.isAnnotation()) || (paramClass.isArray()))
    {
      AppMethodBeat.o(225716);
      return null;
    }
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfConstructor.length)
      {
        Object localObject = arrayOfConstructor[i].getParameterTypes();
        int j;
        if (localObject.length == paramVarArgs.length)
        {
          j = 0;
          int m;
          for (int k = 0; j < localObject.length; k = m)
          {
            if (localObject[j] != paramVarArgs[j].getClass())
            {
              m = k;
              if (!localObject[j].isAssignableFrom(paramVarArgs[j].getClass())) {}
            }
            else
            {
              m = k + 1;
            }
            j += 1;
          }
          if (k == localObject.length)
          {
            j = 1;
            if (j == 0) {
              break label195;
            }
          }
        }
        try
        {
          arrayOfConstructor[i].setAccessible(true);
          localObject = arrayOfConstructor[i].newInstance(paramVarArgs);
          AppMethodBeat.o(225716);
          return localObject;
          j = 0;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          kh.b(localIllegalAccessException.getMessage(), localIllegalAccessException);
          i += 1;
        }
        catch (InstantiationException localInstantiationException)
        {
          for (;;)
          {
            kh.b(localInstantiationException.getMessage(), localInstantiationException);
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            label195:
            kh.b(localInvocationTargetException.getMessage(), localInvocationTargetException);
          }
        }
      }
    }
    try
    {
      paramClass = paramClass.newInstance();
      AppMethodBeat.o(225716);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      kh.b(paramClass.getMessage(), paramClass);
      AppMethodBeat.o(225716);
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        kh.b(paramClass.getMessage(), paramClass);
      }
    }
  }
  
  public static Object a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(225744);
    if (paramObject == null)
    {
      AppMethodBeat.o(225744);
      return null;
    }
    Class localClass = paramObject.getClass();
    if ((paramObject instanceof Class)) {
      localClass = (Class)paramObject;
    }
    try
    {
      paramString = localClass.getDeclaredField(paramString);
      paramString.setAccessible(true);
      if (Modifier.isStatic(paramString.getModifiers()))
      {
        paramObject = paramString.get(localClass);
        AppMethodBeat.o(225744);
        return paramObject;
      }
      paramObject = paramString.get(paramObject);
      AppMethodBeat.o(225744);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      kh.b(paramObject.getMessage(), paramObject);
      AppMethodBeat.o(225744);
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        kh.b(paramObject.getMessage(), paramObject);
      }
    }
  }
  
  private static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(225762);
    if (paramObject == null)
    {
      AppMethodBeat.o(225762);
      return null;
    }
    try
    {
      paramString = a(paramObject.getClass(), paramString, paramArrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.invoke(paramObject, paramArrayOfObject);
        AppMethodBeat.o(225762);
        return paramObject;
      }
    }
    catch (IllegalAccessException paramObject)
    {
      kh.b(paramObject.getMessage(), paramObject);
      AppMethodBeat.o(225762);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;)
      {
        kh.b(paramObject.getMessage(), paramObject);
      }
    }
  }
  
  private static Object a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(225753);
    if (paramObject == null)
    {
      AppMethodBeat.o(225753);
      return null;
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      arrayOfClass[i] = paramVarArgs[i].getClass();
      i += 1;
    }
    try
    {
      paramString = a(paramObject.getClass(), paramString, arrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.invoke(paramObject, paramVarArgs);
        AppMethodBeat.o(225753);
        return paramObject;
      }
    }
    catch (IllegalAccessException paramObject)
    {
      kh.b(paramObject.getMessage(), paramObject);
      AppMethodBeat.o(225753);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;)
      {
        kh.b(paramObject.getMessage(), paramObject);
      }
    }
  }
  
  private static Method a(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(225771);
    localObject = null;
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if (paramClass.getSuperclass() != Object.class)
        {
          paramClass = a(paramClass.getSuperclass(), paramString, paramArrayOfClass);
        }
        else
        {
          kh.b(localNoSuchMethodException.getMessage(), localNoSuchMethodException);
          paramClass = localObject;
        }
      }
    }
    AppMethodBeat.o(225771);
    return paramClass;
  }
  
  private static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(225735);
    if (paramObject1 == null)
    {
      AppMethodBeat.o(225735);
      return;
    }
    try
    {
      paramString = paramObject1.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramObject1, paramObject2);
      AppMethodBeat.o(225735);
      return;
    }
    catch (NoSuchFieldException paramObject1)
    {
      kh.b(paramObject1.getMessage(), paramObject1);
      AppMethodBeat.o(225735);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      kh.b(paramObject1.getMessage(), paramObject1);
      AppMethodBeat.o(225735);
    }
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(225729);
    if (paramArrayOfClass.length != paramArrayOfObject.length)
    {
      AppMethodBeat.o(225729);
      return false;
    }
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfClass.length; j = k)
    {
      if (paramArrayOfClass[i] != paramArrayOfObject[i].getClass())
      {
        k = j;
        if (!paramArrayOfClass[i].isAssignableFrom(paramArrayOfObject[i].getClass())) {}
      }
      else
      {
        k = j + 1;
      }
      i += 1;
    }
    if (j == paramArrayOfClass.length)
    {
      AppMethodBeat.o(225729);
      return true;
    }
    AppMethodBeat.o(225729);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gy
 * JD-Core Version:    0.7.0.1
 */