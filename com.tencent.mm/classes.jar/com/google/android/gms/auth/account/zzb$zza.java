package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class zzb$zza
  extends Binder
  implements zzb
{
  public static zzb zzaz(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
    if ((localIInterface != null) && ((localIInterface instanceof zzb))) {
      return (zzb)localIInterface;
    }
    return new zzb.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.account.IWorkAccountService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.account.IWorkAccountService");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzad(bool);
        paramParcel2.writeNoException();
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.account.IWorkAccountService");
      zza(zza.zza.zzay(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.account.IWorkAccountService");
    zza localzza = zza.zza.zzay(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zza(localzza, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.account.zzb.zza
 * JD-Core Version:    0.7.0.1
 */