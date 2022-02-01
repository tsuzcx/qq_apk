package com.huawei.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract interface a
  extends IInterface
{
  public abstract String checkIssueConditions(Map paramMap);
  
  public abstract String checkServiceStatus(Map paramMap);
  
  public abstract String deleteCard(Map paramMap);
  
  public abstract String doAction(String paramString, Map paramMap);
  
  public abstract int ek(String paramString);
  
  public abstract String issueCard(Map paramMap);
  
  public abstract String preIssueCard(Map paramMap);
  
  public abstract String queryCplc();
  
  public abstract String queryTrafficCardInfo(String paramString, int paramInt);
  
  public abstract String recharge(Map paramMap);
  
  public abstract String startSetDefault(Map paramMap);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a akh()
    {
      return a.dXZ;
    }
    
    public static a k(IBinder paramIBinder)
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
        paramInt1 = ek(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = queryCplc();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = preIssueCard(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = issueCard(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = recharge(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = queryTrafficCardInfo(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = deleteCard(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = checkServiceStatus(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = startSetDefault(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
        paramParcel1 = checkIssueConditions(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
      paramParcel1 = doAction(paramParcel1.readString(), paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    
    static final class a
      implements a
    {
      public static a dXZ;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final String checkIssueConditions(Map paramMap)
      {
        AppMethodBeat.i(208323);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().checkIssueConditions(paramMap);
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
          AppMethodBeat.o(208323);
        }
      }
      
      public final String checkServiceStatus(Map paramMap)
      {
        AppMethodBeat.i(208314);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().checkServiceStatus(paramMap);
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
          AppMethodBeat.o(208314);
        }
      }
      
      public final String deleteCard(Map paramMap)
      {
        AppMethodBeat.i(208311);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().deleteCard(paramMap);
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
          AppMethodBeat.o(208311);
        }
      }
      
      public final String doAction(String paramString, Map paramMap)
      {
        AppMethodBeat.i(208326);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeString(paramString);
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramString = a.a.akh().doAction(paramString, paramMap);
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
          AppMethodBeat.o(208326);
        }
      }
      
      public final int ek(String paramString)
      {
        AppMethodBeat.i(208264);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            i = a.a.akh().ek(paramString);
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
          AppMethodBeat.o(208264);
        }
      }
      
      public final String issueCard(Map paramMap)
      {
        AppMethodBeat.i(208290);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().issueCard(paramMap);
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
          AppMethodBeat.o(208290);
        }
      }
      
      public final String preIssueCard(Map paramMap)
      {
        AppMethodBeat.i(208279);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().preIssueCard(paramMap);
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
          AppMethodBeat.o(208279);
        }
      }
      
      public final String queryCplc()
      {
        AppMethodBeat.i(208271);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            str = a.a.akh().queryCplc();
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
          AppMethodBeat.o(208271);
        }
      }
      
      public final String queryTrafficCardInfo(String paramString, int paramInt)
      {
        AppMethodBeat.i(208304);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramString = a.a.akh().queryTrafficCardInfo(paramString, paramInt);
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
          AppMethodBeat.o(208304);
        }
      }
      
      public final String recharge(Map paramMap)
      {
        AppMethodBeat.i(208298);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().recharge(paramMap);
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
          AppMethodBeat.o(208298);
        }
      }
      
      public final String startSetDefault(Map paramMap)
      {
        AppMethodBeat.i(208320);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
          localParcel1.writeMap(paramMap);
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (a.a.akh() != null))
          {
            paramMap = a.a.akh().startSetDefault(paramMap);
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
          AppMethodBeat.o(208320);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.huawei.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */