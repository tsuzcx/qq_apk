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
    AppMethodBeat.i(88238);
    DEFAULT = (CredentialsOptions)new Builder().zzh();
    AppMethodBeat.o(88238);
  }
  
  private CredentialsOptions(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final class Builder
    extends Auth.AuthCredentialsOptions.Builder
  {
    public final CredentialsOptions build()
    {
      AppMethodBeat.i(88235);
      CredentialsOptions localCredentialsOptions = new CredentialsOptions(this, null);
      AppMethodBeat.o(88235);
      return localCredentialsOptions;
    }
    
    public final Builder forceEnableSaveDialog()
    {
      this.zzar = Boolean.TRUE;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsOptions
 * JD-Core Version:    0.7.0.1
 */