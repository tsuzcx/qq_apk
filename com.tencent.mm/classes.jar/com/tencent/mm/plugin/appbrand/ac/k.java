package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(140843);
    paramClass = b(paramClass, paramString, paramObject, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(140843);
    return paramClass;
  }
  
  /* Error */
  private static <T> T b(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
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
    //   26: aload_2
    //   27: invokevirtual 37	java/lang/Object:getClass	()Ljava/lang/Class;
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 6
    //   35: aload 5
    //   37: ifnull +75 -> 112
    //   40: aload 5
    //   42: aload_1
    //   43: aload_3
    //   44: invokevirtual 43	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   47: astore 7
    //   49: aload 7
    //   51: astore 6
    //   53: aload 5
    //   55: invokevirtual 46	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   58: astore 5
    //   60: goto -25 -> 35
    //   63: astore 7
    //   65: aload 6
    //   67: astore 7
    //   69: aload_0
    //   70: aload 5
    //   72: if_acmpne +12 -> 84
    //   75: aload 5
    //   77: aload_1
    //   78: aload_3
    //   79: invokevirtual 43	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   82: astore 7
    //   84: aload 5
    //   86: invokevirtual 46	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: astore 5
    //   91: aload 7
    //   93: astore 6
    //   95: goto -60 -> 35
    //   98: astore_0
    //   99: aload 5
    //   101: invokevirtual 46	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   104: pop
    //   105: ldc 25
    //   107: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: athrow
    //   112: aload 6
    //   114: ifnonnull +10 -> 124
    //   117: ldc 25
    //   119: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aconst_null
    //   123: areturn
    //   124: aload 6
    //   126: iconst_1
    //   127: invokevirtual 52	java/lang/reflect/Method:setAccessible	(Z)V
    //   130: aload 6
    //   132: aload_2
    //   133: aload 4
    //   135: invokevirtual 56	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   138: astore_0
    //   139: ldc 25
    //   141: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: areturn
    //   146: astore_0
    //   147: ldc 58
    //   149: aload_0
    //   150: ldc 60
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: ldc 25
    //   161: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aconst_null
    //   165: areturn
    //   166: astore 7
    //   168: aload 6
    //   170: astore 7
    //   172: goto -88 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramClass	Class<?>
    //   0	175	1	paramString	String
    //   0	175	2	paramObject	Object
    //   0	175	3	paramArrayOfClass	Class<?>[]
    //   0	175	4	paramArrayOfObject	Object[]
    //   30	70	5	localClass	Class
    //   33	136	6	localObject1	Object
    //   47	3	7	localMethod	java.lang.reflect.Method
    //   63	1	7	localException1	java.lang.Exception
    //   67	25	7	localObject2	Object
    //   166	1	7	localException2	java.lang.Exception
    //   170	1	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	63	java/lang/Exception
    //   40	49	98	finally
    //   75	84	98	finally
    //   124	139	146	java/lang/Exception
    //   75	84	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.k
 * JD-Core Version:    0.7.0.1
 */