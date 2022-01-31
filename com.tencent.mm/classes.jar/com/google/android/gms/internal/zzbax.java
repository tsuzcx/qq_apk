package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzaf;

public class zzbax
  implements Parcelable.Creator<zzbaw>
{
  static void zza(zzbaw paramzzbaw, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbaw.zzaiI);
    zzc.zza(paramParcel, 2, paramzzbaw.zzyh(), paramInt, false);
    zzc.zza(paramParcel, 3, paramzzbaw.zzPT(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzbaw zzjy(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    zzaf localzzaf = null;
    ConnectionResult localConnectionResult = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        localConnectionResult = (ConnectionResult)zzb.zza(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 3: 
        localzzaf = (zzaf)zzb.zza(paramParcel, k, zzaf.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbaw(i, localConnectionResult, localzzaf);
  }
  
  public zzbaw[] zzny(int paramInt)
  {
    return new zzbaw[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzbax
 * JD-Core Version:    0.7.0.1
 */