package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zzf;

public abstract class zze
  extends com.google.android.gms.internal.auth.zze
  implements zzd
{
  public zze()
  {
    super("com.google.android.gms.auth.account.IWorkAccountCallback");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      zzf((Account)zzf.zzd(paramParcel1, Account.CREATOR));
    }
    for (;;)
    {
      return true;
      zzd(zzf.zzd(paramParcel1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.account.zze
 * JD-Core Version:    0.7.0.1
 */