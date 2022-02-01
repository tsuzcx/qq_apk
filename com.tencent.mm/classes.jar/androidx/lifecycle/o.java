package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o
{
  private static Map<Class<?>, Integer> aaf;
  private static Map<Class<?>, List<Constructor<? extends f>>> aag;
  
  static
  {
    AppMethodBeat.i(213399);
    aaf = new HashMap();
    aag = new HashMap();
    AppMethodBeat.o(213399);
  }
  
  @Deprecated
  static g K(Object paramObject)
  {
    AppMethodBeat.i(213386);
    boolean bool1 = paramObject instanceof j;
    boolean bool2 = paramObject instanceof e;
    if ((bool1) && (bool2)) {
      paramObject = new FullLifecycleObserverAdapter((e)paramObject, (j)paramObject);
    }
    for (;;)
    {
      paramObject = new Lifecycling.1(paramObject);
      AppMethodBeat.o(213386);
      return paramObject;
      if (bool2)
      {
        paramObject = new FullLifecycleObserverAdapter((e)paramObject, null);
      }
      else if (bool1)
      {
        paramObject = (j)paramObject;
      }
      else
      {
        Object localObject = paramObject.getClass();
        if (f((Class)localObject) == 2)
        {
          localObject = (List)aag.get(localObject);
          if (((List)localObject).size() == 1)
          {
            paramObject = new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
          }
          else
          {
            f[] arrayOff = new f[((List)localObject).size()];
            int i = 0;
            while (i < ((List)localObject).size())
            {
              arrayOff[i] = a((Constructor)((List)localObject).get(i), paramObject);
              i += 1;
            }
            paramObject = new CompositeGeneratedAdaptersObserver(arrayOff);
          }
        }
        else
        {
          paramObject = new ReflectiveGenericLifecycleObserver(paramObject);
        }
      }
    }
  }
  
  private static f a(Constructor<? extends f> paramConstructor, Object paramObject)
  {
    AppMethodBeat.i(213388);
    try
    {
      paramConstructor = (f)paramConstructor.newInstance(new Object[] { paramObject });
      AppMethodBeat.o(213388);
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      paramConstructor = new RuntimeException(paramConstructor);
      AppMethodBeat.o(213388);
      throw paramConstructor;
    }
    catch (InstantiationException paramConstructor)
    {
      paramConstructor = new RuntimeException(paramConstructor);
      AppMethodBeat.o(213388);
      throw paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      paramConstructor = new RuntimeException(paramConstructor);
      AppMethodBeat.o(213388);
      throw paramConstructor;
    }
  }
  
  /* Error */
  private static Constructor<? extends f> e(Class<?> paramClass)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 127	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 131	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +86 -> 102
    //   19: aload_1
    //   20: invokevirtual 136	java/lang/Package:getName	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 142	java/lang/String:isEmpty	()Z
    //   28: ifeq +80 -> 108
    //   31: new 144	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: ldc 147
    //   41: ldc 149
    //   43: invokevirtual 153	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   46: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 159
    //   51: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_2
    //   58: aload_1
    //   59: invokevirtual 142	java/lang/String:isEmpty	()Z
    //   62: ifeq +60 -> 122
    //   65: aload_2
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 166	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   71: iconst_1
    //   72: anewarray 123	java/lang/Class
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokevirtual 170	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 173	java/lang/reflect/Constructor:isAccessible	()Z
    //   87: ifne +8 -> 95
    //   90: aload_0
    //   91: iconst_1
    //   92: invokevirtual 177	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   95: ldc 121
    //   97: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: ldc 179
    //   104: astore_1
    //   105: goto -81 -> 24
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 182	java/lang/String:length	()I
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 186	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: astore_2
    //   119: goto -88 -> 31
    //   122: new 144	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 147
    //   135: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_1
    //   146: goto -79 -> 67
    //   149: astore_0
    //   150: ldc 121
    //   152: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: new 109	java/lang/RuntimeException
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 112	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   166: astore_0
    //   167: ldc 121
    //   169: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_0
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramClass	Class<?>
    //   9	137	1	localObject	Object
    //   14	125	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   5	15	149	java/lang/ClassNotFoundException
    //   19	24	149	java/lang/ClassNotFoundException
    //   24	31	149	java/lang/ClassNotFoundException
    //   31	65	149	java/lang/ClassNotFoundException
    //   67	95	149	java/lang/ClassNotFoundException
    //   108	119	149	java/lang/ClassNotFoundException
    //   122	146	149	java/lang/ClassNotFoundException
    //   5	15	157	java/lang/NoSuchMethodException
    //   19	24	157	java/lang/NoSuchMethodException
    //   24	31	157	java/lang/NoSuchMethodException
    //   31	65	157	java/lang/NoSuchMethodException
    //   67	95	157	java/lang/NoSuchMethodException
    //   108	119	157	java/lang/NoSuchMethodException
    //   122	146	157	java/lang/NoSuchMethodException
  }
  
  private static int f(Class<?> paramClass)
  {
    AppMethodBeat.i(213393);
    Integer localInteger = (Integer)aaf.get(paramClass);
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(213393);
      return i;
    }
    int i = g(paramClass);
    aaf.put(paramClass, Integer.valueOf(i));
    AppMethodBeat.o(213393);
    return i;
  }
  
  private static int g(Class<?> paramClass)
  {
    AppMethodBeat.i(213395);
    if (paramClass.getCanonicalName() == null)
    {
      AppMethodBeat.o(213395);
      return 1;
    }
    Object localObject1 = e(paramClass);
    if (localObject1 != null)
    {
      aag.put(paramClass, Collections.singletonList(localObject1));
      AppMethodBeat.o(213395);
      return 2;
    }
    if (b.Zx.b(paramClass))
    {
      AppMethodBeat.o(213395);
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (h((Class)localObject2))
    {
      if (f((Class)localObject2) == 1)
      {
        AppMethodBeat.o(213395);
        return 1;
      }
      localObject1 = new ArrayList((Collection)aag.get(localObject2));
    }
    localObject2 = paramClass.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      Class localClass = localObject2[i];
      if (!h(localClass)) {
        break label237;
      }
      if (f(localClass) == 1)
      {
        AppMethodBeat.o(213395);
        return 1;
      }
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = new ArrayList();
      label178:
      ((List)localObject1).addAll((Collection)aag.get(localClass));
    }
    label234:
    label237:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 != null)
      {
        aag.put(paramClass, localObject1);
        AppMethodBeat.o(213395);
        return 2;
      }
      AppMethodBeat.o(213395);
      return 1;
      break label178;
    }
  }
  
  private static boolean h(Class<?> paramClass)
  {
    AppMethodBeat.i(213397);
    if ((paramClass != null) && (k.class.isAssignableFrom(paramClass)))
    {
      AppMethodBeat.o(213397);
      return true;
    }
    AppMethodBeat.o(213397);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.o
 * JD-Core Version:    0.7.0.1
 */