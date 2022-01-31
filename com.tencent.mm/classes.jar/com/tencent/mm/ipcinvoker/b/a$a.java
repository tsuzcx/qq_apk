package com.tencent.mm.ipcinvoker.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
  }
  
  public static a k(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
      String str;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        str = paramParcel1.readString();
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          break label117;
        }
        paramParcel1 = (Parcel)localObject;
      }
      for (;;)
      {
        a(paramParcel2, str, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        label117:
        localObject = paramParcel1.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
        if ((localObject != null) && ((localObject instanceof b))) {
          paramParcel1 = (b)localObject;
        } else {
          paramParcel1 = new b.a.a(paramParcel1);
        }
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
    if (paramParcel1.readInt() != 0)
    {
      localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      paramParcel1 = f((Bundle)localObject, paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 == null) {
        break label226;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      return true;
      localObject = null;
      break;
      label226:
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.a.a
 * JD-Core Version:    0.7.0.1
 */