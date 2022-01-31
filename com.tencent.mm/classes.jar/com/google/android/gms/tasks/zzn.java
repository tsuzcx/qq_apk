package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn
  implements Runnable
{
  zzn(zzm paramzzm, Task paramTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(57401);
    synchronized (zzm.zza(this.zzafx))
    {
      if (zzm.zzb(this.zzafx) != null) {
        zzm.zzb(this.zzafx).onSuccess(this.zzafn.getResult());
      }
      AppMethodBeat.o(57401);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzn
 * JD-Core Version:    0.7.0.1
 */