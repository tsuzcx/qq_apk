package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<CredentialPickerConfig>
{
  static void zza(CredentialPickerConfig paramCredentialPickerConfig, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramCredentialPickerConfig.shouldShowAddAccountButton());
    zzc.zza(paramParcel, 2, paramCredentialPickerConfig.shouldShowCancelButton());
    zzc.zza(paramParcel, 3, paramCredentialPickerConfig.isForNewAccount());
    zzc.zzc(paramParcel, 4, paramCredentialPickerConfig.zzqW());
    zzc.zzc(paramParcel, 1000, paramCredentialPickerConfig.zzaiI);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public CredentialPickerConfig zzL(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzdc(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, m);
        break;
      case 1: 
        bool3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, m);
        break;
      case 2: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, m);
        break;
      case 3: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, m);
        break;
      case 4: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, m);
        break;
      case 1000: 
        j = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new CredentialPickerConfig(j, bool3, bool2, bool1, i);
  }
  
  public CredentialPickerConfig[] zzba(int paramInt)
  {
    return new CredentialPickerConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzb
 * JD-Core Version:    0.7.0.1
 */