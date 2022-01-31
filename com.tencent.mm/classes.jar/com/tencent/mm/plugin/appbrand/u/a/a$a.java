package com.tencent.mm.plugin.appbrand.u.a;

final class a$a
  implements Runnable
{
  volatile boolean isStop = false;
  
  private a$a(a parama) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 22	com/tencent/mm/plugin/appbrand/u/a/a$a:isStop	Z
    //   9: ifne +218 -> 227
    //   12: invokestatic 46	java/lang/Thread:interrupted	()Z
    //   15: ifne +212 -> 227
    //   18: aload_0
    //   19: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   22: getfield 50	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   25: getfield 56	com/tencent/mm/plugin/appbrand/u/c:iYM	Ljava/util/concurrent/BlockingQueue;
    //   28: invokeinterface 61 1 0
    //   33: ifne +189 -> 222
    //   36: iconst_1
    //   37: istore_1
    //   38: iload_1
    //   39: ifeq -34 -> 5
    //   42: aload_0
    //   43: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   46: getfield 50	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   49: getfield 56	com/tencent/mm/plugin/appbrand/u/c:iYM	Ljava/util/concurrent/BlockingQueue;
    //   52: ldc2_w 62
    //   55: getstatic 69	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   58: invokeinterface 73 4 0
    //   63: checkcast 75	java/nio/ByteBuffer
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull -63 -> 5
    //   71: aload_0
    //   72: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   75: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   78: aload_2
    //   79: invokevirtual 83	java/nio/ByteBuffer:array	()[B
    //   82: iconst_0
    //   83: aload_2
    //   84: invokevirtual 87	java/nio/ByteBuffer:limit	()I
    //   87: invokevirtual 93	java/io/OutputStream:write	([BII)V
    //   90: aload_0
    //   91: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   94: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   97: invokevirtual 96	java/io/OutputStream:flush	()V
    //   100: goto -95 -> 5
    //   103: astore_2
    //   104: aload_0
    //   105: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   108: getfield 50	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   111: getfield 56	com/tencent/mm/plugin/appbrand/u/c:iYM	Ljava/util/concurrent/BlockingQueue;
    //   114: invokeinterface 100 1 0
    //   119: astore_2
    //   120: aload_2
    //   121: invokeinterface 105 1 0
    //   126: ifeq +101 -> 227
    //   129: aload_2
    //   130: invokeinterface 109 1 0
    //   135: checkcast 75	java/nio/ByteBuffer
    //   138: astore_3
    //   139: aload_0
    //   140: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   143: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   146: aload_3
    //   147: invokevirtual 83	java/nio/ByteBuffer:array	()[B
    //   150: iconst_0
    //   151: aload_3
    //   152: invokevirtual 87	java/nio/ByteBuffer:limit	()I
    //   155: invokevirtual 93	java/io/OutputStream:write	([BII)V
    //   158: aload_0
    //   159: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   162: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   165: invokevirtual 96	java/io/OutputStream:flush	()V
    //   168: goto -48 -> 120
    //   171: astore_2
    //   172: aload_0
    //   173: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   176: aload_2
    //   177: invokestatic 112	com/tencent/mm/plugin/appbrand/u/a/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a/a;Ljava/lang/Exception;)V
    //   180: ldc 114
    //   182: aload_2
    //   183: ldc 116
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: ldc 114
    //   194: ldc 124
    //   196: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   203: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   206: invokevirtual 131	java/io/OutputStream:close	()V
    //   209: aload_0
    //   210: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   213: invokestatic 133	com/tencent/mm/plugin/appbrand/u/a/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a/a;)V
    //   216: ldc 34
    //   218: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: iconst_0
    //   223: istore_1
    //   224: goto -186 -> 38
    //   227: ldc 114
    //   229: ldc 124
    //   231: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   238: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   241: invokevirtual 131	java/io/OutputStream:close	()V
    //   244: aload_0
    //   245: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   248: invokestatic 133	com/tencent/mm/plugin/appbrand/u/a/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a/a;)V
    //   251: ldc 34
    //   253: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    //   257: astore_2
    //   258: aload_0
    //   259: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   262: aload_2
    //   263: invokestatic 112	com/tencent/mm/plugin/appbrand/u/a/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a/a;Ljava/lang/Exception;)V
    //   266: ldc 114
    //   268: aload_2
    //   269: ldc 138
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: ldc 114
    //   280: ldc 124
    //   282: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   289: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   292: invokevirtual 131	java/io/OutputStream:close	()V
    //   295: aload_0
    //   296: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   299: invokestatic 133	com/tencent/mm/plugin/appbrand/u/a/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a/a;)V
    //   302: ldc 34
    //   304: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: return
    //   308: astore_2
    //   309: ldc 114
    //   311: ldc 124
    //   313: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   320: getfield 79	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   323: invokevirtual 131	java/io/OutputStream:close	()V
    //   326: aload_0
    //   327: getfield 17	com/tencent/mm/plugin/appbrand/u/a/a$a:iZl	Lcom/tencent/mm/plugin/appbrand/u/a/a;
    //   330: invokestatic 133	com/tencent/mm/plugin/appbrand/u/a/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a/a;)V
    //   333: ldc 34
    //   335: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_2
    //   339: athrow
    //   340: astore_3
    //   341: goto -15 -> 326
    //   344: astore_2
    //   345: goto -50 -> 295
    //   348: astore_2
    //   349: goto -140 -> 209
    //   352: astore_2
    //   353: goto -109 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	a
    //   37	187	1	i	int
    //   66	18	2	localByteBuffer1	java.nio.ByteBuffer
    //   103	1	2	localInterruptedException	java.lang.InterruptedException
    //   119	11	2	localIterator	java.util.Iterator
    //   171	12	2	localIOException1	java.io.IOException
    //   257	12	2	localException	java.lang.Exception
    //   308	31	2	localObject	Object
    //   344	1	2	localIOException2	java.io.IOException
    //   348	1	2	localIOException3	java.io.IOException
    //   352	1	2	localIOException4	java.io.IOException
    //   138	14	3	localByteBuffer2	java.nio.ByteBuffer
    //   340	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   5	36	103	java/lang/InterruptedException
    //   42	67	103	java/lang/InterruptedException
    //   71	100	103	java/lang/InterruptedException
    //   5	36	171	java/io/IOException
    //   42	67	171	java/io/IOException
    //   71	100	171	java/io/IOException
    //   104	120	171	java/io/IOException
    //   120	168	171	java/io/IOException
    //   5	36	257	java/lang/Exception
    //   42	67	257	java/lang/Exception
    //   71	100	257	java/lang/Exception
    //   104	120	257	java/lang/Exception
    //   120	168	257	java/lang/Exception
    //   5	36	308	finally
    //   42	67	308	finally
    //   71	100	308	finally
    //   104	120	308	finally
    //   120	168	308	finally
    //   172	192	308	finally
    //   258	278	308	finally
    //   316	326	340	java/io/IOException
    //   285	295	344	java/io/IOException
    //   199	209	348	java/io/IOException
    //   234	244	352	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.a.a
 * JD-Core Version:    0.7.0.1
 */