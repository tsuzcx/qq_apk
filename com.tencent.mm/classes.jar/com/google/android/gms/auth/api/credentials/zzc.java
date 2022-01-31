package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzc
  implements Parcelable.Creator<CredentialRequest>
{
  static void zza(CredentialRequest paramCredentialRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 1, paramCredentialRequest.isPasswordLoginSupported());
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, paramCredentialRequest.getAccountTypes(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 3, paramCredentialRequest.getCredentialPickerConfig(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramCredentialRequest.getCredentialHintPickerConfig(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramCredentialRequest.isIdTokenRequested());
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 6, paramCredentialRequest.getServerClientId(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, paramCredentialRequest.getIdTokenNonce(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1000, paramCredentialRequest.zzaiI);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, i);
  }
  
  public CredentialRequest zzM(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    CredentialPickerConfig localCredentialPickerConfig1 = null;
    CredentialPickerConfig localCredentialPickerConfig2 = null;
    String[] arrayOfString = null;
    boolean bool2 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 2: 
        arrayOfString = zzb.zzC(paramParcel, k);
        break;
      case 3: 
        localCredentialPickerConfig2 = (CredentialPickerConfig)zzb.zza(paramParcel, k, CredentialPickerConfig.CREATOR);
        break;
      case 4: 
        localCredentialPickerConfig1 = (CredentialPickerConfig)zzb.zza(paramParcel, k, CredentialPickerConfig.CREATOR);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, k);
        break;
      case 6: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 7: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zzb.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new CredentialRequest(i, bool2, arrayOfString, localCredentialPickerConfig2, localCredentialPickerConfig1, bool1, str2, str1);
  }
  
  public CredentialRequest[] zzbb(int paramInt)
  {
    return new CredentialRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzc
 * JD-Core Version:    0.7.0.1
 */