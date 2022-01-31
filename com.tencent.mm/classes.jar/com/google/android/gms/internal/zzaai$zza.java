package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

class zzaai$zza
  implements zzabc.zza
{
  private zzaai$zza(zzaai paramzzaai) {}
  
  public void zzc(int paramInt, boolean paramBoolean)
  {
    zzaai.zza(this.zzaAI).lock();
    try
    {
      if ((zzaai.zzc(this.zzaAI)) || (zzaai.zzd(this.zzaAI) == null) || (!zzaai.zzd(this.zzaAI).isSuccess()))
      {
        zzaai.zza(this.zzaAI, false);
        zzaai.zza(this.zzaAI, paramInt, paramBoolean);
        return;
      }
      zzaai.zza(this.zzaAI, true);
      zzaai.zze(this.zzaAI).onConnectionSuspended(paramInt);
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
      zzaai.zza(this.zzaAI, paramConnectionResult);
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
      zzaai.zza(this.zzaAI, paramBundle);
      zzaai.zza(this.zzaAI, ConnectionResult.zzayj);
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
 * Qualified Name:     com.google.android.gms.internal.zzaai.zza
 * JD-Core Version:    0.7.0.1
 */