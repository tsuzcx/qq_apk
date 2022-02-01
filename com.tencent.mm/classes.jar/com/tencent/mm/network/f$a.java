package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class f$a
  extends Binder
  implements f
{
  public f$a()
  {
    attachInterface(this, "com.tencent.mm.network.IAccInfo_AIDL");
  }
  
  public static f bQI()
  {
    return f.a.a.pnN;
  }
  
  public static f q(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IAccInfo_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof f))) {
      return (f)localIInterface;
    }
    return new f.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.network.IAccInfo_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      reset();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      a(paramParcel1.createByteArray(), paramParcel1.createByteArray(), paramParcel1.createByteArray(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      setUin(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      setUsername(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      aG(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      aH(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = getUsername();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = sA(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = bFZ();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = bGb();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramInt1 = getUin();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = bGa();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      k(paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = LW(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      setForeground(bool);
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = isForeground();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = bGc();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      Rp(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramInt1 = av(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = bGd();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramInt1 = aw(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      i(paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      b(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      aI(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = aJ(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = LX(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = LZ(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      paramParcel1 = LY(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = Ma(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bGe();
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bGf();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
    bool = Rr(paramParcel1.readString());
    paramParcel2.writeNoException();
    paramInt1 = n;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.f.a
 * JD-Core Version:    0.7.0.1
 */