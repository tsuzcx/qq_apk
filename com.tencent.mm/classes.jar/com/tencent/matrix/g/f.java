package com.tencent.matrix.g;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f
{
  public static <T> T a(Class<?> paramClass, String paramString, Object paramObject)
  {
    return new e(paramClass, paramString).get(paramObject);
  }
  
  public static <T> T b(Object paramObject, String paramString, T paramT)
  {
    if (paramObject == null) {
      return paramT;
    }
    try
    {
      paramString = (Field)Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class }).invoke(paramObject.getClass(), new Object[] { paramString });
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      c.e("Matrix.ReflectUtils", paramObject.toString() + "isHard=%s\n%s", new Object[] { Boolean.TRUE, d.g(paramObject) });
    }
    return paramT;
  }
  
  public static Method c(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramObject = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(paramObject.getClass(), new Object[] { paramString, paramVarArgs });
      paramObject.setAccessible(true);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      c.e("Matrix.ReflectUtils", paramObject.toString() + "isHard=%s\n%s", new Object[] { Boolean.TRUE, d.g(paramObject) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.g.f
 * JD-Core Version:    0.7.0.1
 */