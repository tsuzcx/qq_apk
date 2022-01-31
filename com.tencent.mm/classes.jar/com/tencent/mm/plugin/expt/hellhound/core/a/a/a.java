package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  private static Class<?> lZF;
  private static Object lZG;
  public static final a.a lZH;
  
  static
  {
    AppMethodBeat.i(152483);
    lZH = new a.a((byte)0);
    AppMethodBeat.o(152483);
  }
  
  public static final Object a(ClassLoader paramClassLoader, Class<?>[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
  {
    AppMethodBeat.i(152494);
    paramClassLoader = a.a.a(paramClassLoader, paramArrayOfClass, paramInvocationHandler);
    AppMethodBeat.o(152494);
    return paramClassLoader;
  }
  
  public static final Object a(Object paramObject, Field paramField)
  {
    AppMethodBeat.i(152490);
    if ((paramField == null) || (paramObject == null))
    {
      AppMethodBeat.o(152490);
      return null;
    }
    paramObject = paramField.get(paramObject);
    AppMethodBeat.o(152490);
    return paramObject;
  }
  
  public static final Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(152496);
    paramObject = a.a.a(paramObject, paramMethod, paramArrayOfObject);
    AppMethodBeat.o(152496);
    return paramObject;
  }
  
  public static final Field a(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(152488);
    paramClass = a.a.a(paramClass, paramString);
    AppMethodBeat.o(152488);
    return paramClass;
  }
  
  public static final Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(152491);
    paramClass = a.a.a(paramClass, paramString, paramArrayOfClass);
    AppMethodBeat.o(152491);
    return paramClass;
  }
  
  public static final void a(Field paramField, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(152493);
    if (paramField != null)
    {
      paramField.set(paramObject1, paramObject2);
      AppMethodBeat.o(152493);
      return;
    }
    AppMethodBeat.o(152493);
  }
  
  public static final ArrayList<Class<?>> ak(Class<?> paramClass)
  {
    AppMethodBeat.i(152486);
    paramClass = lZH.ak(paramClass);
    AppMethodBeat.o(152486);
    return paramClass;
  }
  
  public static final Object b(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(152489);
    paramClass = a.a.b(paramClass, paramString);
    AppMethodBeat.o(152489);
    return paramClass;
  }
  
  public static final boolean b(Object paramObject, Class<?> paramClass)
  {
    AppMethodBeat.i(152495);
    boolean bool = a.a.b(paramObject, paramClass);
    AppMethodBeat.o(152495);
    return bool;
  }
  
  public static final Object bry()
  {
    AppMethodBeat.i(152484);
    a.a.init();
    Object localObject = lZG;
    AppMethodBeat.o(152484);
    return localObject;
  }
  
  public static final Class<?> brz()
  {
    AppMethodBeat.i(152485);
    a.a.init();
    Class localClass = lZF;
    AppMethodBeat.o(152485);
    return localClass;
  }
  
  public static final Object c(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(152492);
    if (paramClass == null)
    {
      AppMethodBeat.o(152492);
      return null;
    }
    paramClass = a.a.a(paramClass, paramString, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(152492);
      return null;
    }
    paramClass = paramClass.invoke(null, new Object[0]);
    AppMethodBeat.o(152492);
    return paramClass;
  }
  
  public static final Class<?> getClass(String paramString)
  {
    AppMethodBeat.i(152487);
    paramString = a.a.getClass(paramString);
    AppMethodBeat.o(152487);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.a
 * JD-Core Version:    0.7.0.1
 */