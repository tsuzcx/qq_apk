package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

final class zzt
  implements zzbq
{
  private zzt(zzr paramzzr) {}
  
  public final void zzb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(11468);
    zzr.zza(this.zzgc).lock();
    try
    {
      if ((zzr.zzc(this.zzgc)) || (zzr.zzd(this.zzgc) == null) || (!zzr.zzd(this.zzgc).isSuccess()))
      {
        zzr.zza(this.zzgc, false);
        zzr.zza(this.zzgc, paramInt, paramBoolean);
        return;
      }
      zzr.zza(this.zzgc, true);
      zzr.zze(this.zzgc).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(11468);
    }
  }
  
  public final void zzb(Bundle paramBundle)
  {
    AppMethodBeat.i(11466);
    zzr.zza(this.zzgc).lock();
    try
    {
      zzr.zza(this.zzgc, paramBundle);
      zzr.zza(this.zzgc, ConnectionResult.RESULT_SUCCESS);
      zzr.zzb(this.zzgc);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(11466);
    }
  }
  
  public final void zzc(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11467);
    zzr.zza(this.zzgc).lock();
    try
    {
      zzr.zza(this.zzgc, paramConnectionResult);
      zzr.zzb(this.zzgc);
      return;
    }
    finally
    {
      zzr.zza(this.zzgc).unlock();
      AppMethodBeat.o(11467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzt
 * JD-Core Version:    0.7.0.1
 */