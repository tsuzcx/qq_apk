package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class b
{
  private static b c;
  public m a;
  private String b;
  private Context d;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(180773);
    this.b = b.class.getSimpleName();
    this.d = paramContext;
    this.a = new m(this.d);
    AppMethodBeat.o(180773);
  }
  
  public static b a(Context paramContext)
  {
    AppMethodBeat.i(180774);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("context is null");
      AppMethodBeat.o(180774);
      throw paramContext;
    }
    if (paramContext.getApplicationContext() == null)
    {
      paramContext = new NullPointerException("application context is null");
      AppMethodBeat.o(180774);
      throw paramContext;
    }
    try
    {
      if (c == null) {
        c = new b(paramContext.getApplicationContext());
      }
      paramContext = c;
      AppMethodBeat.o(180774);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(180774);
    }
  }
  
  public static Object a(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    AppMethodBeat.i(180778);
    if (paramObject == null)
    {
      paramObject = new NullPointerException("Object instance is null");
      AppMethodBeat.o(180778);
      throw paramObject;
    }
    if (paramMethod == null)
    {
      paramObject = new NullPointerException("method instance is null");
      AppMethodBeat.o(180778);
      throw paramObject;
    }
    if (paramVarArgs == null)
    {
      paramObject = paramMethod.invoke(paramObject, new Object[] { paramMethod });
      AppMethodBeat.o(180778);
      return paramObject;
    }
    paramObject = paramMethod.invoke(paramObject, paramVarArgs);
    AppMethodBeat.o(180778);
    return paramObject;
  }
  
  public static Object a(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    AppMethodBeat.i(180776);
    if (paramConstructor == null)
    {
      paramConstructor = new NullPointerException("constructor is null");
      AppMethodBeat.o(180776);
      throw paramConstructor;
    }
    paramConstructor = paramConstructor.newInstance(paramVarArgs);
    AppMethodBeat.o(180776);
    return paramConstructor;
  }
  
  public static Constructor<?> a(Class paramClass, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(180775);
    if (paramClass == null)
    {
      paramClass = new NullPointerException("class is null");
      AppMethodBeat.o(180775);
      throw paramClass;
    }
    paramClass = paramClass.getConstructor(paramVarArgs);
    AppMethodBeat.o(180775);
    return paramClass;
  }
  
  public static Method a(Class paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(180777);
    if (paramClass == null)
    {
      paramClass = new NullPointerException("class is null");
      AppMethodBeat.o(180777);
      throw paramClass;
    }
    if (paramVarArgs == null)
    {
      paramClass = paramClass.getDeclaredMethod(paramString, new Class[0]);
      AppMethodBeat.o(180777);
      return paramClass;
    }
    paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
    AppMethodBeat.o(180777);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.tools.internal.b
 * JD-Core Version:    0.7.0.1
 */