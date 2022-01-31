package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

final class b$2
  implements Runnable
{
  b$2(b paramb, String paramString) {}
  
  public final void run()
  {
    synchronized (b.a(this.gQP))
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = (ConcurrentLinkedQueue)b.a(this.gQP).get(this.val$url);
      y.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { this.val$url, Integer.valueOf(localConcurrentLinkedQueue.size()) });
      Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
      if (localRunnable != null)
      {
        localRunnable.run();
        localConcurrentLinkedQueue.poll();
        if (localConcurrentLinkedQueue.size() > 0)
        {
          y.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
          b.b(this.gQP, this.val$url);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.b.2
 * JD-Core Version:    0.7.0.1
 */