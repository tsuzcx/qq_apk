package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class zzu$zza
  extends Binder
  implements zzu
{
  public zzu$zza()
  {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public static zzu zzbt(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzu))) {
      return (zzu)localIInterface;
    }
    return new zzu.zza.zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IBinder localIBinder = null;
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      paramInt1 = paramParcel1.readInt();
      localIBinder = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramInt1, localIBinder, (Bundle)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
    paramInt1 = paramParcel1.readInt();
    localObject = localIBinder;
    if (paramParcel1.readInt() != 0) {
      localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    zzb(paramInt1, (Bundle)localObject);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzu.zza
 * JD-Core Version:    0.7.0.1
 */