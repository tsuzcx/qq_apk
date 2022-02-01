package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
  implements ThreadFactory
{
  private final ThreadGroup cSo;
  private final AtomicInteger cSp;
  private final String cSq;
  
  public g()
  {
    AppMethodBeat.i(136822);
    this.cSp = new AtomicInteger(1);
    this.cSq = "audio_mix_thread#";
    this.cSo = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    AppMethodBeat.o(136822);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(136823);
    paramRunnable = new Thread(this.cSo, paramRunnable, "audio_mix_thread#" + this.cSp.getAndIncrement(), 0L);
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