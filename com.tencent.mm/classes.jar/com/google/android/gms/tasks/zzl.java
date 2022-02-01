package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl
  implements Runnable
{
  zzl(zzk paramzzk, Task paramTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(13397);
    synchronized (zzk.zza(this.zzafv))
    {
      if (zzk.zzb(this.zzafv) != null) {
        zzk.zzb(this.zzafv).onFailure(this.zzafn.getException());
      }
      AppMethodBeat.o(13397);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzl
 * JD-Core Version:    0.7.0.1
 */