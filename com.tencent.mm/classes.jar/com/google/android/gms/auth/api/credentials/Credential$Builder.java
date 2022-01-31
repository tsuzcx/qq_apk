package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import java.util.List;

public class Credential$Builder
{
  private String mName;
  private final String zzGV;
  private Uri zzajf;
  private List<IdToken> zzajg;
  private String zzajh;
  private String zzaji;
  private String zzajj;
  private String zzajk;
  private String zzajl;
  private String zzajm;
  
  public Credential$Builder(Credential paramCredential)
  {
    this.zzGV = Credential.zza(paramCredential);
    this.mName = Credential.zzb(paramCredential);
    this.zzajf = Credential.zzc(paramCredential);
    this.zzajg = Credential.zzd(paramCredential);
    this.zzajh = Credential.zze(paramCredential);
    this.zzaji = Credential.zzf(paramCredential);
    this.zzajj = Credential.zzg(paramCredential);
    this.zzajk = Credential.zzh(paramCredential);
    this.zzajl = Credential.zzi(paramCredential);
    this.zzajm = Credential.zzj(paramCredential);
  }
  
  public Credential$Builder(String paramString)
  {
    this.zzGV = paramString;
  }
  
  public Credential build()
  {
    return new Credential(4, this.zzGV, this.mName, this.zzajf, this.zzajg, this.zzajh, this.zzaji, this.zzajj, this.zzajk, this.zzajl, this.zzajm);
  }
  
  public Builder setAccountType(String paramString)
  {
    this.zzaji = paramString;
    return this;
  }
  
  public Builder setName(String paramString)
  {
    this.mName = paramString;
    return this;
  }
  
  public Builder setPassword(String paramString)
  {
    this.zzajh = paramString;
    return this;
  }
  
  public Builder setProfilePictureUri(Uri paramUri)
  {
    this.zzajf = paramUri;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential.Builder
 * JD-Core Version:    0.7.0.1
 */