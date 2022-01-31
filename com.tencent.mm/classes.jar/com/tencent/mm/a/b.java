package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b
{
  static ah btW;
  File btT;
  private ReentrantLock btU = new ReentrantLock();
  private Condition btV = this.btU.newCondition();
  
  public b(final String paramString)
  {
    try
    {
      if (btW == null)
      {
        localObject = new HandlerThread("I/O Worker");
        ((HandlerThread)localObject).start();
        btW = new ah(((HandlerThread)localObject).getLooper());
      }
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        this.btT = ((File)localObject);
        return;
      }
    }
    finally {}
    y.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", new Object[] { paramString });
    btW.post(new Runnable()
    {
      public final void run()
      {
        File localFile = new File(paramString);
        long l;
        if (!localFile.exists())
        {
          l = System.currentTimeMillis();
          e.bO(paramString);
          y.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          l = System.currentTimeMillis();
        }
        try
        {
          localFile.createNewFile();
          y.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          b.a(b.this).lock();
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            try
            {
              b.this.btT = localFile;
              b.b(b.this).signal();
              y.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", new Object[] { localFile.getAbsoluteFile() });
              return;
            }
            finally
            {
              b.a(b.this).unlock();
            }
            localIOException = localIOException;
            y.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", localIOException, "", new Object[0]);
            y.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", localIOException, "createNewFile", new Object[0]);
          }
        }
      }
    });
  }
  
  /* Error */
  public final File rL()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/mm/a/b:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 59	com/tencent/mm/a/b:btT	Ljava/io/File;
    //   11: ifnonnull +35 -> 46
    //   14: ldc 61
    //   16: ldc 90
    //   18: invokestatic 93	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 30	com/tencent/mm/a/b:btV	Ljava/util/concurrent/locks/Condition;
    //   25: invokeinterface 98 1 0
    //   30: goto -23 -> 7
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 24	com/tencent/mm/a/b:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   38: invokevirtual 101	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   41: aload_0
    //   42: getfield 59	com/tencent/mm/a/b:btT	Ljava/io/File;
    //   45: areturn
    //   46: aload_0
    //   47: getfield 24	com/tencent/mm/a/b:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 101	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: goto -12 -> 41
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 24	com/tencent/mm/a/b:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   61: invokevirtual 101	java/util/concurrent/locks/ReentrantLock:unlock	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.b
 * JD-Core Version:    0.7.0.1
 */