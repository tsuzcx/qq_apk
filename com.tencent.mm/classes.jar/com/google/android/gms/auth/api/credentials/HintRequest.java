package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class HintRequest
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<HintRequest> CREATOR = new zzd();
  final int zzaiI;
  private final boolean zzajA;
  private final String[] zzajs;
  private final boolean zzajv;
  private final String zzajw;
  private final String zzajx;
  private final CredentialPickerConfig zzajy;
  private final boolean zzajz;
  
  HintRequest(int paramInt, CredentialPickerConfig paramCredentialPickerConfig, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this.zzaiI = paramInt;
    this.zzajy = ((CredentialPickerConfig)zzac.zzw(paramCredentialPickerConfig));
    this.zzajz = paramBoolean1;
    this.zzajA = paramBoolean2;
    this.zzajs = ((String[])zzac.zzw(paramArrayOfString));
    if (this.zzaiI < 2)
    {
      this.zzajv = true;
      this.zzajw = null;
      this.zzajx = null;
      return;
    }
    this.zzajv = paramBoolean3;
    this.zzajw = paramString1;
    this.zzajx = paramString2;
  }
  
  private HintRequest(HintRequest.Builder paramBuilder)
  {
    this(2, HintRequest.Builder.zza(paramBuilder), HintRequest.Builder.zzb(paramBuilder), HintRequest.Builder.zzc(paramBuilder), HintRequest.Builder.zzd(paramBuilder), HintRequest.Builder.zze(paramBuilder), HintRequest.Builder.zzf(paramBuilder), HintRequest.Builder.zzg(paramBuilder));
  }
  
  public final String[] getAccountTypes()
  {
    return this.zzajs;
  }
  
  public final CredentialPickerConfig getHintPickerConfig()
  {
    return this.zzajy;
  }
  
  public final String getIdTokenNonce()
  {
    return this.zzajx;
  }
  
  public final String getServerClientId()
  {
    return this.zzajw;
  }
  
  public final boolean isEmailAddressIdentifierSupported()
  {
    return this.zzajz;
  }
  
  public final boolean isIdTokenRequested()
  {
    return this.zzajv;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public final boolean zzqX()
  {
    return this.zzajA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.HintRequest
 * JD-Core Version:    0.7.0.1
 */