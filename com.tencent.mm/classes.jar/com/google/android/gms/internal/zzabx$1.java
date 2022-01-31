package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

class zzabx$1
  implements Runnable
{
  zzabx$1(zzabx paramzzabx, Result paramResult) {}
  
  public void run()
  {
    try
    {
      zzaaf.zzaAg.set(Boolean.valueOf(true));
      Object localObject1 = zzabx.zzc(this.zzaDt).onSuccess(this.zzaDs);
      zzabx.zzd(this.zzaDt).sendMessage(zzabx.zzd(this.zzaDt).obtainMessage(0, localObject1));
      zzaaf.zzaAg.set(Boolean.valueOf(false));
      zzabx.zza(this.zzaDt, this.zzaDs);
      localObject1 = (GoogleApiClient)zzabx.zze(this.zzaDt).get();
      if (localObject1 != null) {
        ((GoogleApiClient)localObject1).zzb(this.zzaDt);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzabx.zzd(this.zzaDt).sendMessage(zzabx.zzd(this.zzaDt).obtainMessage(1, localRuntimeException));
      GoogleApiClient localGoogleApiClient1;
      return;
    }
    finally
    {
      zzaaf.zzaAg.set(Boolean.valueOf(false));
      zzabx.zza(this.zzaDt, this.zzaDs);
      GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzabx.zze(this.zzaDt).get();
      if (localGoogleApiClient2 != null) {
        localGoogleApiClient2.zzb(this.zzaDt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzabx.1
 * JD-Core Version:    0.7.0.1
 */