package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b
{
  static MMHandler hbN;
  private ReentrantLock bKF = new ReentrantLock();
  u hbL;
  private Condition hbM = this.bKF.newCondition();
  
  public b(final String paramString)
  {
    try
    {
      if (hbN == null) {
        hbN = new MMHandler("I/O Worker");
      }
      u localu = new u(paramString);
      if (localu.jKS())
      {
        this.hbL = localu;
        return;
      }
    }
    finally {}
    Log.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", new Object[] { paramString });
    hbN.post(new Runnable()
    {
      public final void run()
      {
        u localu1 = new u(paramString);
        long l;
        if (!localu1.jKS())
        {
          l = System.currentTimeMillis();
          u localu2 = new u(paramString).jKP();
          if ((!localu2.jKS()) && ((!localu2.jKY()) || (!localu2.isDirectory()))) {
            Log.e("MicroMsg.ConcurrentFileBuilder", "mkParentDir mkdir error. %s", new Object[] { paramString });
          }
          Log.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          l = System.currentTimeMillis();
        }
        try
        {
          localu1.jKZ();
          Log.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          b.a(b.this).lock();
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            try
            {
              b.this.hbL = localu1;
              b.b(b.this).signal();
              Log.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", new Object[] { localu1.jKU() });
              return;
            }
            finally
            {
              b.a(b.this).unlock();
            }
            localIOException = localIOException;
            Log.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", localIOException, "", new Object[0]);
            Log.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", localIOException, "createNewFile", new Object[0]);
          }
        }
      }
    });
  }
  
  /* Error */
  public final u aAD()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/mm/b/b:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 47	com/tencent/mm/b/b:hbL	Lcom/tencent/mm/vfs/u;
    //   11: ifnonnull +35 -> 46
    //   14: ldc 49
    //   16: ldc 78
    //   18: invokestatic 81	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 30	com/tencent/mm/b/b:hbM	Ljava/util/concurrent/locks/Condition;
    //   25: invokeinterface 86 1 0
    //   30: goto -23 -> 7
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 24	com/tencent/mm/b/b:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   38: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   41: aload_0
    //   42: getfield 47	com/tencent/mm/b/b:hbL	Lcom/tencent/mm/vfs/u;
    //   45: areturn
    //   46: aload_0
    //   47: getfield 24	com/tencent/mm/b/b:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: goto -12 -> 41
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 24	com/tencent/mm/b/b:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   61: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	b
    //   33	1	1	localException	java.lang.Exception
    //   56	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	30	33	java/lang/Exception
    //   7	30	56	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.b.b
 * JD-Core Version:    0.7.0.1
 */