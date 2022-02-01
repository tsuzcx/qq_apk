package com.tencent.mm.plugin.appbrand.ae.a;

import com.tencent.f.i.h;

final class a$a
  implements h
{
  volatile boolean isStop = false;
  
  private a$a(a parama) {}
  
  public final String getKey()
  {
    return "WebsocketWriteThread";
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 22	com/tencent/mm/plugin/appbrand/ae/a/a$a:isStop	Z
    //   9: ifne +218 -> 227
    //   12: invokestatic 50	java/lang/Thread:interrupted	()Z
    //   15: ifne +212 -> 227
    //   18: aload_0
    //   19: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   22: getfield 54	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   25: getfield 60	com/tencent/mm/plugin/appbrand/ae/c:oir	Ljava/util/concurrent/BlockingQueue;
    //   28: invokeinterface 65 1 0
    //   33: ifne +189 -> 222
    //   36: iconst_1
    //   37: istore_1
    //   38: iload_1
    //   39: ifeq -34 -> 5
    //   42: aload_0
    //   43: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   46: getfield 54	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   49: getfield 60	com/tencent/mm/plugin/appbrand/ae/c:oir	Ljava/util/concurrent/BlockingQueue;
    //   52: ldc2_w 66
    //   55: getstatic 73	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   58: invokeinterface 77 4 0
    //   63: checkcast 79	java/nio/ByteBuffer
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull -63 -> 5
    //   71: aload_0
    //   72: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   75: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   78: aload_2
    //   79: invokevirtual 87	java/nio/ByteBuffer:array	()[B
    //   82: iconst_0
    //   83: aload_2
    //   84: invokevirtual 91	java/nio/ByteBuffer:limit	()I
    //   87: invokevirtual 97	java/io/OutputStream:write	([BII)V
    //   90: aload_0
    //   91: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   94: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   97: invokevirtual 100	java/io/OutputStream:flush	()V
    //   100: goto -95 -> 5
    //   103: astore_2
    //   104: aload_0
    //   105: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   108: getfield 54	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   111: getfield 60	com/tencent/mm/plugin/appbrand/ae/c:oir	Ljava/util/concurrent/BlockingQueue;
    //   114: invokeinterface 104 1 0
    //   119: astore_2
    //   120: aload_2
    //   121: invokeinterface 109 1 0
    //   126: ifeq +101 -> 227
    //   129: aload_2
    //   130: invokeinterface 113 1 0
    //   135: checkcast 79	java/nio/ByteBuffer
    //   138: astore_3
    //   139: aload_0
    //   140: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   143: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   146: aload_3
    //   147: invokevirtual 87	java/nio/ByteBuffer:array	()[B
    //   150: iconst_0
    //   151: aload_3
    //   152: invokevirtual 91	java/nio/ByteBuffer:limit	()I
    //   155: invokevirtual 97	java/io/OutputStream:write	([BII)V
    //   158: aload_0
    //   159: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   162: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   165: invokevirtual 100	java/io/OutputStream:flush	()V
    //   168: goto -48 -> 120
    //   171: astore_2
    //   172: aload_0
    //   173: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   176: aload_2
    //   177: invokestatic 116	com/tencent/mm/plugin/appbrand/ae/a/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;Ljava/lang/Exception;)V
    //   180: ldc 118
    //   182: aload_2
    //   183: ldc 120
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: ldc 118
    //   194: ldc 128
    //   196: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   203: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   206: invokevirtual 135	java/io/OutputStream:close	()V
    //   209: aload_0
    //   210: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   213: invokestatic 137	com/tencent/mm/plugin/appbrand/ae/a/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;)V
    //   216: ldc 38
    //   218: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: iconst_0
    //   223: istore_1
    //   224: goto -186 -> 38
    //   227: ldc 118
    //   229: ldc 128
    //   231: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   238: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   241: invokevirtual 135	java/io/OutputStream:close	()V
    //   244: aload_0
    //   245: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   248: invokestatic 137	com/tencent/mm/plugin/appbrand/ae/a/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;)V
    //   251: ldc 38
    //   253: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    //   257: astore_2
    //   258: aload_0
    //   259: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   262: aload_2
    //   263: invokestatic 116	com/tencent/mm/plugin/appbrand/ae/a/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;Ljava/lang/Exception;)V
    //   266: ldc 118
    //   268: aload_2
    //   269: ldc 142
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: ldc 118
    //   280: ldc 128
    //   282: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   289: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   292: invokevirtual 135	java/io/OutputStream:close	()V
    //   295: aload_0
    //   296: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   299: invokestatic 137	com/tencent/mm/plugin/appbrand/ae/a/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;)V
    //   302: ldc 38
    //   304: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: return
    //   308: astore_2
    //   309: ldc 118
    //   311: ldc 128
    //   313: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   320: getfield 83	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   323: invokevirtual 135	java/io/OutputStream:close	()V
    //   326: aload_0
    //   327: getfield 17	com/tencent/mm/plugin/appbrand/ae/a/a$a:oiO	Lcom/tencent/mm/plugin/appbrand/ae/a/a;
    //   330: invokestatic 137	com/tencent/mm/plugin/appbrand/ae/a/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;)V
    //   333: ldc 38
    //   335: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.a
 * JD-Core Version:    0.7.0.1
 */