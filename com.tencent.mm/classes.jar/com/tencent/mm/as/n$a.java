package com.tencent.mm.as;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n$a
{
  static ah btW;
  private ReentrantLock btU = new ReentrantLock();
  private Condition btV = this.btU.newCondition();
  int ent;
  n.a.a epF;
  
  public static a a(n.e parame)
  {
    try
    {
      if (btW == null)
      {
        localObject = new HandlerThread("big file gen Worker");
        ((HandlerThread)localObject).start();
        btW = new ah(((HandlerThread)localObject).getLooper());
      }
      Object localObject = new a();
      parame.epZ = ((a)localObject);
      a locala = parame.epZ;
      btW.post(new n.a.1(locala, parame));
      ((a)localObject).ent = parame.ent;
      return localObject;
    }
    finally {}
  }
  
  /* Error */
  public final n.a.a OC()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mm/as/n$a:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 88	com/tencent/mm/as/n$a:epF	Lcom/tencent/mm/as/n$a$a;
    //   11: ifnonnull +35 -> 46
    //   14: ldc 90
    //   16: ldc 92
    //   18: invokestatic 98	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 34	com/tencent/mm/as/n$a:btV	Ljava/util/concurrent/locks/Condition;
    //   25: invokeinterface 103 1 0
    //   30: goto -23 -> 7
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 28	com/tencent/mm/as/n$a:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   38: invokevirtual 106	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   41: aload_0
    //   42: getfield 88	com/tencent/mm/as/n$a:epF	Lcom/tencent/mm/as/n$a$a;
    //   45: areturn
    //   46: aload_0
    //   47: getfield 28	com/tencent/mm/as/n$a:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 106	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: goto -12 -> 41
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 28	com/tencent/mm/as/n$a:btU	Ljava/util/concurrent/locks/ReentrantLock;
    //   61: invokevirtual 106	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   33	1	1	localException	java.lang.Exception
    //   56	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	30	33	java/lang/Exception
    //   7	30	56	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.n.a
 * JD-Core Version:    0.7.0.1
 */