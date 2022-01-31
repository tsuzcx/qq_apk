package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.zze;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzaar$zzb
  extends zzaar.zzf
{
  private final Map<Api.zze, zzaar.zza> zzaBC;
  
  public zzaar$zzb(Map<Api.zze, zzaar.zza> paramMap)
  {
    super(paramMap, null);
    Object localObject;
    this.zzaBC = localObject;
  }
  
  public void zzwe()
  {
    int m = 0;
    Object localObject = this.zzaBC.keySet().iterator();
    int i = 1;
    int j = 0;
    Api.zze localzze;
    if (((Iterator)localObject).hasNext())
    {
      localzze = (Api.zze)((Iterator)localObject).next();
      if (localzze.zzvh())
      {
        if (zzaar.zza.zza((zzaar.zza)this.zzaBC.get(localzze))) {
          break label287;
        }
        j = 1;
      }
    }
    for (int k = 1;; k = 0)
    {
      if (j != 0) {
        m = zzaar.zzb(this.zzaBA).isGooglePlayServicesAvailable(zzaar.zza(this.zzaBA));
      }
      if ((m != 0) && ((k != 0) || (i != 0)))
      {
        localObject = new ConnectionResult(m, null);
        zzaar.zzd(this.zzaBA).zza(new zzaar.zzb.1(this, this.zzaBA, (ConnectionResult)localObject));
        label151:
        return;
        i = 0;
      }
      for (;;)
      {
        break;
        if (zzaar.zze(this.zzaBA)) {
          zzaar.zzf(this.zzaBA).connect();
        }
        localObject = this.zzaBC.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localzze = (Api.zze)((Iterator)localObject).next();
          zzf.zzf localzzf = (zzf.zzf)this.zzaBC.get(localzze);
          if ((localzze.zzvh()) && (m != 0)) {
            zzaar.zzd(this.zzaBA).zza(new zzaar.zzb.2(this, this.zzaBA, localzzf));
          } else {
            localzze.zza(localzzf);
          }
        }
        break label151;
        label287:
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaar.zzb
 * JD-Core Version:    0.7.0.1
 */