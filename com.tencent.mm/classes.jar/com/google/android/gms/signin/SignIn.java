package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignIn
{
  public static final Api<SignInOptions> API;
  public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> CLIENT_BUILDER;
  public static final Api.ClientKey<SignInClientImpl> CLIENT_KEY;
  public static final Api<SignIn.SignInOptionsInternal> INTERNAL_API;
  public static final Api.ClientKey<SignInClientImpl> INTERNAL_CLIENT_KEY;
  public static final Scope SCOPE_EMAIL;
  public static final Scope SCOPE_PROFILE;
  private static final Api.AbstractClientBuilder<SignInClientImpl, SignIn.SignInOptionsInternal> zzacz;
  
  static
  {
    AppMethodBeat.i(12136);
    CLIENT_KEY = new Api.ClientKey();
    INTERNAL_CLIENT_KEY = new Api.ClientKey();
    CLIENT_BUILDER = new zza();
    zzacz = new zzb();
    SCOPE_PROFILE = new Scope("profile");
    SCOPE_EMAIL = new Scope("email");
    API = new Api("SignIn.API", CLIENT_BUILDER, CLIENT_KEY);
    INTERNAL_API = new Api("SignIn.INTERNAL_API", zzacz, INTERNAL_CLIENT_KEY);
    AppMethodBeat.o(12136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.SignIn
 * JD-Core Version:    0.7.0.1
 */