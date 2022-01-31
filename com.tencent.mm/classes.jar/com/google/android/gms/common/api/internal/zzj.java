package com.google.android.gms.common.api.internal;

import android.support.v4.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzj
{
  private final a<zzh<?>, ConnectionResult> zzcc;
  private final a<zzh<?>, String> zzei;
  private final TaskCompletionSource<Map<zzh<?>, String>> zzej;
  private int zzek;
  private boolean zzel;
  
  public zzj(Iterable<? extends GoogleApi<?>> paramIterable)
  {
    AppMethodBeat.i(60935);
    this.zzei = new a();
    this.zzej = new TaskCompletionSource();
    this.zzel = false;
    this.zzcc = new a();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      GoogleApi localGoogleApi = (GoogleApi)paramIterable.next();
      this.zzcc.put(localGoogleApi.zzm(), null);
    }
    this.zzek = this.zzcc.keySet().size();
    AppMethodBeat.o(60935);
  }
  
  public final Task<Map<zzh<?>, String>> getTask()
  {
    AppMethodBeat.i(60937);
    Task localTask = this.zzej.getTask();
    AppMethodBeat.o(60937);
    return localTask;
  }
  
  public final void zza(zzh<?> paramzzh, ConnectionResult paramConnectionResult, String paramString)
  {
    AppMethodBeat.i(60938);
    this.zzcc.put(paramzzh, paramConnectionResult);
    this.zzei.put(paramzzh, paramString);
    this.zzek -= 1;
    if (!paramConnectionResult.isSuccess()) {
      this.zzel = true;
    }
    if (this.zzek == 0)
    {
      if (this.zzel)
      {
        paramzzh = new AvailabilityException(this.zzcc);
        this.zzej.setException(paramzzh);
        AppMethodBeat.o(60938);
        return;
      }
      this.zzej.setResult(this.zzei);
    }
    AppMethodBeat.o(60938);
  }
  
  public final Set<zzh<?>> zzs()
  {
    AppMethodBeat.i(60936);
    Set localSet = this.zzcc.keySet();
    AppMethodBeat.o(60936);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzj
 * JD-Core Version:    0.7.0.1
 */