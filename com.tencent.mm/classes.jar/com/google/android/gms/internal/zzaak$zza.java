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

class zzaak$zza
  implements OnCompleteListener<Void>
{
  private zzaak$zza(zzaak paramzzaak) {}
  
  public void onComplete(Task<Void> paramTask)
  {
    zzaak.zza(this.zzaBa).lock();
    Object localObject;
    try
    {
      boolean bool = zzaak.zzb(this.zzaBa);
      if (!bool) {
        return;
      }
      if (paramTask.isSuccessful())
      {
        zzaak.zza(this.zzaBa, new a(zzaak.zzc(this.zzaBa).size()));
        paramTask = zzaak.zzc(this.zzaBa).values().iterator();
        while (paramTask.hasNext())
        {
          localObject = (zzaaj)paramTask.next();
          zzaak.zzd(this.zzaBa).put(((zzaaj)localObject).getApiKey(), ConnectionResult.zzayj);
        }
      }
      if (!(paramTask.getException() instanceof zzb)) {
        break label435;
      }
    }
    finally
    {
      zzaak.zza(this.zzaBa).unlock();
    }
    paramTask = (zzb)paramTask.getException();
    if (zzaak.zze(this.zzaBa))
    {
      zzaak.zza(this.zzaBa, new a(zzaak.zzc(this.zzaBa).size()));
      localObject = zzaak.zzc(this.zzaBa).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzaaj localzzaaj = (zzaaj)((Iterator)localObject).next();
        zzzz localzzzz = localzzaaj.getApiKey();
        ConnectionResult localConnectionResult = paramTask.zza(localzzaaj);
        if (zzaak.zza(this.zzaBa, localzzaaj, localConnectionResult)) {
          zzaak.zzd(this.zzaBa).put(localzzzz, new ConnectionResult(16));
        } else {
          zzaak.zzd(this.zzaBa).put(localzzzz, localConnectionResult);
        }
      }
    }
    zzaak.zza(this.zzaBa, paramTask.zzvj());
    zzaak.zza(this.zzaBa, zzaak.zzf(this.zzaBa));
    if (zzaak.zzg(this.zzaBa) != null)
    {
      zzaak.zzd(this.zzaBa).putAll(zzaak.zzg(this.zzaBa));
      zzaak.zza(this.zzaBa, zzaak.zzf(this.zzaBa));
    }
    if (zzaak.zzh(this.zzaBa) == null)
    {
      zzaak.zzi(this.zzaBa);
      zzaak.zzj(this.zzaBa);
    }
    for (;;)
    {
      zzaak.zzl(this.zzaBa).signalAll();
      zzaak.zza(this.zzaBa).unlock();
      return;
      label435:
      paramTask.getException();
      zzaak.zza(this.zzaBa, Collections.emptyMap());
      zzaak.zza(this.zzaBa, new ConnectionResult(8));
      break;
      zzaak.zza(this.zzaBa, false);
      zzaak.zzk(this.zzaBa).zzc(zzaak.zzh(this.zzaBa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzaak.zza
 * JD-Core Version:    0.7.0.1
 */