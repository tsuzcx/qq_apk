package com.google.android.gms.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzr;
import java.util.Map;
import java.util.Set;

class zzaax$zzb
  implements zzf.zzf, zzabr.zza
{
  private final Api.zze zzaAJ;
  private zzr zzaBw = null;
  private boolean zzaCI = false;
  private Set<Scope> zzakq = null;
  private final zzzz<?> zzayU;
  
  public zzaax$zzb(Api.zze paramzze, zzzz<?> paramzzzz)
  {
    this.zzaAJ = paramzzzz;
    Object localObject;
    this.zzayU = localObject;
  }
  
  private void zzwP()
  {
    if ((this.zzaCI) && (this.zzaBw != null)) {
      this.zzaAJ.zza(this.zzaBw, this.zzakq);
    }
  }
  
  public void zzb(zzr paramzzr, Set<Scope> paramSet)
  {
    if ((paramzzr == null) || (paramSet == null))
    {
      Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
      zzi(new ConnectionResult(4));
      return;
    }
    this.zzaBw = paramzzr;
    this.zzakq = paramSet;
    zzwP();
  }
  
  public void zzg(ConnectionResult paramConnectionResult)
  {
    zzaax.zza(this.zzaCx).post(new zzaax.zzb.1(this, paramConnectionResult));
  }
  
  public void zzi(ConnectionResult paramConnectionResult)
  {
    ((zzaax.zza)zzaax.zzj(this.zzaCx).get(this.zzayU)).zzi(paramConnectionResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzaax.zzb
 * JD-Core Version:    0.7.0.1
 */