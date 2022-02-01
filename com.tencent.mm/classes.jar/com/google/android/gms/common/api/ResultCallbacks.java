package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(Status paramStatus);
  
  @KeepForSdk
  public final void onResult(R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess()) {
      onSuccess(paramR);
    }
    do
    {
      return;
      onFailure(localStatus);
    } while (!(paramR instanceof Releasable));
    try
    {
      ((Releasable)paramR).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramR = String.valueOf(paramR);
      new StringBuilder(String.valueOf(paramR).length() + 18).append("Unable to release ").append(paramR);
    }
  }
  
  public abstract void onSuccess(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.ResultCallbacks
 * JD-Core Version:    0.7.0.1
 */