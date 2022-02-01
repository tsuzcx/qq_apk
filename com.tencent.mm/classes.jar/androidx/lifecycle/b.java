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
  static b bGQ;
  private final Map<Class<?>, a> BY;
  private final Map<Class<?>, Boolean> bGR;
  
  static
  {
    AppMethodBeat.i(194435);
    bGQ = new b();
    AppMethodBeat.o(194435);
  }
  
  b()
  {
    AppMethodBeat.i(194400);
    this.BY = new HashMap();
    this.bGR = new HashMap();
    AppMethodBeat.o(194400);
  }
  
  private a a(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    AppMethodBeat.i(194432);
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = l((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((a)localObject1).bGT);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = l(localObject1[i]).bGT.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (b)((Map.Entry)localObject3).getKey(), (j.a)((Map.Entry)localObject3).getValue(), paramClass);
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
      localObject3 = (z)((Method)localObject1).getAnnotation(z.class);
      if (localObject3 == null) {
        break label417;
      }
      localObject2 = ((Method)localObject1).getParameterTypes();
      if (localObject2.length <= 0) {
        break label420;
      }
      if (localObject2[0].isAssignableFrom(q.class)) {
        break;
      }
      paramClass = new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      AppMethodBeat.o(194432);
      throw paramClass;
      paramArrayOfMethod = k(paramClass);
    }
    label417:
    label420:
    for (i = 1;; i = 0)
    {
      localObject3 = ((z)localObject3).Ho();
      if (localObject2.length > 1)
      {
        if (!localObject2[1].isAssignableFrom(j.a.class))
        {
          paramClass = new IllegalArgumentException("invalid parameter type. second arg must be an event");
          AppMethodBeat.o(194432);
          throw paramClass;
        }
        if (localObject3 != j.a.ON_ANY)
        {
          paramClass = new IllegalArgumentException("Second arg is supported only for ON_ANY value");
          AppMethodBeat.o(194432);
          throw paramClass;
        }
        i = 2;
      }
      if (localObject2.length > 2)
      {
        paramClass = new IllegalArgumentException("cannot have more than 2 params");
        AppMethodBeat.o(194432);
        throw paramClass;
      }
      a(localHashMap, new b(i, (Method)localObject1), (j.a)localObject3, paramClass);
      bool = true;
      for (;;)
      {
        j += 1;
        break;
        label372:
        paramArrayOfMethod = new a(localHashMap);
        this.BY.put(paramClass, paramArrayOfMethod);
        this.bGR.put(paramClass, Boolean.valueOf(bool));
        AppMethodBeat.o(194432);
        return paramArrayOfMethod;
      }
    }
  }
  
  private static void a(Map<b, j.a> paramMap, b paramb, j.a parama, Class<?> paramClass)
  {
    AppMethodBeat.i(194417);
    j.a locala = (j.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      paramMap = paramb.mMethod;
      paramMap = new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + locala + ", new value " + parama);
      AppMethodBeat.o(194417);
      throw paramMap;
    }
    if (locala == null) {
      paramMap.put(paramb, parama);
    }
    AppMethodBeat.o(194417);
  }
  
  private static Method[] k(Class<?> paramClass)
  {
    AppMethodBeat.i(194407);
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      AppMethodBeat.o(194407);
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      paramClass = new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
      AppMethodBeat.o(194407);
      throw paramClass;
    }
  }
  
  final boolean j(Class<?> paramClass)
  {
    AppMethodBeat.i(194445);
    Object localObject = (Boolean)this.bGR.get(paramClass);
    if (localObject != null)
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(194445);
      return bool;
    }
    localObject = k(paramClass);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((z)localObject[i].getAnnotation(z.class) != null)
      {
        a(paramClass, (Method[])localObject);
        AppMethodBeat.o(194445);
        return true;
      }
      i += 1;
    }
    this.bGR.put(paramClass, Boolean.FALSE);
    AppMethodBeat.o(194445);
    return false;
  }
  
  final a l(Class<?> paramClass)
  {
    AppMethodBeat.i(194454);
    a locala = (a)this.BY.get(paramClass);
    if (locala != null)
    {
      AppMethodBeat.o(194454);
      return locala;
    }
    paramClass = a(paramClass, null);
    AppMethodBeat.o(194454);
    return paramClass;
  }
  
  static final class a
  {
    final Map<j.a, List<b.b>> bGS;
    final Map<b.b, j.a> bGT;
    
    a(Map<b.b, j.a> paramMap)
    {
      AppMethodBeat.i(194462);
      this.bGT = paramMap;
      this.bGS = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        j.a locala = (j.a)localEntry.getValue();
        List localList = (List)this.bGS.get(locala);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.bGS.put(locala, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
      AppMethodBeat.o(194462);
    }
    
    static void a(List<b.b> paramList, q paramq, j.a parama, Object paramObject)
    {
      AppMethodBeat.i(194476);
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
            switch (localb.bGU)
            {
            case 0: 
              localb.mMethod.invoke(paramObject, new Object[0]);
            }
          }
          catch (InvocationTargetException paramList)
          {
            paramList = new RuntimeException("Failed to call observer method", paramList.getCause());
            AppMethodBeat.o(194476);
            throw paramList;
            localb.mMethod.invoke(paramObject, new Object[] { paramq });
          }
          catch (IllegalAccessException paramList)
          {
            paramList = new RuntimeException(paramList);
            AppMethodBeat.o(194476);
            throw paramList;
          }
          localb.mMethod.invoke(paramObject, new Object[] { paramq, parama });
        }
        else
        {
          AppMethodBeat.o(194476);
          return;
        }
        i -= 1;
      }
    }
  }
  
  static final class b
  {
    final int bGU;
    final Method mMethod;
    
    b(int paramInt, Method paramMethod)
    {
      AppMethodBeat.i(194471);
      this.bGU = paramInt;
      this.mMethod = paramMethod;
      this.mMethod.setAccessible(true);
      AppMethodBeat.o(194471);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194480);
      if (this == paramObject)
      {
        AppMethodBeat.o(194480);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(194480);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.bGU == paramObject.bGU) && (this.mMethod.getName().equals(paramObject.mMethod.getName())))
      {
        AppMethodBeat.o(194480);
        return true;
      }
      AppMethodBeat.o(194480);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(194488);
      int i = this.bGU;
      int j = this.mMethod.getName().hashCode();
      AppMethodBeat.o(194488);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.b
 * JD-Core Version:    0.7.0.1
 */