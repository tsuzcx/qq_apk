package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class t$a
  extends Binder
  implements t
{
  public t$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
    b(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.t.a
 * JD-Core Version:    0.7.0.1
 */