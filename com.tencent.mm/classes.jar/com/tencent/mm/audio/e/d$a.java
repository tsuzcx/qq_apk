package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

final class d$a
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(55774);
    for (;;)
    {
      synchronized (this.clQ)
      {
        boolean bool = this.clQ.clA;
        ab.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + bool + " queueLen: " + this.clQ.clz.size());
        if (bool) {
          if (this.clQ.clz.isEmpty()) {
            break;
          }
        }
      }
      try
      {
        ??? = (g.a)this.clQ.clz.poll(200L, TimeUnit.MILLISECONDS);
        if (??? != null) {
          break label159;
        }
        ab.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.clQ.clB);
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
      }
      localObject2 = finally;
      AppMethodBeat.o(55774);
      throw localObject2;
      continue;
      label159:
      this.clQ.a(localInterruptedException, 0, false);
    }
    AppMethodBeat.o(55774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.e.d.a
 * JD-Core Version:    0.7.0.1
 */