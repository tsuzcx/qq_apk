package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(91170);
    paramClass = a(paramClass, paramString, paramObject, paramArrayOfClass, paramArrayOfObject, null);
    AppMethodBeat.o(91170);
    return paramClass;
  }
  
  /* Error */
  public static <T> T a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, T paramT)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnonnull +20 -> 26
    //   9: new 27	java/lang/IllegalArgumentException
    //   12: dup
    //   13: ldc 29
    //   15: invokespecial 33	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: ldc 25
    //   21: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: athrow
    //   26: aconst_null
    //   27: astore 7
    //   29: aload_2
    //   30: invokevirtual 37	java/lang/Object:getClass	()Ljava/lang/Class;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +75 -> 112
    //   40: aload 6
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 43	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   47: astore 8
    //   49: aload 8
    //   51: astore 7
    //   53: aload 6
    //   55: invokevirtual 46	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   58: astore 6
    //   60: goto -25 -> 35
    //   63: astore 8
    //   65: aload 7
    //   67: astore 8
    //   69: aload_0
    //   70: aload 6
    //   72: if_acmpne +12 -> 84
    //   75: aload 6
    //   77: aload_1
    //   78: aload_3
    //   79: invokevirtual 43	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   82: astore 8
    //   84: aload 6
    //   86: invokevirtual 46	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: astore 6
    //   91: aload 8
    //   93: astore 7
    //   95: goto -60 -> 35
    //   98: astore_0
    //   99: aload 6
    //   101: invokevirtual 46	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   104: pop
    //   105: ldc 25
    //   107: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: athrow
    //   112: aload 7
    //   114: ifnonnull +11 -> 125
    //   117: ldc 25
    //   119: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload 5
    //   124: areturn
    //   125: aload 7
    //   127: iconst_1
    //   128: invokevirtual 52	java/lang/reflect/Method:setAccessible	(Z)V
    //   131: aload 7
    //   133: aload_2
    //   134: aload 4
    //   136: invokevirtual 56	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   139: astore_0
    //   140: ldc 25
    //   142: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_0
    //   146: areturn
    //   147: astore_0
    //   148: ldc 58
    //   150: aload_0
    //   151: ldc 60
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 66	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: ldc 25
    //   162: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 5
    //   167: areturn
    //   168: astore 8
    //   170: aload 7
    //   172: astore 8
    //   174: goto -90 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramClass	Class<?>
    //   0	177	1	paramString	String
    //   0	177	2	paramObject	Object
    //   0	177	3	paramArrayOfClass	Class<?>[]
    //   0	177	4	paramArrayOfObject	Object[]
    //   0	177	5	paramT	T
    //   33	67	6	localClass	Class
    //   27	144	7	localObject1	Object
    //   47	3	8	localMethod	java.lang.reflect.Method
    //   63	1	8	localException1	java.lang.Exception
    //   67	25	8	localObject2	Object
    //   168	1	8	localException2	java.lang.Exception
    //   172	1	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	63	java/lang/Exception
    //   40	49	98	finally
    //   75	84	98	finally
    //   125	140	147	java/lang/Exception
    //   75	84	168	java/lang/Exception
  }
  
  public static <T> T a(String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(91172);
    paramString = a(null, paramString, paramObject, paramArrayOfClass, paramArrayOfObject, null);
    AppMethodBeat.o(91172);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.l
 * JD-Core Version:    0.7.0.1
 */