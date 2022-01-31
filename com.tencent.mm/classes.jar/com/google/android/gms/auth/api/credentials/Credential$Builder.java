package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class Credential$Builder
{
  private String mName;
  private String zzbx;
  private final String zzci;
  private Uri zzcj;
  private List<IdToken> zzck;
  private String zzcl;
  private String zzcm;
  private String zzcn;
  private String zzco;
  private String zzcp;
  
  public Credential$Builder(Credential paramCredential)
  {
    AppMethodBeat.i(50308);
    this.zzci = Credential.zzd(paramCredential);
    this.mName = Credential.zze(paramCredential);
    this.zzcj = Credential.zzf(paramCredential);
    this.zzck = Credential.zzg(paramCredential);
    this.zzcl = Credential.zzh(paramCredential);
    this.zzbx = Credential.zzi(paramCredential);
    this.zzcm = Credential.zzj(paramCredential);
    this.zzcn = Credential.zzk(paramCredential);
    this.zzco = Credential.zzl(paramCredential);
    this.zzcp = Credential.zzm(paramCredential);
    AppMethodBeat.o(50308);
  }
  
  public Credential$Builder(String paramString)
  {
    this.zzci = paramString;
  }
  
  public Credential build()
  {
    AppMethodBeat.i(50309);
    Credential localCredential = new Credential(this.zzci, this.mName, this.zzcj, this.zzck, this.zzcl, this.zzbx, this.zzcm, this.zzcn, this.zzco, this.zzcp);
    AppMethodBeat.o(50309);
    return localCredential;
  }
  
  public Builder setAccountType(String paramString)
  {
    this.zzbx = paramString;
    return this;
  }
  
  public Builder setName(String paramString)
  {
    this.mName = paramString;
    return this;
  }
  
  public Builder setPassword(String paramString)
  {
    this.zzcl = paramString;
    return this;
  }
  
  public Builder setProfilePictureUri(Uri paramUri)
  {
    this.zzcj = paramUri;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential.Builder
 * JD-Core Version:    0.7.0.1
 */