package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
  implements ThreadFactory
{
  private final ThreadGroup ddE;
  private final AtomicInteger ddF;
  private final String ddG;
  
  public g()
  {
    AppMethodBeat.i(136822);
    this.ddF = new AtomicInteger(1);
    this.ddG = "audio_mix_thread#";
    this.ddE = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    AppMethodBeat.o(136822);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(136823);
    paramRunnable = new Thread(this.ddE, paramRunnable, "audio_mix_thread#" + this.ddF.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    AppMethodBeat.o(136823);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.g
 * JD-Core Version:    0.7.0.1
 */