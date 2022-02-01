package com.google.android.gms.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zze
  implements ThreadFactory
{
  private final AtomicInteger zzx;
  
  zze(GcmTaskService paramGcmTaskService)
  {
    AppMethodBeat.i(3703);
    this.zzx = new AtomicInteger(1);
    AppMethodBeat.o(3703);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(3704);
    int i = this.zzx.getAndIncrement();
    paramRunnable = new Thread(paramRunnable, 20 + "gcm-task#" + i);
    paramRunnable.setPriority(4);
    AppMethodBeat.o(3704);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.gcm.zze
 * JD-Core Version:    0.7.0.1
 */