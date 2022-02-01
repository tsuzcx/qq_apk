package com.tencent.mm.audio.mix.decode;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
  implements ThreadFactory
{
  private final ThreadGroup hsA;
  private final AtomicInteger hsB;
  private final String hsC;
  private String hsD;
  
  public h()
  {
    AppMethodBeat.i(136822);
    this.hsB = new AtomicInteger(1);
    this.hsC = "audio_mix_thread#";
    this.hsD = "";
    this.hsA = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    AppMethodBeat.o(136822);
  }
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236216);
    this.hsB = new AtomicInteger(1);
    this.hsC = "audio_mix_thread#";
    this.hsD = "";
    this.hsA = new ThreadGroup(paramString1);
    this.hsD = paramString2;
    AppMethodBeat.o(236216);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(136823);
    if (TextUtils.isEmpty(this.hsD)) {
      this.hsD = "audio_mix_thread#";
    }
    paramRunnable = new Thread(this.hsA, paramRunnable, this.hsD + this.hsB.getAndIncrement(), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.h
 * JD-Core Version:    0.7.0.1
 */