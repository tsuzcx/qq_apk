package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzva
{
  public static Intent zza(Context paramContext, HintRequest paramHintRequest, PasswordSpecification paramPasswordSpecification)
  {
    paramContext = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints");
    zzd.zza(paramPasswordSpecification, paramContext, "com.google.android.gms.credentials.PasswordSpecification");
    zzd.zza(paramHintRequest, paramContext, "com.google.android.gms.credentials.HintRequest");
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzva
 * JD-Core Version:    0.7.0.1
 */