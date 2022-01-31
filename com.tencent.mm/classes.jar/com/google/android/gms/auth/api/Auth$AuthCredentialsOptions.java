package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class Auth$AuthCredentialsOptions
  implements Api.ApiOptions.Optional
{
  private static final AuthCredentialsOptions zzan;
  private final String zzao;
  private final PasswordSpecification zzap;
  private final boolean zzaq;
  
  static
  {
    AppMethodBeat.i(50306);
    zzan = new Builder().zzh();
    AppMethodBeat.o(50306);
  }
  
  public Auth$AuthCredentialsOptions(Builder paramBuilder)
  {
    AppMethodBeat.i(50304);
    this.zzao = null;
    this.zzap = paramBuilder.zzap;
    this.zzaq = paramBuilder.zzar.booleanValue();
    AppMethodBeat.o(50304);
  }
  
  public final Bundle toBundle()
  {
    AppMethodBeat.i(50305);
    Bundle localBundle = new Bundle();
    localBundle.putString("consumer_package", null);
    localBundle.putParcelable("password_specification", this.zzap);
    localBundle.putBoolean("force_save_dialog", this.zzaq);
    AppMethodBeat.o(50305);
    return localBundle;
  }
  
  public final PasswordSpecification zzg()
  {
    return this.zzap;
  }
  
  @Deprecated
  public static class Builder
  {
    protected PasswordSpecification zzap = PasswordSpecification.zzdg;
    protected Boolean zzar = Boolean.FALSE;
    
    public Builder forceEnableSaveDialog()
    {
      this.zzar = Boolean.TRUE;
      return this;
    }
    
    public Auth.AuthCredentialsOptions zzh()
    {
      AppMethodBeat.i(50303);
      Auth.AuthCredentialsOptions localAuthCredentialsOptions = new Auth.AuthCredentialsOptions(this);
      AppMethodBeat.o(50303);
      return localAuthCredentialsOptions;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.Auth.AuthCredentialsOptions
 * JD-Core Version:    0.7.0.1
 */