package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Locker
{
  private boolean released;
  private V8 runtime;
  private Thread thread;
  
  V8Locker(V8 paramV8)
  {
    AppMethodBeat.i(62127);
    this.thread = null;
    this.released = false;
    this.runtime = paramV8;
    acquire();
    AppMethodBeat.o(62127);
  }
  
  public void acquire()
  {
    try
    {
      AppMethodBeat.i(62128);
      if ((this.thread != null) && (this.thread != Thread.currentThread()))
      {
        Error localError = new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
        AppMethodBeat.o(62128);
        throw localError;
      }
    }
    finally {}
    if (this.thread == Thread.currentThread()) {
      AppMethodBeat.o(62128);
    }
    for (;;)
    {
      return;
      this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
      this.thread = Thread.currentThread();
      this.released = false;
      AppMethodBeat.o(62128);
    }
  }
  
  public void checkThread()
  {
    AppMethodBeat.i(62131);
    Error localError;
    if ((this.released) && (this.thread == null))
    {
      localError = new Error("Invalid V8 thread access: the locker has been released!");
      AppMethodBeat.o(62131);
      throw localError;
    }
    if (this.thread != Thread.currentThread())
    {
      localError = new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
      AppMethodBeat.o(62131);
      throw localError;
    }
    AppMethodBeat.o(62131);
  }
  
  public Thread getThread()
  {
    return this.thread;
  }
  
  public boolean hasLock()
  {
    AppMethodBeat.i(62132);
    if (this.thread == Thread.currentThread())
    {
      AppMethodBeat.o(62132);
      return true;
    }
    AppMethodBeat.o(62132);
    return false;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 85
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/eclipsesource/v8/V8Locker:released	Z
    //   11: ifeq +10 -> 21
    //   14: aload_0
    //   15: getfield 24	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   18: ifnull +13 -> 31
    //   21: aload_0
    //   22: getfield 28	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   25: invokevirtual 88	com/eclipsesource/v8/V8:isReleased	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 85
    //   33: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: invokevirtual 90	com/eclipsesource/v8/V8Locker:checkThread	()V
    //   43: aload_0
    //   44: getfield 28	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   47: aload_0
    //   48: getfield 28	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   51: invokevirtual 71	com/eclipsesource/v8/V8:getV8RuntimePtr	()J
    //   54: invokevirtual 93	com/eclipsesource/v8/V8:releaseLock	(J)V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 24	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 26	com/eclipsesource/v8/V8Locker:released	Z
    //   67: ldc 85
    //   69: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -36 -> 36
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	V8Locker
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	75	finally
    //   21	31	75	finally
    //   31	36	75	finally
    //   39	72	75	finally
  }
  
  /* Error */
  public boolean tryAcquire()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 95
    //   6: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 24	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   13: ifnull +22 -> 35
    //   16: aload_0
    //   17: getfield 24	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   20: invokestatic 42	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: if_acmpeq +12 -> 35
    //   26: ldc 95
    //   28: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: aload_0
    //   36: getfield 24	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   39: invokestatic 42	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   42: if_acmpne +13 -> 55
    //   45: ldc 95
    //   47: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_1
    //   51: istore_1
    //   52: goto -21 -> 31
    //   55: aload_0
    //   56: getfield 28	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   59: aload_0
    //   60: getfield 28	com/eclipsesource/v8/V8Locker:runtime	Lcom/eclipsesource/v8/V8;
    //   63: invokevirtual 71	com/eclipsesource/v8/V8:getV8RuntimePtr	()J
    //   66: invokevirtual 75	com/eclipsesource/v8/V8:acquireLock	(J)V
    //   69: aload_0
    //   70: invokestatic 42	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   73: putfield 24	com/eclipsesource/v8/V8Locker:thread	Ljava/lang/Thread;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 26	com/eclipsesource/v8/V8Locker:released	Z
    //   81: ldc 95
    //   83: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_1
    //   87: istore_1
    //   88: goto -57 -> 31
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	V8Locker
    //   1	87	1	bool	boolean
    //   91	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	31	91	finally
    //   35	50	91	finally
    //   55	86	91	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.V8Locker
 * JD-Core Version:    0.7.0.1
 */