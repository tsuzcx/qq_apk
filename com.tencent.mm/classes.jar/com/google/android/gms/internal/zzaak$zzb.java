package com.google.android.gms.internal;

import android.support.v4.f.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class zzaak$zzb
  implements OnCompleteListener<Void>
{
  private zzabq zzaBb;
  
  zzaak$zzb(zzaak paramzzaak, zzabq paramzzabq)
  {
    this.zzaBb = paramzzabq;
  }
  
  void cancel()
  {
    this.zzaBb.zzrq();
  }
  
  public void onComplete(Task<Void> paramTask)
  {
    zzaak.zza(this.zzaBa).lock();
    Object localObject;
    try
    {
      if (!zzaak.zzb(this.zzaBa))
      {
        this.zzaBb.zzrq();
        return;
      }
      if (paramTask.isSuccessful())
      {
        zzaak.zzb(this.zzaBa, new a(zzaak.zzm(this.zzaBa).size()));
        paramTask = zzaak.zzm(this.zzaBa).values().iterator();
        while (paramTask.hasNext())
        {
          localObject = (zzaaj)paramTask.next();
          zzaak.zzg(this.zzaBa).put(((zzaaj)localObject).getApiKey(), ConnectionResult.zzayj);
        }
      }
      if (!(paramTask.getException() instanceof zzb)) {
        break label417;
      }
    }
    finally
    {
      zzaak.zza(this.zzaBa).unlock();
    }
    paramTask = (zzb)paramTask.getException();
    if (zzaak.zze(this.zzaBa))
    {
      zzaak.zzb(this.zzaBa, new a(zzaak.zzm(this.zzaBa).size()));
      localObject = zzaak.zzm(this.zzaBa).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzaaj localzzaaj = (zzaaj)((Iterator)localObject).next();
        zzzz localzzzz = localzzaaj.getApiKey();
        ConnectionResult localConnectionResult = paramTask.zza(localzzaaj);
        if (zzaak.zza(this.zzaBa, localzzaaj, localConnectionResult)) {
          zzaak.zzg(this.zzaBa).put(localzzzz, new ConnectionResult(16));
        } else {
          zzaak.zzg(this.zzaBa).put(localzzzz, localConnectionResult);
        }
      }
    }
    zzaak.zzb(this.zzaBa, paramTask.zzvj());
    for (;;)
    {
      if (this.zzaBa.isConnected())
      {
        zzaak.zzd(this.zzaBa).putAll(zzaak.zzg(this.zzaBa));
        if (zzaak.zzf(this.zzaBa) == null)
        {
          zzaak.zzi(this.zzaBa);
          zzaak.zzj(this.zzaBa);
          zzaak.zzl(this.zzaBa).signalAll();
        }
      }
      this.zzaBb.zzrq();
      zzaak.zza(this.zzaBa).unlock();
      return;
      label417:
      paramTask.getException();
      zzaak.zzb(this.zzaBa, Collections.emptyMap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaak.zzb
 * JD-Core Version:    0.7.0.1
 */