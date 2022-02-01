package com.b.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract interface a
  extends IInterface
{
  public abstract int Kb(String paramString);
  
  public abstract String LJ();
  
  public abstract String V(String paramString, Map paramMap);
  
  public abstract String cl(Map paramMap);
  
  public abstract String cm(Map paramMap);
  
  public abstract String cn(Map paramMap);
  
  public abstract String co(Map paramMap);
  
  public abstract String cp(Map paramMap);
  
  public abstract String cq(Map paramMap);
  
  public abstract String cr(Map paramMap);
  
  public abstract String hz(String paramString, int paramInt);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a Q(IBinder paramIBinder)
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
        paramInt1 = Kb(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = LJ();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = cl(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = cm(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = cn(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = hz(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = co(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = cp(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = cq(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = cr(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = V(paramParcel1.readString(), paramParcel1.readHashMap(getClass().getClassLoader()));
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
      
      public final int Kb(String paramString)
      {
        AppMethodBeat.i(221258);
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
          AppMethodBeat.o(221258);
        }
      }
      
      public final String LJ()
      {
        AppMethodBeat.i(221259);
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
          AppMethodBeat.o(221259);
        }
      }
      
      public final String V(String paramString, Map paramMap)
      {
        AppMethodBeat.i(221268);
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
          AppMethodBeat.o(221268);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final String cl(Map paramMap)
      {
        AppMethodBeat.i(221260);
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
          AppMethodBeat.o(221260);
        }
      }
      
      public final String cm(Map paramMap)
      {
        AppMethodBeat.i(221261);
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
          AppMethodBeat.o(221261);
        }
      }
      
      public final String cn(Map paramMap)
      {
        AppMethodBeat.i(221262);
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
          AppMethodBeat.o(221262);
        }
      }
      
      public final String co(Map paramMap)
      {
        AppMethodBeat.i(221264);
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
          AppMethodBeat.o(221264);
        }
      }
      
      public final String cp(Map paramMap)
      {
        AppMethodBeat.i(221265);
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
          AppMethodBeat.o(221265);
        }
      }
      
      public final String cq(Map paramMap)
      {
        AppMethodBeat.i(221266);
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
          AppMethodBeat.o(221266);
        }
      }
      
      public final String cr(Map paramMap)
      {
        AppMethodBeat.i(221267);
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
          AppMethodBeat.o(221267);
        }
      }
      
      public final String hz(String paramString, int paramInt)
      {
        AppMethodBeat.i(221263);
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
          AppMethodBeat.o(221263);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */