package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling
{
  private static Map<Class, Integer> cH = new HashMap();
  private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> cI = new HashMap();
  
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
    if (h((Class)localObject) == 2)
    {
      localObject = (List)cI.get(localObject);
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
  
  private static Constructor<? extends GeneratedAdapter> g(Class<?> paramClass)
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
  
  public static String getAdapterName(String paramString)
  {
    return paramString.replace(".", "_") + "_LifecycleAdapter";
  }
  
  private static int h(Class<?> paramClass)
  {
    if (cH.containsKey(paramClass)) {
      return ((Integer)cH.get(paramClass)).intValue();
    }
    int i = i(paramClass);
    cH.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static int i(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = g(paramClass);
    if (localObject1 != null)
    {
      cI.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (ClassesInfoCache.bY.d(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (j((Class)localObject2))
    {
      if (h((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)cI.get(localObject2));
    }
    localObject2 = paramClass.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      Class localClass = localObject2[i];
      if (!j(localClass)) {
        break label197;
      }
      if (h(localClass) == 1) {
        return 1;
      }
      if (localObject1 != null) {
        break label194;
      }
      localObject1 = new ArrayList();
      label148:
      ((List)localObject1).addAll((Collection)cI.get(localClass));
    }
    label194:
    label197:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 != null)
      {
        cI.put(paramClass, localObject1);
        return 2;
      }
      return 1;
      break label148;
    }
  }
  
  private static boolean j(Class<?> paramClass)
  {
    return (paramClass != null) && (LifecycleObserver.class.isAssignableFrom(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.Lifecycling
 * JD-Core Version:    0.7.0.1
 */