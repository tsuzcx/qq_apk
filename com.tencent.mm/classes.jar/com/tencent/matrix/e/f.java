package com.tencent.matrix.e;

import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f
{
  public static <T> T a(Class<?> paramClass, String paramString, Object paramObject)
  {
    return new e(paramClass, paramString).get(paramObject);
  }
  
  private static Method a(Object paramObject, boolean paramBoolean, String paramString, Class<?>... paramVarArgs)
  {
    if (paramBoolean) {
      try
      {
        paramObject = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(paramObject.getClass(), new Object[] { paramString, paramVarArgs });
        paramObject.setAccessible(true);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        c.e("Matrix.ReflectUtils", paramObject.toString() + "isHard=%s\n%s", new Object[] { Boolean.TRUE, d.e(paramObject) });
      }
    }
    for (;;)
    {
      return null;
      try
      {
        paramObject = paramObject.getClass().getDeclaredMethod(paramString, paramVarArgs);
        paramObject.setAccessible(true);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        c.e("Matrix.ReflectUtils", paramObject.toString() + "isHard=%s\n%s", new Object[] { Boolean.FALSE, d.e(paramObject) });
      }
    }
  }
  
  public static <T> T c(Object paramObject, String paramString, T paramT)
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
      c.e("Matrix.ReflectUtils", paramObject.toString() + "isHard=%s\n%s", new Object[] { Boolean.TRUE, d.e(paramObject) });
    }
    return paramT;
  }
  
  public static Method c(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT <= 29) {}
    for (boolean bool = true;; bool = false) {
      return a(paramObject, bool, paramString, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.e.f
 * JD-Core Version:    0.7.0.1
 */