package com.tencent.mm.plugin.expt.hellhound.core.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a zBn;
  
  static
  {
    AppMethodBeat.i(122559);
    zBn = new a((byte)0);
    AppMethodBeat.o(122559);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector$Companion;", "", "()V", "ActivityThreadClass", "Ljava/lang/Class;", "TAG", "", "sCurrentActivityThread", "sMainThreadHandler", "Landroid/os/Handler;", "execOnMainThread", "", "runnable", "Ljava/lang/Runnable;", "execOnMainThreadDelayed", "delayMillis", "", "getActivityThread", "getActivityThreadClazz", "getAllInterfaces", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clazz", "interfacesFound", "Ljava/util/HashSet;", "getClass", "className", "getDeclaredField", "Ljava/lang/reflect/Field;", "fieldName", "getDeclaredMethod", "Ljava/lang/reflect/Method;", "methodName", "paramTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getFieldAndObj", "Lkotlin/Pair;", "obj", "getFieldObject", "field", "getStaticFieldAndObj", "getStaticFieldObject", "init", "invokeMethod", "params", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeStaticMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "isInstance", "", "classType", "newProxy", "classLoader", "Ljava/lang/ClassLoader;", "interfaces", "handle", "Ljava/lang/reflect/InvocationHandler;", "(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;", "reflect", "Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKArgs;", "setField", "value", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static Object a(Class<?> paramClass, Object paramObject, String paramString)
    {
      AppMethodBeat.i(300110);
      if ((paramClass == null) || (paramObject == null))
      {
        AppMethodBeat.o(300110);
        return null;
      }
      try
      {
        paramClass = h(paramClass, paramString);
        if (paramClass == null)
        {
          AppMethodBeat.o(300110);
          return null;
        }
      }
      catch (IllegalArgumentException paramClass)
      {
        AppMethodBeat.o(300110);
        return null;
        paramClass = paramClass.get(paramObject);
        AppMethodBeat.o(300110);
        return paramClass;
      }
      catch (IllegalAccessException paramClass)
      {
        AppMethodBeat.o(300110);
      }
      return null;
    }
    
    public static Object a(ClassLoader paramClassLoader, Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
    {
      AppMethodBeat.i(300113);
      if ((paramClassLoader == null) || (paramInvocationHandler == null))
      {
        AppMethodBeat.o(300113);
        return null;
      }
      paramClassLoader = Proxy.newProxyInstance(paramClassLoader, paramArrayOfClass, paramInvocationHandler);
      AppMethodBeat.o(300113);
      return paramClassLoader;
    }
    
    public static Object a(Object paramObject, Field paramField)
    {
      AppMethodBeat.i(300106);
      if ((paramField == null) || (paramObject == null))
      {
        AppMethodBeat.o(300106);
        return null;
      }
      paramObject = paramField.get(paramObject);
      AppMethodBeat.o(300106);
      return paramObject;
    }
    
    private final void a(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
    {
      AppMethodBeat.i(300093);
      while (paramClass != null)
      {
        Class[] arrayOfClass = paramClass.getInterfaces();
        s.s(arrayOfClass, "interfaces");
        int i = 0;
        int k = arrayOfClass.length;
        while (i < k)
        {
          Class localClass = arrayOfClass[i];
          int j = i + 1;
          i = j;
          if (paramHashSet.add(localClass))
          {
            a(localClass, paramHashSet);
            i = j;
          }
        }
        paramClass = paramClass.getSuperclass();
      }
      AppMethodBeat.o(300093);
    }
    
    public static boolean c(Object paramObject, Class<?> paramClass)
    {
      AppMethodBeat.i(122558);
      if (paramClass == null)
      {
        AppMethodBeat.o(122558);
        return false;
      }
      boolean bool = paramClass.isInstance(paramObject);
      AppMethodBeat.o(122558);
      return bool;
    }
    
    public static Object d(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300120);
      if (paramArrayOfObject == null)
      {
        if (paramMethod == null)
        {
          AppMethodBeat.o(300120);
          return null;
        }
        paramObject = paramMethod.invoke(paramObject, new Object[0]);
        AppMethodBeat.o(300120);
        return paramObject;
      }
      if (paramMethod == null)
      {
        AppMethodBeat.o(300120);
        return null;
      }
      paramObject = paramMethod.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(300120);
      return paramObject;
    }
    
    public static Class<?> getClass(String paramString)
    {
      AppMethodBeat.i(122557);
      try
      {
        paramString = Class.forName(paramString);
        AppMethodBeat.o(122557);
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        AppMethodBeat.o(122557);
      }
      return null;
    }
    
    public static Field h(Class<?> paramClass, String paramString)
    {
      AppMethodBeat.i(300100);
      if ((paramClass == null) || (paramString == null))
      {
        AppMethodBeat.o(300100);
        return null;
      }
      try
      {
        paramClass = paramClass.getDeclaredField(paramString);
        paramClass.setAccessible(true);
        AppMethodBeat.o(300100);
        return paramClass;
      }
      catch (NoSuchFieldException paramClass)
      {
        AppMethodBeat.o(300100);
      }
      return null;
    }
    
    public static Object i(Class<?> paramClass, String paramString)
    {
      AppMethodBeat.i(300104);
      paramClass = h(paramClass, paramString);
      if (paramClass == null)
      {
        AppMethodBeat.o(300104);
        return null;
      }
      try
      {
        paramClass = paramClass.get(null);
        AppMethodBeat.o(300104);
        return paramClass;
      }
      catch (IllegalArgumentException paramClass)
      {
        AppMethodBeat.o(300104);
        return null;
      }
      catch (IllegalAccessException paramClass)
      {
        AppMethodBeat.o(300104);
      }
      return null;
    }
    
    public final ArrayList<Class<?>> bd(Class<?> paramClass)
    {
      AppMethodBeat.i(300123);
      if (paramClass == null)
      {
        AppMethodBeat.o(300123);
        return null;
      }
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      a(paramClass, (HashSet)localLinkedHashSet);
      paramClass = new ArrayList((Collection)localLinkedHashSet);
      AppMethodBeat.o(300123);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.b.a
 * JD-Core Version:    0.7.0.1
 */