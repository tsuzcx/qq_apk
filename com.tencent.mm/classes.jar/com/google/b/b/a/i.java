package com.google.b.b.a;

public final class i
{
  /* Error */
  public static <V> V b(java.util.concurrent.Future<V> paramFuture)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_0
    //   8: invokeinterface 21 1 0
    //   13: astore_2
    //   14: iload_1
    //   15: ifeq +9 -> 24
    //   18: invokestatic 27	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 31	java/lang/Thread:interrupt	()V
    //   24: ldc 9
    //   26: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: iconst_1
    //   33: istore_1
    //   34: goto -27 -> 7
    //   37: astore_0
    //   38: iload_1
    //   39: ifeq +9 -> 48
    //   42: invokestatic 27	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 31	java/lang/Thread:interrupt	()V
    //   48: ldc 9
    //   50: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramFuture	java.util.concurrent.Future<V>
    //   6	33	1	i	int
    //   13	17	2	localObject	Object
    //   31	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	14	31	java/lang/InterruptedException
    //   7	14	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.a.i
 * JD-Core Version:    0.7.0.1
 */