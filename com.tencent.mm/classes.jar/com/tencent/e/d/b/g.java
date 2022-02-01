package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private static Boolean ahtM;
  private static final Object ahtN;
  
  static
  {
    AppMethodBeat.i(138374);
    ahtM = null;
    ahtN = new Object();
    AppMethodBeat.o(138374);
  }
  
  /* Error */
  public static boolean jXj()
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 24	com/tencent/e/d/b/g:ahtN	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: getstatic 19	com/tencent/e/d/b/g:ahtM	Ljava/lang/Boolean;
    //   16: ifnonnull +72 -> 88
    //   19: getstatic 39	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 17
    //   24: if_icmplt +132 -> 156
    //   27: new 41	java/io/File
    //   30: dup
    //   31: ldc 43
    //   33: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 49	java/io/File:exists	()Z
    //   39: istore_0
    //   40: iload_0
    //   41: ifeq +115 -> 156
    //   44: new 51	java/io/FileInputStream
    //   47: dup
    //   48: ldc 43
    //   50: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 58	java/io/InputStream:read	()I
    //   58: bipush 49
    //   60: if_icmpne +45 -> 105
    //   63: iconst_1
    //   64: istore_0
    //   65: aload_1
    //   66: invokestatic 64	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   69: iload_0
    //   70: invokestatic 70	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: ifnonnull +7 -> 84
    //   80: getstatic 73	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   83: astore_2
    //   84: aload_2
    //   85: putstatic 19	com/tencent/e/d/b/g:ahtM	Ljava/lang/Boolean;
    //   88: getstatic 19	com/tencent/e/d/b/g:ahtM	Ljava/lang/Boolean;
    //   91: invokevirtual 76	java/lang/Boolean:booleanValue	()Z
    //   94: istore_0
    //   95: aload 4
    //   97: monitorexit
    //   98: ldc 33
    //   100: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iload_0
    //   104: ireturn
    //   105: iconst_0
    //   106: istore_0
    //   107: goto -42 -> 65
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 64	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   117: aconst_null
    //   118: astore_1
    //   119: goto -45 -> 74
    //   122: aload_3
    //   123: invokestatic 64	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   126: ldc 33
    //   128: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload 4
    //   136: monitorexit
    //   137: ldc 33
    //   139: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: astore_2
    //   145: aload_1
    //   146: astore_3
    //   147: aload_2
    //   148: astore_1
    //   149: goto -27 -> 122
    //   152: astore_2
    //   153: goto -40 -> 113
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -84 -> 74
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_3
    //   164: goto -42 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	68	0	bool	boolean
    //   53	24	1	localObject1	Object
    //   110	1	1	localException1	java.lang.Exception
    //   112	20	1	localCloseable	java.io.Closeable
    //   133	13	1	localObject2	Object
    //   148	10	1	localObject3	Object
    //   161	1	1	localObject4	Object
    //   75	10	2	localObject5	Object
    //   144	4	2	localObject6	Object
    //   152	1	2	localException2	java.lang.Exception
    //   122	42	3	localObject7	Object
    //   8	127	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   44	54	110	java/lang/Exception
    //   13	40	133	finally
    //   65	74	133	finally
    //   80	84	133	finally
    //   84	88	133	finally
    //   88	98	133	finally
    //   113	117	133	finally
    //   122	133	133	finally
    //   54	63	144	finally
    //   54	63	152	java/lang/Exception
    //   44	54	161	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.b.g
 * JD-Core Version:    0.7.0.1
 */