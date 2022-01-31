package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.zzac;

public class zzve
{
  public static PendingIntent zza(Context paramContext, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, HintRequest paramHintRequest)
  {
    zzac.zzb(paramContext, "context must not be null");
    zzac.zzb(paramHintRequest, "request must not be null");
    return PendingIntent.getActivity(paramContext, 2000, zzva.zza(paramContext, paramHintRequest, zza(paramAuthCredentialsOptions)), 268435456);
  }
  
  public static PasswordSpecification zza(Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    if ((paramAuthCredentialsOptions != null) && (paramAuthCredentialsOptions.zzqT() != null)) {
      return paramAuthCredentialsOptions.zzqT();
    }
    return PasswordSpecification.zzajC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzve
 * JD-Core Version:    0.7.0.1
 */