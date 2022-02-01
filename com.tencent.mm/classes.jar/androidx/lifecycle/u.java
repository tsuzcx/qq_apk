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

public final class u
{
  private static Map<Class<?>, List<Constructor<? extends h>>> bHA;
  private static Map<Class<?>, Integer> bHz;
  
  static
  {
    AppMethodBeat.i(194429);
    bHz = new HashMap();
    bHA = new HashMap();
    AppMethodBeat.o(194429);
  }
  
  private static h a(Constructor<? extends h> paramConstructor, Object paramObject)
  {
    AppMethodBeat.i(194388);
    try
    {
      paramConstructor = (h)paramConstructor.newInstance(new Object[] { paramObject });
      AppMethodBeat.o(194388);
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      paramConstructor = new RuntimeException(paramConstructor);
      AppMethodBeat.o(194388);
      throw paramConstructor;
    }
    catch (InstantiationException paramConstructor)
    {
      paramConstructor = new RuntimeException(paramConstructor);
      AppMethodBeat.o(194388);
      throw paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      paramConstructor = new RuntimeException(paramConstructor);
      AppMethodBeat.o(194388);
      throw paramConstructor;
    }
  }
  
  static o aK(Object paramObject)
  {
    AppMethodBeat.i(194380);
    boolean bool1 = paramObject instanceof o;
    boolean bool2 = paramObject instanceof g;
    if ((bool1) && (bool2))
    {
      paramObject = new FullLifecycleObserverAdapter((g)paramObject, (o)paramObject);
      AppMethodBeat.o(194380);
      return paramObject;
    }
    if (bool2)
    {
      paramObject = new FullLifecycleObserverAdapter((g)paramObject, null);
      AppMethodBeat.o(194380);
      return paramObject;
    }
    if (bool1)
    {
      paramObject = (o)paramObject;
      AppMethodBeat.o(194380);
      return paramObject;
    }
    Object localObject = paramObject.getClass();
    if (n((Class)localObject) == 2)
    {
      localObject = (List)bHA.get(localObject);
      if (((List)localObject).size() == 1)
      {
        paramObject = new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
        AppMethodBeat.o(194380);
        return paramObject;
      }
      h[] arrayOfh = new h[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfh[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      paramObject = new CompositeGeneratedAdaptersObserver(arrayOfh);
      AppMethodBeat.o(194380);
      return paramObject;
    }
    paramObject = new ReflectiveGenericLifecycleObserver(paramObject);
    AppMethodBeat.o(194380);
    return paramObject;
  }
  
  /* Error */
  private static Constructor<? extends h> m(Class<?> paramClass)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 122	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 126	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +86 -> 102
    //   19: aload_1
    //   20: invokevirtual 131	java/lang/Package:getName	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 137	java/lang/String:isEmpty	()Z
    //   28: ifeq +80 -> 108
    //   31: new 139	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: ldc 142
    //   41: ldc 144
    //   43: invokevirtual 148	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   46: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 154
    //   51: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_2
    //   58: aload_1
    //   59: invokevirtual 137	java/lang/String:isEmpty	()Z
    //   62: ifeq +60 -> 122
    //   65: aload_2
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 161	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   71: iconst_1
    //   72: anewarray 118	java/lang/Class
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokevirtual 165	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 168	java/lang/reflect/Constructor:isAccessible	()Z
    //   87: ifne +8 -> 95
    //   90: aload_0
    //   91: iconst_1
    //   92: invokevirtual 172	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   95: ldc 116
    //   97: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: ldc 174
    //   104: astore_1
    //   105: goto -81 -> 24
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 177	java/lang/String:length	()I
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: astore_2
    //   119: goto -88 -> 31
    //   122: new 139	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 142
    //   135: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_1
    //   146: goto -79 -> 67
    //   149: astore_0
    //   150: ldc 116
    //   152: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: new 52	java/lang/RuntimeException
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 55	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   166: astore_0
    //   167: ldc 116
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
  
  private static int n(Class<?> paramClass)
  {
    AppMethodBeat.i(194404);
    Integer localInteger = (Integer)bHz.get(paramClass);
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(194404);
      return i;
    }
    int i = o(paramClass);
    bHz.put(paramClass, Integer.valueOf(i));
    AppMethodBeat.o(194404);
    return i;
  }
  
  private static int o(Class<?> paramClass)
  {
    AppMethodBeat.i(194415);
    if (paramClass.getCanonicalName() == null)
    {
      AppMethodBeat.o(194415);
      return 1;
    }
    Object localObject1 = m(paramClass);
    if (localObject1 != null)
    {
      bHA.put(paramClass, Collections.singletonList(localObject1));
      AppMethodBeat.o(194415);
      return 2;
    }
    if (b.bGQ.j(paramClass))
    {
      AppMethodBeat.o(194415);
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (p((Class)localObject2))
    {
      if (n((Class)localObject2) == 1)
      {
        AppMethodBeat.o(194415);
        return 1;
      }
      localObject1 = new ArrayList((Collection)bHA.get(localObject2));
    }
    localObject2 = paramClass.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      Class localClass = localObject2[i];
      if (!p(localClass)) {
        break label237;
      }
      if (n(localClass) == 1)
      {
        AppMethodBeat.o(194415);
        return 1;
      }
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = new ArrayList();
      label178:
      ((List)localObject1).addAll((Collection)bHA.get(localClass));
    }
    label234:
    label237:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 != null)
      {
        bHA.put(paramClass, localObject1);
        AppMethodBeat.o(194415);
        return 2;
      }
      AppMethodBeat.o(194415);
      return 1;
      break label178;
    }
  }
  
  private static boolean p(Class<?> paramClass)
  {
    AppMethodBeat.i(194422);
    if ((paramClass != null) && (p.class.isAssignableFrom(paramClass)))
    {
      AppMethodBeat.o(194422);
      return true;
    }
    AppMethodBeat.o(194422);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.u
 * JD-Core Version:    0.7.0.1
 */