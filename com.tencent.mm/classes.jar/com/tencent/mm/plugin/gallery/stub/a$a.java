package com.tencent.mm.plugin.gallery.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
  }
  
  public static a A(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
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
    int i = 0;
    boolean bool1;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      aK(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      bEm();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      paramInt1 = MY();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label236;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        a(str1, str2, bool1, paramInt1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      paramInt1 = MW();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      paramInt1 = MV();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 7: 
      label236:
      paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = hT(bool1);
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
    paramInt1 = PD(paramParcel1.readString());
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.stub.a.a
 * JD-Core Version:    0.7.0.1
 */