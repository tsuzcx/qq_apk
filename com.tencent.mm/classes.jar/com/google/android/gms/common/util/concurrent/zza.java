package com.google.android.gms.common.util.concurrent;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  implements Runnable
{
  private final int priority;
  private final Runnable zzaax;
  
  public zza(Runnable paramRunnable, int paramInt)
  {
    this.zzaax = paramRunnable;
    this.priority = paramInt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(5326);
    Process.setThreadPriority(this.priority);
    this.zzaax.run();
    AppMethodBeat.o(5326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.zza
 * JD-Core Version:    0.7.0.1
 */