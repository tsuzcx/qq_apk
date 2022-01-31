package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm
  implements Runnable
{
  private final zzl zzev;
  
  zzm(zzk paramzzk, zzl paramzzl)
  {
    this.zzev = paramzzl;
  }
  
  public final void run()
  {
    AppMethodBeat.i(60940);
    if (!this.zzew.mStarted)
    {
      AppMethodBeat.o(60940);
      return;
    }
    Object localObject = this.zzev.getConnectionResult();
    if (((ConnectionResult)localObject).hasResolution())
    {
      this.zzew.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zza(this.zzew.getActivity(), ((ConnectionResult)localObject).getResolution(), this.zzev.zzu(), false), 1);
      AppMethodBeat.o(60940);
      return;
    }
    if (this.zzew.zzdg.isUserResolvableError(((ConnectionResult)localObject).getErrorCode()))
    {
      this.zzew.zzdg.showErrorDialogFragment(this.zzew.getActivity(), this.zzew.mLifecycleFragment, ((ConnectionResult)localObject).getErrorCode(), 2, this.zzew);
      AppMethodBeat.o(60940);
      return;
    }
    if (((ConnectionResult)localObject).getErrorCode() == 18)
    {
      localObject = this.zzew.zzdg.showUpdatingDialog(this.zzew.getActivity(), this.zzew);
      this.zzew.zzdg.registerCallbackOnUpdate(this.zzew.getActivity().getApplicationContext(), new zzn(this, (Dialog)localObject));
      AppMethodBeat.o(60940);
      return;
    }
    this.zzew.zza((ConnectionResult)localObject, this.zzev.zzu());
    AppMethodBeat.o(60940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzm
 * JD-Core Version:    0.7.0.1
 */