package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzbi
  implements Parcelable.Creator<zzbh>
{
  static void zza(zzbh paramzzbh, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbh.statusCode);
    zzc.zza(paramParcel, 3, paramzzbh.zzbUD, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzbh zzlh(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    ConnectionConfiguration localConnectionConfiguration = null;
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
        localConnectionConfiguration = (ConnectionConfiguration)zzb.zza(paramParcel, k, ConnectionConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbh(i, localConnectionConfiguration);
  }
  
  public zzbh[] zzpJ(int paramInt)
  {
    return new zzbh[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbi
 * JD-Core Version:    0.7.0.1
 */