package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zza
  implements Parcelable.Creator<AccountChangeEvent>
{
  static void zza(AccountChangeEvent paramAccountChangeEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramAccountChangeEvent.mVersion);
    zzc.zza(paramParcel, 2, paramAccountChangeEvent.zzait);
    zzc.zza(paramParcel, 3, paramAccountChangeEvent.zzaiu, false);
    zzc.zzc(paramParcel, 4, paramAccountChangeEvent.zzaiv);
    zzc.zzc(paramParcel, 5, paramAccountChangeEvent.zzaiw);
    zzc.zza(paramParcel, 6, paramAccountChangeEvent.zzaix, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public AccountChangeEvent zzG(Parcel paramParcel)
  {
    int m = zzb.zzaY(paramParcel);
    long l = 0L;
    String str1 = null;
    int i = 0;
    int j = 0;
    String str2 = null;
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
        k = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        l = zzb.zzi(paramParcel, n);
        break;
      case 3: 
        str2 = zzb.zzq(paramParcel, n);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 5: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 6: 
        str1 = zzb.zzq(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new AccountChangeEvent(k, l, str2, j, i, str1);
  }
  
  public AccountChangeEvent[] zzaV(int paramInt)
  {
    return new AccountChangeEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.zza
 * JD-Core Version:    0.7.0.1
 */