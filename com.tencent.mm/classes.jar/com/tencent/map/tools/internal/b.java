package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class b
{
  private static b b;
  private String a;
  private Context c;
  private m d;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(180773);
    this.a = b.class.getSimpleName();
    this.c = paramContext;
    this.d = new m(this.c);
    AppMethodBeat.o(180773);
  }
  
  public static b a(Context paramContext)
  {
    AppMethodBeat.i(180774);
    if (b == null)
    {
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
    }
    try
    {
      if (b == null) {
        b = new b(paramContext.getApplicationContext());
      }
      paramContext = b;
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
  
  public final Class a(String paramString)
  {
    AppMethodBeat.i(224073);
    DexClassLoader localDexClassLoader = this.d.b();
    if (localDexClassLoader == null)
    {
      paramString = new NullPointerException("load class failed");
      AppMethodBeat.o(224073);
      throw paramString;
    }
    paramString = localDexClassLoader.loadClass(paramString);
    AppMethodBeat.o(224073);
    return paramString;
  }
  
  public final void a()
  {
    AppMethodBeat.i(224070);
    this.d.a();
    AppMethodBeat.o(224070);
  }
  
  public final void a(ModuleUncaughtListener paramModuleUncaughtListener)
  {
    AppMethodBeat.i(224068);
    this.d.a(paramModuleUncaughtListener);
    AppMethodBeat.o(224068);
  }
  
  public final void a(File paramFile)
  {
    AppMethodBeat.i(224069);
    this.d.a(paramFile);
    AppMethodBeat.o(224069);
  }
  
  public final DexClassLoader b()
  {
    AppMethodBeat.i(224071);
    DexClassLoader localDexClassLoader = this.d.b();
    AppMethodBeat.o(224071);
    return localDexClassLoader;
  }
  
  public final int c()
  {
    AppMethodBeat.i(224072);
    int i = this.d.a(a.g);
    AppMethodBeat.o(224072);
    return i;
  }
  
  public final File d()
  {
    AppMethodBeat.i(224074);
    File localFile = this.d.c();
    AppMethodBeat.o(224074);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.b
 * JD-Core Version:    0.7.0.1
 */