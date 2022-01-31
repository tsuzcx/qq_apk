package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

final class b$2
  implements Runnable
{
  b$2(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(108133);
    synchronized (b.a(this.isE))
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = (ConcurrentLinkedQueue)b.a(this.isE).get(this.val$url);
      ab.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { this.val$url, Integer.valueOf(localConcurrentLinkedQueue.size()) });
      Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
      if (localRunnable != null)
      {
        localRunnable.run();
        localConcurrentLinkedQueue.poll();
        if (localConcurrentLinkedQueue.size() > 0)
        {
          ab.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
          b.b(this.isE, this.val$url);
        }
      }
      AppMethodBeat.o(108133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.b.2
 * JD-Core Version:    0.7.0.1
 */