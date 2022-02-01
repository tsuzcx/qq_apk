package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class o$a
  extends Binder
  implements o
{
  public o$a()
  {
    attachInterface(this, "com.tencent.mm.network.IOnReportKV_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.network.IOnReportKV_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.IOnReportKV_AIDL");
    long l = paramParcel1.readLong();
    String str = paramParcel1.readString();
    boolean bool1;
    if (paramParcel1.readInt() != 0)
    {
      bool1 = true;
      if (paramParcel1.readInt() == 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool2 = true;; bool2 = false)
    {
      reportKV(l, str, bool1, bool2);
      paramParcel2.writeNoException();
      return true;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.o.a
 * JD-Core Version:    0.7.0.1
 */