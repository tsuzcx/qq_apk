package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbas
  implements Parcelable.Creator<zzbar>
{
  static void zza(zzbar paramzzbar, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbar.zzaiI);
    zzc.zza(paramParcel, 2, paramzzbar.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 3, paramzzbar.zzPQ(), paramInt, false);
    zzc.zza(paramParcel, 4, paramzzbar.getServerClientId(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzbar zzjw(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String str = null;
    Scope[] arrayOfScope = null;
    Account localAccount = null;
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
        localAccount = (Account)zzb.zza(paramParcel, k, Account.CREATOR);
        break;
      case 3: 
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, k, Scope.CREATOR);
        break;
      case 4: 
        str = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbar(i, localAccount, arrayOfScope, str);
  }
  
  public zzbar[] zznw(int paramInt)
  {
    return new zzbar[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzbas
 * JD-Core Version:    0.7.0.1
 */