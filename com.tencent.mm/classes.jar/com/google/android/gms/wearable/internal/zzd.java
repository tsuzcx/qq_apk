package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzd
  implements Parcelable.Creator<zzc>
{
  static void zza(zzc paramzzc, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, paramzzc.zzAg(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 3, paramzzc.zzbTC, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramzzc.zzbTD, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramzzc.zzbTE, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, i);
  }
  
  public zzc zzkN(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    String str2 = null;
    String str1 = null;
    IntentFilter[] arrayOfIntentFilter = null;
    IBinder localIBinder = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        localIBinder = zzb.zzr(paramParcel, j);
        break;
      case 3: 
        arrayOfIntentFilter = (IntentFilter[])zzb.zzb(paramParcel, j, IntentFilter.CREATOR);
        break;
      case 4: 
        str1 = zzb.zzq(paramParcel, j);
        break;
      case 5: 
        str2 = zzb.zzq(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzc(localIBinder, arrayOfIntentFilter, str1, str2);
  }
  
  public zzc[] zzpm(int paramInt)
  {
    return new zzc[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzd
 * JD-Core Version:    0.7.0.1
 */