package com.tencent.midas.download;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class APMidasPluginDownloadManager
{
  private static final int MAX_CURRENCY_DOWNLOAD_THREAD = 1;
  private static final String TAG = "APMidasPluginDownloadManager";
  private ExecutorService executorService;
  
  private APMidasPluginDownloadManager()
  {
    AppMethodBeat.i(253040);
    this.executorService = getExecutorService();
    AppMethodBeat.o(253040);
  }
  
  /* Error */
  private void enqueue(APMidasPluginDownloadWorker paramAPMidasPluginDownloadWorker)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 39
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +18 -> 26
    //   11: ldc 13
    //   13: ldc 41
    //   15: invokestatic 47	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 39
    //   20: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 32	com/tencent/midas/download/APMidasPluginDownloadManager:executorService	Ljava/util/concurrent/ExecutorService;
    //   30: aload_1
    //   31: invokeinterface 53 2 0
    //   36: ldc 39
    //   38: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	APMidasPluginDownloadManager
    //   0	49	1	paramAPMidasPluginDownloadWorker	APMidasPluginDownloadWorker
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   11	23	44	finally
    //   26	41	44	finally
  }
  
  private ExecutorService getExecutorService()
  {
    AppMethodBeat.i(253046);
    if (this.executorService == null) {
      this.executorService = Executors.newFixedThreadPool(1, threadFactory("Plugin Download Thread", false));
    }
    ExecutorService localExecutorService = this.executorService;
    AppMethodBeat.o(253046);
    return localExecutorService;
  }
  
  static void startDownload(Context paramContext, ArrayList<APMidasPluginDownInfo> paramArrayList, IAPMidasPluginDownListener paramIAPMidasPluginDownListener)
  {
    AppMethodBeat.i(253042);
    File localFile = paramContext.getApplicationContext().getDir("midaspluginsTemp", 0);
    new APMidasPluginDownloadManager().enqueue(new APMidasPluginDownloadWorker(paramContext, paramArrayList, localFile, paramIAPMidasPluginDownListener));
    AppMethodBeat.o(253042);
  }
  
  private static ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(253047);
    paramString = new ThreadFactory()
    {
      private AtomicInteger netThreadCount;
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(252989);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, this.val$name + " " + this.netThreadCount.getAndIncrement());
        paramAnonymousRunnable.setPriority(10);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        AppMethodBeat.o(252989);
        return paramAnonymousRunnable;
      }
    };
    AppMethodBeat.o(253047);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.download.APMidasPluginDownloadManager
 * JD-Core Version:    0.7.0.1
 */