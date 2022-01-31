package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzl
  implements Parcelable.Creator<zzk>
{
  static void zza(zzk paramzzk, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzk.getId());
    zzc.zza(paramParcel, 3, paramzzk.zzke(), false);
    zzc.zza(paramParcel, 4, paramzzk.zzUl(), false);
    zzc.zza(paramParcel, 5, paramzzk.zzUm(), false);
    zzc.zza(paramParcel, 6, paramzzk.getTitle(), false);
    zzc.zza(paramParcel, 7, paramzzk.zzEu(), false);
    zzc.zza(paramParcel, 8, paramzzk.getDisplayName(), false);
    zzc.zza(paramParcel, 9, paramzzk.zzUn());
    zzc.zza(paramParcel, 10, paramzzk.zzUo());
    zzc.zza(paramParcel, 11, paramzzk.zzUp());
    zzc.zza(paramParcel, 12, paramzzk.zzUq());
    zzc.zza(paramParcel, 13, paramzzk.getPackageName(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzk zzkQ(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    byte b4 = 0;
    byte b3 = 0;
    byte b2 = 0;
    byte b1 = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 2: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 3: 
        str7 = zzb.zzq(paramParcel, k);
        break;
      case 4: 
        str6 = zzb.zzq(paramParcel, k);
        break;
      case 5: 
        str5 = zzb.zzq(paramParcel, k);
        break;
      case 6: 
        str4 = zzb.zzq(paramParcel, k);
        break;
      case 7: 
        str3 = zzb.zzq(paramParcel, k);
        break;
      case 8: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 9: 
        b4 = zzb.zze(paramParcel, k);
        break;
      case 10: 
        b3 = zzb.zze(paramParcel, k);
        break;
      case 11: 
        b2 = zzb.zze(paramParcel, k);
        break;
      case 12: 
        b1 = zzb.zze(paramParcel, k);
        break;
      case 13: 
        str1 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzk(i, str7, str6, str5, str4, str3, str2, b4, b3, b2, b1, str1);
  }
  
  public zzk[] zzpp(int paramInt)
  {
    return new zzk[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzl
 * JD-Core Version:    0.7.0.1
 */