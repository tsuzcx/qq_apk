package com.tencent.mm.at;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n$a
{
  static ak bVh;
  private ReentrantLock bVf;
  private Condition bVg;
  int fDP;
  n.a.a fGf;
  
  public n$a()
  {
    AppMethodBeat.i(78358);
    this.bVf = new ReentrantLock();
    this.bVg = this.bVf.newCondition();
    AppMethodBeat.o(78358);
  }
  
  public static a a(n.e parame)
  {
    AppMethodBeat.i(78359);
    try
    {
      if (bVh == null)
      {
        localObject = new HandlerThread("big file gen Worker");
        ((HandlerThread)localObject).start();
        bVh = new ak(((HandlerThread)localObject).getLooper());
      }
      Object localObject = new a();
      parame.fGz = ((a)localObject);
      a locala = parame.fGz;
      bVh.post(new n.a.1(locala, parame));
      ((a)localObject).fDP = parame.fDP;
      AppMethodBeat.o(78359);
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(78359);
    }
  }
  
  /* Error */
  public final n.a.a ahv()
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 35	com/tencent/mm/at/n$a:bVf	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: invokevirtual 98	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: getfield 100	com/tencent/mm/at/n$a:fGf	Lcom/tencent/mm/at/n$a$a;
    //   16: ifnonnull +42 -> 58
    //   19: ldc 102
    //   21: ldc 104
    //   23: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 41	com/tencent/mm/at/n$a:bVg	Ljava/util/concurrent/locks/Condition;
    //   30: invokeinterface 114 1 0
    //   35: goto -23 -> 12
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 35	com/tencent/mm/at/n$a:bVf	Ljava/util/concurrent/locks/ReentrantLock;
    //   43: invokevirtual 117	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   46: aload_0
    //   47: getfield 100	com/tencent/mm/at/n$a:fGf	Lcom/tencent/mm/at/n$a$a;
    //   50: astore_1
    //   51: ldc 95
    //   53: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_1
    //   57: areturn
    //   58: aload_0
    //   59: getfield 35	com/tencent/mm/at/n$a:bVf	Ljava/util/concurrent/locks/ReentrantLock;
    //   62: invokevirtual 117	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: goto -19 -> 46
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 35	com/tencent/mm/at/n$a:bVf	Ljava/util/concurrent/locks/ReentrantLock;
    //   73: invokevirtual 117	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   76: ldc 95
    //   78: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   38	1	1	localException	java.lang.Exception
    //   50	7	1	locala	n.a.a
    //   68	14	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	35	38	java/lang/Exception
    //   12	35	68	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.n.a
 * JD-Core Version:    0.7.0.1
 */