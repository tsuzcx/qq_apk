package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public abstract class zzaae
  extends zzabe
  implements DialogInterface.OnCancelListener
{
  protected boolean mStarted;
  private ConnectionResult zzaAa;
  private int zzaAb = -1;
  private final Handler zzaAc = new Handler(Looper.getMainLooper());
  protected boolean zzazZ;
  protected final GoogleApiAvailability zzazn;
  
  protected zzaae(zzabf paramzzabf)
  {
    this(paramzzabf, GoogleApiAvailability.getInstance());
  }
  
  zzaae(zzabf paramzzabf, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramzzabf);
    this.zzazn = paramGoogleApiAvailability;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramInt1 != 0)
      {
        zzvD();
        return;
      }
      break;
    case 2: 
      label30:
      j = this.zzazn.isGooglePlayServicesAvailable(getActivity());
      if (j != 0) {}
      break;
    }
    for (paramInt2 = i;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (this.zzaAa.getErrorCode() != 18) {
        break label30;
      }
      paramInt1 = paramInt2;
      if (j != 18) {
        break label30;
      }
      return;
      paramInt1 = j;
      if (paramInt2 == -1) {
        break label30;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (paramIntent != null) {}
      for (paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);; paramInt1 = 13)
      {
        this.zzaAa = new ConnectionResult(paramInt1, null);
        break;
        zza(this.zzaAa, this.zzaAb);
        return;
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(new ConnectionResult(13, null), this.zzaAb);
    zzvD();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.zzazZ = paramBundle.getBoolean("resolving_error", false);
      if (this.zzazZ)
      {
        this.zzaAb = paramBundle.getInt("failed_client_id", -1);
        this.zzaAa = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.zzazZ);
    if (this.zzazZ)
    {
      paramBundle.putInt("failed_client_id", this.zzaAb);
      paramBundle.putInt("failed_status", this.zzaAa.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.zzaAa.getResolution());
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
  
  public void zzb(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!this.zzazZ)
    {
      this.zzazZ = true;
      this.zzaAb = paramInt;
      this.zzaAa = paramConnectionResult;
      this.zzaAc.post(new zzaae.zza(this, null));
    }
  }
  
  protected void zzvD()
  {
    this.zzaAb = -1;
    this.zzazZ = false;
    this.zzaAa = null;
    zzvx();
  }
  
  protected abstract void zzvx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaae
 * JD-Core Version:    0.7.0.1
 */