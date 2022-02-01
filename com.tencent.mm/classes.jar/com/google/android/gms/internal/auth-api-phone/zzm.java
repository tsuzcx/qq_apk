package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzm
  extends TaskApiCall<zzi, Void>
{
  private TaskCompletionSource<Void> zzf;
  
  protected abstract void zza(zze paramzze);
  
  protected final void zzb(Status paramStatus)
  {
    TaskUtil.setResultOrApiException(paramStatus, this.zzf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzm
 * JD-Core Version:    0.7.0.1
 */