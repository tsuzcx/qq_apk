package com.tencent.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a$a
  extends Binder
  implements a
{
  public static a j(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.BaseService");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.assistant.sdk.BaseService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
      paramInt1 = a(paramParcel1.readString(), paramParcel1.readString(), b.a.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
      paramInt1 = a(b.a.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
      paramParcel1 = c(paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
    d(paramParcel1.readString(), paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */