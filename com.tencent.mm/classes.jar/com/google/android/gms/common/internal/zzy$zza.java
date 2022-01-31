package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzy$zza
  extends Binder
  implements zzy
{
  public static zzy zzbx(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    if ((localIInterface != null) && ((localIInterface instanceof zzy))) {
      return (zzy)localIInterface;
    }
    return new zzy.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      paramParcel1 = zza(IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (zzah)zzah.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      localIObjectWrapper = zza(localIObjectWrapper, paramParcel1);
      paramParcel2.writeNoException();
      paramParcel1 = localObject;
      if (localIObjectWrapper != null) {
        paramParcel1 = localIObjectWrapper.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzy.zza
 * JD-Core Version:    0.7.0.1
 */