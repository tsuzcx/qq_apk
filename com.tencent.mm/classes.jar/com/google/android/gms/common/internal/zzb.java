package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzd;

public class zzb
{
  public static zza zzG(Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      return new zzd(paramStatus);
    }
    return new zza(paramStatus);
  }
  
  public static zza zzl(ConnectionResult paramConnectionResult)
  {
    return zzG(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzb
 * JD-Core Version:    0.7.0.1
 */