package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b
{
  static b Zx;
  private final Map<Class<?>, a> Zy;
  private final Map<Class<?>, Boolean> Zz;
  
  static
  {
    AppMethodBeat.i(213323);
    Zx = new b();
    AppMethodBeat.o(213323);
  }
  
  b()
  {
    AppMethodBeat.i(213301);
    this.Zy = new HashMap();
    this.Zz = new HashMap();
    AppMethodBeat.o(213301);
  }
  
  private a a(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    AppMethodBeat.i(213321);
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = d((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((a)localObject1).ZB);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = d(localObject1[i]).ZB.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (b)((Map.Entry)localObject3).getKey(), (h.a)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod != null) {}
    boolean bool;
    for (;;)
    {
      int k = paramArrayOfMethod.length;
      j = 0;
      bool = false;
      if (j >= k) {
        break label372;
      }
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (t)((Method)localObject1).getAnnotation(t.class);
      if (localObject3 == null) {
        break label417;
      }
      localObject2 = ((Method)localObject1).getParameterTypes();
      if (localObject2.length <= 0) {
        break label420;
      }
      if (localObject2[0].isAssignableFrom(l.class)) {
        break;
      }
      paramClass = new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      AppMethodBeat.o(213321);
      throw paramClass;
      paramArrayOfMethod = c(paramClass);
    }
    label417:
    label420:
    for (i = 1;; i = 0)
    {
      localObject3 = ((t)localObject3).jl();
      if (localObject2.length > 1)
      {
        if (!localObject2[1].isAssignableFrom(h.a.class))
        {
          paramClass = new IllegalArgumentException("invalid parameter type. second arg must be an event");
          AppMethodBeat.o(213321);
          throw paramClass;
        }
        if (localObject3 != h.a.ON_ANY)
        {
          paramClass = new IllegalArgumentException("Second arg is supported only for ON_ANY value");
          AppMethodBeat.o(213321);
          throw paramClass;
        }
        i = 2;
      }
      if (localObject2.length > 2)
      {
        paramClass = new IllegalArgumentException("cannot have more than 2 params");
        AppMethodBeat.o(213321);
        throw paramClass;
      }
      a(localHashMap, new b(i, (Method)localObject1), (h.a)localObject3, paramClass);
      bool = true;
      for (;;)
      {
        j += 1;
        break;
        label372:
        paramArrayOfMethod = new a(localHashMap);
        this.Zy.put(paramClass, paramArrayOfMethod);
        this.Zz.put(paramClass, Boolean.valueOf(bool));
        AppMethodBeat.o(213321);
        return paramArrayOfMethod;
      }
    }
  }
  
  private static void a(Map<b, h.a> paramMap, b paramb, h.a parama, Class<?> paramClass)
  {
    AppMethodBeat.i(213314);
    h.a locala = (h.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      paramMap = paramb.mMethod;
      paramMap = new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + locala + ", new value " + parama);
      AppMethodBeat.o(213314);
      throw paramMap;
    }
    if (locala == null) {
      paramMap.put(paramb, parama);
    }
    AppMethodBeat.o(213314);
  }
  
  private static Method[] c(Class<?> paramClass)
  {
    AppMethodBeat.i(213308);
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      AppMethodBeat.o(213308);
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      paramClass = new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
      AppMethodBeat.o(213308);
      throw paramClass;
    }
  }
  
  final boolean b(Class<?> paramClass)
  {
    AppMethodBeat.i(213304);
    Object localObject = (Boolean)this.Zz.get(paramClass);
    if (localObject != null)
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(213304);
      return bool;
    }
    localObject = c(paramClass);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((t)localObject[i].getAnnotation(t.class) != null)
      {
        a(paramClass, (Method[])localObject);
        AppMethodBeat.o(213304);
        return true;
      }
      i += 1;
    }
    this.Zz.put(paramClass, Boolean.FALSE);
    AppMethodBeat.o(213304);
    return false;
  }
  
  final a d(Class<?> paramClass)
  {
    AppMethodBeat.i(213311);
    a locala = (a)this.Zy.get(paramClass);
    if (locala != null)
    {
      AppMethodBeat.o(213311);
      return locala;
    }
    paramClass = a(paramClass, null);
    AppMethodBeat.o(213311);
    return paramClass;
  }
  
  static final class a
  {
    final Map<h.a, List<b.b>> ZA;
    final Map<b.b, h.a> ZB;
    
    a(Map<b.b, h.a> paramMap)
    {
      AppMethodBeat.i(213259);
      this.ZB = paramMap;
      this.ZA = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        h.a locala = (h.a)localEntry.getValue();
        List localList = (List)this.ZA.get(locala);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.ZA.put(locala, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
      AppMethodBeat.o(213259);
    }
    
    static void a(List<b.b> paramList, l paraml, h.a parama, Object paramObject)
    {
      AppMethodBeat.i(213266);
      int i;
      if (paramList != null) {
        i = paramList.size() - 1;
      }
      for (;;)
      {
        if (i >= 0)
        {
          b.b localb = (b.b)paramList.get(i);
          try
          {
            switch (localb.ZC)
            {
            case 0: 
              localb.mMethod.invoke(paramObject, new Object[0]);
            }
          }
          catch (InvocationTargetException paramList)
          {
            paramList = new RuntimeException("Failed to call observer method", paramList.getCause());
            AppMethodBeat.o(213266);
            throw paramList;
            localb.mMethod.invoke(paramObject, new Object[] { paraml });
          }
          catch (IllegalAccessException paramList)
          {
            paramList = new RuntimeException(paramList);
            AppMethodBeat.o(213266);
            throw paramList;
          }
          localb.mMethod.invoke(paramObject, new Object[] { paraml, parama });
        }
        else
        {
          AppMethodBeat.o(213266);
          return;
        }
        i -= 1;
      }
    }
  }
  
  static final class b
  {
    final int ZC;
    final Method mMethod;
    
    b(int paramInt, Method paramMethod)
    {
      AppMethodBeat.i(213275);
      this.ZC = paramInt;
      this.mMethod = paramMethod;
      this.mMethod.setAccessible(true);
      AppMethodBeat.o(213275);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(213279);
      if (this == paramObject)
      {
        AppMethodBeat.o(213279);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(213279);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.ZC == paramObject.ZC) && (this.mMethod.getName().equals(paramObject.mMethod.getName())))
      {
        AppMethodBeat.o(213279);
        return true;
      }
      AppMethodBeat.o(213279);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(213283);
      int i = this.ZC;
      int j = this.mMethod.getName().hashCode();
      AppMethodBeat.o(213283);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.b
 * JD-Core Version:    0.7.0.1
 */