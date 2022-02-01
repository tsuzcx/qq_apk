package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzci
  implements Runnable
{
  zzci(zzch paramzzch, Result paramResult) {}
  
  public final void run()
  {
    AppMethodBeat.i(11381);
    try
    {
      BasePendingResult.zzez.set(Boolean.TRUE);
      Object localObject1 = zzch.zzc(this.zzml).onSuccess(this.zzmk);
      zzch.zzd(this.zzml).sendMessage(zzch.zzd(this.zzml).obtainMessage(0, localObject1));
      BasePendingResult.zzez.set(Boolean.FALSE);
      zzch.zza(this.zzml, this.zzmk);
      localObject1 = (GoogleApiClient)zzch.zze(this.zzml).get();
      if (localObject1 != null) {
        ((GoogleApiClient)localObject1).zzb(this.zzml);
      }
      AppMethodBeat.o(11381);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzch.zzd(this.zzml).sendMessage(zzch.zzd(this.zzml).obtainMessage(1, localRuntimeException));
      GoogleApiClient localGoogleApiClient1;
      return;
    }
    finally
    {
      BasePendingResult.zzez.set(Boolean.FALSE);
      zzch.zza(this.zzml, this.zzmk);
      GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzch.zze(this.zzml).get();
      if (localGoogleApiClient2 != null) {
        localGoogleApiClient2.zzb(this.zzml);
      }
      AppMethodBeat.o(11381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzci
 * JD-Core Version:    0.7.0.1
 */