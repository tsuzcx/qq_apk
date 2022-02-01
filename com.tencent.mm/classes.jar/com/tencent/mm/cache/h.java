package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface h
  extends IInterface
{
  public abstract MCacheItem CV(String paramString);
  
  public abstract void CW(String paramString);
  
  public abstract void b(String paramString, Bitmap paramBitmap);
  
  public abstract Bitmap getBitmap(String paramString);
  
  public static abstract class a
    extends Binder
    implements h
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.cache.IMMCache_AIDL");
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
        paramParcel2.writeString("com.tencent.mm.cache.IMMCache_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
        CV(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(0);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          MCacheItem.CREATOR.createFromParcel(paramParcel1);
        }
        CW(str);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
        paramParcel1 = getBitmap(paramParcel1.readString());
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
      }
      paramParcel1.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        b(str, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.h
 * JD-Core Version:    0.7.0.1
 */