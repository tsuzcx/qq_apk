package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CredentialsOptions
  extends Auth.AuthCredentialsOptions
{
  public static final CredentialsOptions DEFAULT;
  
  static
  {
    AppMethodBeat.i(50343);
    DEFAULT = (CredentialsOptions)new CredentialsOptions.Builder().zzh();
    AppMethodBeat.o(50343);
  }
  
  private CredentialsOptions(CredentialsOptions.Builder paramBuilder)
  {
    super(paramBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsOptions
 * JD-Core Version:    0.7.0.1
 */