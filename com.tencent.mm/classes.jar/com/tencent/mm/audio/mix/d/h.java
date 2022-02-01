package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
  implements ThreadFactory
{
  private final ThreadGroup dvH;
  private final AtomicInteger dvI;
  private final String dvJ;
  private String dvK;
  
  public h()
  {
    AppMethodBeat.i(136822);
    this.dvI = new AtomicInteger(1);
    this.dvJ = "audio_mix_thread#";
    this.dvK = "";
    this.dvH = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    AppMethodBeat.o(136822);
  }
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198110);
    this.dvI = new AtomicInteger(1);
    this.dvJ = "audio_mix_thread#";
    this.dvK = "";
    this.dvH = new ThreadGroup(paramString1);
    this.dvK = paramString2;
    AppMethodBeat.o(198110);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(136823);
    if (TextUtils.isEmpty(this.dvK)) {
      this.dvK = "audio_mix_thread#";
    }
    paramRunnable = new Thread(this.dvH, paramRunnable, this.dvK + this.dvI.getAndIncrement(), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.h
 * JD-Core Version:    0.7.0.1
 */