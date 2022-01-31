package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class j$a
  extends Binder
  implements j
{
  public j$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
  }
  
  public static j v(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof j))) {
      return (j)localIInterface;
    }
    return new j.a.a(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
    a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.j.a
 * JD-Core Version:    0.7.0.1
 */