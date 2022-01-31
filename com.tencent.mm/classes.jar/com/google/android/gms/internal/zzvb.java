package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzvb
  implements CredentialRequestResult
{
  private final Status zzair;
  private final Credential zzajL;
  
  public zzvb(Status paramStatus, Credential paramCredential)
  {
    this.zzair = paramStatus;
    this.zzajL = paramCredential;
  }
  
  public static zzvb zzi(Status paramStatus)
  {
    return new zzvb(paramStatus, null);
  }
  
  public final Credential getCredential()
  {
    return this.zzajL;
  }
  
  public final Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzvb
 * JD-Core Version:    0.7.0.1
 */