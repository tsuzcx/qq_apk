package com.tencent.midas.control;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.midas.api.request.APMidasBaseRequest;

class APMidasPayHelper$8
  implements Runnable
{
  APMidasPayHelper$8(APMidasPayHelper paramAPMidasPayHelper, ProgressDialog paramProgressDialog, long paramLong, Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 50
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 60	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: invokestatic 60	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
    //   14: invokevirtual 63	java/lang/Object:wait	()V
    //   17: aload_1
    //   18: monitorexit
    //   19: aload_0
    //   20: getfield 30	com/tencent/midas/control/APMidasPayHelper$8:val$progressDialog	Landroid/app/ProgressDialog;
    //   23: invokevirtual 69	android/app/ProgressDialog:isShowing	()Z
    //   26: ifeq +10 -> 36
    //   29: aload_0
    //   30: getfield 30	com/tencent/midas/control/APMidasPayHelper$8:val$progressDialog	Landroid/app/ProgressDialog;
    //   33: invokevirtual 72	android/app/ProgressDialog:dismiss	()V
    //   36: invokestatic 78	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   39: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   42: invokestatic 90	com/pay/tool/APMidasTools:getCurrentThreadName	(Ljava/lang/Thread;)Ljava/lang/String;
    //   45: ldc 92
    //   47: aload_0
    //   48: getfield 32	com/tencent/midas/control/APMidasPayHelper$8:val$startTime	J
    //   51: invokevirtual 96	com/tencent/midas/data/APPluginReportManager:insertTimeDataEx	(Ljava/lang/String;Ljava/lang/String;J)V
    //   54: aload_0
    //   55: getfield 28	com/tencent/midas/control/APMidasPayHelper$8:this$0	Lcom/tencent/midas/control/APMidasPayHelper;
    //   58: aload_0
    //   59: getfield 34	com/tencent/midas/control/APMidasPayHelper$8:val$activity	Landroid/app/Activity;
    //   62: aload_0
    //   63: getfield 36	com/tencent/midas/control/APMidasPayHelper$8:val$request	Lcom/tencent/midas/api/request/APMidasBaseRequest;
    //   66: aload_0
    //   67: getfield 38	com/tencent/midas/control/APMidasPayHelper$8:val$toMethod	Ljava/lang/String;
    //   70: aload_0
    //   71: getfield 40	com/tencent/midas/control/APMidasPayHelper$8:val$fromMethod	Ljava/lang/String;
    //   74: invokestatic 100	com/tencent/midas/control/APMidasPayHelper:access$700	(Lcom/tencent/midas/control/APMidasPayHelper;Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: ldc 50
    //   80: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_2
    //   85: aload_1
    //   86: monitorexit
    //   87: ldc 50
    //   89: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: ldc 105
    //   97: aload_1
    //   98: invokevirtual 109	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   101: invokestatic 115	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: goto -85 -> 19
    //   107: astore_1
    //   108: goto -72 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	8
    //   94	4	1	localInterruptedException	java.lang.InterruptedException
    //   107	1	1	localThrowable	java.lang.Throwable
    //   84	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	19	84	finally
    //   85	87	84	finally
    //   5	11	94	java/lang/InterruptedException
    //   87	94	94	java/lang/InterruptedException
    //   19	36	107	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.control.APMidasPayHelper.8
 * JD-Core Version:    0.7.0.1
 */