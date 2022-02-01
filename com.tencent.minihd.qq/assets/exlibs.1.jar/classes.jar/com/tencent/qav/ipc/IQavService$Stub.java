package com.tencent.qav.ipc;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import lje;

public abstract class IQavService$Stub
  extends Binder
  implements IQavService
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.qav.ipc.IQavService";
  static final int b = 2;
  static final int c = 3;
  
  public IQavService$Stub()
  {
    attachInterface(this, "com.tencent.qav.ipc.IQavService");
  }
  
  public static IQavService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qav.ipc.IQavService");
    if ((localIInterface != null) && ((localIInterface instanceof IQavService))) {
      return (IQavService)localIInterface;
    }
    return new lje(paramIBinder);
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
      paramParcel2.writeString("com.tencent.qav.ipc.IQavService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavService");
      a(IQavCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavService");
      a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavService");
    String str = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(str, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.IQavService.Stub
 * JD-Core Version:    0.7.0.1
 */