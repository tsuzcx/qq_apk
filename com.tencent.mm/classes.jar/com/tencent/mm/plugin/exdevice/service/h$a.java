package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class h$a
  extends Binder
  implements h
{
  public h$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
  }
  
  public static h t(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof h))) {
      return (h)localIInterface;
    }
    return new h.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = b(paramParcel1.readInt(), j.a.v(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = c(paramParcel1.readInt(), j.a.v(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      paramParcel1 = aMa();
      paramParcel2.writeNoException();
      paramParcel2.writeLongArray(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = a(paramParcel1.readLong(), paramParcel1.readInt(), k.a.w(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = dZ(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = ea(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      l = a(p.a.z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = eb(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = a(i.a.u(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = b(i.a.u(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i2;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject3;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof n))) {
          paramParcel1 = (n)localObject1;
        } else {
          paramParcel1 = new n.a.a(paramParcel1);
        }
      }
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      setChannelSessionKey(paramParcel1.readLong(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          break label793;
        }
        paramParcel1 = (Parcel)localObject1;
      }
      for (;;)
      {
        bool = a((String)localObject2, bool, paramParcel1);
        paramParcel2.writeNoException();
        paramInt1 = i3;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
        bool = false;
        break;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof q))) {
          paramParcel1 = (q)localObject1;
        } else {
          paramParcel1 = new q.a.a(paramParcel1);
        }
      }
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = d(paramParcel1.readInt(), j.a.v(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i4;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = e(paramParcel1.readInt(), j.a.v(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i5;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = b(paramParcel1.readLong(), paramParcel1.readInt(), k.a.w(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i6;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = ec(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = i7;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 18: 
      label793:
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject4;
      }
      for (;;)
      {
        bool = a(paramParcel1);
        paramParcel2.writeNoException();
        paramInt1 = i8;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof s))) {
          paramParcel1 = (s)localObject1;
        } else {
          paramParcel1 = new s.a.a(paramParcel1);
        }
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
    long l = paramParcel1.readLong();
    localObject1 = paramParcel1.createByteArray();
    paramParcel1 = paramParcel1.readStrongBinder();
    if (paramParcel1 == null) {
      paramParcel1 = (Parcel)localObject2;
    }
    for (;;)
    {
      bool = b(l, (byte[])localObject1, paramParcel1);
      paramParcel2.writeNoException();
      paramInt1 = i9;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
      localObject2 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
      if ((localObject2 != null) && ((localObject2 instanceof t))) {
        paramParcel1 = (t)localObject2;
      } else {
        paramParcel1 = new t.a.a(paramParcel1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.h.a
 * JD-Core Version:    0.7.0.1
 */