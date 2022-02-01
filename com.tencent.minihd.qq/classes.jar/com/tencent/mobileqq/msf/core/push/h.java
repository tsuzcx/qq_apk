package com.tencent.mobileqq.msf.core.push;

class h
  extends Thread
{
  h(f paramf) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc2_w 18
    //   3: invokestatic 23	java/lang/Thread:sleep	(J)V
    //   6: invokestatic 29	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   9: ifeq +25 -> 34
    //   12: aload_0
    //   13: getfield 10	com/tencent/mobileqq/msf/core/push/h:a	Lcom/tencent/mobileqq/msf/core/push/f;
    //   16: getfield 35	com/tencent/mobileqq/msf/core/push/f:t	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 10	com/tencent/mobileqq/msf/core/push/h:a	Lcom/tencent/mobileqq/msf/core/push/f;
    //   26: getfield 35	com/tencent/mobileqq/msf/core/push/f:t	Ljava/lang/Object;
    //   29: invokevirtual 40	java/lang/Object:notify	()V
    //   32: aload_1
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 43	java/lang/InterruptedException:printStackTrace	()V
    //   40: goto -34 -> 6
    //   43: astore_2
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	h
    //   35	10	1	localInterruptedException	java.lang.InterruptedException
    //   43	4	2	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	6	35	java/lang/InterruptedException
    //   22	34	43	finally
    //   44	46	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.h
 * JD-Core Version:    0.7.0.1
 */