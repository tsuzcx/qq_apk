package com.tencent.mm.plugin.expt.hellhound.core.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a wfn;
  
  static
  {
    AppMethodBeat.i(122559);
    wfn = new a((byte)0);
    AppMethodBeat.o(122559);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector$Companion;", "", "()V", "ActivityThreadClass", "Ljava/lang/Class;", "TAG", "", "sCurrentActivityThread", "sMainThreadHandler", "Landroid/os/Handler;", "execOnMainThread", "", "runnable", "Ljava/lang/Runnable;", "execOnMainThreadDelayed", "delayMillis", "", "getActivityThread", "getActivityThreadClazz", "getAllInterfaces", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clazz", "interfacesFound", "Ljava/util/HashSet;", "getClass", "className", "getDeclaredField", "Ljava/lang/reflect/Field;", "fieldName", "getDeclaredMethod", "Ljava/lang/reflect/Method;", "methodName", "paramTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getFieldAndObj", "Lkotlin/Pair;", "obj", "getFieldObject", "field", "getStaticFieldAndObj", "getStaticFieldObject", "init", "invokeMethod", "params", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeStaticMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "isInstance", "", "classType", "newProxy", "classLoader", "Ljava/lang/ClassLoader;", "interfaces", "handle", "Ljava/lang/reflect/InvocationHandler;", "(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;", "reflect", "Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKArgs;", "setField", "value", "plugin-expt_release"})
  public static final class a
  {
    public static boolean b(Object paramObject, Class<?> paramClass)
    {
      AppMethodBeat.i(122558);
      if (paramClass != null)
      {
        boolean bool = paramClass.isInstance(paramObject);
        AppMethodBeat.o(122558);
        return bool;
      }
      AppMethodBeat.o(122558);
      return false;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.b.a
 * JD-Core Version:    0.7.0.1
 */