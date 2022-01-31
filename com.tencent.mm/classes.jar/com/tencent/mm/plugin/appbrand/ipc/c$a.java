package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class c$a
  extends Binder
  implements c
{
  public c$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
  }
  
  public static c q(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new c.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      B(paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      C((Bundle)localObject1);
      paramParcel2.writeNoException();
      if (localObject1 != null)
      {
        paramParcel2.writeInt(1);
        ((Bundle)localObject1).writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
    a(paramParcel1.readStrongBinder(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.c.a
 * JD-Core Version:    0.7.0.1
 */