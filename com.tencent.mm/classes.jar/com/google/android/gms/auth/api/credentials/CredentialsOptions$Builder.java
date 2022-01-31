package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CredentialsOptions$Builder
  extends Auth.AuthCredentialsOptions.Builder
{
  public final CredentialsOptions build()
  {
    AppMethodBeat.i(50340);
    CredentialsOptions localCredentialsOptions = new CredentialsOptions(this, null);
    AppMethodBeat.o(50340);
    return localCredentialsOptions;
  }
  
  public final Builder forceEnableSaveDialog()
  {
    this.zzar = Boolean.TRUE;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsOptions.Builder
 * JD-Core Version:    0.7.0.1
 */