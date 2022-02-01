package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj
  implements Runnable
{
  zzj(zzi paramzzi, Task paramTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(13394);
    synchronized (zzi.zza(this.zzaft))
    {
      if (zzi.zzb(this.zzaft) != null) {
        zzi.zzb(this.zzaft).onComplete(this.zzafn);
      }
      AppMethodBeat.o(13394);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzj
 * JD-Core Version:    0.7.0.1
 */