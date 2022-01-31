package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class zza$zza
  extends Binder
  implements zza
{
  public zza$zza()
  {
    attachInterface(this, "com.google.android.gms.auth.account.IWorkAccountCallback");
  }
  
  public static zza zzay(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountCallback");
    if ((localIInterface != null) && ((localIInterface instanceof zza))) {
      return (zza)localIInterface;
    }
    return new zza.zza.zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.account.IWorkAccountCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.account.IWorkAccountCallback");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzd(paramParcel1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.account.IWorkAccountCallback");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzac(bool);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.account.zza.zza
 * JD-Core Version:    0.7.0.1
 */