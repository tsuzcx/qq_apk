package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;

public abstract interface zzaau
{
  public abstract void begin();
  
  public abstract void connect();
  
  public abstract boolean disconnect();
  
  public abstract void onConnected(Bundle paramBundle);
  
  public abstract void onConnectionSuspended(int paramInt);
  
  public abstract <A extends Api.zzb, R extends Result, T extends zzaad.zza<R, A>> T zza(T paramT);
  
  public abstract void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean);
  
  public abstract <A extends Api.zzb, T extends zzaad.zza<? extends Result, A>> T zzb(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaau
 * JD-Core Version:    0.7.0.1
 */