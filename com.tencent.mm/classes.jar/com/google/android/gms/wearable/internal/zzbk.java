package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzbk
  implements Parcelable.Creator<zzbj>
{
  static void zza(zzbj paramzzbj, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbj.statusCode);
    zzc.zza(paramParcel, 3, paramzzbj.zzbUE, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzbj zzli(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    ConnectionConfiguration[] arrayOfConnectionConfiguration = null;
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
        arrayOfConnectionConfiguration = (ConnectionConfiguration[])zzb.zzb(paramParcel, k, ConnectionConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbj(i, arrayOfConnectionConfiguration);
  }
  
  public zzbj[] zzpK(int paramInt)
  {
    return new zzbj[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbk
 * JD-Core Version:    0.7.0.1
 */