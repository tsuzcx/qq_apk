package com.tencent.mm.audio.mix.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(137087);
    Process.setThreadPriority(-19);
    List localList;
    com.tencent.mm.audio.mix.a.b localb;
    d locald;
    if (this.cgE.Dt())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "stop and exit");
      AppMethodBeat.o(137087);
      return;
      System.nanoTime();
      localList = this.cgE.DQ();
      if (localList.size() > 0)
      {
        long l1 = System.nanoTime();
        localb = this.cgE.cgg.G(localList);
        long l2 = System.nanoTime();
        ??? = this.cgE;
        ((c)???).cgz += 1;
        this.cgE.cgA = (l2 - l1 + this.cgE.cgA);
        if (localb != null)
        {
          ??? = this.cgE;
          localb.cen.addAll(((c)???).cen);
          ((c)???).cen.clear();
          locald = ((c)???).cgh;
          if (!locald.chn.get()) {
            break label219;
          }
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
        }
      }
    }
    for (;;)
    {
      c.F(localList);
      localList.clear();
      if (this.cgE.Dt()) {
        break label327;
      }
      this.cgE.DN();
      if (!this.cgE.Dt()) {
        break;
      }
      AppMethodBeat.o(137087);
      return;
      label219:
      synchronized (locald.chp)
      {
        for (;;)
        {
          if (locald.cho.size() >= 2)
          {
            boolean bool = locald.chn.get();
            if (!bool) {
              try
              {
                locald.chp.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "enqueueMixBuffer", new Object[0]);
              }
            }
          }
        }
      }
      locald.cho.add(localb);
      locald.chp.notifyAll();
    }
    label327:
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
    AppMethodBeat.o(137087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.c.1
 * JD-Core Version:    0.7.0.1
 */