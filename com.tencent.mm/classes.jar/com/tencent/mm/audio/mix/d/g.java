package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
  implements ThreadFactory
{
  private final ThreadGroup cfU;
  private final AtomicInteger cfV;
  private final String cfW;
  
  public g()
  {
    AppMethodBeat.i(137074);
    this.cfV = new AtomicInteger(1);
    this.cfW = "audio_mix_thread#";
    this.cfU = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    AppMethodBeat.o(137074);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(137075);
    paramRunnable = new Thread(this.cfU, paramRunnable, "audio_mix_thread#" + this.cfV.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    AppMethodBeat.o(137075);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.g
 * JD-Core Version:    0.7.0.1
 */