package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<IdToken>
{
  static void zza(IdToken paramIdToken, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramIdToken.getAccountType(), false);
    zzc.zza(paramParcel, 2, paramIdToken.getIdToken(), false);
    zzc.zzc(paramParcel, 1000, paramIdToken.zzaiI);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public IdToken zzO(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 2: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zzb.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new IdToken(i, str1, str2);
  }
  
  public IdToken[] zzbd(int paramInt)
  {
    return new IdToken[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zze
 * JD-Core Version:    0.7.0.1
 */