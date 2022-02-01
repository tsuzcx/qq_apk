package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract interface zzba
  extends IInterface
{
  public abstract void zzd(Status paramStatus, Credential paramCredential);
  
  public abstract void zzd(Status paramStatus, String paramString);
  
  public abstract void zze(Status paramStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzba
 * JD-Core Version:    0.7.0.1
 */