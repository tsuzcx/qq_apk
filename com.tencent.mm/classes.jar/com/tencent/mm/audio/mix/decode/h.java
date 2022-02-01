package com.tencent.mm.audio.mix.decode;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
  implements ThreadFactory
{
  private final ThreadGroup foq;
  private final AtomicInteger jdField_for;
  private final String fos;
  private String fot;
  
  public h()
  {
    AppMethodBeat.i(136822);
    this.jdField_for = new AtomicInteger(1);
    this.fos = "audio_mix_thread#";
    this.fot = "";
    this.foq = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    AppMethodBeat.o(136822);
  }
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257488);
    this.jdField_for = new AtomicInteger(1);
    this.fos = "audio_mix_thread#";
    this.fot = "";
    this.foq = new ThreadGroup(paramString1);
    this.fot = paramString2;
    AppMethodBeat.o(257488);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(136823);
    if (TextUtils.isEmpty(this.fot)) {
      this.fot = "audio_mix_thread#";
    }
    paramRunnable = new Thread(this.foq, paramRunnable, this.fot + this.jdField_for.getAndIncrement(), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.h
 * JD-Core Version:    0.7.0.1
 */