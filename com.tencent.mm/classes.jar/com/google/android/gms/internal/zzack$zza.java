package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzack$zza
  extends Binder
  implements zzack
{
  public zzack$zza()
  {
    attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
  }
  
  public static zzack zzbA(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzack))) {
      return (zzack)localIInterface;
    }
    return new zzack.zza.zza(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
    zzdd(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzack.zza
 * JD-Core Version:    0.7.0.1
 */