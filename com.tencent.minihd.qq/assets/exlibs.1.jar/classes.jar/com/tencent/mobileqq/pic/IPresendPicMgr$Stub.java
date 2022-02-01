package com.tencent.mobileqq.pic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import jlt;

public abstract class IPresendPicMgr$Stub
  extends Binder
  implements IPresendPicMgr
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.pic.IPresendPicMgr";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  
  public IPresendPicMgr$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pic.IPresendPicMgr");
  }
  
  public static IPresendPicMgr a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
    if ((localIInterface != null) && ((localIInterface instanceof IPresendPicMgr))) {
      return (IPresendPicMgr)localIInterface;
    }
    return new jlt(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.pic.IPresendPicMgr");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(str1, str2, bool);
        paramParcel2.writeNoException();
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      a();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      b();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
    paramParcel1 = a(paramParcel1.createStringArrayList());
    paramParcel2.writeNoException();
    paramParcel2.writeStringList(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.IPresendPicMgr.Stub
 * JD-Core Version:    0.7.0.1
 */