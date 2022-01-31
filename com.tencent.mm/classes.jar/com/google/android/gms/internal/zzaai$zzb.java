package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

class zzaai$zzb
  implements zzabc.zza
{
  private zzaai$zzb(zzaai paramzzaai) {}
  
  public void zzc(int paramInt, boolean paramBoolean)
  {
    zzaai.zza(this.zzaAI).lock();
    try
    {
      if (zzaai.zzc(this.zzaAI))
      {
        zzaai.zza(this.zzaAI, false);
        zzaai.zza(this.zzaAI, paramInt, paramBoolean);
        return;
      }
      zzaai.zza(this.zzaAI, true);
      zzaai.zzf(this.zzaAI).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzaai.zza(this.zzaAI).unlock();
    }
  }
  
  public void zzc(ConnectionResult paramConnectionResult)
  {
    zzaai.zza(this.zzaAI).lock();
    try
    {
      zzaai.zzb(this.zzaAI, paramConnectionResult);
      zzaai.zzb(this.zzaAI);
      return;
    }
    finally
    {
      zzaai.zza(this.zzaAI).unlock();
    }
  }
  
  public void zzo(Bundle paramBundle)
  {
    zzaai.zza(this.zzaAI).lock();
    try
    {
      zzaai.zzb(this.zzaAI, ConnectionResult.zzayj);
      zzaai.zzb(this.zzaAI);
      return;
    }
    finally
    {
      zzaai.zza(this.zzaAI).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaai.zzb
 * JD-Core Version:    0.7.0.1
 */