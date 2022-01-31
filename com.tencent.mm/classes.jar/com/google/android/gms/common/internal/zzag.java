package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzag
  implements Parcelable.Creator<zzaf>
{
  static void zza(zzaf paramzzaf, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzaf.zzaiI);
    zzc.zza(paramParcel, 2, paramzzaf.zzaEW, false);
    zzc.zza(paramParcel, 3, paramzzaf.zzyh(), paramInt, false);
    zzc.zza(paramParcel, 4, paramzzaf.zzyi());
    zzc.zza(paramParcel, 5, paramzzaf.zzyj());
    zzc.zzJ(paramParcel, i);
  }
  
  public zzaf zzaU(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    boolean bool1 = false;
    boolean bool2 = false;
    ConnectionResult localConnectionResult = null;
    IBinder localIBinder = null;
    int i = 0;
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
        localIBinder = zzb.zzr(paramParcel, k);
        break;
      case 3: 
        localConnectionResult = (ConnectionResult)zzb.zza(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 4: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzaf(i, localIBinder, localConnectionResult, bool2, bool1);
  }
  
  public zzaf[] zzcZ(int paramInt)
  {
    return new zzaf[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzag
 * JD-Core Version:    0.7.0.1
 */