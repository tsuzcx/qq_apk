package com.tencent.d.d.b;

public final class f
{
  private static Boolean wMV = null;
  private static final Object wMW = new Object();
  
  /* Error */
  public static boolean cOM()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: getstatic 17	com/tencent/d/d/b/f:wMW	Ljava/lang/Object;
    //   5: astore 5
    //   7: aload 5
    //   9: monitorenter
    //   10: getstatic 12	com/tencent/d/d/b/f:wMV	Ljava/lang/Boolean;
    //   13: ifnonnull +73 -> 86
    //   16: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   19: bipush 17
    //   21: if_icmplt +112 -> 133
    //   24: new 30	java/io/File
    //   27: dup
    //   28: ldc 32
    //   30: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 38	java/io/File:exists	()Z
    //   36: istore_1
    //   37: iload_1
    //   38: ifeq +95 -> 133
    //   41: new 40	java/io/FileInputStream
    //   44: dup
    //   45: ldc 32
    //   47: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 47	java/io/InputStream:read	()I
    //   55: bipush 49
    //   57: if_icmpne +5 -> 62
    //   60: iconst_1
    //   61: istore_0
    //   62: aload_2
    //   63: invokestatic 53	com/tencent/d/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   66: iload_0
    //   67: invokestatic 59	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: astore_2
    //   71: aload_2
    //   72: astore_3
    //   73: aload_2
    //   74: ifnonnull +8 -> 82
    //   77: iconst_0
    //   78: invokestatic 59	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: astore_3
    //   82: aload_3
    //   83: putstatic 12	com/tencent/d/d/b/f:wMV	Ljava/lang/Boolean;
    //   86: getstatic 12	com/tencent/d/d/b/f:wMV	Ljava/lang/Boolean;
    //   89: invokevirtual 62	java/lang/Boolean:booleanValue	()Z
    //   92: istore_0
    //   93: aload 5
    //   95: monitorexit
    //   96: iload_0
    //   97: ireturn
    //   98: aload_2
    //   99: invokestatic 53	com/tencent/d/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   102: aconst_null
    //   103: astore_2
    //   104: goto -33 -> 71
    //   107: aload 4
    //   109: invokestatic 53	com/tencent/d/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   112: aload_2
    //   113: athrow
    //   114: astore_2
    //   115: aload 5
    //   117: monitorexit
    //   118: aload_2
    //   119: athrow
    //   120: astore_3
    //   121: aload_2
    //   122: astore 4
    //   124: aload_3
    //   125: astore_2
    //   126: goto -19 -> 107
    //   129: astore_3
    //   130: goto -32 -> 98
    //   133: aconst_null
    //   134: astore_2
    //   135: goto -64 -> 71
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_2
    //   141: goto -43 -> 98
    //   144: astore_2
    //   145: aconst_null
    //   146: astore 4
    //   148: goto -41 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	96	0	bool1	boolean
    //   36	2	1	bool2	boolean
    //   50	63	2	localObject1	Object
    //   114	8	2	localObject2	Object
    //   125	10	2	localObject3	Object
    //   138	1	2	localException1	java.lang.Exception
    //   140	1	2	localObject4	Object
    //   144	1	2	localObject5	Object
    //   72	11	3	localObject6	Object
    //   120	5	3	localObject7	Object
    //   129	1	3	localException2	java.lang.Exception
    //   107	40	4	localObject8	Object
    //   5	111	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   10	37	114	finally
    //   62	71	114	finally
    //   77	82	114	finally
    //   82	86	114	finally
    //   86	96	114	finally
    //   98	102	114	finally
    //   107	114	114	finally
    //   115	118	114	finally
    //   51	60	120	finally
    //   51	60	129	java/lang/Exception
    //   41	51	138	java/lang/Exception
    //   41	51	144	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.d.d.b.f
 * JD-Core Version:    0.7.0.1
 */