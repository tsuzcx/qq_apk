package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzv
  implements Parcelable.Creator<zzu>
{
  static void zza(zzu paramzzu, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzu.getToken(), false);
    zzc.zza(paramParcel, 3, paramzzu.getNodeId(), false);
    zzc.zza(paramParcel, 4, paramzzu.getPath(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzu zzkT(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    String str3 = null;
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
        str3 = zzb.zzq(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzu(str1, str2, str3);
  }
  
  public zzu[] zzpu(int paramInt)
  {
    return new zzu[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzv
 * JD-Core Version:    0.7.0.1
 */