package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling
{
  private static Map<Class, Integer> cm = new HashMap();
  private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> cn = new HashMap();
  
  private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (GeneratedAdapter)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  static GenericLifecycleObserver e(Object paramObject)
  {
    if ((paramObject instanceof FullLifecycleObserver)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject);
    }
    if ((paramObject instanceof GenericLifecycleObserver)) {
      return (GenericLifecycleObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (g((Class)localObject) == 2)
    {
      localObject = (List)cn.get(localObject);
      if (((List)localObject).size() == 1) {
        return new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
      }
      GeneratedAdapter[] arrayOfGeneratedAdapter = new GeneratedAdapter[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfGeneratedAdapter[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfGeneratedAdapter);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static Constructor<? extends GeneratedAdapter> f(Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        localObject = paramClass.getPackage();
        String str = paramClass.getCanonicalName();
        if (localObject != null)
        {
          localObject = ((Package)localObject).getName();
          if (((String)localObject).isEmpty())
          {
            str = getAdapterName(str);
            if (((String)localObject).isEmpty())
            {
              localObject = str;
              paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
              if (paramClass.isAccessible()) {
                break label124;
              }
              paramClass.setAccessible(true);
              return paramClass;
            }
          }
          else
          {
            str = str.substring(((String)localObject).length() + 1);
            continue;
          }
          localObject = (String)localObject + "." + str;
          continue;
          return paramClass;
        }
      }
      catch (ClassNotFoundException paramClass)
      {
        return null;
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new RuntimeException(paramClass);
      }
      label124:
      Object localObject = "";
    }
  }
  
  private static int g(Class<?> paramClass)
  {
    int j = 0;
    if (cm.containsKey(paramClass)) {
      return ((Integer)cm.get(paramClass)).intValue();
    }
    Object localObject1;
    int i;
    boolean bool;
    label119:
    Object localObject2;
    int k;
    if (paramClass.getCanonicalName() != null)
    {
      localObject1 = f(paramClass);
      if (localObject1 != null)
      {
        cn.put(paramClass, Collections.singletonList(localObject1));
        i = 2;
        cm.put(paramClass, Integer.valueOf(i));
        return i;
      }
      localObject1 = ClassesInfoCache.bU;
      if (((ClassesInfoCache)localObject1).bW.containsKey(paramClass))
      {
        bool = ((Boolean)((ClassesInfoCache)localObject1).bW.get(paramClass)).booleanValue();
        if (bool) {
          break label352;
        }
        localObject2 = paramClass.getSuperclass();
        localObject1 = null;
        if (h((Class)localObject2))
        {
          if (g((Class)localObject2) == 1) {
            break label352;
          }
          localObject1 = new ArrayList((Collection)cn.get(localObject2));
        }
        localObject2 = paramClass.getInterfaces();
        k = localObject2.length;
        i = j;
        label184:
        if (i >= k) {
          break label330;
        }
        Class localClass = localObject2[i];
        if (!h(localClass)) {
          break label360;
        }
        if (g(localClass) == 1) {
          break label352;
        }
        if (localObject1 != null) {
          break label357;
        }
        localObject1 = new ArrayList();
        label226:
        ((List)localObject1).addAll((Collection)cn.get(localClass));
      }
    }
    label308:
    label330:
    label352:
    label357:
    label360:
    for (;;)
    {
      i += 1;
      break label184;
      localObject2 = ClassesInfoCache.d(paramClass);
      k = localObject2.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label308;
        }
        if ((OnLifecycleEvent)localObject2[i].getAnnotation(OnLifecycleEvent.class) != null)
        {
          ((ClassesInfoCache)localObject1).a(paramClass, (Method[])localObject2);
          bool = true;
          break;
        }
        i += 1;
      }
      ((ClassesInfoCache)localObject1).bW.put(paramClass, Boolean.valueOf(false));
      bool = false;
      break label119;
      if (localObject1 != null)
      {
        cn.put(paramClass, localObject1);
        i = 2;
        break;
      }
      i = 1;
      break;
      break label226;
    }
  }
  
  public static String getAdapterName(String paramString)
  {
    return paramString.replace(".", "_") + "_LifecycleAdapter";
  }
  
  private static boolean h(Class<?> paramClass)
  {
    return (paramClass != null) && (LifecycleObserver.class.isAssignableFrom(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.Lifecycling
 * JD-Core Version:    0.7.0.1
 */