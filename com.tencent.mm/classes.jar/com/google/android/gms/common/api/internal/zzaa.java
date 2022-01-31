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
    AppMethodBeat.i(60676);
    this.zzgw = Collections.synchronizedMap(new WeakHashMap());
    this.zzgx = Collections.synchronizedMap(new WeakHashMap());
    AppMethodBeat.o(60676);
  }
  
  private final void zza(boolean paramBoolean, Status paramStatus)
  {
    AppMethodBeat.i(60682);
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
          AppMethodBeat.o(60682);
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
    AppMethodBeat.o(60682);
  }
  
  final void zza(BasePendingResult<? extends Result> paramBasePendingResult, boolean paramBoolean)
  {
    AppMethodBeat.i(60677);
    this.zzgw.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zzab(this, paramBasePendingResult));
    AppMethodBeat.o(60677);
  }
  
  final <TResult> void zza(TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean)
  {
    AppMethodBeat.i(60678);
    this.zzgx.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zzac(this, paramTaskCompletionSource));
    AppMethodBeat.o(60678);
  }
  
  final boolean zzaj()
  {
    AppMethodBeat.i(60679);
    if ((!this.zzgw.isEmpty()) || (!this.zzgx.isEmpty()))
    {
      AppMethodBeat.o(60679);
      return true;
    }
    AppMethodBeat.o(60679);
    return false;
  }
  
  public final void zzak()
  {
    AppMethodBeat.i(60680);
    zza(false, GoogleApiManager.zzjj);
    AppMethodBeat.o(60680);
  }
  
  public final void zzal()
  {
    AppMethodBeat.i(60681);
    zza(true, zzck.zzmm);
    AppMethodBeat.o(60681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaa
 * JD-Core Version:    0.7.0.1
 */