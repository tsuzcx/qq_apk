package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class zzux$zza
  extends Binder
  implements zzux
{
  public static zzux zzaD(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
    if ((localIInterface != null) && ((localIInterface instanceof zzux))) {
      return (zzux)localIInterface;
    }
    return new zzux.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
    if (paramParcel1.readInt() != 0) {}
    for (Account localAccount = (Account)Account.CREATOR.createFromParcel(paramParcel1);; localAccount = null)
    {
      zza(localAccount, paramParcel1.readInt(), zzuw.zza.zzaC(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzux.zza
 * JD-Core Version:    0.7.0.1
 */