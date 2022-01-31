package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

class zzaai$1
  implements Runnable
{
  zzaai$1(zzaai paramzzaai) {}
  
  public void run()
  {
    zzaai.zza(this.zzaAI).lock();
    try
    {
      zzaai.zzb(this.zzaAI);
      return;
    }
    finally
    {
      zzaai.zza(this.zzaAI).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzaai.1
 * JD-Core Version:    0.7.0.1
 */