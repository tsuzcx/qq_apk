package com.tencent.midas.download;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class APMidasPluginDownloadManager$1
  implements ThreadFactory
{
  private AtomicInteger netThreadCount;
  
  APMidasPluginDownloadManager$1(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217137);
    this.netThreadCount = new AtomicInteger(0);
    AppMethodBeat.o(217137);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(217141);
    paramRunnable = new Thread(paramRunnable, this.val$name + " " + this.netThreadCount.getAndIncrement());
    paramRunnable.setPriority(10);
    paramRunnable.setDaemon(this.val$daemon);
    AppMethodBeat.o(217141);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.midas.download.APMidasPluginDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */