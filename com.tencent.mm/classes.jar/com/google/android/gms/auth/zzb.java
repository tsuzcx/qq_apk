package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<AccountChangeEventsRequest>
{
  static void zza(AccountChangeEventsRequest paramAccountChangeEventsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramAccountChangeEventsRequest.mVersion);
    zzc.zzc(paramParcel, 2, paramAccountChangeEventsRequest.zzaiw);
    zzc.zza(paramParcel, 3, paramAccountChangeEventsRequest.zzaiu, false);
    zzc.zza(paramParcel, 4, paramAccountChangeEventsRequest.zzahh, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public AccountChangeEventsRequest zzH(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    Account localAccount = null;
    String str = null;
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
        str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, m);
        break;
      case 4: 
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, m, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new AccountChangeEventsRequest(i, j, str, localAccount);
  }
  
  public AccountChangeEventsRequest[] zzaW(int paramInt)
  {
    return new AccountChangeEventsRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.zzb
 * JD-Core Version:    0.7.0.1
 */