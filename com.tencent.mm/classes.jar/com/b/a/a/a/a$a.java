package com.b.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract class a$a
  extends Binder
  implements a
{
  public static a h(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramInt1 = cj(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = zM();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = c(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = d(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = e(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = n(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = f(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = g(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = h(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = i(paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
    paramParcel1 = d(paramParcel1.readString(), paramParcel1.readHashMap(getClass().getClassLoader()));
    paramParcel2.writeNoException();
    paramParcel2.writeString(paramParcel1);
    return true;
  }
  
  static final class a
    implements a
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final String c(Map paramMap)
    {
      AppMethodBeat.i(221907);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221907);
      }
    }
    
    public final int cj(String paramString)
    {
      AppMethodBeat.i(221905);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeString(paramString);
        this.mRemote.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221905);
      }
    }
    
    public final String d(String paramString, Map paramMap)
    {
      AppMethodBeat.i(221915);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeString(paramString);
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(11, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramString = localParcel2.readString();
        return paramString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221915);
      }
    }
    
    public final String d(Map paramMap)
    {
      AppMethodBeat.i(221908);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(4, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221908);
      }
    }
    
    public final String e(Map paramMap)
    {
      AppMethodBeat.i(221909);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221909);
      }
    }
    
    public final String f(Map paramMap)
    {
      AppMethodBeat.i(221911);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(7, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221911);
      }
    }
    
    public final String g(Map paramMap)
    {
      AppMethodBeat.i(221912);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(8, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221912);
      }
    }
    
    public final String h(Map paramMap)
    {
      AppMethodBeat.i(221913);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(9, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221913);
      }
    }
    
    public final String i(Map paramMap)
    {
      AppMethodBeat.i(221914);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeMap(paramMap);
        this.mRemote.transact(10, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramMap = localParcel2.readString();
        return paramMap;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221914);
      }
    }
    
    public final String n(String paramString, int paramInt)
    {
      AppMethodBeat.i(221910);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        this.mRemote.transact(6, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramString = localParcel2.readString();
        return paramString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221910);
      }
    }
    
    public final String zM()
    {
      AppMethodBeat.i(221906);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(221906);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.b.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */