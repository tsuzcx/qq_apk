package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzd
  implements Parcelable.Creator<HintRequest>
{
  static void zza(HintRequest paramHintRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramHintRequest.getHintPickerConfig(), paramInt, false);
    zzc.zza(paramParcel, 2, paramHintRequest.isEmailAddressIdentifierSupported());
    zzc.zza(paramParcel, 3, paramHintRequest.zzqX());
    zzc.zza(paramParcel, 4, paramHintRequest.getAccountTypes(), false);
    zzc.zza(paramParcel, 5, paramHintRequest.isIdTokenRequested());
    zzc.zza(paramParcel, 6, paramHintRequest.getServerClientId(), false);
    zzc.zza(paramParcel, 7, paramHintRequest.getIdTokenNonce(), false);
    zzc.zzc(paramParcel, 1000, paramHintRequest.zzaiI);
    zzc.zzJ(paramParcel, i);
  }
  
  public HintRequest zzN(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    String[] arrayOfString = null;
    boolean bool2 = false;
    boolean bool3 = false;
    CredentialPickerConfig localCredentialPickerConfig = null;
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
        localCredentialPickerConfig = (CredentialPickerConfig)zzb.zza(paramParcel, k, CredentialPickerConfig.CREATOR);
        break;
      case 2: 
        bool3 = zzb.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 4: 
        arrayOfString = zzb.zzC(paramParcel, k);
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
    return new HintRequest(i, localCredentialPickerConfig, bool3, bool2, arrayOfString, bool1, str2, str1);
  }
  
  public HintRequest[] zzbc(int paramInt)
  {
    return new HintRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzd
 * JD-Core Version:    0.7.0.1
 */