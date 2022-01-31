package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CredentialRequest
  extends zza
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
  final int zzaiI;
  private final boolean zzajr;
  private final String[] zzajs;
  private final CredentialPickerConfig zzajt;
  private final CredentialPickerConfig zzaju;
  private final boolean zzajv;
  private final String zzajw;
  private final String zzajx;
  
  CredentialRequest(int paramInt, boolean paramBoolean1, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2, boolean paramBoolean2, String paramString1, String paramString2)
  {
    this.zzaiI = paramInt;
    this.zzajr = paramBoolean1;
    this.zzajs = ((String[])zzac.zzw(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzajt = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzaju = paramArrayOfString;
    if (paramInt < 3)
    {
      this.zzajv = true;
      this.zzajw = null;
      this.zzajx = null;
      return;
    }
    this.zzajv = paramBoolean2;
    this.zzajw = paramString1;
    this.zzajx = paramString2;
  }
  
  private CredentialRequest(CredentialRequest.Builder paramBuilder)
  {
    this(3, CredentialRequest.Builder.zza(paramBuilder), CredentialRequest.Builder.zzb(paramBuilder), CredentialRequest.Builder.zzc(paramBuilder), CredentialRequest.Builder.zzd(paramBuilder), CredentialRequest.Builder.zze(paramBuilder), CredentialRequest.Builder.zzf(paramBuilder), CredentialRequest.Builder.zzg(paramBuilder));
  }
  
  public final String[] getAccountTypes()
  {
    return this.zzajs;
  }
  
  public final Set<String> getAccountTypesSet()
  {
    return new HashSet(Arrays.asList(this.zzajs));
  }
  
  public final CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return this.zzaju;
  }
  
  public final CredentialPickerConfig getCredentialPickerConfig()
  {
    return this.zzajt;
  }
  
  public final String getIdTokenNonce()
  {
    return this.zzajx;
  }
  
  public final String getServerClientId()
  {
    return this.zzajw;
  }
  
  @Deprecated
  public final boolean getSupportsPasswordLogin()
  {
    return isPasswordLoginSupported();
  }
  
  public final boolean isIdTokenRequested()
  {
    return this.zzajv;
  }
  
  public final boolean isPasswordLoginSupported()
  {
    return this.zzajr;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest
 * JD-Core Version:    0.7.0.1
 */