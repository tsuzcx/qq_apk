package com.tencent.d.d.b;

import android.text.TextUtils;
import com.tencent.d.f.h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = c(paramClass, paramString);
      if (paramClass == null) {
        return null;
      }
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      h.l(paramClass);
    }
    return null;
  }
  
  public static Method a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      paramString1 = b(afH(paramString1), paramString2, paramVarArgs);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      h.l(paramString1);
    }
    return null;
  }
  
  private static Class<?> afH(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      if (paramString == null) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      try
      {
        h.l(paramString);
        paramString = null;
      }
      catch (Throwable paramString)
      {
        h.l(paramString);
      }
      return paramString;
    }
    return null;
  }
  
  private static Method b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass != null) {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        if (paramClass != null)
        {
          paramClass.setAccessible(true);
          return paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        h.l(paramClass);
      }
    }
    return null;
  }
  
  private static Field c(Class<?> paramClass, String paramString)
  {
    if (paramClass == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramClass = paramClass.getDeclaredField(paramString);
        if (paramClass != null)
        {
          paramClass.setAccessible(true);
          return paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        h.l(paramClass);
      }
    }
    return null;
  }
  
  public static Object gL(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(afH(paramString1), paramString2, null);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      h.l(paramString1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.d.b.e
 * JD-Core Version:    0.7.0.1
 */