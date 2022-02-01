package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzr
{
  private final ScheduledExecutorService zzbz;
  @GuardedBy("this")
  private zzt zzca;
  @GuardedBy("this")
  private int zzcb;
  private final Context zzk;
  
  public zzr(Context paramContext)
  {
    this(paramContext, Executors.newSingleThreadScheduledExecutor());
    AppMethodBeat.i(2553);
    AppMethodBeat.o(2553);
  }
  
  private zzr(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(2554);
    this.zzca = new zzt(this, null);
    this.zzcb = 1;
    this.zzk = paramContext.getApplicationContext();
    this.zzbz = paramScheduledExecutorService;
    AppMethodBeat.o(2554);
  }
  
  private final <T> Task<T> zzd(zzz<T> paramzzz)
  {
    try
    {
      AppMethodBeat.i(2556);
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramzzz);
        new StringBuilder(String.valueOf(str).length() + 9).append("Queueing ").append(str);
      }
      if (!this.zzca.zze(paramzzz))
      {
        this.zzca = new zzt(this, null);
        this.zzca.zze(paramzzz);
      }
      paramzzz = paramzzz.zzcl.getTask();
      AppMethodBeat.o(2556);
      return paramzzz;
    }
    finally {}
  }
  
  private final int zzq()
  {
    try
    {
      int i = this.zzcb;
      this.zzcb = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Task<Bundle> zzd(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(2555);
    paramBundle = zzd(new zzab(zzq(), 1, paramBundle));
    AppMethodBeat.o(2555);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.zzr
 * JD-Core Version:    0.7.0.1
 */