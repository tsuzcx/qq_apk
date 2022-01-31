package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzan
  implements CredentialRequestResult
{
  private final Status mStatus;
  private final Credential zzdq;
  
  public zzan(Status paramStatus, Credential paramCredential)
  {
    this.mStatus = paramStatus;
    this.zzdq = paramCredential;
  }
  
  public static zzan zzf(Status paramStatus)
  {
    AppMethodBeat.i(50471);
    paramStatus = new zzan(paramStatus, null);
    AppMethodBeat.o(50471);
    return paramStatus;
  }
  
  public final Credential getCredential()
  {
    return this.zzdq;
  }
  
  public final Status getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzan
 * JD-Core Version:    0.7.0.1
 */