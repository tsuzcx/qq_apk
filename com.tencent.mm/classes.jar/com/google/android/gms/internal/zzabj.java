package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzabj
  extends zzaae
{
  private TaskCompletionSource<Void> zzazE = new TaskCompletionSource();
  
  private zzabj(zzabf paramzzabf)
  {
    super(paramzzabf);
    this.zzaCR.zza("GmsAvailabilityHelper", this);
  }
  
  public static zzabj zzu(Activity paramActivity)
  {
    paramActivity = zzs(paramActivity);
    zzabj localzzabj = (zzabj)paramActivity.zza("GmsAvailabilityHelper", zzabj.class);
    if (localzzabj != null)
    {
      if (localzzabj.zzazE.getTask().isComplete()) {
        localzzabj.zzazE = new TaskCompletionSource();
      }
      return localzzabj;
    }
    return new zzabj(paramActivity);
  }
  
  public Task<Void> getTask()
  {
    return this.zzazE.getTask();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.zzazE.setException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.zzazE.setException(zzb.zzl(paramConnectionResult));
  }
  
  public void zzk(ConnectionResult paramConnectionResult)
  {
    zzb(paramConnectionResult, 0);
  }
  
  protected void zzvx()
  {
    int i = this.zzazn.isGooglePlayServicesAvailable(this.zzaCR.zzwV());
    if (i == 0)
    {
      this.zzazE.setResult(null);
      return;
    }
    zzk(new ConnectionResult(i, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzabj
 * JD-Core Version:    0.7.0.1
 */