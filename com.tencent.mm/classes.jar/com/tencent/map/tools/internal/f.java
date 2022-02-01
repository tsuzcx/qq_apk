package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f
  implements d
{
  private b a;
  
  public f(b paramb)
  {
    this.a = paramb;
  }
  
  public final Object callSheetMth(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(180788);
    try
    {
      paramString = b.a(paramObject.getClass(), paramString, paramArrayOfClass);
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          paramString.setAccessible(true);
          paramObject = b.a(paramObject, paramString, paramArrayOfObject);
          AppMethodBeat.o(180788);
          return paramObject;
        }
        catch (Exception paramObject)
        {
          if (!(paramObject instanceof InvocationTargetException)) {
            continue;
          }
          paramObject = new RuntimeException(((InvocationTargetException)paramObject).getTargetException());
          AppMethodBeat.o(180788);
          throw paramObject;
          paramObject = new RuntimeException(paramObject);
          AppMethodBeat.o(180788);
          throw paramObject;
        }
        paramString = paramString;
        paramString = null;
      }
    }
    AppMethodBeat.o(180788);
    return null;
  }
  
  public final Object callSheetMth(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(180787);
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i].getClass();
      i += 1;
    }
    try
    {
      paramString = b.a(paramObject.getClass(), paramString, arrayOfClass);
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          paramString.setAccessible(true);
          paramObject = b.a(paramObject, paramString, paramVarArgs);
          AppMethodBeat.o(180787);
          return paramObject;
        }
        catch (Exception paramObject)
        {
          if (!(paramObject instanceof InvocationTargetException)) {
            continue;
          }
          paramObject = new RuntimeException(((InvocationTargetException)paramObject).getTargetException());
          AppMethodBeat.o(180787);
          throw paramObject;
          paramObject = new RuntimeException(paramObject);
          AppMethodBeat.o(180787);
          throw paramObject;
        }
        paramString = paramString;
        paramString = null;
      }
    }
    AppMethodBeat.o(180787);
    return null;
  }
  
  public final Object callSheetStaMth(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(209788);
    Object localObject = null;
    try
    {
      paramString = b.a(paramClass, paramString, paramArrayOfClass);
      try
      {
        paramClass = b.a(paramClass, paramString, paramArrayOfObject);
        AppMethodBeat.o(209788);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        if ((paramClass instanceof InvocationTargetException))
        {
          paramClass = new RuntimeException(((InvocationTargetException)paramClass).getTargetException());
          AppMethodBeat.o(209788);
          throw paramClass;
        }
        paramClass = new RuntimeException(paramClass);
        AppMethodBeat.o(209788);
        throw paramClass;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public final Class findSheet(String paramString)
  {
    AppMethodBeat.i(180782);
    try
    {
      paramString = this.a.a(paramString);
      AppMethodBeat.o(180782);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(180782);
    }
    return null;
  }
  
  public final <T> Class<? extends T> findSheet(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(180783);
    paramString = findSheet(paramString);
    if (paramClass.isAssignableFrom(paramString))
    {
      AppMethodBeat.o(180783);
      return paramString;
    }
    AppMethodBeat.o(180783);
    return null;
  }
  
  public final ClassLoader getSheetLoader()
  {
    AppMethodBeat.i(180786);
    DexClassLoader localDexClassLoader = this.a.b();
    AppMethodBeat.o(180786);
    return localDexClassLoader;
  }
  
  public final int loadSheetGroups()
  {
    AppMethodBeat.i(180789);
    int i = this.a.c();
    AppMethodBeat.o(180789);
    return i;
  }
  
  public final <T> T newSheetIns(Class<T> paramClass, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(180785);
    if (paramClass != null)
    {
      Class[] arrayOfClass = new Class[paramVarArgs.length];
      while (i < paramVarArgs.length)
      {
        arrayOfClass[i] = paramVarArgs[i].getClass();
        i += 1;
      }
      try
      {
        paramClass = b.a(paramClass, arrayOfClass);
        if (paramClass == null) {}
      }
      catch (Exception paramClass)
      {
        for (;;)
        {
          try
          {
            paramClass = b.a(paramClass, new Object[0]);
            AppMethodBeat.o(180785);
            return paramClass;
          }
          catch (Exception paramClass)
          {
            if (!(paramClass instanceof InvocationTargetException)) {
              continue;
            }
            paramClass = new RuntimeException(((InvocationTargetException)paramClass).getTargetException());
            AppMethodBeat.o(180785);
            throw paramClass;
            paramClass = new RuntimeException(paramClass);
            AppMethodBeat.o(180785);
            throw paramClass;
          }
          paramClass = paramClass;
          paramClass = null;
        }
      }
    }
    AppMethodBeat.o(180785);
    return null;
  }
  
  public final Object newSheetIns(String paramString)
  {
    AppMethodBeat.i(180784);
    try
    {
      paramString = newSheetIns(findSheet(paramString), new Object[0]);
      AppMethodBeat.o(180784);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(180784);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.f
 * JD-Core Version:    0.7.0.1
 */