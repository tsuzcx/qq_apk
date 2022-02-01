package com.tencent.mm.network.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class b$a
  extends Binder
  implements b
{
  public b$a()
  {
    attachInterface(this, "com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      int i = paramParcel1.readInt();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramInt1, paramInt2, str1, i, str2, bool);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
    u(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.a.b.a
 * JD-Core Version:    0.7.0.1
 */