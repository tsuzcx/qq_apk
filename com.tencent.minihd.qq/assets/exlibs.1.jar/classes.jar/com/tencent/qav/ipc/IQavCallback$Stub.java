package com.tencent.qav.ipc;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import ljd;

public abstract class IQavCallback$Stub
  extends Binder
  implements IQavCallback
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.qav.ipc.IQavCallback";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  
  public IQavCallback$Stub()
  {
    attachInterface(this, "com.tencent.qav.ipc.IQavCallback");
  }
  
  public static IQavCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qav.ipc.IQavCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IQavCallback))) {
      return (IQavCallback)localIInterface;
    }
    return new ljd(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.qav.ipc.IQavCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavCallback");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavCallback");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 3: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavCallback");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QavState)QavState.CREATOR.createFromParcel(paramParcel1);
      }
      a((QavState)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavCallback");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QavState)QavState.CREATOR.createFromParcel(paramParcel1);
      }
      b((QavState)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavCallback");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QavState)QavState.CREATOR.createFromParcel(paramParcel1);
      }
      c((QavState)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.qav.ipc.IQavCallback");
    localObject1 = localObject4;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (QavMsgRecord)QavMsgRecord.CREATOR.createFromParcel(paramParcel1);
    }
    a((QavMsgRecord)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.IQavCallback.Stub
 * JD-Core Version:    0.7.0.1
 */