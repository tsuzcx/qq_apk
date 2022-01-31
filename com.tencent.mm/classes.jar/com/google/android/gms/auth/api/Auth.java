package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.internal.zzut;
import com.google.android.gms.internal.zzuu;
import com.google.android.gms.internal.zzuv;
import com.google.android.gms.internal.zzvc;
import com.google.android.gms.internal.zzvf;
import com.google.android.gms.internal.zzvt;

public final class Auth
{
  public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
  public static final CredentialsApi CredentialsApi;
  public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
  public static final GoogleSignInApi GoogleSignInApi = new zzc();
  public static final Api<zzb> PROXY_API;
  public static final ProxyApi ProxyApi;
  public static final Api.zzf<zzvf> zzaiS = new Api.zzf();
  public static final Api.zzf<zzuv> zzaiT = new Api.zzf();
  public static final Api.zzf<zzd> zzaiU = new Api.zzf();
  private static final Api.zza<zzvf, AuthCredentialsOptions> zzaiV = new Auth.1();
  private static final Api.zza<zzuv, Api.ApiOptions.NoOptions> zzaiW = new Auth.2();
  private static final Api.zza<zzd, GoogleSignInOptions> zzaiX = new Auth.3();
  public static final Api<Api.ApiOptions.NoOptions> zzaiY;
  public static final zzut zzaiZ;
  
  static
  {
    PROXY_API = zza.API;
    CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzaiV, zzaiS);
    GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzaiX, zzaiU);
    zzaiY = new Api("Auth.ACCOUNT_STATUS_API", zzaiW, zzaiT);
    ProxyApi = new zzvt();
    CredentialsApi = new zzvc();
    zzaiZ = new zzuu();
  }
  
  public static final class AuthCredentialsOptions
    implements Api.ApiOptions.Optional
  {
    private final String zzaja;
    private final PasswordSpecification zzajb;
    
    public final Bundle zzqL()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("consumer_package", this.zzaja);
      localBundle.putParcelable("password_specification", this.zzajb);
      return localBundle;
    }
    
    public final PasswordSpecification zzqT()
    {
      return this.zzajb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.Auth
 * JD-Core Version:    0.7.0.1
 */