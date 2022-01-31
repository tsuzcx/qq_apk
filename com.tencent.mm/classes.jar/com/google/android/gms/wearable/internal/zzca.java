package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzca
  implements Parcelable.Creator<zzbz>
{
  static void zza(zzbz paramzzbz, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbz.getRequestId());
    zzc.zza(paramParcel, 3, paramzzbz.getPath(), false);
    zzc.zza(paramParcel, 4, paramzzbz.getData(), false);
    zzc.zza(paramParcel, 5, paramzzbz.getSourceNodeId(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzbz zzln(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String str2 = null;
    byte[] arrayOfByte = null;
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
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = zzb.zzt(paramParcel, k);
        break;
      case 5: 
        str2 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbz(i, str1, arrayOfByte, str2);
  }
  
  public zzbz[] zzpP(int paramInt)
  {
    return new zzbz[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzca
 * JD-Core Version:    0.7.0.1
 */