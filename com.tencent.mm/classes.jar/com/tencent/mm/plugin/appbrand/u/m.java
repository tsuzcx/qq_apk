package com.tencent.mm.plugin.appbrand.u;

public final class m
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    return a(paramClass, paramString, paramObject, paramArrayOfClass, paramArrayOfObject, null);
  }
  
  /* Error */
  public static <T> T a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, T paramT)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +13 -> 14
    //   4: new 16	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 18
    //   10: invokespecial 22	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore 7
    //   17: aload_2
    //   18: invokevirtual 26	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnull +70 -> 95
    //   28: aload 6
    //   30: aload_1
    //   31: aload_3
    //   32: invokevirtual 32	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   35: astore 8
    //   37: aload 8
    //   39: astore 7
    //   41: aload 6
    //   43: invokevirtual 35	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   46: astore 6
    //   48: goto -25 -> 23
    //   51: astore 8
    //   53: aload 7
    //   55: astore 8
    //   57: aload_0
    //   58: aload 6
    //   60: if_acmpne +12 -> 72
    //   63: aload 6
    //   65: aload_1
    //   66: aload_3
    //   67: invokevirtual 32	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore 8
    //   72: aload 6
    //   74: invokevirtual 35	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   77: astore 6
    //   79: aload 8
    //   81: astore 7
    //   83: goto -60 -> 23
    //   86: astore_0
    //   87: aload 6
    //   89: invokevirtual 35	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   92: pop
    //   93: aload_0
    //   94: athrow
    //   95: aload 7
    //   97: ifnonnull +6 -> 103
    //   100: aload 5
    //   102: areturn
    //   103: aload 7
    //   105: iconst_1
    //   106: invokevirtual 41	java/lang/reflect/Method:setAccessible	(Z)V
    //   109: aload 7
    //   111: aload_2
    //   112: aload 4
    //   114: invokevirtual 45	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   117: astore_0
    //   118: aload_0
    //   119: areturn
    //   120: astore_0
    //   121: ldc 47
    //   123: aload_0
    //   124: ldc 49
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 55	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 5
    //   135: areturn
    //   136: astore 8
    //   138: aload 7
    //   140: astore 8
    //   142: goto -70 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramClass	Class<?>
    //   0	145	1	paramString	String
    //   0	145	2	paramObject	Object
    //   0	145	3	paramArrayOfClass	Class<?>[]
    //   0	145	4	paramArrayOfObject	Object[]
    //   0	145	5	paramT	T
    //   21	67	6	localClass	Class
    //   15	124	7	localObject1	Object
    //   35	3	8	localMethod	java.lang.reflect.Method
    //   51	1	8	localException1	java.lang.Exception
    //   55	25	8	localObject2	Object
    //   136	1	8	localException2	java.lang.Exception
    //   140	1	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	51	java/lang/Exception
    //   28	37	86	finally
    //   63	72	86	finally
    //   103	118	120	java/lang/Exception
    //   63	72	136	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.m
 * JD-Core Version:    0.7.0.1
 */