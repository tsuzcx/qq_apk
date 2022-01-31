package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbf
  implements Parcelable.Creator<zzbg>
{
  static void zza(zzbg paramzzbg, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbg.statusCode);
    zzc.zza(paramParcel, 3, paramzzbg.enabled);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzbg zzlg(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    boolean bool = false;
    int i = 0;
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
        bool = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbg(i, bool);
  }
  
  public zzbg[] zzpI(int paramInt)
  {
    return new zzbg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbf
 * JD-Core Version:    0.7.0.1
 */