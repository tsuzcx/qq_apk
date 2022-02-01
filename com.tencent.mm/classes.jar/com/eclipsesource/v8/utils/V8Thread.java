package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;

public class V8Thread
  extends Thread
{
  private V8 runtime;
  private final V8Runnable target;
  
  public V8Thread(V8Runnable paramV8Runnable)
  {
    this.target = paramV8Runnable;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 30	com/eclipsesource/v8/V8:createV8Runtime	()Lcom/eclipsesource/v8/V8;
    //   9: putfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   12: aload_0
    //   13: getfield 15	com/eclipsesource/v8/utils/V8Thread:target	Lcom/eclipsesource/v8/utils/V8Runnable;
    //   16: aload_0
    //   17: getfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   20: invokeinterface 37 2 0
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   31: invokevirtual 41	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   34: invokevirtual 47	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   37: ifeq +15 -> 52
    //   40: aload_0
    //   41: getfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   44: invokevirtual 50	com/eclipsesource/v8/V8:release	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   52: aload_0
    //   53: monitorexit
    //   54: ldc 18
    //   56: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: ldc 18
    //   65: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   77: invokevirtual 41	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   80: invokevirtual 47	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   83: ifeq +15 -> 98
    //   86: aload_0
    //   87: getfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   90: invokevirtual 50	com/eclipsesource/v8/V8:release	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 32	com/eclipsesource/v8/utils/V8Thread:runtime	Lcom/eclipsesource/v8/V8;
    //   98: aload_0
    //   99: monitorexit
    //   100: ldc 18
    //   102: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: ldc 18
    //   112: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	V8Thread
    //   60	9	1	localObject1	java.lang.Object
    //   70	36	1	localObject2	java.lang.Object
    //   107	9	1	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   27	52	60	finally
    //   52	54	60	finally
    //   61	63	60	finally
    //   12	25	70	finally
    //   73	98	107	finally
    //   98	100	107	finally
    //   108	110	107	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8Thread
 * JD-Core Version:    0.7.0.1
 */