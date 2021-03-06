package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInOptions
  implements Api.ApiOptions.Optional
{
  public static final SignInOptions DEFAULT;
  private final boolean zzadb;
  private final boolean zzadc;
  private final Long zzadd;
  private final Long zzade;
  private final boolean zzt;
  private final boolean zzv;
  private final String zzw;
  private final String zzx;
  
  static
  {
    AppMethodBeat.i(12143);
    DEFAULT = new Builder().build();
    AppMethodBeat.o(12143);
  }
  
  private SignInOptions(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, boolean paramBoolean4, Long paramLong1, Long paramLong2)
  {
    this.zzadb = paramBoolean1;
    this.zzt = paramBoolean2;
    this.zzw = paramString1;
    this.zzv = paramBoolean3;
    this.zzadc = paramBoolean4;
    this.zzx = paramString2;
    this.zzadd = paramLong1;
    this.zzade = paramLong2;
  }
  
  public final Long getAuthApiSignInModuleVersion()
  {
    return this.zzadd;
  }
  
  public final String getHostedDomain()
  {
    return this.zzx;
  }
  
  public final Long getRealClientLibraryVersion()
  {
    return this.zzade;
  }
  
  public final String getServerClientId()
  {
    return this.zzw;
  }
  
  public final boolean isForceCodeForRefreshToken()
  {
    return this.zzv;
  }
  
  public final boolean isIdTokenRequested()
  {
    return this.zzt;
  }
  
  public final boolean isOfflineAccessRequested()
  {
    return this.zzadb;
  }
  
  public final boolean waitForAccessTokenRefresh()
  {
    return this.zzadc;
  }
  
  public static final class Builder
  {
    private boolean zzadf;
    private boolean zzadg;
    private String zzadh;
    private boolean zzadi;
    private String zzadj;
    private boolean zzadk;
    private Long zzadl;
    private Long zzadm;
    
    private final String zza(String paramString)
    {
      AppMethodBeat.i(12142);
      Preconditions.checkNotNull(paramString);
      if ((this.zzadh == null) || (this.zzadh.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "two different server client ids provided");
        AppMethodBeat.o(12142);
        return paramString;
      }
    }
    
    public final SignInOptions build()
    {
      AppMethodBeat.i(12137);
      SignInOptions localSignInOptions = new SignInOptions(this.zzadf, this.zzadg, this.zzadh, this.zzadi, this.zzadj, this.zzadk, this.zzadl, this.zzadm, null);
      AppMethodBeat.o(12137);
      return localSignInOptions;
    }
    
    public final Builder requestIdToken(String paramString)
    {
      AppMethodBeat.i(12139);
      this.zzadg = true;
      this.zzadh = zza(paramString);
      AppMethodBeat.o(12139);
      return this;
    }
    
    public final Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(12138);
      this.zzadi = paramBoolean;
      this.zzadf = true;
      this.zzadh = zza(paramString);
      AppMethodBeat.o(12138);
      return this;
    }
    
    public final Builder setAuthApiSignInModuleVersion(long paramLong)
    {
      AppMethodBeat.i(12140);
      this.zzadl = Long.valueOf(paramLong);
      AppMethodBeat.o(12140);
      return this;
    }
    
    public final Builder setHostedDomain(String paramString)
    {
      this.zzadj = paramString;
      return this;
    }
    
    public final Builder setRealClientLibraryVersion(long paramLong)
    {
      AppMethodBeat.i(12141);
      this.zzadm = Long.valueOf(paramLong);
      AppMethodBeat.o(12141);
      return this;
    }
    
    public final Builder setWaitForAccessTokenRefresh(boolean paramBoolean)
    {
      this.zzadk = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.SignInOptions
 * JD-Core Version:    0.7.0.1
 */