package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class q$a
{
  static MMHandler hbN;
  private ReentrantLock bKF;
  private Condition hbM;
  int oGu;
  a oIR;
  
  public q$a()
  {
    AppMethodBeat.i(150721);
    this.bKF = new ReentrantLock();
    this.hbM = this.bKF.newCondition();
    AppMethodBeat.o(150721);
  }
  
  public static a a(final q.e parame)
  {
    AppMethodBeat.i(150722);
    try
    {
      if (hbN == null) {
        hbN = new MMHandler("big file gen Worker");
      }
      a locala1 = new a();
      parame.oJk = locala1;
      a locala2 = parame.oJk;
      hbN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150720);
          long l = System.currentTimeMillis();
          q.a.a locala = new q.a.a();
          locala.oIU = new PString();
          locala.oIV = new PString();
          locala.oIW = new PString();
          locala.oIX = new PString();
          String str = i.NV(parame.oJb);
          locala.oGC = r.bKa().a(parame.hHa, parame.oJb, str, parame.oGu, true, locala.oIU, locala.oIV, locala.oIW, locala.oIX, parame.oJd, parame.oJi, -1);
          q.a.a(q.a.this).lock();
          try
          {
            q.a.this.oIR = locala;
            q.a.b(q.a.this).signal();
            Log.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.oJb, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
            return;
          }
          finally
          {
            q.a.a(q.a.this).unlock();
            AppMethodBeat.o(150720);
          }
        }
      });
      locala1.oGu = parame.oGu;
      AppMethodBeat.o(150722);
      return locala1;
    }
    finally
    {
      AppMethodBeat.o(150722);
    }
  }
  
  /* Error */
  public final a bJR()
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/tencent/mm/modelimage/q$a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: getfield 88	com/tencent/mm/modelimage/q$a:oIR	Lcom/tencent/mm/modelimage/q$a$a;
    //   16: ifnonnull +42 -> 58
    //   19: ldc 90
    //   21: ldc 92
    //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 43	com/tencent/mm/modelimage/q$a:hbM	Ljava/util/concurrent/locks/Condition;
    //   30: invokeinterface 102 1 0
    //   35: goto -23 -> 12
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 37	com/tencent/mm/modelimage/q$a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   46: aload_0
    //   47: getfield 88	com/tencent/mm/modelimage/q$a:oIR	Lcom/tencent/mm/modelimage/q$a$a;
    //   50: astore_1
    //   51: ldc 83
    //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_1
    //   57: areturn
    //   58: aload_0
    //   59: getfield 37	com/tencent/mm/modelimage/q$a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: goto -19 -> 46
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 37	com/tencent/mm/modelimage/q$a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   73: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   76: ldc 83
    //   78: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   38	1	1	localException	java.lang.Exception
    //   50	7	1	locala	a
    //   68	14	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	35	38	java/lang/Exception
    //   12	35	68	finally
  }
  
  public static final class a
  {
    String oGC;
    PString oIU;
    PString oIV;
    PString oIW;
    PString oIX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.q.a
 * JD-Core Version:    0.7.0.1
 */