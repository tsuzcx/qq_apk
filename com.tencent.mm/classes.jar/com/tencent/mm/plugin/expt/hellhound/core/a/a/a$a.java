package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector$Companion;", "", "()V", "ActivityThreadClass", "Ljava/lang/Class;", "TAG", "", "sCurrentActivityThread", "sMainThreadHandler", "Landroid/os/Handler;", "execOnMainThread", "", "runnable", "Ljava/lang/Runnable;", "execOnMainThreadDelayed", "delayMillis", "", "getActivityThread", "getActivityThreadClazz", "getAllInterfaces", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clazz", "interfacesFound", "Ljava/util/HashSet;", "getClass", "className", "getDeclaredField", "Ljava/lang/reflect/Field;", "fieldName", "getDeclaredMethod", "Ljava/lang/reflect/Method;", "methodName", "paramTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getFieldAndObj", "Lkotlin/Pair;", "obj", "getFieldObject", "field", "getStaticFieldAndObj", "getStaticFieldObject", "init", "invokeMethod", "params", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeStaticMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "isInstance", "", "classType", "newProxy", "classLoader", "Ljava/lang/ClassLoader;", "interfaces", "handle", "Ljava/lang/reflect/InvocationHandler;", "(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;", "reflect", "Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKArgs;", "setField", "value", "plugin-expt_release"})
public final class a$a
{
  public static Object a(ClassLoader paramClassLoader, Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
  {
    AppMethodBeat.i(152480);
    if ((paramClassLoader == null) || (paramArrayOfClass == null) || (paramInvocationHandler == null))
    {
      AppMethodBeat.o(152480);
      return null;
    }
    paramClassLoader = Proxy.newProxyInstance(paramClassLoader, paramArrayOfClass, paramInvocationHandler);
    AppMethodBeat.o(152480);
    return paramClassLoader;
  }
  
  public static Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(152482);
    if (paramArrayOfObject == null)
    {
      if (paramMethod != null)
      {
        paramObject = paramMethod.invoke(paramObject, new Object[0]);
        AppMethodBeat.o(152482);
        return paramObject;
      }
      AppMethodBeat.o(152482);
      return null;
    }
    if (paramMethod != null)
    {
      paramObject = paramMethod.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(152482);
      return paramObject;
    }
    AppMethodBeat.o(152482);
    return null;
  }
  
  public static Field a(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(152477);
    if ((paramClass == null) || (paramString == null))
    {
      AppMethodBeat.o(152477);
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      j.p(paramClass, "field");
      paramClass.setAccessible(true);
      AppMethodBeat.o(152477);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(152477);
    }
    return null;
  }
  
  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(152479);
    if ((paramClass == null) || (paramString == null))
    {
      AppMethodBeat.o(152479);
      return null;
    }
    int i;
    if (paramArrayOfClass != null)
    {
      if (paramArrayOfClass.length != 0) {
        break label61;
      }
      i = 1;
      if (i == 0) {
        break label66;
      }
    }
    label61:
    label66:
    for (paramClass = paramClass.getDeclaredMethod(paramString, new Class[0]);; paramClass = paramClass.getDeclaredMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, paramArrayOfClass.length)))
    {
      if (paramClass != null) {
        paramClass.setAccessible(true);
      }
      AppMethodBeat.o(152479);
      return paramClass;
      i = 0;
      break;
    }
  }
  
  private final void a(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
  {
    AppMethodBeat.i(152475);
    while (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getInterfaces();
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class localClass = arrayOfClass[i];
        if (paramHashSet.add(localClass)) {
          ((a)this).a(localClass, paramHashSet);
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
    AppMethodBeat.o(152475);
  }
  
  public static Object b(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(152478);
    paramClass = a(paramClass, paramString);
    if (paramClass == null)
    {
      AppMethodBeat.o(152478);
      return null;
    }
    try
    {
      paramClass = paramClass.get(null);
      AppMethodBeat.o(152478);
      return paramClass;
    }
    catch (IllegalArgumentException paramClass)
    {
      AppMethodBeat.o(152478);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(152478);
    }
    return null;
  }
  
  public static boolean b(Object paramObject, Class<?> paramClass)
  {
    AppMethodBeat.i(152481);
    if (paramClass != null)
    {
      boolean bool = paramClass.isInstance(paramObject);
      AppMethodBeat.o(152481);
      return bool;
    }
    AppMethodBeat.o(152481);
    return false;
  }
  
  public static Class<?> getClass(String paramString)
  {
    AppMethodBeat.i(152476);
    if (paramString == null)
    {
      AppMethodBeat.o(152476);
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(152476);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(152476);
    }
    return null;
  }
  
  static void init()
  {
    Object localObject2 = null;
    AppMethodBeat.i(152473);
    if (a.brx() != null)
    {
      AppMethodBeat.o(152473);
      return;
    }
    a.aj(getClass("android.app.ActivityThread"));
    Object localObject3 = new StringBuilder("habbyge-mali, ActivityThreadClass: ");
    Object localObject1 = a.brx();
    if (localObject1 != null) {}
    for (localObject1 = ((Class)localObject1).getSimpleName();; localObject1 = null)
    {
      ab.i("HellKReflector", (String)localObject1);
      localObject3 = a(a.brx(), "currentActivityThread", null);
      if (localObject3 != null) {
        ((Method)localObject3).invoke(a.brx(), new Object[0]);
      }
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Method)localObject3).invoke(a.brx(), new Object[0]);
      }
      a.bH(localObject1);
      AppMethodBeat.o(152473);
      return;
    }
  }
  
  public final ArrayList<Class<?>> ak(Class<?> paramClass)
  {
    AppMethodBeat.i(152474);
    if (paramClass == null)
    {
      AppMethodBeat.o(152474);
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    ((a)this).a(paramClass, (HashSet)localLinkedHashSet);
    paramClass = new ArrayList((Collection)localLinkedHashSet);
    AppMethodBeat.o(152474);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */