package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzaa
{
  private final Map<BasePendingResult<?>, Boolean> zzgw;
  private final Map<TaskCompletionSource<?>, Boolean> zzgx;
  
  public zzaa()
  {
    AppMethodBeat.i(11168);
    this.zzgw = Collections.synchronizedMap(new WeakHashMap());
    this.zzgx = Collections.synchronizedMap(new WeakHashMap());
    AppMethodBeat.o(11168);
  }
  
  private final void zza(boolean paramBoolean, Status paramStatus)
  {
    AppMethodBeat.i(11174);
    Object localObject2;
    synchronized (this.zzgw)
    {
      localObject2 = new HashMap(this.zzgw);
    }
    synchronized (this.zzgx)
    {
      ??? = new HashMap(this.zzgx);
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (Map.Entry)((Iterator)localObject2).next();
        if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue()))
        {
          ((BasePendingResult)((Map.Entry)???).getKey()).zzb(paramStatus);
          continue;
          paramStatus = finally;
          AppMethodBeat.o(11174);
          throw paramStatus;
        }
      }
    }
    ??? = ((Map)???).entrySet().iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)???).next();
      if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {
        ((TaskCompletionSource)((Map.Entry)localObject2).getKey()).trySetException(new ApiException(paramStatus));
      }
    }
    AppMethodBeat.o(11174);
  }
  
  final void zza(BasePendingResult<? extends Result> paramBasePendingResult, boolean paramBoolean)
  {
    AppMethodBeat.i(11169);
    this.zzgw.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zzab(this, paramBasePendingResult));
    AppMethodBeat.o(11169);
  }
  
  final <TResult> void zza(TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean)
  {
    AppMethodBeat.i(11170);
    this.zzgx.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zzac(this, paramTaskCompletionSource));
    AppMethodBeat.o(11170);
  }
  
  final boolean zzaj()
  {
    AppMethodBeat.i(11171);
    if ((!this.zzgw.isEmpty()) || (!this.zzgx.isEmpty()))
    {
      AppMethodBeat.o(11171);
      return true;
    }
    AppMethodBeat.o(11171);
    return false;
  }
  
  public final void zzak()
  {
    AppMethodBeat.i(11172);
    zza(false, GoogleApiManager.zzjj);
    AppMethodBeat.o(11172);
  }
  
  public final void zzal()
  {
    AppMethodBeat.i(11173);
    zza(true, zzck.zzmm);
    AppMethodBeat.o(11173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaa
 * JD-Core Version:    0.7.0.1
 */