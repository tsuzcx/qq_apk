package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Queue;

public class zzaas
  implements zzaau
{
  private final zzaav zzaBk;
  
  public zzaas(zzaav paramzzaav)
  {
    this.zzaBk = paramzzaav;
  }
  
  public void begin()
  {
    this.zzaBk.zzwu();
    this.zzaBk.zzaAw.zzaBR = Collections.emptySet();
  }
  
  public void connect()
  {
    this.zzaBk.zzws();
  }
  
  public boolean disconnect()
  {
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt) {}
  
  public <A extends Api.zzb, R extends Result, T extends zzaad.zza<R, A>> T zza(T paramT)
  {
    this.zzaBk.zzaAw.zzaAU.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  public <A extends Api.zzb, T extends zzaad.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaas
 * JD-Core Version:    0.7.0.1
 */