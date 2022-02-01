package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CredentialRequestResponse
  extends Response<CredentialRequestResult>
{
  public Credential getCredential()
  {
    AppMethodBeat.i(88223);
    Credential localCredential = ((CredentialRequestResult)getResult()).getCredential();
    AppMethodBeat.o(88223);
    return localCredential;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequestResponse
 * JD-Core Version:    0.7.0.1
 */