package com.tencent.e.d.b;

import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f
{
  public static Method a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(138372);
    try
    {
      paramString1 = c(bFz(paramString1), paramString2, paramVarArgs);
      AppMethodBeat.o(138372);
      return paramString1;
    }
    finally
    {
      h.w(paramString1);
      AppMethodBeat.o(138372);
    }
    return null;
  }
  
  public static Object b(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(138369);
    try
    {
      paramClass = m(paramClass, paramString);
      if (paramClass == null)
      {
        AppMethodBeat.o(138369);
        return null;
      }
      paramClass = paramClass.get(paramObject);
      AppMethodBeat.o(138369);
      return paramClass;
    }
    finally
    {
      h.w(paramClass);
      AppMethodBeat.o(138369);
    }
    return null;
  }
  
  private static Class<?> bFz(String paramString)
  {
    AppMethodBeat.i(138368);
    try
    {
      paramString = Class.forName(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(138368);
        return null;
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          h.w(paramString);
          paramString = null;
        }
      }
      finally
      {
        h.w(paramString);
        AppMethodBeat.o(138368);
      }
      AppMethodBeat.o(138368);
      return paramString;
    }
    return null;
  }
  
  private static Method c(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(138371);
    if (paramClass != null) {}
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(138371);
        return null;
      }
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      if (paramClass == null)
      {
        AppMethodBeat.o(138371);
        return null;
      }
      paramClass.setAccessible(true);
      AppMethodBeat.o(138371);
      return paramClass;
    }
    finally
    {
      h.w(paramClass);
      AppMethodBeat.o(138371);
    }
    return null;
  }
  
  private static Field m(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(138367);
    if (paramClass == null)
    {
      AppMethodBeat.o(138367);
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      if (paramClass == null)
      {
        AppMethodBeat.o(138367);
        return null;
      }
      paramClass.setAccessible(true);
      AppMethodBeat.o(138367);
      return paramClass;
    }
    finally
    {
      h.w(paramClass);
      AppMethodBeat.o(138367);
    }
    return null;
  }
  
  public static Object qB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138370);
    try
    {
      paramString1 = b(bFz(paramString1), paramString2, null);
      AppMethodBeat.o(138370);
      return paramString1;
    }
    finally
    {
      h.w(paramString1);
      AppMethodBeat.o(138370);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.b.f
 * JD-Core Version:    0.7.0.1
 */