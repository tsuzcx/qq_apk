package com.tencent.midas.control;

import android.app.ProgressDialog;
import android.os.ResultReceiver;

class APMidasPayHelper$6
  implements Runnable
{
  APMidasPayHelper$6(APMidasPayHelper paramAPMidasPayHelper, ProgressDialog paramProgressDialog, long paramLong, ResultReceiver paramResultReceiver) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 39
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 49	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: invokestatic 49	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
    //   14: invokevirtual 52	java/lang/Object:wait	()V
    //   17: aload_1
    //   18: monitorexit
    //   19: aload_0
    //   20: getfield 25	com/tencent/midas/control/APMidasPayHelper$6:val$progressDialog	Landroid/app/ProgressDialog;
    //   23: invokevirtual 58	android/app/ProgressDialog:isShowing	()Z
    //   26: ifeq +10 -> 36
    //   29: aload_0
    //   30: getfield 25	com/tencent/midas/control/APMidasPayHelper$6:val$progressDialog	Landroid/app/ProgressDialog;
    //   33: invokevirtual 61	android/app/ProgressDialog:dismiss	()V
    //   36: invokestatic 67	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   39: invokestatic 73	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   42: invokestatic 79	com/pay/tool/APMidasTools:getCurrentThreadName	(Ljava/lang/Thread;)Ljava/lang/String;
    //   45: ldc 81
    //   47: aload_0
    //   48: getfield 27	com/tencent/midas/control/APMidasPayHelper$6:val$startTime	J
    //   51: invokevirtual 85	com/tencent/midas/data/APPluginReportManager:insertTimeDataEx	(Ljava/lang/String;Ljava/lang/String;J)V
    //   54: aload_0
    //   55: getfield 29	com/tencent/midas/control/APMidasPayHelper$6:val$followupAction	Landroid/os/ResultReceiver;
    //   58: iconst_0
    //   59: new 87	android/os/Bundle
    //   62: dup
    //   63: invokespecial 88	android/os/Bundle:<init>	()V
    //   66: invokevirtual 94	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   69: ldc 39
    //   71: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: astore_2
    //   76: aload_1
    //   77: monitorexit
    //   78: ldc 39
    //   80: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_2
    //   84: athrow
    //   85: astore_1
    //   86: ldc 99
    //   88: aload_1
    //   89: invokevirtual 103	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   92: invokestatic 109	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: goto -76 -> 19
    //   98: astore_1
    //   99: goto -63 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	6
    //   85	4	1	localInterruptedException	java.lang.InterruptedException
    //   98	1	1	localThrowable	java.lang.Throwable
    //   75	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	19	75	finally
    //   76	78	75	finally
    //   5	11	85	java/lang/InterruptedException
    //   78	85	85	java/lang/InterruptedException
    //   19	36	98	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.control.APMidasPayHelper.6
 * JD-Core Version:    0.7.0.1
 */