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
    AppMethodBeat.i(60848);
    this.zzln = new TaskCompletionSource();
    this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
    AppMethodBeat.o(60848);
  }
  
  public static zzbt zzd(Activity paramActivity)
  {
    AppMethodBeat.i(60847);
    paramActivity = getFragment(paramActivity);
    zzbt localzzbt = (zzbt)paramActivity.getCallbackOrNull("GmsAvailabilityHelper", zzbt.class);
    if (localzzbt != null)
    {
      if (localzzbt.zzln.getTask().isComplete()) {
        localzzbt.zzln = new TaskCompletionSource();
      }
      AppMethodBeat.o(60847);
      return localzzbt;
    }
    paramActivity = new zzbt(paramActivity);
    AppMethodBeat.o(60847);
    return paramActivity;
  }
  
  public final Task<Void> getTask()
  {
    AppMethodBeat.i(60852);
    Task localTask = this.zzln.getTask();
    AppMethodBeat.o(60852);
    return localTask;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(60851);
    super.onDestroy();
    this.zzln.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    AppMethodBeat.o(60851);
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(60849);
    this.zzln.setException(ApiExceptionUtil.fromConnectionResult(paramConnectionResult));
    AppMethodBeat.o(60849);
  }
  
  protected final void zzr()
  {
    AppMethodBeat.i(60850);
    int i = this.zzdg.isGooglePlayServicesAvailable(this.mLifecycleFragment.getLifecycleActivity());
    if (i == 0)
    {
      this.zzln.setResult(null);
      AppMethodBeat.o(60850);
      return;
    }
    if (!this.zzln.getTask().isComplete()) {
      zzb(new ConnectionResult(i, null), 0);
    }
    AppMethodBeat.o(60850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbt
 * JD-Core Version:    0.7.0.1
 */