package com.huawei.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract interface a
  extends IInterface
{
  public abstract String IC();
  
  public abstract int cw(String paramString);
  
  public abstract String d(String paramString, Map paramMap);
  
  public abstract String e(Map paramMap);
  
  public abstract String f(Map paramMap);
  
  public abstract String g(Map paramMap);
  
  public abstract String h(Map paramMap);
  
  public abstract String i(Map paramMap);
  
  public abstract String j(Map paramMap);
  
  public abstract String k(Map paramMap);
  
  public abstract String n(String paramString, int paramInt);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a ID()
    {
      return a.cfP;
    }
    
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
        paramInt1 = cw(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = IC();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = e(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = f(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = g(paramParcel1.readHashMap(getClass().getClassLoader()));
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
        paramParcel1 = h(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = i(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = j(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = k(paramParcel1.readHashMap(getClass().getClassLoader()));
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
      public static a cfP;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final String IC()
      {
        AppMethodBeat.i(226024);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            str = a.a.ID().IC();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226024);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int cw(String paramString)
      {
        AppMethodBeat.i(226023);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            i = a.a.ID().cw(paramString);
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226023);
        }
      }
      
      public final String d(String paramString, Map paramMap)
      {
        AppMethodBeat.i(226033);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeString(paramString);
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramString = a.a.ID().d(paramString, paramMap);
            return paramString;
          }
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226033);
        }
      }
      
      public final String e(Map paramMap)
      {
        AppMethodBeat.i(226025);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().e(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226025);
        }
      }
      
      public final String f(Map paramMap)
      {
        AppMethodBeat.i(226026);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().f(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226026);
        }
      }
      
      public final String g(Map paramMap)
      {
        AppMethodBeat.i(226027);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().g(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226027);
        }
      }
      
      public final String h(Map paramMap)
      {
        AppMethodBeat.i(226029);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().h(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226029);
        }
      }
      
      public final String i(Map paramMap)
      {
        AppMethodBeat.i(226030);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().i(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226030);
        }
      }
      
      public final String j(Map paramMap)
      {
        AppMethodBeat.i(226031);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().j(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226031);
        }
      }
      
      public final String k(Map paramMap)
      {
        AppMethodBeat.i(226032);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramMap = a.a.ID().k(paramMap);
            return paramMap;
          }
          localParcel2.readException();
          paramMap = localParcel2.readString();
          return paramMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226032);
        }
      }
      
      public final String n(String paramString, int paramInt)
      {
        AppMethodBeat.i(226028);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (a.a.ID() != null))
          {
            paramString = a.a.ID().n(paramString, paramInt);
            return paramString;
          }
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(226028);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.huawei.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */