package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzayy
  implements Parcelable.Creator<zzayx>
{
  static void zza(zzayx paramzzayx, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzayx.zzbBC);
    zzc.zza(paramParcel, 3, paramzzayx.zzbBD, paramInt, false);
    zzc.zza(paramParcel, 4, paramzzayx.zzbBE, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzayx zzja(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
    zzayz[] arrayOfzzayz = null;
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
        arrayOfzzayz = (zzayz[])zzb.zzb(paramParcel, k, zzayz.CREATOR);
        break;
      case 4: 
        arrayOfString = zzb.zzC(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzayx(i, arrayOfzzayz, arrayOfString);
  }
  
  public zzayx[] zzmX(int paramInt)
  {
    return new zzayx[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzayy
 * JD-Core Version:    0.7.0.1
 */