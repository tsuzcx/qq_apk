package com.tencent.mm.booter.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  /* Error */
  static java.lang.reflect.Field findField(java.lang.Class<?> paramClass, String paramString)
  {
    // Byte code:
    //   0: ldc 13
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 21
    //   7: ldc 23
    //   9: invokestatic 27	com/tencent/mm/booter/notification/b:uH	(Ljava/lang/String;)Ljava/lang/String;
    //   12: iconst_1
    //   13: anewarray 21	java/lang/Class
    //   16: dup
    //   17: iconst_0
    //   18: ldc 29
    //   20: aastore
    //   21: invokevirtual 33	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   24: astore_3
    //   25: aload_0
    //   26: astore_2
    //   27: aload_3
    //   28: aload_2
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: invokevirtual 39	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 41	java/lang/reflect/Field
    //   43: astore 4
    //   45: aload 4
    //   47: iconst_1
    //   48: invokevirtual 45	java/lang/reflect/Field:setAccessible	(Z)V
    //   51: ldc 13
    //   53: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload 4
    //   58: areturn
    //   59: astore_2
    //   60: new 50	java/lang/NoSuchFieldException
    //   63: dup
    //   64: new 52	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 54
    //   70: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: invokevirtual 62	java/lang/Class:getName	()Ljava/lang/String;
    //   77: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 68
    //   82: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokespecial 72	java/lang/NoSuchFieldException:<init>	(Ljava/lang/String;)V
    //   95: astore_0
    //   96: ldc 13
    //   98: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_0
    //   102: athrow
    //   103: astore_2
    //   104: new 50	java/lang/NoSuchFieldException
    //   107: dup
    //   108: new 52	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 74
    //   114: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: invokevirtual 62	java/lang/Class:getName	()Ljava/lang/String;
    //   121: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 68
    //   126: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 72	java/lang/NoSuchFieldException:<init>	(Ljava/lang/String;)V
    //   139: astore_0
    //   140: ldc 13
    //   142: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_0
    //   146: athrow
    //   147: astore 4
    //   149: aload 4
    //   151: invokevirtual 78	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   154: instanceof 50
    //   157: ifeq +78 -> 235
    //   160: aload_2
    //   161: invokevirtual 82	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   164: astore_2
    //   165: aload_2
    //   166: ldc 4
    //   168: if_acmpeq +7 -> 175
    //   171: aload_2
    //   172: ifnonnull +106 -> 278
    //   175: new 50	java/lang/NoSuchFieldException
    //   178: dup
    //   179: new 52	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   186: ldc 87
    //   188: invokestatic 27	com/tencent/mm/booter/notification/b:uH	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 89
    //   200: invokestatic 27	com/tencent/mm/booter/notification/b:uH	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: invokevirtual 62	java/lang/Class:getName	()Ljava/lang/String;
    //   210: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 91
    //   215: invokestatic 27	com/tencent/mm/booter/notification/b:uH	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokespecial 72	java/lang/NoSuchFieldException:<init>	(Ljava/lang/String;)V
    //   227: astore_0
    //   228: ldc 13
    //   230: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_0
    //   234: athrow
    //   235: new 50	java/lang/NoSuchFieldException
    //   238: dup
    //   239: new 52	java/lang/StringBuilder
    //   242: dup
    //   243: ldc 93
    //   245: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   248: aload_0
    //   249: invokevirtual 62	java/lang/Class:getName	()Ljava/lang/String;
    //   252: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 68
    //   257: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokespecial 72	java/lang/NoSuchFieldException:<init>	(Ljava/lang/String;)V
    //   270: astore_0
    //   271: ldc 13
    //   273: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_0
    //   277: athrow
    //   278: goto -251 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramClass	java.lang.Class<?>
    //   0	281	1	paramString	String
    //   26	3	2	localClass	java.lang.Class<?>
    //   59	1	2	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   103	58	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   164	8	2	localClass1	java.lang.Class
    //   24	4	3	localMethod	java.lang.reflect.Method
    //   43	14	4	localField	java.lang.reflect.Field
    //   147	3	4	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   5	25	59	java/lang/NoSuchMethodException
    //   27	51	103	java/lang/IllegalAccessException
    //   27	51	147	java/lang/reflect/InvocationTargetException
  }
  
  private static String uH(String paramString)
  {
    AppMethodBeat.i(186337);
    for (;;)
    {
      int m;
      int i;
      int k;
      try
      {
        m = paramString.length();
        Object localObject = null;
        i = 9;
        j = 0;
        k = 0;
        switch (i)
        {
        case 2: 
        case 4: 
        case 6: 
        case 8: 
        case 10: 
        case 12: 
        case 14: 
        case 16: 
        default: 
          paramString = new IllegalStateException();
          AppMethodBeat.o(186337);
          throw paramString;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(186337);
        return paramString;
      }
      paramString = localThrowable.toString();
      AppMethodBeat.o(186337);
      return paramString;
      if (k >= m) {
        i -= 2;
      }
      for (;;)
      {
        break;
        i += 2;
      }
      int j = (byte)paramString.charAt(k);
      i += 10;
      continue;
      i -= 4;
      k += 1;
      continue;
      StringBuilder localStringBuilder = new StringBuilder();
      i -= 6;
      continue;
      localStringBuilder.append((char)j);
      i -= 4;
      continue;
      j = (byte)(j ^ 0x3C);
      i += 4;
      continue;
      j = (byte)(k - m ^ j);
      i -= 2;
      continue;
      j = (byte)(j & 0xFF);
      i -= 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b
 * JD-Core Version:    0.7.0.1
 */