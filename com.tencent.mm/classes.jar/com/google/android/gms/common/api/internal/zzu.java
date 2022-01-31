package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

final class zzu
  implements zzbq
{
  private zzu(zzr paramzzr) {}
  
  public final void zzb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(60979);
    zzr.zza(this.zzgc).lock();
    try
    {
      if (zzr.zzc(this.zzgc))
      {
        zzr.zza(this.zzgc, false);
        zzr.zza(this.zzgc, paramInt, paramBoolean);
        return;
      }
      zzr.zza(this.zzgc, true);
      zzr.zzf(this.zzgc).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(60979);
    }
  }
  
  public final void zzb(Bundle paramBundle)
  {
    AppMethodBeat.i(60977);
    zzr.zza(this.zzgc).lock();
    try
    {
      zzr.zzb(this.zzgc, ConnectionResult.RESULT_SUCCESS);
      zzr.zzb(this.zzgc);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(60977);
    }
  }
  
  public final void zzc(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(60978);
    zzr.zza(this.zzgc).lock();
    try
    {
      zzr.zzb(this.zzgc, paramConnectionResult);
      zzr.zzb(this.zzgc);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(60978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzu
 * JD-Core Version:    0.7.0.1
 */