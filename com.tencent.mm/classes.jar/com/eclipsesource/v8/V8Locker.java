package com.eclipsesource.v8;

public class V8Locker
{
  private boolean released = false;
  private V8 runtime;
  private Thread thread = null;
  
  V8Locker(V8 paramV8)
  {
    this.runtime = paramV8;
    acquire();
  }
  
  public void acquire()
  {
    try
    {
      if ((this.thread != null) && (this.thread != Thread.currentThread())) {
        throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
      }
    }
    finally {}
    Thread localThread1 = this.thread;
    Thread localThread2 = Thread.currentThread();
    if (localThread1 == localThread2) {}
    for (;;)
    {
      return;
      this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
      this.thread = Thread.currentThread();
      this.released = false;
    }
  }
  
  public void checkThread()
  {
    if ((this.released) && (this.thread == null)) {
      throw new Error("Invalid V8 thread access: the locker has been released!");
    }
    if (this.thread != Thread.currentThread()) {
      throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
    }
  }
  
  public Thread getThread()
  {
    return this.thread;
  }
  
  public boolean hasLock()
  {
    return this.thread == Thread.currentThread();
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/eclipsesource/v8/V8Locker:released	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 17	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   13: ifnull +15 -> 28
    //   16: aload_0
    //   17: getfield 21	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   20: invokevirtual 74	com/eclipsesource/v8/V8:isReleased	()Z
    //   23: istore_1
    //   24: iload_1
    //   25: ifeq +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: invokevirtual 76	com/eclipsesource/v8/V8Locker:checkThread	()V
    //   35: aload_0
    //   36: getfield 21	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   39: aload_0
    //   40: getfield 21	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   43: invokevirtual 60	com/eclipsesource/v8/V8:getV8RuntimePtr	()J
    //   46: invokevirtual 79	com/eclipsesource/v8/V8:releaseLock	(J)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 17	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 19	com/eclipsesource/v8/V8Locker:released	Z
    //   59: goto -31 -> 28
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	V8Locker
    //   23	2	1	bool	boolean
    //   62	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	62	finally
    //   16	24	62	finally
    //   31	59	62	finally
  }
  
  /* Error */
  public boolean tryAcquire()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 17	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   8: ifnull +21 -> 29
    //   11: aload_0
    //   12: getfield 17	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   15: astore_2
    //   16: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19: astore_3
    //   20: aload_2
    //   21: aload_3
    //   22: if_acmpeq +7 -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: aload_0
    //   30: getfield 17	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   33: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   36: if_acmpne +8 -> 44
    //   39: iconst_1
    //   40: istore_1
    //   41: goto -16 -> 25
    //   44: aload_0
    //   45: getfield 21	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   48: aload_0
    //   49: getfield 21	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   52: invokevirtual 60	com/eclipsesource/v8/V8:getV8RuntimePtr	()J
    //   55: invokevirtual 64	com/eclipsesource/v8/V8:acquireLock	(J)V
    //   58: aload_0
    //   59: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   62: putfield 17	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 19	com/eclipsesource/v8/V8Locker:released	Z
    //   70: iconst_1
    //   71: istore_1
    //   72: goto -47 -> 25
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	V8Locker
    //   1	71	1	bool	boolean
    //   15	6	2	localThread1	Thread
    //   75	4	2	localObject	Object
    //   19	3	3	localThread2	Thread
    // Exception table:
    //   from	to	target	type
    //   4	20	75	finally
    //   29	39	75	finally
    //   44	70	75	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.V8Locker
 * JD-Core Version:    0.7.0.1
 */