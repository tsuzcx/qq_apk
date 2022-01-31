package com.tencent.e.d.b;

import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(114528);
    try
    {
      paramClass = f(paramClass, paramString);
      if (paramClass == null)
      {
        AppMethodBeat.o(114528);
        return null;
      }
      paramClass = paramClass.get(paramObject);
      AppMethodBeat.o(114528);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      h.w(paramClass);
      AppMethodBeat.o(114528);
    }
    return null;
  }
  
  public static Method a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(114531);
    try
    {
      paramString1 = c(awD(paramString1), paramString2, paramVarArgs);
      AppMethodBeat.o(114531);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      h.w(paramString1);
      AppMethodBeat.o(114531);
    }
    return null;
  }
  
  private static Class<?> awD(String paramString)
  {
    AppMethodBeat.i(114527);
    try
    {
      paramString = Class.forName(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(114527);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      try
      {
        h.w(paramString);
        paramString = null;
      }
      catch (Throwable paramString)
      {
        h.w(paramString);
        AppMethodBeat.o(114527);
      }
      AppMethodBeat.o(114527);
      return paramString;
    }
    return null;
  }
  
  private static Method c(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(114530);
    if (paramClass != null) {}
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(114530);
        return null;
      }
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      if (paramClass == null)
      {
        AppMethodBeat.o(114530);
        return null;
      }
      paramClass.setAccessible(true);
      AppMethodBeat.o(114530);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      h.w(paramClass);
      AppMethodBeat.o(114530);
    }
    return null;
  }
  
  private static Field f(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(114526);
    if (paramClass == null)
    {
      AppMethodBeat.o(114526);
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      if (paramClass == null)
      {
        AppMethodBeat.o(114526);
        return null;
      }
      paramClass.setAccessible(true);
      AppMethodBeat.o(114526);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      h.w(paramClass);
      AppMethodBeat.o(114526);
    }
    return null;
  }
  
  public static Object iR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114529);
    try
    {
      paramString1 = a(awD(paramString1), paramString2, null);
      AppMethodBeat.o(114529);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      h.w(paramString1);
      AppMethodBeat.o(114529);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.d.b.e
 * JD-Core Version:    0.7.0.1
 */