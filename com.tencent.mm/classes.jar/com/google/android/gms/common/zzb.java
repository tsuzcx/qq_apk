package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<ConnectionResult>
{
  static void zza(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramConnectionResult.zzaiI);
    zzc.zzc(paramParcel, 2, paramConnectionResult.getErrorCode());
    zzc.zza(paramParcel, 3, paramConnectionResult.getResolution(), paramInt, false);
    zzc.zza(paramParcel, 4, paramConnectionResult.getErrorMessage(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public ConnectionResult zzaJ(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    String str = null;
    PendingIntent localPendingIntent = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzdc(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, m);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, m);
        break;
      case 2: 
        j = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, m);
        break;
      case 3: 
        localPendingIntent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 4: 
        str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new ConnectionResult(i, j, localPendingIntent, str);
  }
  
  public ConnectionResult[] zzcu(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.zzb
 * JD-Core Version:    0.7.0.1
 */