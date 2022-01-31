package com.tencent.mm.f.c;

import com.tencent.mm.f.b.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

final class d$a
  implements Runnable
{
  public final void run()
  {
    for (;;)
    {
      synchronized (this.bEF)
      {
        boolean bool = this.bEF.bEr;
        y.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + bool + " queueLen: " + this.bEF.bEq.size());
        if (bool) {
          if (this.bEF.bEq.isEmpty()) {
            break;
          }
        }
      }
      try
      {
        ??? = (g.a)this.bEF.bEq.poll(200L, TimeUnit.MILLISECONDS);
        if (??? != null) {
          break label149;
        }
        y.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.bEF.bEs);
      }
      catch (InterruptedException localInterruptedException)
      {
        y.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
      }
      localObject2 = finally;
      throw localObject2;
      continue;
      label149:
      this.bEF.a(localInterruptedException, 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.c.d.a
 * JD-Core Version:    0.7.0.1
 */