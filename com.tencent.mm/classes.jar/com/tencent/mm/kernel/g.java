package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class g
{
  private static volatile boolean mDi = false;
  
  public static <T> T aC(Class<T> paramClass)
  {
    AppMethodBeat.i(158301);
    if (!mDi)
    {
      AppMethodBeat.o(158301);
      return null;
    }
    paramClass = b(paramClass, 0);
    AppMethodBeat.o(158301);
    return paramClass;
  }
  
  private static <T> T b(Class<T> paramClass, int paramInt)
  {
    AppMethodBeat.i(158302);
    if (!mDi)
    {
      AppMethodBeat.o(158302);
      return null;
    }
    if (paramInt > 3)
    {
      l.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
      AppMethodBeat.o(158302);
      return null;
    }
    if (!paramClass.isInterface())
    {
      AppMethodBeat.o(158302);
      return null;
    }
    try
    {
      Object localObject = new a((byte)0);
      ((a)localObject).level = paramInt;
      localObject = Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass, b.class }, (InvocationHandler)localObject);
      l.i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", new Object[] { localObject, paramClass, Integer.valueOf(paramInt) });
      AppMethodBeat.o(158302);
      return localObject;
    }
    finally
    {
      l.printErrStackTrace("MMSkeleton.DummyMode", paramClass, "", new Object[0]);
      AppMethodBeat.o(158302);
    }
    return null;
  }
  
  public static void bay()
  {
    mDi = true;
  }
  
  public static boolean cR(Object paramObject)
  {
    return (paramObject instanceof b);
  }
  
  static final class a
    implements InvocationHandler
  {
    public int level = 0;
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(158300);
      paramObject = paramMethod.getReturnType();
      if (paramObject.equals(Integer.TYPE))
      {
        AppMethodBeat.o(158300);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Long.TYPE))
      {
        AppMethodBeat.o(158300);
        return Long.valueOf(0L);
      }
      if (paramObject.equals(Double.TYPE))
      {
        AppMethodBeat.o(158300);
        return Double.valueOf(0.0D);
      }
      if (paramObject.equals(Float.TYPE))
      {
        AppMethodBeat.o(158300);
        return Float.valueOf(0.0F);
      }
      if (paramObject.equals(Short.TYPE))
      {
        AppMethodBeat.o(158300);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Byte.TYPE))
      {
        AppMethodBeat.o(158300);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Character.TYPE))
      {
        AppMethodBeat.o(158300);
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Boolean.TYPE))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(158300);
        return paramObject;
      }
      if (paramObject.equals(Boolean.class))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(158300);
        return paramObject;
      }
      if (paramObject.isInterface())
      {
        paramObject = g.c(paramObject, this.level + 1);
        AppMethodBeat.o(158300);
        return paramObject;
      }
      AppMethodBeat.o(158300);
      return null;
    }
  }
  
  static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.g
 * JD-Core Version:    0.7.0.1
 */