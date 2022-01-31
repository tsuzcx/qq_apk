package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class f
{
  private static volatile boolean eIl = false;
  
  public static <T> T J(Class<T> paramClass)
  {
    AppMethodBeat.i(123248);
    if (!eIl)
    {
      AppMethodBeat.o(123248);
      return null;
    }
    paramClass = a(paramClass, 0);
    AppMethodBeat.o(123248);
    return paramClass;
  }
  
  private static <T> T a(Class<T> paramClass, int paramInt)
  {
    AppMethodBeat.i(123249);
    if (!eIl)
    {
      AppMethodBeat.o(123249);
      return null;
    }
    if (paramInt > 3)
    {
      j.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
      AppMethodBeat.o(123249);
      return null;
    }
    if (!paramClass.isInterface())
    {
      AppMethodBeat.o(123249);
      return null;
    }
    try
    {
      Object localObject = new a((byte)0);
      ((a)localObject).level = paramInt;
      localObject = Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass, b.class }, (InvocationHandler)localObject);
      j.i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", new Object[] { localObject, paramClass, Integer.valueOf(paramInt) });
      AppMethodBeat.o(123249);
      return localObject;
    }
    catch (Throwable paramClass)
    {
      j.printErrStackTrace("MMSkeleton.DummyMode", paramClass, "", new Object[0]);
      AppMethodBeat.o(123249);
    }
    return null;
  }
  
  public static boolean an(Object paramObject)
  {
    return (paramObject instanceof b);
  }
  
  static final class a
    implements InvocationHandler
  {
    public int level = 0;
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(123247);
      paramObject = paramMethod.getReturnType();
      if (paramObject.equals(Integer.TYPE))
      {
        AppMethodBeat.o(123247);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Long.TYPE))
      {
        AppMethodBeat.o(123247);
        return Long.valueOf(0L);
      }
      if (paramObject.equals(Double.TYPE))
      {
        AppMethodBeat.o(123247);
        return Double.valueOf(0.0D);
      }
      if (paramObject.equals(Float.TYPE))
      {
        AppMethodBeat.o(123247);
        return Float.valueOf(0.0F);
      }
      if (paramObject.equals(Short.TYPE))
      {
        AppMethodBeat.o(123247);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Byte.TYPE))
      {
        AppMethodBeat.o(123247);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Character.TYPE))
      {
        AppMethodBeat.o(123247);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Boolean.TYPE))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(123247);
        return paramObject;
      }
      if (paramObject.equals(Boolean.class))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(123247);
        return paramObject;
      }
      if (paramObject.isInterface())
      {
        paramObject = f.b(paramObject, this.level + 1);
        AppMethodBeat.o(123247);
        return paramObject;
      }
      AppMethodBeat.o(123247);
      return null;
    }
  }
  
  static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.f
 * JD-Core Version:    0.7.0.1
 */