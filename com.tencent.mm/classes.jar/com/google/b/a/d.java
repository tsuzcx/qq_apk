package com.google.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d
{
  private static final Object dAR;
  private static final Method dAS;
  private static final Method dAT;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(208718);
    Object localObject1 = XQ();
    dAR = localObject1;
    if (localObject1 == null)
    {
      localObject1 = null;
      dAS = (Method)localObject1;
      if (dAR != null) {
        break label67;
      }
    }
    label67:
    for (localObject1 = localObject2;; localObject1 = XR())
    {
      dAT = (Method)localObject1;
      AppMethodBeat.o(208718);
      return;
      localObject1 = a("getStackTraceElement", new Class[] { Throwable.class, Integer.TYPE });
      break;
    }
  }
  
  /* Error */
  private static Object XQ()
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 57
    //   7: iconst_0
    //   8: aconst_null
    //   9: invokestatic 61	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   12: ldc 63
    //   14: iconst_0
    //   15: anewarray 35	java/lang/Class
    //   18: invokevirtual 66	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: aconst_null
    //   22: iconst_0
    //   23: anewarray 4	java/lang/Object
    //   26: invokevirtual 72	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore_0
    //   30: ldc 55
    //   32: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc 55
    //   40: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: athrow
    //   45: astore_0
    //   46: ldc 55
    //   48: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	7	0	localObject1	Object
    //   37	7	0	localThreadDeath	java.lang.ThreadDeath
    //   45	1	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	30	37	java/lang/ThreadDeath
    //   5	30	45	finally
  }
  
  private static Method XR()
  {
    AppMethodBeat.i(208710);
    try
    {
      Method localMethod = a("getStackTraceDepth", new Class[] { Throwable.class });
      if (localMethod == null)
      {
        AppMethodBeat.o(208710);
        return null;
      }
      localMethod.invoke(XQ(), new Object[] { new Throwable() });
      AppMethodBeat.o(208710);
      return localMethod;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(208710);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label61;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label61:
      break label61;
    }
  }
  
  /* Error */
  private static Method a(java.lang.String paramString, Class<?>... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 87
    //   7: iconst_0
    //   8: aconst_null
    //   9: invokestatic 61	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 66	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: astore_0
    //   18: ldc 85
    //   20: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: astore_0
    //   26: ldc 85
    //   28: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: athrow
    //   33: astore_0
    //   34: ldc 85
    //   36: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aconst_null
    //   40: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramString	java.lang.String
    //   0	41	1	paramVarArgs	Class<?>[]
    // Exception table:
    //   from	to	target	type
    //   5	18	25	java/lang/ThreadDeath
    //   5	18	33	finally
  }
  
  public static void n(Throwable paramThrowable)
  {
    AppMethodBeat.i(208702);
    b.checkNotNull(paramThrowable);
    if ((paramThrowable instanceof RuntimeException))
    {
      paramThrowable = (RuntimeException)paramThrowable;
      AppMethodBeat.o(208702);
      throw paramThrowable;
    }
    AppMethodBeat.o(208702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.d
 * JD-Core Version:    0.7.0.1
 */