package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

public class zzbt
  extends zzk
{
  private TaskCompletionSource<Void> zzln;
  
  private zzbt(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    AppMethodBeat.i(11340);
    this.zzln = new TaskCompletionSource();
    this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
    AppMethodBeat.o(11340);
  }
  
  public static zzbt zzd(Activity paramActivity)
  {
    AppMethodBeat.i(11339);
    paramActivity = getFragment(paramActivity);
    zzbt localzzbt = (zzbt)paramActivity.getCallbackOrNull("GmsAvailabilityHelper", zzbt.class);
    if (localzzbt != null)
    {
      if (localzzbt.zzln.getTask().isComplete()) {
        localzzbt.zzln = new TaskCompletionSource();
      }
      AppMethodBeat.o(11339);
      return localzzbt;
    }
    paramActivity = new zzbt(paramActivity);
    AppMethodBeat.o(11339);
    return paramActivity;
  }
  
  public final Task<Void> getTask()
  {
    AppMethodBeat.i(11344);
    Task localTask = this.zzln.getTask();
    AppMethodBeat.o(11344);
    return localTask;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(11343);
    super.onDestroy();
    this.zzln.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    AppMethodBeat.o(11343);
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(11341);
    this.zzln.setException(ApiExceptionUtil.fromConnectionResult(paramConnectionResult));
    AppMethodBeat.o(11341);
  }
  
  protected final void zzr()
  {
    AppMethodBeat.i(11342);
    int i = this.zzdg.isGooglePlayServicesAvailable(this.mLifecycleFragment.getLifecycleActivity());
    if (i == 0)
    {
      this.zzln.setResult(null);
      AppMethodBeat.o(11342);
      return;
    }
    if (!this.zzln.getTask().isComplete()) {
      zzb(new ConnectionResult(i, null), 0);
    }
    AppMethodBeat.o(11342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbt
 * JD-Core Version:    0.7.0.1
 */