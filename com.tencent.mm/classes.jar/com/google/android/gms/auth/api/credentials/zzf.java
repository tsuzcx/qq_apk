package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<PasswordSpecification>
{
  static void zza(PasswordSpecification paramPasswordSpecification, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramPasswordSpecification.zzajE, false);
    zzc.zzb(paramParcel, 2, paramPasswordSpecification.zzajF, false);
    zzc.zza(paramParcel, 3, paramPasswordSpecification.zzajG, false);
    zzc.zzc(paramParcel, 4, paramPasswordSpecification.zzajH);
    zzc.zzc(paramParcel, 5, paramPasswordSpecification.zzajI);
    zzc.zzc(paramParcel, 1000, paramPasswordSpecification.zzaiI);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public PasswordSpecification zzP(Parcel paramParcel)
  {
    int m = zzb.zzaY(paramParcel);
    int i = 0;
    int j = 0;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        str = zzb.zzq(paramParcel, n);
        break;
      case 2: 
        localArrayList2 = zzb.zzE(paramParcel, n);
        break;
      case 3: 
        localArrayList1 = zzb.zzD(paramParcel, n);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 5: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 1000: 
        k = zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new PasswordSpecification(k, str, localArrayList2, localArrayList1, j, i);
  }
  
  public PasswordSpecification[] zzbe(int paramInt)
  {
    return new PasswordSpecification[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzf
 * JD-Core Version:    0.7.0.1
 */