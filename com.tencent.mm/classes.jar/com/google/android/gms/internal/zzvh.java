package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzvh
  implements Parcelable.Creator<zzvg>
{
  static void zza(zzvg paramzzvg, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramzzvg.getCredential(), paramInt, false);
    zzc.zzc(paramParcel, 1000, paramzzvg.zzaiI);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzvg zzQ(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    Credential localCredential = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        localCredential = (Credential)zzb.zza(paramParcel, k, Credential.CREATOR);
        break;
      case 1000: 
        i = zzb.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzvg(i, localCredential);
  }
  
  public zzvg[] zzbf(int paramInt)
  {
    return new zzvg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzvh
 * JD-Core Version:    0.7.0.1
 */