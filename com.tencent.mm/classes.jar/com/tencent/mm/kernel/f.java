package com.tencent.mm.kernel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class f
{
  private static volatile boolean dKN = false;
  
  private static <T> T a(Class<T> paramClass, int paramInt)
  {
    if (!dKN) {}
    do
    {
      return null;
      if (paramInt > 3)
      {
        k.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
        return null;
      }
    } while (!paramClass.isInterface());
    try
    {
      Object localObject = new a((byte)0);
      ((a)localObject).level = paramInt;
      localObject = Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass, b.class }, (InvocationHandler)localObject);
      k.i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", new Object[] { localObject, paramClass, Integer.valueOf(paramInt) });
      return localObject;
    }
    catch (Throwable paramClass)
    {
      k.printErrStackTrace("MMSkeleton.DummyMode", paramClass, "", new Object[0]);
    }
    return null;
  }
  
  public static boolean af(Object paramObject)
  {
    return (paramObject instanceof b);
  }
  
  public static <T> T w(Class<T> paramClass)
  {
    if (!dKN) {
      return null;
    }
    return a(paramClass, 0);
  }
  
  private static final class a
    implements InvocationHandler
  {
    public int level = 0;
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      paramObject = paramMethod.getReturnType();
      if (paramObject.equals(Integer.TYPE)) {
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Long.TYPE)) {
        return Long.valueOf(0L);
      }
      if (paramObject.equals(Double.TYPE)) {
        return Double.valueOf(0.0D);
      }
      if (paramObject.equals(Float.TYPE)) {
        return Float.valueOf(0.0F);
      }
      if (paramObject.equals(Short.TYPE)) {
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Byte.TYPE)) {
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Character.TYPE)) {
        return Integer.valueOf(0);
      }
      if (paramObject.equals(Boolean.TYPE)) {
        return Boolean.valueOf(false);
      }
      if (paramObject.equals(Boolean.class)) {
        return Boolean.valueOf(false);
      }
      if (paramObject.isInterface()) {
        return f.b(paramObject, this.level + 1);
      }
      return null;
    }
  }
  
  private static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.f
 * JD-Core Version:    0.7.0.1
 */