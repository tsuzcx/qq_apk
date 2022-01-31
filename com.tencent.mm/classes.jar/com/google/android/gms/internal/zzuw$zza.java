package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public abstract class zzuw$zza
  extends Binder
  implements zzuw
{
  public static zzuw zzaC(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzuw))) {
      return (zzuw)localIInterface;
    }
    return new zzuw.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateCallbacks");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zzg(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzuw.zza
 * JD-Core Version:    0.7.0.1
 */