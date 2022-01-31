package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zze;
import java.util.Collections;
import java.util.Map;

class zzaax$zzb$1
  implements Runnable
{
  zzaax$zzb$1(zzaax.zzb paramzzb, ConnectionResult paramConnectionResult) {}
  
  public void run()
  {
    if (this.zzaCH.isSuccess())
    {
      zzaax.zzb.zza(this.zzaCJ, true);
      if (zzaax.zzb.zza(this.zzaCJ).zzrd())
      {
        zzaax.zzb.zzb(this.zzaCJ);
        return;
      }
      zzaax.zzb.zza(this.zzaCJ).zza(null, Collections.emptySet());
      return;
    }
    ((zzaax.zza)zzaax.zzj(this.zzaCJ.zzaCx).get(zzaax.zzb.zzc(this.zzaCJ))).onConnectionFailed(this.zzaCH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaax.zzb.1
 * JD-Core Version:    0.7.0.1
 */