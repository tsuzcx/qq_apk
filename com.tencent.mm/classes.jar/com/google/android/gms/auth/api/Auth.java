package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzao;
import com.google.android.gms.internal.auth.zzax;
import com.google.android.gms.internal.auth.zzbn;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Auth
{
  public static final Api<Auth.AuthCredentialsOptions> CREDENTIALS_API;
  public static final CredentialsApi CredentialsApi;
  public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
  public static final GoogleSignInApi GoogleSignInApi;
  @KeepForSdk
  public static final Api<zzh> PROXY_API;
  @KeepForSdk
  public static final ProxyApi ProxyApi;
  public static final Api.ClientKey<zzax> zzaj;
  public static final Api.ClientKey<com.google.android.gms.auth.api.signin.internal.zzh> zzak;
  private static final Api.AbstractClientBuilder<zzax, Auth.AuthCredentialsOptions> zzal;
  private static final Api.AbstractClientBuilder<com.google.android.gms.auth.api.signin.internal.zzh, GoogleSignInOptions> zzam;
  
  static
  {
    AppMethodBeat.i(50307);
    zzaj = new Api.ClientKey();
    zzak = new Api.ClientKey();
    zzal = new zzd();
    zzam = new zze();
    PROXY_API = zzf.API;
    CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzal, zzaj);
    GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzam, zzak);
    ProxyApi = new zzbn();
    CredentialsApi = new zzao();
    GoogleSignInApi = new zzg();
    AppMethodBeat.o(50307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.Auth
 * JD-Core Version:    0.7.0.1
 */