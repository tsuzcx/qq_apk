package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzk
  extends LifecycleCallback
  implements DialogInterface.OnCancelListener
{
  protected volatile boolean mStarted;
  protected final GoogleApiAvailability zzdg;
  protected final AtomicReference<zzl> zzer = new AtomicReference(null);
  private final Handler zzes = new Handler(Looper.getMainLooper());
  
  protected zzk(LifecycleFragment paramLifecycleFragment)
  {
    this(paramLifecycleFragment, GoogleApiAvailability.getInstance());
  }
  
  @VisibleForTesting
  private zzk(LifecycleFragment paramLifecycleFragment, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramLifecycleFragment);
    this.zzdg = paramGoogleApiAvailability;
  }
  
  private static int zza(zzl paramzzl)
  {
    if (paramzzl == null) {
      return -1;
    }
    return paramzzl.zzu();
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 13;
    zzl localzzl = (zzl)this.zzer.get();
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramIntent = localzzl;
      if (paramInt1 != 0)
      {
        zzt();
        return;
      }
      break;
    case 2: 
      label45:
      label53:
      i = this.zzdg.isGooglePlayServicesAvailable(getActivity());
      if (i != 0) {}
      break;
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (localzzl == null) {
        break label53;
      }
      paramIntent = localzzl;
      paramInt1 = paramInt2;
      if (localzzl.getConnectionResult().getErrorCode() != 18) {
        break label45;
      }
      paramIntent = localzzl;
      paramInt1 = paramInt2;
      if (i != 18) {
        break label45;
      }
      return;
      if (paramInt2 == -1)
      {
        paramInt1 = 1;
        paramIntent = localzzl;
        break label45;
      }
      if (paramInt2 != 0) {
        break;
      }
      paramInt1 = i;
      if (paramIntent != null) {
        paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
      }
      paramIntent = new zzl(new ConnectionResult(paramInt1, null), zza(localzzl));
      this.zzer.set(paramIntent);
      paramInt1 = 0;
      break label45;
      if (paramIntent == null) {
        break label53;
      }
      zza(paramIntent.getConnectionResult(), paramIntent.zzu());
      return;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(new ConnectionResult(13, null), zza((zzl)this.zzer.get()));
    zzt();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AtomicReference localAtomicReference;
    if (paramBundle != null)
    {
      localAtomicReference = this.zzer;
      if (!paramBundle.getBoolean("resolving_error", false)) {
        break label67;
      }
    }
    label67:
    for (paramBundle = new zzl(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1));; paramBundle = null)
    {
      localAtomicReference.set(paramBundle);
      return;
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    zzl localzzl = (zzl)this.zzer.get();
    if (localzzl != null)
    {
      paramBundle.putBoolean("resolving_error", true);
      paramBundle.putInt("failed_client_id", localzzl.zzu());
      paramBundle.putInt("failed_status", localzzl.getConnectionResult().getErrorCode());
      paramBundle.putParcelable("failed_resolution", localzzl.getConnectionResult().getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStarted = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.mStarted = false;
  }
  
  protected abstract void zza(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void zzb(ConnectionResult paramConnectionResult, int paramInt)
  {
    paramConnectionResult = new zzl(paramConnectionResult, paramInt);
    if (this.zzer.compareAndSet(null, paramConnectionResult)) {
      this.zzes.post(new zzm(this, paramConnectionResult));
    }
  }
  
  protected abstract void zzr();
  
  protected final void zzt()
  {
    this.zzer.set(null);
    zzr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzk
 * JD-Core Version:    0.7.0.1
 */