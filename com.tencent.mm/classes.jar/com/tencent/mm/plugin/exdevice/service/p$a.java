package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class p$a
  extends Binder
  implements p
{
  public p$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
  }
  
  public static p z(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof p))) {
      return (p)localIInterface;
    }
    return new p.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    o localo = null;
    l locall = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
      localo = aMj();
      paramParcel2.writeNoException();
      paramParcel1 = locall;
      if (localo != null) {
        paramParcel1 = localo.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
    locall = aMk();
    paramParcel2.writeNoException();
    paramParcel1 = localo;
    if (locall != null) {
      paramParcel1 = locall.asBinder();
    }
    paramParcel2.writeStrongBinder(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.p.a
 * JD-Core Version:    0.7.0.1
 */