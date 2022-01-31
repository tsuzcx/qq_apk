package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzi
  implements Parcelable.Creator<zzh>
{
  static void zza(zzh paramzzh, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzh.zzUj());
    zzc.zza(paramParcel, 3, paramzzh.zzUk());
    zzc.zza(paramParcel, 4, paramzzh.getValue(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzh zzkP(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    String str = null;
    byte b2 = 0;
    byte b1 = 0;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        b1 = zzb.zze(paramParcel, j);
        break;
      case 3: 
        b2 = zzb.zze(paramParcel, j);
        break;
      case 4: 
        str = zzb.zzq(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzh(b1, b2, str);
  }
  
  public zzh[] zzpo(int paramInt)
  {
    return new zzh[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzi
 * JD-Core Version:    0.7.0.1
 */