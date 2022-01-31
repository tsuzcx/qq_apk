package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzvj
  implements Parcelable.Creator<zzvi>
{
  static void zza(zzvi paramzzvi, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramzzvi.zzqT(), paramInt, false);
    zzc.zzc(paramParcel, 1000, paramzzvi.zzaiI);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzvi zzR(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    PasswordSpecification localPasswordSpecification = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        localPasswordSpecification = (PasswordSpecification)zzb.zza(paramParcel, k, PasswordSpecification.CREATOR);
        break;
      case 1000: 
        i = zzb.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzvi(i, localPasswordSpecification);
  }
  
  public zzvi[] zzbg(int paramInt)
  {
    return new zzvi[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzvj
 * JD-Core Version:    0.7.0.1
 */