package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ClassesInfoCache
{
  static ClassesInfoCache bY = new ClassesInfoCache();
  private final Map<Class, CallbackInfo> bZ = new HashMap();
  private final Map<Class, Boolean> ca = new HashMap();
  
  private CallbackInfo a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = f((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((CallbackInfo)localObject1).cc);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = f(localObject1[i]).cc.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (MethodReference)((Map.Entry)localObject3).getKey(), (Lifecycle.Event)((Map.Entry)localObject3).getValue(), paramClass);
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
        break label339;
      }
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (OnLifecycleEvent)((Method)localObject1).getAnnotation(OnLifecycleEvent.class);
      if (localObject3 == null) {
        break label379;
      }
      localObject2 = ((Method)localObject1).getParameterTypes();
      if (localObject2.length <= 0) {
        break label382;
      }
      if (localObject2[0].isAssignableFrom(LifecycleOwner.class)) {
        break;
      }
      throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      paramArrayOfMethod = e(paramClass);
    }
    label339:
    label379:
    label382:
    for (i = 1;; i = 0)
    {
      localObject3 = ((OnLifecycleEvent)localObject3).value();
      if (localObject2.length > 1)
      {
        if (!localObject2[1].isAssignableFrom(Lifecycle.Event.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (localObject3 != Lifecycle.Event.ON_ANY) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject2.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a(localHashMap, new MethodReference(i, (Method)localObject1), (Lifecycle.Event)localObject3, paramClass);
      bool = true;
      for (;;)
      {
        j += 1;
        break;
        paramArrayOfMethod = new CallbackInfo(localHashMap);
        this.bZ.put(paramClass, paramArrayOfMethod);
        this.ca.put(paramClass, Boolean.valueOf(bool));
        return paramArrayOfMethod;
      }
    }
  }
  
  private static void a(Map<MethodReference, Lifecycle.Event> paramMap, MethodReference paramMethodReference, Lifecycle.Event paramEvent, Class paramClass)
  {
    Lifecycle.Event localEvent = (Lifecycle.Event)paramMap.get(paramMethodReference);
    if ((localEvent != null) && (paramEvent != localEvent))
    {
      paramMap = paramMethodReference.mMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localEvent + ", new value " + paramEvent);
    }
    if (localEvent == null) {
      paramMap.put(paramMethodReference, paramEvent);
    }
  }
  
  private static Method[] e(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  final boolean d(Class paramClass)
  {
    if (this.ca.containsKey(paramClass)) {
      return ((Boolean)this.ca.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = e(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((OnLifecycleEvent)arrayOfMethod[i].getAnnotation(OnLifecycleEvent.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.ca.put(paramClass, Boolean.FALSE);
    return false;
  }
  
  final CallbackInfo f(Class paramClass)
  {
    CallbackInfo localCallbackInfo = (CallbackInfo)this.bZ.get(paramClass);
    if (localCallbackInfo != null) {
      return localCallbackInfo;
    }
    return a(paramClass, null);
  }
  
  static class CallbackInfo
  {
    final Map<Lifecycle.Event, List<ClassesInfoCache.MethodReference>> cb;
    final Map<ClassesInfoCache.MethodReference, Lifecycle.Event> cc;
    
    CallbackInfo(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> paramMap)
    {
      this.cc = paramMap;
      this.cb = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Lifecycle.Event localEvent = (Lifecycle.Event)localEntry.getValue();
        List localList = (List)this.cb.get(localEvent);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.cb.put(localEvent, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
    }
    
    static void a(List<ClassesInfoCache.MethodReference> paramList, LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject)
    {
      int i;
      if (paramList != null) {
        i = paramList.size() - 1;
      }
      for (;;)
      {
        if (i >= 0)
        {
          ClassesInfoCache.MethodReference localMethodReference = (ClassesInfoCache.MethodReference)paramList.get(i);
          try
          {
            switch (localMethodReference.cd)
            {
            case 0: 
              localMethodReference.mMethod.invoke(paramObject, new Object[0]);
            }
          }
          catch (InvocationTargetException paramList)
          {
            throw new RuntimeException("Failed to call observer method", paramList.getCause());
            localMethodReference.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner });
          }
          catch (IllegalAccessException paramList)
          {
            throw new RuntimeException(paramList);
          }
          localMethodReference.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner, paramEvent });
        }
        else
        {
          return;
        }
        i -= 1;
      }
    }
  }
  
  static class MethodReference
  {
    final int cd;
    final Method mMethod;
    
    MethodReference(int paramInt, Method paramMethod)
    {
      this.cd = paramInt;
      this.mMethod = paramMethod;
      this.mMethod.setAccessible(true);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (MethodReference)paramObject;
      } while ((this.cd == paramObject.cd) && (this.mMethod.getName().equals(paramObject.mMethod.getName())));
      return false;
    }
    
    public int hashCode()
    {
      return this.cd * 31 + this.mMethod.getName().hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ClassesInfoCache
 * JD-Core Version:    0.7.0.1
 */