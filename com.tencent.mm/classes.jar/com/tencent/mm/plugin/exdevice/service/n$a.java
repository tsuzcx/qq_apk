package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class n$a
  extends Binder
  implements n
{
  public n$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0)
    {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      paramParcel1 = j(paramInt1, paramParcel1);
      paramParcel2.writeNoException();
      if (paramParcel1 == null) {
        break label110;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      return true;
      paramParcel1 = null;
      break;
      label110:
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.n.a
 * JD-Core Version:    0.7.0.1
 */