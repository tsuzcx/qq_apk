package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.internal.zzac;

public abstract class ResolvingResultCallbacks<R extends Result>
  extends ResultCallbacks<R>
{
  private final Activity mActivity;
  private final int zzazu;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    this.mActivity = ((Activity)zzac.zzb(paramActivity, "Activity must not be null"));
    this.zzazu = paramInt;
  }
  
  public final void onFailure(Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      try
      {
        paramStatus.startResolutionForResult(this.mActivity, this.zzazu);
        return;
      }
      catch (IntentSender.SendIntentException paramStatus)
      {
        onUnresolvableFailure(new Status(8));
        return;
      }
    }
    onUnresolvableFailure(paramStatus);
  }
  
  public abstract void onSuccess(R paramR);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.api.ResolvingResultCallbacks
 * JD-Core Version:    0.7.0.1
 */