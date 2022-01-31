package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

class zzaae$zza
  implements Runnable
{
  private zzaae$zza(zzaae paramzzaae) {}
  
  public void run()
  {
    if (!this.zzaAd.mStarted) {
      return;
    }
    if (zzaae.zza(this.zzaAd).hasResolution())
    {
      this.zzaAd.zzaCR.startActivityForResult(GoogleApiActivity.zzb(this.zzaAd.getActivity(), zzaae.zza(this.zzaAd).getResolution(), zzaae.zzb(this.zzaAd), false), 1);
      return;
    }
    if (this.zzaAd.zzazn.isUserResolvableError(zzaae.zza(this.zzaAd).getErrorCode()))
    {
      this.zzaAd.zzazn.zza(this.zzaAd.getActivity(), this.zzaAd.zzaCR, zzaae.zza(this.zzaAd).getErrorCode(), 2, this.zzaAd);
      return;
    }
    if (zzaae.zza(this.zzaAd).getErrorCode() == 18)
    {
      Dialog localDialog = this.zzaAd.zzazn.zza(this.zzaAd.getActivity(), this.zzaAd);
      this.zzaAd.zzazn.zza(this.zzaAd.getActivity().getApplicationContext(), new zzaae.zza.1(this, localDialog));
      return;
    }
    this.zzaAd.zza(zzaae.zza(this.zzaAd), zzaae.zzb(this.zzaAd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaae.zza
 * JD-Core Version:    0.7.0.1
 */