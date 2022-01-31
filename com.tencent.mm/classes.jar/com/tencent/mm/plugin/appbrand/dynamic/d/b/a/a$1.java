package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   4: getfield 25	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:workerThread	Ljava/lang/Thread;
    //   7: invokevirtual 31	java/lang/Thread:isInterrupted	()Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   18: getfield 35	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWg	Ljava/util/concurrent/BlockingQueue;
    //   21: invokeinterface 41 1 0
    //   26: checkcast 43	com/tencent/mm/plugin/appbrand/dynamic/d/b/b
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   36: getfield 35	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWg	Ljava/util/concurrent/BlockingQueue;
    //   39: invokeinterface 47 1 0
    //   44: iconst_2
    //   45: if_icmplt +82 -> 127
    //   48: aload_1
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   54: getfield 51	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWi	J
    //   57: lconst_0
    //   58: lcmp
    //   59: ifle +68 -> 127
    //   62: aload_1
    //   63: astore_2
    //   64: aload_1
    //   65: getfield 54	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:fVT	J
    //   68: aload_0
    //   69: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   72: getfield 57	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWj	J
    //   75: lcmp
    //   76: ifge +51 -> 127
    //   79: aload_0
    //   80: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   83: astore_1
    //   84: aload_1
    //   85: aload_1
    //   86: getfield 61	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWk	I
    //   89: iconst_1
    //   90: iadd
    //   91: putfield 61	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWk	I
    //   94: aload_0
    //   95: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   98: getfield 35	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWg	Ljava/util/concurrent/BlockingQueue;
    //   101: invokeinterface 64 1 0
    //   106: checkcast 43	com/tencent/mm/plugin/appbrand/dynamic/d/b/b
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_0
    //   113: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   116: getfield 35	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWg	Ljava/util/concurrent/BlockingQueue;
    //   119: invokeinterface 47 1 0
    //   124: ifgt -62 -> 62
    //   127: aload_2
    //   128: ifnull +84 -> 212
    //   131: aload_2
    //   132: invokevirtual 66	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:run	()V
    //   135: aload_0
    //   136: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   139: aload_2
    //   140: getfield 54	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:fVT	J
    //   143: putfield 51	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWi	J
    //   146: aload_0
    //   147: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   150: getfield 70	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWm	Z
    //   153: ifeq +59 -> 212
    //   156: ldc 72
    //   158: ldc 74
    //   160: iconst_0
    //   161: anewarray 4	java/lang/Object
    //   164: invokestatic 80	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_0
    //   168: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   171: getfield 83	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWh	Ljava/util/concurrent/BlockingQueue;
    //   174: invokeinterface 41 1 0
    //   179: checkcast 6	java/lang/Runnable
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +9 -> 193
    //   187: aload_1
    //   188: invokeinterface 84 1 0
    //   193: aload_0
    //   194: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   197: iconst_0
    //   198: putfield 70	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:fWm	Z
    //   201: ldc 72
    //   203: ldc 86
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 80	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_0
    //   213: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:fWn	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
    //   216: getfield 25	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:workerThread	Ljava/lang/Thread;
    //   219: invokevirtual 31	java/lang/Thread:isInterrupted	()Z
    //   222: ifne -209 -> 13
    //   225: ldc2_w 87
    //   228: invokestatic 92	java/lang/Thread:sleep	(J)V
    //   231: goto -231 -> 0
    //   234: astore_1
    //   235: ldc 72
    //   237: aload_1
    //   238: ldc 94
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: return
    //   248: astore_1
    //   249: ldc 72
    //   251: aload_1
    //   252: ldc 94
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: return
    //   262: astore_1
    //   263: ldc 72
    //   265: aload_1
    //   266: ldc 94
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	1
    //   29	159	1	localObject1	Object
    //   234	4	1	localInterruptedException1	java.lang.InterruptedException
    //   248	4	1	localInterruptedException2	java.lang.InterruptedException
    //   262	4	1	localInterruptedException3	java.lang.InterruptedException
    //   31	109	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   225	231	234	java/lang/InterruptedException
    //   14	30	248	java/lang/InterruptedException
    //   156	183	262	java/lang/InterruptedException
    //   187	193	262	java/lang/InterruptedException
    //   193	212	262	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */