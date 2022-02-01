package com.google.android.gms.common.api.internal;

import androidx.b.a;
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

final class zzz
  implements OnCompleteListener<Map<zzh<?>, String>>
{
  private SignInConnectionListener zzgv;
  
  zzz(zzw paramzzw, SignInConnectionListener paramSignInConnectionListener)
  {
    this.zzgv = paramSignInConnectionListener;
  }
  
  final void cancel()
  {
    AppMethodBeat.i(11499);
    this.zzgv.onComplete();
    AppMethodBeat.o(11499);
  }
  
  public final void onComplete(Task<Map<zzh<?>, String>> paramTask)
  {
    AppMethodBeat.i(11500);
    zzw.zza(this.zzgu).lock();
    Object localObject;
    try
    {
      if (!zzw.zzb(this.zzgu))
      {
        this.zzgv.onComplete();
        return;
      }
      if (paramTask.isSuccessful())
      {
        zzw.zzb(this.zzgu, new a(zzw.zzm(this.zzgu).size()));
        paramTask = zzw.zzm(this.zzgu).values().iterator();
        while (paramTask.hasNext())
        {
          localObject = (zzv)paramTask.next();
          zzw.zzg(this.zzgu).put(((GoogleApi)localObject).zzm(), ConnectionResult.RESULT_SUCCESS);
        }
      }
      if (!(paramTask.getException() instanceof AvailabilityException)) {
        break label441;
      }
    }
    finally
    {
      zzw.zza(this.zzgu).unlock();
      AppMethodBeat.o(11500);
    }
    paramTask = (AvailabilityException)paramTask.getException();
    if (zzw.zze(this.zzgu))
    {
      zzw.zzb(this.zzgu, new a(zzw.zzm(this.zzgu).size()));
      localObject = zzw.zzm(this.zzgu).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzv localzzv = (zzv)((Iterator)localObject).next();
        zzh localzzh = localzzv.zzm();
        ConnectionResult localConnectionResult = paramTask.getConnectionResult(localzzv);
        if (zzw.zza(this.zzgu, localzzv, localConnectionResult)) {
          zzw.zzg(this.zzgu).put(localzzh, new ConnectionResult(16));
        } else {
          zzw.zzg(this.zzgu).put(localzzh, localConnectionResult);
        }
      }
    }
    zzw.zzb(this.zzgu, paramTask.zzl());
    for (;;)
    {
      if (this.zzgu.isConnected())
      {
        zzw.zzd(this.zzgu).putAll(zzw.zzg(this.zzgu));
        if (zzw.zzf(this.zzgu) == null)
        {
          zzw.zzi(this.zzgu);
          zzw.zzj(this.zzgu);
          zzw.zzl(this.zzgu).signalAll();
        }
      }
      this.zzgv.onComplete();
      zzw.zza(this.zzgu).unlock();
      AppMethodBeat.o(11500);
      return;
      label441:
      paramTask.getException();
      zzw.zzb(this.zzgu, Collections.emptyMap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzz
 * JD-Core Version:    0.7.0.1
 */