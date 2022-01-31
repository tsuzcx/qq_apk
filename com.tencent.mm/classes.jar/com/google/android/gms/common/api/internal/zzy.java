package com.google.android.gms.common.api.internal;

import android.support.v4.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class zzy
  implements OnCompleteListener<Map<zzh<?>, String>>
{
  private zzy(zzw paramzzw) {}
  
  public final void onComplete(Task<Map<zzh<?>, String>> paramTask)
  {
    AppMethodBeat.i(61006);
    zzw.zza(this.zzgu).lock();
    Object localObject;
    try
    {
      boolean bool = zzw.zzb(this.zzgu);
      if (!bool) {
        return;
      }
      if (paramTask.isSuccessful())
      {
        zzw.zza(this.zzgu, new a(zzw.zzc(this.zzgu).size()));
        paramTask = zzw.zzc(this.zzgu).values().iterator();
        while (paramTask.hasNext())
        {
          localObject = (zzv)paramTask.next();
          zzw.zzd(this.zzgu).put(((GoogleApi)localObject).zzm(), ConnectionResult.RESULT_SUCCESS);
        }
      }
      if (!(paramTask.getException() instanceof AvailabilityException)) {
        break label455;
      }
    }
    finally
    {
      zzw.zza(this.zzgu).unlock();
      AppMethodBeat.o(61006);
    }
    paramTask = (AvailabilityException)paramTask.getException();
    if (zzw.zze(this.zzgu))
    {
      zzw.zza(this.zzgu, new a(zzw.zzc(this.zzgu).size()));
      localObject = zzw.zzc(this.zzgu).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzv localzzv = (zzv)((Iterator)localObject).next();
        zzh localzzh = localzzv.zzm();
        ConnectionResult localConnectionResult = paramTask.getConnectionResult(localzzv);
        if (zzw.zza(this.zzgu, localzzv, localConnectionResult)) {
          zzw.zzd(this.zzgu).put(localzzh, new ConnectionResult(16));
        } else {
          zzw.zzd(this.zzgu).put(localzzh, localConnectionResult);
        }
      }
    }
    zzw.zza(this.zzgu, paramTask.zzl());
    zzw.zza(this.zzgu, zzw.zzf(this.zzgu));
    if (zzw.zzg(this.zzgu) != null)
    {
      zzw.zzd(this.zzgu).putAll(zzw.zzg(this.zzgu));
      zzw.zza(this.zzgu, zzw.zzf(this.zzgu));
    }
    if (zzw.zzh(this.zzgu) == null)
    {
      zzw.zzi(this.zzgu);
      zzw.zzj(this.zzgu);
    }
    for (;;)
    {
      zzw.zzl(this.zzgu).signalAll();
      zzw.zza(this.zzgu).unlock();
      AppMethodBeat.o(61006);
      return;
      label455:
      paramTask.getException();
      zzw.zza(this.zzgu, Collections.emptyMap());
      zzw.zza(this.zzgu, new ConnectionResult(8));
      break;
      zzw.zza(this.zzgu, false);
      zzw.zzk(this.zzgu).zzc(zzw.zzh(this.zzgu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzy
 * JD-Core Version:    0.7.0.1
 */