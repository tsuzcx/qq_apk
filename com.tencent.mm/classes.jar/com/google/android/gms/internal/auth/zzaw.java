package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaw
{
  public static PendingIntent zzd(Context paramContext, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, HintRequest paramHintRequest)
  {
    AppMethodBeat.i(88380);
    Preconditions.checkNotNull(paramContext, "context must not be null");
    Preconditions.checkNotNull(paramHintRequest, "request must not be null");
    if ((paramAuthCredentialsOptions != null) && (paramAuthCredentialsOptions.zzg() != null)) {}
    for (paramAuthCredentialsOptions = paramAuthCredentialsOptions.zzg();; paramAuthCredentialsOptions = PasswordSpecification.zzdg)
    {
      Intent localIntent = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", null);
      SafeParcelableSerializer.serializeToIntentExtra(paramAuthCredentialsOptions, localIntent, "com.google.android.gms.credentials.PasswordSpecification");
      SafeParcelableSerializer.serializeToIntentExtra(paramHintRequest, localIntent, "com.google.android.gms.credentials.HintRequest");
      paramContext = PendingIntent.getActivity(paramContext, 2000, localIntent, 134217728);
      AppMethodBeat.o(88380);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzaw
 * JD-Core Version:    0.7.0.1
 */