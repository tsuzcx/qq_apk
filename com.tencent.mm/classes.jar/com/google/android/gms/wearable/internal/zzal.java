package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzal
  implements Parcelable.Creator<DataItemAssetParcelable>
{
  static void zza(DataItemAssetParcelable paramDataItemAssetParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramDataItemAssetParcelable.getId(), false);
    zzc.zza(paramParcel, 3, paramDataItemAssetParcelable.getDataItemKey(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public DataItemAssetParcelable zzkX(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        str1 = zzb.zzq(paramParcel, j);
        break;
      case 3: 
        str2 = zzb.zzq(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new DataItemAssetParcelable(str1, str2);
  }
  
  public DataItemAssetParcelable[] zzpz(int paramInt)
  {
    return new DataItemAssetParcelable[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzal
 * JD-Core Version:    0.7.0.1
 */