package com.b.a.a;

import android.os.Handler;

abstract class c
  extends d
{
  private boolean bmq;
  
  void a(Handler paramHandler, d.a parama)
  {
    try
    {
      this.bmq = false;
      super.a(paramHandler, parama);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  /* Error */
  final void aU(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/b/a/a/c:bmq	Z
    //   6: iload_1
    //   7: ixor
    //   8: ifeq +19 -> 27
    //   11: aload_0
    //   12: iload_1
    //   13: putfield 15	com/b/a/a/c:bmq	Z
    //   16: aload_0
    //   17: getfield 15	com/b/a/a/c:bmq	Z
    //   20: ifeq +10 -> 30
    //   23: aload_0
    //   24: invokevirtual 22	com/b/a/a/c:te	()V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokevirtual 25	com/b/a/a/c:tf	()V
    //   34: goto -7 -> 27
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	c
    //   0	42	1	paramBoolean	boolean
    //   37	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	27	37	finally
    //   30	34	37	finally
  }
  
  abstract void te();
  
  abstract void tf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */