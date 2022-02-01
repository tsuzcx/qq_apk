package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

final class zzs
  implements Runnable
{
  zzs(zzr paramzzr) {}
  
  public final void run()
  {
    AppMethodBeat.i(11465);
    zzr.zza(this.zzgc).lock();
    try
    {
      zzr.zzb(this.zzgc);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(11465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzs
 * JD-Core Version:    0.7.0.1
 */