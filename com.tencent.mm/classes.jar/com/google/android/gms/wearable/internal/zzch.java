package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzch
  implements Parcelable.Creator<zzcg>
{
  static void zza(zzcg paramzzcg, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzcg.packageName, false);
    zzc.zza(paramParcel, 3, paramzzcg.label, false);
    zzc.zza(paramParcel, 4, paramzzcg.zzbUT);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzcg zzlq(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    long l = 0L;
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
        break;
      case 4: 
        l = zzb.zzi(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzcg(str1, str2, l);
  }
  
  public zzcg[] zzpS(int paramInt)
  {
    return new zzcg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzch
 * JD-Core Version:    0.7.0.1
 */