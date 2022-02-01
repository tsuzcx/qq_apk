package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Result;

public abstract interface CredentialRequestResult
  extends Result
{
  public abstract Credential getCredential();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequestResult
 * JD-Core Version:    0.7.0.1
 */