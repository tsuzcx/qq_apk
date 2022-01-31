package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class s$a
  extends Binder
  implements s
{
  public s$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
    c(paramParcel1.readLong(), paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.s.a
 * JD-Core Version:    0.7.0.1
 */