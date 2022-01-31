package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 10891
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   10: getfield 31	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:workerThread	Ljava/lang/Thread;
    //   13: invokevirtual 37	java/lang/Thread:isInterrupted	()Z
    //   16: ifeq +10 -> 26
    //   19: sipush 10891
    //   22: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: return
    //   26: aload_0
    //   27: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   30: getfield 44	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpJ	Ljava/util/concurrent/BlockingQueue;
    //   33: invokeinterface 50 1 0
    //   38: checkcast 52	com/tencent/mm/plugin/appbrand/dynamic/d/b/b
    //   41: astore_1
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   48: getfield 44	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpJ	Ljava/util/concurrent/BlockingQueue;
    //   51: invokeinterface 56 1 0
    //   56: iconst_2
    //   57: if_icmplt +82 -> 139
    //   60: aload_1
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   66: getfield 60	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpL	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifle +68 -> 139
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: getfield 63	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:hpw	J
    //   80: aload_0
    //   81: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   84: getfield 66	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpM	J
    //   87: lcmp
    //   88: ifge +51 -> 139
    //   91: aload_0
    //   92: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   95: astore_1
    //   96: aload_1
    //   97: aload_1
    //   98: getfield 70	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpN	I
    //   101: iconst_1
    //   102: iadd
    //   103: putfield 70	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpN	I
    //   106: aload_0
    //   107: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   110: getfield 44	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpJ	Ljava/util/concurrent/BlockingQueue;
    //   113: invokeinterface 73 1 0
    //   118: checkcast 52	com/tencent/mm/plugin/appbrand/dynamic/d/b/b
    //   121: astore_2
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   128: getfield 44	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpJ	Ljava/util/concurrent/BlockingQueue;
    //   131: invokeinterface 56 1 0
    //   136: ifgt -62 -> 74
    //   139: aload_2
    //   140: ifnull +84 -> 224
    //   143: aload_2
    //   144: invokevirtual 75	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:run	()V
    //   147: aload_0
    //   148: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   151: aload_2
    //   152: getfield 63	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:hpw	J
    //   155: putfield 60	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpL	J
    //   158: aload_0
    //   159: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   162: getfield 79	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpP	Z
    //   165: ifeq +59 -> 224
    //   168: ldc 81
    //   170: ldc 83
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 88	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_0
    //   180: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   183: getfield 91	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpK	Ljava/util/concurrent/BlockingQueue;
    //   186: invokeinterface 50 1 0
    //   191: checkcast 6	java/lang/Runnable
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +9 -> 205
    //   199: aload_1
    //   200: invokeinterface 92 1 0
    //   205: aload_0
    //   206: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   209: iconst_0
    //   210: putfield 79	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:hpP	Z
    //   213: ldc 81
    //   215: ldc 94
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 88	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_0
    //   225: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:hpQ	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   228: getfield 31	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:workerThread	Ljava/lang/Thread;
    //   231: invokevirtual 37	java/lang/Thread:isInterrupted	()Z
    //   234: ifne +72 -> 306
    //   237: ldc2_w 95
    //   240: invokestatic 100	java/lang/Thread:sleep	(J)V
    //   243: goto -237 -> 6
    //   246: astore_1
    //   247: ldc 81
    //   249: aload_1
    //   250: ldc 102
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: sipush 10891
    //   262: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_1
    //   267: ldc 81
    //   269: aload_1
    //   270: ldc 102
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: sipush 10891
    //   282: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: return
    //   286: astore_1
    //   287: ldc 81
    //   289: aload_1
    //   290: ldc 102
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: sipush 10891
    //   302: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: return
    //   306: sipush 10891
    //   309: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	1
    //   41	159	1	localObject1	Object
    //   246	4	1	localInterruptedException1	java.lang.InterruptedException
    //   266	4	1	localInterruptedException2	java.lang.InterruptedException
    //   286	4	1	localInterruptedException3	java.lang.InterruptedException
    //   43	109	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   237	243	246	java/lang/InterruptedException
    //   26	42	266	java/lang/InterruptedException
    //   168	195	286	java/lang/InterruptedException
    //   199	205	286	java/lang/InterruptedException
    //   205	224	286	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */