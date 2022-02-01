package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  implements PendingResult.StatusListener
{
  zza(Batch paramBatch) {}
  
  public final void onComplete(Status paramStatus)
  {
    AppMethodBeat.i(11501);
    synchronized (Batch.zza(this.zzch))
    {
      if (this.zzch.isCanceled())
      {
        AppMethodBeat.o(11501);
        return;
      }
      if (paramStatus.isCanceled()) {
        Batch.zza(this.zzch, true);
      }
      while (paramStatus.isSuccess())
      {
        Batch.zzb(this.zzch);
        if (Batch.zzc(this.zzch) == 0)
        {
          if (!Batch.zzd(this.zzch)) {
            break;
          }
          Batch.zze(this.zzch);
        }
        AppMethodBeat.o(11501);
        return;
      }
      Batch.zzb(this.zzch, true);
    }
    if (Batch.zzf(this.zzch)) {}
    for (paramStatus = new Status(13);; paramStatus = Status.RESULT_SUCCESS)
    {
      this.zzch.setResult(new BatchResult(paramStatus, Batch.zzg(this.zzch)));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.zza
 * JD-Core Version:    0.7.0.1
 */