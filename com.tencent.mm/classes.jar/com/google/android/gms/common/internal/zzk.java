package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzk
  implements Parcelable.Creator<zzj>
{
  static void zza(zzj paramzzj, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, paramzzj.version);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 2, paramzzj.zzaFK);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 3, paramzzj.zzaFL);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramzzj.zzaFM, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramzzj.zzaFN, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 6, paramzzj.zzaFO, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, paramzzj.zzaFP, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, paramzzj.zzaFQ, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 10, paramzzj.zzaFR, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, i);
  }
  
  public zzj zzaS(Parcel paramParcel)
  {
    int m = zzb.zzaY(paramParcel);
    com.google.android.gms.common.zzc[] arrayOfzzc = null;
    Account localAccount = null;
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int i = 0;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(n))
      {
      case 9: 
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        str = zzb.zzq(paramParcel, n);
        break;
      case 5: 
        localIBinder = zzb.zzr(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = zzb.zzs(paramParcel, n);
        break;
      case 8: 
        localAccount = (Account)zzb.zza(paramParcel, n, Account.CREATOR);
        break;
      case 10: 
        arrayOfzzc = (com.google.android.gms.common.zzc[])zzb.zzb(paramParcel, n, com.google.android.gms.common.zzc.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzj(k, j, i, str, localIBinder, arrayOfScope, localBundle, localAccount, arrayOfzzc);
  }
  
  public zzj[] zzcU(int paramInt)
  {
    return new zzj[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzk
 * JD-Core Version:    0.7.0.1
 */